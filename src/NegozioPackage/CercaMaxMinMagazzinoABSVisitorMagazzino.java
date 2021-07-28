package NegozioPackage;

import java.util.Iterator;
import java.util.function.BiFunction;


public abstract class CercaMaxMinMagazzinoABSVisitorMagazzino implements VisitorMagazzino {
    private OggettoImmagazzinabile max;
    private OggettoImmagazzinabile min;
    private BiFunction<OggettoImmagazzinabile, OggettoImmagazzinabile,Boolean> trovaMaxMin;

    @Override
    public void visitaWarehouse(Warehouse warehouse)
    {
        Iterator<OggettoImmagazzinabile> merce= warehouse.getMerce();

        trovaMaxMin= creaLambdaMax();

        max =calcolaMaxMin(merce);

        trovaMaxMin= creaLambdaMin();

        min =calcolaMaxMin(warehouse.getMerce());

    }

    protected abstract BiFunction<OggettoImmagazzinabile, OggettoImmagazzinabile,Boolean> creaLambdaMin();

    protected abstract BiFunction<OggettoImmagazzinabile, OggettoImmagazzinabile,Boolean> creaLambdaMax();


    private OggettoImmagazzinabile calcolaMaxMin(Iterator<OggettoImmagazzinabile> merce)
    {
        OggettoImmagazzinabile rst=null;

        if(merce.hasNext())
        {
            rst=merce.next();
        }

        while (merce.hasNext())
        {
            OggettoImmagazzinabile elementoAnalizzato= merce.next();

            if(trovaMaxMin.apply(rst,elementoAnalizzato))
            {
                rst=elementoAnalizzato;
            }
        }
        return rst;
    }

    public OggettoImmagazzinabile getMax() {
        return max;
    }

    public OggettoImmagazzinabile getMin() {
        return min;
    }

    @Override
    public String toString() {
        String rst;

        if(getMax()==null && getMax()==null)
        {
            rst="NESSUN ELEMENTO PRESENTE NEL MAGAZZINO";
            return rst;
        }

        rst= "Elemento con valore piu elevato: ";
        rst=rst+getMax().toString()+"<br> Elemento con valore minore: "+getMin().toString();

        return rst;
    }
}
