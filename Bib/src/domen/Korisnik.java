package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Korisnik extends ApstraktniDomenskiObjekat implements Serializable {

    private int korisnikID;
    private String korisnickoIme;
    private String sifra;
    private String ime;
    private String prezime;
    private String emailKor;

    public Korisnik() {

    }

    public Korisnik(int korisnikID, String korisnickoIme, String sifra, String ime, String prezime, String emailKor) {
        this.korisnikID = korisnikID;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
        this.emailKor = emailKor;
    }

    public int getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(int korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmailKor() {
        return emailKor;
    }

    public void setEmailKor(String emailKor) {
        this.emailKor = emailKor;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Korisnik) obj).getKorisnickoIme().equals(this.korisnickoIme);
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String getNazivTabele() {
        return "korisnik";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getListaObjekata(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int korisnikID = rs.getInt("korisnikID");
            String korisnickoIme = rs.getString("korisnickoIme");
            String sifra = rs.getString("sifra");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String emailKor = rs.getString("emailKor");

            Korisnik kor = new Korisnik(korisnikID, korisnickoIme, sifra, ime, prezime, emailKor);
            lista.add(kor);
        }
        return lista;
    }

    @Override
    public ApstraktniDomenskiObjekat getObjekatIzRS(ResultSet rs) throws Exception {
        Korisnik kor = null;
        if (rs.next()) {
            int korisnikID = rs.getInt("korisnikID");
            String korisnickoIme = rs.getString("korisnickoIme");
            String sifra = rs.getString("sifra");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String emailKor = rs.getString("emailKor");

            kor = new Korisnik(korisnikID, korisnickoIme, sifra, ime, prezime, emailKor);
        }
        return kor;
    }

    @Override
    public String getKoloneZaInsert() {
        return "ime, prezime, korisnickoIme, sifra, emailKor";
    }

    @Override
    public String getVrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', '" + korisnickoIme + "', '" + sifra + "', '" + emailKor + "'";
    }

    @Override
    public String getPrimarniKljuc() {
        return "korisnikID = '" + korisnikID + "'";
    }

    @Override
    public String getVrednostiZaUpdate() {
        return "ime = '" + ime + "', prezime = '" + prezime + "', korisnickoIme = '" + korisnickoIme + "', sifra = '" + sifra + "', emailKor = '" + emailKor + "'";
    }

}
