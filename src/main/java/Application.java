import model.DatabaseManager;
import service.DatabaseQueryService;
import service.impl.DatabaseQueryServiceImpl;

import java.util.Scanner;

/**
 * @author ravi.bhatt
 * @version Application: Application.java, v 1.0 09/07/21 5:08 pm ravi.bhatt Exp $$
 */
public class Application {
    public static void main(String[] args) {
        DatabaseQueryService queryService = DatabaseQueryServiceImpl.getInstance();
        Scanner scn = new Scanner(System.in);

        while(scn.hasNext()) {
            String str = scn.nextLine();
            queryService.runQuery(str);
        }

    }
}
