/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import org.apache.log4j.Logger;

public class Switch extends Thread {

    private final Controller controller;
    private boolean power;

    public Switch(Controller c, boolean power) {
        this.controller = c;
        this.power = power;
    }

    public Controller getCont() {
        return controller;
    }

    public void powerOn() {
        power = true;
    }

    public void powerOff() {
        power = false;
    }

    public boolean isPower() {
        return power;
    }

    @Override
    public void run() {
        while (true) { // while the switch of the controller is on
            try {
                Switch.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Switch.class.getName()).log(null, ex);
            }
        }
    }
}
