/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jonatha.dao;

import br.com.jonatha.conexao.ModuloConexao;
import br.com.jonatha.telas.CadastroImoveis;
import br.com.jonatha.telas.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Format;
import java.text.SimpleDateFormat;
import static java.time.LocalDateTime.now;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonatha
 */
public class LoginDAO {
    private Connection conexao;
    
        
    public LoginDAO() throws ClassNotFoundException{
        this.conexao = new ModuloConexao().Conector();
    }
    
    CadastroImoveis princ = new CadastroImoveis();
       
    
    public boolean logar(String cpf, String senha) {
       
        
        try {
            String Sql = "SELECT * FROM proprietario WHERE cpf = ? and senha = aes_encrypt(?,'nome')";
            PreparedStatement pst = conexao.prepareStatement(Sql);
            pst.setString(1, cpf);
            pst.setString(2, senha);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                 
                 
                 princ.setVisible(true);
                 princ.txtIdProp.setText(rs.getString(1));
                 secao();
                //fecha a tela de login 
                //this.dispose();
                //fecha a conexão com o banco
                conexao.close();
            } else {
                Login login = new Login();
                login.setVisible(true);
                JOptionPane.showMessageDialog(null, "Usuário ou senha não encontrado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }

    
    public void secao(){
        //abre a tela cadastro de imoveis
                
                
                Calendar hora = Calendar.getInstance();
     
                // formata e exibe a hora atual
                 Format formato = new SimpleDateFormat("HH:mm");
                  String hora1 = formato.format(hora.getTime());
 
                // vamos adicionar 1 minuto a esta hora
                 hora.add(Calendar.MINUTE, 1);
 
               // formata e exibe o resultado
               formato = new SimpleDateFormat("HH:mm");
    
             String hora2 = formato.format(hora.getTime());    

             // vamos adicionar 2 minutos a esta hora
                hora.add(Calendar.MINUTE, 1);
 
              // formata e exibe o resultado
               formato = new SimpleDateFormat("HH:mm");
    
                 String hora3 = formato.format(hora.getTime());
                
                
                 princ.txtDLog.setText(hora1);
                 princ.txtDLog1.setText(hora2);
                 princ.txtDLog2.setText(hora3);
        
    }
 
      
    
}