package NegozioPackage;

import java.util.Iterator;
import java.util.LinkedList;


public class Pacchetto implements Item,Cloneable
{
    protected LinkedList<Item> itemList;

    public Pacchetto() {
        itemList = new LinkedList<Item>();
    }

    public Iterator<Item> getIteretor() {
        return itemList.iterator();
    }

    @Override
    public String getDescrizione() {
        Iterator<Item> it = getIteretor();

        String descr = "Pacchetto (";

        while (it.hasNext()) {
            descr = descr + it.next().getDescrizione();
            descr = descr + "\n";
        }

        return descr+")";
    }

    @Override
    public void inserisciArticolo(Item articolo) throws Exception {
        itemList.add(articolo);
    }

    @Override
    public void rimuoviArticolo(Item articolo) throws Exception
    {
        itemList.remove(articolo);
    }

  /*  public boolean equals(Object o) {
        boolean rst = false;

        if (o instanceof Pacchetto) {
            Pacchetto pac = (Pacchetto) o;

            if (this.itemList.size() == pac.itemList.size()) {

                boolean uguali = true;
                int i=0;

                while(uguali && i<this.itemList.size())
                {
                    int j=0;
                    boolean trovato;
                    while (j<)
                }
                rst = tmp;
            }
        }

        return rst;
    }*/

    @Override
    public double getTotal()
    {
        Iterator<Item> it = getIteretor();

        double prezzo = 0;


        while (it.hasNext()) {
            prezzo = prezzo + it.next().getTotal();
        }
        return prezzo;
    }

   @Override
    public String toString()
    {
        String rst = "";
        Iterator<Item> it= getIteretor();

        while (it.hasNext())
        {
            Item ogg= it.next();
            rst=rst+ogg.getNome();
            rst=rst+" ";
        }

        return "Nome: "+ rst+ "Prezzo: "+getTotal();
    }

    public Pacchetto clone() throws CloneNotSupportedException {
        Pacchetto art= (Pacchetto) super.clone();
        art.itemList= (LinkedList<Item>) itemList.clone();

        return art;

    }

    public String getNome()
    {
        String nome ="";
        Iterator<Item> it= getIteretor();

        while (it.hasNext())
        {
            Item ogg= it.next();
            nome=nome+" "+ogg.getNome();
        }

        return nome;
    }
}
