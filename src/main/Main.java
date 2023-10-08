package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Main {

	private JFrame frame;
	private JLabel motivationalQuoteLabel;
	private String[] motivationalQuotes = {
			"El fracaso es solo la oportunidad de comenzar de nuevo, esta vez de forma más inteligente.",
			"El éxito es la suma de pequeños esfuerzos repetidos día tras día.",
			"El único lugar donde el éxito viene antes que el trabajo es en el diccionario.",
			// Añade más citas aquí...
	};


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

		motivationalQuoteLabel = new JLabel();
		motivationalQuoteLabel.setForeground(new Color(255, 255, 255));
		motivationalQuoteLabel.setBounds(74, 144, 299, 50);
		motivationalQuoteLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		motivationalQuoteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(motivationalQuoteLabel);

		JButton btnNewButton = new JButton("Ingresar ");
		btnNewButton.setFont(UIManager.getFont("ToggleButton.font"));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(229, 251, 255));
		btnNewButton.setBackground(Color.blue); 
		btnNewButton.setOpaque(true);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login l1 = new login();
				
			}
		});
		btnNewButton.setBounds(164, 197, 117, 29);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("B I E N V E N I D O  ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(64, 89, 339, 43);
		lblNewLabel.setFont(new Font("Plantagenet Cherokee", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("/Users/joshuaaviles/Downloads/WhatsApp Image 2023-03-01 at 17.27.41.jpeg"));
		lblNewLabel_3.setBounds(91, 68, 271, 74);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("imagen");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/joshuaaviles/Downloads/WhatsApp Image 2023-03-01 at 17.08.33.jpeg"));
		lblNewLabel_2.setLabelFor(frame);
		lblNewLabel_2.setBounds(0, 0, 450, 272);
		frame.getContentPane().add(lblNewLabel_2);

		// Agrega un Timer que se actualiza cada 5 segundos
		new Timer(5000, new ActionListener() {
			Random random = new Random();
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = random.nextInt(motivationalQuotes.length);
				motivationalQuoteLabel.setText("<html><p style='width:100%;text-align:center'>" + motivationalQuotes[index] + "</p></html>");
			}
		}).start();
	}
}
