import java.util.Scanner;

import app.salesianos.resource.Menu;

public class App {
    static final Scanner KEYBOARD = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
    boolean exist = true;
    String option= "";

    Menu menu = new Menu();
    while (exist) {
        option= menu.getMenu();
        switch (option) {
            case "1":
                
                break;
        
            default:
                break;
        }
    }
    }
}
