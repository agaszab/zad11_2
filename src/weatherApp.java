import java.util.ArrayList;

public class weatherApp {

    public static void main(String[] args) {

        ArrayList<WeatherInfo> lista = new ArrayList<>();
        WeatherOutIn outin = new WeatherOutIn();

        outin.zapisDoListy(lista);
        outin.zapisZListyDoPliku(lista);

    }

}



