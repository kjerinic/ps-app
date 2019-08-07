package db;

import db.konekcija.DBKonekcija;
import domen.ApstraktniDomenskiObjekat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class DBBroker {

    public List<ApstraktniDomenskiObjekat> vratiPoUslovu(ApstraktniDomenskiObjekat adobj, String join, String uslov) throws Exception {
        List<ApstraktniDomenskiObjekat> list = null;
        String upit = "SELECT * FROM " + adobj.getNazivTabele();
        if (join != null) {
            upit += join;
        }
        upit += " WHERE " + uslov;
        System.out.println(upit);
        Connection konekcija = DBKonekcija.getInstanca().getKonekcija();
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        list = adobj.getListaObjekata(rs);

        rs.close();
        st.close();

        return list;
    }

    public ApstraktniDomenskiObjekat vratiPoPrimarnomKljucu(ApstraktniDomenskiObjekat adobj, String join) throws Exception {
        ApstraktniDomenskiObjekat vraceniAdobj = null;
        String upit = "SELECT * FROM " + adobj.getNazivTabele();
        if (join != null) {
            upit += join;
        }
        upit += " WHERE " + adobj.getPrimarniKljuc();
        System.out.println(upit);
        Connection konekcija = DBKonekcija.getInstanca().getKonekcija();
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        vraceniAdobj = adobj.getObjekatIzRS(rs);

        rs.close();
        st.close();

        return vraceniAdobj;

    }

    public List<ApstraktniDomenskiObjekat> vratiSve(ApstraktniDomenskiObjekat adobj, String join) throws Exception {
        List<ApstraktniDomenskiObjekat> list = null;
        String upit = "SELECT * FROM " + adobj.getNazivTabele();

        if (join != null) {
            upit += join;
        }

        System.out.println(upit);
        Connection konekcija = DBKonekcija.getInstanca().getKonekcija();
        Statement st = konekcija.createStatement();
        ResultSet rs = st.executeQuery(upit);
        list = adobj.getListaObjekata(rs);

        rs.close();
        st.close();

        return list;
    }

    public void ubaci(ApstraktniDomenskiObjekat adobj) throws Exception {
        String upit = "INSERT INTO " + adobj.getNazivTabele() + "(" + adobj.getKoloneZaInsert()
                + ") VALUES(" + adobj.getVrednostiZaInsert() + ")";
        System.out.println(upit);
        Connection konekcija = DBKonekcija.getInstanca().getKonekcija();
        Statement st = konekcija.createStatement();
        st.executeUpdate(upit);
        st.close();
    }

    public void izmeni(ApstraktniDomenskiObjekat adobj) throws Exception {
        String upit = "UPDATE " + adobj.getNazivTabele() + " SET " + adobj.getVrednostiZaUpdate() + " WHERE " + adobj.getPrimarniKljuc();
        System.out.println(upit);
        Connection konekcija = DBKonekcija.getInstanca().getKonekcija();
        Statement st = konekcija.createStatement();
        st.executeUpdate(upit);
        st.close();
    }

    public void obrisi(ApstraktniDomenskiObjekat adobj) throws Exception {
        String upit = "DELETE FROM " + adobj.getNazivTabele()+ " WHERE " + adobj.getPrimarniKljuc();
        System.out.println(upit);
        Connection konekcija = DBKonekcija.getInstanca().getKonekcija();
        Statement st = konekcija.createStatement();
        st.executeUpdate(upit);
        st.close();
    }

}
