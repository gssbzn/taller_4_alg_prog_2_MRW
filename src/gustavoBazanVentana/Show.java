/* Taller 4 */

package gustavoBazanVentana;

import gustavoBazanGrafo.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**Ventana para mostrar informacion*/
public class Show extends JDialog {

    /**
     * Creates new form Show
     */
    public Show(JFrame parent) {
        //super(parent,true);
        initComponents();
        pack();
        Rectangle parentBounds = parent.getBounds();
        Dimension size = getSize();
        // Center in the parent
        int x = Math.max(0, parentBounds.x + (parentBounds.width - size.width) / 2);
        int y = Math.max(0, parentBounds.y + (parentBounds.height - size.height) / 2);
        setLocation(new Point(x, y));
    }

     /** This method is called from within the constructor to
      * initialize the form.
      * WARNING: Do NOT modify this code.
      */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("");
        mainPanel.setLayout(new java.awt.GridBagLayout());

        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(11, 11, 12, 12));
        closeButton.setMnemonic('C');
        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(closeButton, gridBagConstraints);

        textArea.setColumns(25);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setRows(8);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        textArea.setFocusable(false);
        scrollPane.setViewportView(textArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(scrollPane, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(mainPanel, gridBagConstraints);

    }// </editor-fold>//GEN-END:initComponents

    /**Salir.*/
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed
    
    /**Muestra el Archivo de entrada.*/
    public void showIn(){
        setTitle("mrw.in");
        try {
            FileReader fr = new FileReader("mrw.in");
            BufferedReader br = new BufferedReader(fr);
            String str;
            try {
                textArea.setText("");
                while ((str = br.readLine()) != null)
                {
                    str += "\n";
                    textArea.append(str);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            textArea.setForeground(new java.awt.Color(255, 0, 0));
            textArea.setText("ERROR--ARCHIVO NO ENCONTRADO");
        }        
    }
    
    /**Muestra el archivo de salida.*/
    public void showOut(){
        setTitle("mrw.out");
        try {
            FileReader fr = new FileReader("mrw.out");
            BufferedReader br = new BufferedReader(fr);
            String str;
            try {
                textArea.setText("");
                while ((str = br.readLine()) != null)
                {
                    str += "\n";
                    textArea.append(str);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            textArea.setForeground(new java.awt.Color(255, 0, 0));
            textArea.setText("ERROR--ARCHIVO NO ENCONTRADO");
        }        
    }
    
    /**Procesa los datos, mostrandolos tanto por pantalla como guardandolos
     *en el archivo de salida
     */
    public void process(){
        FileReader fr;
        try {
            fr = new FileReader("mrw.in");
            FileWriter fw = null;
            try {
                fw = new FileWriter("mrw.out");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            BufferedReader br = new BufferedReader(fr);
            String str = null, XX, YY;
            int X, M, N, P, T;
            float costo;
            NodoVert g;
            Grafo G;
            NodoAdy H;
            StringTokenizer aux;
            try {

                str = br.readLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            textArea.setText("");
            X = Integer.valueOf(str).intValue();
            for(int j=0; j<X; j++){
                try {
                    str = br.readLine();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                aux=new StringTokenizer(str);
                str=aux.nextToken();
                M = Integer.valueOf(str).intValue();
                str=aux.nextToken();
                N = Integer.valueOf(str).intValue();
                str=aux.nextToken();
                P = Integer.valueOf(str).intValue();
                try {

                    str = br.readLine();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                aux=new StringTokenizer(str);
                G=new Grafo();
                for(int i=0; i<M; i++){
                    str=aux.nextToken();
                    G.agregarVertice(str);
                }

                for(int i=0; i<N; i++){
                    try {
                        str = br.readLine();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    aux=new StringTokenizer(str);
                    XX=aux.nextToken();
                    YY=aux.nextToken();
                    str=aux.nextToken();
                    costo=Float.valueOf(str).floatValue();
                    G.agregarArco(XX, YY, costo);
                    G.agregarArco(YY, XX, costo);
                }

                List cos, camino, V;

                V=new LinkedList();
                g=G.getG().getProx();
                while(g != null){
                     V.add(g.getInfo());
                     g=g.getProx();
                }
                
                textArea.append("Caso de Prueba " + (j+1) + "\n\n");
                try {
                    fw.write("Caso de Prueba " + (j+1) + "\n\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                for(int i=0; i<P; i++){
                    try {
                        str = br.readLine();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    aux=new StringTokenizer(str);
                    str=aux.nextToken();
                    T=Integer.valueOf(str).intValue();
                    XX=aux.nextToken();
                    YY=aux.nextToken();
                    cos = new LinkedList();
                    camino = new LinkedList();
                    GustavoBazanMain.algDijkstra(G, cos, camino, XX);

                    costo=T * Float.valueOf(cos.get(V.indexOf(YY)).toString()).floatValue();
                    if(costo<99999){
                        str=Float.toString(costo);
                        camino(camino, V, V.indexOf(YY), XX, fw);
                        textArea.append(YY + " Bs. " + str + "\n");
                        try {
                            fw.write(YY + " Bs. " + str + "\n");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    else{
                        textArea.append("El envio no se puede realizar\n");
                        try {
                            fw.write("El envio no se puede realizar\n");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                textArea.append("\n");
                try {
                    fw.write("\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            try {
                fr.close();
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            textArea.setForeground(new java.awt.Color(255, 0, 0));
            textArea.setText("ERROR--ARCHIVO NO ENCONTRADO");
        }        
    }
    
    /**Determina el caminio para alcanzar a un vertice
     *@param    P   la lista con el camino.
     *@param    V   la lista con los vertices del grafo.
     *@param    j   la posicion del vertice de donde se viene.
     *@param    n   el vertice de partida.
     */
    public void camino(List P, List V, int j, String n,  FileWriter fw) {
        int i;
        if (P.get(j).toString()==n){
            textArea.append(P.get(j)+" ");
            try {
                fw.write(P.get(j)+" ");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else{
            i=V.indexOf(P.get(j));
            camino(P, V, i, n, fw);
            textArea.append(P.get(j)+" ");
            try {
                fw.write(P.get(j)+" ");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables

}
