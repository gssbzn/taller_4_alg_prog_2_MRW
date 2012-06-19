package gustavoBazanGrafo;

/*
 * NodoVert.java
 *
 * Created on 7 de mayo de 2006, 05:43 PM
 *
 */

/**
 *
 * @author Gustavo Bazan
 */
public class NodoVert {
    private String   info;
    private NodoAdy  listaAdy;
    private NodoVert prox;

    //~--- constructors -------------------------------------------------------

    /** Creates a new instance of NodoVert */
    public NodoVert() {
        listaAdy = new NodoAdy();
    }

    //~--- get methods --------------------------------------------------------

    /**
     * Obtiene la informacion del nodo.
     * @return     La informacion del nodo.
     */
    public String getInfo() {
        return (info);
    }

    /**
     * Optiene la lista de nodos adyacentes al vertice.
     * @return   El nodo cabecera de la lista.
     */
    public NodoAdy getListaAdy() {
        return (listaAdy);
    }

    /**
     * Obtiene el proximo nodo.
     * @return     El proximo nodo.
     */
    public NodoVert getProx() {
        return (prox);
    }

    //~--- set methods --------------------------------------------------------

    /**
     * Da valor a la informacion del nodo.
     * @param      v     La informacion a dar al nodo.
     */
    public void setInfo(String v) {
        info = v;
    }

    /**
     * Asigna el valor del nodo adyacente al vertice.
     * @param      p    El nodo adyacente.
     */
    public void setListaAdy(NodoAdy p) {
        listaAdy = p;
    }

    /**
     * Asigna el valor del siguiente nodo.
     * @param      p    El proximo nodo.
     */
    public void setProx(NodoVert p) {
        prox = p;
    }
}

