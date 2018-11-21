/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Natan Oliveira
 */
public class EntradaModel {
    private int id;
    private int idFornecedor;
    private int idProduto;
    private int idFuncionario;
    private int quantidade;
    private double valor;
    private String dataEntrada;
    private double margem;
    private double margemPrazo;

    public EntradaModel() {
    }

    public EntradaModel(int id, int idFornecedor, int idProduto, int idFuncionario, int quantidade, double valor, String dataEntrada, double margem, double margemPrazo) {
        this.id = id;
        this.idFornecedor = idFornecedor;
        this.idProduto = idProduto;
        this.idFuncionario = idFuncionario;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataEntrada = dataEntrada;
        this.margem = margem;
        this.margemPrazo = margemPrazo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public double getMargem() {
        return margem;
    }

    public void setMargem(double margem) {
        this.margem = margem;
    }

    public double getMargemPrazo() {
        return margemPrazo;
    }

    public void setMargemPrazo(double margemPrazo) {
        this.margemPrazo = margemPrazo;
    }
    
}
