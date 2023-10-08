package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPasswordField;

public class password {

	private JFrame frame;
	private JPasswordField passwordField;
	private BD bd=new BD();


	
	public password() {

		initialize();
	}


	private void initialize() {
		
		
	
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 192, 115, 26);
		frame.getContentPane().add(passwordField);

		
		JButton btnNewButton_1 = new JButton("<html><u>¿ Recuperar contraseña ?</u></html>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				passwordrecuperar Pr = new passwordrecuperar();
				Pr.start();
			}
		});
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBackground(new Color(0, 0, 0, 0));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(96, 243, 240, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_1.setBackground(new Color(210, 210, 210));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(158, 172, 109, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("/Users/joshuaaviles/Downloads/logo Sistemas.png"));
		lblNewLabel_3.setBounds(166, 69, 109, 91);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bd.Conectar();
				 bd.Buscarpass(passwordField.getText());
				
				if( bd.Buscarpass(passwordField.getText())==true) {
						frame.dispose();
						Eleccion E1 = new Eleccion();
					} else {
					JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
					//System.out.println("nada");
	
				}
					
			}
		});
		btnNewButton.setBounds(160, 221, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/joshuaaviles/Downloads/WhatsApp Image 2023-03-01 at 13.25.32.jpeg"));
		lblNewLabel_2.setBounds(0, 0, 450, 272);
		frame.getContentPane().add(lblNewLabel_2);
	}

}
