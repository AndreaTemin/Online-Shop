package NegozioPackage;

import NegozioPackage.GUI.InserimentoElementiMagazzino;
import NegozioPackage.GUI.InterfacciaUtente;


public class MainClass {

    private InserimentoElementiMagazzino elementiMagazzino;
    private InterfacciaUtente gui;

    public void run()
    {
        elementiMagazzino= new InserimentoElementiMagazzino();
        gui= new InterfacciaUtente();
        
    }

    public static void main(String args[])
    {
        new MainClass().run();
    }
}
