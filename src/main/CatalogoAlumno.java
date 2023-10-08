package main;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CatalogoAlumno {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CatalogoAlumno window = new CatalogoAlumno();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	private JFrame frame;
	private final JLabel lblNewLabel = new JLabel("Ingrese los siguientes datos");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblSemestre;
	private JLabel lblSemestre_1;
	private JButton btnModificar;
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton btnNewButton_1;
	private JComboBox <String> comboBox;
	private DefaultComboBoxModel <String> o = new DefaultComboBoxModel <String> (); 
	private BD bd = new BD();
	
	public CatalogoAlumno() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(115, 6, 222, 29);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(43, 74, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(43, 123, 130, 26);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(43, 172, 130, 26);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(43, 220, 130, 26);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(244, 74, 130, 26);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(244, 123, 130, 26);
		frame.getContentPane().add(textField_5);
		
		JLabel lblNombre = new JLabel("Nombre completo");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(-11, 45, 222, 29);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatricula.setBounds(-33, 96, 222, 29);
		frame.getContentPane().add(lblMatricula);
		
		JLabel lblFechaDeNacimeinto = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimeinto.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaDeNacimeinto.setBounds(20, 149, 179, 29);
		frame.getContentPane().add(lblFechaDeNacimeinto);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdad.setBounds(6, 200, 111, 29);
		frame.getContentPane().add(lblEdad);
		
		lblSemestre = new JLabel("Carrera");
		lblSemestre.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemestre.setBounds(157, 45, 222, 29);
		frame.getContentPane().add(lblSemestre);
		
		lblSemestre_1 = new JLabel("Semestre");
		lblSemestre_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemestre_1.setBounds(168, 102, 222, 29);
		frame.getContentPane().add(lblSemestre_1);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textField.getText();
				int matricula = Integer.parseInt(textField_1.getText());
				String fechaNacimiento = textField_2.getText();
				int edad = Integer.parseInt(textField_3.getText());
				String carrera = textField_4.getText();
				int semestre = Integer.parseInt(textField_5.getText()); 
				
				//frame.dispose();
				bd.agregartablaalumno(nombre, matricula, fechaNacimiento, edad, carrera, semestre, comboBox.getSelectedItem().toString() );
				bd.tablaalumnos();
			
			}
		});
		btnNewButton.setBounds(220, 220, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(327, 220, 117, 29);
		frame.getContentPane().add(btnEliminar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(442, 220, 117, 29);
		frame.getContentPane().add(btnModificar);
		
		// Crear la tabla y el modelo de tabla
		table = new JTable();
		tableModel = new DefaultTableModel();
		table.setModel(tableModel);
		
		// Añadir columnas al modelo de tabla
		tableModel.addColumn("Nombre");
		tableModel.addColumn("Matricula");
		tableModel.addColumn("Fecha de nacimiento");
		tableModel.addColumn("Edad");
		tableModel.addColumn("Carrera");
		tableModel.addColumn("Semestre");
		
		// Crear el scroll pane para la tabla
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 290, 588, 72);
		frame.getContentPane().add(scrollPane);
		
		btnNewButton_1 = new JButton("Siguiente");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JOptionPane.showMessageDialog(null, "Listo ya se ha registrado");
				try {
					Catalogos c2 = new Catalogos();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
						| UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(456, 397, 117, 29);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblSemestre_1_1 = new JLabel("Materia");
		lblSemestre_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemestre_1_1.setBounds(157, 149, 222, 29);
		frame.getContentPane().add(lblSemestre_1_1);

		
		// Dentro del bloque de código del ActionListener del botón "Eliminar"
		btnEliminar.addActionListener(e -> {
		    // Obtener el índice de la fila seleccionada
		    int selectedRow = table.getSelectedRow();
		    
		    if (selectedRow >= 0) {
		        // Eliminar la fila seleccionada del modelo de tabla
		        tableModel.removeRow(selectedRow);
		    }
		});

		// Dentro del bloque de código del ActionListener del botón "Modificar"
		btnModificar.addActionListener(e -> {
		    // Obtener el índice de la fila seleccionada
		    int selectedRow = table.getSelectedRow();
		    
		    if (selectedRow >= 0) {
		        // Obtener los nuevos datos ingresados en los campos de texto
		        String nombre = textField.getText();
		        String matricula = textField_1.getText();
		        String fechaNacimiento = textField_2.getText();
		        String edad = textField_3.getText();
		        String carrera = textField_4.getText();
		        String semestre = textField_5.getText();
		        
		        // Actualizar los valores en el modelo de tabla
		        tableModel.setValueAt(nombre, selectedRow, 0);
		        tableModel.setValueAt(matricula, selectedRow, 1);
		        tableModel.setValueAt(fechaNacimiento, selectedRow, 2);
		        tableModel.setValueAt(edad, selectedRow, 3);
		        tableModel.setValueAt(carrera, selectedRow, 4);
		        tableModel.setValueAt(semestre, selectedRow, 5);
		        
		        // Limpiar los campos de texto después de modificar los datos
		        textField.setText("");
		        textField_1.setText("");
		        textField_2.setText("");
		        textField_3.setText("");
		        textField_4.setText("");
		        textField_5.setText("");
		    }
		    
		});
		o=bd.comboxmaterias();
		comboBox = new JComboBox<String> (o);
		
		comboBox.setBounds(242, 181, 95, 27);
		frame.getContentPane().add(comboBox);
		
		 JButton btnNewButton_1 = new JButton("");
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	    frame.dispose();
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
	        btnNewButton_1.setBounds(6, 6, 57, 37);
	        frame.getContentPane().add(btnNewButton_1);
	    }
		
		
	}


