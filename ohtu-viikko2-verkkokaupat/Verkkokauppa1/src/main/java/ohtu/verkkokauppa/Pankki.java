package ohtu.verkkokauppa;

public class Pankki implements Maksujenkasittelija {

    private Kirjaaja kirjaaja;

    public Pankki(Kirjaaja kirjaaja) {
        this.kirjaaja = kirjaaja;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjaaja.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
