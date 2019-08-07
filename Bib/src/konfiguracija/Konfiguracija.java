package konfiguracija;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Konfiguracija {

    private static Konfiguracija instance;
    private Properties properties;

    private Konfiguracija() {
        try {
            properties = new Properties();
            properties.load(new FileInputStream("../Bib/settings.properties"));
        } catch (IOException ex) {
            Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Konfiguracija getInstance() {
        if (instance == null) {
            instance = new Konfiguracija();
        }
        return instance;
    }

    public Properties getProperties() {
        return properties;
    }

    public String getProperty(String key) {
        return properties.getProperty(key, "n/a");
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public void sacuvajIzmene() {
        try {
            properties.store(new FileOutputStream("../Bib/settings.properties"), null);

        } catch (IOException ex) {
            Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
