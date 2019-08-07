package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Recikliranje extends ApstraktniDomenskiObjekat implements Serializable {

    private int recikliranjeID;
    private Reciklazer reciklazerID;
    private Ambalaza ambalazaID;
    private Korisnik korisnikID;
    private String napomena;

    public Recikliranje() {
    }

    public Recikliranje(int recikliranjeID, Reciklazer reciklazerID, Ambalaza ambalazaID, Korisnik korisnikID, String napomena) {
        this.recikliranjeID = recikliranjeID;
        this.reciklazerID = reciklazerID;
        this.ambalazaID = ambalazaID;
        this.korisnikID = korisnikID;
        this.napomena = napomena;
    }

    public int getRecikliranjeID() {
        return recikliranjeID;
    }

    public void setRecikliranjeID(int recikliranjeID) {
        this.recikliranjeID = recikliranjeID;
    }

    public Reciklazer getReciklazerID() {
        return reciklazerID;
    }

    public void setReciklazerID(Reciklazer reciklazerID) {
        this.reciklazerID = reciklazerID;
    }

    public Ambalaza getAmbalazaID() {
        return ambalazaID;
    }

    public void setAmbalazaID(Ambalaza ambalazaID) {
        this.ambalazaID = ambalazaID;
    }

    public Korisnik getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(Korisnik korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    @Override
    public String getNazivTabele() {
        return "recikliranje";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> getListaObjekata(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getKoloneZaInsert() {
        return "reciklazerID, ambalazaID, korisnikID, napomena";
    }

    @Override
    public String getVrednostiZaInsert() {
        return "'" + reciklazerID.getReciklazerID() + "', '" + ambalazaID.getAmbalazaID() + "', '" + korisnikID.getKorisnikID() + "', '" + napomena + "'";
    }

    @Override
    public String getPrimarniKljuc() {
        return "ambalazaID = '" + ambalazaID + "'";
    }

    @Override
    public String getVrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        final Recikliranje other = (Recikliranje) obj;
        if (!Objects.equals(this.reciklazerID, other.reciklazerID)) {
            return false;
        }
        if (!Objects.equals(this.ambalazaID, other.ambalazaID)) {
            return false;
        }
        if (!Objects.equals(this.korisnikID, other.korisnikID)) {
            return false;
        }
        return true;
    }
    
    

}
