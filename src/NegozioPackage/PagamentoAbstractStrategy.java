package NegozioPackage;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;


public abstract class PagamentoAbstractStrategy implements StrategiaPagamento
{
    CarrelloInterface carrello;
    GregorianCalendar gc ;


    public PagamentoAbstractStrategy(CarrelloInterface carrello) {
        this.carrello = carrello;
        gc= new GregorianCalendar();

    }

    public double getTotal(){return carrello.getTotal();}

    public String getTotalString(){return carrello.getTotalString();}

    public String stampaScontrino(){
        String rst="";

        Iterator<OggettoImmagazzinabile> iterator= carrello.getIteretor();

        while (iterator.hasNext())
        {
            rst= rst+iterator.next().toString();
            rst=rst+"<BR>";
        }

        return rst;
    }

    public String getData()
    {
        int giorno= gc.get(Calendar.DAY_OF_MONTH);
        int mese= gc.get(Calendar.MONTH)+1;
        int anno= gc.get(Calendar.YEAR);

        int ore=gc.get(Calendar.HOUR);
        int minuti= gc.get(Calendar.MINUTE);

        return ore+":"+minuti+" "+ giorno+"/"+mese+"/"+anno;

    }

}
