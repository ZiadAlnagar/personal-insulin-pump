/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Events;

/**
 *
 * @author Yousef Hussien
 */
public class ChargeBattery {

    private boolean charged;

    public ChargeBattery(boolean charged) {
        this.charged = charged;
    }

    public boolean isCharged() {
        return charged;
    }

    public void setCharged(boolean charged) {
        this.charged = charged;
    }

}
