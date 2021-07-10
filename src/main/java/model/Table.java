package model;

import java.util.HashMap;

/**
 * This class is typically a representation of Table in database
 *
 * @author ravi.bhatt
 * @version Table: Table.java, v 1.0 09/07/21 5:09 pm ravi.bhatt Exp $$
 */
public class Table {
    private String name ;
    /** This is a map of rowId and Row **/
    private HashMap<String,Row> rows;
    private String createdDate;
    private String modifiedDate;

    public Table(String name,String createdDate, String modifiedDate) {
        this.name = name;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    /**
     * Insert row
     * @param rowId
     * @param row
     */
    public void insertRow(String rowId , Row row){
        if(rows.containsKey(rowId)){
            System.out.println("Primary key constraint : A row already exist with this rowId");
        }else {
            rows.put(rowId, row);
        }
    }

    /**
     *  Delete row
     * @param rowId
     */
    public void deleteRow(String rowId){
        if(rows.containsKey(rowId)){
            rows.remove(rowId);
        }else{
            System.out.println("Row does not exist with the rowId = "+rowId);
        }
    }

    /**
     * Read the row by rowId
     * @param rowId
     * @return
     */
    public HashMap<String,String> readRow(String rowId){
        return rows.get(rowId).getColumnValuesMap();
    }

    /**
     * Given a Row object with parameters that needs to be set as non-null values
     * @param columnsMap
     * @param rowId
     */
    public void updateRow(HashMap<String, String> columnsMap, String rowId){
        final Row currRow = rows.get(rowId);
        if(currRow!=null){
            columnsMap.forEach(currRow::update);
        }else{
            System.out.println("Can't Update , Row with the given row id does not exist");
        }
    }
}
