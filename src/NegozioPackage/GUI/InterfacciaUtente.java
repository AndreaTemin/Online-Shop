package NegozioPackage.GUI;

import NegozioPackage.*;
import NegozioPackage.ObserverCarrello;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;


public class InterfacciaUtente extends JFrame implements ObserverMagazzino, ObserverCarrello {

    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel buttonPanel;
    private JScrollPane magazzinoScroll;
    private JScrollPane carrelloScroll;
    private JList<OggettoImmagazzinabile> magazzinoList;
    private JList<OggettoImmagazzinabile> carrelloList;
    private JPanel middlePanel;
    private JButton inserisciButton;
    private JButton rimuoviButton;
    private JPanel topDXPanel;
    private JLabel totaleLabel;
    private JButton pagaButton;
    private JPanel topSXPanel;
    private JLabel carrelloTitoloLabel;
    private JLabel magazzinoTitoloLabel;
    private JButton visualizzaDescrizione;
    private DefaultListModel<OggettoImmagazzinabile> listModelMagazzino;
    private DefaultListModel<OggettoImmagazzinabile> listModelCarrello;
    private CarrelloInterface carrello;
    private Warehouse mag;


    public InterfacciaUtente() throws HeadlessException {
        super("Interfaccia Utente");

        $$$setupUI$$$();
        inserisciButton.addActionListener(new AscoltaInserisici());
        rimuoviButton.addActionListener(new AscoltaRimuovi());
        pagaButton.addActionListener(new AscoltaPagaButton());
        visualizzaDescrizione.addActionListener(new AscoltaVisualizzaDescrizone());

        mag = Magazzino.getInstance();
        mag.addObserver(this);

        carrello = new Carrello();
        carrello.addObserver(this);

        add(mainPanel);

        setSize(700, 350);
        this.setLocation(300, 400);

        setVisible(true);

    }

    private void aggiornaModelloLista(JList<OggettoImmagazzinabile> list, DefaultListModel<OggettoImmagazzinabile> listModel, Iterator<OggettoImmagazzinabile> ogg) {
        int i = 0;

        listModel.clear();

        while (ogg.hasNext()) {
            listModel.addElement(ogg.next());
        }

        list.setModel(listModel);
        repaint();
    }

    @Override
    public void update(Warehouse m) {
        Iterator<OggettoImmagazzinabile> ogg = m.getMerce();

        aggiornaModelloLista(magazzinoList, listModelMagazzino, ogg);


    }

    @Override
    public void update(CarrelloInterface ogg) {

        Iterator<OggettoImmagazzinabile> it = ogg.getIteretor();

        aggiornaModelloLista(carrelloList, listModelCarrello, it);

        totaleLabel.setText("Totale Carrello: " + carrello.getTotal());

    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        topPanel = new JPanel();
        topPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(topPanel, gbc);
        middlePanel = new JPanel();
        middlePanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        topPanel.add(middlePanel, gbc);
        inserisciButton = new JButton();
        inserisciButton.setText("Inserisci >>");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        middlePanel.add(inserisciButton, gbc);
        rimuoviButton = new JButton();
        rimuoviButton.setText("<< Rimuovi");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        middlePanel.add(rimuoviButton, gbc);
        visualizzaDescrizione = new JButton();
        visualizzaDescrizione.setText("Visualizza Descrizione");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        middlePanel.add(visualizzaDescrizione, gbc);
        topDXPanel = new JPanel();
        topDXPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        topPanel.add(topDXPanel, gbc);
        carrelloScroll = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        topDXPanel.add(carrelloScroll, gbc);
        carrelloList.setSelectionMode(0);
        carrelloScroll.setViewportView(carrelloList);
        totaleLabel = new JLabel();
        totaleLabel.setText("Totale Carrello: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        topDXPanel.add(totaleLabel, gbc);
        carrelloTitoloLabel = new JLabel();
        carrelloTitoloLabel.setText("Carrello");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        topDXPanel.add(carrelloTitoloLabel, gbc);
        topSXPanel = new JPanel();
        topSXPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        topPanel.add(topSXPanel, gbc);
        magazzinoScroll = new JScrollPane();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        topSXPanel.add(magazzinoScroll, gbc);
        magazzinoScroll.setViewportView(magazzinoList);
        magazzinoTitoloLabel = new JLabel();
        magazzinoTitoloLabel.setText("Scegli articolo");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        topSXPanel.add(magazzinoTitoloLabel, gbc);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(buttonPanel, gbc);
        pagaButton = new JButton();
        pagaButton.setText("Paga Carrello");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buttonPanel.add(pagaButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }


    public class AscoltaRimuovi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int[] select = carrelloList.getSelectedIndices();

            for (int i = 0; i < select.length; i++) {
                int selectIndex = select[i];

                OggettoImmagazzinabile ogg = listModelCarrello.elementAt(selectIndex);

                try {
                    OggettoImmagazzinabile copy = ogg.clone();
                    mag.inserisciMerce(copy);

                } catch (CloneNotSupportedException e1) {
                    e1.printStackTrace();
                }

                boolean cancellare = !carrello.rimuoviArticolo(selectIndex);

                if (cancellare) {
                    decrementaSelezione(select);
                }

            }

        }

        private void decrementaSelezione(int[] select) {
            for (int i = 0; i < select.length; i++)
                select[i]--;
        }
    }

