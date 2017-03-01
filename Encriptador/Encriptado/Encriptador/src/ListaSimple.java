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

	/*
    public void insertarDatoOrdenadoDeMenorAMayor(int elemento) {
    	Nodo nuevo = new Nodo(elemento);
    	if(this.estaVacia())
    		this.inicio = nuevo;
    	else {
    		Nodo aux = this.inicio;
        	Nodo ant = null;
        	while(aux != null && nuevo.getDato() > aux.getDato()) {
        		ant = aux;
        		aux = aux.getSiguiente();
        	}
        	if(ant == null) {
        		nuevo.setSiguiente(this.inicio);
        		this.inicio = nuevo;
        	}else {
        		ant.setSiguiente(nuevo);
        		nuevo.setSiguiente(aux);
        	}
    	}
    }

    public boolean insertarDatoAntesQueToken(int elemento, int token) {
    	if(this.estaVacia())
    		return false;
    	else {
    		Nodo aux = this.inicio;
    		Nodo ant = null;
    		while(aux != null && aux.getDato() != token) {
    			ant = aux;
    			aux = aux.getSiguiente();
    		}
    		if(aux == null)
    			return false;
    		else {
    			Nodo nuevo = new Nodo(elemento);
    			if(ant == null) {
    				nuevo.setSiguiente(this.inicio);
    				this.inicio = nuevo;
    			}else {
    				ant.setSiguiente(nuevo);
    				nuevo.setSiguiente(aux);
    			}
    			return true;
    		}
    	}
    }

    public boolean insertarDatoDespuesQueToken(int elemento, int token) {
    	if(this.estaVacia())
    		return false;
    	else{
    		Nodo aux = this.inicio;
    		while(aux != null && aux.getDato() != token) {
    			aux = aux.getSiguiente();
    		}
    		if(aux == null) 
    			return false;
    		else {
    			Nodo nuevo = new Nodo(elemento);
    			nuevo.setSiguiente(aux.getSiguiente());
        		aux.setSiguiente(nuevo);
        		return true;
    		}
    	}
    }
	 */
	public void mostrar() {
		Nodo aux = inicio;
		
		while(aux != null) {
			System.out.printf("[%d]-->", aux.getDato());
			aux = aux.getSiguiente();
		}
	}

	/*
	public boolean estaOrdenada() throws ListaVaciaException{
		if(this.inicio == null)
			throw new ListaVaciaException();
		else{
			Nodo aux = this.inicio;
			while(aux != null && aux.getSiguiente() != null && aux.getDato() <= aux.getSiguiente().getDato()) {
				aux = aux.getSiguiente();
			}
			if(aux.getSiguiente() == null)
				return true;
			else
				return false;
		}
	}

	public boolean eliminarPrimerDato() {
		if(this.inicio == null) 
			return false;
		else {
			if(this.inicio.getSiguiente() == null)
				this.inicio = null;
			else 
				this.inicio = this.inicio.getSiguiente();
			return true;
		}
	}

	public boolean eliminarUltimoDato() {
		if(this.inicio == null)
			return false;
		else {
			if(this.inicio.getSiguiente() == null)
				this.inicio = null;
			else {
				Nodo aux = this.inicio;
				while(aux.getSiguiente().getSiguiente() != null)
					aux = aux.getSiguiente();
				aux.setSiguiente(null);
			}
			return true;
		}
	}

	public void ordenarDeMenorAMayor() throws ListaVaciaException {
		if(this.estaVacia()) 
			throw new ListaVaciaException();
		else {
			Nodo aux = this.inicio;
			Nodo ant = null;
			Nodo auxDato = null;
			while(aux != null) {
				ant = aux.getSiguiente();
				while(ant != null) {
					if(aux.getDato() > ant.getDato()) {
						auxDato = new Nodo(aux.getDato());
						aux.setDato(ant.getDato());
						ant.setDato(auxDato.getDato());
					}
					ant = ant.getSiguiente();
				}
				aux = aux.getSiguiente();
			}
		}
	}
*/

}