package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Ambalaza extends ApstraktniDomenskiObjekat implements Serializable {

    private int ambalazaID;
    private String nazivAmbalaze;
    private ReciklazniKod reciklazniKod;
    private Korisnik korisnikID;

    public Ambalaza() {
    }

    public Ambalaza(int ambalazaID, String nazivAmbalaze, ReciklazniKod reciklazniKod, Korisnik korisnikID) {
        this.ambalazaID = ambalazaID;
        this.nazivAmbalaze = nazivAmbalaze;
        this.reciklazniKod = reciklazniKod;
        this.korisnikID = korisnikID;
    }

    public int getAmbalazaID() {
        return ambalazaID;
    }

    public void setAmbalazaID(int ambalazaID) {
        this.ambalazaID = ambalazaID;
    }

    public String getNazivAmbalaze() {
        return nazivAmbalaze;
    }

    public void setNazivAmbalaze(String nazivAmbalaze) {
        this.nazivAmbalaze = nazivAmbalaze;
    }

    public ReciklazniKod getReciklazniKod() {
        return reciklazniKod;
    }

    public void setReciklazniKod(ReciklazniKod reciklazniKod) {
        this.reciklazniKod = reciklazniKod;
    }

    public Korisnik getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(Korisnik korisnikID) {
        this.korisnikID = korisnikID;
    }

    @Override
    public String getNazivTabele() {
        return "ambalaza";
    }

    @Override
    public String toString() {
        return "Ambalaza{" + "ambalazaID=" + ambalazaID + ", nazivAmbalaze=" + nazivAmbalaze + ", reciklazniKod=" + reciklazniKod.getSlova() + ", korisnikID=" + korisnikID.getIme() + '}';
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getListaObjekata(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int ambalazaID = rs.getInt("ambalazaID");
            String nazivAmbalaze = rs.getString("nazivAmbalaze");

            int kod = rs.getInt("reciklazniKod");
            String slova = rs.getString("slova");

            int kategorijaID = rs.getInt("kategorijaID");
            String nazivKategorije = rs.getString("nazivKategorije");
            Kategorija kat = new Kategorija(kategorijaID, nazivKategorije);

            ReciklazniKod reciklazniKod = new ReciklazniKod(kod, slova, kat);

            int korisnikID = rs.getInt("korisnikID");
            String korisnickoIme = rs.getString("korisnickoIme");
            String sifra = rs.getString("sifra");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String emailKor = rs.getString("emailKor");

            Korisnik kor = new Korisnik(korisnikID, korisnickoIme, sifra, ime, prezime, emailKor);

            Ambalaza ambalaza = new Ambalaza(ambalazaID, nazivAmbalaze, reciklazniKod, kor);

            lista.add(ambalaza);
        }
        

        return lista;

    }

    @Override
    public ApstraktniDomenskiObjekat getObjekatIzRS(ResultSet rs) throws Exception {
        Ambalaza ambalaza = null;

        while (rs.next()) {
            int ambalazaID = rs.getInt("ambalazaID");
            String nazivAmbalaze = rs.getString("nazivAmbalaze");

            int kod = rs.getInt("reciklazniKod");
            String slova = rs.getString("slova");

            int kategorijaID = rs.getInt("kategorijaID");
            String nazivKategorije = rs.getString("nazivKategorije");
            Kategorija kat = new Kategorija(kategorijaID, nazivKategorije);

            ReciklazniKod reciklazniKod = new ReciklazniKod(kod, slova, kat);

            int korisnikID = rs.getInt("korisnikID");
            String korisnickoIme = rs.getString("korisnickoIme");
            String sifra = rs.getString("sifra");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String emailKor = rs.getString("emailKor");

            Korisnik kor = new Korisnik(korisnikID, korisnickoIme, sifra, ime, prezime, emailKor);

            ambalaza = new Ambalaza(ambalazaID, nazivAmbalaze, reciklazniKod, kor);
        }

        return ambalaza;
    }

    @Override
    public String getKoloneZaInsert() {
        return "nazivAmbalaze, reciklazniKod, korisnikID";
    }

    @Override
    public String getVrednostiZaInsert() {
        return "'" + nazivAmbalaze + "', '" + reciklazniKod.getKod() + "', '" + korisnikID.getKorisnikID() + "'";
    }

    @Override
    public String getPrimarniKljuc() {
        return "ambalazaID = '" + ambalazaID + "'";
    }

    @Override
    public String getVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
