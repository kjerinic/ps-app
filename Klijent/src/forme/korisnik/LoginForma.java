package forme.korisnik;

import java.awt.Color;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import kontroler.Kontroler;

public class LoginForma extends javax.swing.JFrame {

    Kontroler k;

    public LoginForma() {
        initComponents();
        srediFormu();
        k = Kontroler.getInstanca();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsername = new javax.swing.JLabel();
        txtKorisnickoIme = new javax.swing.JTextField();
        btnPrijaviSe = new javax.swing.JButton();
        txtStatus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtSifra = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lblUsername.setText("Korisničko ime:");

        txtKorisnickoIme.setEditable(false);

        btnPrijaviSe.setText("Prijavi se");
        btnPrijaviSe.setEnabled(false);
        btnPrijaviSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrijaviSeActionPerformed(evt);
            }
        });

        txtStatus.setEditable(false);

        jLabel1.setText("Sifra:");

        txtSifra.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStatus)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPrijaviSe))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKorisnickoIme)
                            .addComponent(txtSifra, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                        .addGap(0, 55, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(btnPrijaviSe)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrijaviSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrijaviSeActionPerformed
        String korisnickoIme = txtKorisnickoIme.getText();
        String sifra = new String(txtSifra.getPassword());

        if (korisnickoIme.isEmpty() || sifra.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Korisnicko ime i sifra ne mogu biti prazni.", "Greska", JOptionPane.WARNING_MESSAGE);
        } else {
            k.prijaviSe(korisnickoIme, sifra);
        }
    }//GEN-LAST:event_btnPrijaviSeActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Kontroler.getInstanca().vratiNaPocetnu();
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrijaviSe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtKorisnickoIme;
    private javax.swing.JPasswordField txtSifra;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void uspesnoPrijavljivanje(String poruka) {
        JOptionPane.showMessageDialog(this, "Uspesno ste se prijavili, " + poruka + ".");
    }

    public void neuspesnoPrijavljivanje(String poruka) {
        JOptionPane.showMessageDialog(this, "Sistem ne može da vas prijavi.", "Greška", JOptionPane.ERROR_MESSAGE);
    }

    public void onemoguciAkciju() {
        txtStatus.setText("Niste povezani na server.");
        txtStatus.setBackground(Color.red);
        txtKorisnickoIme.setEditable(false);
        txtSifra.setEditable(false);
        btnPrijaviSe.setEnabled(false);

        this.dispose();
    }

    public void omoguciAkciju() {
        txtStatus.setText("Povezani ste na server.");
        txtStatus.setBackground(Color.green);
        txtKorisnickoIme.setEditable(true);
        txtSifra.setEditable(true);
        btnPrijaviSe.setEnabled(true);
    }


}
