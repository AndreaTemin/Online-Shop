package NegozioPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Magazzino implements Warehouse
{
    private static Magazzino ourInstance = new Magazzino();

    private List<OggettoImmagazzinabile> merce ;
    private ArrayList<ObserverMagazzino> osservatori;

    public static Warehouse getInstance() {
        return ourInstance;
    }

    @Override
    public boolean rimuoviMerce(int indexMerce, int quantita)
    {
        boolean rimosso=false;
        for(int i=0;i<quantita;i++)
        {
            rimosso=rimuoviMerce(indexMerce);
        }

        return rimosso;

    }

    private Magazzino() {

        merce= new ArrayList<>();
        osservatori= new ArrayList<>();
    }

    @Override
    public Iterator<OggettoImmagazzinabile> getMerce()
    {
        return merce.iterator();
    }

    @Override
    public void inserisciMerce(OggettoImmagazzinabile articolo)
    {
        Iterator<OggettoImmagazzinabile> it= getMerce();
        boolean trovato=false;

        OggettoImmagazzinabile ogg=null;

        while (!trovato && it.hasNext())
        {
            ogg= it.next();

            if(ogg.equals(articolo))
            {
                trovato=true;
            }

        }

        if(trovato)
        {
            ogg.incrementaQuantita(1);
        }
        else
        {
            merce.add(articolo);
        }
        notifyObserver();
    }

    @Override
    public boolean rimuoviMerce(int i)
    {
        OggettoImmagazzinabile ogg= merce.get(i);

        boolean nonCancellare= ogg.decrementaQuantita(1);

        if(nonCancellare==false)
        {
            merce.remove(i);
        }

        notifyObserver();

        return nonCancellare;

    }

    @Override
    public void accettaVisitor(VisitorMagazzino v)
    {
        v.visitaWarehouse(this);
    }

    @Override
    public OggettoImmagazzinabile getOggettoAtIndex(int index) {
        return merce.get(index);
    }

    @Override
    public void rimuoviElemento(OggettoImmagazzinabile daRimuovere) {
        merce.remove(daRimuovere);
        notifyObserver();
    }

    @Override
    public void addObserver(ObserverMagazzino obs) {
        osservatori.add(obs);
    }

    @Override
    public void removeObserver(ObserverMagazzino obs) {
        osservatori.remove(obs);
    }

    @Override
    public void notifyObserver() {
        int i=0;
        for( ;i<osservatori.size();i++)
        {
            ObserverMagazzino obs= osservatori.get(i);
            obs.update(this);
        }
    }

    public void resetMagazzino()
    {
        merce= new ArrayList<>();
    }
}
