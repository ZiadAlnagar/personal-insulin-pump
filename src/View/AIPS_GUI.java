/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Esper.Config;
import Events.*;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 *
 * @author Yousef Hussien
 */
public class AIPS_GUI extends javax.swing.JFrame {

    /**
     * Creates new form AIPS_GUI
     */
    public AIPS_GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        clock = new javax.swing.JTextField();
        battery = new javax.swing.JTextField();
        display1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        sugarSensorBtn = new javax.swing.JButton();
        pumperBtn = new javax.swing.JButton();
        reservoirBtn = new javax.swing.JButton();
        insertReservoirBtn = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        display2 = new javax.swing.JTextField();
        f5m = new javax.swing.JButton();
        f30s = new javax.swing.JButton();
        stateLabel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        onBtn = new javax.swing.JButton();
        offBtn = new javax.swing.JButton();
        f10m = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        chargeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        clock.setEditable(false);
        clock.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clock.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        clock.setText("00:00:00");
        clock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clockActionPerformed(evt);
            }
        });

        battery.setEditable(false);
        battery.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        battery.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        battery.setText("100%");
        battery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batteryActionPerformed(evt);
            }
        });

        display1.setEditable(false);
        display1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        display1.setText("---");
        display1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                display1ActionPerformed(evt);
            }
        });

        sugarSensorBtn.setText("Suger Sensor");
        sugarSensorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sugarSensorBtnActionPerformed(evt);
            }
        });

        pumperBtn.setText("Pumper");
        pumperBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pumperBtnActionPerformed(evt);
            }
        });

        reservoirBtn.setText("Reservour");
        reservoirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservoirBtnActionPerformed(evt);
            }
        });

        insertReservoirBtn.setText("Insert Reservour");
        insertReservoirBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertReservoirBtnActionPerformed(evt);
            }
        });

        jSlider1.setMaximum(250);
        jSlider1.setMinimum(50);
        jSlider1.setToolTipText("");
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jLabel5.setText("Suger level");

        jLabel6.setText("50 | | | | 80 | | | | | | | 130 | | | | | | | | | | | | | | | | | | | | 250");

        display2.setEditable(false);
        display2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        display2.setText("---");

        f5m.setText(">> 5 m");
        f5m.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        f5m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f5mActionPerformed(evt);
            }
        });

        f30s.setText(">> 30 s");
        f30s.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        f30s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f30sActionPerformed(evt);
            }
        });

        stateLabel.setEditable(false);
        stateLabel.setBackground(new java.awt.Color(153, 153, 153));
        stateLabel.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        stateLabel.setText("OFF");
        stateLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateLabelActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("AIPS - Automated Insulin Pump System");

        onBtn.setText("ON");
        onBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        onBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBtnActionPerformed(evt);
            }
        });

        offBtn.setText("OFF");
        offBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offBtnActionPerformed(evt);
            }
        });

        f10m.setText(">> 10 m");
        f10m.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        f10m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f10mActionPerformed(evt);
            }
        });

        jLabel7.setText("Change Hardware Status:");

        chargeBtn.setText("Add Battery Charge");
        chargeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chargeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(onBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(offBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(stateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(battery))
                            .addComponent(display1)
                            .addComponent(display2))
                        .addGap(92, 92, 92))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jSeparator1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pumperBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reservoirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(f30s, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(f5m, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f10m))
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sugarSensorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insertReservoirBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(93, 93, 93)))
                .addGap(69, 69, 69))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(chargeBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(battery, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(display2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(display1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(onBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(offBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f30s)
                    .addComponent(f5m)
                    .addComponent(f10m))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pumperBtn)
                    .addComponent(reservoirBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertReservoirBtn)
                    .addComponent(sugarSensorBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chargeBtn)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clockActionPerformed

    private void batteryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batteryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_batteryActionPerformed

    private void display1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_display1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_display1ActionPerformed

    private void reservoirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservoirBtnActionPerformed
        Config.sendEvent(new HardwareIssue(true, 2));
    }//GEN-LAST:event_reservoirBtnActionPerformed

    private void insertReservoirBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertReservoirBtnActionPerformed
        Config.sendEvent(new ReservoirInserted(100));
    }//GEN-LAST:event_insertReservoirBtnActionPerformed

    private void sugarSensorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sugarSensorBtnActionPerformed
        Config.sendEvent(new HardwareIssue(true, 1));
    }//GEN-LAST:event_sugarSensorBtnActionPerformed

    private void pumperBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pumperBtnActionPerformed
        Config.sendEvent(new HardwareIssue(true, 3));
    }//GEN-LAST:event_pumperBtnActionPerformed

    private void stateLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stateLabelActionPerformed

    private void offBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offBtnActionPerformed
        Config.sendEvent(new SwitchhEvent(false));
    }//GEN-LAST:event_offBtnActionPerformed

    private void onBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onBtnActionPerformed
        Config.sendEvent(new SwitchhEvent(true));
    }//GEN-LAST:event_onBtnActionPerformed

    private void f30sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f30sActionPerformed
        Config.sendEvent(new TimeForward(30 - 5));
    }//GEN-LAST:event_f30sActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        System.out.println("" + jSlider1.getValue());
    }//GEN-LAST:event_jSlider1StateChanged

    private void f5mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f5mActionPerformed
        Config.sendEvent(new TimeForward((5 * 60) - 5));
    }//GEN-LAST:event_f5mActionPerformed

    private void f10mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f10mActionPerformed
        Config.sendEvent(new TimeForward((10 * 60) - 5));
    }//GEN-LAST:event_f10mActionPerformed

    private void chargeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chargeBtnActionPerformed
        Config.sendEvent(new ChargeBattery(true));
    }//GEN-LAST:event_chargeBtnActionPerformed

    public JTextField getDisplay1() {
        return display1;
    }

    public JTextField getBattery() {
        return battery;
    }

    public JTextField getClock() {
        return clock;
    }

    public JTextField getStateLabel() {
        return stateLabel;
    }

    public JSlider getjSlider1() {
        return jSlider1;
    }

    public JTextField getDisplay2() {
        return display2;
    }

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AIPS_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AIPS_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AIPS_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AIPS_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AIPS_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField battery;
    private javax.swing.JButton chargeBtn;
    private javax.swing.JTextField clock;
    private javax.swing.JTextField display1;
    private javax.swing.JTextField display2;
    private javax.swing.JButton f10m;
    private javax.swing.JButton f30s;
    private javax.swing.JButton f5m;
    private javax.swing.JButton insertReservoirBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton offBtn;
    private javax.swing.JButton onBtn;
    private javax.swing.JButton pumperBtn;
    private javax.swing.JButton reservoirBtn;
    private javax.swing.JTextField stateLabel;
    private javax.swing.JButton sugarSensorBtn;
    // End of variables declaration//GEN-END:variables
}
