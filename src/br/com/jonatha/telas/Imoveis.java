/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.jonatha.telas;

import br.com.jonatha.dao.ImoveisDAO;
import br.com.jonatha.classe.Imovel;
import br.com.jonatha.classe.Model;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Jonatha
 */
public class Imoveis extends javax.swing.JFrame {
    
    //Connection conexao = null;
    //PreparedStatement pst = null;
    //ResultSet  rs = null;

    /**
     * Creates new form Imoveis
     */
    public Imoveis()  {
        
        initComponents();
        populateJTable();
           
       
    }
    
    public void populateJTable() {
        
           
        try {
             ImoveisDAO imoveisdao = new ImoveisDAO();
             ArrayList<Imovel> list = imoveisdao.BindTable();
            String[] columnName = {"Imagem","Data","Valor","Area","Endereço"}; //,"IdProp","IdImo"
        Object[][] rows = new Object[list.size()][8];
        for(int i = 0; i < list.size(); i++){
            rows[i][0] = list.get(i).getImagem();
            rows[i][1] = list.get(i).getDatapublicacao();
            rows[i][2] = list.get(i).getValor();
            rows[i][3] = list.get(i).getArea();
            rows[i][4] = list.get(i).getEndereco();
            rows[i][5] = list.get(i).getIdproprietario();
            rows[i][6] = list.get(i).getIdimoveis();
            rows[i][7] = list.get(i).getEmail();
         if(list.get(i).getImagem() != null){
                
             ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getImagem()).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   //.getScaledInstance(150, 120, Image.SCALE_SMOOTH)
                
            rows[i][0] = image;
            }
            else{
                rows[i][0] = null;
            }
            rows[i][1] = list.get(i).getDatapublicacao();
            rows[i][2] = "RS "+list.get(i).getValor();
            rows[i][3] = list.get(i).getArea();   
            rows[i][4] = list.get(i).getEndereco();
            rows[i][5] = list.get(i).getIdproprietario();
            rows[i][6] = list.get(i).getIdimoveis();
            rows[i][7] = list.get(i).getEmail();
            
        }
        Model model = new Model(rows, columnName);
        jTable1.setModel(model);
        jTable1.setRowHeight(120);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(150);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Imoveis.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
    
     public void setar_campo_vend(){
         
       int setar = jTable1.getSelectedRow(); 
       
                Email vIm = new Email();
                vIm.setVisible(true);
                vIm.txtIdImovel.setText(jTable1.getModel().getValueAt(setar, 6).toString());
                vIm.txtIdProp.setText(jTable1.getModel().getValueAt(setar, 5).toString());
                vIm.txtEmailProp.setText(jTable1.getModel().getValueAt(setar, 7).toString());
                
               
    }
     
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLC = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLC.setText("Login / Cadastrar");
        btnLC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLCActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLC)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(885, 606));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLCActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_btnLCActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        setar_campo_vend();
        
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Imoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Imoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Imoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Imoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Imoveis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLC;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
