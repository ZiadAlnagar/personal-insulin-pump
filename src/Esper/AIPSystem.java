package Esper;

import Model.*;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Yousef Hussien
 */
public class AIPSystem {

    public static void main(String[] args) {

        // Disable logging
        Logger.getRootLogger().setLevel(Level.OFF);

        // Register events
        Config.registerEvents();

        // Controller Initialization
        final Controller controller = new Controller();

        // Creating Events Statements
        Config.createStatement("select powerState from SwitchhEvent")
                .setSubscriber(new Object() {
                    public void update(boolean powerState) throws InterruptedException {
                        System.out.println("SwitchhEvent Event Triggered: " + powerState);
                        if (powerState) {
                            controller.changeState(SystemState.NORMAL);
                        } else {
                            controller.changeState(SystemState.OFF);
                        }
                    }
                });

        Config.createStatement("select charged from ChargeBattery")
                .setSubscriber(new Object() {
                    public void update(boolean charged) {
                        System.out.println("Chraged Battery Event Triggered");
                        controller.getBattery().chargeBatteryLevel(25);
                    }
                });

        Config.createStatement("select timeOut from SelfTest")
                .setSubscriber(new Object() {
                    public void update(boolean timeOut) {
                        System.out.println("Self Test Event Triggered");
                        controller.selfTest();
                    }
                });

        Config.createStatement("select timeOut from PeriodicTest")
                .setSubscriber(new Object() {
                    public void update(boolean timeOut) {
                        System.out.println("Periodic Test Event Triggered");
                        controller.periodicSugarTest();
                    }
                });

        Config.createStatement("select fwdSecs from TimeForward")
                .setSubscriber(new Object() {
                    public void update(int fwdSecs) {
                        System.out.println("Time" + fwdSecs + "s Forward Event Triggered");
                        controller.getClock().forwardTime(fwdSecs);
                    }
                });

        Config.createStatement("select capacity from ReservoirInserted")
                .setSubscriber(new Object() {
                    public void update(double capacity) {
                        System.out.println("Reservoir Inserted Event Triggered");
                        controller.resetSystem();
                        System.out.println(capacity);
                    }
                });

        Config.createStatement("select code from Display1Update")
                .setSubscriber(new Object() {
                    public void update(String code) throws InterruptedException {
                        System.out.println("Display_1 Event Triggered");
                        System.out.println(code);
                        Display_1 ds_1 = Display_1.getInstance();
                        ds_1.run();
                        ds_1.addToBuffer(code);
                    }
                });

        Config.createStatement("select batteryLevel from BatteryEvent")
                .setSubscriber(new Object() {
                    public void update(double batteryLevel) {
                        System.out.println("Battery Event Triggered");
                        controller.getBattery().display("");
                    }
                });

        Config.createStatement("select timeInSeconds from TimeEvents")
                .setSubscriber(new Object() {
                    public void update(int timeInSeconds) throws InterruptedException {
                        System.out.println("Time Event Triggered");
                        controller.getClock().display("");
                    }
                });

//        Config.createStatement("select SugarSensorIssue from HardwareIssue")
//                .setSubscriber(new Object() {
//                    public void update(boolean SugarSensorIssue) throws InterruptedException {
//                        System.out.println("HardwareIssue Event Triggered");
//                        controller.getSugarSensor().setBroken(SugarSensorIssue);
//                    }
//                });
//        Config.createStatement("select ReservoirIssue from HardwareIssue")
//                .setSubscriber(new Object() {
//                    public void update(boolean ReservoirIssue) throws InterruptedException {
//                        System.out.println("HardwareIssue Event Triggered");
//                        controller.getReservoirSensor().setBroken(ReservoirIssue);
//                    }
//                });
//        Config.createStatement("select PumperIssue from HardwareIssue")
//                .setSubscriber(new Object() {
//                    public void update(boolean ReservoirIssue) throws InterruptedException {
//                        System.out.println("HardwareIssue Event Triggered");
//                        controller.getInsulinPumper().setBroken(ReservoirIssue);
//                    }
//                });
    }
}
