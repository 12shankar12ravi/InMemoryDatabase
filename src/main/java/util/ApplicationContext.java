package util;

import java.util.HashMap;

/**
 * @author ravi.bhatt
 * @version applicationContext: ApplicationContext.java, v 1.0 10/07/21 12:52 pm ravi.bhatt Exp $$
 */
public class ApplicationContext {

    private static HashMap<String,Object> beanRegistry = new HashMap<>();

    public static Object getBean(String beanName){
        return beanRegistry.get(beanName);
    }

    public static void registerBean(Object object){
        beanRegistry.put(object.getClass().getName(),object);
    }
}