    public class AscoltaInserisici implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int[] select = magazzinoList.getSelectedIndices();

            for (int i = 0; i < select.length; i++) {
                int selectIndex = select[i];

                OggettoImmagazzinabile ogg = mag.getOggettoAtIndex(selectIndex);

                try {
                    OggettoImmagazzinabile copy = ogg.clone();
                    copy.setQuantita(1);
                    carrello.inserisciArticolo(copy);
                } catch (CloneNotSupportedException e1) {
                    e1.printStackTrace();
                }

                mag.rimuoviMerce(selectIndex);

            }

        }
    }

    public class AscoltaPagaButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (carrello.getIteretor().hasNext()) {
                setVisible(false);
                new Pagamento(carrello);
                dispose();
            }

        }
    }

    public class AscoltaVisualizzaDescrizone implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int[] selectedCarello = carrelloList.getSelectedIndices();
            int[] selectedMagazzino = magazzinoList.getSelectedIndices();

            if (selectedCarello.length != 0) {
                creaFinestreDescrizione(selectedCarello, carrello);
            }
            if (selectedMagazzino.length != 0) {
                creaFinestreDescrizione(selectedMagazzino);
            }

            if (carrello.getIteretor().hasNext()) {
                setVisible(false);
                new Pagamento(carrello);
                dispose();
            }

        }

        private void creaFinestreDescrizione(int[] selectedCarello, CarrelloInterface carrello) {
            for (int i = 0; i < selectedCarello.length; i++) {
                OggettoImmagazzinabile ogg = listModelCarrello.elementAt(i);

                Item item = ogg.getOggetto();

                String rst = "<HTML> <B> Nome: </B> " + item.getNome() + "<BR> <B>Descrizione: </B>" + item.getDescrizione()
                        + "<BR><B> Prezzo: </B>" + item.getTotal();

                new DescrizioneForm(rst);

            }
        }

        private void creaFinestreDescrizione(int[] selectedMagazzino) {

            for (int i = 0; i < selectedMagazzino.length; i++) {

                OggettoImmagazzinabile ogg = listModelMagazzino.elementAt(i);

                Item item = ogg.getOggetto();

                String rst = "<HTML> <B> Nome: </B> " + item.getNome() + "<BR> <B>Descrizione: </B>" + item.getDescrizione()
                        + "<B> Prezzo: </B>" + item.getTotal();

                DescrizioneForm f = new DescrizioneForm(rst);

            }
        }


    }


    public static void main(String args[]) {
        Warehouse mag = Magazzino.getInstance();

        mag.inserisciMerce(new RegistroMagazzino(2, new ArticoloSingolo("1", "Descri", 10), 1));
        mag.inserisciMerce(new RegistroMagazzino(7, new ArticoloSingolo("2", "Descrrwdsfi", 100), 10));
        mag.inserisciMerce(new RegistroMagazzino(5, new ArticoloSingolo("3", "Descrrwdsfi", 10), 10));
        mag.inserisciMerce(new RegistroMagazzino(56, new ArticoloSingolo("4", "Descrrwdsfi", 20), 10));
        mag.inserisciMerce(new RegistroMagazzino(55, new ArticoloSingolo("5", "Descrrwdsfi", 54), 10));
        mag.inserisciMerce(new RegistroMagazzino(54, new ArticoloSingolo("6", "Descrrwdsfi", 54), 10));
        mag.inserisciMerce(new RegistroMagazzino(53, new ArticoloSingolo("7", "Descrrwdsfi", 54), 10));
        mag.inserisciMerce(new RegistroMagazzino(52, new ArticoloSingolo("8", "Descrrwdsfi", 54), 10));
        mag.inserisciMerce(new RegistroMagazzino(51, new ArticoloSingolo("9", "Descrrwdsfi", 54), 10));
        mag.inserisciMerce(new RegistroMagazzino(25, new ArticoloSingolo("87", "Descrrwdsfi", 54), 10));


        new InterfacciaUtente();

    }


    private void createUIComponents() {
        listModelMagazzino = new DefaultListModel();
        listModelCarrello = new DefaultListModel();

        Warehouse magazzino = Magazzino.getInstance();

        magazzinoList = new JList(listModelMagazzino);

        aggiornaModelloLista(magazzinoList, listModelMagazzino, magazzino.getMerce());

        carrelloList = new JList(listModelCarrello);

    }
}