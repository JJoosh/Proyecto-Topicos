package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Catalogo {

	private JFrame frmCatalogo;
	private JTextField txtmateria;
	private JTextField textunidad;
	private JTable tableMateria;
	private DefaultTableModel modelo;
	private DefaultTableModel modelo2;
	private BD bd = new BD();

	public Catalogo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCatalogo = new JFrame();
		frmCatalogo.getContentPane().setBackground(new Color(194, 252, 232));
		frmCatalogo.setTitle("Catalogo");
		frmCatalogo.setBounds(100, 100, 450, 500);
		frmCatalogo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCatalogo.getContentPane().setLayout(null);
		frmCatalogo.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Ingrese los siguientes datos");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(60, 17, 332, 35);
		frmCatalogo.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 172, 257, 146);
		frmCatalogo.getContentPane().add(scrollPane);
		
		tableMateria = new JTable();
		tableMateria.setFont(new Font("Hiragino Sans", Font.PLAIN, 12));
		scrollPane.setViewportView(tableMateria);
		tableMateria.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"<html><b><center>Materia</b></center></html>", "Unidades"
				}
			));
			DefaultTableModel modelo;
			modelo = (DefaultTableModel) tableMateria.getModel();
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Materia:");
		lblNewLabel_1_1.setBounds(22, 64, 167, 16);
		frmCatalogo.getContentPane().add(lblNewLabel_1_1);
		
		txtmateria = new JTextField();
		txtmateria.setColumns(10);
		txtmateria.setBounds(81, 59, 130, 26);
		frmCatalogo.getContentPane().add(txtmateria);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Unidades");
		lblNewLabel_1_1_1.setBounds(22, 126, 167, 16);
		frmCatalogo.getContentPane().add(lblNewLabel_1_1_1);
		
		textunidad = new JTextField();
		textunidad.setColumns(10);
		textunidad.setBounds(81, 121, 130, 26);
		frmCatalogo.getContentPane().add(textunidad);
			
		 modelo2 = bd.tablamaterias();
		 tableMateria.setModel(modelo2);
		 
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 bd.Agregar(txtmateria.getText(),Integer.parseInt(textunidad.getText()));
				
				 modelo2 = bd.tablamaterias();
				 tableMateria.setModel(modelo2);
				
			}
		});
		btnNewButton.setBounds(231, 121, 117, 29);
		frmCatalogo.getContentPane().add(btnNewButton);
		
		JButton btnElimina = new JButton("Eliminar");
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tableMateria.getSelectedRow()>=0) {
					int x = tableMateria.getSelectedRow();
					modelo2.removeRow(x);
				}
			}
		});
		btnElimina.setBounds(22, 330, 117, 29);
		frmCatalogo.getContentPane().add(btnElimina);
		
		JButton btnNewButton_1_1 = new JButton("Modificar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = tableMateria.getSelectedRow();
				int columnaSeleccionada = tableMateria.getSelectedColumn();
				Object nuevoValor = null;
				tableMateria.setValueAt(nuevoValor, filaSeleccionada, columnaSeleccionada);
				tableMateria.repaint();


			}
		});
		btnNewButton_1_1.setBounds(155, 330, 117, 29);
		frmCatalogo.getContentPane().add(btnNewButton_1_1);
		

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("/Users/joshuaaviles/Downloads/pngwing.com (4).png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frmCatalogo.dispose();
					Catalogos c2 = new Catalogos();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(314, 383, 130, 83);
		
		btnNewButton_2.setBorderPainted(false);
		frmCatalogo.getContentPane().add(btnNewButton_2);
		
		 JButton btnNewButton_1 = new JButton("");
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		frmCatalogo.dispose();
	        		try {
						Catalogos ventanaEleccion = new Catalogos();
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	     
	        	}
	        });
	        btnNewButton_1.setIcon(new ImageIcon("/Users/joshuaaviles/Downloads/566095 (1).png"));
	       
	        btnNewButton_1.setContentAreaFilled(false);
			btnNewButton_1.setBackground(new Color(0, 0, 0, 0));
			btnNewButton_1.setBorderPainted(false);
	        btnNewButton_1.setBounds(18, 17, 57, 37);
	        frmCatalogo.getContentPane().add(btnNewButton_1);
	}
}
