import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelMenu extends JPanel {

	private JLabel lblEncriptar;
	private JLabel lblDesencriptar;
	
	private JButton btnNuevoArchivo;
	private JButton btnArchivoExistente;
	private JButton btnSeleccionarArchivo;
	
	private JFileChooser fc;
	private File archivo;
	private Controlador gestor;
	
	public PanelMenu() {
		setLayout(null);
		
		lblEncriptar = new JLabel("Encriptar");
		lblEncriptar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEncriptar.setFont(new Font("Arial", Font.PLAIN, 20));
		lblEncriptar.setBounds(10, 11, 400, 36);
		add(lblEncriptar);
		
		btnNuevoArchivo = new JButton("Nuevo archivo");
		btnNuevoArchivo.setBounds(140, 58, 140, 23);
		btnNuevoArchivo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelNuevoArchivo panelNuevoArchivo = new PanelNuevoArchivo();
				panelNuevoArchivo.setSize(420, 320);
				panelNuevoArchivo.setLocation(0,0);
				removeAll();
				panelNuevoArchivo.setVisible(true);
				add(panelNuevoArchivo, BorderLayout.CENTER); 
				revalidate();
				repaint();
			}
		});
		
		add(btnNuevoArchivo);
		
		btnArchivoExistente = new JButton("Archivo existente");
		btnArchivoExistente.setBounds(140, 92, 140, 23);
		btnArchivoExistente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fc = new JFileChooser();
				gestor = new Controlador();
				
				if(fc.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
					
					archivo = fc.getSelectedFile();
					if(archivo.canRead()) {
						
						if(archivo.getName().endsWith("txt")) {
							
							String contenido = gestor.abrirArchivo(archivo);
							PanelArchivoExistente panelArchivoExistente = new PanelArchivoExistente();
							
							panelArchivoExistente.setSize(420, 320);
							panelArchivoExistente.setLocation(0,0);
							panelArchivoExistente.getTextArea().setText(contenido);
							panelArchivoExistente.getLblDirectorio().setText(fc.getSelectedFile().toString());
							panelArchivoExistente.getLblNombreArchivo().setText("Archivo: " + fc.getSelectedFile().getName());
							
							removeAll();
							panelArchivoExistente.setVisible(true);
							add(panelArchivoExistente, BorderLayout.CENTER); 
							revalidate();
							repaint();
							
						} else {
							JOptionPane.showMessageDialog(null, "Seleccione un archivo de texto (.txt)");
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Seleccione un archivo que se pueda leer.");
					}
					
				}
			}
		});
		
		add(btnArchivoExistente);
		
		lblDesencriptar = new JLabel("Desencriptar");
		lblDesencriptar.setFont(new Font("Arial", Font.PLAIN, 20));
		lblDesencriptar.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesencriptar.setBounds(10, 145, 400, 30);
		add(lblDesencriptar);
		
		btnSeleccionarArchivo = new JButton("Seleccionar archivo");
		btnSeleccionarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fc = new JFileChooser();
				gestor = new Controlador();
				
				if(fc.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
					
					archivo = fc.getSelectedFile();
					if(archivo.canRead()) {
						
						if(archivo.getName().endsWith("txt")) {
							
							String contenido = gestor.abrirArchivo(archivo);
							PanelArchivoExistente panelArchivoExistente = new PanelArchivoExistente();
							
							panelArchivoExistente.setSize(420, 320);
							panelArchivoExistente.setLocation(0,0);
							panelArchivoExistente.getTextArea().setText(contenido);
							panelArchivoExistente.getLblDirectorio().setText(fc.getSelectedFile().toString());
							panelArchivoExistente.getLblNombreArchivo().setText("Archivo: " + fc.getSelectedFile().getName());
							panelArchivoExistente.getButtonEncriptar().setVisible(false);
							panelArchivoExistente.getButtonDesencriptar().setVisible(true);
							
							removeAll();
							panelArchivoExistente.setVisible(true);
							add(panelArchivoExistente, BorderLayout.CENTER); 
							revalidate();
							repaint();
							
						}else {
							JOptionPane.showMessageDialog(null, "Seleccione un archivo de texto (.txt)");
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Seleccione un archivo que se pueda leer.");
					}
					
				}
			}
		});
		
		btnSeleccionarArchivo.setBounds(124, 186, 171, 23);
		add(btnSeleccionarArchivo);
	}
}
