package model;

import java.util.HashMap;

/**
 *  Row class represents a typical row in a database.
 *
 * @author ravi.bhatt
 * @version Row: Row.java, v 1.0 09/07/21 5:10 pm ravi.bhatt Exp $$
 */
public class Row {
    /*  This represents the primary key of the table : immutable*/
    private String rowId;

    /*  This has column name and column value as a key value pair : directly can't be set from outside
    *   But its content can be updated from service class */
    private final HashMap<String , String> columnValuesMap;

    /*  This is the row creation time : immutable*/
    private String createdDate;

    /* This is the row modified time : mutable*/
    private String modifiedDate;

    /**
     *  Constructor to create the row with mandatory parameters.
     * @param rowId
     * @param columnValuesMap
     * @param createdDate
     * @param modifiedDate
     */
    public Row(String rowId, HashMap<String, String> columnValuesMap, String createdDate, String modifiedDate) {
        this.rowId = rowId;
        this.columnValuesMap = columnValuesMap;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    /**
     *  This method sets modifiedDate in case of update operation
     * @param modifiedDate
     */
    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     *
     * @param columnName
     * @param columnValue
     */
    public void update(String columnName , String columnValue){
        if(columnValuesMap!=null && !columnValuesMap.isEmpty())
            columnValuesMap.put(columnName,columnValue);
    }

    public String getRowId() {
        return rowId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public HashMap<String, String> getColumnValuesMap() {
        return columnValuesMap;
    }
}
