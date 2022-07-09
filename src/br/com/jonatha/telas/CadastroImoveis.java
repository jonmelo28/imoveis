/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.jonatha.telas;

import br.com.jonatha.classe.Imovel;
import br.com.jonatha.classe.Imovel2;
import br.com.jonatha.classe.ManipularImagem;
import br.com.jonatha.classe.Model;
import java.text.SimpleDateFormat;
import java.util.Date;
import br.com.jonatha.dao.ImoveisDAO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonatha
 */
public class CadastroImoveis extends javax.swing.JFrame {

    
    BufferedImage imagem;
    /**
     * Creates new form CadastroImoveis
     */
    public CadastroImoveis() {
       
        initComponents();
        
         
    }
    
    
    public void verifica(){
       // try {
       //     ImoveisDAO dao = new ImoveisDAO();
       //     dao.secao();
       // } catch (ClassNotFoundException ex) {
       //     Logger.getLogger(CadastroImoveis.class.getName()).log(Level.SEVERE, null, ex);
       // }
        
        String horan1 = txtDLog.getText() , horan2 = txtDLog1.getText(), horan3 = txtDLog2.getText(), horaAtual;
        //int idProp;
        
        //hora = txtDLog.getText();
        //hora1 = txtDLog1.getText();
        //hora2 = txtDLog2.getText();
        
         
        
        Date dataHoraAtual = new Date();
         
         horaAtual = new SimpleDateFormat("HH:mm").format(dataHoraAtual);
        if(horaAtual.equals(horan1) || horaAtual.equals(horan2) || horaAtual.equals(horan3) ){
            CadastroImoveis imo = new CadastroImoveis(); 
            //imo.setVisible(true);
            imo.txtDLog.setText(horan1);
            imo.txtDLog1.setText(horan2);
            imo.txtDLog2.setText(horan3);

         
        }else{
           Login login = new Login();
           login.setVisible(true);
           this.dispose();
        }
        
    }
    
   public void adicionar(){
       
         Imovel2 obj2 = new Imovel2();
                
              obj2.setEndereco(txtEndereco.getText());  
              obj2.setBairro(txtBairro.getText());  
              obj2.setCidade(txtCidade.getText());  
              obj2.setEstado(txtEstado.getText());  
              obj2.setArea(txtArea.getText().replace(",", "."));  
              obj2.setValor(txtValor.getText().replace(",", "."));  
              obj2.setEmpreendimento(txtEmpreendimento.getSelectedItem().toString());  
              obj2.setOpcionais(txtOpcao.getText());  
              obj2.setIdproprietario(Integer.parseInt(txtIdProp.getText()) );  
              obj2.setImagem(ManipularImagem.getImgBytes(imagem));
        
        if ((txtEndereco.getText().isEmpty()) || (txtBairro.getText().isEmpty()) || (txtCidade.getText().isEmpty()) || (txtEstado.getText().isEmpty()) ||  (txtArea.getText().isEmpty()) || (txtValor.getText().isEmpty()) || (txtIdProp.getText().isEmpty())) {
                
             JOptionPane.showMessageDialog(null, "Preencha os compos obrigatórios");
            } else {
            
        
             
                
            try {
                 ImoveisDAO dao = new ImoveisDAO();
                  dao.cadastrar(obj2);
            } catch (ClassNotFoundException ex) {
               JOptionPane.showMessageDialog(null, ex);
            }
             
               
                //listarStiuacao();
                 //limparCampos();
           
        }
        
    }
   
