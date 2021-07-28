package NegozioPackage;


public interface Item extends Cloneable {

	public String  getNome();

	public String getDescrizione();

	public void inserisciArticolo(Item articolo) throws Exception;

	public void rimuoviArticolo(Item articolo) throws Exception;

	public double getTotal();

	Item clone() throws CloneNotSupportedException;

}
