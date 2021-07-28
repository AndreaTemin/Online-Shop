package NegozioPackage;


public class PagamentoCartaDiCreditoStrategy extends PagamentoAbstractStrategy {

    public PagamentoCartaDiCreditoStrategy(CarrelloInterface carrello) {
        super(carrello);
    }

    @Override
    public String stampaScontrino() {
        String rst="<HTML><BR>";

        rst=rst+"Pagamento effettuato con Carta di Credito";
        rst=rst+"<BR> ";

        rst=rst+super.stampaScontrino();

        rst=rst+"<BR><BR> <B> Totale: "+ super.getTotalString()+"<B> <BR> Data: "+super.getData()+"</HTML>";

        return rst;
    }


}
