package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Set;

/**
 * @author ravi.bhatt
 * @version Database: Database.java, v 1.0 09/07/21 5:09 pm ravi.bhatt Exp $$
 */
public class Database {
    private String name;
    private HashMap<String,Table> tableMap;
    private String createdAt;

    public Database(String name) {
        this.name = name;
        this.tableMap = new HashMap<>();
        this.createdAt = LocalDate.now().toString();
    }

    public void createTable(String tableName){
        if(tableMap.containsKey(tableName)){
            System.out.println("Can't create a table , A table already exists with the given name");
        }else{
            Table table = new Table(tableName,LocalDate.now().toString(),LocalDate.now().toString());
            tableMap.put(tableName,table);
            System.out.println("Table successfully created");
        }
    }

    public void dropTable(String tableName){
        if(tableMap.containsKey(tableName)){
            tableMap.remove(tableName);
        }else{
            System.out.println("Table does not exist");
        }
    }

    public Set<String> getAllTableNames(){
        return tableMap.keySet();
    }

}
