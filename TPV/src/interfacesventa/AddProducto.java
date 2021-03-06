/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesventa;

import conexion_bbdd.Agente;
import interfacesventa.modelo.Categoria;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class AddProducto extends javax.swing.JDialog {

    private Productos prod;
    private int id;
    private char tipo;
    
    /**
     * Creates new form AddProducto
     */
    public AddProducto(java.awt.Frame parent, boolean modal, char tipo) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.tipo = tipo;
        this.setTitle("Añadir/Modificar producto");
        setCategorias();
    }
    
    public void setProductos (Productos prod) {
        this.prod = prod;
    }
    
    public void setDatos (int id, String producto, String descripcion, String categoria, String precio, String descuento) {
        this.id = id;
        txtProducto.setText(producto);
        txtDescripcion.setText(descripcion);
        
        boolean encontrado = false;
        for (int i=0;i<cboCategoria.getItemCount() && !encontrado; i++) {
            Categoria aux = (Categoria) cboCategoria.getItemAt(i);
            if (aux.getNombreCategoria().equals(categoria)) {
                encontrado = true;
                cboCategoria.setSelectedIndex(i);
                System.out.println(i);
            }
        }
        
        txtPrecio.setText(precio);
        txtDescuento.setText(descuento);
    }
    
    public void setCategorias () {
        cboCategoria.removeAllItems();
        try {
            Connection conexion = Agente.getAgente().mBD;
            String sql = "SELECT ID_CATEGORIA, NOMBRE_CAT FROM CATEGORIAS";
            Statement sentencia = conexion.createStatement();
            ResultSet result = sentencia.executeQuery(sql);
            
            while (result.next()) {
                Categoria aux = new Categoria(result.getInt(1),result.getString(2));
                cboCategoria.addItem(aux);
            }  
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtProducto = new javax.swing.JTextField();
        lblProducto = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        cboCategoria = new javax.swing.JComboBox<>();
        txtPrecio = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblAsterisco = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblDescuento = new javax.swing.JLabel();
        lblAsterisco1 = new javax.swing.JLabel();
        lblAsterisco2 = new javax.swing.JLabel();
        lblAsterisco4 = new javax.swing.JLabel();
        lblAsterisco5 = new javax.swing.JLabel();
        lblAsterisco6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblProducto.setText("Producto:");

        lblDescripcion.setText("Descripción:");

        btnAceptar.setBackground(new java.awt.Color(255, 255, 255));
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_confirmacion.png"))); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_cancelar.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblAsterisco.setForeground(new java.awt.Color(255, 0, 0));
        lblAsterisco.setText("*");

        lblCategoria.setText("Categoría:");

        lblPrecio.setText("Precio:");

        lblDescuento.setText("Descuento:");

        lblAsterisco1.setForeground(new java.awt.Color(255, 0, 0));
        lblAsterisco1.setText("*");

        lblAsterisco2.setForeground(new java.awt.Color(255, 0, 0));
        lblAsterisco2.setText("*");

        lblAsterisco4.setForeground(new java.awt.Color(255, 0, 0));
        lblAsterisco4.setText("*");

        lblAsterisco5.setForeground(new java.awt.Color(255, 0, 0));
        lblAsterisco5.setText("*");

        lblAsterisco6.setForeground(new java.awt.Color(255, 0, 0));
        lblAsterisco6.setText("* Todos los campos son obligatorios");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_producto_vent.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_descuento.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_precio.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_descripcion.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_categorias.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAceptar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblProducto)
                                    .addComponent(lblDescripcion)
                                    .addComponent(lblCategoria)
                                    .addComponent(lblPrecio)
                                    .addComponent(lblDescuento))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDescuento)
                                    .addComponent(txtPrecio)
                                    .addComponent(txtProducto)
                                    .addComponent(txtDescripcion)
                                    .addComponent(cboCategoria, 0, 320, Short.MAX_VALUE)))
                            .addComponent(lblAsterisco6, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAsterisco)
                    .addComponent(lblAsterisco1)
                    .addComponent(lblAsterisco2)
                    .addComponent(lblAsterisco4)
                    .addComponent(lblAsterisco5))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblProducto)
                                    .addComponent(lblAsterisco)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDescripcion)
                                    .addComponent(lblAsterisco1))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCategoria)
                                    .addComponent(lblAsterisco2))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPrecio)
                                    .addComponent(lblAsterisco4))
                                .addGap(17, 17, 17))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)))
                        .addComponent(lblAsterisco5)
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescuento)))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAsterisco6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (!txtProducto.getText().trim().isEmpty() && !txtDescripcion.getText().trim().isEmpty() && !txtPrecio.getText().trim().isEmpty() && !txtDescuento.getText().trim().isEmpty()) {
            String producto = txtProducto.getText();
            String descripcion = txtDescripcion.getText();
            String precio = txtPrecio.getText();
            String descuento = txtDescuento.getText();
            Categoria aux = (Categoria) cboCategoria.getSelectedItem();
            if (tipo=='+') {
                try {
                    String sql = "INSERT INTO PRODUCTOS (NOMBRE_PROD, DESCRIPCION, ID_CATEGORIA, PRECIO, DESCUENTO) VALUES ('"+producto+"','"+descripcion+"',"+aux.getId()+","+precio+","+descuento+")";
                    Connection conexion = Agente.getAgente().mBD;
                    Statement sentencia = conexion.createStatement();
                    sentencia.executeUpdate(sql);
                    sentencia.close();

                    this.setVisible(false);
                    this.prod.cargarDatos();
                    this.dispose();
                } catch (Exception ex) {
                    System.out.println(ex+" "+ex.getMessage());
                }
            } else if (tipo=='M') {
                try {
                    String sql = "UPDATE PRODUCTOS SET NOMBRE_PROD='"+producto+"', DESCRIPCION='"+descripcion+"', ID_CATEGORIA="+aux.getId()+", PRECIO="+precio+", DESCUENTO="+descuento+" WHERE ID_PRODUCTO="+id;
                    Connection conexion = Agente.getAgente().mBD;
                    Statement sentencia = conexion.createStatement();
                    sentencia.executeUpdate(sql);
                    sentencia.close();

                    this.setVisible(false);
                    this.prod.cargarDatos();
                    this.dispose();
                } catch (Exception ex) {
                    System.out.println(ex+" "+ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hay campos vacíos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<Categoria> cboCategoria;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblAsterisco;
    private javax.swing.JLabel lblAsterisco1;
    private javax.swing.JLabel lblAsterisco2;
    private javax.swing.JLabel lblAsterisco4;
    private javax.swing.JLabel lblAsterisco5;
    private javax.swing.JLabel lblAsterisco6;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
