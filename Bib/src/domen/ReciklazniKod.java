package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReciklazniKod extends ApstraktniDomenskiObjekat implements Serializable {

    private int kod;
    private String slova;
    private Kategorija kategorija;

    public ReciklazniKod() {
    }

    public ReciklazniKod(int kod, String slova, Kategorija kategorija) {
        this.kod = kod;
        this.slova = slova;
        this.kategorija = kategorija;
    }

    public int getKod() {
        return kod;
    }

    public void setKod(int kod) {
        this.kod = kod;
    }

    public String getSlova() {
        return slova;
    }

    public void setSlova(String slova) {
        this.slova = slova;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    @Override
    public String getNazivTabele() {
        return "reciklaznikod";
    }

    @Override
    public String toString() {
        return kod + " " + slova;
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getListaObjekata(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int kod = rs.getInt("kod");
            String slova = rs.getString("slova");

            int kategorijaID = rs.getInt("kategorijaID");
            String nazivKategorije = rs.getString("nazivKategorije");
            Kategorija kat = new Kategorija(kategorijaID, nazivKategorije);

            ReciklazniKod reciklazniKod = new ReciklazniKod(kod, slova, kat);

            lista.add(reciklazniKod);
        }
        return lista;
    }

    @Override
    public ApstraktniDomenskiObjekat getObjekatIzRS(ResultSet rs) throws Exception {
        ReciklazniKod reciklazniKod = null;
        if (rs.next()) {
            int kod = rs.getInt("kod");
            String slova = rs.getString("slova");

            int kategorijaID = rs.getInt("kategorijaID");
            String nazivKategorije = rs.getString("nazivKategorije");
            Kategorija kat = new Kategorija(kategorijaID, nazivKategorije);

            reciklazniKod = new ReciklazniKod(kod, slova, kat);
        }
        return reciklazniKod;

    }
    
    @Override
    public String getKoloneZaInsert() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getVrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getPrimarniKljuc() {
        return "reciklaznikod.kod = " + this.kod + "'";
    }

    @Override
    public String getVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
