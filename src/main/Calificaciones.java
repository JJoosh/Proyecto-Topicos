package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Calificaciones {

    private JFrame frame;
    private JTable table;
    private DefaultTableModel modelo;
    private JComboBox<String> comboBox;

    private BD bd = new BD();

    public Calificaciones() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(100, 100, 600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(96, 128, 408, 250);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JButton btnNewButton = createButton("Eliminar", 450, 96, 95, 27);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    modelo.removeRow(selectedRow);
                }
            }
        });
        frame.getContentPane().add(btnNewButton);

        JButton btnAgregar = createButton("Aceptar", 350, 96, 95, 27);
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedMateria = comboBox.getSelectedItem().toString();
                modelo = bd.tablacal(selectedMateria);
                table.setModel(modelo);
            }
        });
        frame.getContentPane().add(btnAgregar);

        JLabel lblNewLabel_1 = new JLabel("Calificaciones");
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 24));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(168, 30, 266, 30);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("Selecciona una materia");
        lblNewLabel.setBounds(96, 100, 160, 16);
        frame.getContentPane().add(lblNewLabel);

        comboBox = new JComboBox<>(bd.comboxmaterias());
        comboBox.setBounds(253, 96, 95, 27);
        frame.getContentPane().add(comboBox);

        JButton btnEnviarCalificaciones = createButton("Enviar Calificaciones", 222, 400, 180, 30);
        btnEnviarCalificaciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int x = 0; x < modelo.getRowCount(); x++) {
                    String nombre = modelo.getValueAt(x, 0) != null ? modelo.getValueAt(x, 0).toString() : null;
                    String materia = comboBox.getSelectedItem() != null ? comboBox.getSelectedItem().toString() : null;
                    for (int i = 1; i < modelo.getColumnCount(); i++) {
                        String unidad = Integer.toString(i);
                        Object cellValue = modelo.getValueAt(x, i);
                        if (cellValue != null) {
                            String cellValueString = cellValue.toString();
                            float cellValueFloat = Float.parseFloat(cellValueString);
                            bd.ingresarcal(nombre, materia, unidad, cellValueFloat);
                        }
                    }
                }
            }
        });
        frame.getContentPane().add(btnEnviarCalificaciones);

        
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
        btnNewButton_1.setBounds(31, 6, 55, 47);
        frame.getContentPane().add(btnNewButton_1);
    }

    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setForeground(Color.BLACK);
        button.setBackground(Color.BLUE);
        return button;
    }

}
