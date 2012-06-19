package gustavoBazanGrafo;

//~--- JDK imports ------------------------------------------------------------

import java.util.*;

//~--- classes ----------------------------------------------------------------

/*
 * Grafo.java
 *
 * Created on 7 de mayo de 2006, 11:25 AM
 *
 */

/**
 *
 * @author Gustavo Bazan
 */
public class Grafo {
    private NodoVert g;
    private int      orden;

    //~--- constructors -------------------------------------------------------

    /** Creates a new instance of Grafo */
    public Grafo() {
        orden = 0;
        g = new NodoVert();
    }

    //~--- methods ------------------------------------------------------------

    /**
     * Añade el arco(v,w) dentro del grafo.
     * @param    v   el vertice de origen.
     * @param    w   el vertice de llegada.
     */
    public void agregarArco(String v, String w, float c) {
        NodoAdy ant = null, act, Q;

        act = getVertice(v).getListaAdy();
        Q   = new NodoAdy();
        Q.setInfo(w);
        Q.setCosto(c);

        while (act != null) {
            ant = act;
            act = act.getProxAdy();
        }

        ant.setProxAdy(Q);
    }

    /**
     * Agrega un vertice al grafo.
     * @param    v   el vertice a añadir.
     */
    public void agregarVertice(String v) {
        NodoVert ant = null, act, Q;

        act = g;
        Q   = new NodoVert();
        Q.setInfo(v);

        while (act != null) {
            ant = act;
            act = act.getProx();
        }

        ant.setProx(Q);
        orden++;
    }

    /**
     * Devuelve el costo  del arco (v,w).
     * @param    v   el vertice de origen.
     * @param    w   el vertice de llegada.
     * @return   el costo del arco.
     */
    public float costoArco(String v, String w) {
        NodoVert origen;
        NodoAdy  destino;

        origen  = getVertice(v);
        destino = origen.getListaAdy().getProxAdy();

        while (destino != null) {
            if (destino.getInfo().equals(w)) {
                return (destino.getCosto());
            }

            destino = destino.getProxAdy();
        }

        return (destino.getCosto());
    }

    /**
     * Elimina el arco(v,w) del grafo.
     * @param    v   el vertice de partide.
     * @param    w   el vertice de llegada.
     */
    public void eliminarArco(String v, String w) {
        NodoAdy Act,
                Ant = null;

        Act = getVertice(v).getListaAdy();

        while (Act != null) {
            Ant = Act;
            Act = Act.getProxAdy();

            if (Act.getInfo().equals(w)) {
                break;
            }
        }

        Ant.setProxAdy(Act.getProxAdy());
    }

    /**
     * Elimina el vertice v del grafo.
     * @param    v   el vertice a eliminar.
     */
    public void eliminarVertice(String v) {
        NodoVert Act,
                 Ant = null;

        Act = g;

        while (Act != null) {
            Ant = Act;
            Act = Act.getProx();

            if (Act.getInfo().equals(v)) {
                break;
            }
        }

        Ant.setProx(Act.getProx());
        orden--;
    }

    /**
     * Determina si el grafo es vacio.
     * @return   verdadero si orden=0 o falso si orden!=0.
     */
    public boolean esVacio() {
        return (orden == 0);
    }

    /**
     * Determina si existe o no un arco(v,w) dentro del grafo.
     * @param    v   el vertice de origen.
     * @param    w   el vertice de llegada.
     * @return   verdadero si existe o falso en caso contrario.
     */
    public boolean existeArco(String v, String w) {
        boolean  esta = false;
        NodoVert origen;
        NodoAdy  destino;

        origen  = getVertice(v);
        destino = origen.getListaAdy().getProxAdy();

        while ((destino != null) &&!esta) {
            if (destino.getInfo().equals(w)) {
                esta = true;
            }

            destino = destino.getProxAdy();
        }

        return (esta);
    }

    /**
     * Determina si existe un camino entre a y b.
     * @param    a   vertice de origen.
     * @param    b   vertice de llegada.
     * @param    camino  lista con los verices q forman el camino entre a y b.
     * @return   true si existe el camino o false en caso contrario.
     */
    public boolean existeCamino(String a, String b, List camino) {
        boolean existe;
        List    suc;
        String  v;

        existe = false;
        camino.add(a);

        if (existeArco(a, b)) {
            camino.add(b);
            existe = true;
        } else {
            suc = sucesores(a);

            while (!suc.isEmpty() &&!existe) {
                v = String.valueOf(suc.get(1)).toString();
                suc.remove(1);

                if (!camino.contains(v)) {
                    existe = existeCamino(v, b, camino);
                }
            }
        }

        if (!existe) {
            camino.remove(camino.size());
        }

        return (existe);
    }

    /**
     * Determina si existe o no un vertice dentro del grafo.
     * @param    v   el vertice a buscar.
     * @return   verdadero si existe o falso en caso contrario.
     */
    public boolean existeVertice(String v) {
        boolean  esta = false;
        NodoVert aux;

        aux = g.getProx();

        while ((aux != null) &&!esta) {
            if (aux.getInfo().equals(v)) {
                esta = true;
            }

            aux = aux.getProx();
        }

        return (esta);
    }

    /**
     * Obtiene el orden del grafo.
     * @return   el orden del grafo.
     */
    public int ordenGrafo() {
        return orden;
    }

    /**
     * Obtiene la lista de vertices predecesores de v.
     * @param   v   el vertice a buscar.
     * @return  una lista con los vertices predecesores.
     */
    public List predecesores(String v) {
        List     pre;
        NodoVert aux;
        NodoAdy  temp;

        pre = new LinkedList();
        aux = g.getProx();

        while (aux != null) {
            if (!aux.getInfo().equals(v)) {
                temp = aux.getListaAdy().getProxAdy();

                while (temp != null) {
                    if (temp.getInfo().equals(v)) {
                        pre.add(aux.getInfo());

                        break;
                    }

                    temp = temp.getProxAdy();
                }
            }

            aux = aux.getProx();
        }

        return (pre);
    }

    /**
     * Obtiene la lista de vertices sucesores de v.
     * @param   v   el vertice a buscar.
     * @return  una lista con los vertices sucesores.
     */
    public List sucesores(String v) {
        List    suc;
        NodoAdy temp;

        suc  = new LinkedList();
        temp = getVertice(v).getListaAdy().getProxAdy();

        while (temp != null) {
            suc.add(temp.getInfo());
            temp = temp.getProxAdy();
        }

        return (suc);
    }

    /**
     * Obtiene un vertice dentro del grafo.
     * @param    v   el vertice buscar.
     * @return el nodo del vertice a buscar.
     */
    public NodoVert getVertice(String v) {
        NodoVert act;

        act = g.getProx();

        while (act != null) {
            if (act.getInfo().equals(v)) {
                return (act);
            }

            act = act.getProx();
        }

        return (act);
    }
    //~--- get methods --------------------------------------------------------

    /**
     * Obtiene el nodo cabesera de la lista de adyacencia que
     * representa el grafo.
     * @return   El nodo cabecera.
     */
    public NodoVert getG() {
        return (g);
    }
    
    //~--- set methods --------------------------------------------------------

    public void setG(NodoVert p) {
        g = p;
    }
}
