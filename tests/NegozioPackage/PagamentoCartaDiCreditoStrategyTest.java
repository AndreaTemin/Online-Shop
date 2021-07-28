package NegozioPackage;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by LorenzoMorandi on 26/01/17.
 */
public class PagamentoCartaDiCreditoStrategyTest {

    CarrelloInterface c;
    PagamentoAbstractStrategy pagamentoStrategy;

    @Before
    public void setUp() throws Exception {

        c= new Carrello();
        Item i1= new ArticoloSingolo("Nome","Descrizione",10);
        Item i2= new ArticoloSingolo("Nome","Descrizione",30);

        Item i3= new Pacchetto();
        i3.inserisciArticolo(i2);
        i3.inserisciArticolo(i1);

        OggettoImmagazzinabile ogg= new RegistroMagazzino(1,i3,10);
        c.inserisciArticolo(ogg);

        OggettoImmagazzinabile ogg1= new RegistroMagazzino(2,i2,10);
        c.inserisciArticolo(ogg1);

        pagamentoStrategy= new PagamentoCartaDiCreditoStrategy(c);

    }

    @Test
    public void stampaScontrino() throws Exception {

        String rstAtteso= "<HTML><BR>Pagamento effettuato con Carta di Credito<BR> Codice: 1Nome: Nome Nome Prezzo: " +
                "40.0 Quantità: 10<BR>Codice: 2 Nome: Nome, Prezzo: 30.0 Quantità: 10<BR><BR><BR> <B> Totale: 700.0<B>" +
                " <BR> Data: "+pagamentoStrategy.getData()+"</HTML>";

        assertEquals(rstAtteso,pagamentoStrategy.stampaScontrino());
    }

    @Test
    public void getTotal() throws Exception
    {
        assertEquals(700,pagamentoStrategy.getTotal(),0.20);
    }

}