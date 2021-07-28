package NegozioPackage;


public abstract class DecoraItem implements Item
{
    private Item oggettoDecorato;

    public DecoraItem(Item oggettoDecorato) {
        this.oggettoDecorato = oggettoDecorato;
    }

    @Override
    public double getTotal()
    {
        double prezzo= oggettoDecorato.getTotal();

        return prezzo;
    }

    @Override
    public void inserisciArticolo(Item articolo) throws Exception {

        oggettoDecorato.inserisciArticolo(articolo);
    }

    @Override
    public void rimuoviArticolo(Item articolo) throws Exception {
        oggettoDecorato.rimuoviArticolo(articolo);}

    public DecoraItem clone() throws CloneNotSupportedException {
       DecoraItem di= (DecoraItem) super.clone();
       di.oggettoDecorato= (Item) oggettoDecorato.clone();
       return di;
    }

    @Override
    public String toString() {
        return oggettoDecorato.toString();

    }

    public String getDescrizione()
    {
        return oggettoDecorato.getDescrizione();
    }

    public String getNome()
    {
        return oggettoDecorato.getNome();
    }

}
