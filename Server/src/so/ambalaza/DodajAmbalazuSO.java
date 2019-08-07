package so.ambalaza;

import domen.Ambalaza;
import domen.ApstraktniDomenskiObjekat;
import so.ApstraktnaGenerickaOperacija;

public class DodajAmbalazuSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void validiraj(Object entity) throws Exception {
        if (!(entity instanceof Ambalaza)) {
            throw new Exception("Objekat nije instanca klase Ambalaza!");
        }
    }

    @Override
    protected void izvrsi(Object entity, String keyword) throws Exception {
        dbb.ubaci((ApstraktniDomenskiObjekat) entity);
    }

}
