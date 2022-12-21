package Model;

import Esper.Config;
import View.AIPS_GUI;

import java.awt.*;


public class Controller {

    // System Current State: Normal / OFF / Suspended / Emergency
    private SystemState state;

    // Blood Sugar Measurements
    private double currReading;
    private double prevReading;
    private double rateOfChange;

    // Safe Zone Boundaries & Emergency Reading Limit
    private final double safeZoneMin;
    private final double safeZoneMax;
    private final double emergencyLimit; //new

    // Dose Safety Constraints
    private double accumlativeDoses;
    private double maxDosesPerDay;
    private double maxDoseLimit;

    // Time to start a Periodic Test
    private int periodicTestTime;

    // Hardware Devices Objects
    private final InsulinPumper insulinPumper;
    private final BloodSugarSensor sugarSensor;
    private final InsulinReservoirSensor reservoirSensor;
    private final Battery battery;
    private final Switch switchh;
    private final Clock clock;
    private final Display_1 display1;
    private final Display_2 display2;
    // GUI
    private final AIPS_GUI gui;

    // Constructors //
    public Controller() {
        this.gui = new AIPS_GUI();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);

        this.state = SystemState.OFF;
        this.currReading = 0.0;
        this.prevReading = 0.0;
        this.rateOfChange = 0.0;
        this.safeZoneMin = 80;
        this.safeZoneMax = 130;
        this.accumlativeDoses = 0.0;
        this.maxDosesPerDay = 100;
        this.maxDoseLimit = 10;
        this.periodicTestTime = 10 * 60;
        this.emergencyLimit = 200;

        // Intililzation of hardware devices
        this.insulinPumper = new InsulinPumper(this);
//        insulinPumper.setBroken(true);
        this.sugarSensor = new BloodSugarSensor(this);
        sugarSensor.setBroken(true);
        this.reservoirSensor = new InsulinReservoirSensor(this, 100, true);

        this.battery = new Battery(this, 100, 15, true);
        this.switchh = new Switch(this, false);
        this.clock = new Clock(this);

