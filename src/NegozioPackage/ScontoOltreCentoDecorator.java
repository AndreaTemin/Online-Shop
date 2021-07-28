package NegozioPackage;


public class ScontoOltreCentoDecorator extends DecoraCarrello
{
    public ScontoOltreCentoDecorator(CarrelloInterface oggettoDecorato) {
        super(oggettoDecorato);
    }

    @Override
    public double getTotal() {
        return  (oggettoDecorato.getTotal()*(0.9));
    }

    @Override
    public String getTotalString() {
        return getTotal()+"Applicato Sconto del 10% ";
    }
}
