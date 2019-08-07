package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Kategorija extends ApstraktniDomenskiObjekat implements Serializable {

    private int kategorijaID;
    private String nazivKategorije;

    public Kategorija() {
    }

    public Kategorija(int kategorijaID, String nazivKategorije) {
        this.kategorijaID = kategorijaID;
        this.nazivKategorije = nazivKategorije;
    }

    public int getKategorijaID() {
        return kategorijaID;
    }

    public void setKategorijaID(int kategorijaID) {
        this.kategorijaID = kategorijaID;
    }

    public String getNazivKategorije() {
        return nazivKategorije;
    }

    public void setNazivKategorije(String nazivKategorije) {
        this.nazivKategorije = nazivKategorije;
    }

    @Override
    public String toString() {
        return nazivKategorije;
    }

    @Override
    public String getNazivTabele() {
        return "kategorija";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getListaObjekata(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            int kategorijaID = rs.getInt("kategorijaID");
            String nazivKategorije = rs.getString("nazivKategorije");

            Kategorija kategorija = new Kategorija(kategorijaID, nazivKategorije);
            lista.add(kategorija);
        }
        return lista;
    }

    @Override
    public ApstraktniDomenskiObjekat getObjekatIzRS(ResultSet rs) throws Exception {
        Kategorija kategorija = null;
        if (rs.next()) {
            int kategorijaID = rs.getInt("kategorijaID");
            String nazivKategorije = rs.getString("nazivKategorije");
            kategorija = new Kategorija(kategorijaID, nazivKategorije);
        }
        return kategorija;
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
        return "kategorijaID = '" + kategorijaID + "'";
    }

    @Override
    public String getVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