        // Displays
        this.display1 = Display_1.getInstance();
        this.display1.setController(this);
        this.display2 = new Display_2(this, currReading, 0);
    }

    // Setters & Getters //
    public SystemState getState() {
        return state;
    }

    public Switch getSwitchh() {
        return switchh;
    }

    public AIPS_GUI getGui() {
        return gui;
    }

    public InsulinPumper getInsulinPumper() {
        return insulinPumper;
    }

    public BloodSugarSensor getSugarSensor() {
        return sugarSensor;
    }

    public Display_1 getDisplay1() {
        return display1;
    }

    public Clock getClock() {
        return clock;
    }

    public int getPeriodicTestTime() {
        return periodicTestTime;
    }

    public Battery getBattery() {
        return this.battery;
    }

    public InsulinReservoirSensor getReservoirSensor() {
        return reservoirSensor;
    }

    // Methods //
    public void changeState(SystemState state) {
        if (this.state == SystemState.OFF && state != SystemState.OFF) {
            clock.start();
            battery.start();
            display2.start();
            System.out.println("threads starts..");
        }

        // If State was Emergency and changed
        if (this.state == SystemState.EMERGENCY && state != SystemState.EMERGENCY) {
            this.periodicTestTime *= 2;
            this.maxDoseLimit /= 1.5;
            this.maxDosesPerDay *= 1.25;
        } // If State was not Emergency and changed          
        else if (this.state != SystemState.EMERGENCY && state == SystemState.EMERGENCY) {
            this.periodicTestTime /= 2;
            this.maxDoseLimit *= 1.5;
            this.maxDosesPerDay *= 1.25;
        } // If State was Suspended and changed
        else if (this.state == SystemState.SUSPENDED && state != SystemState.SUSPENDED && state != SystemState.OFF) {
            if (isEmergency(currReading)) {
                state = SystemState.EMERGENCY;
            } else {
                state = SystemState.NORMAL;
            }
        }

        this.state = state;
        if (state == SystemState.OFF) {
            switchh.powerOff();
            System.out.println("Poweroff");
        } else {
            switchh.powerOn();
            System.out.println("poweron");
        }

        System.out.println("State Changed to " + this.state);
        switch (this.state) {
            case OFF:
                gui.getStateLabel().setText("OFF");
                gui.getStateLabel().setBackground(Color.gray);
                break;
            case NORMAL:
                gui.getStateLabel().setText("NORMAL");
                gui.getStateLabel().setBackground(Color.green);
                break;
            case SUSPENDED:
                gui.getStateLabel().setText("SUSPENDED");
                gui.getStateLabel().setBackground(Color.orange);
                break;
            case EMERGENCY:
                gui.getStateLabel().setText("EMERGENCY");
                gui.getStateLabel().setBackground(Color.red);
                break;
            default:
                break;
        }
    }

    public void resetSystem() {
        changeState(SystemState.NORMAL);
        this.currReading = 0.0;
        this.prevReading = 0.0;
        this.rateOfChange = 0.0;
        this.accumlativeDoses = 0.0;
        System.out.println("System is Reset...");
    }

    public void selfTest() {
        if (state == SystemState.OFF) {
            System.out.println("\nSystem is OFF...");
            return;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("\nStarting Selt Test...");
                Config.sendEvent(new Events.Display1Update("SELF_TEST_START"));

                // Check Blood Sugar Sensor Hardware
                boolean sugarSensor_hasIssue = sugarSensor.checkHardware();

                // Check Insulin Reservoir Sensor Hardware
                boolean reservoirSensor_hasIssue = reservoirSensor.checkHardware();

                // Check Insulin Pumper Hardware
                boolean insulinPumper_hasIssue = insulinPumper.checkHardware();

                // Check Battery Level
                boolean battery_hasIssue = battery.isBatteryLow();

                // Suspend System if any issue
                if (sugarSensor_hasIssue || reservoirSensor_hasIssue || insulinPumper_hasIssue || battery_hasIssue) {
                    if (sugarSensor_hasIssue) {
                        System.out.println("Error in Blood Sugar Sensor");
                        Config.sendEvent(new Events.Display1Update("Error in Blood Sugar Sensor"));
                    }
                    if (reservoirSensor_hasIssue) {
                        System.out.println("Error in Insulin Reservoir Sensor");
                        Config.sendEvent(new Events.Display1Update("Error in Insulin Reservoir Sensor"));
                    }
                    if (insulinPumper_hasIssue) {
                        System.out.println("Error in Insulin Pumper");
                        Config.sendEvent(new Events.Display1Update("Error in Insulin Pumper"));
                    }
                    if (battery_hasIssue) {
                        System.out.println("Battery is Low!");
                        Config.sendEvent(new Events.Display1Update("Battery is Low!"));
                    }

                    changeState(SystemState.SUSPENDED);
                } else {
                    System.out.println("Self Test: No Errors!\n");
                    if (state == SystemState.SUSPENDED) {
                        changeState(SystemState.NORMAL);
                    }
                }
            }
        }).start();
        System.out.println();

    }

    public void periodicSugarTest() {
        if (state == SystemState.OFF) {
            System.out.println("\nSystem is OFF...");
            return;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                // Run the Periodic Test in a separate Thread
                System.out.println("Periodic Test Thread Started...");
                Config.sendEvent(new Events.Display1Update("Periodic Test Started..."));
//        display1.addToBuffer("Periodic Test Started...");

                // Check System is not in Suspended State
                if (state == SystemState.SUSPENDED) {
                    System.out.println("Periodic Test Failed! System is Suspended");
//            Config.sendEvent(new Events.Display1Update("Periodic Test Failed! System is Suspended"));
                    display1.addToBuffer("Periodic Test Failed! System is Suspended");
                    return;
                }

                // Get Sugar Reading from Sensor
                currReading = sugarSensor.CaptureSugarLevel();
                System.out.println("Blood Sugar Current Reading: " + currReading);
                display2.setLastSugerReading(currReading);

                // Check if Reading in Emergency
                if (currReading > emergencyLimit) {
                    changeState(SystemState.EMERGENCY);
                    System.out.println("System in Emergency !!");
//            Config.sendEvent(new Events.Display1Update("System in Emergency !!"));
                    display1.addToBuffer("System in Emergency !!");
                }

                // Check if Reading within Safe Zone
                int safeZoneState = inSafeZone();
                // -1: Below Safe Zone
                //  0: within Safe Zone
                //  1: Above Safe Zone

                // Check if Sugar Level is Increasing
                boolean sugarIncreasing = isSugarIncreasing();

                // Check if Rate of Change is Increasing
                boolean rateIncreasing = isRateIncreasing();

                // Check Cases when Dose is needed
                boolean needInsulin;

                // Case 1 //
                // Reading in Safe Zone &
                // Sugar Level Increasing & Rate of Change Increasing
                if (safeZoneState == 0 && sugarIncreasing && rateIncreasing) {
                    needInsulin = true;
                } // Case 2 //
                // Reading above Safe Zone &
                // One of Sugar Level or Rate of Change is Increasing
                else if (safeZoneState == 1 && (sugarIncreasing || rateIncreasing)) {
                    needInsulin = true;
                } // Otherwise, no Insulin needed
                else {
                    needInsulin = false;
                }

                // If Patient needs insulin, Compute and Pump the Dose
                if (needInsulin) {
                    double dose = computeDose();
                    System.out.println("Insulin Needed with Dose = " + dose);

                    // Pump the Insulin Dose
                    insulinPumper.pumpInsulin(dose);

                    System.out.println("Insulin Dose Pumped");
                    Config.sendEvent(new Events.Display1Update("Insulin Dose Pumped"));
                    display2.setLastInsulinDose(dose);

                } else {
                    System.out.println("No Insulin Dose Needed");
                    Config.sendEvent(new Events.Display1Update("No Insulin Dose Needed"));
                }

                // Reset Reading Variables for the next Test call
                setRateOfChange();
                resetReadings();
                System.out.println("Periodic Test Ended...");
            }
        }).start();

    }

    public boolean isEmergency(double reading) {
        return state == SystemState.EMERGENCY;
    }

    public void setRateOfChange() {
        rateOfChange = currReading - prevReading;
    }

    public void resetReadings() {
        prevReading = currReading;
        currReading = 0;
    }

    public int inSafeZone() {
        if (currReading > safeZoneMax) {
            return 1;
        } else if (currReading < safeZoneMin) {
            return -1;
        } else {
            return 0;
        }
    }

    public boolean isSugarIncreasing() {
        double rate = (currReading - prevReading);

        return rate >= 0;
    }

    public boolean isRateIncreasing() {
        double rate = (currReading - prevReading) - rateOfChange;

        return rate >= 0;
    }

    public double computeDose() {
        double dose;

        dose = (currReading - prevReading) / 4;

        if (checkDoseLimit(dose)) {
            if (checkAccumlativeDoseLimit(accumlativeDoses + dose)) {
                accumlativeDoses = accumlativeDoses + dose;
                return dose;
            } else {
                // to compute the last allowed dose from the max accumaltive dose limit
                dose = (accumlativeDoses + dose) - maxDosesPerDay;
                return dose;
            }
        } else {

            // to compute the last allowed dose from the max dose limit in the single injection
            dose = dose - maxDoseLimit;

            if (checkAccumlativeDoseLimit(accumlativeDoses + dose)) {
                // then to check it doenst reach the max accumlative
                accumlativeDoses = accumlativeDoses + dose;
                return dose;

            } else {
                // to compute the last allowed dose from the max accumaltive dose limit
                dose = (accumlativeDoses + dose) - maxDosesPerDay;
            }
            return dose;
        }
    }

    public boolean checkDoseLimit(double dose) {
        return dose < maxDoseLimit;
    }

    public boolean checkAccumlativeDoseLimit(double Accdose) {
        return Accdose < maxDosesPerDay;
    }

}
