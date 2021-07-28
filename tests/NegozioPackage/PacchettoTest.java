package NegozioPackage;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedList;

import NegozioPackage.ArticoloSingolo;
import NegozioPackage.Pacchetto;
import NegozioPackage.Item;
import org.junit.Before;
import org.junit.Test;

public class PacchettoTest
{
	Pacchetto p;
	Item uno;
	Item due;
	Item tre;

	@Before
	public void setUpBeforeClass() throws Exception {
		p = new Pacchetto();
		uno = new ArticoloSingolo("uno","mezzo" ,1);
		due = new ArticoloSingolo("due","terzo",2);
		tre = new Pacchetto();
		tre.inserisciArticolo(due);
		tre.inserisciArticolo(uno);
	}

    @Test
	public void testInserisciArticoloSingolo() throws Exception
    {
        p=new Pacchetto();
		p.inserisciArticolo(uno);

        LinkedList<Item> prova= new LinkedList<Item>();
        prova.add(uno);

        Iterator<Item> provaIteretor= prova.iterator();
        Iterator<Item> pIteretor= p.getIteretor();

        Item itemProva= provaIteretor.next();
        Item itemP= pIteretor.next();

        assertEquals(true,itemP.equals(itemProva));

	}
	@Test
	public void inserisciArticoloPacchetto() throws Exception {

	    //Creazione pacchetto di test
        Item test= new Pacchetto();
        test.inserisciArticolo(uno);
        test.inserisciArticolo(due);

        //Inserimento pacchetto
        p=new Pacchetto();
        p.inserisciArticolo(test);

        //Simulazione della lista di articoli
        LinkedList<Item> prova= new LinkedList<Item>();
        prova.add(test);

        //Confronto tra iteratori
        Iterator<Item> provaIteretor= prova.iterator();
        Iterator<Item> pIteretor= p.getIteretor();

        Item itemProva= provaIteretor.next();
        Item itemP= pIteretor.next();

        assertEquals(true,itemP.equals(itemProva));
	}

    @Test
	public void testRimuoviArticolo1() throws Exception
    {
        Pacchetto pac=creaItem();

        pac.rimuoviArticolo(uno);

        LinkedList<Item> prova= new LinkedList<Item>();
        prova.add(due);

        Iterator<Item> provaIteretor= prova.iterator();
        Iterator<Item> pIteretor= pac.getIteretor();

        boolean rst= provaIteretor.next().equals(pIteretor.next());

        assertEquals(true,rst);

	}

    private Pacchetto creaItem()
    {
        Pacchetto pac=new Pacchetto();

        try
        {
            pac.inserisciArticolo(uno);
            pac.inserisciArticolo(due);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return pac;
    }

    @Test
    public void getNome() throws Exception
    {
        assertEquals(" uno due", creaItem().getNome());
    }


    @Test
    public void cloneTest() throws Exception
    {
        Item ogg= creaItem();
        Item clonato = ogg.clone();

        boolean rst= ogg.getClass()==clonato.getClass();

        assertEquals(true,rst);

        rst= clonato!=ogg;

        assertEquals(true,rst);

    }
}
