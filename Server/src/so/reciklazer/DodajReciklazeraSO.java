package so.reciklazer;

import domen.Reciklazer;
import so.ApstraktnaGenerickaOperacija;

public class DodajReciklazeraSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void validiraj(Object entity) throws Exception {
        if (!(entity instanceof Reciklazer)) {
            throw new Exception("Objekat nije instanca klase Reciklazer!");
        }
    }

    @Override
    protected void izvrsi(Object entity, String keyword) throws Exception {
        Reciklazer reciklazer = (Reciklazer) entity;
        dbb.ubaci(reciklazer);
    }

}
