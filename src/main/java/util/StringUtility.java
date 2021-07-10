package util;

/**
 * @author ravi.bhatt
 * @version StringUtility: StringUtility.java, v 1.0 10/07/21 8:45 am ravi.bhatt Exp $$
 */
public class StringUtility {
    public static boolean isNotNull(String str){
        return str!=null;
    }

    public static boolean isNotBlank(String str){
        return str!=null && str.length()!=0 && !str.trim().equals("");
    }

    public static boolean isBlank(String str){
        return str!=null && str.trim().equals("");
    }
}
