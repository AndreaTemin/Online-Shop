package NegozioPackage;

import java.util.Iterator;
import java.util.function.Function;


public interface CarrelloInterface extends Observable<ObserverCarrello>
{
    public void inserisciArticolo(OggettoImmagazzinabile articolo);

    public boolean rimuoviArticolo(int index);

    public double getTotal();

    public Iterator<OggettoImmagazzinabile> getIteretor();

    public void applicaSconto(Function<OggettoImmagazzinabile, OggettoImmagazzinabile> applicaSconto);

    public String getTotalString();


}
