package so.korisnik;

import domen.Korisnik;
import so.ApstraktnaGenerickaOperacija;

public class NapraviNovogKorisnikaSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void validiraj(Object entity) throws Exception {
        if (!(entity instanceof Korisnik)) {
            throw new Exception("Objekat nije instanca klase Korisnik!");
        }
    }

    @Override
    protected void izvrsi(Object entity, String keyword) throws Exception {
        String korisnickoIme = ((Korisnik) entity).getKorisnickoIme();
        String sifra = ((Korisnik) entity).getSifra();
        String ime = ((Korisnik) entity).getIme();
        String prezime = ((Korisnik) entity).getPrezime();
        String email = ((Korisnik) entity).getEmailKor();
        
        Korisnik kor = new Korisnik(0, korisnickoIme, sifra, ime, prezime, email);
        
        dbb.ubaci(kor);
    }


}
