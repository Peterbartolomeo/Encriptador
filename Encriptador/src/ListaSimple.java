public class ListaSimple {

	private Nodo inicio;

	public ListaSimple() {

	}

	public Nodo getInicio() {
		return inicio;
	}

	public void setInicio(Nodo inicio) {
		this.inicio = inicio;
	}

	public boolean estaVacia() {
		return inicio == null;
	}

	public void agregarInicio(int elemento) {
		Nodo nuevo = new Nodo(elemento);

		if(estaVacia())
			inicio = nuevo;
		else {
			nuevo.setSiguiente(inicio);
			inicio = nuevo;
		}
	}

	public void agregar(int elemento) {
		Nodo nuevo = new Nodo(elemento);

		if(estaVacia())
			inicio = nuevo;
		else {
			Nodo aux = inicio;

			while(aux.getSiguiente() != null) {
				aux = aux.getSiguiente();
			}

			aux.setSiguiente(nuevo);
		}
	}



}