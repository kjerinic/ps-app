package forme.korisnik;

import domen.Korisnik;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import sesija.Sesija;

public class FormaNapraviNalog extends javax.swing.JDialog {

    public FormaNapraviNalog(java.awt.Frame parent, boolean modal, EnumFormaNalog enumFormaNalog) {
        super(parent, modal);
        initComponents();
        srediFormu(enumFormaNalog);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        txtPrezime = new javax.swing.JTextField();
        txtKorisnickoIme = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnNapraviNovNalog = new javax.swing.JButton();
        btnSacuvajIzmene = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        txtPrijavljeniKorisnik = new javax.swing.JTextField();
        pnlBrisanje = new javax.swing.JPanel();
        btnObrisiNalog = new javax.swing.JButton();
        txtSifra = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nov nalog");

        jLabel1.setText("Ime:");

        jLabel2.setText("Prezime:");

        jLabel3.setText("Korisničko ime:");

        jLabel4.setText("Šifra:");

        jLabel5.setText("Email:");

        btnNapraviNovNalog.setText("Napravi nov nalog");
        btnNapraviNovNalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNapraviNovNalogActionPerformed(evt);
            }
        });

        btnSacuvajIzmene.setText("Sačuvaj izmene");
        btnSacuvajIzmene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajIzmeneActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        txtPrijavljeniKorisnik.setEditable(false);

        pnlBrisanje.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Brisanje", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 102, 102))); // NOI18N

        btnObrisiNalog.setForeground(new java.awt.Color(255, 102, 102));
        btnObrisiNalog.setText("Obriši nalog");
        btnObrisiNalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiNalogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBrisanjeLayout = new javax.swing.GroupLayout(pnlBrisanje);
        pnlBrisanje.setLayout(pnlBrisanjeLayout);
        pnlBrisanjeLayout.setHorizontalGroup(
            pnlBrisanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBrisanjeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnObrisiNalog)
                .addContainerGap())
        );
        pnlBrisanjeLayout.setVerticalGroup(
            pnlBrisanjeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBrisanjeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnObrisiNalog)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPrijavljeniKorisnik, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlBrisanje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSacuvajIzmene)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNapraviNovNalog))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIme)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                    .addComponent(txtPrezime)
                                    .addComponent(txtKorisnickoIme)
                                    .addComponent(txtSifra)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnIzmeni)))
                        .addGap(17, 17, 17))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPrijavljeniKorisnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKorisnickoIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSifra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIzmeni)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvajIzmene)
                    .addComponent(btnNapraviNovNalog))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(pnlBrisanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNapraviNovNalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNapraviNovNalogActionPerformed
        String ime = txtIme.getText();
        String prezime = txtPrezime.getText();
        String korisnickoIme = txtKorisnickoIme.getText();
        String sifra = new String(txtSifra.getPassword());
        String email = txtEmail.getText();

        if (ime.isEmpty() || prezime.isEmpty() || korisnickoIme.isEmpty() || sifra.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nijedno polje ne sme biti prazno!", "Greska", JOptionPane.WARNING_MESSAGE);
        } else if (!email.contains("@")) {
            JOptionPane.showMessageDialog(this, "Neispravna email adresa.", "Greska", JOptionPane.WARNING_MESSAGE);
        } else {
            Korisnik korisnik = new Korisnik(0, korisnickoIme, sifra, ime, prezime, email);
            Kontroler.getInstanca().napraviNovNalog(korisnik);
        }

    }//GEN-LAST:event_btnNapraviNovNalogActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        GlavnaForma gf = (GlavnaForma) this.getParent();
        this.dispose();
        JDialog formaNapraviNalog = new FormaNapraviNalog(null, true, EnumFormaNalog.EDIT);
        gf.setFormaNapraviNalog(formaNapraviNalog);
        formaNapraviNalog.setVisible(true);
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnSacuvajIzmeneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajIzmeneActionPerformed
        String ime = txtIme.getText();
        String prezime = txtPrezime.getText();
        String korisnickoIme = txtKorisnickoIme.getText();
        String sifra = new String(txtSifra.getPassword());
        String email = txtEmail.getText();

        if (ime == Sesija.getInstance().getPrijavljeniKorisnik().getIme()
                && prezime == Sesija.getInstance().getPrijavljeniKorisnik().getPrezime()
                && korisnickoIme == Sesija.getInstance().getPrijavljeniKorisnik().getKorisnickoIme()
                && sifra == Sesija.getInstance().getPrijavljeniKorisnik().getSifra()
                && email == Sesija.getInstance().getPrijavljeniKorisnik().getEmailKor()) {

            JOptionPane.showMessageDialog(this, "Niste napravili nikakvu izmenu.", "Obavestenje", JOptionPane.WARNING_MESSAGE);

        } else if (ime.isEmpty() || prezime.isEmpty() || korisnickoIme.isEmpty() || sifra.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nijedno polje ne sme biti prazno!", "Greska", JOptionPane.WARNING_MESSAGE);
        } else if (!email.contains("@")) {
            JOptionPane.showMessageDialog(this, "Neispravna email adresa.", "Greska", JOptionPane.WARNING_MESSAGE);
        } else {
            int korisnikID = Sesija.getInstance().getPrijavljeniKorisnik().getKorisnikID();
            Korisnik korisnik = new Korisnik(korisnikID, korisnickoIme, sifra, ime, prezime, email);
            Kontroler.getInstanca().izmeniNalog(korisnik);
        }

    }//GEN-LAST:event_btnSacuvajIzmeneActionPerformed

    private void btnObrisiNalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiNalogActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Jeste li sigurni da zelite da obrisete svoj nalog?", "Brisanje", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.NO_OPTION) {
            return;
        } else {
            Kontroler.getInstanca().obrisiKorisnika();
        }

    }//GEN-LAST:event_btnObrisiNalogActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnNapraviNovNalog;
    private javax.swing.JButton btnObrisiNalog;
    private javax.swing.JButton btnSacuvajIzmene;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel pnlBrisanje;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIme;
    private javax.swing.JTextField txtKorisnickoIme;
    private javax.swing.JTextField txtPrezime;
    private javax.swing.JTextField txtPrijavljeniKorisnik;
    private javax.swing.JPasswordField txtSifra;
    // End of variables declaration//GEN-END:variables

    public void resetujSvaPolja() {
        txtIme.setText("");
        txtPrezime.setText("");
        txtKorisnickoIme.setText("");
        txtSifra.setText("");
        txtEmail.setText("");
    }

    private void srediFormu(EnumFormaNalog enumFormaNalog) {
        this.setResizable(false);
        this.setLocation(10, 10);

        switch (enumFormaNalog) {
            case NEW:
                pnlBrisanje.setVisible(false);
                btnNapraviNovNalog.setVisible(true);
                btnIzmeni.setVisible(false);
                btnSacuvajIzmene.setVisible(false);

                setTitle("Pravljenje novog naloga");
                break;
            case VIEW:
                pnlBrisanje.setVisible(true);
                btnNapraviNovNalog.setVisible(false);
                btnIzmeni.setVisible(true);
                btnSacuvajIzmene.setVisible(false);

                txtPrijavljeniKorisnik.setText(Sesija.getInstance().getPrijavljeniKorisnik().getKorisnickoIme());

                String ime = Sesija.getInstance().getPrijavljeniKorisnik().getIme();
                String prezime = Sesija.getInstance().getPrijavljeniKorisnik().getPrezime();
                String korisnickoIme = Sesija.getInstance().getPrijavljeniKorisnik().getKorisnickoIme();
                String sifra = Sesija.getInstance().getPrijavljeniKorisnik().getSifra();
                String email = Sesija.getInstance().getPrijavljeniKorisnik().getEmailKor();

                txtIme.setText(ime);
                txtPrezime.setText(prezime);
                txtKorisnickoIme.setText(korisnickoIme);
                txtSifra.setText(sifra);
                txtEmail.setText(email);

                txtEmail.setEditable(false);
                txtPrezime.setEditable(false);
                txtIme.setEditable(false);
                txtSifra.setEditable(false);
                txtKorisnickoIme.setEditable(false);

                setTitle("Moj nalog");
                break;
            case EDIT:
                pnlBrisanje.setVisible(false);
                btnNapraviNovNalog.setVisible(false);
                btnSacuvajIzmene.setVisible(true);
                btnIzmeni.setVisible(false);

                txtPrijavljeniKorisnik.setText(Sesija.getInstance().getPrijavljeniKorisnik().getKorisnickoIme());

                String i = Sesija.getInstance().getPrijavljeniKorisnik().getIme();
                String p = Sesija.getInstance().getPrijavljeniKorisnik().getPrezime();
                String ki = Sesija.getInstance().getPrijavljeniKorisnik().getKorisnickoIme();
                String s = Sesija.getInstance().getPrijavljeniKorisnik().getSifra();
                String e = Sesija.getInstance().getPrijavljeniKorisnik().getEmailKor();

                txtIme.setText(i);
                txtPrezime.setText(p);
                txtKorisnickoIme.setText(ki);
                txtSifra.setText(s);
                txtEmail.setText(e);

                txtEmail.setEditable(true);
                txtPrezime.setEditable(true);
                txtIme.setEditable(true);
                txtSifra.setEditable(true);
                txtKorisnickoIme.setEditable(true);

                setTitle("Ažuriranje naloga");
                break;
        }

    }
}
