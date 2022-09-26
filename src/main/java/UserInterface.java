import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);


    public void start() {
        welcome();
    }

    public void welcome() {
        System.out.println("Velkommen til KEA!");
        direction();
    }

    public void direction() {
        String direction = scan.nextLine();

        switch (direction) {
            case "Nord":
                System.out.println("Going North");
                break;
            case "South":
                System.out.println("Going south");
                break;
            case "East":
                System.out.println("Going east");
                break;
            case "West":
                System.out.println("Going west");
                break;
            default:
                System.out.println("Error");
                break;
        }

    }
}