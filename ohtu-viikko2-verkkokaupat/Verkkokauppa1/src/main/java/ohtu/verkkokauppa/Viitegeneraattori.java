package ohtu.verkkokauppa;

public class Viitegeneraattori implements UudenLuova {

    private int seuraava;
    private static Viitegeneraattori instanssi;

    private Viitegeneraattori() {
        seuraava = 1;
    }

    public static Viitegeneraattori getInstance() {
        if (instanssi == null) {
            instanssi = new Viitegeneraattori();
        }

        return instanssi;
    }

    @Override
    public int uusi() {
        return seuraava++;
    }
}
