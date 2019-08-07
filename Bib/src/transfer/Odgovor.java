package transfer;

import java.io.Serializable;

public class Odgovor implements Serializable {
    private int operacija;
    private Object podaci;
    private int statusniKod;

    public Odgovor() {
    }

    public Odgovor(int operacija, Object podaci, int statusniKod) {
        this.operacija = operacija;
        this.podaci = podaci;
        this.statusniKod = statusniKod;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getPodaci() {
        return podaci;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

    public int getStatusniKod() {
        return statusniKod;
    }

    public void setStatusniKod(int statusniKod) {
        this.statusniKod = statusniKod;
    }    
    
}
