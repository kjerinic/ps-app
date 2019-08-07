package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

public abstract class ApstraktniDomenskiObjekat {

    public abstract String getNazivTabele();

    public abstract List<ApstraktniDomenskiObjekat> getListaObjekata(ResultSet rs) throws Exception;

    public abstract String getKoloneZaInsert();

    public abstract String getVrednostiZaInsert();

    public abstract String getPrimarniKljuc();

    public ApstraktniDomenskiObjekat getObjekatIzRS(ResultSet rs) throws Exception {
        return null;
    }

    public abstract String getVrednostiZaUpdate();

}
