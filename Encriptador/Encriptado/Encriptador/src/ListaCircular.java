public class ListaCircular {

	private Nodo actual;

    public ListaCircular() {

    }

	public void agregar(Integer dato) {
    	Nodo nuevo = new Nodo(dato);
    	nuevo.setSiguiente(nuevo);
    	
    	if(actual == null) {
    		actual = nuevo;
    	} else {
    		
    		nuevo.setSiguiente(actual.getSiguiente());
    		actual.setSiguiente(nuevo);
    		actual = nuevo;
    		
    	}
    }

    public void mostrar() {
    	if(actual != null) {
    		Nodo aux = actual;
    		
    		do {
    			
    			System.out.printf("[%d]--->", aux.getDato());
    			aux = aux.getSiguiente();
    			
    		} while(aux != actual);
    		
    	}
    }
    
    public Integer getActualYRecorrer() {
    	Integer actualInt = actual.getDato();
    	actual = actual.getSiguiente();
    	
    	return actualInt;
    }
    
    public Integer getActual()  {
    	return actual.getDato();	
    }
    
    public void recorrer() {
    	actual = actual.getSiguiente();
    }
    
    public Integer getActualYBorrar() { 
    	Integer actualInt = actual.getDato();
    	borrarActual();
    	
    	return actualInt;
    }
    
    public void borrarActual() {
    	if(actual.getSiguiente() == actual) {
    		
    		actual.setSiguiente(null);
    		actual = null;
    		
    	}else {
    		
    		Nodo aux = actual;
    		
    		while(aux.getSiguiente() != null) {
    			aux = aux.getSiguiente();
    		}
    		
    		aux.setSiguiente(actual.getSiguiente());
    		actual.setSiguiente(null);
    		actual = aux.getSiguiente();
    	}
    }
}