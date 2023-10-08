package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AlumnosTabla {
	
	
	
	private JFrame frame;
    private DefaultTableModel modelo;
	//private Object[][] rowDatas;
	private JTextField textFieldnombre;
	private TableRowSorter trsfiltro;
	private String filtro;
	private JLabel lblNewLabel_1;
	JTextField textField;
	private BD bd = new BD();
	private DefaultComboBoxModel <String> o = new DefaultComboBoxModel <String> ();
	private JComboBox comboBox;
    private DefaultTableModel M = null;
	private JComboBox<String> genderComboBox;
	private TableColumn genderColumn; 
 
    

    public AlumnosTabla()
    {
   
    	
    	
    	initialize();
    }

	public void initialize() {
		
       
		M=bd.r();
		// Configuración del JFrame
		frame = new JFrame("Tabla de Alumnos");
		frame.setResizable(false);
	    frame.getContentPane().setBackground(new Color(255, 255, 255));
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
       // frame.pack();
        frame.setBounds(100, 100, 600, 500);
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setForeground(new Color(232, 255, 233));
        
    	lblNewLabel_1 = new JLabel(" Lista de alumnos de:");
        lblNewLabel_1.setFont(new Font("Myanmar MN", Font.BOLD, 23));
        lblNewLabel_1.setBounds(203, 14, 316, 42);
        panel.add(lblNewLabel_1);

             JTable table = new JTable();
             table.setModel(M);
             
             genderColumn = table.getColumnModel().getColumn(2);
             genderComboBox = new JComboBox<String>();
             
             TableColumn listaColumn = table.getColumnModel().getColumn(1);
             listaColumn.setPreferredWidth(250);
             listaColumn = table.getColumnModel().getColumn(0);
             listaColumn.setPreferredWidth(50);
             
             genderComboBox.addItem("P");
             genderComboBox.addItem("A");
             genderColumn.setCellEditor(new DefaultCellEditor(genderComboBox));
             genderColumn.setCellRenderer(new DefaultTableCellRenderer());
             panel.setLayout(null);  
             genderColumn = table.getColumnModel().getColumn(2);
             genderColumn.setCellEditor(new DefaultCellEditor(genderComboBox));
             genderColumn.setCellRenderer(new DefaultTableCellRenderer());
             
             
             
             
             JScrollPane scrollPane = new JScrollPane(table);
             scrollPane.setBounds(6, 140, 588, 315);
             panel.add(scrollPane);
             frame.getContentPane().add(panel);
             
             
             
             JLabel lblNewLabel_2_1 = new JLabel("ingresa nombre");
             lblNewLabel_2_1.setBounds(17, 112, 106, 16);
             panel.add(lblNewLabel_2_1);
             
             textFieldnombre = new JTextField();
             textFieldnombre.addKeyListener(new KeyAdapter() {
             	@Override
             	public void keyTyped(KeyEvent e) {
             		trsfiltro = new TableRowSorter(table.getModel());
             		table.setRowSorter(trsfiltro); 
             	}
             });
             
          
             textFieldnombre.setBounds(125, 107, 156, 26);
             panel.add(textFieldnombre);
             textFieldnombre.setColumns(10);
             
             JButton btnNewButton = new JButton("Buscar alumno");
             btnNewButton.addActionListener(new ActionListener() {
             	public void actionPerformed(ActionEvent e) {
              		 String nombre = textFieldnombre.getText().trim();
              		 textFieldnombre.setText(nombre);
              		 frame.repaint();
              		 filtro();
                          
               		
               		}
             });
             btnNewButton.setBounds(280, 107, 127, 28);
             panel.add(btnNewButton);
             	
             
             JSeparator separator = new JSeparator();
             separator.setForeground(Color.BLACK);
             separator.setBounds(0, 84, 594, 16);
             panel.add(separator);
             
             JButton btnNewButton_1 = new JButton("");
             btnNewButton_1.addActionListener(new ActionListener() {
             	public void actionPerformed(ActionEvent e) {
             	    frame.dispose();
             	    Eleccion ventanaEleccion = new Eleccion();
          
             	}
             });
             btnNewButton_1.setIcon(new ImageIcon("/Users/joshuaaviles/Downloads/566095 (1).png"));
             
             btnNewButton_1.setContentAreaFilled(false);
     		 btnNewButton_1.setBackground(new Color(0, 0, 0, 0));
     		 btnNewButton_1.setBorderPainted(false);
             btnNewButton_1.setBounds(4, 9, 55, 47);
             panel.add(btnNewButton_1);
             
             comboBox = new JComboBox();
             o=bd.comboxmaterias();
     		 comboBox = new JComboBox<String> (o);
     		 comboBox.setBounds(161, 51, 95, 27);
             comboBox.setBounds(161, 51, 189, 27);
             panel.add(comboBox);
             
             JButton btnAceptar = new JButton("Aceptar");
             btnAceptar.addActionListener(new ActionListener() {
             	public void actionPerformed(ActionEvent e) {
             		
             		bd.mostrarcolumnaalumnos(comboBox.getSelectedItem().toString());
             		M=bd.r();
             		table.setModel(M);
             	}
             });
             btnAceptar.setBounds(362, 50, 127, 28);
             panel.add(btnAceptar);
             
             JButton btnGuardar = new JButton("Guardar");
             btnGuardar.addActionListener(new ActionListener() {
             	public void actionPerformed(ActionEvent e) {
             		  for (int row = 0; row < table.getRowCount(); row++) {
             	            Object nombreObject = table.getValueAt(row, 1);
             	            
             	            // Si algún valor es null, se asigna una cadena vacía en lugar de null.
             	            String nombre = nombreObject != null ? nombreObject.toString() : "";
             	            String materia = comboBox.getSelectedItem().toString();
             	            String asistencia = genderComboBox.getSelectedItem().toString();
             	           	//bd.updateAsistencia(nombre, materia, asistencia);
             	            // Verifica si nombre, materia o asistencia están vacíos
             	            if(!nombre.isEmpty() && !materia.isEmpty() && !asistencia.isEmpty()) {
             	            	System.out.print("se guardo");
             	            	
             	                bd.updateAsistencia(nombre, materia, asistencia);
             	            } else {
             	            	//bd.updateAsistencia(nombre, materia, asistencia);// Manejar el caso cuando nombre, materia o asistencia están vacíos
             	            }
             	        }
             	}
             });
             btnGuardar.setBounds(406, 107, 127, 28);
             panel.add(btnGuardar);
       
             
 
       
	}
	   public void filtro() {
      	 filtro = textFieldnombre.getText();
      	 trsfiltro.setRowFilter(RowFilter.regexFilter(textFieldnombre.getText(), 0, 1));
       }

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

