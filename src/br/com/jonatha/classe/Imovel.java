/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.jonatha.classe;

import javax.swing.Icon;

/**
 *
 * @author Jonatha
 */
public class Imovel {
  private int idimoveis;
  private String endereco;
  private String bairro;
  private String cidade;
  private String estado;
  private double area;
  private String valor;
  private String empreendimento;
  private String opcionais;
  private String datapublicacao;
  private String datavalidade;
  private String venda;
  private byte[] imagem;
  private int idproprietario;
  private String email;

    public Imovel( byte[] imagem, int idimoveis, String endereco, String bairro, String cidade, String estado, double area, String valor, String empreendimento, String opcionais, String datapublicacao, String datavalidade, String venda, int idproprietario, String email) {
        this.imagem = imagem;
        this.idimoveis = idimoveis;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.area = area;
        this.valor = valor;
        this.empreendimento = empreendimento;
        this.opcionais = opcionais;
        this.datapublicacao = datapublicacao;
        this.datavalidade = datavalidade;
        this.venda = venda;
        this.idproprietario = idproprietario;
        this.email = email;
        
    }

    public Imovel(String endereco, String bairro, String cidade, String estado, double area, String valor, String empreendimento, String opcionais, String datapublicacao, String datavalidade, String venda, int idproprietario) {
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.area = area;
        this.valor = valor;
        this.empreendimento = empreendimento;
        this.opcionais = opcionais;
        this.datapublicacao = datapublicacao;
        this.datavalidade = datavalidade;
        this.venda = venda;
        this.imagem = imagem ;
        this.idproprietario = idproprietario;    
    }

  
 public Imovel( byte[] imagem, int idimoveis, String endereco, String bairro, String cidade, String estado, double area, String valor, String empreendimento, String opcionais, String venda) {
        this.imagem = imagem;
        this.idimoveis = idimoveis;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.area = area;
        this.valor = valor;
        this.empreendimento = empreendimento;
        this.opcionais = opcionais;
        this.venda = venda;
    }

   

    
  
  
    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public int getIdimoveis() {
        return idimoveis;
    }

    public void setIdimoveis(int idimoveis) {
        this.idimoveis = idimoveis;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getEmpreendimento() {
        return empreendimento;
    }

    public void setEmpreendimento(String empreendimento) {
        this.empreendimento = empreendimento;
    }

    public String getOpcionais() {
        return opcionais;
    }

    public void setOpcionais(String opcionais) {
        this.opcionais = opcionais;
    }

    public String getDatapublicacao() {
        return datapublicacao;
    }

    public void setDatapublicacao(String datapublicacao) {
        this.datapublicacao = datapublicacao;
    }

    public String getDatavalidade() {
        return datavalidade;
    }

    public void setDatavalidade(String datavalidade) {
        this.datavalidade = datavalidade;
    }

    public String getVenda() {
        return venda;
    }

    public void setVenda(String venda) {
        this.venda = venda;
    }

    public int getIdproprietario() {
        return idproprietario;
    }

    public void setIdproprietario(int idproprietario) {
        this.idproprietario = idproprietario;
    }

    public byte[] getMyImage() {
       return imagem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
  
  
}
