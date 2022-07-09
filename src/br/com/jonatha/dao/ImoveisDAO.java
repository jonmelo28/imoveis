/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jonatha.dao;

import br.com.jonatha.classe.Imovel;
import br.com.jonatha.classe.Imovel2;
import br.com.jonatha.classe.ManipularImagem;
import br.com.jonatha.conexao.ModuloConexao;
import br.com.jonatha.telas.CadastroImoveis;
import br.com.jonatha.telas.Imoveis;
import br.com.jonatha.telas.Email;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonatha
 */
public class ImoveisDAO {
    
     private Connection conexao;
        
    public ImoveisDAO() throws ClassNotFoundException{
        this.conexao = new ModuloConexao().Conector();
    }
    
    public ArrayList<Imovel> BindTable(){
        try {
            ArrayList<Imovel> list = new ArrayList<>();
             String sql = "SELECT i.imagem, i.idimovel, i.endereco, i.bairro, i.cidade, i.estado, i.area, i.valor, i.empreendimento, i.opcionais, i.datapublicacao, i.datavalidade, i.venda, i.idproprietario, p.email FROM imoveis i , proprietario p WHERE i.idproprietario = p.idproprietario and i.venda = 'A Venda' and i.datavalidade >= now()";
        
         
            Statement pst = conexao.createStatement();
            ResultSet rs = pst.executeQuery(sql);
            
            Imovel i;
            while(rs.next()){
             i = new Imovel(
             rs.getBytes(1),
             rs.getInt(2),
             rs.getString(3),
             rs.getString(4),
             rs.getString(5),
             rs.getString(6),
             rs.getDouble(7),
             rs.getString(8).replace(".",","),
             rs.getString(9),
             rs.getString(10),
             rs.getString(11),
             rs.getString(12),
             rs.getString(13),
             rs.getInt(14),
             rs.getString(15)
             );
             list.add(i);
             
            }
             return list; 
             
             
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
           return null;
        }
       
    }
    
    public ArrayList<Imovel> listIdProp(int idProp){
     try{
          ArrayList<Imovel> lista = new ArrayList<>();
         
         String sql = "SELECT `imagem`, `idimovel`, `endereco`, `bairro`, `cidade`, `estado`, `area`, `valor`, `empreendimento`, `opcionais`, `venda` FROM `imoveis` WHERE `idproprietario` = ? and venda = 'A Venda' and datavalidade >= now()";
        
         
         PreparedStatement pst = conexao.prepareStatement(sql);
           pst.setInt(1, idProp);
            ResultSet rs = pst.executeQuery();
            
            Imovel i;
            while(rs.next()){
             i = new Imovel(
             rs.getBytes(1),
             rs.getInt(2),
             rs.getString(3),
             rs.getString(4),
             rs.getString(5),
             rs.getString(6),
             rs.getDouble(7),
             rs.getString(8).replace(".",","),
             rs.getString(9),
             rs.getString(10),
             rs.getString(11)
             );
             lista.add(i);
            }
             return lista; 
       }catch (Exception e){
    
       JOptionPane.showMessageDialog(null, e);
       return null;   
      } 
 }
    
    public String secao() {
        
         CadastroImoveis imo = new CadastroImoveis();
         
            String horan1, horan2, horan3;
              
            
        Calendar horan = Calendar.getInstance();
     
                // formata e exibe a hora atual
                 Format formato = new SimpleDateFormat("HH:mm");
                   horan1 = formato.format(horan.getTime());
 
                // vamos adicionar 1 minuto a esta hora
                 horan.add(Calendar.MINUTE, 1);
 
               // formata e exibe o resultado
               formato = new SimpleDateFormat("HH:mm");
    
              horan2 = formato.format(horan.getTime());    

             // vamos adicionar 2 minutos a esta hora
                horan.add(Calendar.MINUTE, 1);
 
              // formata e exibe o resultado
               formato = new SimpleDateFormat("HH:mm");
    
                 horan3 = formato.format(horan.getTime());
              
                //System.out.println("aqui é da tela imoveis " + horan1);
                //System.out.println("aqui é da tela imoveis " + horan2);
                //System.out.println("aqui é da tela imoveis " + horan3);
                 
                 imo.txtDLog.setText(horan1);
                 imo.txtDLog1.setText(horan2);
                 imo.txtDLog2.setText(horan3);
                 
                return horan1 + horan2 + horan3; 
              
               
         
    
    }
    
