package de.niklasmaul;

import de.niklasmaul.view.HumidityView;
import de.niklasmaul.view.TemperatureView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Weatherstation weatherstation = new Weatherstation(10, 30);

        HumidityView humidityView = new HumidityView(weatherstation);
        TemperatureView temperatureView = new TemperatureView(weatherstation);

        weatherstation.subscribe(humidityView);
        weatherstation.subscribe(temperatureView);


        while (true) {
            try {
                Thread.sleep(5000);

                int randomTemp = (int) (Math.random() * 3); // 0.00–3.00
                int vorzeichenTemp = Math.random() < 0.5 ? -1 : 1; // zufällig -1 oder +1
                int deltaTemp = randomTemp * vorzeichenTemp;

                int newTemp = weatherstation.getTemperature() + deltaTemp;

                int randomHum = (int) (Math.random() * 5); // 0.00–3.00
                int vorzeichenHum = Math.random() < 0.5 ? -1 : 1; // zufällig -1 oder +1
                int deltaTHum = randomHum * vorzeichenHum;

                int newHum = weatherstation.getHumidity() + deltaTHum;

                System.out.println("\n---- NEUE MESSWERTE ----");
                weatherstation.setTemperature(newTemp);
                weatherstation.setHumidity(newHum); // kann auch in -% oder über 100% werden, aber egal hier
            }catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
