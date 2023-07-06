package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import javax.swing.JTable;

import conversores.*;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class MenuPrincipalGui extends JFrame implements ActionListener {

	private JPanel contentPane;
	JButton btnConversorDeMoneda, btnTemperatura, btnConversorDeTiempo;
	private JLabel lblConversorDivisas;
	private JLabel lblConversorTemperatura;
	private JLabel lblConversorTiempo;

	public MenuPrincipalGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		setTitle("CONVERSOR");
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void iniciarComponentes() {

		setBounds(100, 100, 422, 257);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		Color c = UIManager.getLookAndFeel().getDefaults().getColor("Panel.background");
		AjustarImagen[] btnAjustado = new AjustarImagen[3];

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnConversorDeMoneda = new JButton("");
		btnConversorDeMoneda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConversorDeMoneda.setBorderPainted(false);
		btnConversorDeMoneda.setOpaque(true);
		btnConversorDeMoneda.setBorder(null);
		btnConversorDeMoneda.setBackground(new Color(c.getRed(), c.getGreen(), c.getBlue()));
		btnConversorDeMoneda.setBounds(10, 52, 114, 98);

		
		btnAjustado[0] = new AjustarImagen();
		btnAjustado[0].AjustaImagen(btnConversorDeMoneda, "/imagenes/cambio-de-divisas.png");

		contentPane.add(btnConversorDeMoneda);

		btnTemperatura = new JButton("");
		btnTemperatura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTemperatura.setFocusPainted(false);
		btnTemperatura.setBorderPainted(false);
		btnTemperatura.setBounds(145, 52, 114, 98);
		btnTemperatura.setOpaque(true);
		btnTemperatura.setBorder(null);
		btnAjustado[1] = new AjustarImagen();
		btnAjustado[1].AjustaImagen(btnTemperatura, "/imagenes/termometro.png");
		btnTemperatura.addActionListener(this);
		contentPane.add(btnTemperatura);

		btnConversorDeTiempo = new JButton("");
		btnConversorDeTiempo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConversorDeTiempo.setFocusPainted(false);
		btnConversorDeTiempo.setBorderPainted(false);
		btnConversorDeTiempo.setBounds(282, 52, 114, 98);
		btnConversorDeTiempo.setOpaque(true);
		btnConversorDeTiempo.setBorder(null);
		btnAjustado[2] = new AjustarImagen();
		btnAjustado[2].AjustaImagen(btnConversorDeTiempo, "/imagenes/el-tiempo-pasa.png");
		contentPane.add(btnConversorDeTiempo);
		btnConversorDeTiempo.addActionListener(this);

		JLabel lblNewLabel = new JLabel("Elige el tipo de conversor");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(78, 11, 257, 30);
		contentPane.add(lblNewLabel);

		lblConversorDivisas = new JLabel("Divisas");
		lblConversorDivisas.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConversorDivisas.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversorDivisas.setBounds(20, 161, 104, 30);
		contentPane.add(lblConversorDivisas);

		lblConversorTemperatura = new JLabel("Temperatura");
		lblConversorTemperatura.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConversorTemperatura.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversorTemperatura.setBounds(155, 161, 104, 30);
		contentPane.add(lblConversorTemperatura);

		lblConversorTiempo = new JLabel("Tiempo");
		lblConversorTiempo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblConversorTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversorTiempo.setBounds(292, 161, 86, 30);
		contentPane.add(lblConversorTiempo);
		btnConversorDeMoneda.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnConversorDeMoneda) {
			ConversorDeMoneda conversorM = new ConversorDeMoneda();

		} else if (e.getSource() == btnTemperatura) {
			ConversorTemperatura conversorT = new ConversorTemperatura();
			ConversorTemperaturaGui guiT = new ConversorTemperaturaGui();
			guiT.setVisible(true);

		} else if (e.getSource() == btnConversorDeTiempo) {
			ConversorTiempo conversotTm = new ConversorTiempo();
			ConversorTiempoGui guiTm = new ConversorTiempoGui();
			guiTm.setVisible(true);

		}
		this.dispose();

	}

}
