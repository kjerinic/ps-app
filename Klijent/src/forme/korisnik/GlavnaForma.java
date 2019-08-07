package forme.korisnik;

import domen.Korisnik;
import forme.ambalaza.EnumFormaAmbalaza;
import forme.ambalaza.FormaPretraziAmbalaze;
import forme.reciklazer.EnumFormaReciklazer;
import forme.reciklazer.FormaPretraziReciklazere;
import forme.recikliranje.FormaDodajRecikliranje;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import konstante.UseCase;
import kontroler.Kontroler;
import sesija.Sesija;

public class GlavnaForma extends javax.swing.JFrame {

    Kontroler k;
    JDialog formaNapraviNalog;
    private FormaPretraziReciklazere formaPretraziReciklazere;
    private FormaPretraziAmbalaze formaPretraziAmbalaze;
    private FormaDodajRecikliranje formaDodajRecikliranje;

    public GlavnaForma() {
        initComponents();
        srediFormu();
        k = Kontroler.getInstanca();
    }

    public void setFormaNapraviNalog(JDialog formaNapraviNalog) {
        this.formaNapraviNalog = formaNapraviNalog;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        txtKorisnik = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnPretraziAmbalaze = new javax.swing.JButton();
        btnPretraziReciklazere = new javax.swing.JButton();
        btnDodajRecikliranje = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        itemProfil = new javax.swing.JMenu();
        itemMojProfil = new javax.swing.JMenuItem();
        itemOdjaviSe = new javax.swing.JMenuItem();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ucesnik");
        setName("Ucesnik"); // NOI18N

        txtKorisnik.setEditable(false);
        txtKorisnik.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KAKO RECIKLIRATI AMBALAŽU U SRBIJI?");

        btnPretraziAmbalaze.setText("Pretraži ambalaže");
        btnPretraziAmbalaze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziAmbalazeActionPerformed(evt);
            }
        });

        btnPretraziReciklazere.setText("Pretraži reciklažere");
        btnPretraziReciklazere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziReciklazereActionPerformed(evt);
            }
        });

        btnDodajRecikliranje.setText("Dodaj recikliranje");
        btnDodajRecikliranje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajRecikliranjeActionPerformed(evt);
            }
        });

        itemProfil.setText("Moj profil");

        itemMojProfil.setText("Moj profil");
        itemMojProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMojProfilActionPerformed(evt);
            }
        });
        itemProfil.add(itemMojProfil);

        itemOdjaviSe.setText("Odjavi se");
        itemOdjaviSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemOdjaviSeActionPerformed(evt);
            }
        });
        itemProfil.add(itemOdjaviSe);

        jMenuBar1.add(itemProfil);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPretraziAmbalaze)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDodajRecikliranje)
                        .addGap(84, 84, 84)
                        .addComponent(btnPretraziReciklazere))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtKorisnik, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtKorisnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPretraziAmbalaze)
                    .addComponent(btnPretraziReciklazere)
                    .addComponent(btnDodajRecikliranje))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPretraziReciklazereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziReciklazereActionPerformed
        this.formaPretraziReciklazere = new FormaPretraziReciklazere(EnumFormaReciklazer.ADD_NEW);
        Kontroler.getInstanca().setFormaPretraziReciklazere(formaPretraziReciklazere);
    }//GEN-LAST:event_btnPretraziReciklazereActionPerformed

    private void itemOdjaviSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemOdjaviSeActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Jeste li sigurni da zelite da se odjavite?", "Odjava", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.NO_OPTION) {
            return;
        } else {
            k.odjaviSe();
        }

    }//GEN-LAST:event_itemOdjaviSeActionPerformed

    private void itemMojProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMojProfilActionPerformed
        formaNapraviNalog = new FormaNapraviNalog(this, true, EnumFormaNalog.VIEW);
        formaNapraviNalog.setVisible(true);
    }//GEN-LAST:event_itemMojProfilActionPerformed

    private void btnPretraziAmbalazeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziAmbalazeActionPerformed
        formaPretraziAmbalaze = new FormaPretraziAmbalaze(EnumFormaAmbalaza.ADD_NEW);
        Kontroler.getInstanca().setFormaPretraziAmbalaze(formaPretraziAmbalaze);
    }//GEN-LAST:event_btnPretraziAmbalazeActionPerformed

    private void btnDodajRecikliranjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajRecikliranjeActionPerformed
        Sesija.getInstance().setCurrentUseCase(UseCase.DODAJ_RECIKLIRANJE);
        formaDodajRecikliranje = new FormaDodajRecikliranje();
        Kontroler.getInstanca().setFormaDodajRecikliranje(formaDodajRecikliranje);
    }//GEN-LAST:event_btnDodajRecikliranjeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajRecikliranje;
    private javax.swing.JButton btnPretraziAmbalaze;
    private javax.swing.JButton btnPretraziReciklazere;
    private javax.swing.JMenuItem itemMojProfil;
    private javax.swing.JMenuItem itemOdjaviSe;
    private javax.swing.JMenu itemProfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private java.awt.Label label1;
    private javax.swing.JTextField txtKorisnik;
    // End of variables declaration//GEN-END:variables

    private void srediFormu() {
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    public void postaviKorisnika(String korisnik) {
        txtKorisnik.setText(korisnik);
    }

    public void obavestiNeuspesnaIzmena() {
        JOptionPane.showMessageDialog(formaNapraviNalog, "Sistem ne može da zapamti korisnika.", "Greska", JOptionPane.ERROR_MESSAGE);
    }

    public void obavestiUspesnaIzmena() {
        JOptionPane.showMessageDialog(formaNapraviNalog, "Sistem je zapamtio korisnika", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
        formaNapraviNalog.dispose();
    }

    public void obavestiOdjavljivanje() {
        JOptionPane.showMessageDialog(this, "Odjavljivanje...", "Odjavljivanje", JOptionPane.INFORMATION_MESSAGE);
    }

    public void onemoguciAkciju() {
        JOptionPane.showMessageDialog(formaNapraviNalog, "Server se ugasio.", "Greska", JOptionPane.ERROR_MESSAGE);

        if (formaNapraviNalog != null && formaNapraviNalog.isVisible()) {
            formaNapraviNalog.dispose();
        }
        if (formaPretraziAmbalaze != null && formaPretraziAmbalaze.isVisible()) {
            formaPretraziAmbalaze.dispose();
        }
        if (formaPretraziReciklazere != null && formaPretraziReciklazere.isVisible()) {
            formaPretraziReciklazere.dispose();
        }

        this.dispose();
    }

    public void obavestiNeuspesnoBrisanje() {
        JOptionPane.showMessageDialog(formaNapraviNalog, "Sistem ne može da obriše korisnika.", "Greska", JOptionPane.ERROR_MESSAGE);
    }

    public void obavestiUspesnoBrisanje() {
        JOptionPane.showMessageDialog(formaNapraviNalog, "Sistem je obrisao korisnika.", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
        formaNapraviNalog.dispose();
    }

    public void obavestiGasenje() {
        JOptionPane.showMessageDialog(formaNapraviNalog, "Sistem se gasi..", "Greska", JOptionPane.ERROR_MESSAGE);

        if (formaNapraviNalog != null && formaNapraviNalog.isVisible()) {
            formaNapraviNalog.dispose();
        }
        if (formaPretraziReciklazere != null && formaPretraziReciklazere.isVisible()) {
            formaPretraziReciklazere.dispose();
        }
        if (formaPretraziAmbalaze != null && formaPretraziAmbalaze.isVisible()) {
            formaPretraziAmbalaze.dispose();
        }

        this.dispose();
    }

    public void obavestiUspesanUnosRecikliranja() {
        JOptionPane.showMessageDialog(this, "Sistem je zapamtio listu recikliranja", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
        formaDodajRecikliranje.dispose();
    }

    public void obavestiNeuspesanUnosRecikliranja() {
        JOptionPane.showMessageDialog(this, "Sistem ne može da zapamti listu recikliranja.", "Greska", JOptionPane.ERROR_MESSAGE);
    }


}
