import java.util.Scanner;

public class UserInput
{
    public String[] resident = new String[4];
    private PeselVal psl = new PeselVal();


    public String askForData()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj miasto: ");
        resident[0] = scanner.nextLine();

        System.out.println("Podaj imie: ");
        resident[1] = scanner.nextLine();

        System.out.println("Podaj nazwisko: ");
        resident[2] = scanner.nextLine();

        for(;;)
        {
            System.out.println("Podaj PESEL");
            resident[3] = scanner.nextLine();

            if(psl.PeselValidation(resident[3])==false)
                System.out.println("Błędny numer PESEL. Proszę spróbować ponownie");
            else
                break;
        }
        return resident[0] + " " + resident[1] + " " + resident[2] + " " + resident[3] + "\n";
    }

}
