package util;

public enum EntityType {
    DATABASE("database"),
    TABLE("table");

    private String name;

    EntityType(String name){
        this.name = name;
    }
}
