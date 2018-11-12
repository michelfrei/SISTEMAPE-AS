/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ClienteModel;
import Model.FuncionarioModel;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Natan Oliveira
 */
public class FuncionarioDAO {
    
    Document doc;
    
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
    
    public void DesativaFuncionario(FuncionarioModel func) throws SQLException {
        String SQL = "update funcionario set ativo = ? where id=?";

        PreparedStatement stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);
        stmt.setBoolean(1, false);
        stmt.setInt(2, func.getId());

        stmt.execute();
        stmt.close();
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
    
    public void RelatorioFuncionario() throws SQLException, DocumentException {
        try {
            List<FuncionarioModel> ListaFuncionario = new ArrayList<>();
            FuncionarioModel funcModel = new FuncionarioModel();
            FuncionarioDAO funcDAO = new FuncionarioDAO();
            ListaFuncionario = funcDAO.ListaFuncionario();
            doc = new Document(PageSize.A4, 41.5f, 41.5f, 55.2f, 55.2f);
            PdfWriter.getInstance(doc, new FileOutputStream("C:/Users/Real/Desktop/RelatorioFuncionario.pdf"));
            doc.open();
            Font f1 = new Font(Font.HELVETICA, 14, Font.BOLD);
            Font f2 = new Font(Font.HELVETICA, 12, Font.BOLD);
            Font f3 = new Font(Font.HELVETICA, 12, Font.NORMAL);
            Font f4 = new Font(Font.HELVETICA, 10, Font.BOLD);
            Font f5 = new Font(Font.HELVETICA, 10, Font.NORMAL);
            Paragraph titulo1 = new Paragraph("Programa de peças", f2);
            titulo1.setAlignment(Element.ALIGN_CENTER);
            titulo1.setSpacingAfter(10);
            Paragraph titulo2 = new Paragraph("Relatório de Funcionario", f1);
            titulo2.setAlignment(Element.ALIGN_CENTER);
            titulo2.setSpacingAfter(0);
            PdfPTable tabela = new PdfPTable(new float[]{0.40f, 0.60f});
            tabela.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela.setWidthPercentage(100f);
            PdfPCell cabecalho1 = new PdfPCell(new Paragraph("Nome", f3));
//cabecalho1.setBackgroundColor(new Color(0xc0, 0xc0, 0xc0));
            cabecalho1.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cabecalho1.setBorder(0);
            PdfPCell cabecalho2 = new PdfPCell(new Paragraph("Endereço", f3));
//cabecalho2.setBackgroundColor(new Color(0xc0, 0xc0, 0xc0));
            cabecalho2.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
            cabecalho2.setBorder(0);
            tabela.addCell(cabecalho1);
            tabela.addCell(cabecalho2);
            for (FuncionarioModel funcionario : ListaFuncionario) {
                Paragraph p1 = new Paragraph(funcionario.getNome(), f5);
                p1.setAlignment(Element.ALIGN_JUSTIFIED);
                PdfPCell col1 = new PdfPCell(p1);
                col1.setBorder(0);
                Paragraph p2 = new Paragraph(funcionario.getEndereco(), f5);
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
            String caminho = "C:/Users/Real/Desktop/RelatorioFuncionario.pdf";
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
