package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conversores.ConversorTiempo;
import conversores.MenuConversor;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

import java.text.DecimalFormat;


public class ConversorTiempoGui extends JFrame implements ActionListener, ItemListener, KeyListener {
	private JTextField textFieldValor;
	private JLabel lblTitulo, lblResultado;
	private JButton btnConvertir, btnAtras;
	private JComboBox<String> comboBoxDe, comboBoxA;
	


	public ConversorTiempoGui() {
		getContentPane().setBackground(new Color(255, 248, 220));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		setTitle("CONVERSOR DE TIEMPO");
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void iniciarComponentes() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 373, 411);

		AjustarImagen[] imgAjustada = new AjustarImagen[2];
		comboBoxDe = new JComboBox<String>();
		comboBoxDe.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBoxDe.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Segundos", "Minutos", "Horas", "Días", "Semanas", "Meses", "Años" }));
		comboBoxDe.setBounds(88, 110, 183, 31);
		getContentPane().add(comboBoxDe);
		comboBoxDe.addItemListener(this);

		comboBoxA = new JComboBox<String>();
		comboBoxA.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBoxA.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Segundos", "Minutos", "Horas", "Días", "Semanas", "Meses", "Años" }));
		comboBoxA.setBounds(88, 183, 183, 31);
		getContentPane().add(comboBoxA);
		comboBoxA.addItemListener(this);

		textFieldValor = new JTextField();
		textFieldValor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldValor.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldValor.setBounds(88, 68, 183, 31);
		getContentPane().add(textFieldValor);
		textFieldValor.setColumns(10);
		textFieldValor.addKeyListener(this);

		JLabel lblA = new JLabel("a");
		lblA.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setBounds(164, 152, 30, 20);
		getContentPane().add(lblA);

		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(63, 265, 221, 76);
		getContentPane().add(lblResultado);

		lblTitulo = new JLabel("CONVERSOR DE TIEMPO");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(28, 11, 292, 35);
		getContentPane().add(lblTitulo);

		btnConvertir = new JButton();
		btnConvertir.setBorderPainted(false);
		btnConvertir.setBounds(153, 225, 49, 49);
		btnConvertir.setBackground(new Color(255, 248, 220));
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
		btnAtras.setBackground(new Color(255, 248, 220));
		imgAjustada[1] = new AjustarImagen();
		imgAjustada[1].AjustaImagen(btnAtras, "/imagenes/atras.png");
		btnAtras.addActionListener(this);
		getContentPane().add(btnAtras);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ConversorTiempo conversor = new ConversorTiempo();
		boolean estaVacio = textFieldValor.getText().isEmpty();
		String resultado = "0";
		
		if (e.getSource() == btnConvertir && !estaVacio) {
			try {
				Double valor = Double.parseDouble(textFieldValor.getText());
				String unidadDe = (String) comboBoxDe.getSelectedItem();
				String unidadA = (String) comboBoxA.getSelectedItem();
				switch (unidadDe) {
				case "Segundos":
					resultado = conversor.convertirSegundos(valor, unidadA) +" "+ unidadA;
					break;
				case "Minutos":
					resultado = conversor.convertirMinutos(valor, unidadA)+" "+ unidadA;
					break;
				case "Horas":
					resultado = conversor.convertirHoras(valor, unidadA)+" "+ unidadA;
					break;
				case "Días":
					resultado = conversor.convertirDias(valor, unidadA)+" "+ unidadA;
					break;
				case "Semanas":
					resultado = conversor.convertirSemanas(valor, unidadA)+" "+ unidadA;
					break;
				case "Meses":
					resultado = conversor.convertirMeses(valor, unidadA)+" "+ unidadA;
					break;
				case "Años":
					resultado = conversor.convertirAnios(valor, unidadA)+" "+ unidadA;
					break;
				}

			} catch (NumberFormatException ex) {
				resultado = "No es un parámetro válido";
			}
			lblResultado.setText(resultado);
		} else if (e.getSource() == btnConvertir && estaVacio) {
			lblResultado.setText("Ingresa un valor");
		} else if (btnAtras == e.getSource()) {
			MenuConversor menu = new MenuConversor();
			this.dispose();

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		char key = e.getKeyChar();
		boolean numeros = key >= 48 && key <= 59;
		boolean punto = key == 46;

		if (!(numeros || punto)) {
			e.consume();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		
	}
}
