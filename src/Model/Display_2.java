package Model;

import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 *
 * @author yousef
 */
public class Display_2 extends Thread implements Display {

    private final Controller controller;

    private double LastSugerReading;
    private double LastInsulinDose;

    public Display_2(Controller c, double LastSugerReading, double LastInsulinDose) {
        this.controller = c;
        this.LastSugerReading = LastSugerReading;
        this.LastInsulinDose = LastInsulinDose;
    }

    public double getLastSugerReading() {
        return LastSugerReading;
    }

    public double getLastInsulinDose() {
        return LastInsulinDose;
    }

    public void setLastSugerReading(double LastSugerReading) {
        this.LastSugerReading = LastSugerReading;
    }

    public void setLastInsulinDose(double LastInsulinDose) {
        this.LastInsulinDose = LastInsulinDose;
    }

    @Override
    public void display(String s) {
//        System.out.print("Last Reading: " + LastSugerReading + " - Last Dose: " + LastInsulinDose);
        controller.getGui().getDisplay2().setText("Last Reading: " + LastSugerReading + " - Last Dose: " + LastInsulinDose);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                display("");
            } catch (InterruptedException ex) {
                Logger.getLogger(Switch.class.getName()).log(null, (Supplier<String>) ex);
            }
        }
    }
}
