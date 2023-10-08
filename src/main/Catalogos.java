package main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;

public class Catalogos {

	private JFrame frame;


	public Catalogos() throws InstantiationException, IllegalAccessException, ClassNotFoundException, UnsupportedLookAndFeelException {
		initialize();
	}

	 public void Eleccion() throws InstantiationException, IllegalAccessException, ClassNotFoundException, UnsupportedLookAndFeelException {
	        initialize();
	    }

	    private void initialize() throws InstantiationException, IllegalAccessException, ClassNotFoundException, UnsupportedLookAndFeelException {

	        frame = new JFrame();
	        frame.setBounds(100, 100, 500, 500);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(3, 1, 10, 10));

	        Font buttonFont = new Font("Arial", Font.BOLD, 20);
	        
	        JButton btnAgregarCatalogoAl = new JButton("Registrar Alumnos");
	        btnAgregarCatalogoAl.setFont(buttonFont);
	        btnAgregarCatalogoAl.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	CatalogoAlumno ca = new CatalogoAlumno();
	                frame.dispose();
	            }
	        });

	        JButton btnAgregarCatalogo = new JButton("Registrar Materias");
	        btnAgregarCatalogo.setFont(buttonFont);
	        btnAgregarCatalogo.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               Catalogo c1 = new Catalogo();
	                frame.dispose();
	            }
	        });
	        JButton btnAgregarEleccion = new JButton("Regresar");
	        btnAgregarEleccion.setFont(buttonFont);
	        btnAgregarEleccion.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	           
					Eleccion e2 = new Eleccion();
	                frame.dispose();
	            }
	        });

	        panel.add(btnAgregarCatalogoAl);
	        panel.add(btnAgregarCatalogo);
	        panel.add(btnAgregarEleccion);
	      

	        try {
	            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("/Users/joshuaaviles/Downloads/WhatsApp Image 2023-03-01 at 13.25.32.jpeg")))));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        frame.setLayout(new GridBagLayout());
	        frame.add(panel);
	        frame.pack();
	        frame.setVisible(true);
	        
	        
	    }
	
 } 

