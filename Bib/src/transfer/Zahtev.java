package transfer;

import java.io.Serializable;

public class Zahtev implements Serializable {
    private int operacija;
    private Object podaci;

    public Zahtev() {
    }

    public Zahtev(int operacija, Object podaci) {
        this.operacija = operacija;
        this.podaci = podaci;
    }

    public Object getPodaci() {
        return podaci;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }
    
    
}
