package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conversores.ConversorTemperatura;
import conversores.MenuConversor;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ConversorTemperaturaGui extends JFrame implements ActionListener, ItemListener, KeyListener {

	private JPanel contentPane;
	private JTextField textFieldValor;
	private JButton btnConvertir, btnAtras;
	JComboBox<String> comboBoxDe, comboBoxA;
	private JLabel lblresultado;
	ConversorTemperatura conversor;

	public ConversorTemperaturaGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		setTitle("CONVERSOR DE TEMPERATURA");
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void iniciarComponentes() {
		setBounds(100, 100, 397, 408);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		AjustarImagen[] imgAjustada = new AjustarImagen[2];

		comboBoxDe = new JComboBox<>();
		comboBoxDe.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBoxDe.setModel(new DefaultComboBoxModel<String>(new String[] { "Celsius", "Fahrenheit", "Kelvin" }));
		comboBoxDe.setBounds(103, 129, 169, 28);
		contentPane.add(comboBoxDe);
		comboBoxDe.addItemListener(this);

		comboBoxA = new JComboBox<String>();
		comboBoxA.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBoxA.setModel(new DefaultComboBoxModel<String>(new String[] { "Fahrenheit", "Kelvin", "Celsius" }));
		comboBoxA.setBounds(103, 185, 169, 28);
		contentPane.add(comboBoxA);
		comboBoxA.addItemListener(this);

		JLabel lblA = new JLabel("a");
		lblA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setBounds(162, 156, 46, 28);
		contentPane.add(lblA);

		JLabel lblTitulo = new JLabel("CONVERSOR DE TEMPERATURA");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(56, 15, 301, 34);
		contentPane.add(lblTitulo);

		textFieldValor = new JTextField();
		textFieldValor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldValor.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldValor.setBounds(103, 90, 169, 28);
		contentPane.add(textFieldValor);
		textFieldValor.setColumns(10);
		textFieldValor.addKeyListener(this);

		btnConvertir = new JButton();
		btnConvertir.setBorderPainted(false);
		btnConvertir.setBounds(159, 236, 49, 49);
		btnConvertir.setBackground(new Color(240, 255, 240));
		imgAjustada[0] = new AjustarImagen();
		imgAjustada[0].AjustaImagen(btnConvertir, "/imagenes/flecha-de-bucle.png");

		btnConvertir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConvertir.addActionListener(this);
		getContentPane().add(btnConvertir);

		btnAtras = new JButton();
		btnAtras.setAlignmentY(0.0f);
		btnAtras.setFocusPainted(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.setBounds(0, 0, 49, 49);
		btnAtras.setOpaque(true);
		btnAtras.setBorder(null);
		btnAtras.setBackground(new Color(240, 255, 240));
		imgAjustada[1] = new AjustarImagen();
		imgAjustada[1].AjustaImagen(btnAtras, "/imagenes/atras.png");
		btnAtras.addActionListener(this);
		getContentPane().add(btnAtras);

		lblresultado = new JLabel("");
		lblresultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblresultado.setBounds(103, 296, 169, 49);
		contentPane.add(lblresultado);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		conversor = new ConversorTemperatura();
		boolean estaVacio = textFieldValor.getText().isEmpty();
		String resultado = "No es una conversion valida";

		if (e.getSource() == btnConvertir && !estaVacio) {
			try {
				Double valor = Double.parseDouble(textFieldValor.getText());
				String unidadDe = (String) comboBoxDe.getSelectedItem();
				String unidadA = (String) comboBoxA.getSelectedItem();

				switch (unidadDe) {
				case "Celsius":
					switch (unidadA) {
					case "Fahrenheit":
						resultado = conversor.celsiusAFahrenheit(valor);
						break;
					case "Kelvin":
						resultado = conversor.celsiusAkevin(valor);
						break;
					}
					break;
				case "Fahrenheit":
					switch (unidadA) {
					case "Celsius":
						resultado = conversor.FahrenheitAcelsius(valor);
						break;
					case "Kelvin":
						resultado = conversor.fahrenheitAKelvin(valor);
						break;
					}
					break;
				case "Kelvin":
					switch (unidadA) {
					case "Celsius":
						resultado = conversor.kelvinAcelsius(valor);
						break;
					case "Fahrenheit":
						resultado = conversor.KelvinAFahrenheit(valor);
						break;
					}
					break;
				}
				lblresultado.setText(resultado);
			} catch (NumberFormatException ex) {
				lblresultado.setText("Parametro no valido");

			}
		} else if (e.getSource() == btnConvertir && estaVacio) {
			lblresultado.setText("Ingresa un valor");
		} else if (btnAtras == e.getSource()) {
			MenuConversor menu = new MenuConversor();
			this.dispose();

		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();
		boolean numeros = key >= 48 && key <= 59;
		boolean puntoYnegativo = key >= 45 && key <= 46;

		if (!(numeros || puntoYnegativo)) {
			e.consume();

		}

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
