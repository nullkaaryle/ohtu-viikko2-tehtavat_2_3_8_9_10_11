package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface Kirjaaja {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);

}
