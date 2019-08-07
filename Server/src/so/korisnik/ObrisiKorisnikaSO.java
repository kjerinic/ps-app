package so.korisnik;

import domen.Korisnik;
import so.ApstraktnaGenerickaOperacija;

public class ObrisiKorisnikaSO extends ApstraktnaGenerickaOperacija {

    @Override
    protected void validiraj(Object entity) throws Exception {
        if (!(entity instanceof Korisnik)) {
            throw new Exception("Objekat nije instanca klase Korisnik!");
        }
    }

    @Override
    protected void izvrsi(Object entity, String keyword) throws Exception {
        int korisnikID = ((Korisnik) entity).getKorisnikID();
        String korisnickoIme = ((Korisnik) entity).getKorisnickoIme();
        String sifra = ((Korisnik) entity).getSifra();
        String ime = ((Korisnik) entity).getIme();
        String prezime = ((Korisnik) entity).getPrezime();
        String email = ((Korisnik) entity).getEmailKor();

        Korisnik kor = new Korisnik(korisnikID, korisnickoIme, sifra, ime, prezime, email);
        
        dbb.obrisi(kor);
    }

}
