package NegozioPackage;


public class PagamentoBonificoStrategy extends PagamentoAbstractStrategy
{

    public PagamentoBonificoStrategy(CarrelloInterface carrello)
    {
        super(carrello);
    }

    @Override
    public String stampaScontrino() {
        String rst="<HTML><BR>";

        rst=rst+"Pagamento effettuato con Bonfico Bancario";
        rst=rst+"<BR> ";

        rst=rst+super.stampaScontrino();

        rst=rst+"<BR><BR> <B> Totale: "+ super.getTotalString()+"<B> <BR> Data: "+super.getData()+"</HTML>";

        return rst;
    }

}
