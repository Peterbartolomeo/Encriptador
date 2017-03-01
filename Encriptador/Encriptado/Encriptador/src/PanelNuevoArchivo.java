import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PanelNuevoArchivo extends JPanel {

	private JScrollPane scrollPane;
	
	private JTextArea textArea;
	
	private JButton btnGuardar;
	private JButton btnRegresar;
	
	private JFileChooser fc;
	
	private File archivo;
	
	private Controlador gestor;
	
	private FileNameExtensionFilter filter;
	
	public PanelNuevoArchivo() {
		setLayout(null);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 16));
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 400, 220);
		scrollPane.setViewportView(textArea);
		add(scrollPane);
		
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(109, 256, 89, 23);
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fc = new JFileChooser();
				
				gestor = new Controlador();
				
				filter = new FileNameExtensionFilter("Archivo de texto *txt", ".txt");
				fc.setFileFilter(filter);
				
				if(fc.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
					
					archivo = fc.getSelectedFile();
					if(archivo.getName().endsWith("txt")) {
						
						String contenido = textArea.getText();
						gestor.guardarArchivo(archivo, contenido);
						
						if(gestor.guardarArchivo(archivo, contenido)) {
							
							JOptionPane.showMessageDialog(null, "El archivo se creó correctamente");
							
							PanelArchivoExistente panelArchivoExistente = new PanelArchivoExistente();
							panelArchivoExistente.setSize(420, 320);
							panelArchivoExistente.setLocation(0,0);
							panelArchivoExistente.getTextArea().setText(contenido);
							panelArchivoExistente.getLblDirectorio().setText(archivo.getAbsolutePath());
							panelArchivoExistente.getLblNombreArchivo().setText("Archivo: " + fc.getSelectedFile().getName());
							
							removeAll();
							panelArchivoExistente.setVisible(true);
							add(panelArchivoExistente, BorderLayout.CENTER); 
							revalidate();
							repaint();
							
						} else {
							JOptionPane.showMessageDialog(null, "Ocurrio un error al guardar.");
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "El arhivo nuevo debe ser un archivo de texto.");
					}
					
				}
			}
		});
		add(btnGuardar);
		
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
		
	}
}
