package DAO;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.ClienteModel;
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
public class ClienteDAO {

    PreparedStatement stmt;
    private ResultSet rs;

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    Document doc;

    public void NovoCliente(ClienteModel cli) throws SQLException {
        String SQL = "INSERT INTO cliente (id, nome_razao, cpf_cnpj, rg, endereco, numero, complemento, bairro, cidade, estado, cep, telefone, telefone2, email, vencimento, debito, ativo) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);

        stmt.setInt(1, 0);
        stmt.setString(2, cli.getNomeRazao());
        stmt.setString(3, cli.getCPF_CNPJ());
        stmt.setString(4, cli.getRG());
        stmt.setString(5, cli.getEndereco());
        stmt.setInt(6, cli.getNumero());
        stmt.setString(7, cli.getComplemento());
        stmt.setString(8, cli.getBairro());
        stmt.setString(9, cli.getCidade());
        stmt.setString(10, cli.getEstado());
        stmt.setString(11, cli.getCEP());
        stmt.setString(12, cli.getTelefone());
        stmt.setString(13, cli.getTelefone2());
        stmt.setString(14, cli.getEmail());
        stmt.setString(15, cli.getVencimentoConta());
        stmt.setDouble(16, cli.getDebito());
        stmt.setBoolean(17, true);

        stmt.execute();
        stmt.close();

    }

    public void DesativarCliente(ClienteModel cli) throws SQLException {
        String SQL = "update cliente set ativo = ? where id=?";

        PreparedStatement stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);
        stmt.setBoolean(1, false);
        stmt.setInt(2, cli.getId());

        stmt.execute();
        stmt.close();
    }

    public void AlterarCliente(ClienteModel cli) throws SQLException {
        String SQL = "update cliente set nome_razao=?, cpf_cnpj=?, rg=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?, cep=?, telefone=?, telefone2=?, email=?, vencimento=?, debito=? where id=?";

        PreparedStatement stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);
        stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);

        stmt.setString(1, cli.getNomeRazao());
        stmt.setString(2, cli.getCPF_CNPJ());
        stmt.setString(3, cli.getRG());
        stmt.setString(4, cli.getEndereco());
        stmt.setInt(5, cli.getNumero());
        stmt.setString(6, cli.getComplemento());
        stmt.setString(7, cli.getBairro());
        stmt.setString(8, cli.getCidade());
        stmt.setString(9, cli.getEstado());
        stmt.setString(10, cli.getCEP());
        stmt.setString(11, cli.getTelefone());
        stmt.setString(12, cli.getTelefone2());
        stmt.setString(13, cli.getEmail());
        stmt.setString(14, cli.getVencimentoConta());
        stmt.setDouble(15, cli.getDebito());
        stmt.setInt(16, cli.getId());

        stmt.execute();
        stmt.close();
    }

    public List<ClienteModel> ListaCliente() throws SQLException {

        List<ClienteModel> ListaCliente;
        ListaCliente = new ArrayList<>();

        String SQL = "select* from cliente order by id ASC";
        try {

            PreparedStatement stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);

            while (rs.next()) {
                ListaCliente.add(new ClienteModel(
                        rs.getInt("id"),
                        rs.getString("nome_razao"),
                        rs.getString("cpf_cnpj"),
                        rs.getString("rg"),
                        rs.getString("endereco"),
                        rs.getInt("numero"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("cep"),
                        rs.getString("telefone"),
                        rs.getString("telefone2"),
                        rs.getString("email"),
                        rs.getString("vencimento"),
                        rs.getDouble("debito"),
                        rs.getBoolean("ativo")));

            }
        } catch (Exception e) {
            System.out.println("Problema tal tela cliente:");
            System.out.println(e.getMessage());
        }
        return ListaCliente;
    }

    public List<ClienteModel> ListaBuscaCliente(ClienteModel cli) throws SQLException {
        List<ClienteModel> retorno = new ArrayList<ClienteModel>();

        String SQL = "select * from cliente";

        if (cli.getNomeRazao() != null) {
            SQL += " where nome_razao like ? order by id ASC";
        }

        PreparedStatement stmt = Conexao.getConexaoMySQL().prepareStatement(SQL);

        if (cli.getNomeRazao() != null) {
            stmt.setString(1, "%" + cli.getNomeRazao() + "%");
        }

        try {
            rs = stmt.executeQuery();
            while (rs.next()) {

                retorno.add(new ClienteModel(rs.getInt("id"),
                        rs.getString("nome_razao"),
                        rs.getString("cpf_cnpj"),
                        rs.getString("rg"),
                        rs.getString("endereco"),
                        rs.getInt("numero"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("cep"),
                        rs.getString("telefone"),
                        rs.getString("telefone2"),
                        rs.getString("email"),
                        rs.getString("vencimento"),
                        rs.getDouble("debito"),
                        rs.getBoolean("ativo")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        stmt.close();
        Conexao.getConexaoMySQL().close();

        return retorno;
    }

    public void RelatorioCliente() throws SQLException, DocumentException {

        try {
            List<ClienteModel> ListaCliente = new ArrayList<>();
            ClienteModel cliModel = new ClienteModel();
            ClienteDAO cliDAO = new ClienteDAO();
            ListaCliente = cliDAO.ListaCliente();
            doc = new Document(PageSize.A4, 41.5f, 41.5f, 55.2f, 55.2f);
            PdfWriter.getInstance(doc, new FileOutputStream("C:/Users/Real/Desktop/RelatorioCliente.pdf"));
            doc.open();
            Font f1 = new Font(Font.HELVETICA, 14, Font.BOLD);
            Font f2 = new Font(Font.HELVETICA, 12, Font.BOLD);
            Font f3 = new Font(Font.HELVETICA, 12, Font.NORMAL);
            Font f4 = new Font(Font.HELVETICA, 10, Font.BOLD);
            Font f5 = new Font(Font.HELVETICA, 10, Font.NORMAL);
            Paragraph titulo1 = new Paragraph("Programa de peças", f2);
            titulo1.setAlignment(Element.ALIGN_CENTER);
            titulo1.setSpacingAfter(10);
            Paragraph titulo2 = new Paragraph("Relatório de Clientes", f1);
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
            for (ClienteModel cliente : ListaCliente) {
                Paragraph p1 = new Paragraph(cliente.getNomeRazao(), f5);
                p1.setAlignment(Element.ALIGN_JUSTIFIED);
                PdfPCell col1 = new PdfPCell(p1);
                col1.setBorder(0);
                Paragraph p2 = new Paragraph(cliente.getEndereco(), f5);
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
            String caminho = "C:/Users/Real/Desktop/RelatorioCliente.pdf";
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
