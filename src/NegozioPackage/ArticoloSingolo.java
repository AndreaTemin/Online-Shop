package NegozioPackage;


public class ArticoloSingolo implements Item
{
	private String nome;
	private String descrizione;
	private double prezzo;

	public ArticoloSingolo(String nome, String descrizione, double prezzo) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}

    @Override
	public String getDescrizione() {
		return "Articolo: " + nome + ", Descrizione: " + descrizione;
	}

	@Override
	public void inserisciArticolo(Item articolo) throws Exception {
		throw new Exception("IMPOSSIBILE");
	}

	@Override
	public void rimuoviArticolo(Item articolo) throws Exception {
		throw new Exception("IMPOSSIBILE");
	}

/*	public boolean equals(Object o) {
		boolean rst = false;

		if (o instanceof ArticoloSingolo) {
			ArticoloSingolo art = (ArticoloSingolo) o;

			if (this.nome.equals(art.nome) && this.prezzo == art.prezzo) {
				rst = true;
			}
		}
		return rst;
	}*/

	@Override
	public String toString() {
		return " Nome: " + nome  +
				", Prezzo: " + prezzo;
	}

	@Override
	public double getTotal() {
		return prezzo;
	}

    /*@Override
	public String toString() {
		return "Nome: "+ nome+"Prezzo: "+prezzo;
	}*/

    public ArticoloSingolo clone() throws CloneNotSupportedException {
		return (ArticoloSingolo) super.clone();
	}

	public String getNome()
	{
		return nome;
	}
}
