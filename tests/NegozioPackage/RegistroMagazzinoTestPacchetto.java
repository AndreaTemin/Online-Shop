package NegozioPackage;

import static org.junit.Assert.assertEquals;

/**
 * Created by LorenzoMorandi on 24/01/17.
 */
public class RegistroMagazzinoTestPacchetto extends RegistroMagazzinoTestAbstract {


    @Override
    public void setUp() throws Exception {
        Item pacchetto= new Pacchetto();
        pacchetto.inserisciArticolo(new ArticoloSingolo("nome", "descrizone",100));
        pacchetto.inserisciArticolo(new ArticoloSingolo("Nome", "descrizione",100));

        super.setOggetto(pacchetto);
        super.setUp();
    }

    @Override
    public void toStringTest() throws Exception {
        assertEquals("Codice: 10Nome: nome Nome Prezzo: 200.0 Quantità: 20",super.getRegistroMagazzino().toString());

    }

}
