package mundoArboles;

import java.util.List;


import mundo.Cliente;
import java.util.ArrayList;


public class arbolBinario {
	 private NodoArbol raiz;

	    public arbolBinario() {
	        raiz = null;
	    }

	    public NodoArbol getRaiz() {
	        return raiz;
	    }

	 // Método para insertar un cliente en el árbol de forma ordenada
	    public void insertarCliente(Cliente cliente) {
	        NodoArbol nuevoNodo = new NodoArbol(cliente); // Creamos un nuevo nodo con el cliente a insertar

	        if (raiz == null) {
	            raiz = nuevoNodo; // Si el árbol está vacío, el nuevo nodo se convierte en la raíz
	        } else {
	            insertarNodo(raiz, nuevoNodo); // Si no, llamamos al método auxiliar para insertar el nodo en la posición adecuada
	        }
	    }

	    // Método auxiliar para insertar un nodo en el árbol de forma ordenada
	    private void insertarNodo(NodoArbol nodoActual, NodoArbol nuevoNodo) {
	        int comparacion = nodoActual.getCliente().getCedula().compareTo(nuevoNodo.getCliente().getCedula());

	        if (comparacion > 0) {
	            // Si la cédula del cliente actual es mayor que la del nuevo nodo, buscamos en el subárbol izquierdo
	            if (nodoActual.getIzquierdo() == null) {
	                nodoActual.setIzquierdo(nuevoNodo); // Si llegamos a una posición vacía, insertamos el nuevo nodo aquí
	            } else {
	                insertarNodo(nodoActual.getIzquierdo(), nuevoNodo); // Si no, continuamos buscando en el subárbol izquierdo
	            }
	        } else if (comparacion < 0) {
	            // Si la cédula del cliente actual es menor que la del nuevo nodo, buscamos en el subárbol derecho
	            if (nodoActual.getDerecho() == null) {
	                nodoActual.setDerecho(nuevoNodo); // Si llegamos a una posición vacía, insertamos el nuevo nodo aquí
	            } else {
	                insertarNodo(nodoActual.getDerecho(), nuevoNodo); // Si no, continuamos buscando en el subárbol derecho
	            }
	        }
	    }

	   
	    /**
	     * Método que realiza el recorrido preorden de un árbol binario.
	     * @param nodo El nodo desde donde comenzar el recorrido.
	     * @return Una lista con los clientes en el recorrido preorden.
	     */
	    public List<Cliente> preorden(NodoArbol nodo) {
	        List<Cliente> clientes = new ArrayList<>();

	        // Verificamos que el nodo no sea nulo antes de continuar
	        if (nodo != null) {
	            // Obtenemos el cliente del nodo actual y lo agregamos a la lista
	            Cliente cliente = nodo.getCliente();
	            clientes.add(cliente);

	            // Realizamos el recorrido preorden en el subárbol izquierdo y lo agregamos a la lista
	            clientes.addAll(preorden(nodo.getIzquierdo()));

	            // Realizamos el recorrido preorden en el subárbol derecho y lo agregamos a la lista
	            clientes.addAll(preorden(nodo.getDerecho()));
	        }

	        return clientes; // Retornamos la lista con los clientes en el recorrido preorden
	    }

	    /**
	     * Método que realiza el recorrido inorden de un árbol binario.
	     * @param nodo El nodo desde donde comenzar el recorrido.
	     * @return Una lista con los clientes en el recorrido inorden.
	     */
	    public List<Cliente> inorden(NodoArbol nodo) {
	        List<Cliente> clientes = new ArrayList<>();

	        // Verificamos que el nodo no sea nulo antes de continuar
	        if (nodo != null) {
	            // Realizamos el recorrido inorden en el subárbol izquierdo y lo agregamos a la lista
	            clientes.addAll(inorden(nodo.getIzquierdo()));

	            // Obtenemos el cliente del nodo actual y lo agregamos a la lista
	            Cliente cliente = nodo.getCliente();
	            clientes.add(cliente);

	            // Realizamos el recorrido inorden en el subárbol derecho y lo agregamos a la lista
	            clientes.addAll(inorden(nodo.getDerecho()));
	        }

	        return clientes; // Retornamos la lista con los clientes en el recorrido inorden
	    }

	    /**
	     * Método que realiza el recorrido postorden de un árbol binario.
	     * @param nodo El nodo desde donde comenzar el recorrido.
	     * @return Una lista con los clientes en el recorrido postorden.
	     */
	    public List<Cliente> postorden(NodoArbol nodo) {
	        List<Cliente> clientes = new ArrayList<>();

	        // Verificamos que el nodo no sea nulo antes de continuar
	        if (nodo != null) {
	            // Realizamos el recorrido postorden en el subárbol izquierdo y lo agregamos a la lista
	            clientes.addAll(postorden(nodo.getIzquierdo()));

	            // Realizamos el recorrido postorden en el subárbol derecho y lo agregamos a la lista
	            clientes.addAll(postorden(nodo.getDerecho()));

	            // Obtenemos el cliente del nodo actual y lo agregamos a la lista
	            Cliente cliente = nodo.getCliente();
	            clientes.add(cliente);
	        }

	        return clientes; // Retornamos la lista con los clientes en el recorrido postorden
	    }

	 
	    /**
	     * Método público para buscar un cliente en el árbol binario por su cédula.
	     * @param cedula La cédula del cliente a buscar.
	     * @return El cliente encontrado, o null si no se encuentra.
	     */
	    public Cliente buscarCliente(String cedula) {
	        // Comenzamos la búsqueda recursiva desde la raíz del árbol
	        return buscarClienteRecursivo(raiz, cedula);
	    }

