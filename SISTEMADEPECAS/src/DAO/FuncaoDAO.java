/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Funcao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Real
 */
public class FuncaoDAO {
        public void InserirFuncao(Funcao funcao) throws SQLException {

        String SQL = "INSERT INTO sys.funcao (id, Nome) values (?, ?)";

        PreparedStatement stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);

        stmt.setInt(1, funcao.getId());
        stmt.setString(2, funcao.getNome());

        stmt.execute();
        stmt.close();
    }

    public void RemoverFuncao(Funcao funcao) throws SQLException {
        String SQL = "Delete from sys.funcao where id=?";

        PreparedStatement stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);
        stmt.setInt(1, funcao.getId());

        stmt.execute();
        stmt.close();
    }

    public void AlterarFuncao(Funcao funcao) throws SQLException {
        String SQL = "update sys.funcao set Nome=? where id = ?";

        PreparedStatement stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);
        stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);

        stmt.setString(1, funcao.getNome());
        stmt.setInt(2, funcao.getId());
        stmt.execute();
        stmt.close();
    }

    public List<Funcao> ListaFuncao() throws SQLException {

        List<Funcao> ListaFuncao;
        ListaFuncao = new ArrayList<>();

        String SQL = "select* from sys.funcao";
        try {

            PreparedStatement stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ListaFuncao.add(new Funcao(rs.getInt("id"),
                        rs.getString("Nome")));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ListaFuncao;
    }

    public List<Funcao> ListaBuscaFuncao(Funcao funcao) throws SQLException {
        List<Funcao> retorno = new ArrayList<Funcao>();

        String SQL = "select * from sys.funcao";
        
        if(funcao.getNome()!= null){
            SQL += " where Nome like ?";
        }
        
        
        PreparedStatement stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);
        
        if(funcao.getNome()!= null){
        stmt.setString(1, "%" + funcao.getNome() + "%");
        }
        try {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                retorno.add(new Funcao(rs.getInt("id"),
                        rs.getString("Nome")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        stmt.close();
        Conexao.getConexaoMySQL().close();

        return retorno;
    }  
}
