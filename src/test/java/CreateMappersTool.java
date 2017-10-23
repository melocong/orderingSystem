import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CreateMappersTool {


    public static void usage() {
        StringBuffer usage = new StringBuffer(200);
        usage.append("************************************************************");
        usage.append("\n 根据数据库表自动生成对应的pojo，dao，service，mappers");
        usage.append("\n 使用参数举例如下：");
        usage.append("\n 该模块的包名，例如com.mass.test");
        usage.append("\n 数据库表名，例如Test");
        usage.append("\n 不需要生成的文件，例如service，可设置为service");
        usage.append("\n************************************************************");
        System.out.println(usage);
    }

    private final static String BASE = System.getProperty("user.dir");
    private final static String JAVA = BASE + "/src/main/java/";
    private final static String MAPPERS = BASE + "/src/main/resources/mappers/";
    /**
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        if (args.length == 0) {
            usage();
            return;
        }
        String packageName = args[0];
        String dir = packageName.replaceAll("\\.", "/");

        String tableName = args[1];

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://182.254.217.209:3306/X?useUnicode=true&characterEncoding=UTF-8", "tomato", "tomatoegg");
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet rs = metaData.getColumns(null, null,
                tableName, null);

        ArrayList<FieldColumn> fieldColumns = new ArrayList<FieldColumn>();
        while (rs.next()) {
            String columnName = rs.getString("COLUMN_NAME");
            FieldColumn fieldColumn = new FieldColumn();
            String propName = rs.getString("REMARKS");
            Integer columnLength = rs.getInt("COLUMN_SIZE");
            String columnType = rs.getString("TYPE_NAME");
            String isNullable = rs.getString("IS_NULLABLE");
            fieldColumn.setColumnName(columnName);
            fieldColumn.setJavaProperty(fieldToProperty(columnName));
            if (columnName.endsWith("ID")) {
                fieldColumn.setJdbcType("String");
            } else {
                fieldColumn.setJdbcType(getJdbcType(columnType));
            }
            fieldColumn.setPropName(propName);
            fieldColumn.setColumnLength(columnLength);
            fieldColumn.setColumnType(getColumnType(columnType));
            fieldColumn.setRequired(!"YES".equals(isNullable));
            fieldColumns.add(fieldColumn);
        }
        if (fieldColumns.isEmpty()) {
            System.out.println("can not find table");
            System.exit(1);
        }
        String ignore = null;
        if (args.length == 3) {
            ignore = args[2];
        }

        String pojoNameLow = fieldToProperty(tableName);
        populateMappers(tableName, packageName, fieldColumns, MAPPERS + pojoNameLow + "Mappers.xml");
        String pojoName = fieldToGsProperty(tableName);
        if (ignore == null || !ignore.contains("pojo")) {
            populatePojo(tableName, fieldColumns, packageName, JAVA + dir + "\\pojo\\" + pojoName + ".java");
        }
        if (ignore == null || !ignore.contains("param")) {
            populateParam(tableName, packageName, JAVA + dir + "\\param\\" + pojoName + "QueryParam.java");
        }
        if (ignore == null || !ignore.contains("dao")) {
            populateDao(tableName, packageName, JAVA + dir + "\\dao\\" + pojoName + "Dao.java");
        }
        if (ignore == null || !ignore.contains("service")) {
            populateService(tableName, packageName, JAVA + dir + "\\service\\" + pojoName + "Service.java");
        }

        connection.close();
        System.exit(0);
    }

    private static void populatePojo(String tableName, ArrayList<FieldColumn> fieldColumns, String packageName, String fileName) throws IOException {
        String str = readFile(1);
        str = str.replaceAll("\\$\\{package\\}", packageName);
        str = str.replaceAll("\\$\\{pojo\\}", fieldToGsProperty(tableName));
        String property = "";
        for (FieldColumn fieldColumn : fieldColumns) {
            property += "//"+fieldColumn.getPropName()+"\nprivate " + fieldColumn.getJdbcType() + " " + fieldColumn.getJavaProperty() + ";\n";
        }
        str = str.replaceAll("\\$\\{property\\}", property);
        writeFile(fileName,str);
    }

    private static void populateParam(String tableName, String packageName, String fileName) throws IOException {
        String str = readFile(2);
        str = str.replaceAll("\\$\\{package\\}", packageName);
        str = str.replaceAll("\\$\\{pojo\\}", fieldToGsProperty(tableName));
        writeFile(fileName,str);
    }

    private static void populateDao(String tableName, String packageName, String fileName) throws IOException {
        String str = readFile(3);
        str = str.replaceAll("\\$\\{package\\}", packageName);
        str = str.replaceAll("\\$\\{pojo\\}", fieldToGsProperty(tableName));
        str = str.replaceAll("\\$\\{pojoLow\\}", fieldToProperty(tableName));
        writeFile(fileName,str);
    }

    private static void populateService(String tableName, String packageName, String fileName) throws IOException {
        String str = readFile(4);
        str = str.replaceAll("\\$\\{package\\}", packageName);
        str = str.replaceAll("\\$\\{pojo\\}", fieldToGsProperty(tableName));
        str = str.replaceAll("\\$\\{pojoLow\\}", fieldToProperty(tableName));
        writeFile(fileName,str);
    }

    private static void populateMappers(String tableName, String packageName, ArrayList<FieldColumn> fieldColumns, String fileName) throws IOException {
        String str = readFile(0);
        String result = "";
        String values = "";
        String column = "";
        String columnTable = "";
        String set = "";
        int size = fieldColumns.size();
        int i = 0;
        for (FieldColumn fieldColumn : fieldColumns) {
            i++;
            String columnName = fieldColumn.getColumnName();
            String javaProperty = fieldColumn.getJavaProperty();
            if ("ID".equalsIgnoreCase(columnName)) {
                result += "<id property=\"";
            } else {
                result += "<result property=\"";
                values += ("#{" + javaProperty + ",jdbcType=" + fieldColumn.getColumnType() + "}");
                column += ("`" + columnName + "`");
                columnTable += (tableName + ".`" + columnName + "`");
                set += ("`" + columnName + "` = #{" + javaProperty + "}");
                if (size != i) {
                    set += (",\n");
                    values += (",\n");
                    column += (",\n");
                    columnTable += (",\n");
                }
            }
            result += fieldColumn.getJavaProperty() + "\"" + " column=\"" + columnName + "\"" + " javaType=\"" + fieldColumn.getJdbcType() + "\" jdbcType=\"" + fieldColumn.getColumnType() + "\"/>\n";
        }
        String tableNameJava = fieldToGsProperty(tableName);
        str = str.replaceAll("\\$\\{package\\}", packageName);
        str = str.replaceAll("\\$\\{pojo\\}", tableNameJava);
        str = str.replaceAll("\\$\\{table\\}", tableName);
        str = str.replaceAll("\\$\\{result\\}", result);
        str = str.replaceAll("\\$\\{values\\}", values);
        str = str.replaceAll("\\$\\{updateColumn\\}", set);
        str = str.replaceAll("\\$\\{tc\\}", column);
        str = str.replaceAll("\\$\\{tci\\}", columnTable);
        writeFile(fileName,str);
    }


    private static void writeFile(String fileName,String content) throws IOException {
        File file = new File(fileName);
        file.getParentFile().mkdirs();
        FileWriter writer = new FileWriter(file, false);
        writer.write(content);
        writer.flush();
        writer.close();

    }

    /**
     * @param type 0:mappers.xml
     * @return
     */
    private static String readFile(int type) throws IOException {
        String fileName = null;
        switch (type) {
            case 0: {
                fileName = BASE + "/src/test/resources/mapper/mappers.xml";
                break;
            }
            case 1: {
                fileName = BASE + "/src/test/resources/mapper/pojo";
                break;
            }
            case 2: {
                fileName = BASE + "/src/test/resources/mapper/param";
                break;
            }
            case 3: {
                fileName = BASE + "/src/test/resources/mapper/dao";
                break;
            }
            case 4: {
                fileName = BASE + "/src/test/resources/mapper/service";
                break;
            }
        }
        if (fileName == null) {
            return null;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), Charset.forName("UTF-8")));
        StringBuilder builder = new StringBuilder();
        String s;
        while ((s = reader.readLine()) != null) {
            builder.append(s).append("\n");
        }
        return builder.toString();
    }

    /**
     * 将数据库字段转换为java属性，如user_name-->userName
     *
     * @param field 字段名
     * @return
     */
    private static String fieldToProperty(String field) {
        if (null == field) {
            return "";
        }
        char[] chars = field.toLowerCase().toCharArray();
        StringBuffer property = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '_') {
                int j = i + 1;
                if (j < chars.length) {
                    property.append(String.valueOf(chars[j]).toUpperCase());
                    i++;
                }
            } else {
                property.append(c);
            }
        }
        return property.toString();
    }

    /**
     * 将数据库字段转换为java属性，如user_name-->UserName
     *
     * @param field 字段名
     * @return
     */
    public static String fieldToGsProperty(String field) {
        if (null == field) {
            return "";
        }
        char[] chars = field.toLowerCase().toCharArray();
        StringBuffer property = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '_') {
                int j = i + 1;
                if (j < chars.length) {
                    property.append(String.valueOf(chars[j]).toUpperCase());
                    i++;
                }
            } else {
                if (i == 0) {
                    property.append(String.valueOf(chars[i]).toUpperCase());
                } else {
                    property.append(c);
                }
            }
        }
        return property.toString();
    }

    public static final Map<String, String> typeMap;
    public static final Map<String, String> typeMap1;

    public static String getJdbcType(String columnType) {
        return typeMap.get(columnType);
    }

    public static String getColumnType(String columnType) {
        String s = typeMap1.get(columnType);
        return s == null ? columnType : s;
    }

    static {
        typeMap = new HashMap<String, String>();
        typeMap1 = new HashMap<String, String>();
        typeMap.put("VARCHAR", "String");
        typeMap.put("MEDIUMTEXT", "String");
        typeMap.put("CHAR", "Character");
        typeMap.put("SMALLINT", "Integer");
        typeMap.put("INT", "Integer");
        typeMap.put("INT UNSIGNED", "Integer");
        typeMap.put("TEXT", "String");
        typeMap.put("BIGINT", "Long");
        typeMap.put("BOOLEAN", "Boolean");
        typeMap.put("BIT", "Boolean");
        typeMap1.put("INT", "BIGINT");
        typeMap1.put("MEDIUMTEXT", "VARCHAR");
        typeMap1.put("TEXT", "VARCHAR");
        typeMap1.put("BOOLEAN", "TINYINT");
    }

    @Setter
    @Getter
    static class FieldColumn {
        /**
         * 字段名
         */
        private String columnName;

        /**
         * 字段长度
         */
        private Integer columnLength;

        /**
         * 类属性
         */
        private String javaProperty;
        /**
         * 类属性名
         */
        private String propName;

        /**
         * 数据库类型
         */
        private String columnType;

        /**
         * java类型
         */
        private String jdbcType;

        /**
         * 是否必填
         */
        private Boolean required;

    }
}
