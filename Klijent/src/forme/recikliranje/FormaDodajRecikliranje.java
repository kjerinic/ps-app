package forme.recikliranje;

import domen.Ambalaza;
import domen.Kategorija;
import domen.Korisnik;
import domen.Reciklazer;
import domen.Recikliranje;
import forme.ambalaza.model.ModelTabeleAmbalaza;
import forme.reciklazer.model.ModelTabeleReciklazera;
import forme.recikliranje.model.ModelTabeleRecikliranja;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import sesija.Sesija;

public class FormaDodajRecikliranje extends javax.swing.JFrame {

    ArrayList<Ambalaza> listaAmbalaza;
    ArrayList<Reciklazer> listaReciklazera;
    ArrayList<Kategorija> listaKategorija = new ArrayList<>();
    boolean popunjenaTblAmbalaze = false;
    boolean popunjenaTblReciklazeri = false;

    public FormaDodajRecikliranje() {
        initComponents();
        srediFormu();
        Kontroler.getInstanca().vratiSveAmbalaze();
        Kontroler.getInstanca().vratiSveReciklazere();

        pripremiCmbKategorije();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblRecikliranja = new javax.swing.JTable();
        btnSacuvajSve = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNapomena = new javax.swing.JTextArea();
        btnDodajRecikliranje = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReciklazeri = new javax.swing.JTable();
        btnPretraziReciklazere = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnPretraziAmbalaze = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAmbalaze = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtTerminPretrage = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbKategorije = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recikliranje");

        jLabel4.setText("Recikliranja:");

        tblRecikliranja.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblRecikliranja);

        btnSacuvajSve.setText("Sačuvaj sve");
        btnSacuvajSve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajSveActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos recikliranja"));
        jPanel1.setToolTipText("Unos recikliranja");

        jLabel3.setText("Napomena:");

        txtNapomena.setColumns(20);
        txtNapomena.setRows(5);
        jScrollPane3.setViewportView(txtNapomena);

