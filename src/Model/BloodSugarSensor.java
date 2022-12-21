package Model;

//import esper.config;
//import events.BloodSugarReading;
//import events.StateEvent;
import Esper.Config;
import Events.SelfTest;
import java.util.Random;
import java.util.logging.Logger;
import java.util.logging.Level;

public class BloodSugarSensor extends Thread {
      private final Controller controller;

    private double sugarLvl;
    private boolean broken;

    public BloodSugarSensor(Controller c) {
         this.controller = c;
        this.sugarLvl = 0;
        this.broken = false;
    }

    public void setBroken(boolean broken) {
        this.broken = broken;
    }

    public boolean checkHardware() {
        if (broken == false) {
            return broken;
        } else {
            return true;
        }
    }

    public double CaptureSugarLevel() {
        sugarLvl = controller.getGui().getjSlider1().getValue();
        return sugarLvl;
    }

}
