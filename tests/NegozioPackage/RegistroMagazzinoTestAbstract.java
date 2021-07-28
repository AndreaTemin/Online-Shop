package NegozioPackage;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by LorenzoMorandi on 24/01/17.
 */
public abstract class RegistroMagazzinoTestAbstract {

    private RegistroMagazzino registroMagazzino;
    private int cod=10;
    private int giacenza=20;
    private Item oggetto;


    public RegistroMagazzinoTestAbstract() {

    }

    @Before
    public  void setUp() throws Exception
    {
        registroMagazzino= new RegistroMagazzino(cod,oggetto,giacenza);
    }

    @Test
    public void equals() throws Exception
    {
        assertEquals(true,registroMagazzino.equals(registroMagazzino));
    }

    @Test
    public void getCodice() throws Exception
    {
        assertEquals(cod,registroMagazzino.getCodice());
    }

    @Test
    public void getQuantita() throws Exception
    {
        setUp();

        assertEquals(giacenza,registroMagazzino.getQuantita());

    }

    @Test
    public void setQuantita() throws Exception
    {
        registroMagazzino.setQuantita(34);

        assertEquals(34,registroMagazzino.getQuantita());
    }

    @Test
    public void getOggetto() throws Exception
    {
        assertEquals(true,oggetto.equals(registroMagazzino.getOggetto()));
    }

    @Test
    public void decrementaQuantitaTest() throws Exception
    {
        setUp();

        boolean rst= registroMagazzino.decrementaQuantita(10);

        assertEquals(giacenza-10,registroMagazzino.getQuantita());
        assertEquals(true,rst);

    }

    @Test
    public void decrementaQuantitaTestFalse() throws Exception
    {
        setUp();

        boolean rst= registroMagazzino.decrementaQuantita(40);

        assertEquals(giacenza,registroMagazzino.getQuantita());
        assertEquals(false,rst);

    }

    @Test
    public abstract void toStringTest() throws Exception;

    @Test
    public void incrementaQuantitaTest() throws Exception
    {
        setUp();
        registroMagazzino.incrementaQuantita(10);

        assertEquals(giacenza+10 ,registroMagazzino.getQuantita());


    }

    @Test
    public void cloneTest() throws Exception
    {
        setUp();
        RegistroMagazzino clonato= registroMagazzino.clone();

        boolean rst= registroMagazzino.getClass()==clonato.getClass();

        assertEquals(true,rst);

        rst= clonato!=registroMagazzino;

        assertEquals(true,rst);

    }

    @Test
    public void setOggettoTest() throws Exception
    {
        registroMagazzino.setOggetto(oggetto);
        assertEquals(true,oggetto.equals(registroMagazzino.getOggetto()));
    }

    public void setOggetto(Item oggetto) {
        this.oggetto = oggetto;
    }

    public RegistroMagazzino getRegistroMagazzino() {
        return registroMagazzino;
    }
}
