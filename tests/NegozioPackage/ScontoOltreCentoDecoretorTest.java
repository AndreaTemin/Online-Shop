package NegozioPackage;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.function.Function;

import static org.junit.Assert.*;

/**
 * Created by LorenzoMorandi on 25/01/17.
 */
public class ScontoOltreCentoDecoretorTest
{

    ScontoOltreCentoDecorator sc;

    @Before
    public void setUp() throws Exception {

        CarrelloInterface in= new Carrello();
        OggettoImmagazzinabile ogg= new RegistroMagazzino(7,new ArticoloSingolo("Nome","Descrizione",20),40);
        in.inserisciArticolo(ogg);

        ogg= new RegistroMagazzino(3,new ArticoloSingolo("Nome","Descrizione",10),40);
        in.inserisciArticolo(ogg);

        sc= new ScontoOltreCentoDecorator(in);
    }

    @Test
    public void getTotal() throws Exception {

        setUp();
        assertEquals(1080,sc.getTotal(),0.20);

    }

    @Test
    public void inserisciArticolo1() throws Exception
    {
        CarrelloInterface in= new Carrello();
        OggettoImmagazzinabile ogg= new RegistroMagazzino(1,new ArticoloSingolo("Nome","Descrizione",20),40);
        OggettoImmagazzinabile ogg2= new RegistroMagazzino(1,new ArticoloSingolo("Nome","Descrizione",20),1);

        in.inserisciArticolo(ogg);
        in.inserisciArticolo(ogg2);
        ScontoOltreCentoDecorator scontoOltreCentoDecoretor= new ScontoOltreCentoDecorator(in);

        Iterator<OggettoImmagazzinabile> it= scontoOltreCentoDecoretor.getIteretor();
        OggettoImmagazzinabile daValutare= it.next();

        assertEquals(41,daValutare.getQuantita());
    }

    @Test
    public void inserisciArticolo2() throws Exception
    {
        CarrelloInterface in= new Carrello();
        OggettoImmagazzinabile ogg= new RegistroMagazzino(1,new ArticoloSingolo("Nome","Descrizione",20),40);
        OggettoImmagazzinabile ogg2= new RegistroMagazzino(59,new ArticoloSingolo("Nome","Descrizione",204),7);

        in.inserisciArticolo(ogg);
        in.inserisciArticolo(ogg2);
        ScontoOltreCentoDecorator scontoOltreCentoDecoretor= new ScontoOltreCentoDecorator(in);

        Iterator<OggettoImmagazzinabile> it= scontoOltreCentoDecoretor.getIteretor();

        int qntaItem = getQntaItem(it);

        assertEquals(2,qntaItem);
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

    @Test
    public void rimuoviArticoli1() throws Exception {

        CarrelloInterface in= new Carrello();
        OggettoImmagazzinabile ogg= new RegistroMagazzino(7,new ArticoloSingolo("Nome","Descrizione",20),40);
        in.inserisciArticolo(ogg);

        ogg= new RegistroMagazzino(3,new ArticoloSingolo("Nome","Descrizione",10),1);
        in.inserisciArticolo(ogg);

        sc= new ScontoOltreCentoDecorator(in);

        //Eliminazione di un item con giacenza 1

        sc.rimuoviArticolo(1);

        int qntaItem = getQntaItem(sc.getIteretor());

        assertEquals(1,qntaItem);
    }

    @Test
    public void rimuoviArticoli2() throws Exception {

        CarrelloInterface in= new Carrello();
        OggettoImmagazzinabile ogg= new RegistroMagazzino(7,new ArticoloSingolo("Nome","Descrizione",20),40);
        in.inserisciArticolo(ogg);

        ogg= new RegistroMagazzino(3,new ArticoloSingolo("Nome","Descrizione",10),3);
        in.inserisciArticolo(ogg);

        sc= new ScontoOltreCentoDecorator(in);

        //Eliminazione di un item con giacenza maggiore di uno

        sc.rimuoviArticolo(1);

        int qntaItem = getQntaItem(sc.getIteretor());

        assertEquals(2,qntaItem);
    }

    @Test
    public void applicaSconto() throws Exception
    {
        setUp();
        Function<OggettoImmagazzinabile,OggettoImmagazzinabile> applicaSconto= (daScontare)->
        {
            Item tmp = daScontare.getOggetto();
            tmp = new ScontoUniversitariDecorator(tmp);
            daScontare.setOggetto(tmp);
            return daScontare;
        };

         sc.applicaSconto(applicaSconto);

         //Sconto applicato piu sconto oltre cento
         assertEquals(864,sc.getTotal(),1.0);
    }
}