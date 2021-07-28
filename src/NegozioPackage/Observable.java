package NegozioPackage;


public interface Observable<T>
{
    void addObserver(T obs);
    void removeObserver(T obs);
    void notifyObserver();
}
