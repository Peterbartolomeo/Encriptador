import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Scanner;

public class Controlador {

	private ListaSimple listaSimple;
	private ListaCircular listaCircular;
	private Scanner scanner;
	private FileReader fileReader;

	public Controlador() {

	}

	public boolean guardarArchivo(File archivo, String contenido) {
		try (FileOutputStream salida = new FileOutputStream(archivo)) {
			byte[] byteText = contenido.getBytes();
			salida.write(byteText);

			return true;
		}catch(Exception e) {
			e.printStackTrace();

			return false;
		}
	}

	public String abrirArchivo(File archivo) {
		String contenido = "";
		try (FileInputStream entrada = new FileInputStream(archivo)){
			int codigoAscci;

			while((codigoAscci = entrada.read()) != -1) {
				char caracter = (char) codigoAscci;
				contenido += caracter;
			}

			return contenido;
		}catch(Exception e) {
			e.printStackTrace();

			return null;
		}
	}

	public String cifrarArchivo(File archivo, String contrasena) {
		try {
			String texto = "";
			String textoEncriptado = "";

			ListaSimple listaEncriptada;
			Nodo aux;

			char[] caracteres;
			char[] key = contrasena.toCharArray();

			fileReader = new FileReader(archivo);

			scanner = new Scanner(this.fileReader);

			listaSimple = new ListaSimple();
			listaCircular = new ListaCircular();

			while(scanner.hasNext()) {
				texto += scanner.nextLine();
			}

			caracteres = texto.toCharArray();

			for(int i = 0; i < texto.length(); i++) {
				listaSimple.agregar((int)caracteres[i]);
			}

			for(int i = 0; i < key.length; i++) {
				listaCircular.agregar((int) key[i]);
			}

			listaEncriptada = sumarListas(listaSimple, listaCircular);

			aux = listaEncriptada.getInicio();
			while(aux != null) {
				textoEncriptado += (char) aux.getDato();
				aux = aux.getSiguiente();
			}

			return textoEncriptado;

		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String descifrarArchivo(File archivo, String contrasena) {

		try {
			String texto = "";
			String textoDesencriptado = "";

			ListaSimple listaDesencriptada;
			Nodo aux;

			char[] caracteres;
			char[] key = contrasena.toCharArray();

			fileReader = new FileReader(archivo);

			scanner = new Scanner(this.fileReader);

			listaSimple = new ListaSimple();
			listaCircular = new ListaCircular();

			while(scanner.hasNext()) {
				texto += scanner.nextLine();
			}

			caracteres = texto.toCharArray();

			for(int i = 0; i < texto.length(); i++) {
				listaSimple.agregar((int)caracteres[i]);
			}

			for(int i = 0; i < key.length; i++) {
				listaCircular.agregar((int) key[i]);
			}

			listaDesencriptada = restarListas(listaSimple, listaCircular);

			aux = listaDesencriptada.getInicio();
			while(aux != null) {
				textoDesencriptado += (char) aux.getDato();
				aux = aux.getSiguiente();
			}

			return textoDesencriptado;

		} catch (FileNotFoundException e) {
			e.printStackTrace();

			return null;
		}
	}

	public ListaSimple sumarListas (ListaSimple listaSimple, ListaCircular listaCircular) {
		Nodo aux = listaSimple.getInicio();

		ListaSimple listaAuxiliar = new ListaSimple();

		listaCircular.recorrer();

		while(aux != null) {

			if(aux.getDato() + listaCircular.getActual() > 255) {
				listaAuxiliar.agregar(aux.getDato() + listaCircular.getActualYRecorrer() - 255);
			}else {
				listaAuxiliar.agregar(aux.getDato() + listaCircular.getActualYRecorrer());
			}

			aux = aux.getSiguiente();
		}

		return listaAuxiliar;
	}

	public ListaSimple restarListas(ListaSimple listaSimple, ListaCircular listaCiurcular) {
		Nodo aux = listaSimple.getInicio();
		
		ListaSimple listaAuxiliar = new ListaSimple();

		listaCircular.recorrer();
		while(aux != null) {
			listaAuxiliar.agregar(aux.getDato() - listaCircular.getActualYRecorrer());
			aux = aux.getSiguiente();
		}
		
		return listaAuxiliar;
	}

}
