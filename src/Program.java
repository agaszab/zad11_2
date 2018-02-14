import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        File file = new File("cities.txt");
        String city="";
        WeatherApi api = new WeatherApi();


        try (Scanner scan=new Scanner(file);) {

            while(scan.hasNextLine()) {

                city = scan.nextLine();
                try {

                    int temperature = api.getTemperature(city);
                    String description = api.getDescription(city);
                    System.out.printf("Pogoda w mieście %s: %s\n", city, description);
                    System.out.printf("Aktualna temperatura: %d stopni\n", temperature);
                } catch (IOException e) {
                    System.err.println("Nie udało się pobrać informacji dla miasta " + city);
                }


            }

        } catch (FileNotFoundException e) {
                System.out.println ("Plik cities.txt nie istnieje.");
            }


     //   System.out.println(text);
        }

    }