 public void cadastrar(Imovel2 obj2){
        try {
        String Sql = "INSERT INTO `imoveis`(`endereco`, `bairro`, `cidade`, `estado`, `area`, `valor`, `empreendimento`, `opcionais`, `datapublicacao`, `datavalidade`, `venda`, `idproprietario`,imagem) VALUES (?,?,?,?,?,?,?,?,CURDATE(), DATE_ADD(CURDATE(), INTERVAL 30 day),'A Venda',?,?)";
            PreparedStatement pst = conexao.prepareStatement(Sql);
                pst.setString(1, obj2.getEndereco());
                pst.setString(2, obj2.getBairro());
                pst.setString(3, obj2.getCidade());
                pst.setString(4, obj2.getEstado());
                pst.setString(5, obj2.getArea());
                pst.setString(6, obj2.getValor());
                pst.setString(7, obj2.getEmpreendimento());
                pst.setString(8, obj2.getOpcionais());
                pst.setInt(9, obj2.getIdproprietario());
                pst.setBytes(10, obj2.getImagem());
                
          
               
                
                
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Imovel cadastrado com sucesso");
            
        
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }   
 
 public void altera(Imovel2 obj2){
  
            try {
        String Sql = "UPDATE imoveis SET endereco=?,bairro=?,cidade=?,estado=?,area=?,valor=?,empreendimento=?,opcionais=?,venda=?,vlvenda=? WHERE idimovel=?";
            PreparedStatement pst = conexao.prepareStatement(Sql);
                pst.setString(1, obj2.getEndereco());
                pst.setString(2, obj2.getBairro());
                pst.setString(3, obj2.getCidade());
                pst.setString(4, obj2.getEstado());
                pst.setString(5, obj2.getArea());
                pst.setString(6, obj2.getValor());
                pst.setString(7, obj2.getEmpreendimento());
                pst.setString(8, obj2.getOpcionais());
                pst.setString(9, obj2.getVenda());
                pst.setString(10, obj2.getVlVenda());
                pst.setInt(11, obj2.getIdimoveis());
          
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Imovel alterado com sucesso");
            
        
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
                
    }   
 
   public void exclui(Imovel2 obj2){
  
            try {
        String Sql = "DELETE FROM imoveis WHERE idimovel=?";
            PreparedStatement pst = conexao.prepareStatement(Sql);
                pst.setInt(1, obj2.getIdimoveis());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Imovel excluido com sucesso");
            
        
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
                
    }  
 
  public Boolean update(Imovel2 obj2){
       Boolean retorno = false;
       String sql = "UPDATE imoveis SET imagem = ? where idimovel = ?";
                
           try {
               PreparedStatement pst = conexao.prepareStatement(sql);
                pst.setBytes(1, obj2.getImagem());
                pst.setInt(2,obj2.getIdimoveis());
                retorno = pst.execute();
                JOptionPane.showMessageDialog(null, "imagem alterada com sucesso");
           } catch (SQLException ex) {
               Logger.getLogger(ImoveisDAO.class.getName()).log(Level.SEVERE, null, ex);
           }
               return retorno;
            }
 
 
    public Imovel2 buscar(int idImovel){
          Imovel2 retorno = null;
          String sql = "SELECT imagem FROM `imoveis` where idimovel = ?";
          try {
             PreparedStatement pst = conexao.prepareStatement(sql);
             pst.setInt(1, idImovel);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                retorno = new Imovel2();
                retorno.setImagem(rs.getBytes("imagem"));
            }
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);
          }
         
          
          return retorno;
      }
    
    public void emailProp(int idProp){
        String sql = "SELECT email FROM proprietario where idproprietario = ?";
          try {
             PreparedStatement pst = conexao.prepareStatement(sql);
             pst.setInt(1, idProp);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
              Email veI = new Email();
              veI.setVisible(true);
              veI.txtEmailProp.setText(rs.getString(1));
                System.out.println(rs.getString(1));
            }
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e);
          }
    }
    
    
}
