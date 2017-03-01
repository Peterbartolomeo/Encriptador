import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class PanelArchivoExistente extends JPanel {

	private JPasswordField passwordField;
	
	private JScrollPane scrollPane;
	
	private JLabel lblContrasena;
	private JLabel lblDirectorio;
	private JLabel lblNombre;
	private JLabel lblPreview;
	
	private JButton btnEncriptar;
	private JButton btnRegresar;
	private JButton btnDesencriptar;
	
	private JEditorPane editorPane;
	
	private File archivo;
	
	private JFileChooser fc;
	

	public PanelArchivoExistente() {
		setLayout(null);

		editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setFont(new Font("Arial", Font.PLAIN, 16));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 400, 129);
		scrollPane.setViewportView(editorPane);
		add(scrollPane);

		lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setFont(new Font("Arial", Font.PLAIN, 14));
		lblContrasena.setBounds(10, 218, 94, 14);
		add(lblContrasena);

		btnEncriptar = new JButton("Encriptar");
		btnEncriptar.setBounds(109, 256, 102, 23);
		btnEncriptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(passwordField.getPassword().length < 3) {
					
					JOptionPane.showMessageDialog(null, "La contraseña debe contener al menos 3 caracteres");
					
				} else {
					Controlador gestor = new Controlador();
					
					fc = new JFileChooser();
					editorPane.setText(gestor.cifrarArchivo(new File(lblDirectorio.getText()), new String(passwordField.getPassword())));
					
					if(fc.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
						
						archivo = fc.getSelectedFile();
						if(archivo.getName().endsWith("txt")) {
							
							if(gestor.guardarArchivo(archivo, editorPane.getText())) {
								
								lblDirectorio.setText(archivo.getAbsolutePath());
								lblNombre.setText(archivo.getName());
								btnDesencriptar.setVisible(true);
								btnEncriptar.setVisible(false);
								passwordField.setText("");
								
							} else {
								JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar.");
							}
							
						} else {
							JOptionPane.showMessageDialog(null, "El arhivo nuevo debe ser un archivo de texto.");
						}
						
					}
				}
			}
		});
		add(btnEncriptar);

		btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(10, 256, 89, 23);
		btnRegresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelMenu panelEncriptar = new PanelMenu();
				panelEncriptar.setSize(420, 320);
				panelEncriptar.setLocation(0,0);
				
				removeAll();
				panelEncriptar.setVisible(true);
				add(panelEncriptar, BorderLayout.CENTER); 
				revalidate();
				repaint();
			}
		});
		add(btnRegresar);

		passwordField = new JPasswordField();
		passwordField.setBounds(109, 217, 301, 20);
		add(passwordField);

		lblDirectorio = new JLabel("");
		lblDirectorio.setBounds(10, 193, 400, 14);
		add(lblDirectorio);

		lblNombre = new JLabel("Archivo: ");
		lblNombre.setBounds(10, 168, 400, 14);
		add(lblNombre);

		lblPreview = new JLabel("Preview");
		lblPreview.setFont(new Font("Arial", Font.PLAIN, 18));
		lblPreview.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreview.setBounds(10, 3, 400, 23);
		add(lblPreview);

		btnDesencriptar = new JButton("Desencriptar");
		btnDesencriptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controlador gestor = new Controlador();
				editorPane.setText(gestor.descifrarArchivo(new File(lblDirectorio.getText()), new String(passwordField.getPassword())));
				btnDesencriptar.setVisible(false);
				btnEncriptar.setVisible(true);
			}
		});
		btnDesencriptar.setBounds(222, 256, 110, 23);
		btnDesencriptar.setVisible(false);
		add(btnDesencriptar);
	}

	public JEditorPane getTextArea() {
		return editorPane;
	}

	public JLabel getLblDirectorio() {
		return lblDirectorio;
	}

	public JLabel getLblNombreArchivo() {
		return lblNombre;
	}
	
	public JButton getButtonEncriptar() {
		return btnEncriptar;
	}
	
	public JButton getButtonDesencriptar() {
		return btnDesencriptar;
	}
}
