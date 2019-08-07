package so.recikliranje;

import domen.ApstraktniDomenskiObjekat;
import domen.Recikliranje;
import java.util.ArrayList;
import so.ApstraktnaGenerickaOperacija;

public class DodajRecikliranjeSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void validiraj(Object entity) throws Exception {
        if (!(entity instanceof Recikliranje)) {
            throw new Exception("Objekat nije instanca klase Recikliranje!");
        }
    }

    @Override
    protected void izvrsi(Object entity, String keyword) throws Exception {
        dbb.ubaci((ApstraktniDomenskiObjekat) entity);
    }

}
