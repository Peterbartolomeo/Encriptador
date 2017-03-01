import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class PanelArchivoEncriptado extends JPanel {

	private JPasswordField passwordField;
	
	private JButton btnRegresar;
	private JButton btnDesencriptar;
	
	private JLabel lblArchivoEncriptado;
	private JLabel lblContrasena;
	private JLabel lblNombreDeArchivo;
	
	private JScrollPane scrollPane;
	
	private JEditorPane editorPane;
	
	private JTextPane textPane;
	
	public PanelArchivoEncriptado() {
		setLayout(null);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelMenu panelMenu = new PanelMenu();
				panelMenu.setSize(420, 320);
				panelMenu.setLocation(0,0);
				
				removeAll();
				panelMenu.setVisible(true);
				add(panelMenu, BorderLayout.CENTER); 
				revalidate();
				repaint();
			}
		});
		btnRegresar.setBounds(10, 256, 89, 23);
		add(btnRegresar);
		
		btnDesencriptar = new JButton("Desencriptar");
		btnDesencriptar.setBounds(198, 256, 115, 23);
		add(btnDesencriptar);
		
		lblArchivoEncriptado = new JLabel("Archivo Encriptado");
		lblArchivoEncriptado.setFont(new Font("Arial", Font.PLAIN, 18));
		lblArchivoEncriptado.setHorizontalAlignment(SwingConstants.CENTER);
		lblArchivoEncriptado.setBounds(10, 11, 400, 23);
		add(lblArchivoEncriptado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 400, 154);
		add(scrollPane);
		
		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		scrollPane.setViewportView(editorPane);
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setFont(new Font("Arial", Font.PLAIN, 16));
		scrollPane.setViewportView(textPane);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(130, 225, 280, 20);
		add(passwordField);
		
		lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setFont(new Font("Arial", Font.PLAIN, 16));
		lblContrasena.setBounds(10, 221, 110, 23);
		add(lblContrasena);
		
		lblNombreDeArchivo = new JLabel("Nombre de Archivo");
		lblNombreDeArchivo.setBounds(10, 200, 400, 14);
		add(lblNombreDeArchivo);
		
	}
	
	public JPasswordField getPasswordFiel() {
		return passwordField;
	}
	
	public JLabel getLabelNombreArchivo() {
		return lblNombreDeArchivo;
	}
	
	public JEditorPane getEditorPane() {
		return editorPane;
	}
	
	public JTextPane getTextPane() {
		return textPane;
	}
}
