package com.orderingSystem.base;

public class Constants {


    public static enum UserType {
        ADMIN('0', "管理员"), NPO('1', "公证员"), PERSONAL('2', "个人用户"), ENTERPRISE('3', "企业用户");

        private char value;
        private String comment;

        private UserType(char value, String comment) {
            this.comment = comment;
            this.value = value;
        }

        public String getComment() {
            return comment;
        }

        public char getValue() {
            return value;
        }


        public static UserType get(char type) {
            for (UserType userType : UserType.values()) {
                if (userType.getValue() == type) {
                    return userType;
                }
            }
            return null;
        }
    }



    public static final String SORT_DESC = "DESC";
    public static final String SORT_ASC = "ASC";


    public static final String SQL_CREATE_TIME = "CREATE_TIME";
    public static final String SQL_UPDATE_TIME = "UPDATE_TIME";
    public static final String SQL_SUBMIT_TIME = "SUBMIT_TIME";


}
