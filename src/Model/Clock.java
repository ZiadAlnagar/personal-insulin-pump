package Model;

import Esper.Config;
import Events.*;
import org.apache.log4j.Logger;

public class Clock extends Thread implements Display {

    private final Controller controller;
    private int seconds;

    public Clock(Controller controller) {
        this.controller = controller;
        this.seconds = 0;
    }

    public int getCurrentTime() {
        return seconds;
    }
    
    public void forwardTime(int sec) {
        seconds += sec;
    }
    
    @Override
    public void display(String s) {
        int sec = seconds % 60;
        int min = (seconds / 60) % 60;
        int hours = (seconds / 60) / 60;

        String strSec = (sec < 10) ? "0" + Integer.toString(sec) : Integer.toString(sec);
        String strmin = (min < 10) ? "0" + Integer.toString(min) : Integer.toString(min);
        String strHours = (hours < 10) ? "0" + Integer.toString(hours) : Integer.toString(hours);

        System.out.println("Time: " + strHours + ":" + strmin + ":" + strSec);
        if (controller.getSwitchh().isPower())
            controller.getGui().getClock().setText("" + strHours + ":" + strmin + ":" + strSec);
        else
            controller.getGui().getClock().setText("--:--:--");
    }

    @Override
    public void run() {
        while (true) { // while the switch of the controller is on
            try {
                System.out.println("Current System State >> "+controller.getState());
                Config.sendEvent(new Events.TimeEvents(seconds));
                Clock.sleep(1000);
                seconds += 1;
                
                int selfTestTime = 30;
                if (seconds % selfTestTime == 0) {
                    System.out.println();
                    Config.sendEvent(new SelfTest());
                }

                int periodicTestTime = controller.getPeriodicTestTime();
//                periodicTestTime = 10 * 60;
                if (seconds % periodicTestTime == 0) {
                    System.out.println();
                    Config.sendEvent(new PeriodicTest());
                }
                
                int day = 24 * 60 * 60;
                if (seconds % day == 0)
                    seconds = 0;

            } catch (InterruptedException ex) {
                Logger.getLogger(Switch.class.getName()).log(null, ex);

            }
        }
    }
}