   public void alterar(){
          int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar o imovel","Atenção",JOptionPane.YES_NO_OPTION);
        
         if(confirma == JOptionPane.YES_OPTION){
         Imovel2 obj2 = new Imovel2();
                
              obj2.setEndereco(txtEndereco.getText());  
              obj2.setBairro(txtBairro.getText());  
              obj2.setCidade(txtCidade.getText());  
              obj2.setEstado(txtEstado.getText());  
              obj2.setArea(txtArea.getText().replace(",", "."));  
              obj2.setValor(txtValor.getText().replace(",", "."));  
              obj2.setEmpreendimento(txtEmpreendimento.getSelectedItem().toString());  
              obj2.setOpcionais(txtOpcao.getText());  
              obj2.setVenda(cbVenda.getSelectedItem().toString());
              obj2.setIdimoveis(Integer.parseInt(txtIdImovel.getText()));
        
        if ((txtEndereco.getText().isEmpty()) || (txtBairro.getText().isEmpty()) || (txtCidade.getText().isEmpty()) || (txtEstado.getText().isEmpty()) ||  (txtArea.getText().isEmpty()) || (txtValor.getText().isEmpty()) || (txtIdProp.getText().isEmpty())) {
                
             JOptionPane.showMessageDialog(null, "Preencha os compos obrigatórios");
            } else {
            
        
             if(cbVenda.getSelectedItem().equals("Vendido")){
                 if(txtVlVenda.getText().isEmpty()){
                     JOptionPane.showMessageDialog(null, "Preencher o Valor da venda");
                 }else{
                   try {
                 ImoveisDAO dao = new ImoveisDAO();
                  dao.altera(obj2);
            } catch (ClassNotFoundException ex) {
               JOptionPane.showMessageDialog(null, ex);
            }  
                 }
             }
                
            
             
        }
         } 
    }
 
   public void excluir(){
          int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar o imovel","Atenção",JOptionPane.YES_NO_OPTION);
        
         if(confirma == JOptionPane.YES_OPTION){
         Imovel2 obj2 = new Imovel2();
              obj2.setIdimoveis(Integer.parseInt(txtIdImovel.getText()));
                  
                
            try {
                 ImoveisDAO dao = new ImoveisDAO();
                  dao.exclui(obj2);
            } catch (ClassNotFoundException ex) {
               JOptionPane.showMessageDialog(null, ex);
            }
             
        
         } 
    }
 
   
   public void populateJTable() {
         String idProp;
           idProp = txtIdProp.getText();
           
        try {
             ImoveisDAO imoveisdao = new ImoveisDAO();
             ArrayList<Imovel> list = imoveisdao.listIdProp(Integer.parseInt(idProp));
            String[] columnName = {"Imagem","Cód.Imovel","Endereço","Bairro","Cidade","Estado","Area","Valor","Empreendimento","Opcionais","Venda"}; 
        Object[][] rows = new Object[list.size()][11];
        for(int i = 0; i < list.size(); i++){
            rows[i][0] = list.get(i).getImagem();
            rows[i][1] = list.get(i).getIdimoveis();
            rows[i][2] = list.get(i).getEndereco();
            rows[i][3] = list.get(i).getBairro();
            rows[i][4] = list.get(i).getCidade();
            rows[i][5] = list.get(i).getEstado();
            rows[i][6] = list.get(i).getArea();
            rows[i][7] = list.get(i).getValor();
            rows[i][8] = list.get(i).getEmpreendimento();            
            rows[i][9] = list.get(i).getOpcionais();          
            rows[i][10] = list.get(i).getVenda();
         if(list.get(i).getImagem() != null){
                
             ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getImagem()).getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   //.getScaledInstance(150, 120, Image.SCALE_SMOOTH)
                
            rows[i][0] = image;
            }
            else{
                rows[i][0] = null;
            }
            
            rows[i][1] = list.get(i).getIdimoveis();
            rows[i][2] = list.get(i).getEndereco();
            rows[i][3] = list.get(i).getBairro();
            rows[i][4] = list.get(i).getCidade();
            rows[i][5] = list.get(i).getEstado();
            rows[i][6] = list.get(i).getArea();
            rows[i][7] = list.get(i).getValor();
            rows[i][8] = list.get(i).getEmpreendimento();            
            rows[i][9] = list.get(i).getOpcionais();            
            rows[i][10] = list.get(i).getVenda();
            
        }
        Model model = new Model(rows, columnName);
        tblImoveis.setModel(model);
        tblImoveis.setRowHeight(120);
        tblImoveis.getColumnModel().getColumn(0).setPreferredWidth(150);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Imoveis.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
    }
  
