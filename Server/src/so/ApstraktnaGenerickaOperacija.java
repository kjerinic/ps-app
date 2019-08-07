package so;

import db.DBBroker;
import db.konekcija.DBKonekcija;

public abstract class ApstraktnaGenerickaOperacija {
        protected DBBroker dbb;

    public ApstraktnaGenerickaOperacija() {
        dbb = new DBBroker();
    }
    
    public final void templateExecute(Object entity, String keyword) throws Exception {
        try {
            validiraj(entity);
            zapocniTransakciju();
            izvrsi(entity, keyword);
            potvrdiTransakciju();
        } catch (Exception ex) {
            ponistiTransakciju();
            throw ex;
        }
    }
    
    protected abstract void validiraj(Object entity) throws Exception;

    protected abstract void izvrsi(Object entity, String keyword) throws Exception;

    private void zapocniTransakciju() throws Exception {
        DBKonekcija.getInstanca().getKonekcija().setAutoCommit(false);
    }

    private void potvrdiTransakciju() throws Exception {
        DBKonekcija.getInstanca().potvrdiTransakciju();
    }

    private void ponistiTransakciju() throws Exception {
        DBKonekcija.getInstanca().ponistiTransakciju();
    }

}
