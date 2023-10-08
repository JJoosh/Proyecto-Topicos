package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;

public class SubirArchivo extends JFrame {

    private JLabel label;
    private JTextField textField;
    private JButton button;
    private JFileChooser ElegirArchivo;
    private JButton btnNewButton;

    public SubirArchivo() {
        super("Subir Archivo");
        setResizable(false);
        setTitle("Subir asignacion");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        Container contenedor = getContentPane();

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 100));
        panel.setLayout(null);

        label = new JLabel("Elige un archivo a elegir:");
        label.setBounds(6, 39, 192, 20);

        textField = new JTextField();
        textField.setBounds(177, 39, 192, 20);

        button = new JButton("Buscar");
        button.setBounds(165, 77, 100, 20);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	ElegirArchivo = new JFileChooser();
                int returnVal = ElegirArchivo.showOpenDialog(panel);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = ElegirArchivo.getSelectedFile();
                    textField.setText(file.getAbsolutePath());
                }
            }
        });

        panel.add(label);
        panel.add(textField);
        panel.add(button);

        contenedor.add(panel, BorderLayout.CENTER);
	
        
        btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        			dispose();
					Eleccion ventanaEleccion = new Eleccion();
				
        	}
        });
        btnNewButton.setIcon(new ImageIcon("/Users/joshuaaviles/Downloads/566095 (1).png"));
	       
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setBackground(new Color(0, 0, 0, 0));
        btnNewButton.setBorderPainted(false);
        btnNewButton.setBounds(6, 0, 60, 38);
        panel.add(btnNewButton);

        setVisible(true);
    }
}