package NegozioPackage;

import java.util.Iterator;
import java.util.function.Function;


public abstract class DecoraCarrello implements CarrelloInterface
{
    CarrelloInterface oggettoDecorato;

    public DecoraCarrello(CarrelloInterface oggettoDecorato) {
        this.oggettoDecorato = oggettoDecorato;
    }

    @Override
    public void addObserver(ObserverCarrello obs) {
        oggettoDecorato.addObserver(obs);
    }

    @Override
    public void removeObserver(ObserverCarrello obs) {
        oggettoDecorato.removeObserver(obs);
    }

    @Override
    public void notifyObserver() {
        oggettoDecorato.notifyObserver();
    }

    @Override
    public void inserisciArticolo(OggettoImmagazzinabile articolo) {
        oggettoDecorato.inserisciArticolo(articolo);
    }

    @Override
    public boolean rimuoviArticolo(int index) {
        return  oggettoDecorato.rimuoviArticolo(index);
    }

    @Override
    public double getTotal()
    {
        return (oggettoDecorato.getTotal());
    }

    @Override
    public void applicaSconto(Function<OggettoImmagazzinabile, OggettoImmagazzinabile> applicaSconto) {
        oggettoDecorato.applicaSconto(applicaSconto);
    }

    public abstract String getTotalString();

    @Override
    public Iterator<OggettoImmagazzinabile> getIteretor() {
        return oggettoDecorato.getIteretor();
    }
}
