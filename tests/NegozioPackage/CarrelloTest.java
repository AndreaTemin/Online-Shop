package NegozioPackage;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.function.Function;

import static org.junit.Assert.*;

/**
 * Created by LorenzoMorandi on 25/01/17.
 */
public class CarrelloTest {


    private CarrelloInterface carrello;

    @Before
    public void setUp() throws Exception {
        carrello= new Carrello();

    }

    @Test
    public void inserisciArticolo1() throws Exception
    {

        OggettoImmagazzinabile ogg= new RegistroMagazzino(1,new ArticoloSingolo("Nome","Descrizione",20),40);
        OggettoImmagazzinabile ogg2= new RegistroMagazzino(1,new ArticoloSingolo("Nome","Descrizione",20),1);

        //Inserimento di un oggetto gia presente nel carrello
        carrello.inserisciArticolo(ogg);
        carrello.inserisciArticolo(ogg2);

        Iterator<OggettoImmagazzinabile> it= carrello.getIteretor();
        OggettoImmagazzinabile daValutare= it.next();

        assertEquals(41,daValutare.getQuantita());

    }

    @Test
    public void inserisciArticolo2() throws Exception
    {

        OggettoImmagazzinabile ogg= new RegistroMagazzino(1,new ArticoloSingolo("Nome","Descrizione",20),40);
        OggettoImmagazzinabile ogg2= new RegistroMagazzino(4,new ArticoloSingolo("Nome","Descrizione",20),1);

        //Inserimento di un oggetto gia presente nel carrello
        carrello.inserisciArticolo(ogg);
        carrello.inserisciArticolo(ogg2);

        Iterator<OggettoImmagazzinabile> it= carrello.getIteretor();
        OggettoImmagazzinabile daValutare= it.next();

        assertEquals(40,daValutare.getQuantita());

        daValutare=it.next();
        assertEquals(1,daValutare.getQuantita());

    }

    @Test
    public void rimuoviArticolo1() throws Exception {

        OggettoImmagazzinabile ogg= new RegistroMagazzino(7,new ArticoloSingolo("Nome","Descrizione",20),40);
        carrello.inserisciArticolo(ogg);

        ogg= new RegistroMagazzino(3,new ArticoloSingolo("Nome","Descrizione",10),1);
        carrello.inserisciArticolo(ogg);

        //Eliminazione di un item con giacenza 1

        carrello.rimuoviArticolo(1);

        int qntaItem = getQntaItem(carrello.getIteretor());

        assertEquals(1,qntaItem);

    }

    @Test
    public void rimuoviArticolo2() throws Exception {

        OggettoImmagazzinabile ogg= new RegistroMagazzino(7,new ArticoloSingolo("Nome","Descrizione",20),40);
        carrello.inserisciArticolo(ogg);

        ogg= new RegistroMagazzino(3,new ArticoloSingolo("Nome","Descrizione",10),3);
        carrello.inserisciArticolo(ogg);

        //Eliminazione di un item con giacenza maggiore di uno

        carrello.rimuoviArticolo(1);

        int qntaItem = getQntaItem(carrello.getIteretor());

        assertEquals(2,qntaItem);

    }

    @Test
    public void getTotal() throws Exception {

        OggettoImmagazzinabile ogg= new RegistroMagazzino(7,new ArticoloSingolo("Nome","Descrizione",20),40);
        carrello.inserisciArticolo(ogg);

        ogg= new RegistroMagazzino(3,new ArticoloSingolo("Nome","Descrizione",10),20);
        carrello.inserisciArticolo(ogg);


        assertEquals(1000,carrello.getTotal(),0.20);

    }

    @Test
    public void applicaSconto() throws Exception {

        OggettoImmagazzinabile ogg= new RegistroMagazzino(7,new ArticoloSingolo("Nome","Descrizione",20),40);
        carrello.inserisciArticolo(ogg);

        ogg= new RegistroMagazzino(3,new ArticoloSingolo("Nome","Descrizione",10),20);
        carrello.inserisciArticolo(ogg);

        Function<OggettoImmagazzinabile,OggettoImmagazzinabile> applicaSconto= (daScontare)->
        {
            Item tmp = daScontare.getOggetto();
            tmp = new ScontoUniversitariDecorator(tmp);
            daScontare.setOggetto(tmp);
            return daScontare;
        };

        carrello.applicaSconto(applicaSconto);

        //Sconto applicato del 20%

        assertEquals(800,carrello.getTotal(),1.0);

    }

    private int getQntaItem(Iterator<OggettoImmagazzinabile> it) {
        int qntaItem=0;
        while(it.hasNext())
        {
            qntaItem++;
            it.next();
        }
        return qntaItem;
    }


}