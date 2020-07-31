import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        FileData pierwszy = new FileData();


        for(;;)
        {
            System.out.println("======= MENU ========");
            System.out.println("1. Wpisz dane");
            System.out.println("2. Wyjdz");

            Scanner scan = new Scanner(System.in);
            int option = scan.nextInt();


            switch (option)
            {
                case 1:
                    System.out.println("\nUzupelnij formularz:\n");
                    pierwszy.saveData();
                    break;
                case 2:
                    System.exit(0);
                default:
                    System.out.println("\nOpcja nie istnieje. Prosze sprobowac ponownie.");
            }
        }

    }
}
