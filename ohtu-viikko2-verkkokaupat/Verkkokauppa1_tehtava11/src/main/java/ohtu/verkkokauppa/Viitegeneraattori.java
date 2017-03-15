package ohtu.verkkokauppa;

import org.springframework.stereotype.Component;

@Component
public class Viitegeneraattori implements UudenLuova {

    private int seuraava;

    public Viitegeneraattori() {
        seuraava = 1;
    }

    @Override
    public int uusi() {
        return seuraava++;
    }
}
