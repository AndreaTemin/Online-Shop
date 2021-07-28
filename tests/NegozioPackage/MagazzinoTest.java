package NegozioPackage;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by LorenzoMorandi on 26/01/17.
 */
public class MagazzinoTest {

    Warehouse magazzino=Magazzino.getInstance();


    @Before
    public void init()
    {
        setUp();
    }

    public void setUp() {

        magazzino.resetMagazzino();

        Item i1= new ArticoloSingolo("Nome","Descrizione",10);
        Item i2= new ArticoloSingolo("Nome1","Descrizione1",30);

        Item i3= new Pacchetto();
        try {
            i3.inserisciArticolo(i2);
            i3.inserisciArticolo(i1);
        } catch (Exception e) {
            e.printStackTrace();
        }


        OggettoImmagazzinabile ogg= new RegistroMagazzino(1,i3,10);
        magazzino.inserisciMerce(ogg);

        OggettoImmagazzinabile ogg1= new RegistroMagazzino(2,i2,10);
        magazzino.inserisciMerce(ogg1);

    }

    @Test
    public void getInstance() throws Exception {

        Warehouse prova= Magazzino.getInstance();

        assertNotEquals(null,prova);

    }


    @Test
    public void rimuoviMerce() throws Exception {

        OggettoImmagazzinabile ogg= new RegistroMagazzino(3,new ArticoloSingolo("Nome","Descrizione",10),1);
        magazzino.inserisciMerce(ogg);

        //Eliminazione di un item con giacenza 1

        magazzino.rimuoviMerce(2);

        int qntaItem = getQntaItem(magazzino.getMerce());

        assertEquals(2,qntaItem);

    }

    @Test
    public void rimuoviMerce1() throws Exception {

        //Eliminazione di un item con giacenza maggiore 1

        magazzino.rimuoviMerce(1);

        int qntaItem = getQntaItem(magazzino.getMerce());

        assertEquals(2,qntaItem);


    }

    @Test
    public void inserisciMerce() throws Exception {

        Iterator<OggettoImmagazzinabile> it= magazzino.getMerce();
        OggettoImmagazzinabile oggPrecedente =getAtIndex(it,2);
        int valoreGiacenzaPrecedente = oggPrecedente.getQuantita();

        OggettoImmagazzinabile ogg1= new RegistroMagazzino(2,new ArticoloSingolo("Nome1","Descrizione1",30),1);
        magazzino.inserisciMerce(ogg1);

        //Inseirmento di un articolo gia presente
        it= magazzino.getMerce();
        OggettoImmagazzinabile daValutare =getAtIndex(it,2);
        assertEquals(valoreGiacenzaPrecedente+1,daValutare.getQuantita());

        it=magazzino.getMerce();
        int qntaMerce =getQntaItem(it);

        assertEquals(qntaMerce,2);
    }

    @Test
    public void inserisciMerce1() throws Exception {

        OggettoImmagazzinabile ogg1= new RegistroMagazzino(3,new ArticoloSingolo("Nome1","Descrizione1",30),1);
        magazzino.inserisciMerce(ogg1);

        //Inseirmento di un articolo non presente

        Iterator<OggettoImmagazzinabile> it=magazzino.getMerce();
        int qntaMerce =getQntaItem(it);

        assertEquals(3,qntaMerce);

        it=magazzino.getMerce();
        OggettoImmagazzinabile daVal= getAtIndex(it,3);

        assertEquals(true, daVal.equals(daVal));

        magazzino.rimuoviMerce(2);
    }


    @Test
    public void addObserver() throws Exception {



    }

    @Test
    public void removeObserver() throws Exception {

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

    private OggettoImmagazzinabile getAtIndex(Iterator<OggettoImmagazzinabile> it,int index)
    {
        for(int i=0;i<index-1;i++)
        {
            it.next();
        }

        return it.next();

    }



}