    public void setar_campo(){
       int setar = tblImoveis.getSelectedRow();       
                txtIdImovel.setText(tblImoveis.getModel().getValueAt(setar, 1).toString());
                txtEndereco.setText(tblImoveis.getModel().getValueAt(setar, 2).toString());
                txtBairro.setText(tblImoveis.getModel().getValueAt(setar, 3).toString());
                txtCidade.setText(tblImoveis.getModel().getValueAt(setar, 4).toString());
                txtEstado.setText(tblImoveis.getModel().getValueAt(setar, 5).toString());
                txtArea.setText(tblImoveis.getModel().getValueAt(setar, 6).toString().replace(".", ","));
                txtValor.setText(tblImoveis.getModel().getValueAt(setar, 7).toString().replace(".", ","));
                txtEmpreendimento.setSelectedItem(tblImoveis.getModel().getValueAt(setar, 8).toString());
                txtOpcao.setText(tblImoveis.getModel().getValueAt(setar, 9).toString());
                cbVenda.setSelectedItem(tblImoveis.getModel().getValueAt(setar, 10).toString());
                btnSalvarImagem.setVisible(true);
                btnAlterar.setEnabled(true);
                btnExcluir.setEnabled(true);
                btnInsert.setEnabled(false);
                cbVenda.setEnabled(true);
                txtVlVenda.setEnabled(true);
                        
    }
    
   
    
