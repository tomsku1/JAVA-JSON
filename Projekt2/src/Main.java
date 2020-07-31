import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main
{
    private static HttpURLConnection connection;


    public static void main(String[] args)
    {
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        try {
            URL url = new URL("https://api.exchangeratesapi.io/latest");
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int status = connection.getResponseCode();

            if (status > 299)
            {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = reader.readLine()) !=null)
                {
                    responseContent.append(line);
                }
                reader.close();
            }
            else
            {
                reader = new BufferedReader((new InputStreamReader(connection.getInputStream())));
                while((line = reader.readLine()) !=null)
                {
                    responseContent.append(line);
                }
                reader.close();
            }

            parse(responseContent.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            connection.disconnect();
        }
    }

    public static String parse(String responseBody)
    {
        JSONObject currencies = new JSONObject(responseBody);
        JSONObject currency = currencies.getJSONObject("rates");
        String date = currencies.getString("date");
        JSONArray keys = currency.names();
        Scanner scanner = new Scanner(System.in);

        System.out.println("============== Codzienny kurs EURO  ===============");
        System.out.println("Prosze podac kod waluty");
        String option = scanner.nextLine().toUpperCase();

        for (int i=0; i < keys.length(); i++)
        {
            String key = keys.getString(i);
            if(option.equals(key.toString()))
            {
                float value = currency.getFloat(key);
                System.out.println("Kurs na dzien: " + date + " wynosi " + value);
                break;
            }
        }
        return null;
    }
}
