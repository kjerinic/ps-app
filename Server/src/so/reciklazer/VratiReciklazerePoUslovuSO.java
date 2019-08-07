package so.reciklazer;

import domen.ApstraktniDomenskiObjekat;
import domen.Reciklazer;
import java.util.List;
import so.ApstraktnaGenerickaOperacija;

public class VratiReciklazerePoUslovuSO extends ApstraktnaGenerickaOperacija {

    private List<ApstraktniDomenskiObjekat> lista;

    @Override
    protected void validiraj(Object entity) throws Exception {
        if (!(entity instanceof Reciklazer)) {
            throw new Exception("Objekat nije instanca klase Reciklazer!");
        }
    }

    @Override
    protected void izvrsi(Object entity, String keyword) throws Exception {
        String join = " JOIN kategorija ON reciklazer.kategorijaID = kategorija.kategorijaID JOIN korisnik ON reciklazer.korisnikID = korisnik.korisnikID";

        String[] obaUslova = keyword.split(",");
        String kategorijaID = obaUslova[0];
        String terminPretrage = obaUslova[1];

        String uslov = "";
        System.out.println("termin pretrage " + terminPretrage);

        if (!kategorijaID.equals("0")) {
            uslov += "kategorija.kategorijaID = '" + kategorijaID + "' ";
        }

        if (!terminPretrage.equals("x")) {
            if (!uslov.isEmpty()) {
                uslov += " AND ";
            }
            uslov += "reciklazer.nazivReciklazera LIKE '%" + terminPretrage + "%' ";
        } else {
            if (!uslov.isEmpty()) {
                uslov += " AND ";
            }

            uslov += "reciklazer.nazivReciklazera LIKE '%" + "" + "%' ";

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
