package gustavoBazanGrafo;

/*
 * NodoAdy.java
 *
 * Created on 7 de mayo de 2006, 05:41 PM
 *
 */

/**
 *
 * @author Gustavo Bazan
 */
public class NodoAdy {
    private float   costo;
    private String  info;
    private NodoAdy prox;

    //~--- get methods --------------------------------------------------------

    /**
     * Obtiene el costo.
     * @return     El costo del arco.
     */
    public float getCosto() {
        return (costo);
    }

    /**
     * Obtiene la informacion del nodo.
     * @return     La informacion del nodo.
     */
    public String getInfo() {
        return (info);
    }

    /**
     * Obtiene el proximo nodo de adyacencia.
     * @return     El proximo nodo.
     */
    public NodoAdy getProxAdy() {
        return (prox);
    }

    //~--- set methods --------------------------------------------------------

    /**
     * Da valor al costo
     * @param      c   El costo del arco.
     */
    public void setCosto(float c) {
        costo = c;
    }

    /**
     * Da valor a la informacion del nodo.
     * @param      e   La informacion a dar al nodo.
     */
    public void setInfo(String e) {
        info = e;
    }

    /**
     * Asigna el valor del siguiente nodo de adyacencia.
     * @param      p   El proximo nodo.
     */
    public void setProxAdy(NodoAdy p) {
        prox = p;
    }
}

