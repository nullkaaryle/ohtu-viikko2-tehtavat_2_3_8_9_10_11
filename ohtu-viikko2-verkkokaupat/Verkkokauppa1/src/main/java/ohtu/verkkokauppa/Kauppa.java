package ohtu.verkkokauppa;

public class Kauppa {

    private Sailytyspaikka sailytyspaikka;
    private Maksujenkasittelija maksujenkasittelija;
    private Ostoskori ostoskori;
    private UudenLuova uudenluova;
    private String kaupanTili;

    public Kauppa(Sailytyspaikka sailytyspaikka, Maksujenkasittelija maksujenkasittelija, UudenLuova uudenluova) {
        this.sailytyspaikka = sailytyspaikka;
        this.maksujenkasittelija = maksujenkasittelija;
        this.uudenluova = uudenluova;
        this.kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = sailytyspaikka.haeTuote(id); 
        sailytyspaikka.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (sailytyspaikka.saldo(id)>0) {
            Tuote t = sailytyspaikka.haeTuote(id);             
            ostoskori.lisaa(t);
            sailytyspaikka.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = uudenluova.uusi();
        int summa = ostoskori.hinta();
        
        return maksujenkasittelija.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
