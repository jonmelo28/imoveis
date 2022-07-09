/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jonatha.dao;

import br.com.jonatha.classe.Proprietario;
import br.com.jonatha.classe.ValidaCPF;
import br.com.jonatha.conexao.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonatha
 */
public class ProprietarioDAO {
     private Connection conexao;
        
    public ProprietarioDAO(){
        this.conexao = ModuloConexao.Conector();
    } 
    
    public void CadastrarProprietario(Proprietario obj){
        try {
           String sql = "INSERT INTO proprietario (nome, email, telefone, cpf, senha) VALUES (?, ?, ?, ?, aes_encrypt(?,'nome'))";
         try (PreparedStatement pst = conexao.prepareStatement(sql)) {
                pst.setString(1, obj.getNome());
                pst.setString(2, obj.getEmail());
                pst.setString(3, obj.getTelefone());
                pst.setString(4, obj.getCpf());
                pst.setString(5, obj.getSenha());
                pst.execute();
                
                
                
                JOptionPane.showMessageDialog(null, "Proprietário cadastrado com sucesso");
                
            }
        
        }catch (java.sql.SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "CPF já cadastrado favor informa outro cpf");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
