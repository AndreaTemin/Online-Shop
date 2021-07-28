package NegozioPackage;

import java.util.Iterator;

public interface Warehouse extends Observable<ObserverMagazzino>
{
     Iterator<OggettoImmagazzinabile> getMerce();

     void inserisciMerce(OggettoImmagazzinabile i);

     boolean rimuoviMerce(int i);

     boolean rimuoviMerce(int indexMerce, int quantita);

     void accettaVisitor(VisitorMagazzino v);

     OggettoImmagazzinabile getOggettoAtIndex(int index);

     void rimuoviElemento(OggettoImmagazzinabile daRimuovere);

     void resetMagazzino();
}
