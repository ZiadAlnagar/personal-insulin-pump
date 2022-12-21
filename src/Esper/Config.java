/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Esper;

import Events.*;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

/**
 *
 * @author Yousef Hussien
 */
public class Config {
    
    private static EPServiceProvider engine = EPServiceProviderManager.getDefaultProvider();

    public static void registerEvents() {      
        // On/OFF Switch and System State
        engine.getEPAdministrator().getConfiguration().addEventType(SwitchhEvent.class);
//        engine.getEPAdministrator().getConfiguration().addEventType(StateEvent.class);
        
        // Self and Periodic Tests
        engine.getEPAdministrator().getConfiguration().addEventType(SelfTest.class);
        engine.getEPAdministrator().getConfiguration().addEventType(PeriodicTest.class);
        engine.getEPAdministrator().getConfiguration().addEventType(TimeForward.class);
        
        // Displays
        engine.getEPAdministrator().getConfiguration().addEventType(TimeEvents.class);
        engine.getEPAdministrator().getConfiguration().addEventType(BatteryEvent.class);
        engine.getEPAdministrator().getConfiguration().addEventType(ChargeBattery.class);
        engine.getEPAdministrator().getConfiguration().addEventType(Display1Update.class);
        
        // Hardware Devices Tests
        engine.getEPAdministrator().getConfiguration().addEventType(ReservoirInserted.class);
        engine.getEPAdministrator().getConfiguration().addEventType(HardwareIssue.class);
        
        System.out.println("Events Successfully Registered.");
    }

    public static EPStatement createStatement(String s) {
        EPStatement result = engine.getEPAdministrator().createEPL(s);
        System.out.println("EPL Statement Successfully Created.");
        return result;
    }
    
    public static void sendEvent(Object o)
    {
        engine.getEPRuntime().sendEvent(o);
    }
}
