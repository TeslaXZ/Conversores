package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Cursor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import javax.swing.UIManager;

import conversores.MenuConversor;

import conversores.OperacionesDeConversion;
import javax.swing.ImageIcon;
import java.awt.SystemColor;


@SuppressWarnings("serial")
public class ConversorMonedaGui extends JFrame implements ActionListener, ItemListener, KeyListener {

	private JPanel contentPane;
	private JComboBox<String> comboBoxMonedas;
	private JTextField textFieldValorAconvertir;
	private JButton btnConvertir,btnAtras;
	private JLabel lblResultado;
	private OperacionesDeConversion operaciones;
	


	public ConversorMonedaGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		setTitle("CONVERSOR DE MONEDA");
		setResizable(false);
		setLocationRelativeTo(null);
	}

	/**
	 * Asigna las operaciones de conversión al conversor gráfico.
	 *
	 * @param misOperaciones Las operaciones de conversión a asignar.
	 */
	public void asignarOperaciones(OperacionesDeConversion misOperaciones) {
		this.operaciones = misOperaciones;
	}

	/**
	 * Inicializa los componentes de la interfaz gráfica.
	 */
	private void iniciarComponentes() {
		setBounds(100, 100, 517, 360);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		AjustarImagen[] imgAjustada = new AjustarImagen[2];

		JLabel lblTitulo = new JLabel("CONVERSOR DE MONEDAS");
		lblTitulo.setBounds(32, 44, 447, 51);
		lblTitulo.setFont(new Font("Cambria", Font.BOLD, 22));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		
		comboBoxMonedas = new JComboBox<String>();
		comboBoxMonedas.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBoxMonedas.setBounds(212, 169, 215, 32);
		comboBoxMonedas.setModel(new DefaultComboBoxModel<String>(new String[] { "Bolivares a Dolares",
				"Bolivares a Euros", "Bolivares a Yen japones", "Bolivares a Libras Esterlinas",
				"Bolivares a Won-Sul Coreano", "Dolares a Bolivares", "Euros a Bolivares", "Yen Japones a Bolivares",
				"Libras Esterlinas a Bolivares", "Won Sul-Coreano a Bolivares" }));

		comboBoxMonedas.setToolTipText("");
		comboBoxMonedas.addItemListener(this);

		textFieldValorAconvertir = new JTextField();
		textFieldValorAconvertir.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldValorAconvertir.setBounds(32, 170, 168, 31);
		textFieldValorAconvertir.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldValorAconvertir.addKeyListener(this);
		textFieldValorAconvertir.setColumns(10);

		btnConvertir = new JButton();
		btnConvertir.setBorderPainted(false);
		btnConvertir.setBounds(437, 169, 42, 32);
		btnConvertir.setBackground(new Color(255, 255, 224));
		imgAjustada[0] = new AjustarImagen();
		imgAjustada[0].AjustaImagen(btnConvertir,"/imagenes/flecha-de-bucle.png");
		

		btnConvertir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConvertir.addActionListener(this);

		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblResultado.setBounds(132, 212, 252, 99);
		lblResultado.setBorder(null);
		lblResultado.setBackground(new Color(255, 255, 255));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblImporte = new JLabel("Importe");
		lblImporte.setBounds(78, 134, 79, 32);
		lblImporte.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.setLayout(null);
		contentPane.add(lblTitulo);
		contentPane.add(comboBoxMonedas);
		contentPane.add(textFieldValorAconvertir);
		contentPane.add(btnConvertir);
		contentPane.add(lblResultado);
		contentPane.add(lblImporte);

		btnAtras = new JButton();
		btnAtras.setFocusPainted(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.setBounds(0, 0, 49, 51);
		btnAtras.setOpaque(true);
		btnAtras.setBorder(null);
		btnAtras.setBackground(new Color(255, 255, 224));
		imgAjustada[1] = new AjustarImagen();
		imgAjustada[1].AjustaImagen(btnAtras,"/imagenes/atras.png");
		btnAtras.addActionListener(this);
		contentPane.add(btnAtras);

	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		String moneda = (String) comboBoxMonedas.getSelectedItem();
		boolean estaVacio = textFieldValorAconvertir.getText().isEmpty();
		if (btnConvertir == e.getSource() && !estaVacio) {
			try {
				double importe = Double.parseDouble(textFieldValorAconvertir.getText());
				String resultado = operaciones.ConversorDeMoneda(moneda, importe);
				lblResultado.setText(resultado);
			} catch (NumberFormatException ex) {
				lblResultado.setText("No es un parametro valido");
			}
		} else if (btnAtras == e.getSource()) {
			MenuConversor menu = new MenuConversor();
			this.dispose();

		}

		else if (estaVacio) {
			lblResultado.setText("Ingresa un valor");
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		int key = e.getKeyChar();
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
}