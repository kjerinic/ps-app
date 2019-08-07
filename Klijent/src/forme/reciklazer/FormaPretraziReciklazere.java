package forme.reciklazer;

import domen.Kategorija;
import domen.Reciklazer;
import forme.reciklazer.model.ModelTabeleReciklazera;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import sesija.Sesija;

public class FormaPretraziReciklazere extends javax.swing.JFrame {

    ArrayList<Kategorija> listaKategorija = new ArrayList<>();
    ArrayList<Reciklazer> listaReciklazera = new ArrayList<>();
    FormaDodajReciklazera fdr;
    FormReciklazerDetalji formReciklazerDetalji;

    public FormaPretraziReciklazere(EnumFormaReciklazer mode) {
        initComponents();
        srediFormu(mode);
        Kontroler.getInstanca().vratiSveReciklazere();
        pripremiCmbKategorije();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblReciklazer = new javax.swing.JTable();
        btnDodajReciklazera = new javax.swing.JButton();
        cmbKategorije = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txtKorisnik = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        btnDetalji = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTermin = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pregled reciklažera");

        tblReciklazer.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblReciklazer);

        btnDodajReciklazera.setText("Dodaj reciklažera");
        btnDodajReciklazera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajReciklazeraActionPerformed(evt);
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
                        .addComponent(btnDodajReciklazera)
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
                    .addComponent(btnDodajReciklazera)
                    .addComponent(txtKorisnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajReciklazeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajReciklazeraActionPerformed
        fdr = new FormaDodajReciklazera(this, true);
        fdr.setListaKategorija(listaKategorija);
        fdr.setVisible(true);
    }//GEN-LAST:event_btnDodajReciklazeraActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        Kategorija kat = (Kategorija) cmbKategorije.getSelectedItem();
        String terminPretrage = txtTermin.getText();
        if (terminPretrage.isEmpty() || terminPretrage.equals(" ")) {
            terminPretrage = "x";
        }

        if (kat.getKategorijaID() == 0 && terminPretrage.isEmpty()) {
            Kontroler.getInstanca().vratiSveReciklazere();
        } else {
            String kategorijaID = Integer.toString(kat.getKategorijaID());
            String[] uslovi = {kategorijaID, terminPretrage};
            Kontroler.getInstanca().vratiReciklazerePoUslovu(uslovi);
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed
        int odabraniRed = tblReciklazer.getSelectedRow();
        if (odabraniRed > -1) {
            int odabraniReciklazerID = ((ModelTabeleReciklazera)tblReciklazer.getModel()).getListaReciklazera().get(odabraniRed).getReciklazerID();
            Kontroler.getInstanca().vratiReciklazera(odabraniReciklazerID);

//            int reciklazerID = (int) tblReciklazer.getValueAt(odabraniRed, 0);
//            for (Reciklazer reciklazer : listaReciklazera) {
//                if (reciklazer.getReciklazerID() == reciklazerID) {
//                    formReciklazerDetalji = new FormReciklazerDetalji(this, false, reciklazer);
//                    break;
//                }
//            }
        } else {
            JOptionPane.showMessageDialog(this, "Nije selektovan nijedan reciklažer.");
        }


    }//GEN-LAST:event_btnDetaljiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JButton btnDodajReciklazera;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JComboBox cmbKategorije;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReciklazer;
    private javax.swing.JTextField txtKorisnik;
    private javax.swing.JTextField txtTermin;
    // End of variables declaration//GEN-END:variables

    private void srediFormu(EnumFormaReciklazer mode) {
        this.setVisible(true);
        this.setResizable(false);
        this.setLocation(10, 10);
        btnPretrazi.setEnabled(false);
        btnDetalji.setEnabled(false);
        txtTermin.setEnabled(false);

        switch (mode) {
            case ADD_NEW:
                btnDodajReciklazera.setVisible(true);
                txtKorisnik.setVisible(true);
                txtKorisnik.setText(Sesija.getInstance().getPrijavljeniKorisnik().getKorisnickoIme());
                break;
            case VIEW:
                btnDodajReciklazera.setVisible(false);
                txtKorisnik.setVisible(false);
                break;
        }

        srediTabelu();
    }

    private void srediTabelu() {
        ModelTabeleReciklazera mtr = new ModelTabeleReciklazera();
        tblReciklazer.setModel(mtr);
    }

    public void popuniTabeluReciklazera(ArrayList<Reciklazer> listaReciklazera) {
        ModelTabeleReciklazera mtr = new ModelTabeleReciklazera(listaReciklazera);
        tblReciklazer.setModel(mtr);
        this.listaReciklazera = listaReciklazera;
        mtr.fireTableDataChanged();
        popuniCmbKategorije();
    }

    @Override
    public void setDefaultCloseOperation(int operation) {
        this.dispose();
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
        cmbKategorije.addItem(new Kategorija(0, "Svi reciklažeri"));
    }

    public void obavestiNeuspesnoVracanjuListeReciklazera() {
        JOptionPane.showMessageDialog(this, "Sistem ne može da nađe reciklažere po zadatoj vrednosti.", "Greska", JOptionPane.ERROR_MESSAGE);
        this.dispose();
    }

    public void obavestiNeuspesanUnos() {
        JOptionPane.showMessageDialog(this, "Sistem nije zapamtio reciklažera.", "Greska", JOptionPane.ERROR_MESSAGE);
        fdr.dispose();
    }

    public void obavestiUspesanUnos() {
        JOptionPane.showMessageDialog(this, "Sistem je zapamtio reciklažera", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
        fdr.dispose();
    }

    public void obavestiNeuspesnoVracanjeListeKategorija() {
        JOptionPane.showMessageDialog(this, "Sistem nije uspeo da vrati listu kategorija.", "Greska", JOptionPane.ERROR_MESSAGE);
        this.dispose();
    }

    public void obavestiUspesnoVracenJedanReciklazer(Reciklazer rec) {
        formReciklazerDetalji = new FormReciklazerDetalji(this, rootPaneCheckingEnabled, rec);
    }

    public void obavestiNeuspesnoVracenJedanReciklazer() {
        JOptionPane.showMessageDialog(this, "Sistem ne može da vrati reciklažera.", "Greska", JOptionPane.ERROR_MESSAGE);
        this.dispose();
    }

}
