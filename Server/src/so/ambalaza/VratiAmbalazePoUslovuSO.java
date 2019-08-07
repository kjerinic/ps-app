package so.ambalaza;

import domen.Ambalaza;
import domen.ApstraktniDomenskiObjekat;
import java.util.List;
import so.ApstraktnaGenerickaOperacija;

public class VratiAmbalazePoUslovuSO extends ApstraktnaGenerickaOperacija {

    private List<ApstraktniDomenskiObjekat> lista;

    @Override
    protected void validiraj(Object entity) throws Exception {
        if (!(entity instanceof Ambalaza)) {
            throw new Exception("Objekat nije instanca klase Ambalaza!");
        }
    }

    @Override
    protected void izvrsi(Object entity, String keyword) throws Exception {
        String join = " JOIN ReciklazniKod ON ambalaza.reciklazniKod = reciklaznikod.kod JOIN kategorija ON reciklaznikod.kategorijaID = kategorija.kategorijaID JOIN korisnik ON ambalaza.korisnikID = korisnik.korisnikID";

        String[] obaUslova = keyword.split(",");
        String kategorijaID = obaUslova[0];
        String terminPretrage = obaUslova[1];

        String uslov = "";
        System.out.println("Termin pretrage: " + terminPretrage);

        if (!kategorijaID.equals("0")) {
            uslov += "kategorija.kategorijaID = '" + kategorijaID + "' ";
        }

        if (!terminPretrage.equals("x")) {
            if (!uslov.isEmpty()) {
                uslov += " AND ";
            }
            uslov += "ambalaza.nazivAmbalaze LIKE '%" + terminPretrage + "%' ";
        } else {
            if (!uslov.isEmpty()) {
                uslov += " AND ";
            }
            uslov += "ambalaza.nazivAmbalaze LIKE '%" + "" + "%' ";
        }

        List<ApstraktniDomenskiObjekat> vracenaLista = dbb.vratiPoUslovu((ApstraktniDomenskiObjekat) entity, join, uslov);

        if (vracenaLista.isEmpty()) {
            lista = null;
        } else {
            lista = vracenaLista;
        }
    }

    public List<ApstraktniDomenskiObjekat> getLista() {
        return lista;
    }

}