	    /**
	     * Método auxiliar recursivo para buscar un cliente en el árbol binario por su cédula.
	     * @param nodo El nodo actual desde donde se comienza la búsqueda.
	     * @param cedula La cédula del cliente a buscar.
	     * @return El cliente encontrado, o null si no se encuentra.
	     */
	    private Cliente buscarClienteRecursivo(NodoArbol nodo, String cedula) {
	        // Si el nodo actual es nulo, significa que no se encontró el cliente
	        if (nodo == null) {
	            return null;
	        }

	        // Comparar la cédula del cliente del nodo actual con la cédula buscada
	        int comparacion = nodo.getCliente().getCedula().compareTo(cedula);

	        // Si la comparación es igual a 0, significa que se encontró el cliente
	        if (comparacion == 0) {
	            return nodo.getCliente(); // Se encontró el cliente
	        }
	        // Si la comparación es mayor a 0, buscar en el subárbol izquierdo
	        else if (comparacion > 0) {
	            return buscarClienteRecursivo(nodo.getIzquierdo(), cedula);
	        }
	        // Si la comparación es menor a 0, buscar en el subárbol derecho
	        else {
	            return buscarClienteRecursivo(nodo.getDerecho(), cedula);
	        }
	    }

	    public boolean eliminarClientePorCedula(String cedula) {
	        if (raiz == null) {
	            return false; // El árbol está vacío, no se puede eliminar nada
	        }

	        // Buscar el nodo del cliente a eliminar
	        NodoArbol nodoAEliminar = buscarNodoPorCedula(raiz, cedula);

	        // Si no se encontró el cliente, retornar false
	        if (nodoAEliminar == null) {
	            return false;
	        }

	        // Eliminar el nodo con el cliente
	        raiz = eliminarNodo(raiz, nodoAEliminar);

	        return true; // Cliente eliminado correctamente
	    }

	    private NodoArbol eliminarNodo(NodoArbol nodoActual, NodoArbol nodoAEliminar) {
	        if (nodoActual == null) {
	            return null;
	        }

	        // Buscar el nodo a eliminar en el subárbol izquierdo
	        if (nodoAEliminar.getCliente().getCedula().compareTo(nodoActual.getCliente().getCedula()) < 0) {
	            nodoActual.setIzquierdo(eliminarNodo(nodoActual.getIzquierdo(), nodoAEliminar));
	        }
	        // Buscar el nodo a eliminar en el subárbol derecho
	        else if (nodoAEliminar.getCliente().getCedula().compareTo(nodoActual.getCliente().getCedula()) > 0) {
	            nodoActual.setDerecho(eliminarNodo(nodoActual.getDerecho(), nodoAEliminar));
	        }
	        // Nodo encontrado, realizar el proceso de eliminación
	        else {
	            // Caso 1: El nodo no tiene hijos o es una hoja
	            if (nodoActual.getIzquierdo() == null && nodoActual.getDerecho() == null) {
	                return null;
	            }
	            // Caso 2: El nodo tiene un solo hijo
	            else if (nodoActual.getIzquierdo() == null) {
	                return nodoActual.getDerecho();
	            } else if (nodoActual.getDerecho() == null) {
	                return nodoActual.getIzquierdo();
	            }
	            // Caso 3: El nodo tiene dos hijos
	            else {
	                // Encontrar el sucesor inorden del nodo
	                NodoArbol sucesorInorden = obtenerSucesorInorden(nodoActual.getDerecho());

	                // Reemplazar el contenido del nodo actual con el contenido del sucesor inorden
	                nodoActual.setCliente(sucesorInorden.getCliente());

	                // Eliminar el sucesor inorden
	                nodoActual.setDerecho(eliminarNodo(nodoActual.getDerecho(), sucesorInorden));
	            }
	        }

	        return nodoActual;
	    }

	    /**
	     * Método para buscar el nodo con la cédula especificada en el árbol binario.
	     * @param nodo El nodo actual desde donde se comienza la búsqueda.
	     * @param cedula La cédula del cliente a buscar.
	     * @return El nodo con la cédula especificada, o null si no se encuentra.
	     */
	    private NodoArbol buscarNodoPorCedula(NodoArbol nodo, String cedula) {
	        // Verificar si el nodo actual es nulo (caso base)
	        if (nodo == null) {
	            return null;
	        }

	        // Comparar la cédula del cliente del nodo actual con la cédula buscada
	        int comparacion = nodo.getCliente().getCedula().compareTo(cedula);

	        // Si la comparación es igual a 0, significa que se encontró el nodo con la cédula buscada
	        if (comparacion == 0) {
	            return nodo; // Se encontró el nodo con la cédula especificada
	        }
	        // Si la comparación es mayor a 0, buscar en el subárbol izquierdo
	        else if (comparacion > 0) {
	            return buscarNodoPorCedula(nodo.getIzquierdo(), cedula);
	        }
	        // Si la comparación es menor a 0, buscar en el subárbol derecho
	        else {
	            return buscarNodoPorCedula(nodo.getDerecho(), cedula);
	        }
	    }

	    /**
	     * Método para obtener el sucesor inorden de un nodo en un árbol binario.
	     * El sucesor inorden es el nodo que se encuentra más a la izquierda del subárbol derecho.
	     * @param nodo El nodo del cual se desea encontrar el sucesor inorden.
	     * @return El nodo sucesor inorden, o null si el nodo es nulo o no tiene subárbol derecho.
	     */
	    private NodoArbol obtenerSucesorInorden(NodoArbol nodo) {
	        NodoArbol actual = nodo;
	        // Recorrer hacia la izquierda hasta llegar al nodo más a la izquierda del subárbol derecho
	        while (actual.getIzquierdo() != null) {
	            actual = actual.getIzquierdo();
	        }
	        return actual;
	    }


	   
	    
}
	    
	