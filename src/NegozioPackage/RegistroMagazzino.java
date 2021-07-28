package NegozioPackage;

public class RegistroMagazzino implements OggettoImmagazzinabile
{
    private int codice;
    private Item oggetto;
    private int giacenza;


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (!(o instanceof RegistroMagazzino)) return false;

        RegistroMagazzino that = (RegistroMagazzino) o;

        return getCodice() == that.getCodice();
    }


    public RegistroMagazzino(int codice, Item oggetto, int giacenza) {
        this.codice = codice;
        this.oggetto = oggetto;
        this.giacenza = giacenza;
    }


    public int getCodice() {
        return codice;
    }

    @Override
    public int getQuantita() {
        return giacenza;
    }

    @Override
    public void setQuantita(int qnta) {
        giacenza=qnta;
    }

    @Override
    public Item getOggetto() {
        return oggetto;
    }

    @Override
    public boolean decrementaQuantita(int qnta)
    {
        int tmp=giacenza-qnta;
        boolean rst;

        if(tmp<=0)
        {
            rst=false;
        }
        else
        {
            rst=true;
            giacenza=tmp;
        }

        return rst;
    }

    @Override
    public String toString() {
        return "Codice: "+codice+oggetto.toString()+" Quantità: "+ giacenza;
    }

    @Override
    public void incrementaQuantita(int qnta) {
        giacenza=giacenza+qnta;
    }

    public RegistroMagazzino clone() throws CloneNotSupportedException
    {
        RegistroMagazzino rm= (RegistroMagazzino) super.clone();
        rm.oggetto= oggetto.clone();

        return rm;

    }


    @Override
    public void setOggetto(Item a) {
        this.oggetto=a;
    }
}

