package so.reciklaznikod;

import domen.ApstraktniDomenskiObjekat;
import domen.ReciklazniKod;
import java.util.List;
import so.ApstraktnaGenerickaOperacija;

public class VratiListuReciklaznihKodovaSO extends ApstraktnaGenerickaOperacija {

    private List<ApstraktniDomenskiObjekat> lista;

    @Override
    protected void validiraj(Object entity) throws Exception {
        if (!(entity instanceof ReciklazniKod)) {
            throw new Exception("Objekat nije instanca klase ReciklazniKod!");
        }
    }

    @Override
    protected void izvrsi(Object entity, String keyword) throws Exception {
        String join = " JOIN kategorija ON reciklazniKod.kategorijaID = kategorija.kategorijaID";
        lista = dbb.vratiSve((ReciklazniKod) entity, join);
    }

    public List<ApstraktniDomenskiObjekat> getLista() {
        return lista;
    }

}
