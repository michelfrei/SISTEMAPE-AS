/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.FuncionarioModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Real
 */
public class AutenticacaoDAO {
    
    PreparedStatement pst;
    String sql;
    
    public FuncionarioModel AutenticacaoDAO(String login, String senha)throws SQLException{
        sql = "Select * from funcionario where login COLLATE utf8_bin = ? and senha COLLATE utf8_bin = ?";
        
        FuncionarioModel funcionarioM = null;
        
        pst = Conexao.getConexaoMySQL().prepareStatement(sql);
        
        pst.setString(1, login);
        pst.setString(2, senha);
        pst.executeQuery();
        
        ResultSet rs = pst.getResultSet();
        
        while(rs.next()){
            funcionarioM = new FuncionarioModel(
                        rs.getInt("id"),
                        rs.getInt("id_tipo_usuario"),
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getInt("numero"),
                        rs.getString("bairro"),
                        rs.getString("cpf"),
                        rs.getString("rg"),
                        rs.getString("telefone"),
                        rs.getString("telefone2"),
                        rs.getString("email"),
                        rs.getString("usuario"),
                        rs.getString("senha"),
                        rs.getString("ativo"));
        }
        return funcionarioM;
    }
}
