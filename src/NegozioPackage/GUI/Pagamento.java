package NegozioPackage.GUI;

import NegozioPackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Function;


public class Pagamento extends JFrame {
    private JPanel mainPanel;
    private JLabel labelPagamento;
    private JRadioButton pagamentoBonificoButton;
    private JRadioButton pagamentoCartaButton;
    private JPanel topPanel;
    private JPanel downPanel;
    private JPanel codicePanel;
    private JPanel buttonPanel;
    private JLabel codiceLabel;
    private JTextField codiceScontoTextField;
    private JButton procediPagamentoButton;
    private CarrelloInterface carrello;

    public Pagamento(CarrelloInterface carrello) {
        super("Seleziona Metodo Pagamento");


        pagamentoBonificoButton.setSelected(true);

        procediPagamentoButton.addActionListener(new AscoltaPagamentoButton());

        add(mainPanel);

        this.carrello = carrello;

        setSize(400, 200);
        setVisible(true);


    }

    public void setData(Pagamento data) {
    }

    public void getData(Pagamento data) {
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
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
        labelPagamento = new JLabel();
        labelPagamento.setFont(new Font(labelPagamento.getFont().getName(), labelPagamento.getFont().getStyle(), 14));
        labelPagamento.setText("Scegli metodo di Pagamento");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        topPanel.add(labelPagamento, gbc);
        pagamentoBonificoButton = new JRadioButton();
        pagamentoBonificoButton.setText("Bonifico");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        topPanel.add(pagamentoBonificoButton, gbc);
        pagamentoCartaButton = new JRadioButton();
        pagamentoCartaButton.setText("Carta di Credito");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        topPanel.add(pagamentoCartaButton, gbc);
        downPanel = new JPanel();
        downPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(downPanel, gbc);
        codicePanel = new JPanel();
        codicePanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        downPanel.add(codicePanel, gbc);
        codiceLabel = new JLabel();
        codiceLabel.setText("Inserisci Codice Promozionale: ");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        codicePanel.add(codiceLabel, gbc);
        codiceScontoTextField = new JTextField();
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        codicePanel.add(codiceScontoTextField, gbc);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        downPanel.add(buttonPanel, gbc);
        procediPagamentoButton = new JButton();
        procediPagamentoButton.setText("Paga");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buttonPanel.add(procediPagamentoButton, gbc);
        ButtonGroup buttonGroup;
        buttonGroup = new ButtonGroup();
        buttonGroup.add(pagamentoBonificoButton);
        buttonGroup.add(pagamentoCartaButton);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }


    public class AscoltaPagamentoButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (carrello.getTotal() > 100) {
                carrello = new ScontoOltreCentoDecorator(carrello);
            }

            controllaSconto();

            if (pagamentoBonificoButton.isSelected()) {
                new Bill(new PagamentoBonificoStrategy(carrello));
                dispose();
            }

            if (pagamentoCartaButton.isSelected()) {
                new Bill(new PagamentoCartaDiCreditoStrategy(carrello));
                dispose();
            }

        }

        private void controllaSconto() {
            String scontoInserito = codiceScontoTextField.getText();

            int sconto = 0;

            try {
                sconto = Integer.parseInt(scontoInserito);
            } catch (Exception e) {
                sconto = 0;
            }

            switch (sconto) {
                case 34:
                    applicaScontoArticoliStudenti();
                    break;
                default:
                    break;
            }

        }
    }

    private void applicaScontoArticoliStudenti() {
        Function<OggettoImmagazzinabile, OggettoImmagazzinabile> applicaSconto = (prima) ->
        {
            Item tmp = prima.getOggetto();
            tmp = new ScontoUniversitariDecorator(tmp);
            prima.setOggetto(tmp);
            return prima;
        };

        carrello.applicaSconto(applicaSconto);
    }

    public static void main(String args[]) {
        Carrello c = new Carrello();
        c.inserisciArticolo(new RegistroMagazzino(19, new ArticoloSingolo("N", "s", 30), 10));
        new Pagamento(c);
    }
}
