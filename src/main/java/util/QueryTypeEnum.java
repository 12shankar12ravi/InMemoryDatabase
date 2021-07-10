package util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ravi.bhatt
 * @version QueryTypeEnum: QueryTypeEnum.java, v 1.0 10/07/21 8:41 am ravi.bhatt Exp $$
 */
public enum QueryTypeEnum {
    SELECT("select"),
    INSERT("insert"),
    DELETE("delete"),
    DROP("drop"),
    CREATE("create"),
    UPDATE("update"),
    USE("use"),
    SHOW("show");

    private String value;

    QueryTypeEnum(String value){
        this.value = value;
    }

    private static final Set<String> values = Arrays.stream(QueryTypeEnum.values()).map(e->e.value).collect(Collectors.toSet());

    public static boolean contains(String str) {
        return values.contains(str);
    }

    public String getValue() {
        return value;
    }
}
