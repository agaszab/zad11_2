import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WeatherOutIn {

    // zapisywanie danych pogodowych z pliku cities.txt do listy

    public void zapisDoListy(ArrayList<WeatherInfo> lista) {
        File file = new File("cities.txt");
        String city = "";
        try (Scanner scan = new Scanner(file);) {
            while (scan.hasNextLine()) {
                city = scan.nextLine();
                try {
                    WeatherApi api = new WeatherApi();
                    int temperature = api.getTemperature(city);
                    String description = api.getDescription(city);
                    System.out.printf("Pogoda w mieście %s: %s\n", city, description);
                    System.out.printf("Aktualna temperatura: %d stopni\n", temperature);
                    WeatherInfo weatInf = new WeatherInfo(city, description, temperature);
                    lista.add(weatInf);
                } catch (IOException e) {
                    System.err.println("Nie udało się pobrać informacji dla miasta " + city);
                }

            }

        } catch (FileNotFoundException e) {
            System.out.println("Plik cities.txt nie istnieje.");
        }
    }

        // zapisywanie danych pogodowych z listy do pliku cities.csv

        public void zapisZListyDoPliku (ArrayList<WeatherInfo> lista) {
            try (FileWriter fileCvs = new FileWriter("cities.cvs");
                 BufferedWriter bf = new BufferedWriter(fileCvs);) {

                for (int i = 0; i < lista.size(); i++) {
                    String text = lista.get(i).getCity() + "; " + lista.get(i).getTemperature() + "; " + lista.get(i).getDescription();
                    bf.write(text);
                    bf.newLine();
                }
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();

            }


        }






}








/*  zapis obiektów do pliku -> serializacja

        try (FileOutputStream fos = new FileOutputStream ("cities.cvs");
             ObjectOutputStream oos = new ObjectOutputStream (fos);) {

            for (int i = 0; i < lista.size(); i++) {

                oos.writeObject(lista.get(i));

            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
*/