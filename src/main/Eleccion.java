package main;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Eleccion {

    private JFrame frame;

    public Eleccion() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10)); //5 rows, one column
        panel.setBorder(new EmptyBorder(50, 50, 50, 50));
        panel.setBackground(Color.DARK_GRAY);

        Font buttonFont = new Font("Arial", Font.BOLD, 20);

        JButton btnListaAlumnos = createButton("Lista de alumnos", buttonFont);
        btnListaAlumnos.addActionListener(e -> {
            new AlumnosTabla().setVisible(true);
            frame.dispose();
        });

        JButton btnAgregarCalificaciones = createButton("Agregar Calificaciones", buttonFont);
        btnAgregarCalificaciones.addActionListener(e -> {
            new Calificaciones();
            frame.dispose();
        });

        JButton btnAgregarcatalogo = createButton("Registrar", buttonFont);
        btnAgregarcatalogo.addActionListener(e -> {
            try {
				new Catalogos();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
					| UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            frame.dispose();
        });

        JButton btnSubirAsignacion = createButton("Subir asignacion", buttonFont);
        btnSubirAsignacion.addActionListener(e -> {
            new SubirArchivo().setVisible(true);
            frame.dispose();
        });

        JButton btnSalir = createButton("Salir", buttonFont);
        btnSalir.addActionListener(e -> {
            Main m1 = new Main();
            frame.dispose();
        });

        panel.add(btnListaAlumnos);
        panel.add(btnAgregarCalificaciones);
        panel.add(btnAgregarcatalogo);
        panel.add(btnSubirAsignacion);
        panel.add(btnSalir);

        frame.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.fill = GridBagConstraints.BOTH; //Ensures the panel fills the window
        gbc_panel.weightx = 1.0;
        gbc_panel.weighty = 1.0;
        gbc_panel.gridy = 0;
        frame.getContentPane().add(panel, gbc_panel);
        frame.pack();
        frame.setVisible(true);
    }

    private JButton createButton(String text, Font font) {
        JButton button = new JButton(text);
        button.setFont(font);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLUE);
        button.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        return button;
    }
}
