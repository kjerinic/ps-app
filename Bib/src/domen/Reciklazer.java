package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reciklazer extends ApstraktniDomenskiObjekat implements Serializable {

    private int reciklazerID;
    private String nazivReciklazera;
    private String opisReciklazera;
    private String email;
    private Kategorija kategorija;
    private Korisnik korisnik;

    public Reciklazer() {
    }

    public Reciklazer(int reciklazerID, String nazivReciklazera, String opisReciklazera, String email, Kategorija kategorija, Korisnik korisnikID) {
        this.reciklazerID = reciklazerID;
        this.nazivReciklazera = nazivReciklazera;
        this.opisReciklazera = opisReciklazera;
        this.email = email;
        this.kategorija = kategorija;
        this.korisnik = korisnikID;
    }

    @Override
    public String getNazivTabele() {
        return "reciklazer";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getListaObjekata(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int reciklazerID = rs.getInt("reciklazerID");
            String nazivReciklazera = rs.getString("nazivReciklazera");
            String opisReciklazera = rs.getString("opisReciklazera");
            String email = rs.getString("email");

            int kategorijaID = rs.getInt("kategorijaID");
            String nazivKategorije = rs.getString("nazivKategorije");

            Kategorija kat = new Kategorija(kategorijaID, nazivKategorije);

            int korisnikID = rs.getInt("korisnikID");
            String korisnickoIme = rs.getString("korisnickoIme");
            String sifra = rs.getString("sifra");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String emailKor = rs.getString("emailKor");

            Korisnik kor = new Korisnik(korisnikID, korisnickoIme, sifra, ime, prezime, emailKor);

            Reciklazer rec = new Reciklazer(reciklazerID, nazivReciklazera, opisReciklazera, email, kat, kor);
            lista.add(rec);
        }
        return lista;
    }

    @Override
    public ApstraktniDomenskiObjekat getObjekatIzRS(ResultSet rs) throws Exception {
        Reciklazer rec = null;
        if (rs.next()) {
            int reciklazerID = rs.getInt("reciklazerID");
            String nazivReciklazera = rs.getString("nazivReciklazera");
            String opisReciklazera = rs.getString("opisReciklazera");
            String email = rs.getString("email");

            int kategorijaID = rs.getInt("kategorijaID");
            String nazivKategorije = rs.getString("nazivKategorije");

            Kategorija kat = new Kategorija(kategorijaID, nazivKategorije);

            int korisnikID = rs.getInt("korisnikID");
            String korisnickoIme = rs.getString("korisnickoIme");
            String sifra = rs.getString("sifra");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String emailKor = rs.getString("emailKor");

            Korisnik kor = new Korisnik(korisnikID, korisnickoIme, sifra, ime, prezime, emailKor);

            rec = new Reciklazer(reciklazerID, nazivReciklazera, opisReciklazera, email, kat, kor);

        }
        return rec;
    }

    @Override
    public String getKoloneZaInsert() {
        return "nazivReciklazera, opisReciklazera, email, kategorijaID, korisnikID";
    }

    @Override
    public String getVrednostiZaInsert() {
        return "'" + nazivReciklazera + "', '" + opisReciklazera + "', '" + email + "', '" + kategorija.getKategorijaID() + "', '" + korisnik.getKorisnikID() + "'";
    }

    @Override
    public String getPrimarniKljuc() {
        return "reciklazerID = '" + reciklazerID + "'";
    }

    @Override
    public String getVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getReciklazerID() {
        return reciklazerID;
    }

    public void setReciklazerID(int reciklazerID) {
        this.reciklazerID = reciklazerID;
    }

    public String getNazivReciklazera() {
        return nazivReciklazera;
    }

    public void setNazivReciklazera(String nazivReciklazera) {
        this.nazivReciklazera = nazivReciklazera;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpisReciklazera() {
        return opisReciklazera;
    }

    public void setOpisReciklazera(String opisReciklazera) {
        this.opisReciklazera = opisReciklazera;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reciklazer other = (Reciklazer) obj;
        if (!Objects.equals(this.nazivReciklazera, other.nazivReciklazera)) {
            return false;
        }
        if (!Objects.equals(this.opisReciklazera, other.opisReciklazera)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.kategorija, other.kategorija)) {
            return false;
        }
        return true;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

}
