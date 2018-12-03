/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DAO.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Natan Oliveira
 */
public class FornecedorDAO {
    PreparedStatement pst;
    String sql;
    private ResultSet rs;

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
    public void Salvar(FornecedorModel fornecedor) throws SQLException {
        int id = 0;
        sql = "INSERT INTO fornecedor VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        pst = Conexao.getConexaoMySQL().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setInt (1, id);
        pst.setString (2, fornecedor.getNomeRazao());
        pst.setString (3, fornecedor.getCnpj());
        pst.setString (4, fornecedor.getEndereco());
        pst.setString (5, fornecedor.getComplemento());
        pst.setInt (6, fornecedor.getNumero());
        pst.setString (7, fornecedor.getCidade());
        pst.setString (8, fornecedor.getCep());
        pst.setString (9, fornecedor.getTelefone());
        pst.setString (10, fornecedor.getTelefone2());
        pst.setString (11, fornecedor.getEmail());
        pst.setBoolean (12, fornecedor.isAtivo());
        pst.execute ();
        pst.close ();
    }
    
    public FornecedorModel getUserByID (int id) throws SQLException {
        FornecedorModel mFornecedor = null;
        sql = "SELECT * FROM fornecedor WHERE codigo = ?";
        Statement st;
        pst = Conexao.getConexaoMySQL().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setInt(1, id);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while(rs.next()) 
            mFornecedor = new FornecedorModel(rs.getInt("id"), rs.getString("nome_razao"), rs.getString("cpf_cnpj"), rs.getString("endereco"), 
                    rs.getString("complemento"), rs.getInt("numero"), rs.getString("cidade"), rs.getString("cep"), rs.getString("telefone"), rs.getString("telefone2"), 
                    rs.getString("email"), rs.getBoolean("ativo"));
        pst.close();
        return mFornecedor;
    }
}
