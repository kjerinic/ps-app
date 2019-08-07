package forme;

import java.awt.Color;
import kontrola.Kontroler;

public class ServerskaForma extends javax.swing.JFrame {

    Kontroler k;

    public ServerskaForma() {
        initComponents();
        srediFormu();
        k = Kontroler.getInstanca();
        k.setSf(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPokreni = new javax.swing.JButton();
        btnZaustavi = new javax.swing.JButton();
        txtStatus = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");

        btnPokreni.setText("Pokreni server");
        btnPokreni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokreniActionPerformed(evt);
            }
        });

        btnZaustavi.setText("Zaustavi server");
        btnZaustavi.setEnabled(false);
        btnZaustavi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZaustaviActionPerformed(evt);
            }
        });

        txtStatus.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStatus)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPokreni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                        .addComponent(btnZaustavi)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPokreni)
                    .addComponent(btnZaustavi))
                .addContainerGap(212, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPokreniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokreniActionPerformed
        k.pokreniServer();
    }//GEN-LAST:event_btnPokreniActionPerformed

    private void btnZaustaviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZaustaviActionPerformed
        k.zaustaviServer();
    }//GEN-LAST:event_btnZaustaviActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPokreni;
    private javax.swing.JButton btnZaustavi;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void obavestiZaustavljen() {
        btnPokreni.setEnabled(true);
        btnZaustavi.setEnabled(false);
        txtStatus.setText("Zaustavljen server.");
        txtStatus.setBackground(Color.red);
    }

    public void obavestiPokrenut() {
        btnPokreni.setEnabled(false);
        btnZaustavi.setEnabled(true);
        txtStatus.setText("Pokrenut server.");
        txtStatus.setBackground(Color.green);
    }
   
}
