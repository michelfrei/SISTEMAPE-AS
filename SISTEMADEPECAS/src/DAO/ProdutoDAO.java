package DAO;

import Model.ClienteModel;
import Model.FuncionarioModel;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.ProdutoModel;
import View.*;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Michel
 */
public class ProdutoDAO {

    Document doc;
    PreparedStatement stmt;
    private ResultSet rs;
    private int i = 0;
    ProdutoModel mProduto;

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
    

    public void InserirNovoProduto(ProdutoModel prod) throws SQLException {
        String SQL = "INSERT INTO produto (id, tipo, descricao, detalhes, marca, origem, codigo_de_barras, fabricante, setor, unidade_medida, peso, medidas, foto, estoque, ativo, valor) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        stmt = Conexao.getConexaoMySQL().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

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
        stmt.setDouble(16, prod.getValor());

        stmt.execute();
        stmt.close();
    }

    public void DesativarProduto(ProdutoModel prod) throws SQLException {
        String SQL = "update produto set ativo = ? where id=?";

        stmt = Conexao.getConexaoMySQL().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
        stmt.setBoolean(1, false);
        stmt.setInt(2, prod.getId());

        stmt.execute();
        stmt.close();
    }

    public void AlterarProduto(ProdutoModel prod) throws SQLException {// não ta funcionando
        String SQL = SQL = "update produto set tipo=?, descricao=?, detalhes=?, marca=?, origem=?, codigo_de_barras=?, fabricante=?, setor=?, unidade_medida=?, peso=?, medidas=?, foto=?, estoque=? where id =?";

        stmt = Conexao.getConexaoMySQL().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
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
    }

    public List<ProdutoModel> ListaProduto() throws SQLException {

        List<ProdutoModel> ListaProduto;
        ListaProduto = new ArrayList<>();

        String SQL = "select* from produto order by id ASC";
        try {

            stmt = Conexao.getConexaoMySQL().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
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
                        rs.getBoolean("ativo"),
                        rs.getDouble("valor")
                ));

            }
        } catch (Exception e) {
            System.out.println("Problema tal tela produto:");
            System.out.println(e.getMessage());
        }
        stmt.close();
        return ListaProduto;
    }

    public List<ProdutoModel> ListaBuscaProduto(ProdutoModel prod) throws SQLException {
        List<ProdutoModel> retorno = new ArrayList<ProdutoModel>();

        String SQL = "select * from produto ";

        if (prod.getDescricao() != null) {
            SQL += " where descricao like ? order by id ASC";
        }

        stmt = Conexao.getConexaoMySQL().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

        if (prod.getDescricao() != null) {
            stmt.setString(1, "%" + prod.getDescricao() + "%");
        }

        try {
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
                        rs.getBoolean("ativo"),
                        rs.getDouble("valor")
                ));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        stmt.close();
        Conexao.getConexaoMySQL().close();

        return retorno;
    }
    
    public ProdutoModel ListaBuscaProdutoID(int id) throws SQLException {
        ProdutoModel retorno = new ProdutoModel();

        String SQL = "select * from produto where id = ?";

        stmt = Conexao.getConexaoMySQL().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id);

        try {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                retorno = (new ProdutoModel(
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
                        rs.getBoolean("ativo"),
                        rs.getDouble("valor")
                ));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        stmt.close();
        Conexao.getConexaoMySQL().close();

        return retorno;
    }
    
    public void baixaEstoque (int id, int estoque) throws SQLException {
        String SQL = "update produto set estoque = ? where id = ?";
        if (Conexao.getConexaoMySQL() == null)
        stmt = Conexao.getConexaoMySQL().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, estoque);
        stmt.setInt(2, id);
        stmt.execute();
        stmt.close();
    }

    public void RelatorioProduto() throws SQLException, DocumentException {
        try {
            List<ProdutoModel> ListaProduto = new ArrayList<>();
            ProdutoModel prodModel = new ProdutoModel();
            ProdutoDAO prodDAO = new ProdutoDAO();
            ListaProduto = prodDAO.ListaProduto();
            doc = new Document(PageSize.A4, 41.5f, 41.5f, 55.2f, 55.2f);
            PdfWriter.getInstance(doc, new FileOutputStream("C:/Users/Real/Desktop/RelatorioProduto.pdf"));
            doc.open();
            Font f1 = new Font(Font.HELVETICA, 14, Font.BOLD);
            Font f2 = new Font(Font.HELVETICA, 12, Font.BOLD);
            Font f3 = new Font(Font.HELVETICA, 12, Font.NORMAL);
            Font f4 = new Font(Font.HELVETICA, 10, Font.BOLD);
            Font f5 = new Font(Font.HELVETICA, 10, Font.NORMAL);
            Paragraph titulo1 = new Paragraph("Programa de peças", f2);
            titulo1.setAlignment(Element.ALIGN_CENTER);
            titulo1.setSpacingAfter(10);
            Paragraph titulo2 = new Paragraph("Relatório de Produto", f1);
            titulo2.setAlignment(Element.ALIGN_CENTER);
            titulo2.setSpacingAfter(0);
            PdfPTable tabela = new PdfPTable(new float[]{0.40f, 0.60f});
            tabela.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.setWidthPercentage(100f);
            PdfPCell cabecalho1 = new PdfPCell(new Paragraph("Descrição", f3));
//cabecalho1.setBackgroundColor(new Color(0xc0, 0xc0, 0xc0));
            cabecalho1.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cabecalho1.setBorder(0);
            PdfPCell cabecalho2 = new PdfPCell(new Paragraph("Detalhes", f3));
//cabecalho2.setBackgroundColor(new Color(0xc0, 0xc0, 0xc0));
            cabecalho2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cabecalho2.setBorder(0);
            tabela.addCell(cabecalho1);
            tabela.addCell(cabecalho2);
            for (ProdutoModel produto : ListaProduto) {
                Paragraph p1 = new Paragraph(produto.getDescricao(), f5);
                p1.setAlignment(Element.ALIGN_JUSTIFIED);
                PdfPCell col1 = new PdfPCell(p1);
                col1.setBorder(0);
                Paragraph p2 = new Paragraph(produto.getDetalhes(), f5);
                p2.setAlignment(Element.ALIGN_JUSTIFIED);
                PdfPCell col2 = new PdfPCell(p2);
                col2.setBorder(0);
                tabela.addCell(col1);
                tabela.addCell(col2);
            }
            doc.add(titulo2);
            doc.add(titulo1);
            doc.add(tabela);
            doc.close();
            JOptionPane.showMessageDialog(null, "Relatório salvo com sucesso");
            String caminho = "C:/Users/Real/Desktop/RelatorioProduto.pdf";
            Desktop.getDesktop().open(new File(caminho));
        } /*catch (DocumentException e) {
            e.printStackTrace();
        }*/ catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException exx) {
            exx.printStackTrace();
            JOptionPane.showMessageDialog(null, "Documento de Requisitos aberto. Feche para gerar um novo.");
        }
    }
}
