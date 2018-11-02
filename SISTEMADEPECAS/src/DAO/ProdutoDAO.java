package DAO;

import Model.ClienteModel;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.ProdutoModel;
import View.*;

/**
 *
 * @author Michel
 */
public class ProdutoDAO {

    public void InserirNovoProduto(ProdutoModel prod) {
        String SQL = "INSERT INTO produto (id, tipo, descricao, detalhes, marca, origem, codigo_de_barras, fabricante, setor, unidade_medida, peso, medidas, foto, estoque, ativo) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);

            stmt.setInt(1, 0);
            stmt.setString(2, prod.getTipo());
            stmt.setString(3, prod.getDescricao());
            stmt.setString(4, prod.getDetalhes());
            stmt.setString(5, prod.getMarca());
            stmt.setString(6, prod.getOrigem());
            stmt.setString(7, prod.getCodigoDeBarras());
            stmt.setString(8, prod.getFabricante());
            stmt.setString(9, prod.getSetor());
            stmt.setString(10, prod.getUnitMedida());
            stmt.setDouble(11, prod.getPeso());
            stmt.setString(12, prod.getMedidas());
            stmt.setString(13, prod.getFoto());
            stmt.setInt(14, prod.getEstoque());
            stmt.setBoolean(15, true);

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }

    public boolean DesativarProduto(ProdutoModel prod) throws SQLException {
        String SQL = "update produto set ativo = ? where id=?";

        try {
            PreparedStatement stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);
            stmt.setBoolean(1, false);
            stmt.setInt(2, prod.getId());

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    public boolean AlterarProduto(ProdutoModel prod) throws SQLException {// não ta funcionando
        String SQL = SQL = "update produto set tipo=?, descricao=?, detalhes=?, marca=?, origem=?, codigo_de_barras=?, fabricante=?, setor=?, unidade_medida=?, peso=?, medidas=?, foto=?, estoque=? where id =?";

        try {
            PreparedStatement stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);
            stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);

            stmt.setString(1, prod.getTipo());
            stmt.setString(2, prod.getDescricao());
            stmt.setString(3, prod.getDetalhes());
            stmt.setString(4, prod.getMarca());
            stmt.setString(5, prod.getOrigem());
            stmt.setString(6, prod.getCodigoDeBarras());
            stmt.setString(7, prod.getFabricante());
            stmt.setString(8, prod.getSetor());
            stmt.setString(9, prod.getUnitMedida());
            stmt.setDouble(10, prod.getPeso());
            stmt.setString(11, prod.getMedidas());
            stmt.setString(12, prod.getFoto());
            stmt.setInt(13, prod.getEstoque());
            stmt.setInt(14, prod.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return true;
    }
    
    public List<ProdutoModel> ListaProduto() throws SQLException {

        List<ProdutoModel> ListaProduto;
        ListaProduto = new ArrayList<>();

        String SQL = "select* from produto order by id ASC";
        try {

            PreparedStatement stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ListaProduto.add(new ProdutoModel(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getString("descricao"),
                        rs.getString("detalhes"),
                        rs.getString("marca"),
                        rs.getString("origem"),
                        rs.getString("codigo_de_barras"),
                        rs.getString("fabricante"),
                        rs.getString("setor"),
                        rs.getString("unidade_medida"),
                        rs.getDouble("peso"),
                        rs.getString("medidas"),
                        rs.getString("foto"),
                        rs.getInt("estoque"),
                        rs.getBoolean("ativo")));

            }
        } catch (Exception e) {
            System.out.println("Problema tal tela produto:");
            System.out.println(e.getMessage());
        }
        return ListaProduto;
    }
    
        public List<ProdutoModel> ListaBuscaProduto(ProdutoModel prod) throws SQLException {
        List<ProdutoModel> retorno = new ArrayList<ProdutoModel>();
        
        String SQL = "select * from produto ";

        if (prod.getDescricao()!= null) {
            SQL += " where descricao like ? order by id ASC";
        } 
        
        PreparedStatement stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);
        
        if (prod.getDescricao()!= null) {
            stmt.setString(1, "%" + prod.getDescricao() + "%");
        }
        
        try{
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {

            retorno.add(new ProdutoModel(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getString("descricao"),
                        rs.getString("detalhes"),
                        rs.getString("marca"),
                        rs.getString("origem"),
                        rs.getString("codigo_de_barras"),
                        rs.getString("fabricante"),
                        rs.getString("setor"),
                        rs.getString("unidade_medida"),
                        rs.getDouble("peso"),
                        rs.getString("medidas"),
                        rs.getString("foto"),
                        rs.getInt("estoque"),
                        rs.getBoolean("ativo")));
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        stmt.close();
        Conexao.getConexaoMySQL().close();

        return retorno;
    }
}
