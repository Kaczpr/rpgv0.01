import java.util.Scanner;

public class game {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void pressEnterKeyToContinue()
    {
        System.out.println("Press Enter key to continue...");
        Scanner s = new Scanner(System.in);
        s.nextLine();
    }
    static void kill(enemy a){
        a = null;
    }

    }
