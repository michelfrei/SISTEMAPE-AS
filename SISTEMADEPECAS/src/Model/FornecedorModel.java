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
public class FornecedorModel {
    private int id;
    private String nomeRazao;
    private String cnpj;
    private String endereco;
    private String complemento;
    private int numero;
    private String cidade;
    private String cep;
    private String telefone;
    private String telefone2;
    private String email;
    private boolean ativo;

    public FornecedorModel() {
    }

    public FornecedorModel(int id, String nomeRazao, String cnpj, String endereco, String complemento, int numero, String cidade, String cep, String telefone, String telefone2, String email, boolean ativo) {
        this.id = id;
        this.nomeRazao = nomeRazao;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.complemento = complemento;
        this.numero = numero;
        this.cidade = cidade;
        this.cep = cep;
        this.telefone = telefone;
        this.telefone2 = telefone2;
        this.email = email;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeRazao() {
        return nomeRazao;
    }

    public void setNomeRazao(String nomeRazao) {
        this.nomeRazao = nomeRazao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
}
