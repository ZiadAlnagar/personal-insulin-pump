package Model;

import Esper.Config;
import Events.BatteryEvent;
import Events.SelfTest;
//import Events.SelfTest;
//import java.io.IOException;
//import java.nio.CharBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Battery extends Thread implements Display {

    private final Controller controller;

    private double batteryLevel;
    private double warningLevel;
    private boolean powerState;

    public Battery(Controller c, double batteryLevel, double warningLevel, boolean powerState) {
        this.controller = c;
        this.batteryLevel = batteryLevel;
        this.warningLevel = warningLevel;
        this.powerState = powerState;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public double getWarningLevel() {
        return warningLevel;
    }

    public void setWarningLevel(double warningLevel) {
        this.warningLevel = warningLevel;
    }

    public boolean isBatteryLow() {

        return batteryLevel < warningLevel;
    }

    public void setPowerState(boolean powerstate) {
        this.powerState = powerstate;
    }

    public boolean getPowerState() {
        return powerState;
    }

    public void decreaseBatterylevel() {
        if (!powerState) {
            return;
        }

        batteryLevel = batteryLevel - 1;
        if (batteryLevel < 0.0) {
            batteryLevel = 0.0;
            powerState = false;
        }
    }

    public void chargeBatteryLevel(double charged) {
        batteryLevel += charged;
        if (batteryLevel > 100) {
            batteryLevel = 100;
        }
    }

    @Override
    public void display(String s) {
        if (powerState == true) {
            System.out.println("The battery is %" + getBatteryLevel());
            controller.getGui().getBattery().setText("% " + batteryLevel);
        } else {
            System.out.println("The battery is off");
            controller.getGui().getBattery().setText(" --- ");
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Battery.sleep(3000);
                Config.sendEvent(new BatteryEvent(batteryLevel));
                if (controller.getSwitchh().isPower()) {
                    decreaseBatterylevel();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Battery.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
