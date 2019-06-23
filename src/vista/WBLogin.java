package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ButtonGroup;

public class WBLogin extends JFrame {

	private static final long serialVersionUID = -2918795942308519739L;
	private Coordinador coord; // Permite la relacion entre esta clase y la clase coordinador
	private JPanel contentPane;
	private JTextField usuarioField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public WBLogin() {
		setTitle("Login - Gesfarma");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 105, 124, 142, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 15, 20, 19, 23, 23, 25, 18, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lblUsuario = new JLabel("Usuario:");
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 0;
		contentPane.add(lblUsuario, gbc_lblUsuario);

		JLabel lblGesfarma = new JLabel("GESFARMA");
		lblGesfarma.setFont(new Font("URW Chancery L", Font.BOLD, 20));
		GridBagConstraints gbc_lblGesfarma = new GridBagConstraints();
		gbc_lblGesfarma.insets = new Insets(0, 0, 5, 0);
		gbc_lblGesfarma.gridx = 2;
		gbc_lblGesfarma.gridy = 0;
		contentPane.add(lblGesfarma, gbc_lblGesfarma);

		usuarioField = new JTextField();
		GridBagConstraints gbc_usuarioField = new GridBagConstraints();
		gbc_usuarioField.anchor = GridBagConstraints.NORTH;
		gbc_usuarioField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usuarioField.insets = new Insets(0, 0, 5, 5);
		gbc_usuarioField.gridx = 1;
		gbc_usuarioField.gridy = 1;
		contentPane.add(usuarioField, gbc_usuarioField);
		usuarioField.setColumns(10);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				coord.mostrarWBNuevoUsuario(true);
			}
		});
		ImageIcon icono = new ImageIcon("images/logo.jpeg");
		JLabel imagen = new JLabel(icono);
		GridBagConstraints gbc_imagen = new GridBagConstraints();
		gbc_imagen.fill = GridBagConstraints.BOTH;
		gbc_imagen.insets = new Insets(0, 0, 5, 5);
		gbc_imagen.gridheight = 4;
		gbc_imagen.gridx = 0;
		gbc_imagen.gridy = 2;
		contentPane.add(imagen, gbc_imagen);

		JLabel lblContrasena = new JLabel("Contraseña:");
		GridBagConstraints gbc_lblContrasena = new GridBagConstraints();
		gbc_lblContrasena.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblContrasena.insets = new Insets(0, 0, 5, 5);
		gbc_lblContrasena.gridx = 1;
		gbc_lblContrasena.gridy = 2;
		contentPane.add(lblContrasena, gbc_lblContrasena);

		JLabel lblRegistro = new JLabel("¿No estás registrado?");
		GridBagConstraints gbc_lblRegistro = new GridBagConstraints();
		gbc_lblRegistro.insets = new Insets(0, 0, 5, 0);
		gbc_lblRegistro.gridx = 2;
		gbc_lblRegistro.gridy = 2;
		contentPane.add(lblRegistro, gbc_lblRegistro);
		GridBagConstraints gbc_btnRegistrarse = new GridBagConstraints();
		gbc_btnRegistrarse.anchor = GridBagConstraints.NORTH;
		gbc_btnRegistrarse.insets = new Insets(0, 0, 5, 0);
		gbc_btnRegistrarse.gridx = 2;
		gbc_btnRegistrarse.gridy = 3;
		contentPane.add(btnRegistrarse, gbc_btnRegistrarse);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 3;
		contentPane.add(passwordField, gbc_passwordField);

		JButton btnIniciarSesion = new JButton("Iniciar sesión");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String usuario = usuarioField.getText();
				char[] clave = passwordField.getPassword();
				int respuesta = 0;
				respuesta = coord.login(usuario, clave); // trabajador

				if (respuesta == 0) { // si son incorrectos los datos
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
				} else { // si es trabajador
					coord.mostrarWBGesfarma(true);
					coord.fijarUsuario(usuario, true);
					coord.mostrarWBLogin(false);
				}
			}
		});
		GridBagConstraints gbc_btnIniciarSesion = new GridBagConstraints();
		gbc_btnIniciarSesion.fill = GridBagConstraints.BOTH;
		gbc_btnIniciarSesion.insets = new Insets(0, 0, 5, 5);
		gbc_btnIniciarSesion.gridx = 1;
		gbc_btnIniciarSesion.gridy = 4;
		contentPane.add(btnIniciarSesion, gbc_btnIniciarSesion);

		JLabel lblContacto = new JLabel("Contacto: info@gesfarma.com");
		GridBagConstraints gbc_lblContacto = new GridBagConstraints();
		gbc_lblContacto.insets = new Insets(0, 0, 5, 5);
		gbc_lblContacto.anchor = GridBagConstraints.WEST;
		gbc_lblContacto.fill = GridBagConstraints.VERTICAL;
		gbc_lblContacto.gridx = 1;
		gbc_lblContacto.gridy = 5;
		contentPane.add(lblContacto, gbc_lblContacto);

	}

	public void setCoordinador(Coordinador coord) {
		this.coord = coord;

	}
}
