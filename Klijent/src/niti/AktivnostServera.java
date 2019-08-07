package niti;

import konstante.StatusniKod;
import kontroler.Kontroler;
import sesija.Sesija;

public class AktivnostServera extends Thread {

    @Override
    public void run() {
        while (!isInterrupted()) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                //
            }

            if (Sesija.getInstance().getStatusServera() == StatusniKod.SERVER_AKTIVAN) {
                Kontroler.getInstanca().obavestiServerAktivan();
            }
            if (Sesija.getInstance().getStatusServera() == StatusniKod.SERVER_NEAKTIVAN) {
                Kontroler.getInstanca().obavestiServerNeaktivan();

            }
        }
    }

    public void zaustaviNit() {
        this.interrupt();
    }

}
