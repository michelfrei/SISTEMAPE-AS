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
public class VendaModel {
    private int id;
    private int idFuncionario;
    private int idCliente;
    private String data;
    private double valorTotal;
    private int tipoPagamento;
    private int numeroParcelas;
    private boolean vendaSemCliente;

    public VendaModel() {
    }

    public VendaModel(int id, int idFuncionario, int idCliente, String data, double valorTotal, int tipoPagamento, int numeroParcelas, boolean vendaSemCliente) {
        this.id = id;
        this.idFuncionario = idFuncionario;
        this.idCliente = idCliente;
        this.data = data;
        this.valorTotal = valorTotal;
        this.tipoPagamento = tipoPagamento;
        this.numeroParcelas = numeroParcelas;
        this.vendaSemCliente = vendaSemCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(int tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public boolean isVendaSemCliente() {
        return vendaSemCliente;
    }

    public void setVendaSemCliente(boolean vendaSemCliente) {
        this.vendaSemCliente = vendaSemCliente;
    }
    
}
