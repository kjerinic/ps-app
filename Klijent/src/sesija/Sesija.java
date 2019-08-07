package sesija;

import domen.Korisnik;
import java.util.HashMap;
import java.util.Map;
import konstante.StatusniKod;


public class Sesija {
    private static Sesija instance;
    private Korisnik prijavljeniKorisnik;
    private int statusServera;
    private int currentUseCase;
    private final Map<String, Object> useCaseParams;
    
    private Sesija() {
       useCaseParams = new HashMap<>();
       statusServera = StatusniKod.SERVER_NEAKTIVAN;
    }
    
    public static Sesija getInstance() {
        if (instance == null) {
            instance = new Sesija();
        }
        return instance;
    }

    public Korisnik getPrijavljeniKorisnik() {
        return prijavljeniKorisnik;
    }

    public void setPrijavljeniKorisnik(Korisnik prijavljeniKorisnik) {
        this.prijavljeniKorisnik = prijavljeniKorisnik;
    }

    public int getStatusServera() {
        return statusServera;
    }

    public void setStatusServera(int statusServera) {
        this.statusServera = statusServera;
    }
    
    public int getCurrentUseCase() {
        return currentUseCase;
    }

    public void setCurrentUseCase(int currentUseCase) {
        this.currentUseCase = currentUseCase;
    }

    public Map<String, Object> getUseCaseParams() {
        return useCaseParams;
    }
}
