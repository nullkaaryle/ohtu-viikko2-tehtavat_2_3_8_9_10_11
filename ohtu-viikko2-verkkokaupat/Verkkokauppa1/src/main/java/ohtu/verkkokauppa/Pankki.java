package ohtu.verkkokauppa;

public class Pankki implements Maksujenkasittelija {

    private static Pankki instanssi;
    private Kirjanpito kirjanpito;

    public Pankki() {
        kirjanpito = Kirjanpito.getInstance();
    }

    public static Pankki getInstance() {
        if (instanssi == null) {
            instanssi = new Pankki();
        }

        return instanssi;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
