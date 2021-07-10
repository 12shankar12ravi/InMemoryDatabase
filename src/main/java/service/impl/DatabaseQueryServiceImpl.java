package service.impl;

import model.Database;
import model.DatabaseManager;
import service.DatabaseQueryService;
import util.EntityType;
import util.QueryTypeEnum;
import util.StringUtility;

import static util.Constants.SPACE;

/**
 *
 * "create table tableName";
 * "select * from tableName"
 * "drop table tableName"
 * "insert into tableName (f,f,f,f)"
 * @author ravi.bhatt
 * @version DatabaseQueryServiceImpl: DatabaseQueryServiceImpl.java, v 1.0 09/07/21 5:11 pm ravi.bhatt Exp $$
 */
public class DatabaseQueryServiceImpl implements DatabaseQueryService {

    private DatabaseManager databaseManager = DatabaseManager.getInstance();

    private static DatabaseQueryServiceImpl databaseQueryService;

    private DatabaseQueryServiceImpl(){

    }

    public static DatabaseQueryService getInstance(){
        if(databaseQueryService == null) {
            synchronized (DatabaseManager.class) {
                if (databaseQueryService == null) {
                    databaseQueryService = new DatabaseQueryServiceImpl();
                }
                return databaseQueryService;
            }
        }
        return databaseQueryService;
    }

    public void runQuery(String query) {
        String[] queryParams = query.split(SPACE);
        if (checkForQueryValidity(queryParams)) {
            String selectedDbName = databaseManager.getSelectedDbName();
            switch (QueryTypeEnum.valueOf(queryParams[0].toUpperCase())) {
                case USE:
                    useDatabase(queryParams[1]);
                    break;
                case CREATE:
                    createEntity(queryParams[1], queryParams[2], selectedDbName);
                    break;
                case SHOW:
                    showEntity(queryParams[1], selectedDbName);
                    break;
                case DROP:
                    break;
                case INSERT:
                    break;
                case DELETE:
                    break;
                case SELECT:
                    break;
                default:
                    break;
            }
        }
    }

    private boolean checkForQueryValidity(String[] queryParams) {
        return StringUtility.isNotBlank(queryParams[0]) && QueryTypeEnum.contains(queryParams[0]);
    }

    /**
     *
     * @param entityType entityType It can be database or table
     * @param entityValue
     * @param dbName
     * @return
     */
    private void createEntity(String entityType, String entityValue, String dbName){
        if(StringUtility.isNotBlank(entityType)) {
            if (StringUtility.isNotBlank(entityValue)) {
                if (EntityType.valueOf(entityType.toUpperCase()) == EntityType.DATABASE) {
                    databaseManager.createDatabase(entityValue);
                } else {
                    if (dbName!=null) {
                        databaseManager.getDatabase(dbName).createTable(entityValue);
                    }else{
                        System.out.println("ERROR : Database not selected before running the query");
                    }
                }
            }else{
                System.out.println("Invalid query missing table/database name");
            }
        }else{
            System.out.println("Invalid query missing table/database keyword");
        }
    }

    /**
     *  It will print the entities with particular entityType
     * @param entityType it can be database or table
     */
    private void showEntity(String entityType, String dbName){
        if(StringUtility.isNotBlank(entityType)) {
            if (EntityType.valueOf(entityType.toUpperCase()) == EntityType.DATABASE) {
                databaseManager.getAllDatabaseNames().forEach(System.out::println);
            } else if(EntityType.valueOf(entityType.toUpperCase()) == EntityType.TABLE && databaseManager.getDatabase(dbName)!=null){
                databaseManager.getDatabase(dbName).getAllTableNames().forEach(System.out::println);
            }else{
                System.out.println("Invalid query type : you can either show databases / tables");
            }
        }else {
            System.out.println("Invalid query missing table/database keyword");
        }
    }

    private void useDatabase(String dbName){
        if(StringUtility.isNotBlank(dbName)) {
            Database database = databaseManager.getDatabase(dbName);
            if(database==null) {
                System.out.println("Database does not exist");
            }else{
                databaseManager.setSelectedDbName(dbName);
                System.out.println("Database "+dbName+" selected successfully");
            }
        }else{
            System.out.println("Invalid query missing table/database keyword");
        }
    }
}
