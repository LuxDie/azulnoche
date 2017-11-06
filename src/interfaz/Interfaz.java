/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.io.PrintStream;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Nacho
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public Interfaz(proyecto.Controlador controlador) {
        System.out.println("Intf init");
        initComponents();
        setSize(815, 600);
        setLocationRelativeTo(null);
        areaTexto.setOpaque(false);
        areaTexto.setEditable(false);
        inputTexto.setText("");
        this.controlador = controlador;
        /*{
            ventanaTexto(controlador.accion(""));
        }*/
        System.out.println("Intf OK");
    }
    
    proyecto.Controlador controlador;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputTexto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botonEnviar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        inputTexto.setText("Escriba aquí");
        getContentPane().add(inputTexto);
        inputTexto.setBounds(50, 480, 220, 30);

        areaTexto.setEditable(false);
        areaTexto.setColumns(20);
        areaTexto.setLineWrap(true);
        areaTexto.setRows(5);
        jScrollPane1.setViewportView(areaTexto);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 60, 330, 360);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Inventario");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(510, 34, 160, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/correccion2.png"))); // NOI18N
        jLabel4.setText("Inventario");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(500, 30, 170, 60);

        botonEnviar.setText("Enviar");
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(botonEnviar);
        botonEnviar.setBounds(280, 480, 80, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/correcion.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(430, 30, 65, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/correccion2.png"))); // NOI18N
        jLabel8.setText("Inventario");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 430, 170, 140);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/inventario.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(440, 30, 306, 497);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/correccion2.png"))); // NOI18N
        jLabel7.setText("Inventario");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(200, 470, 180, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/resize.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 840, 564);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interfaz/correccion2.png"))); // NOI18N
        jLabel6.setText("Inventario");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(500, 30, 170, 60);

        jInternalFrame1.setVisible(true);
        jInternalFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jInternalFrame1);
        jInternalFrame1.setBounds(0, 0, 800, 570);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
        String texto = textoUsuario();
        ventanaTexto(controlador.accion(texto));
    }//GEN-LAST:event_botonEnviarActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public JTextArea getTextArea () {
        return areaTexto;
    }
    
    public void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz(controlador).setVisible(true);
            }
        });
    }
    
    public void ventanaTexto(String texto) {
        areaTexto.setText(areaTexto.getText()+texto);
    }
    
    public String textoUsuario() {
        String texto = inputTexto.getText();
        return texto;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaTexto;
    public javax.swing.JButton botonEnviar;
    private javax.swing.JTextField inputTexto;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
