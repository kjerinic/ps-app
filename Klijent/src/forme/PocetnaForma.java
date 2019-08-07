package forme;

import forme.ambalaza.*;
import forme.korisnik.*;
import forme.reciklazer.*;
import java.awt.Color;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import kontroler.Kontroler;

public class PocetnaForma extends javax.swing.JFrame {

    private FormaNapraviNalog formaNapraviNalog;
    private FormaPretraziReciklazere formaPretraziReciklazere;
    private FormaPretraziAmbalaze formaPretraziAmbalaze;
    //isto za ambalaze

    public PocetnaForma() {
        initComponents();
        srediFormu();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnPrijava = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnNapraviNalog = new javax.swing.JButton();
        btnPretragaAmbalaza = new javax.swing.JButton();
        btnPretragaReciklazera = new javax.swing.JButton();
        txtStatusServera = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.SystemColor.activeCaptionBorder);
        setName("Pocetna forma"); // NOI18N
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KAKO RECIKLIRATI AMBALAŽU U SRBIJI?");
        jLabel1.setMaximumSize(new java.awt.Dimension(67, 30));

        btnPrijava.setText("Prijava na sistem");
        btnPrijava.setEnabled(false);
        btnPrijava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrijavaActionPerformed(evt);
            }
        });

        jLabel2.setText("Nemate nalog? Napravite ga:");

        btnNapraviNalog.setText("Napravi nalog");
        btnNapraviNalog.setEnabled(false);
        btnNapraviNalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNapraviNalogActionPerformed(evt);
            }
        });

        btnPretragaAmbalaza.setText("Pretraga ambalaža");
        btnPretragaAmbalaza.setEnabled(false);
        btnPretragaAmbalaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretragaAmbalazaActionPerformed(evt);
            }
        });

        btnPretragaReciklazera.setText("Pretraga reciklažera");
        btnPretragaReciklazera.setEnabled(false);
        btnPretragaReciklazera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretragaReciklazeraActionPerformed(evt);
            }
        });

        txtStatusServera.setEditable(false);
        txtStatusServera.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtStatusServera.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrijava, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPretragaAmbalaza)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPretragaReciklazera))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNapraviNalog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtStatusServera))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPrijava)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNapraviNalog)
                .addGap(106, 106, 106)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtStatusServera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPretragaAmbalaza)
                    .addComponent(btnPretragaReciklazera))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrijavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrijavaActionPerformed
        this.setVisible(false);
        skloniOstaleForme();
        Kontroler.getInstanca().pokreniLoginFormu();
    }//GEN-LAST:event_btnPrijavaActionPerformed

    private void btnPretragaAmbalazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretragaAmbalazaActionPerformed
        skloniOstaleForme();
        formaPretraziAmbalaze = new FormaPretraziAmbalaze(EnumFormaAmbalaza.VIEW);
        Kontroler.getInstanca().setFormaPretraziAmbalaze(formaPretraziAmbalaze);
    }//GEN-LAST:event_btnPretragaAmbalazaActionPerformed

    private void btnPretragaReciklazeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretragaReciklazeraActionPerformed
        skloniOstaleForme();
        this.formaPretraziReciklazere = new FormaPretraziReciklazere(EnumFormaReciklazer.VIEW);
        Kontroler.getInstanca().setFormaPretraziReciklazere(formaPretraziReciklazere);
    }//GEN-LAST:event_btnPretragaReciklazeraActionPerformed

    private void btnNapraviNalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNapraviNalogActionPerformed
        skloniOstaleForme();
        formaNapraviNalog = new FormaNapraviNalog(this, true, EnumFormaNalog.NEW);
        formaNapraviNalog.setVisible(true);
    }//GEN-LAST:event_btnNapraviNalogActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNapraviNalog;
    private javax.swing.JButton btnPretragaAmbalaza;
    private javax.swing.JButton btnPretragaReciklazera;
    private javax.swing.JButton btnPrijava;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtStatusServera;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public void onemoguciAkciju() {
        this.btnNapraviNalog.setEnabled(false);
        this.btnPrijava.setEnabled(false);
        this.btnPretragaReciklazera.setEnabled(false);
        this.btnPretragaAmbalaza.setEnabled(false);
        txtStatusServera.setText("Niste povezani na server.");
        txtStatusServera.setBackground(Color.RED);

        if (formaNapraviNalog != null && formaNapraviNalog.isVisible()) {
            formaNapraviNalog.dispose();
        }
        if (formaPretraziReciklazere != null && formaPretraziReciklazere.isVisible()) {
            formaPretraziReciklazere.dispose();
        }
        if (formaPretraziAmbalaze != null && formaPretraziAmbalaze.isVisible()) {
            formaPretraziAmbalaze.dispose();
        }
    }

    public void omoguciAkciju() {
        this.btnNapraviNalog.setEnabled(true);
        this.btnPrijava.setEnabled(true);
        this.btnPretragaReciklazera.setEnabled(true);
        this.btnPretragaAmbalaza.setEnabled(true);
        txtStatusServera.setText("Povezani ste na server.");
        txtStatusServera.setBackground(Color.GREEN);
    }

    public void obavestiUspesnoPravljenje() {
        JOptionPane.showMessageDialog(formaNapraviNalog, "Sistem je zapamtio korisnika.", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
        formaNapraviNalog.dispose();
    }

    public void obavestiNeuspesnoPravljenje() {
        JOptionPane.showMessageDialog(formaNapraviNalog, "Sistem ne može da zapamti podatke o korisniku.", "Greska", JOptionPane.ERROR_MESSAGE);
        formaNapraviNalog.resetujSvaPolja();
    }

    private void skloniOstaleForme() {
        if (formaNapraviNalog != null && formaNapraviNalog.isVisible()) {
            formaNapraviNalog.dispose();
        }
        if (formaPretraziReciklazere != null && formaPretraziReciklazere.isVisible()) {
            formaPretraziReciklazere.dispose();
        }
        if (formaPretraziAmbalaze != null && formaPretraziAmbalaze.isVisible()) {
            formaPretraziAmbalaze.dispose();
        }
    }

    public void obavestiGasenje() {

        if (formaNapraviNalog != null && formaNapraviNalog.isVisible()) {
            formaNapraviNalog.dispose();
        }
        if (formaPretraziReciklazere != null && formaPretraziReciklazere.isVisible()) {
            formaPretraziReciklazere.dispose();
        }
        if (formaPretraziAmbalaze != null && formaPretraziAmbalaze.isVisible()) {
            formaPretraziAmbalaze.dispose();
        }

        JOptionPane.showMessageDialog(formaNapraviNalog, "Sistem se gasi..", "Greska", JOptionPane.ERROR_MESSAGE);

        Kontroler.getInstanca().zaustaviPokretanjeKlijenta();
        this.dispose();
    }

}
