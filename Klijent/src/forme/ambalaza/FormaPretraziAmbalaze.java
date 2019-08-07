package forme.ambalaza;

import domen.Ambalaza;
import forme.reciklazer.*;
import domen.Kategorija;
import domen.ReciklazniKod;
import forme.ambalaza.model.ModelTabeleAmbalaza;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import sesija.Sesija;

public class FormaPretraziAmbalaze extends javax.swing.JFrame {

    ArrayList<Kategorija> listaKategorija = new ArrayList<>();
    ArrayList<Ambalaza> listaAmbalaza = new ArrayList<>();
    ArrayList<ReciklazniKod> listaKodova = new ArrayList<>();
    FormaDodajAmbalazu formaDodajAmbalazu;
    FormAmbalazaDetalji formAmbalazaDetalji;

    public FormaPretraziAmbalaze(EnumFormaAmbalaza mode) {
        initComponents();
        srediFormu(mode);
        Kontroler.getInstanca().vratiSveAmbalaze();
        pripremiCmbKategorije();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAmbalaze = new javax.swing.JTable();
        btnDodajAmbalazu = new javax.swing.JButton();
        cmbKategorije = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtKorisnik = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        btnDetalji = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTermin = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pregled ambalaža");

        tblAmbalaze.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblAmbalaze);

