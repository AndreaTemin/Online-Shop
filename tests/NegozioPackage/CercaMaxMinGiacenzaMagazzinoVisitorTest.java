package NegozioPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.Assert.*;

/**
 * Created by LorenzoMorandi on 26/01/17.
 */
public class CercaMaxMinGiacenzaMagazzinoVisitorTest {

    CercaMaxMinMagazzinoABSVisitorMagazzino visitor;
    Warehouse magazzino= Magazzino.getInstance();

    @Before
    public void setUp() throws Exception {

        magazzino.resetMagazzino();

        visitor= new CercaMaxMinGiacenzaMagazzinoVisitorMagazzino();

        Item i1= new ArticoloSingolo("Nome","Descrizione",10);
        Item i2= new ArticoloSingolo("Nome1","Descrizione1",30);

        Item i3= new Pacchetto();
        i3.inserisciArticolo(i2);
        i3.inserisciArticolo(i1);

        OggettoImmagazzinabile ogg= new RegistroMagazzino(1,i3,10);
        OggettoImmagazzinabile ogg1= new RegistroMagazzino(2,i2,40);


        magazzino.inserisciMerce(ogg);
        magazzino.inserisciMerce(ogg1);

    }

    @Test
    public void toStringTest() throws Exception {

        String attesa= "<html>Risultati ricerca per giacenza: <BR>Elemento con valore piu elevato: Codice: 2 " +
                "Nome: Nome1, Prezzo: 30.0 Quantità: 40<br> Elemento con valore minore: Codice: 1Nome: Nome1 Nome" +
                " Prezzo: 40.0 Quantità: 10</html>";

        magazzino.accettaVisitor(visitor);

        assertEquals(attesa,visitor.toString());

    }


}