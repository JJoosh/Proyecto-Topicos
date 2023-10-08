package main;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;

public class Registro {

    private JFrame frame;
    private JTextField textFieldUser;
    private JButton btnNewButton;
    private JLabel lblNewLabel_1;
    private JPasswordField passwordField;
    private JPasswordField passwordField_1;
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/Portal?useSSL=false&allowPublicKeyRetrieval=true";//biblioteca es el nombre de la base de datos
	private static final String USUARIO = "root";
	private static final String CLAVE = "";

    /**
     * Create the application.
     * @param materia
     */
    public Registro() {
       
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setBounds(00, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JLabel lblNewLabel = new JLabel("Nombre de usuario o correo ");
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setBackground(new Color(0, 0, 0));
        lblNewLabel.setBounds(131, 62, 193, 16);
        frame.getContentPane().add(lblNewLabel);
        
                btnNewButton = new JButton("Siguiente");
                btnNewButton.setBackground(new Color(0, 0, 0));
                btnNewButton.addActionListener(new ActionListener() {
                   public void actionPerformed(ActionEvent e) {
                       //Catalogo c1 = new Catalogo();
                      String  usuario = textFieldUser.getText();
                      String contraseña = new String(passwordField.getPassword());
                       String confirmar = new String(passwordField_1.getPassword());

                       Connection connection = null;
                       PreparedStatement statement = null;

                       try {
                           // Establecer la conexión con la base de datos (ajusta los parámetros según tu configuración)
                           connection =  DriverManager.getConnection(URL, USUARIO, CLAVE);

                           // Preparar la consulta SQL para insertar el registro en la tabla
                           String query = "INSERT INTO Usuarios (usuario, contraseña) VALUES (?, ?)";
                           statement = connection.prepareStatement(query);

                           // Establecer los valores de los parámetros de la consulta
                           statement.setString(1, usuario);
                           statement.setString(2, contraseña);
                      

                           // Ejecutar la consulta
                           statement.executeUpdate();

                           // Cerrar la conexión y el statement
                           statement.close();
                           connection.close();

                           // Continuar con el flujo del programa
                           frame.dispose();
                           // Otro código que desees ejecutar después de guardar en la base de datos
                       } catch (SQLException ex) {
                           ex.printStackTrace();
                           // Manejo de errores
                       }
                      login l2 = new login();
                   }
   
        });
                btnNewButton.setBounds(310, 240, 119, 26);
                frame.getContentPane().add(btnNewButton);

        textFieldUser = new JTextField();
        textFieldUser.setBackground(new Color(239, 239, 247));
        textFieldUser.setBounds(157, 90, 130, 26);
        frame.getContentPane().add(textFieldUser);
        textFieldUser.setColumns(10);

        lblNewLabel_1 = new JLabel("Confirmar contraseña");
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setBounds(157, 189, 153, 16);
        frame.getContentPane().add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("Contraseña");
        lblNewLabel_1_1.setBackground(new Color(255, 255, 255));
        lblNewLabel_1_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1_1.setBounds(186, 121, 106, 16);
        frame.getContentPane().add(lblNewLabel_1_1);
        
                JLabel lblNewLabel_2 = new JLabel("");
                lblNewLabel_2.setIcon(new ImageIcon("/Users/joshuaaviles/Downloads/WhatsApp Image 2023-03-01 at 13.25.32 (2) (1).jpeg"));
                lblNewLabel_2.setBounds(197, 6, 45, 56);
                frame.getContentPane().add(lblNewLabel_2);

        passwordField = new JPasswordField();
        passwordField.setBackground(new Color(236, 236, 245));
        passwordField.setBounds(157, 149, 130, 26);
        frame.getContentPane().add(passwordField);

        passwordField_1 = new JPasswordField();
        passwordField_1.setBackground(new Color(236, 236, 245));
        passwordField_1.setBounds(157, 217, 130, 26);
        frame.getContentPane().add(passwordField_1);
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    frame.dispose();
        	    login l3 = new login();

        	}
        });
        btnNewButton_1.setIcon(new ImageIcon("/Users/joshuaaviles/Downloads/566095 (1).png"));
       
        btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBackground(new Color(0, 0, 0, 0));
		btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.setBounds(6, 6, 57, 37);
        frame.getContentPane().add(btnNewButton_1);
        
        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setIcon(new ImageIcon("/Users/joshuaaviles/Downloads/WhatsApp Image 2023-03-01 at 13.25.32.jpeg"));
        lblNewLabel_3.setBounds(0, 0, 450, 287);
        frame.getContentPane().add(lblNewLabel_3);
    }
}