    public void img(){
         String idImovel;
         
        try {
            idImovel = txtIdImovel.getText();
            ImoveisDAO dao;
            dao = new ImoveisDAO();
            Imovel2 exe = dao.buscar(Integer.parseInt(idImovel));
        ManipularImagem.exibiImagemLabel(exe.getImagem(), lblImagem);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroImoveis.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void limpaCampo(){
                txtIdImovel.setText(null);
                txtEndereco.setText(null);
                txtBairro.setText(null);
                txtCidade.setText(null);
                txtEstado.setText(null);
                txtArea.setText(null);
                txtValor.setText(null);
                txtEmpreendimento.setSelectedIndex(0);
                txtOpcao.setText(null);
                cbVenda.setSelectedIndex(0);
                btnInsert.setEnabled(true);
                btnSalvarImagem.setVisible(false);
                cbVenda.setEnabled(false);
                btnAlterar.setEnabled(false);
                btnExcluir.setEnabled(false);
                lblImagem.setIcon(null);
                txtVlVenda.setText(null);
                txtVlVenda.setEnabled(false);
                
    }
    
    public void imgAlt(){
        try {
            
             Imovel2 obj2 = new Imovel2();
            obj2.setImagem(ManipularImagem.getImgBytes(imagem));
            ImoveisDAO dao = new ImoveisDAO();
            dao.update(obj2);
                       
            
         } catch (Exception ex) {
             Logger.getLogger(CadastroImoveis.class.getName()).log(Level.SEVERE, null, ex);
         }
         btnSalvarImagem.setVisible(false);
       
    }     
    
    public void calculo(){
         double vl = 0;
         double v = 0;
        double vlA = 5000;
        double vlC = 0.3;
        if(!txtArea.getText().isEmpty()){
            if(txtEmpreendimento.getSelectedItem().equals("Residencial")){
                vl = Double.parseDouble(txtArea.getText().replace(",", ".")) * vlA;
                int confirma = JOptionPane.showConfirmDialog(null, "O valor calculado para o imovel residencial é " + vl,"Atenção",JOptionPane.YES_NO_OPTION);
        
                     if(confirma == JOptionPane.YES_OPTION){
                         txtValor.setText(String.valueOf(vl).replace(".", ","));
        
                 }
            }else{
                v = (Double.parseDouble(txtArea.getText().replace(",", ".")) * vlA);
               vl = v +(v * vlC) ;
                int confirma = JOptionPane.showConfirmDialog(null, "O valor calculado para o imovel Comercial é " + vl,"Atenção",JOptionPane.YES_NO_OPTION);
        
                     if(confirma == JOptionPane.YES_OPTION){
                         txtValor.setText(String.valueOf(vl).replace(".", ","));
        
                 } 
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblImoveis = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtIdImovel = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        txtArea = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        txtOpcao = new javax.swing.JTextField();
        txtDLog = new javax.swing.JTextField();
        txtDLog1 = new javax.swing.JTextField();
        txtDLog2 = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtIdProp = new javax.swing.JTextField();
        lblImagem = new javax.swing.JLabel();
        btnSelImg = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbVenda = new javax.swing.JComboBox<>();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSalvarImagem = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtVlVenda = new javax.swing.JTextField();
        txtEmpreendimento = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblImoveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Imagem", "Cód. Imóvel", "Endereço", "Bairro", "Cidade", "Estado", "Área (m2)", "Valor", "Empreendimento", "Opção de Lazer", "Situação"
            }
        ));
        tblImoveis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblImoveisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblImoveis);

        jLabel1.setText("Cód.Imóvel ");

        jLabel2.setText("Endereço");

        jLabel3.setText("Bairro");

        jLabel4.setText("Cidade");

        jLabel5.setText("Estado");

        jLabel6.setText("Área (m2)");

        jLabel7.setText("Valor");

        jLabel8.setText("Empreendimento");

        jLabel9.setText("Opções de lazer");

        txtIdImovel.setEnabled(false);

        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });

        txtBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBairroActionPerformed(evt);
            }
        });

        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        txtArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAreaActionPerformed(evt);
            }
        });

        txtValor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtValorFocusLost(evt);
            }
        });
        txtValor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtValorMouseClicked(evt);
            }
        });
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });

        txtDLog.setEditable(false);
        txtDLog.setEnabled(false);
        txtDLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDLogActionPerformed(evt);
            }
        });

        txtDLog1.setEditable(false);
        txtDLog1.setEnabled(false);
        txtDLog1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDLog1ActionPerformed(evt);
            }
        });

        txtDLog2.setEditable(false);
        txtDLog2.setEnabled(false);
        txtDLog2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDLog2ActionPerformed(evt);
            }
        });

        btnInsert.setText("Cadastrar Imóvel");
        btnInsert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInsertMouseClicked(evt);
            }
        });
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        jLabel10.setText("Cód.Proprietario");

        txtIdProp.setEditable(false);
        txtIdProp.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        lblImagem.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnSelImg.setText("Selecionar Imagem");
        btnSelImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSelImgMouseClicked(evt);
            }
        });
        btnSelImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelImgActionPerformed(evt);
            }
        });

        jLabel11.setText("Situação");

        cbVenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A Venda", "Vendido" }));
        cbVenda.setEnabled(false);

        btnAlterar.setText("Alterar Imóvel");
        btnAlterar.setEnabled(false);
        btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterarMouseClicked(evt);
            }
        });
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir Imóvel");
        btnExcluir.setEnabled(false);
        btnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExcluirMouseClicked(evt);
            }
        });
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSalvarImagem.setText("Alterar Imagem");
        btnSalvarImagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarImagemMouseClicked(evt);
            }
        });
        btnSalvarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarImagemActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSairMouseClicked(evt);
            }
        });
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel12.setText("Valor Venda");

        txtVlVenda.setEnabled(false);

        txtEmpreendimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Residencial", "Comercial" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnInsert)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdImovel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(txtDLog, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(txtDLog2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(txtDLog1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 926, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))
                                        .addGap(32, 32, 32)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(145, 145, 145)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(2, 2, 2)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(26, 26, 26)
                                                        .addComponent(btnSelImg)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(btnSalvarImagem)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(txtOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel12))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtIdProp, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtVlVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtEmpreendimento, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(315, 315, 315)
                                        .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtIdImovel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDLog2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDLog1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDLog, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtOpcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdProp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txtEmpreendimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(21, 21, 21)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(30, 30, 30)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cbVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtVlVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnSelImg)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair)
                    .addComponent(btnSalvarImagem)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairroActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
       //pesquisaImo();
       populateJTable();
       txtDLog.setVisible(false);
       txtDLog1.setVisible(false);
       txtDLog2.setVisible(false);
       btnSalvarImagem.setVisible(false);
       txtVlVenda.setEnabled(false);
       txtIdProp.setEnabled(false);
       // try {
       //     ImoveisDAO dao = new ImoveisDAO();
       //     dao.secao();
            
       // } catch (Exception ex) {
       //     Logger.getLogger(CadastroImoveis.class.getName()).log(Level.SEVERE, null, ex);
       // }
        
    }//GEN-LAST:event_formWindowOpened

    private void txtDLog1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDLog1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDLog1ActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        if(lblImagem.getIcon() == null){
            JOptionPane.showMessageDialog(null, "Selecionar uma imagem");
            verifica();
        }else{
        adicionar();
        verifica();
        populateJTable();
        limpaCampo();
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void btnInsertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInsertMouseClicked
        // TODO add your handling code here:
      
        
    }//GEN-LAST:event_btnInsertMouseClicked

    private void txtDLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDLogActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDLogActionPerformed

    private void txtDLog2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDLog2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDLog2ActionPerformed

    private void txtAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAreaActionPerformed

    private void btnSelImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSelImgMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSelImgMouseClicked

    private void btnSelImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelImgActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        int res = fc.showOpenDialog(null);
       
        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();

            try {
                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 160, 160);

                lblImagem.setIcon(new ImageIcon(imagem));
                
            } catch (Exception ex) {
               // System.out.println(ex.printStackTrace().toString());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo.");
        }
    }//GEN-LAST:event_btnSelImgActionPerformed

    private void tblImoveisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblImoveisMouseClicked
        // TODO add your handling code here:
        setar_campo();
        img();
        btnInsert.setEnabled(false);
    }//GEN-LAST:event_tblImoveisMouseClicked

    private void btnAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAlterarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAlterarMouseClicked

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        
            alterar();
            populateJTable();
            verifica();
            limpaCampo();
         
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        
        excluir();
        verifica();
        populateJTable();
        limpaCampo();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarImagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarImagemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarImagemMouseClicked

    private void btnSalvarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarImagemActionPerformed
        // TODO add your handling code here:
        imgAlt();
        btnSalvarImagem.setVisible(false);
    }//GEN-LAST:event_btnSalvarImagemActionPerformed

    private void btnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSairMouseClicked

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
      
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void txtValorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtValorMouseClicked
        // TODO add your handling code here:
       calculo();
    }//GEN-LAST:event_txtValorMouseClicked

    private void txtValorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtValorFocusGained

    private void txtValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorFocusLost
        // TODO add your handling code here:
        calculo();
    }//GEN-LAST:event_txtValorFocusLost

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
            java.util.logging.Logger.getLogger(CadastroImoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroImoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroImoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroImoveis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroImoveis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvarImagem;
    private javax.swing.JButton btnSelImg;
    private javax.swing.JComboBox<String> cbVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JTable tblImoveis;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCidade;
    public javax.swing.JTextField txtDLog;
    public javax.swing.JTextField txtDLog1;
    public javax.swing.JTextField txtDLog2;
    private javax.swing.JComboBox<String> txtEmpreendimento;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtIdImovel;
    public javax.swing.JTextField txtIdProp;
    private javax.swing.JTextField txtOpcao;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtVlVenda;
    // End of variables declaration//GEN-END:variables

    
       
}
