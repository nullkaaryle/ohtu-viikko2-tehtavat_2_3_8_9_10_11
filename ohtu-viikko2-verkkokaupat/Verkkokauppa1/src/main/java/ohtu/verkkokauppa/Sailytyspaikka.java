package ohtu.verkkokauppa;

public interface Sailytyspaikka {
    
    void palautaVarastoon(Tuote t);
    
    void otaVarastosta(Tuote t);
    
    int saldo(int id);
    
    Tuote haeTuote(int id);
    
}
