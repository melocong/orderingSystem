package com.orderingSystem.param;


import com.orderingSystem.base.Constants;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SqlQueryParam {

    public static final int LOCK_FOR_UPDATE = 0;
    public static final int LOCK_IN_SHARE_MODE = 1;

    protected int pageNo = -1;
    protected int pageSize = 10;
    protected String column;
    protected String sort = Constants.SORT_DESC;
    protected int limit = -1;
    protected boolean lock;
    protected int lockMode; // 0:排它锁 FOR UPDATE 1：共享锁 LOCK IN SHARE MODE


    public int getStartIndex() {
        int i = getPageNo() - 1;
        if (i < 0) {
            return 0;
        }
        return i * getPageSize();
    }

    public int getPageSize() {
        return pageSize >= 100 ? 100 : pageSize;
    }

    public int getPageNo() {
        if (pageNo <= 0) {
            return 1;
        }
        return pageNo;
    }


    public String getColumn() {
        if (column != null) {
            if (column.contains("'")) {
                return null;
            }
            return column;
        }
        return null;
    }

    public String getSort() {
        if (Constants.SORT_DESC.equalsIgnoreCase(sort)) {
            return Constants.SORT_DESC;
        }
        if (Constants.SORT_ASC.equalsIgnoreCase(sort)) {
            return Constants.SORT_ASC;
        }
        return null;
    }
}
