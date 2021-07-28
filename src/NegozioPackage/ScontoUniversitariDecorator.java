package NegozioPackage;

public class ScontoUniversitariDecorator extends DecoraItem
{
    public ScontoUniversitariDecorator(Item oggettoDecorato) {
        super(oggettoDecorato);
    }

    @Override
    public double getTotal()
    {
        double prezzo= super.getTotal();
        prezzo=prezzo*0.8;

        return prezzo;
    }

    @Override
    public String getDescrizione() {
        return super.getDescrizione()+"Sconto Univeristario";
    }

    public String toString()
    {
        return "Nome: "+super.getNome()+"Prezzo: "+getTotal()+" Sconto del 20% Applicato ";
    }


}