        btnDodajRecikliranje.setText("Dodaj recikliranje");
        btnDodajRecikliranje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajRecikliranjeActionPerformed(evt);
            }
        });

        tblReciklazeri.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblReciklazeri);

        btnPretraziReciklazere.setText("Pretraži reciklažere");
        btnPretraziReciklazere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziReciklazereActionPerformed(evt);
            }
        });

        jLabel2.setText("Reciklažeri:");

        btnPretraziAmbalaze.setText("Pretraži ambalaže");
        btnPretraziAmbalaze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziAmbalazeActionPerformed(evt);
            }
        });

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

        jLabel1.setText("Ambalaže:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Pretraga"));

        jLabel5.setText("Termin pretrage:");

        cmbKategorije.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Kategorije:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbKategorije, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(txtTerminPretrage, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTerminPretrage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(cmbKategorije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPretraziAmbalaze, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnPretraziReciklazere, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel1)
                            .addComponent(btnDodajRecikliranje))
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btnPretraziAmbalaze)
                        .addGap(26, 26, 26)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnPretraziReciklazere)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDodajRecikliranje)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSacuvajSve)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSacuvajSve)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziReciklazereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziReciklazereActionPerformed
        Kategorija kat = (Kategorija) cmbKategorije.getSelectedItem();
        String terminPretrage = txtTerminPretrage.getText();
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
    }//GEN-LAST:event_btnPretraziReciklazereActionPerformed

    private void btnDodajRecikliranjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajRecikliranjeActionPerformed
        int indeksReciklazer = tblReciklazeri.getSelectedRow();
        int indeksAmbalaza = tblAmbalaze.getSelectedRow();

        if (indeksReciklazer > -1 && indeksAmbalaza > -1) {
            Ambalaza odabranaAmbalaza = ((ModelTabeleAmbalaza) tblAmbalaze.getModel()).getListaAmbalaza().get(indeksAmbalaza);
            Reciklazer odabraniReciklazer = ((ModelTabeleReciklazera) tblReciklazeri.getModel()).getListaReciklazera().get(indeksReciklazer);

            if (odabranaAmbalaza.getReciklazniKod().getKategorija().getKategorijaID() == odabraniReciklazer.getKategorija().getKategorijaID()) {
                Korisnik prijavljeniKorisnik = Sesija.getInstance().getPrijavljeniKorisnik();
                String napomena = txtNapomena.getText();

                Recikliranje recikliranje = new Recikliranje(0, odabraniReciklazer, odabranaAmbalaza, prijavljeniKorisnik, napomena);

                if (!((ModelTabeleRecikliranja) tblRecikliranja.getModel()).getListaRecikliranja().contains(recikliranje)) {
                    dodajUListuRecikliranja(recikliranje);
                } else {
                    JOptionPane.showMessageDialog(this, "Već ste uneli ovo recikliranje.", "Greška", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Odabrani reciklažer ne reciklira ovu kategoriju ambalaže.", "Greška", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Moraju biti selektovani i ambalaža i reciklažer!");
        }

    }//GEN-LAST:event_btnDodajRecikliranjeActionPerformed

    private void btnPretraziAmbalazeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziAmbalazeActionPerformed
        Kategorija kat = (Kategorija) cmbKategorije.getSelectedItem();
        String terminPretrage = txtTerminPretrage.getText();
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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPretraziAmbalazeActionPerformed

    private void btnSacuvajSveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajSveActionPerformed
        ArrayList<Recikliranje> listarecikliranja = ((ModelTabeleRecikliranja) tblRecikliranja.getModel()).getListaRecikliranja();

        Kontroler.getInstanca().sacuvajListuRecikliranja(listarecikliranja);
    }//GEN-LAST:event_btnSacuvajSveActionPerformed

    private void srediFormu() {
        this.setVisible(true);
        this.setResizable(false);
        this.setLocation(10, 10);

        btnPretraziAmbalaze.setEnabled(false);
        btnPretraziReciklazere.setEnabled(false);
        btnSacuvajSve.setEnabled(false);
        btnDodajRecikliranje.setEnabled(false);

        txtTerminPretrage.setEnabled(false);
        txtNapomena.setEnabled(false);

        srediTabeluReciklazera();
        srediTabeluAmbalaza();
        srediTabeluRecikliranja();
    }

    private void srediTabeluReciklazera() {
        ModelTabeleReciklazera mtr = new ModelTabeleReciklazera();
        tblReciklazeri.setModel(mtr);
    }

    private void srediTabeluAmbalaza() {
        ModelTabeleAmbalaza mta = new ModelTabeleAmbalaza();
        tblAmbalaze.setModel(mta);
    }

    private void srediTabeluRecikliranja() {
        ModelTabeleRecikliranja mtr = new ModelTabeleRecikliranja();
        tblRecikliranja.setModel(mtr);
    }

    public void obavestiNeuspesnoVracanjuListeReciklazera() {
        JOptionPane.showMessageDialog(this, "Sistem ne može da nađe reciklažere po zadatoj vrednosti.", "Greška", JOptionPane.ERROR_MESSAGE);
        Kontroler.getInstanca().vratiNaGlavnu();
    }

    public void obavestiNeuspesnoVracanjeListeAmbalaza() {
        JOptionPane.showMessageDialog(this, "Sistem ne može da nađe ambalaže po zadatoj vrednosti.", "Greška", JOptionPane.ERROR_MESSAGE);
        Kontroler.getInstanca().vratiNaGlavnu();
    }

    public void popuniTabeluReciklazera(ArrayList<Reciklazer> listaReciklazera) {
        if (listaReciklazera == null || listaReciklazera.isEmpty()) {
            obavestiNeuspesnoVracanjuListeReciklazera();
        } else {
            ModelTabeleReciklazera mtr = new ModelTabeleReciklazera(listaReciklazera);
            tblReciklazeri.setModel(mtr);
            this.listaReciklazera = listaReciklazera;
            mtr.fireTableDataChanged();
            popunjenaTblReciklazeri = true;

            if (popunjenaTblAmbalaze) {
                popuniCmbKategorije();

            }
        }
    }

    public void popuniTabeluAmbalaza(ArrayList<Ambalaza> listaAmbalaza) {
        if (listaAmbalaza == null || listaAmbalaza.isEmpty()) {
            obavestiNeuspesnoVracanjeListeAmbalaza();
        } else {
            ModelTabeleAmbalaza mta = new ModelTabeleAmbalaza(listaAmbalaza);
            tblAmbalaze.setModel(mta);
            this.listaAmbalaza = listaAmbalaza;
            mta.fireTableDataChanged();
            popunjenaTblAmbalaze = true;

            if (popunjenaTblReciklazeri) {
                popuniCmbKategorije();
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajRecikliranje;
    private javax.swing.JButton btnPretraziAmbalaze;
    private javax.swing.JButton btnPretraziReciklazere;
    private javax.swing.JButton btnSacuvajSve;
    private javax.swing.JComboBox cmbKategorije;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblAmbalaze;
    private javax.swing.JTable tblReciklazeri;
    private javax.swing.JTable tblRecikliranja;
    private javax.swing.JTextArea txtNapomena;
    private javax.swing.JTextField txtTerminPretrage;
    // End of variables declaration//GEN-END:variables

    private void popuniCmbKategorije() {

        if (listaKategorija.isEmpty()) {
            listaKategorija = Kontroler.getInstanca().vratiSveKategorije();

            for (Kategorija kategorija : listaKategorija) {
                cmbKategorije.addItem(kategorija);
            }
        }

        if (popunjenaTblAmbalaze == true || popunjenaTblReciklazeri) {
            omoguciAkciju();
        }

    }

    private void pripremiCmbKategorije() {
        cmbKategorije.removeAllItems();
        cmbKategorije.addItem(new Kategorija(0, "Sve kategorije"));
    }

    private void omoguciAkciju() {
        btnPretraziAmbalaze.setEnabled(true);
        btnPretraziReciklazere.setEnabled(true);
        btnSacuvajSve.setEnabled(true);
        btnDodajRecikliranje.setEnabled(true);

        txtTerminPretrage.setEnabled(true);
        txtNapomena.setEnabled(true);
    }

    @Override
    public void setDefaultCloseOperation(int operation) {
        Sesija.getInstance().setCurrentUseCase(-1);
        this.dispose();
    }

    private void dodajUListuRecikliranja(Recikliranje recikliranje) {
        ((ModelTabeleRecikliranja) tblRecikliranja.getModel()).getListaRecikliranja().add(recikliranje);
        ((ModelTabeleRecikliranja) tblRecikliranja.getModel()).fireTableDataChanged();
    }

}