        btnDodajAmbalazu.setText("Dodaj ambalažu");
        btnDodajAmbalazu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajAmbalazuActionPerformed(evt);
            }
        });

        cmbKategorije.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Filtriraj po kategoriji:");

        txtKorisnik.setEditable(false);
        txtKorisnik.setEnabled(false);

        btnPretrazi.setText("Pretraži");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        btnDetalji.setText("Detalji");
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        jLabel2.setText("Termin za pretragu:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodajAmbalazu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtKorisnik, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbKategorije, 0, 157, Short.MAX_VALUE)
                            .addComponent(txtTermin))
                        .addGap(18, 18, 18)
                        .addComponent(btnPretrazi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDetalji)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbKategorije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(btnDetalji))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtTermin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnPretrazi)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajAmbalazu)
                    .addComponent(txtKorisnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajAmbalazuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajAmbalazuActionPerformed
        Kontroler.getInstanca().vratiSveReciklazneKodove();
    }//GEN-LAST:event_btnDodajAmbalazuActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        Kategorija kat = (Kategorija) cmbKategorije.getSelectedItem();
        String terminPretrage = txtTermin.getText();
        if (terminPretrage.isEmpty() || terminPretrage.equals(" ")) {
            terminPretrage = "x";
        }

        if (kat.getKategorijaID() == 0 && terminPretrage.isEmpty()) {
            Kontroler.getInstanca().vratiSveAmbalaze();
        } else {
            String kategorijaID = Integer.toString(kat.getKategorijaID());
            String[] uslovi = {kategorijaID, terminPretrage};
            Kontroler.getInstanca().vratiAmbalazePoUslovu(uslovi);
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed
        int odabraniRed = tblAmbalaze.getSelectedRow();
        if (odabraniRed > -1) {
            int odabranaAmbalazaID = ((ModelTabeleAmbalaza) tblAmbalaze.getModel()).getListaAmbalaza().get(odabraniRed).getAmbalazaID();
            Kontroler.getInstanca().vratiAmbalazu(odabranaAmbalazaID);
//            int ambalazaID = (int) tblAmbalaze.getValueAt(odabraniRed, 0);
//            for (Ambalaza ambalaza : listaAmbalaza) {
//                if (ambalaza.getAmbalazaID()== odabranaAmbalazaID) {
//                    formAmbalazaDetalji = new FormAmbalazaDetalji(this, false, ambalaza);
//                    break;
//                }
//            }
        } else {
            JOptionPane.showMessageDialog(this, "Nije selektovana nijedna ambalaža.");
        }


    }//GEN-LAST:event_btnDetaljiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JButton btnDodajAmbalazu;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JComboBox cmbKategorije;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAmbalaze;
    private javax.swing.JTextField txtKorisnik;
    private javax.swing.JTextField txtTermin;
    // End of variables declaration//GEN-END:variables

    private void srediFormu(EnumFormaAmbalaza mode) {
        this.setVisible(true);
        this.setResizable(false);
        this.setLocation(10, 10);
        btnPretrazi.setEnabled(false);
        btnDetalji.setEnabled(false);
        txtTermin.setEnabled(false);

        switch (mode) {
            case ADD_NEW:
                btnDodajAmbalazu.setVisible(true);
                txtKorisnik.setVisible(true);
                txtKorisnik.setText(Sesija.getInstance().getPrijavljeniKorisnik().getKorisnickoIme());
                break;
            case VIEW:
                btnDodajAmbalazu.setVisible(false);
                txtKorisnik.setVisible(false);
                break;
        }

        srediTabelu();
    }

    private void srediTabelu() {
        ModelTabeleAmbalaza mta = new ModelTabeleAmbalaza();
        tblAmbalaze.setModel(mta);
    }

    @Override
    public void setDefaultCloseOperation(int operation) {
        this.dispose();
    }

    public void popuniTabeluAmbalaza(ArrayList<Ambalaza> listaAmbalaza) {
        if (listaAmbalaza == null || listaAmbalaza.isEmpty()) {
            obavestiNeuspesnoVracanjeListeAmbalaza();
        } else {
            ModelTabeleAmbalaza mta = new ModelTabeleAmbalaza(listaAmbalaza);
            tblAmbalaze.setModel(mta);
            this.listaAmbalaza = listaAmbalaza;
            mta.fireTableDataChanged();
            popuniCmbKategorije();
        }
    }

    private void popuniCmbKategorije() {
        btnPretrazi.setEnabled(true);
        btnDetalji.setEnabled(true);
        txtTermin.setEnabled(true);

        if (listaKategorija.isEmpty()) {
            listaKategorija = Kontroler.getInstanca().vratiSveKategorije();

            for (Kategorija kategorija : listaKategorija) {
                cmbKategorije.addItem(kategorija);
            }
        }
    }

    private void pripremiCmbKategorije() {
        cmbKategorije.removeAllItems();
        cmbKategorije.addItem(new Kategorija(0, "Sve kategorije"));
    }

    public void obavestiNeuspesnoVracanjeListeAmbalaza() {
        JOptionPane.showMessageDialog(this, "Sistem ne može da nađe ambalaže po zadatoj vrednosti.", "Greška", JOptionPane.ERROR_MESSAGE);
        this.dispose();
    }

    public void obavestiNeuspesnoVracanjeListeKodova() {
        JOptionPane.showMessageDialog(this, "Sistem ne može da vrati listu kategorija.", "Greška", JOptionPane.ERROR_MESSAGE);
        formaDodajAmbalazu.dispose();
        this.dispose();

    }

    public void primiListuKodova(ArrayList<ReciklazniKod> listaKodova) {
        this.listaKodova = listaKodova;
        formaDodajAmbalazu = new FormaDodajAmbalazu(this, true);
        formaDodajAmbalazu.setListaReciklaznihKodova(listaKodova);
        formaDodajAmbalazu.setVisible(true);
    }

    public void obavestiNeuspesanUnosNoveAmbalaze() {
        formaDodajAmbalazu.neuspesanUnos();
    }

    public void obavestiUspesanUnosNoveAmbalaze() {
        formaDodajAmbalazu.uspesanUnos();
    }

    public void obavestiUspesnoVracenaJednaAmbalaza(Ambalaza amb) {
        formAmbalazaDetalji = new FormAmbalazaDetalji(this, rootPaneCheckingEnabled, amb);
    }

    public void obavestiNeuspesnoVracenaJednaAmbalaza() {
        JOptionPane.showMessageDialog(this, "Sistem ne može da vrati ambalažu.", "Greska", JOptionPane.ERROR_MESSAGE);
        this.dispose();
    }


}
