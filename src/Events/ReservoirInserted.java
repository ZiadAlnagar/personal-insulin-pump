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
public class ReservoirInserted {
    private double capacity;

    public ReservoirInserted(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }
}
