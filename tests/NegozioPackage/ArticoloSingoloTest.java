package NegozioPackage;

import NegozioPackage.ArticoloSingolo;
import NegozioPackage.Item;
import org.junit.*;

import static org.junit.Assert.*;


/**
 * Created by LorenzoMorandi on 08/12/16.
 */
public class ArticoloSingoloTest
{
    private ArticoloSingolo ogg;

    @Before
    public void setUpBeforeClass(){
        setUp();
    }

    private void setUp() {
        ogg = new ArticoloSingolo("NegozioPackage.Prova","Test",30);
    }

    @Test
    public void getPrezzo() throws Exception {
        setUp();
        Assert.assertEquals(30.0, ogg.getTotal(),0.0);
    }

    @Test
    public void getDescrizione() {
        assertEquals("Articolo: NegozioPackage.Prova, Descrizione: Test", ogg.getDescrizione());
    }

    @Test (expected = Exception.class)
    public void inserisciArticolo() throws Exception {
        ogg.inserisciArticolo(ogg);
    }

    @Test (expected = Exception.class)
    public void rimuoviArticolo() throws Exception {
        ogg.rimuoviArticolo(ogg);
    }

    @Test
    public void getNomeTrue()
    {
        setUp();
        assertEquals("NegozioPackage.Prova", ogg.getNome());
    }

    @Test
    public void cloneTest() throws Exception {

        Item clonato= ogg.clone();

        boolean rst= ogg.getClass()==clonato.getClass();

        assertEquals(true,rst);

        rst= clonato!=ogg;

        assertEquals(true,rst);

    }
}