package main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frmLogin;
	private JTextField textField;
	private BD bd=new BD();

	

	public login() { 

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.setVisible(true);
		
		JButton btnNewButton_1 = new JButton("<html><u> ¿ Registrarse ? </u></html>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLogin.dispose();
				Registro r1 = new Registro();
			}
		});
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBackground(new Color(0, 0, 0, 0));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(115, 243, 195, 29);
		frmLogin.getContentPane().add(btnNewButton_1);
	
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_1.setBackground(new Color(210, 210, 210));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(150, 164, 109, 16);
		frmLogin.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(145, 183, 130, 26);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("/Users/joshuaaviles/Downloads/logo Sistemas.png"));
		lblNewLabel_3.setBounds(166, 69, 109, 91);
		frmLogin.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				bd.Conectar();
				boolean existe=false;
				existe=bd.BuscarUser(textField.getText());
				
				if(existe==true) {
					frmLogin.dispose();
					//JOptionPane.showMessageDialog(null, "Ingrese un usuario valido");
					password pwd = new password();
				}
				else {
					JOptionPane.showMessageDialog(null, "Ingrese un usuario valido");
				}
			
				
			}
		});
		btnNewButton.setBounds(150, 217, 117, 29);
		frmLogin.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/joshuaaviles/Downloads/WhatsApp Image 2023-03-01 at 13.25.32.jpeg"));
		lblNewLabel_2.setBounds(0, -5, 450, 277);
		frmLogin.getContentPane().add(lblNewLabel_2);
		
	}
}
