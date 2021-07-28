package NegozioPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class Carrello implements CarrelloInterface
{
    private List<OggettoImmagazzinabile> itemList;
    private List<ObserverCarrello> osservatori;

    public Carrello()
    {
        super();
        osservatori=new ArrayList<ObserverCarrello>();
        itemList=new ArrayList<OggettoImmagazzinabile>();
    }

    @Override
    public void inserisciArticolo(OggettoImmagazzinabile articolo)
    {
        Iterator<OggettoImmagazzinabile> it= getIteretor();
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
            itemList.add(articolo);
        }
        notifyObserver();
    }

    @Override
    public boolean rimuoviArticolo(int index)
    {
        OggettoImmagazzinabile ogg= itemList.get(index);

        boolean nonCancellare= ogg.decrementaQuantita(1);

        if(nonCancellare == false )
        {
            itemList.remove(index);
        }
        notifyObserver();

        return nonCancellare;
    }

    @Override
    public double getTotal() {
        Iterator<OggettoImmagazzinabile> it = getIteretor();

        double prezzo = 0;

        while (it.hasNext()) {

            OggettoImmagazzinabile ogg= it.next();
            double prezzoOggetto=ogg.getOggetto().getTotal();
            prezzo = prezzo + prezzoOggetto*ogg.getQuantita();
        }
        return prezzo;
    }

    @Override
    public Iterator<OggettoImmagazzinabile> getIteretor() {
        return itemList.iterator();
    }

    @Override
    public void applicaSconto(Function<OggettoImmagazzinabile, OggettoImmagazzinabile> applicaSconto)
    {

        for(int i =0;i<itemList.size();i++)
        {
            OggettoImmagazzinabile ogg = itemList.get(i);

            ogg = applicaSconto.apply(ogg);

            itemList.set(i, ogg);
        }
    }

    public String getTotalString()
    {
        return""+getTotal();
    }

    @Override
    public void addObserver(ObserverCarrello obs) {
        osservatori.add(obs);
    }

    @Override
    public void removeObserver(ObserverCarrello obs) {
        osservatori.remove(obs);
    }

    @Override
    public void notifyObserver()
    {

        for(ObserverCarrello os: osservatori)
        {
            os.update(this);
        }
    }


}
