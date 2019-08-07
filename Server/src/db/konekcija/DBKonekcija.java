package db.konekcija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import konfiguracija.Konfiguracija;

public class DBKonekcija {

    private static DBKonekcija instanca;
    private final Connection konekcija;

    private DBKonekcija() throws SQLException {
        String url = Konfiguracija.getInstance().getProperty("url");
        String user = Konfiguracija.getInstance().getProperty("user");
        String password = Konfiguracija.getInstance().getProperty("password");
        konekcija = DriverManager.getConnection(url, user, password);
        konekcija.setAutoCommit(false);
    }

    public static DBKonekcija getInstanca() throws SQLException {
        if (instanca == null) {
            instanca = new DBKonekcija();
        }
        return instanca;
    }

    public Connection getKonekcija() {
        return konekcija;
    }

    public void potvrdiTransakciju() throws SQLException {
        konekcija.commit();
    }

    public void ponistiTransakciju() throws SQLException {
        konekcija.rollback();
    }
}
