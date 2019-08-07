package forme.ambalaza;

import domen.Ambalaza;
import domen.ReciklazniKod;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import sesija.Sesija;

public class FormaDodajAmbalazu extends javax.swing.JDialog {

    ArrayList<ReciklazniKod> listaReciklaznihKodova = new ArrayList<>();

    public FormaDodajAmbalazu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setListaReciklaznihKodova(ArrayList<ReciklazniKod> listaReciklaznihKodova) {
        this.listaReciklaznihKodova = listaReciklaznihKodova;
        popuniCmbReciklazniKodovi();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbReciklazniKodovi = new javax.swing.JComboBox();
        txtNaziv = new javax.swing.JTextField();
        btnSacuvajAmbalazu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Unos nove ambalaže");

        jLabel1.setText("Naziv:");

        jLabel4.setText("Reciklažni kod:");

        cmbReciklazniKodovi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbReciklazniKodovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbReciklazniKodoviActionPerformed(evt);
            }
        });

        btnSacuvajAmbalazu.setText("Sačuvaj");
        btnSacuvajAmbalazu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajAmbalazuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSacuvajAmbalazu))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(70, 70, 70)
                                .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(cmbReciklazniKodovi, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 88, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cmbReciklazniKodovi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(btnSacuvajAmbalazu)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajAmbalazuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajAmbalazuActionPerformed
        String naziv = txtNaziv.getText();
        ReciklazniKod rk = (ReciklazniKod) cmbReciklazniKodovi.getSelectedItem();

        if (naziv.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Naziv ne sme biti prazan!", "Greška", JOptionPane.WARNING_MESSAGE);
        } else {
            int result = JOptionPane.showConfirmDialog(this, "Jeste li sigurni da želite da dodate ambalažu?", "Provera", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.NO_OPTION) {
                return;
            } else {
                Ambalaza amb = new Ambalaza(0, naziv, rk, Sesija.getInstance().getPrijavljeniKorisnik());
                Kontroler.getInstanca().sacuvajNovuAmbalazu(amb);
            }
        }

    }//GEN-LAST:event_btnSacuvajAmbalazuActionPerformed

    private void cmbReciklazniKodoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbReciklazniKodoviActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbReciklazniKodoviActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvajAmbalazu;
    private javax.swing.JComboBox cmbReciklazniKodovi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    private void popuniCmbReciklazniKodovi() {
        cmbReciklazniKodovi.removeAllItems();

        for (ReciklazniKod rk : listaReciklaznihKodova) {
            cmbReciklazniKodovi.addItem(rk);
        }
    }

    void neuspesanUnos() {
        JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti ambalažu.", "Greska", JOptionPane.ERROR_MESSAGE);
        this.dispose();
    }

    void uspesanUnos() {
        JOptionPane.showMessageDialog(this, "Sistem je zapamtio ambalažu.", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }
}
