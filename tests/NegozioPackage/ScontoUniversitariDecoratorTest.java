package NegozioPackage;

import NegozioPackage.ArticoloSingolo;
import NegozioPackage.Item;
import NegozioPackage.Pacchetto;
import NegozioPackage.ScontoUniversitariDecorator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by LorenzoMorandi on 14/12/16.
 */
public class ScontoUniversitariDecoratorTest
{
    Item ogg, composto;

    @org.junit.Before
    public void setUp() throws Exception
    {
        ogg= new ArticoloSingolo("nome","Desc",100);
        composto =new Pacchetto();

        composto.inserisciArticolo(ogg);
        composto.inserisciArticolo(ogg);

    }

    @Test
    public void testDecoraArticoloSingolo() throws Exception
    {
        Item dec= new ScontoUniversitariDecorator(ogg);

        assertEquals(80.0,dec.getTotal(),0.0);
    }

    @Test
    public void testDecoraPacchetto() throws Exception
    {
        Item dec= new ScontoUniversitariDecorator(composto);

        assertEquals(160,dec.getTotal(),0.0);
    }

    @Test
    public void getNome()
    {
        assertEquals("nome",ogg.getNome());
    }

    @Test
    public void getNomePacchetto()
    {
        assertEquals(" nome nome",composto.getNome());
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
    public void getTotal() throws Exception {
       assertEquals(100,ogg.getTotal(),0.0);
    }

    @Test
    public void cloneTest() throws Exception {

        Item clonato= ogg.clone();

        boolean rst= ogg!=clonato;

        assertEquals(true,rst);

        rst= ogg.getClass()==clonato.getClass();

        assertEquals(true,rst);

    }

}