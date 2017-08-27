package br.ufjf.dcc171;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class JanelaRadio extends JFrame {

    private final JLabel mensagemInicial = new JLabel("Escolha o imposto e cotação: ");
    private final JLabel valorProduto = new JLabel("Valor do produto: ");
    private final JLabel cotacaoDolar = new JLabel("Cotação do dolar ");
    private final JLabel tributos = new JLabel("Escolha seus tributos: ");
    private final JLabel jbResultado;
    private final JTextField jtCotacaoDolar = new JTextField(03);
    private final JTextField jtvalorProduto = new JTextField(03);
    private final JCheckBox jrTaxa;
    private final JCheckBox jrICMS;
    private final JButton buttonCalculo;

    public JanelaRadio() throws HeadlessException {
        super("Calculadora de Imposto");
        add(mensagemInicial);
        jbResultado = new JLabel();
        add(jbResultado);
        add(valorProduto);
        add(jtvalorProduto);
       
        jrTaxa = new JCheckBox("Taxado", false);
        jrICMS = new JCheckBox("ICMS", false);
        buttonCalculo = new JButton("Gerar Calculo");
        
        
        add(cotacaoDolar);
        add(jtCotacaoDolar);
        add(tributos);
        add(jrTaxa);
        add(jrICMS);
        add(buttonCalculo);
 setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonCalculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculo();

            }

            public void calculo() {
                float valor, cotacaoDolar, resultado;
                valor = Float.parseFloat(jtCotacaoDolar.getText());
                cotacaoDolar = Float.parseFloat(jtvalorProduto.getText());
                if (jrTaxa.isSelected()) {

                    resultado = (float) (cotacaoDolar * valor * 1.6);
                    jbResultado.setText("O valor atualizado do produto : " + resultado);
                } else if (jrICMS.isSelected()) {

                    resultado = (float) (cotacaoDolar * valor * 1.18);
                    jbResultado.setText("O valor atualizado do produto : " + resultado);
                } else if (jrICMS.isSelected() && jrTaxa.isSelected()) {
                    resultado = (float) (cotacaoDolar * valor * 1.6 * 1.18);
                    jbResultado.setText("O valor atualizado do produto : " + resultado);
                } else {

                    resultado = cotacaoDolar * valor;
                    jbResultado.setText("O valor atualizado do produto : " + resultado);
                }

            }

        }
        );
    }
}
