package NegozioPackage;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by LorenzoMorandi on 24/01/17.
 */
public class RegistroMagazzinoTestArticoloSingolo extends RegistroMagazzinoTestAbstract {


    @Override
    public void setUp() throws Exception {
        super.setOggetto(new ArticoloSingolo("nome","descrizione",100));
        super.setUp();
    }

    @Override
    public void toStringTest() throws Exception {
        assertEquals("Codice: 10 Nome: nome, Prezzo: 100.0 Quantità: 20",super.getRegistroMagazzino().toString());

    }
}