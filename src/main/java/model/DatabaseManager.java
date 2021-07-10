package model;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author ravi.bhatt
 * @version DatabaseManager: DatabaseManager.java, v 1.0 09/07/21 5:10 pm ravi.bhatt Exp $$
 */
public class DatabaseManager {
    private HashMap<String, Database> databaseHashMap;

    private String selectedDbName ;

    private static DatabaseManager databaseManager;

    private DatabaseManager(){
        this.databaseHashMap =  new HashMap<>();
    }

    //making database manager singleton
    public static DatabaseManager getInstance(){
        if(databaseManager == null) {
            synchronized (DatabaseManager.class) {
                if (databaseManager == null) {
                    databaseManager = new DatabaseManager();
                }
                return databaseManager;
            }
        }
        return databaseManager;
    }

    public Database createDatabase(String databaseName) {
        if (databaseHashMap.containsKey(databaseName)) {
            System.out.println("A database already exists with this name");
        } else {
            databaseHashMap.put(databaseName, new Database(databaseName));
            System.out.println("Database created successfully");
        }
        return databaseHashMap.get(databaseName);
    }

    public String getSelectedDbName() {
        return selectedDbName;
    }

    public void setSelectedDbName(String selectedDbName) {
        this.selectedDbName = selectedDbName;
    }

    public void deleteDatabase(String databaseName) {
        databaseHashMap.remove(databaseName);
    }

    public Database getDatabase(String databaseName){
        if(databaseHashMap.containsKey(databaseName)){
            return databaseHashMap.get(databaseName);
        }else{
            System.out.println("Database does not exist");
            return null;
        }
    }

    public Set<String> getAllDatabaseNames(){
        return databaseHashMap.keySet();
    }


}
