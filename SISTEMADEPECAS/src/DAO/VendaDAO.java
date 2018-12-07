/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ItensVendaModel;
import Model.VendaModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Natan Oliveira
 */
public class VendaDAO {
    PreparedStatement pst;
    String sql;
    private ResultSet rs;
    private int i = 0;

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
    public void Salvar(VendaModel venda) throws SQLException {
        int id = 0;
        ResultSet inserido;
        sql = "INSERT INTO venda VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        if (Conexao.getConexaoMySQL() == null)
        pst = Conexao.getConexaoMySQL().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setInt (1, id);
        pst.setInt (2, venda.getIdFuncionario());
        pst.setInt (3, venda.getIdCliente());
        pst.setString(4, venda.getData());
        pst.setDouble (5, venda.getValorTotal());
        pst.setInt (6, venda.getTipoPagamento());
        pst.setInt (7, venda.getNumeroParcelas());
        pst.setBoolean (8, venda.isVendaSemCliente());
        pst.execute ();
        inserido = pst.getGeneratedKeys();
        if (inserido.next()) {
            i = inserido.getInt(1);
        }
        pst.close ();
        System.out.println(i);
    }
    
    public void SalvarItens(ItensVendaModel itens) throws SQLException {
        int id = 0;
        sql = "INSERT INTO ites_venda VALUES (?, ?, ?, ?)";
        pst = Conexao.getConexaoMySQL().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setInt (1, id);
        pst.setInt (2, itens.getIdProduto());
        pst.setDouble (3, itens.getValorProduto());
        pst.setInt (4, itens.getQuantidadeProduto());
        pst.execute ();
        pst.close ();
    }
}
