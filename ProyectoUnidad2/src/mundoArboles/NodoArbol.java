package mundoArboles;

import mundo.Cliente;

public class NodoArbol {


	 private Cliente cliente;
	    private NodoArbol izquierdo;
	    private NodoArbol derecho;

	    public NodoArbol(Cliente cliente) {
	        this.cliente = cliente;
	        this.izquierdo = null;
	        this.derecho = null;
	    }

	    public Cliente getCliente() {
	        return cliente;
	    }

	    public void setCliente(Cliente cliente) {
	        this.cliente = cliente;
	    }

	    public NodoArbol getIzquierdo() {
	        return izquierdo;
	    }

	    public void setIzquierdo(NodoArbol izquierdo) {
	        this.izquierdo = izquierdo;
	    }

	    public NodoArbol getDerecho() {
	        return derecho;
	    }

	    public void setDerecho(NodoArbol derecho) {
	        this.derecho = derecho;
	    }
}