package NegozioPackage;

import java.util.function.BiFunction;


public class CercaMaxMinGiacenzaMagazzinoVisitorMagazzino extends CercaMaxMinMagazzinoABSVisitorMagazzino
{


    @Override
    protected BiFunction<OggettoImmagazzinabile, OggettoImmagazzinabile, Boolean> creaLambdaMin() {
        return (tmpMin,valutare)-> tmpMin.getQuantita()>valutare.getQuantita();
    }

    @Override
    protected BiFunction<OggettoImmagazzinabile, OggettoImmagazzinabile, Boolean> creaLambdaMax() {
        return (tmpMax,valutare) -> tmpMax.getQuantita()< valutare.getQuantita();
    }

    @Override
    public String toString() {
        return "<html>Risultati ricerca per giacenza: <BR>"+super.toString() + "</html>";
    }
}
