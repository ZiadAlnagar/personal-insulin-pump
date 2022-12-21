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
public class HardwareIssue {

    private boolean SugarSensorIssue;
    private boolean ReservoirIssue;
    private boolean PumperIssue;

    public HardwareIssue(boolean hardware, int n) {
        if (n == 1) {
            this.SugarSensorIssue = hardware;
        } else if (n == 2) {
            this.ReservoirIssue = hardware;
        } else {
            this.PumperIssue = hardware;
        }
    }

    public boolean isSugarSensorIssue() {
        return SugarSensorIssue;
    }

    public void setSugarSensorIssue(boolean SugarSensorIssue) {
        this.SugarSensorIssue = SugarSensorIssue;
    }

    public boolean isReservoirIssue() {
        return ReservoirIssue;
    }

    public void setReservoirIssue(boolean ReservoirIssue) {
        this.ReservoirIssue = ReservoirIssue;
    }

    public boolean isPumperIssue() {
        return PumperIssue;
    }

    public void setPumperIssue(boolean PumperIssue) {
        this.PumperIssue = PumperIssue;
    }

}
