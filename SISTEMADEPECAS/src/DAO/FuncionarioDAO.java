/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ClienteModel;
import Model.FuncionarioModel;
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
public class FuncionarioDAO {

    PreparedStatement pst;
    String sql;
    private ResultSet rs;

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public void SalvarFuncionario(FuncionarioModel func) throws SQLException {

        sql = "INSERT INTO FUNCIONARIO VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        pst = Conexao.getConexaoMySQL().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setInt(2, func.getIdTipoUsuario());
        pst.setString(3, func.getNome());
        pst.setString(4, func.getEndereco());
        pst.setInt(5, func.getNumero());
        pst.setString(6, func.getBairro());
        pst.setString(7, func.getCpf());
        pst.setString(8, func.getRg());
        pst.setString(9, func.getTelefone());
        pst.setString(10, func.getCelular());
        pst.setString(11, func.getEmail());
        pst.setString(12, func.getUsuario());
        pst.setString(13, func.getSenha());
        pst.setBoolean(14, true);
        pst.execute();
        pst.close();
    }

    public void AlterarFuncionario(FuncionarioModel funcionario) throws SQLException {
        sql = "UPDATE funcionario SET id_tipo_usuario = ?, nome = ?, endereco = ?, numero = ?, bairro=?, cpf = ?, rg = ?, telefone = ?, telefone2 = ?, email = ?, usuario = ?, senha = ? WHERE id = ? ";
        pst = Conexao.getConexaoMySQL().prepareStatement(sql);
        pst.setInt(1, funcionario.getIdTipoUsuario());
        pst.setString(2, funcionario.getNome());
        pst.setString(3, funcionario.getEndereco());
        pst.setInt(4, funcionario.getNumero());
        pst.setString(5, funcionario.getBairro());
        pst.setString(6, funcionario.getCpf());
        pst.setString(7, funcionario.getRg());
        pst.setString(8, funcionario.getTelefone());
        pst.setString(9, funcionario.getCelular());
        pst.setString(10, funcionario.getEmail());
        pst.setString(11, funcionario.getUsuario());
        pst.setString(12, funcionario.getSenha());
        pst.setInt(13, funcionario.getId());
        pst.execute();
        pst.close();
    }

    public List<FuncionarioModel> ListaFuncionario() throws SQLException {

        List<FuncionarioModel> ListaFuncionario;
        ListaFuncionario = new ArrayList<>();

        String SQL = "select* from funcionario order by id ASC";
        try {

            PreparedStatement stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ListaFuncionario.add(new FuncionarioModel(
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
                        rs.getString("ativo")));
            }
        } catch (Exception e) {
            System.out.println("Problema tal tela funcionario:");
            System.out.println(e.getMessage());
        }
        return ListaFuncionario;
    }

    public List<FuncionarioModel> ListaBuscaFuncionario(FuncionarioModel func) throws SQLException {
        List<FuncionarioModel> retorno = new ArrayList<FuncionarioModel>();

        String SQL = "select * from funcionario ";

        if (func.getNome() != null) {
            SQL += " where nome like ? order by id ASC";
        }

        PreparedStatement stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);

        if (func.getNome() != null) {
            stmt.setString(1, "%" + func.getNome() + "%");
        }

        try {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                retorno.add(new FuncionarioModel(rs.getInt("id"),
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
                        rs.getString("ativo")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        stmt.close();
        Conexao.getConexaoMySQL().close();

        return retorno;
    }

    /*public FuncionarioModel getUserByID (int id) throws SQLException {
        FuncionarioModel mFuncionario = null;
        sql = "SELECT * FROM funcionario WHERE id = ?";
        Statement st;
        pst = Conexao.getConexaoMySQL().prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while(rs.next()) 
            mFuncionario = new FuncionarioModel(rs.getInt("id"), rs.getInt("id_tipo_usuario"), rs.getString("nome"), rs.getString("endereco"), rs.getInt("numero"), rs.getString("bairro"),
                    rs.getString("cpf"), rs.getString("rg"), rs.getString("telefone"), rs.getString("telefone2"), rs.getString("email"), rs.getString("usuario"), 
                    rs.getString("senha"), rs.getString("ativo"));
        pst.close();
        return mFuncionario;
    }
    
    public List getUserByName () throws SQLException {
        List <FuncionarioModel> listFuncionario = new ArrayList<>();
        sql = "SELECT * FROM funcionario WHERE ORDER BY id";
        Statement st;
        pst = Conexao.getConexaoMySQL().prepareStatement(sql);
        //pst.setString(1, '%' + name + '%');
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while(rs.next()) 
            listFuncionario.add(new FuncionarioModel(rs.getInt("id"), rs.getInt("id_tipo_usuario"), rs.getString("nome"), rs.getString("endereco"), rs.getInt("numero"), rs.getString("bairro"),
                    rs.getString("cpf"), rs.getString("rg"), rs.getString("telefone"), rs.getString("telefone2"), rs.getString("email"), rs.getString("usuario"), 
                    rs.getString("senha"), rs.getString("ativo")));
        pst.close();
        return listFuncionario;
    }
    
    public FuncionarioModel login (String usuario) throws SQLException {
        FuncionarioModel mFuncionario = null;
        sql = "SELECT * FROM funcionario WHERE usuario = ?";
        Statement st;
        pst = Conexao.getConexaoMySQL().prepareStatement(sql);
        pst.setString(1, usuario);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        while (rs.next())
            mFuncionario = new FuncionarioModel(rs.getInt("id"), rs.getInt("id_tipo_usuario"), rs.getString("nome"), rs.getString("endereco"), rs.getInt("numero"), rs.getString("bairro"),
                    rs.getString("cpf"), rs.getString("rg"), rs.getString("telefone"), rs.getString("telefone2"), rs.getString("email"), rs.getString("usuario"), 
                    rs.getString("senha"), rs.getString("ativo"));
        pst.close();
        return mFuncionario;
    }
    
    public boolean usuarioCadastrado (String usuario) throws SQLException {
        FuncionarioModel mFuncionario = null;
        String user = "";
        sql = "SELECT usuario FROM funcionario WHERE usuario = ?";
        pst = Conexao.getConexaoMySQL().prepareStatement(sql);
        pst.setString(1, usuario);
        pst.executeQuery();
        ResultSet rs = pst.getResultSet();
        if (rs.next())
            user = rs.getString("usuario");
        pst.close();
        return user.trim().isEmpty();
    }
    
    public void desativarAtivar (String ativo, int id) throws SQLException {
        sql = "UPDATE funcionario SET ativo = ? WHERE id = ?";
        pst = Conexao.getConexaoMySQL().prepareStatement(sql);
        pst.setString(1, ativo);
        pst.setInt (2, id);
        pst.execute();
        pst.close();
    }*/
}
