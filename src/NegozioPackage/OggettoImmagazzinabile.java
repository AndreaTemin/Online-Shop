package NegozioPackage;

public interface OggettoImmagazzinabile extends Cloneable
{
    int getCodice();
    int getQuantita();
    void setQuantita(int qnta);
    Item getOggetto();
    boolean decrementaQuantita(int qnta);
    void incrementaQuantita(int qnta);
    String toString();
    OggettoImmagazzinabile clone() throws CloneNotSupportedException;
    void setOggetto(Item a);
}
