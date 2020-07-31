import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


public class FileData
{

    private File inputFile = new File(getNameOfFile());
    private File tempFile = new File("temp.txt");
    private UserInput data = new UserInput();
    private static final String DATE_FORMAT_NOW = "yyyy_MM_dd_HH_mm_ss";


    public String getDate()
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);

        return sdf.format(cal.getTime());
    }

    public String getNameOfFile()
    {
        return "mieszkancy_" + getDate() + ".txt";
    }

    public void saveData() throws IOException
    {
        FileWriter pw = new FileWriter(inputFile,true);


        pw.write(data.askForData());
        pw.close();

        checkDuplicate(data.resident[0], data.resident[1], data.resident[2], data.resident[3]);
    }

    public void checkDuplicate(String city, String name, String surname, String pesel) throws IOException
    {
        Scanner read = new Scanner(inputFile);
        FileWriter temp = new FileWriter(tempFile,true);
        String[] array = new String[countLines()];
        int i=0;

        while(read.hasNextLine())
        {
            String line = read.nextLine();
            array[i] = line;

            String[] splitting = array[i].split(" ");


            if(splitting[3].equals(pesel))
            {
                i += 1;
            }
            else
            {
                temp.write(line + "\n");
                i += 1;
            }
        }
        temp.write(city + " ");
        temp.write(name + " ");
        temp.write(surname + " ");
        temp.write(pesel + "\n");

        temp.close();
        read.close();

        inputFile.delete();
        tempFile.renameTo(inputFile);
    }

    public int countLines() throws IOException
    {
        Scanner read = new Scanner(inputFile);
        int count = 0;

        while (read.hasNextLine())
        {
            count++;
            read.nextLine();
        }
        read.close();

        return count;
    }
}
