package ohtuesimerkkiTest;

import java.util.*;
import ohtuesimerkki.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {

    Statistics stats;

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12)); //16
            players.add(new Player("Lemieux", "PIT", 45, 54)); //99
            players.add(new Player("Kurri", "EDM", 37, 53)); //90
            players.add(new Player("Yzerman", "DET", 42, 56)); //98
            players.add(new Player("Gretzky", "EDM", 35, 89)); //124

            return players;
        }
    };

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void pelaajanHakuPalauttaaPelaajanJosPelaajaOnListalla() {
        Player haettu = stats.search("urri");
        assertEquals(haettu.getName(), "Kurri");
    }

    @Test
    public void pelaajanHakuPalauttaaNullJosPelaajaEiOleListalla() {
        Player haettu = stats.search("aine");
        assertNull(haettu);
    }

    @Test
    public void joukkueenHakuLoytaaJasenet() {
        List<Player> joukkueEdmontonOilers = stats.team("EDM");
        assertEquals(joukkueEdmontonOilers.size(), 3);
    }

    @Test
    public void joukkuuenHakuPalauttaaTyhjanListanJosJaseniaEiLoydy() {
        List<Player> joukkueAnaheimDucks = stats.team("MDA");
        assertTrue(joukkueAnaheimDucks.isEmpty());
    }

    @Test
    public void paremmuusjarjestysToimii() {
        List<Player> kolmeParasta = stats.topScorers(3);
        assertEquals(kolmeParasta.get(0).getName(), "Gretzky");
        assertEquals(kolmeParasta.get(1).getName(), "Lemieux");
        assertEquals(kolmeParasta.get(2).getName(), "Yzerman");
    }

    @Test
    public void paremmuusjarjestysPoimiiVainHalutunMaaran() {
        List<Player> kolmeParasta = stats.topScorers(3);
        assertTrue(kolmeParasta.size() == 3);
    }

}
