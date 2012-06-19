/* Taller 4 */

package gustavoBazanVentana;

import gustavoBazanGrafo.Grafo;
import gustavoBazanGrafo.NodoVert;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import proyecto2.About;

/**Ventana principal*/

public class GustavoBazanMain extends JFrame {

    public static void main(String[] args) {
        new GustavoBazanMain().setVisible(true);
    }
    /**
     * Creates new form Main
     */
    public GustavoBazanMain() {
        initComponents();
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(new Point((screenSize.width - frameSize.width) / 2,
        (screenSize.height - frameSize.width) / 2));
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        mainPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        mainMenu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        showInMenuItem = new javax.swing.JMenuItem();
        showOutMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        process = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        aboutMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setTitle("MRW");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        mainPanel.setLayout(new java.awt.GridBagLayout());

        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        mainPanel.setMinimumSize(new java.awt.Dimension(297, 200));
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gustavoBazanVentana/logo001.gif")));
        mainPanel.add(logo, new java.awt.GridBagConstraints());

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        mainMenu.setForeground(new java.awt.Color(0, 0, 255));
        fileMenu.setMnemonic('F');
        fileMenu.setText("File");
        showInMenuItem.setMnemonic('I');
        showInMenuItem.setText("Show In");
        showInMenuItem.setToolTipText("Muestra el archivo \"mrw.in\"");
        showInMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showInMenuItemActionPerformed(evt);
            }
        });

        fileMenu.add(showInMenuItem);

        showOutMenuItem.setMnemonic('O');
        showOutMenuItem.setText("Show Out");
        showOutMenuItem.setToolTipText("Muestra el archivo \"mrw.out\"");
        showOutMenuItem.setDoubleBuffered(true);
        showOutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showOutMenuItemActionPerformed(evt);
            }
        });

        fileMenu.add(showOutMenuItem);

        fileMenu.add(jSeparator1);

        process.setMnemonic('P');
        process.setText("Process");
        process.setToolTipText("Procesar el archivo de entrada");
        process.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processActionPerformed(evt);
            }
        });

        fileMenu.add(process);

        fileMenu.add(jSeparator2);

        aboutMenuItem.setMnemonic('A');
        aboutMenuItem.setText("About");
        aboutMenuItem.setToolTipText("About MRW");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });

        fileMenu.add(aboutMenuItem);

        exitMenuItem.setMnemonic('E');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });

        fileMenu.add(exitMenuItem);

        mainMenu.add(fileMenu);

        setJMenuBar(mainMenu);

    }// </editor-fold>//GEN-END:initComponents

    /**Procesar el archivo de entrada.*/
    private void processActionPerformed(java.awt.event.ActionEvent evt) {
//GEN-FIRST:event_processActionPerformed
        Show salida;
        salida = new Show(this);
	salida.setVisible(true);
	salida.process();
    }//GEN-LAST:event_processActionPerformed

    /**Mostrar el archivo de salida "mrw.out".*/
    private void showOutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
//GEN-FIRST:event_showOutMenuItemActionPerformed
        Show salida;
        salida = new Show(this);
	salida.setVisible(true);
	salida.showOut();
    }//GEN-LAST:event_showOutMenuItemActionPerformed

    /**Mostrar el archivo de entrada "mrw.in".*/
    private void showInMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
//GEN-FIRST:event_showInMenuItemActionPerformed
        Show entrada;
        entrada = new Show(this);
	entrada.setVisible(true);
	entrada.showIn();
    }//GEN-LAST:event_showInMenuItemActionPerformed

    /**Mostrar la ventana con la informacion del producto.*/
    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
//GEN-FIRST:event_aboutMenuItemActionPerformed
        new About(this).setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    /**Salir*/
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed
    
    /**Salir*/
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm
   
    /**Algoritmo para calcular el camino mas corto entre dos vertices de un grafo.
     *@param    G   El grafo donde buscar,
     *@param    cos La lista con los costos entre v y el vertice en la posicion i.
     *@param    cam La lista con los caminos entre los vertices.
     *@param    v   El vertice de partida.
     */
    public static void algDijkstra(Grafo G, List cos, List cam, String v){
	List T, V; // En T se van agregando los vértices ya tratados. En V los vertices del Grafo.// En T se van agregando los vértices ya tratados. En V los vertices del Grafo.
        int i; // i es contador de vértices.
        float costo;
        NodoVert aux;
        
        T=new LinkedList();
        T.add(v); 
        
        V=new LinkedList();
        
        aux=G.getG().getProx();
        while(aux!=null){
             V.add(aux.getInfo());
             cam.add(v);
             aux=aux.getProx();
        }
        
        for(i=0;i<V.size();i++){
            if(v.equals(V.get(i))){
                cos.add(Float.valueOf("0"));
            }
            else if(G.existeArco(v, V.get(i).toString())){
                cos.add(Float.valueOf(String.valueOf(G.costoArco(v, V.get(i).toString()))));
            }
            else{
                cos.add(Float.valueOf("99999"));
            }
        }
        
        int k=0;
        for(i=0; i<V.size()-1; i++){
            float temp=10000;
            //elegir un vértice  k pertence (V – T)  tal que  Costo[k]  sea el menor posible;
            for(int j=0; j < V.size(); j++){
                if(!T.contains(V.get(j))){
                    if(Float.valueOf(cos.get(j).toString()).floatValue() < temp){
                        temp=Float.valueOf(cos.get(j).toString()).floatValue();
                        k=j;
                    }
                }
            }
            T.add(V.get(k));
            for(int j=0; j<V.size(); j++){
                if(!T.contains(V.get(j))){
                    if(G.existeArco(V.get(k).toString(),V.get(j).toString())){
                        if(Float.valueOf(cos.get(k).toString()).floatValue() + G.costoArco(V.get(k).toString(),V.get(j).toString()) < Float.valueOf(cos.get(j).toString()).floatValue()){
                            costo=Float.valueOf(cos.get(k).toString()).floatValue() + G.costoArco(V.get(k).toString(),V.get(j).toString());
                            cos.set(j, Float.valueOf(Float.toString(costo)));
                            cam.set(j, V.get(k));
                        }
                    }
                }
            }
        }
    }// fin procedimiento alg_Dijkstra //
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel logo;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem process;
    private javax.swing.JMenuItem showInMenuItem;
    private javax.swing.JMenuItem showOutMenuItem;
    // End of variables declaration//GEN-END:variables

}
