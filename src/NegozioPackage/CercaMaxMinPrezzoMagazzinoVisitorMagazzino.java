package NegozioPackage;

import java.util.function.BiFunction;


public class CercaMaxMinPrezzoMagazzinoVisitorMagazzino extends CercaMaxMinMagazzinoABSVisitorMagazzino {

    @Override
    protected BiFunction<OggettoImmagazzinabile, OggettoImmagazzinabile, Boolean> creaLambdaMin() {
        return  (tmpMax,valutare)->tmpMax.getOggetto().getTotal()>valutare.getOggetto().getTotal();
    }

    @Override
    protected BiFunction<OggettoImmagazzinabile, OggettoImmagazzinabile, Boolean> creaLambdaMax() {
        return (tmpMin,valutare)->tmpMin.getOggetto().getTotal()<valutare.getOggetto().getTotal();
    }

    @Override
    public String toString() {
        return "<html>Risultati ricerca per prezzo:<br> "+super.toString()+ "</html>";
    }
}
