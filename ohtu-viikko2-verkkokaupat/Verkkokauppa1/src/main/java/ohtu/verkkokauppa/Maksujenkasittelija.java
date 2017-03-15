package ohtu.verkkokauppa;

public interface Maksujenkasittelija {

    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
    
}
