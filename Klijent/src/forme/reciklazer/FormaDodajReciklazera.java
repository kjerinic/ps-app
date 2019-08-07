package forme.reciklazer;

import domen.Kategorija;
import domen.Korisnik;
import domen.Reciklazer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import sesija.Sesija;

public class FormaDodajReciklazera extends javax.swing.JDialog {

    ArrayList<Kategorija> listaKategorija = new ArrayList<>();

    public FormaDodajReciklazera(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void setListaKategorija(ArrayList<Kategorija> listaKategorija) {
        this.listaKategorija = listaKategorija;
        popuniCmbKategorije();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbKategorije = new javax.swing.JComboBox();
        txtNaziv = new javax.swing.JTextField();
        txtOpis = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnSacuvajReciklazera = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Unos novog reciklazera");

        jLabel1.setText("Naziv:");

        jLabel2.setText("Opis:");

        jLabel3.setText("Email:");

        jLabel4.setText("Kategorija:");

        cmbKategorije.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbKategorije.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKategorijeActionPerformed(evt);
            }
        });

        btnSacuvajReciklazera.setText("Sačuvaj");
        btnSacuvajReciklazera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajReciklazeraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbKategorije, 0, 197, Short.MAX_VALUE)
                    .addComponent(txtNaziv)
                    .addComponent(txtOpis)
                    .addComponent(txtEmail))
                .addContainerGap(118, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSacuvajReciklazera)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtOpis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbKategorije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(btnSacuvajReciklazera)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajReciklazeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajReciklazeraActionPerformed
        String naziv = txtNaziv.getText();
        String opis = txtOpis.getText();
        String email = txtEmail.getText();
        Kategorija kat = (Kategorija) cmbKategorije.getSelectedItem();

        if (naziv.isEmpty() || opis.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nijedno polje ne sme biti prazno!", "Greska", JOptionPane.WARNING_MESSAGE);
        } else if (!email.contains("@")) {
            JOptionPane.showMessageDialog(this, "Neispravna email adresa.", "Greska", JOptionPane.WARNING_MESSAGE);
        } else {
            int result = JOptionPane.showConfirmDialog(this, "Jeste li sigurni da zelite da dodate reciklazera?", "Provera", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.NO_OPTION) {
                return;
            } else {
                Reciklazer rec = new Reciklazer(0, naziv, opis, email, kat, Sesija.getInstance().getPrijavljeniKorisnik());
                Kontroler.getInstanca().sacuvajNovogReciklazera(rec);
            }
        }

    }//GEN-LAST:event_btnSacuvajReciklazeraActionPerformed

    private void cmbKategorijeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKategorijeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbKategorijeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvajReciklazera;
    private javax.swing.JComboBox cmbKategorije;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtOpis;
    // End of variables declaration//GEN-END:variables

    private void popuniCmbKategorije() {
        cmbKategorije.removeAllItems();

        for (Kategorija kategorija : listaKategorija) {
            cmbKategorije.addItem(kategorija);
        }
    }
}
