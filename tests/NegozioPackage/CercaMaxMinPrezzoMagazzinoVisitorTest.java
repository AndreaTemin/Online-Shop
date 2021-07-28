package NegozioPackage;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.function.BiFunction;

import static org.junit.Assert.*;

/**
 * Created by LorenzoMorandi on 26/01/17.
 */
public class CercaMaxMinPrezzoMagazzinoVisitorTest {

    CercaMaxMinMagazzinoABSVisitorMagazzino visitor;
    Warehouse magazzino= Magazzino.getInstance();

    public CercaMaxMinPrezzoMagazzinoVisitorTest() throws Exception {

        magazzino.resetMagazzino();

        visitor= new CercaMaxMinPrezzoMagazzinoVisitorMagazzino();

        Item i1= new ArticoloSingolo("Nome","Descrizione",40);
        Item i2= new ArticoloSingolo("Nome1","Descrizione1",41);

        Item i3= new Pacchetto();
        i3.inserisciArticolo(i2);
        i3.inserisciArticolo(i1);

        OggettoImmagazzinabile ogg= new RegistroMagazzino(40,i3,50);
        OggettoImmagazzinabile ogg1= new RegistroMagazzino(23,i2,90);

        magazzino.inserisciMerce(ogg);
        magazzino.inserisciMerce(ogg1);
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGetMinFunction() throws Exception {
        BiFunction<OggettoImmagazzinabile,OggettoImmagazzinabile,Boolean> f1= (tmpMax,valutare)->tmpMax.getOggetto().getTotal()>valutare.getOggetto().getTotal();

        BiFunction<OggettoImmagazzinabile,OggettoImmagazzinabile,Boolean> f2=visitor.creaLambdaMin();

        Item i1= new ArticoloSingolo("Nome","Descrizione",40);
        Item i2= new ArticoloSingolo("Nome1","Descrizione1",41);

        Item i3= new Pacchetto();
        i3.inserisciArticolo(i2);
        i3.inserisciArticolo(i1);

        OggettoImmagazzinabile ogg= new RegistroMagazzino(40,i3,50);
        OggettoImmagazzinabile ogg1= new RegistroMagazzino(23,i2,90);


        assertEquals(valutaFunzione(f1,ogg,ogg1),valutaFunzione(f2,ogg,ogg1));
        assertEquals(valutaFunzione(f1,ogg1,ogg),valutaFunzione(f2,ogg1,ogg));


    }

    @Test
    public void testGetMaxFunction() throws Exception {
        BiFunction<OggettoImmagazzinabile,OggettoImmagazzinabile,Boolean> f1= (tmpMin,valutare)->tmpMin.getOggetto().getTotal()<valutare.getOggetto().getTotal();;

        BiFunction<OggettoImmagazzinabile,OggettoImmagazzinabile,Boolean> f2=visitor.creaLambdaMax();

        Item i1= new ArticoloSingolo("Nome","Descrizione",40);
        Item i2= new ArticoloSingolo("Nome1","Descrizione1",41);

        Item i3= new Pacchetto();
        i3.inserisciArticolo(i2);
        i3.inserisciArticolo(i1);

        OggettoImmagazzinabile ogg= new RegistroMagazzino(40,i3,50);
        OggettoImmagazzinabile ogg1= new RegistroMagazzino(23,i2,90);


        assertEquals(valutaFunzione(f1,ogg,ogg1),valutaFunzione(f2,ogg,ogg1));
        assertEquals(valutaFunzione(f1,ogg1,ogg),valutaFunzione(f2,ogg1,ogg));


    }

    private boolean valutaFunzione(BiFunction<OggettoImmagazzinabile, OggettoImmagazzinabile, Boolean> function,
                                   OggettoImmagazzinabile ogg, OggettoImmagazzinabile ogg1) {
        return function.apply(ogg,ogg1);
    }


    @Test
    public void toStringTest() throws Exception
    {
        magazzino.accettaVisitor(visitor);

        String attesa="<html>Risultati ricerca per prezzo:<br> Elemento con valore piu elevato: Codice: 40Nome: Nome1 " +
                "Nome Prezzo: 81.0 Quantità: 50<br> Elemento con valore minore: Codice: 23 Nome: Nome1, Prezzo: 41.0 " +
                "Quantità: 90</html>";

        assertEquals(attesa, visitor.toString());

    }

}