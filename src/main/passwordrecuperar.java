package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class passwordrecuperar extends Thread {
	private JFrame frmRecuperarContraseña;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField newPasswordField;
	private String usuario;
	private String contraseña;
	//private String userAdmin;
	private Connection conexion;
	private BD bd=new BD();

	public passwordrecuperar() {
		bd.Conectar();
	}

	public void run() {
		initialize();
	}


	private void initialize() {
		frmRecuperarContraseña = new JFrame();
		frmRecuperarContraseña.setTitle("Recuperar Contraseña");
		frmRecuperarContraseña.setResizable(false);
		frmRecuperarContraseña.setBounds(100, 100, 450, 360);
		frmRecuperarContraseña.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRecuperarContraseña.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_1.setBackground(new Color(210, 210, 210));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(150, 57, 109, 16);
		frmRecuperarContraseña.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ingrese su correo electrónico registrado");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(62, 125, 316, 20);
		frmRecuperarContraseña.getContentPane().add(lblNewLabel_2);

		textField = new JTextField();
		textField.setBounds(145, 75, 130, 26);
		frmRecuperarContraseña.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("/Users/joshuaaviles/Downloads/logo Sistemas.png"));
		lblNewLabel_3.setBounds(166, 6, 109, 49);
		frmRecuperarContraseña.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contraseña actual");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(63, 175, 152, 20);
		frmRecuperarContraseña.getContentPane().add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(224, 173, 130, 26);
		frmRecuperarContraseña.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_5 = new JLabel("Nueva Contraseña");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(63, 220, 152, 20);
		frmRecuperarContraseña.getContentPane().add(lblNewLabel_5);
		
		newPasswordField = new JPasswordField();
		newPasswordField.setBounds(224, 218, 130, 26);
		frmRecuperarContraseña.getContentPane().add(newPasswordField);
		
		JButton btnNewButton = new JButton("Cambiar Contraseña");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField.getText();
				char[] password = passwordField.getPassword();
				char[] newPassword = newPasswordField.getPassword();
				String passwordString = new String(password);
				String newPasswordString = new String(newPassword);
				if (email.equals("") || passwordString.equals("") || newPasswordString.equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
				} else {
					bd.recuperar(email, passwordString, newPasswordString);
				}
			}
		});
		btnNewButton.setBounds(145, 266, 160, 29);
		frmRecuperarContraseña.getContentPane().add(btnNewButton);
		frmRecuperarContraseña.setVisible(true);
		
		 JButton btnNewButton_1 = new JButton("");
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		frmRecuperarContraseña.dispose();
						password p2 = new password();
				
	     
	        	}
	        });
	        btnNewButton_1.setIcon(new ImageIcon("/Users/joshuaaviles/Downloads/566095 (1).png"));
	       
	        btnNewButton_1.setContentAreaFilled(false);
			btnNewButton_1.setBackground(new Color(0, 0, 0, 0));
			btnNewButton_1.setBorderPainted(false);
	        btnNewButton_1.setBounds(18, 17, 57, 37);
	        frmRecuperarContraseña.getContentPane().add(btnNewButton_1);
	}
}

		
	