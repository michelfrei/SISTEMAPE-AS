/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.*;
import Model.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Real
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    List<ClienteModel> ListaCliente;
    List<ClienteModel> ListaBuscaCliente;

    List<FuncionarioModel> ListaFuncionario;
    List<FuncionarioModel> ListaBuscaFuncionario;

    List<ProdutoModel> ListaProduto;
    List<ProdutoModel> ListaBuscaProduto;

    public Menu() {
        initComponents();
        ClienteView.setVisible(false);
        FuncionarioView.setVisible(false);
        ProdutoView.setVisible(false);
        //CampoAtivosCliente.getModel().setSelectedItem(null);
        TravaCamposCliente();
        TravaCamposFunc();
        TravaCamposProd();
        //TravaTudoProd();

        atualizarTabelaCliente();
        atualizarTabelaFuncionario();
        atualizarTabelaProduto();
    }

    public void TravaCamposCliente() {
        CampoNomeCliente.setEnabled(false);
        //CampoAtivosCliente.setEnabled(false);
        CampoCPFCliente.setEnabled(false);
        CampoCelularCliente.setEnabled(false);
        CampoCepCliente.setEnabled(false);
        CampoCidadeCliente.setEnabled(false);
        CampoComplementoCliente.setEnabled(false);
        CampoContasCliente.setEnabled(false);
        CampoDebitoCliente.setEnabled(false);
        CampoEmailCliente.setEnabled(false);
        CampoEnderecoCliente.setEnabled(false);
        CampoEstadoCliente.setEnabled(false);
        CampoNumeroCasaCliente.setEnabled(false);
        CampoRGCliente.setEnabled(false);
        CampoTelefoneCliente.setEnabled(false);
        CampoBairroCliente.setEnabled(false);
    }

    public void DestravaCamposCliente() {
        CampoNomeCliente.setEnabled(true);
        //CampoAtivosCliente.setEnabled(true);
        CampoCPFCliente.setEnabled(true);
        CampoCelularCliente.setEnabled(true);
        CampoCepCliente.setEnabled(true);
        CampoCidadeCliente.setEnabled(true);
        CampoComplementoCliente.setEnabled(true);
        CampoContasCliente.setEnabled(true);
        CampoDebitoCliente.setEnabled(true);
        CampoEmailCliente.setEnabled(true);
        CampoEnderecoCliente.setEnabled(true);
        CampoEstadoCliente.setEnabled(true);
        CampoNumeroCasaCliente.setEnabled(true);
        CampoRGCliente.setEnabled(true);
        CampoTelefoneCliente.setEnabled(true);
        CampoBairroCliente.setEnabled(true);
    }

    public void LimpaCamposCliente() {
        CampoNomeCliente.setText("");
        CampoIdCliente.setText("");
        //CampoAtivosCliente.getModel().setSelectedItem(null);
        CampoCPFCliente.setText("");
        CampoCelularCliente.setText("");
        CampoCepCliente.setText("");
        CampoCidadeCliente.setText("");
        CampoComplementoCliente.setText("");
        CampoContasCliente.setText("");
        CampoDebitoCliente.setText("");
        CampoEmailCliente.setText("");
        CampoEnderecoCliente.setText("");
        CampoEstadoCliente.setText("");
        CampoNumeroCasaCliente.setText("");
        CampoRGCliente.setText("");
        CampoTelefoneCliente.setText("");
        CampoBairroCliente.setText("");
    }

    public void TravaCamposFunc() {
        CampoNomeFunc.setEnabled(false);
        CampoCPFFunc.setEnabled(false);
        CampoCelularFunc.setEnabled(false);
        CampoEmailFunc.setEnabled(false);
        CampoEnderecoFunc.setEnabled(false);
        CampoNumeroCasaFunc.setEnabled(false);
        CampoRGFunc.setEnabled(false);
        CampoTelefoneFunc.setEnabled(false);
        CampoTipoFunc.setEnabled(false);
        CampoNomeUsuarioFunc.setEnabled(false);
        CampoSenhaFunc.setEnabled(false);
        CampoBairroFunc.setEnabled(false);

    }

    public void DestravaCamposFunc() {
        CampoNomeFunc.setEnabled(true);
        CampoCPFFunc.setEnabled(true);
        CampoCelularFunc.setEnabled(true);
        CampoEmailFunc.setEnabled(true);
        CampoEnderecoFunc.setEnabled(true);
        CampoNumeroCasaFunc.setEnabled(true);
        CampoRGFunc.setEnabled(true);
        CampoTelefoneFunc.setEnabled(true);
        CampoTipoFunc.setEnabled(true);
        CampoNomeUsuarioFunc.setEnabled(true);
        CampoSenhaFunc.setEnabled(true);
        CampoBairroFunc.setEnabled(true);
    }

    public void LimpaCamposFunc() {
        CampoIdFunc.setText("");
        CampoSenhaFunc.setText("");
        CampoNomeUsuarioFunc.setText("");
        CampoTipoFunc.setText("");
        CampoTelefoneFunc.setText("");
        CampoRGFunc.setText("");
        CampoNumeroCasaFunc.setText("");
        CampoEnderecoFunc.setText("");
        CampoEmailFunc.setText("");
        CampoCelularFunc.setText("");
        CampoCPFFunc.setText("");
        CampoNomeFunc.setText("");
        CampoBairroFunc.setText("");
    }

    //--------------
    public void TravaCamposProd() {
        CampoIdProduto.setEnabled(false);

        CampoTipoProduto.setEnabled(false);
        CampoDescProduto.setEnabled(false);
        CampoDetalhesProduto.setEnabled(false);
        CampoMarcaProduto.setEnabled(false);
        CampoOrigemProduto.setEnabled(false);
        CampoCodigoDeBarrasProduto.setEnabled(false);
        CampoFabricanteProduto.setEnabled(false);
        CampoSetorProduto.setEnabled(false);
        CampoUnidadeDeMedidaProduto.setEnabled(false);
        CampoPesoProduto.setEnabled(false);
        CampoMedidasProduto.setEnabled(false);
        CampoFotoProduto.setEnabled(false);
        CampoEstoqueProduto.setEnabled(false);
        //CampoAtivosProduto.setEnabled(false);
    }

    public void DestravaCamposProd() {
        CampoTipoProduto.setEnabled(true);
        CampoDescProduto.setEnabled(true);
        CampoDetalhesProduto.setEnabled(true);
        CampoMarcaProduto.setEnabled(true);
        CampoOrigemProduto.setEnabled(true);
        CampoCodigoDeBarrasProduto.setEnabled(true);
        CampoFabricanteProduto.setEnabled(true);
        CampoSetorProduto.setEnabled(true);
        CampoUnidadeDeMedidaProduto.setEnabled(true);
        CampoPesoProduto.setEnabled(true);
        CampoMedidasProduto.setEnabled(true);
        CampoFotoProduto.setEnabled(true);
        CampoEstoqueProduto.setEnabled(true);
        //CampoAtivosProduto.setEnabled(true);
    }

    public void LimpaCamposProd() {
        CampoIdProduto.setText("");
        CampoTipoProduto.setText("");
        CampoDescProduto.setText("");
        CampoDetalhesProduto.setText("");
        CampoMarcaProduto.setText("");
        CampoOrigemProduto.setText("");
        CampoCodigoDeBarrasProduto.setText("");
        CampoFabricanteProduto.setText("");
        CampoSetorProduto.setText("");
        CampoUnidadeDeMedidaProduto.setText("");
        CampoPesoProduto.setText("");
        CampoMedidasProduto.setText("");
        CampoFotoProduto.setText("");
        CampoEstoqueProduto.setText("");
        //CampoAtivosProduto.getModel().setSelectedItem(null);
    }

    public void TravaTudoProd() {
        //CampoAtivosProduto.getModel().setSelectedItem(null);
        CampoIdProduto.setEnabled(false);
        CampoTipoProduto.setEnabled(true);
        CampoDescProduto.setEnabled(true);
        CampoDetalhesProduto.setEnabled(true);
        CampoMarcaProduto.setEnabled(true);
        CampoOrigemProduto.setEnabled(true);
        CampoCodigoDeBarrasProduto.setEnabled(true);
        CampoFabricanteProduto.setEnabled(true);
        CampoSetorProduto.setEnabled(true);
        CampoUnidadeDeMedidaProduto.setEnabled(true);
        CampoPesoProduto.setEnabled(true);
        CampoMedidasProduto.setEnabled(true);
        CampoFotoProduto.setEnabled(true);
        CampoEstoqueProduto.setEnabled(true);
        //CampoAtivosProduto.setEnabled(true);

        BotaoSalvaProduto.setEnabled(false);
        BotaoAlteraProduto.setEnabled(false);
        BotaoDesativaProduto.setEnabled(false);
    }

    public void atualizarTabelaCliente() {
        ClienteModel cli = new ClienteModel();
        ClienteDAO clienteDAO = new ClienteDAO();
        try {
            ListaCliente = clienteDAO.ListaCliente();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        String dados[][] = new String[ListaCliente.size()][17];
        int i = 0;
        for (ClienteModel cliente : ListaCliente) {
            dados[i][0] = String.valueOf(cliente.getId());
            dados[i][1] = cliente.getNomeRazao();
            dados[i][2] = cliente.getCPF_CNPJ();
            dados[i][3] = cliente.getRG();
            dados[i][4] = cliente.getEndereco();
            dados[i][5] = String.valueOf(cliente.getNumero());
            dados[i][6] = cliente.getComplemento();
            dados[i][7] = cliente.getBairro();
            dados[i][8] = cliente.getCidade();
            dados[i][9] = cliente.getEstado();
            dados[i][10] = cliente.getCEP();
            dados[i][11] = cliente.getTelefone();
            dados[i][12] = cliente.getTelefone2();
            dados[i][13] = cliente.getEmail();//--
            dados[i][14] = String.valueOf(cliente.getVencimentoConta());
            dados[i][15] = String.valueOf(cliente.getDebito());
            dados[i][16] = String.valueOf(cliente.isAtivo());

            i++;
        }
        String tituloColuna[] = {"id", "Nome", "Cpf/cnpj", "RG", "Endereço", "Numero", "Complemento", "Bairro", "Cidade", "Estado", "CEP", "Telefone", "Celular",
            "Email", "Vencimento", "Debito", "Ativo"};

        DefaultTableModel tabelaCliente = new DefaultTableModel();
        tabelaCliente.setDataVector(dados, tituloColuna);
        TPesquisarCliente.setModel(new DefaultTableModel(dados, tituloColuna) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        TPesquisarCliente.getColumnModel().getColumn(0).setPreferredWidth(20);
        TPesquisarCliente.getColumnModel().getColumn(1).setPreferredWidth(180);
        TPesquisarCliente.getColumnModel().getColumn(2).setPreferredWidth(100);
        TPesquisarCliente.getColumnModel().getColumn(3).setPreferredWidth(100);
        TPesquisarCliente.getColumnModel().getColumn(4).setPreferredWidth(30);
        TPesquisarCliente.getColumnModel().getColumn(5).setPreferredWidth(50);
        TPesquisarCliente.getColumnModel().getColumn(6).setPreferredWidth(60);
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        TPesquisarCliente.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        TPesquisarCliente.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        TPesquisarCliente.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        TPesquisarCliente.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        TPesquisarCliente.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        TPesquisarCliente.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        TPesquisarCliente.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        TPesquisarCliente.setRowHeight(25);
        TPesquisarCliente.updateUI();
    }

    public void BuscaClienteComFiltro() {

        ClienteModel cli = new ClienteModel();
        String dados[][] = new String[ListaBuscaCliente.size()][17];
        int i = 0;
        for (ClienteModel cliente : ListaBuscaCliente) {
            dados[i][0] = String.valueOf(cliente.getId());
            dados[i][1] = cliente.getNomeRazao();
            dados[i][2] = cliente.getCPF_CNPJ();
            dados[i][3] = cliente.getRG();
            dados[i][4] = cliente.getEndereco();
            dados[i][5] = String.valueOf(cliente.getNumero());
            dados[i][6] = cliente.getComplemento();
            dados[i][7] = cliente.getBairro();
            dados[i][8] = cliente.getCidade();
            dados[i][9] = cliente.getEstado();
            dados[i][10] = cliente.getCEP();
            dados[i][11] = cliente.getTelefone();
            dados[i][12] = cliente.getTelefone2();
            dados[i][13] = cliente.getEmail();
            dados[i][14] = String.valueOf(cliente.getVencimentoConta());
            dados[i][15] = String.valueOf(cliente.getDebito());
            dados[i][16] = String.valueOf(cliente.isAtivo());

            i++;
        }
        String tituloColuna[] = {"id", "Nome", "Cpf/cnpj", "RG", "Endereço", "Numero", "Complemento", "Bairro", "Cidade", "Estado", "CEP", "Telefone", "Celular",
            "Email", "Vencimento", "Debito", "Ativo"};
        DefaultTableModel tabelaCliente = new DefaultTableModel();
        tabelaCliente.setDataVector(dados, tituloColuna);
        TPesquisarCliente.setModel(new DefaultTableModel(dados, tituloColuna) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        TPesquisarCliente.getColumnModel().getColumn(0).setPreferredWidth(20);
        TPesquisarCliente.getColumnModel().getColumn(1).setPreferredWidth(180);
        TPesquisarCliente.getColumnModel().getColumn(2).setPreferredWidth(100);
        TPesquisarCliente.getColumnModel().getColumn(3).setPreferredWidth(100);
        TPesquisarCliente.getColumnModel().getColumn(4).setPreferredWidth(30);
        TPesquisarCliente.getColumnModel().getColumn(5).setPreferredWidth(50);
        TPesquisarCliente.getColumnModel().getColumn(6).setPreferredWidth(60);
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        TPesquisarCliente.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        TPesquisarCliente.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        TPesquisarCliente.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        TPesquisarCliente.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        TPesquisarCliente.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        TPesquisarCliente.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        TPesquisarCliente.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        TPesquisarCliente.setRowHeight(25);
        TPesquisarCliente.updateUI();
    }

    //----------------------------------------------------------------------------------------------------------
    public void atualizarTabelaFuncionario() {
        FuncionarioModel func = new FuncionarioModel();
        FuncionarioDAO funcDAO = new FuncionarioDAO();
        try {
            ListaFuncionario = funcDAO.ListaFuncionario();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        String dados[][] = new String[ListaFuncionario.size()][14];
        int i = 0;
        for (FuncionarioModel funcM : ListaFuncionario) {
            dados[i][0] = String.valueOf(funcM.getId());
            dados[i][1] = String.valueOf(funcM.getIdTipoUsuario());
            dados[i][2] = funcM.getNome();
            dados[i][3] = funcM.getEndereco();
            dados[i][4] = String.valueOf(funcM.getNumero());
            dados[i][5] = funcM.getBairro();
            dados[i][6] = funcM.getCpf();
            dados[i][7] = funcM.getRg();
            dados[i][8] = funcM.getTelefone();
            dados[i][9] = funcM.getCelular();
            dados[i][10] = funcM.getEmail();
            dados[i][11] = funcM.getUsuario();//--
            dados[i][12] = funcM.getSenha();
            dados[i][13] = String.valueOf(funcM.getAtivo());

            i++;
        }
        String tituloColuna[] = {"id", "id_tipo_usuario", "Cpf/nome", "Endereço", "Numero", "Bairro", "CPF", "RG", "telefone", "celular", "email", "usuario", "senha", "ativo"};
        DefaultTableModel tabelaCliente = new DefaultTableModel();
        tabelaCliente.setDataVector(dados, tituloColuna);
        TPesquisarFuncionario.setModel(new DefaultTableModel(dados, tituloColuna) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        TPesquisarFuncionario.getColumnModel().getColumn(0).setPreferredWidth(20);
        TPesquisarFuncionario.getColumnModel().getColumn(1).setPreferredWidth(180);
        TPesquisarFuncionario.getColumnModel().getColumn(2).setPreferredWidth(100);
        TPesquisarFuncionario.getColumnModel().getColumn(3).setPreferredWidth(100);
        TPesquisarFuncionario.getColumnModel().getColumn(4).setPreferredWidth(30);
        TPesquisarFuncionario.getColumnModel().getColumn(5).setPreferredWidth(50);
        TPesquisarFuncionario.getColumnModel().getColumn(6).setPreferredWidth(60);
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        TPesquisarFuncionario.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        TPesquisarFuncionario.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        TPesquisarFuncionario.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        TPesquisarFuncionario.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        TPesquisarFuncionario.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        TPesquisarFuncionario.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        TPesquisarFuncionario.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        TPesquisarFuncionario.setRowHeight(25);
        TPesquisarFuncionario.updateUI();
    }

    public void BuscaFuncionarioComFiltro() {

        FuncionarioModel func = new FuncionarioModel();
        String dados[][] = new String[ListaBuscaFuncionario.size()][14];
        int i = 0;
        for (FuncionarioModel funcM : ListaBuscaFuncionario) {
            dados[i][0] = String.valueOf(funcM.getId());
            dados[i][1] = String.valueOf(funcM.getIdTipoUsuario());
            dados[i][2] = funcM.getNome();
            dados[i][3] = funcM.getEndereco();
            dados[i][4] = String.valueOf(funcM.getNumero());
            dados[i][5] = funcM.getBairro();
            dados[i][6] = funcM.getCpf();
            dados[i][7] = funcM.getRg();
            dados[i][8] = funcM.getTelefone();
            dados[i][9] = funcM.getCelular();
            dados[i][10] = funcM.getEmail();
            dados[i][11] = funcM.getUsuario();//--
            dados[i][12] = funcM.getSenha();
            dados[i][13] = String.valueOf(funcM.getAtivo());

            i++;
        }
        String tituloColuna[] = {"id", "id_tipo_usuario", "Cpf/nome", "Endereço", "Numero", "Bairro", "CPF", "RG", "telefone", "celular", "email", "usuario", "senha", "ativo"};
        DefaultTableModel tabelaCliente = new DefaultTableModel();
        tabelaCliente.setDataVector(dados, tituloColuna);
        TPesquisarFuncionario.setModel(new DefaultTableModel(dados, tituloColuna) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        TPesquisarFuncionario.getColumnModel().getColumn(0).setPreferredWidth(20);
        TPesquisarFuncionario.getColumnModel().getColumn(1).setPreferredWidth(180);
        TPesquisarFuncionario.getColumnModel().getColumn(2).setPreferredWidth(100);
        TPesquisarFuncionario.getColumnModel().getColumn(3).setPreferredWidth(100);
        TPesquisarFuncionario.getColumnModel().getColumn(4).setPreferredWidth(30);
        TPesquisarFuncionario.getColumnModel().getColumn(5).setPreferredWidth(50);
        TPesquisarFuncionario.getColumnModel().getColumn(6).setPreferredWidth(60);
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        TPesquisarFuncionario.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        TPesquisarFuncionario.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        TPesquisarFuncionario.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        TPesquisarFuncionario.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        TPesquisarFuncionario.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        TPesquisarFuncionario.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        TPesquisarFuncionario.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        TPesquisarFuncionario.setRowHeight(25);
        TPesquisarFuncionario.updateUI();
    }

    //----------------------------------------------------------------------------------------------------------
    public void atualizarTabelaProduto() {
        ProdutoModel prod = new ProdutoModel();
        ProdutoDAO prodDAO = new ProdutoDAO();
        try {
            ListaProduto = prodDAO.ListaProduto();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        String dados[][] = new String[ListaProduto.size()][15];
        int i = 0;
        for (ProdutoModel prodM : ListaProduto) {
            dados[i][0] = String.valueOf(prodM.getId());
            dados[i][1] = prodM.getTipo();
            dados[i][2] = prodM.getDescricao();
            dados[i][3] = prodM.getDetalhes();
            dados[i][4] = prodM.getMarca();
            dados[i][5] = prodM.getOrigem();
            dados[i][6] = prodM.getCodigoDeBarras();
            dados[i][7] = prodM.getFabricante();
            dados[i][8] = prodM.getSetor();
            dados[i][9] = prodM.getUnitMedida();
            dados[i][10] = String.valueOf(prodM.getPeso());
            dados[i][11] = prodM.getMedidas();
            dados[i][12] = prodM.getFoto();
            dados[i][13] = String.valueOf(prodM.getEstoque());
            dados[i][14] = String.valueOf(prodM.isAtivo());

            i++;
        }
        String tituloColuna[] = {"id", "tipo", "descricao", "detalhes", "marca", "origem", "codigo_de_barras",
            "fabricante", "setor", "unidade_medida", "peso", "medidas", "foto", "estoque", "ativo"};
        DefaultTableModel tabelaCliente = new DefaultTableModel();
        tabelaCliente.setDataVector(dados, tituloColuna);
        TPesquisaProduto.setModel(new DefaultTableModel(dados, tituloColuna) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        TPesquisaProduto.getColumnModel().getColumn(0).setPreferredWidth(20);
        TPesquisaProduto.getColumnModel().getColumn(1).setPreferredWidth(180);
        TPesquisaProduto.getColumnModel().getColumn(2).setPreferredWidth(100);
        TPesquisaProduto.getColumnModel().getColumn(3).setPreferredWidth(100);
        TPesquisaProduto.getColumnModel().getColumn(4).setPreferredWidth(30);
        TPesquisaProduto.getColumnModel().getColumn(5).setPreferredWidth(50);
        TPesquisaProduto.getColumnModel().getColumn(6).setPreferredWidth(60);
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        TPesquisaProduto.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        TPesquisaProduto.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        TPesquisaProduto.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        TPesquisaProduto.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        TPesquisaProduto.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        TPesquisaProduto.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        TPesquisaProduto.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        TPesquisaProduto.setRowHeight(25);
        TPesquisaProduto.updateUI();
    }

    public void BuscaProdutoComFiltro() {

        ProdutoModel prod = new ProdutoModel();
        String dados[][] = new String[ListaBuscaProduto.size()][15];
        int i = 0;
        for (ProdutoModel prodM : ListaBuscaProduto) {
            dados[i][0] = String.valueOf(prodM.getId());
            dados[i][1] = prodM.getTipo();
            dados[i][2] = prodM.getDescricao();
            dados[i][3] = prodM.getDetalhes();
            dados[i][4] = prodM.getMarca();
            dados[i][5] = prodM.getOrigem();
            dados[i][6] = prodM.getCodigoDeBarras();
            dados[i][7] = prodM.getFabricante();
            dados[i][8] = prodM.getSetor();
            dados[i][9] = prodM.getUnitMedida();
            dados[i][10] = String.valueOf(prodM.getPeso());
            dados[i][11] = prodM.getMedidas();
            dados[i][12] = prodM.getFoto();
            dados[i][13] = String.valueOf(prodM.getEstoque());
            dados[i][14] = String.valueOf(prodM.isAtivo());

            i++;
        }
        String tituloColuna[] = {"id", "tipo", "descricao", "detalhes", "marca", "origem", "codigo_de_barras",
            "fabricante", "setor", "unidade_medida", "peso", "medidas", "foto", "estoque", "ativo"};
        DefaultTableModel tabelaCliente = new DefaultTableModel();
        tabelaCliente.setDataVector(dados, tituloColuna);
        TPesquisaProduto.setModel(new DefaultTableModel(dados, tituloColuna) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        TPesquisaProduto.getColumnModel().getColumn(0).setPreferredWidth(20);
        TPesquisaProduto.getColumnModel().getColumn(1).setPreferredWidth(180);
        TPesquisaProduto.getColumnModel().getColumn(2).setPreferredWidth(100);
        TPesquisaProduto.getColumnModel().getColumn(3).setPreferredWidth(100);
        TPesquisaProduto.getColumnModel().getColumn(4).setPreferredWidth(30);
        TPesquisaProduto.getColumnModel().getColumn(5).setPreferredWidth(50);
        TPesquisaProduto.getColumnModel().getColumn(6).setPreferredWidth(60);
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        TPesquisaProduto.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        TPesquisaProduto.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        TPesquisaProduto.getColumnModel().getColumn(2).setCellRenderer(centralizado);
        TPesquisaProduto.getColumnModel().getColumn(3).setCellRenderer(centralizado);
        TPesquisaProduto.getColumnModel().getColumn(4).setCellRenderer(centralizado);
        TPesquisaProduto.getColumnModel().getColumn(5).setCellRenderer(centralizado);
        TPesquisaProduto.getColumnModel().getColumn(6).setCellRenderer(centralizado);
        TPesquisaProduto.setRowHeight(25);
        TPesquisaProduto.updateUI();
    }
//-------------------------------------------------------------------------------------------------


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChamadaTabelaCliente = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        BotaoBuscaCliente1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TPesquisarCliente = new javax.swing.JTable();
        BuscaCliente = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        ChamadaTabelaFuncionario = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TPesquisarFuncionario = new javax.swing.JTable();
        BotaoBuscaCliente2 = new javax.swing.JButton();
        BuscaFuncionario = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        ChamadaTabelaProduto = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TPesquisaProduto = new javax.swing.JTable();
        BotaoBuscaCliente3 = new javax.swing.JButton();
        BuscaProduto = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        ProdutoView = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        BotaoNovoProduto = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        BotaoSalvaProduto = new javax.swing.JButton();
        BotaoBuscaProduto = new javax.swing.JButton();
        CampoIdProduto = new javax.swing.JTextField();
        CampoDescProduto = new javax.swing.JTextField();
        CampoDetalhesProduto = new javax.swing.JTextField();
        CampoCodigoDeBarrasProduto = new javax.swing.JTextField();
        CampoTipoProduto = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        CampoFabricanteProduto = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        CampoSetorProduto = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        CampoMarcaProduto = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        CampoOrigemProduto = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        CampoUnidadeDeMedidaProduto = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        CampoPesoProduto = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        CampoMedidasProduto = new javax.swing.JTextField();
        BotaoAlteraProduto = new javax.swing.JButton();
        BotaoDesativaProduto = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        CampoFotoProduto = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        CampoEstoqueProduto = new javax.swing.JTextField();
        ClienteView = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        BotaoNovoCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BotaoSalvaCliente = new javax.swing.JButton();
        BotaoBuscaCliente = new javax.swing.JButton();
        CampoIdCliente = new javax.swing.JTextField();
        CampoNomeCliente = new javax.swing.JTextField();
        CampoCPFCliente = new javax.swing.JTextField();
        CampoRGCliente = new javax.swing.JTextField();
        CampoEnderecoCliente = new javax.swing.JTextField();
        CampoComplementoCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CampoNumeroCasaCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        CampoCepCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        CampoTelefoneCliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        CampoCelularCliente = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        CampoEmailCliente = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        CampoEstadoCliente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        CampoCidadeCliente = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        CampoContasCliente = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        CampoDebitoCliente = new javax.swing.JTextField();
        BotaoAlteraCliente = new javax.swing.JButton();
        BotaoDesativaCliente = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        CampoBairroCliente = new javax.swing.JTextField();
        BotaoSalvaCliente1 = new javax.swing.JButton();
        FuncionarioView = new javax.swing.JInternalFrame();
        jPanel4 = new javax.swing.JPanel();
        BotaoNovoFunc = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        BotaoSalvaFunc = new javax.swing.JButton();
        BotaoBuscaFunc = new javax.swing.JButton();
        CampoIdFunc = new javax.swing.JTextField();
        CampoNomeFunc = new javax.swing.JTextField();
        CampoCPFFunc = new javax.swing.JTextField();
        CampoRGFunc = new javax.swing.JTextField();
        CampoEnderecoFunc = new javax.swing.JTextField();
        CampoNumeroCasaFunc = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        CampoTelefoneFunc = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        CampoCelularFunc = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        CampoEmailFunc = new javax.swing.JTextField();
        BotaoAlterarFuncionario = new javax.swing.JButton();
        BotaoNovoCliente9 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        CampoTipoFunc = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        CampoNomeUsuarioFunc = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        CampoSenhaFunc = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        CampoBairroFunc = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        BtnChamadaCliente = new javax.swing.JMenuItem();
        BtnChamadaFuncionario = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        ChamadaTabelaCliente.setMinimumSize(new java.awt.Dimension(850, 500));

        BotaoBuscaCliente1.setBackground(new java.awt.Color(255, 255, 255));
        BotaoBuscaCliente1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoBuscaCliente1.setText("Buscar Cliente");
        BotaoBuscaCliente1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoBuscaCliente1.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoBuscaCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscaCliente1ActionPerformed(evt);
            }
        });

        TPesquisarCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TPesquisarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TPesquisarClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TPesquisarCliente);

        BuscaCliente.setMinimumSize(new java.awt.Dimension(8, 20));
        BuscaCliente.setPreferredSize(new java.awt.Dimension(8, 20));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel48.setText("Tela de pesquisa de Cliente:");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setText("Insira um nome");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(jLabel49)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(BuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoBuscaCliente1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoBuscaCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout ChamadaTabelaClienteLayout = new javax.swing.GroupLayout(ChamadaTabelaCliente.getContentPane());
        ChamadaTabelaCliente.getContentPane().setLayout(ChamadaTabelaClienteLayout);
        ChamadaTabelaClienteLayout.setHorizontalGroup(
            ChamadaTabelaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ChamadaTabelaClienteLayout.setVerticalGroup(
            ChamadaTabelaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ChamadaTabelaFuncionario.setMinimumSize(new java.awt.Dimension(850, 500));
        ChamadaTabelaFuncionario.setPreferredSize(new java.awt.Dimension(850, 500));

        TPesquisarFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TPesquisarFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TPesquisarFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TPesquisarFuncionario);

        BotaoBuscaCliente2.setBackground(new java.awt.Color(255, 255, 255));
        BotaoBuscaCliente2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoBuscaCliente2.setText("Buscar Funcionario");
        BotaoBuscaCliente2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoBuscaCliente2.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoBuscaCliente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscaCliente2ActionPerformed(evt);
            }
        });

        BuscaFuncionario.setMinimumSize(new java.awt.Dimension(8, 20));
        BuscaFuncionario.setPreferredSize(new java.awt.Dimension(8, 20));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel32.setText("Tela de pesquisa de funcionario:");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Insira um nome");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel45)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(BuscaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoBuscaCliente2)))
                .addGap(50, 50, 50))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoBuscaCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout ChamadaTabelaFuncionarioLayout = new javax.swing.GroupLayout(ChamadaTabelaFuncionario.getContentPane());
        ChamadaTabelaFuncionario.getContentPane().setLayout(ChamadaTabelaFuncionarioLayout);
        ChamadaTabelaFuncionarioLayout.setHorizontalGroup(
            ChamadaTabelaFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ChamadaTabelaFuncionarioLayout.setVerticalGroup(
            ChamadaTabelaFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ChamadaTabelaProduto.setMinimumSize(new java.awt.Dimension(850, 500));
        ChamadaTabelaProduto.setPreferredSize(new java.awt.Dimension(850, 500));

        TPesquisaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TPesquisaProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TPesquisaProdutoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TPesquisaProduto);

        BotaoBuscaCliente3.setBackground(new java.awt.Color(255, 255, 255));
        BotaoBuscaCliente3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoBuscaCliente3.setText("Encontrar Produto");
        BotaoBuscaCliente3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoBuscaCliente3.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoBuscaCliente3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscaCliente3ActionPerformed(evt);
            }
        });

        BuscaProduto.setMinimumSize(new java.awt.Dimension(8, 20));
        BuscaProduto.setPreferredSize(new java.awt.Dimension(8, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Insira um produto!");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel29.setText("Tela de pesquisa de produto:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel16)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(BuscaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoBuscaCliente3)))
                .addGap(49, 49, 49))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BuscaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoBuscaCliente3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout ChamadaTabelaProdutoLayout = new javax.swing.GroupLayout(ChamadaTabelaProduto.getContentPane());
        ChamadaTabelaProduto.getContentPane().setLayout(ChamadaTabelaProdutoLayout);
        ChamadaTabelaProdutoLayout.setHorizontalGroup(
            ChamadaTabelaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ChamadaTabelaProdutoLayout.setVerticalGroup(
            ChamadaTabelaProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ProdutoView.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ProdutoView.setClosable(true);
        ProdutoView.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        ProdutoView.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        ProdutoView.setOpaque(true);
        ProdutoView.setVisible(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 246));

        BotaoNovoProduto.setBackground(new java.awt.Color(255, 255, 255));
        BotaoNovoProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoNovoProduto.setText("Novo Produto");
        BotaoNovoProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoNovoProduto.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoNovoProdutoActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Id:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Descrição:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Detalhes:");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Codigo de Barras:");

        BotaoSalvaProduto.setBackground(new java.awt.Color(255, 255, 255));
        BotaoSalvaProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoSalvaProduto.setText("Salvar");
        BotaoSalvaProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoSalvaProduto.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoSalvaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSalvaProdutoActionPerformed(evt);
            }
        });

        BotaoBuscaProduto.setBackground(new java.awt.Color(255, 255, 255));
        BotaoBuscaProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoBuscaProduto.setText("Buscar Produto");
        BotaoBuscaProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoBuscaProduto.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoBuscaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscaProdutoActionPerformed(evt);
            }
        });

        CampoIdProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoIdProdutoActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Tipo:");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Fabricante:");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Setor:");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("Marca:");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Origem:");

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setText("Unidade de Medida:");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("Peso:");

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("Medidas:");

        BotaoAlteraProduto.setBackground(new java.awt.Color(255, 255, 255));
        BotaoAlteraProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoAlteraProduto.setText("Alterar");
        BotaoAlteraProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoAlteraProduto.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoAlteraProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAlteraProdutoActionPerformed(evt);
            }
        });

        BotaoDesativaProduto.setBackground(new java.awt.Color(255, 255, 255));
        BotaoDesativaProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoDesativaProduto.setText("Desativar");
        BotaoDesativaProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoDesativaProduto.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoDesativaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoDesativaProdutoActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("Foto:");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setText("Estoque:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoDetalhesProduto))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoMarcaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoOrigemProduto))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoFabricanteProduto)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoSetorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoUnidadeDeMedidaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoCodigoDeBarrasProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel35)
                        .addGap(8, 8, 8)
                        .addComponent(CampoTipoProduto))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoPesoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel44)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoMedidasProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoFotoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoEstoqueProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(BotaoNovoProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotaoBuscaProduto)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoDescProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(BotaoSalvaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotaoAlteraProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotaoDesativaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoNovoProduto)
                    .addComponent(BotaoBuscaProduto))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel22)
                    .addComponent(CampoIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoDescProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(CampoDetalhesProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(CampoMarcaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(CampoOrigemProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(CampoCodigoDeBarrasProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35)
                    .addComponent(CampoTipoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(CampoFabricanteProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37)
                    .addComponent(CampoSetorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41)
                    .addComponent(CampoUnidadeDeMedidaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(CampoPesoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(CampoMedidasProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(CampoFotoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47)
                    .addComponent(CampoEstoqueProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoSalvaProduto)
                    .addComponent(BotaoAlteraProduto)
                    .addComponent(BotaoDesativaProduto))
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout ProdutoViewLayout = new javax.swing.GroupLayout(ProdutoView.getContentPane());
        ProdutoView.getContentPane().setLayout(ProdutoViewLayout);
        ProdutoViewLayout.setHorizontalGroup(
            ProdutoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ProdutoViewLayout.setVerticalGroup(
            ProdutoViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        ClienteView.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ClienteView.setClosable(true);
        ClienteView.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        ClienteView.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        ClienteView.setOpaque(true);
        ClienteView.setVisible(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 246));

        BotaoNovoCliente.setBackground(new java.awt.Color(255, 255, 255));
        BotaoNovoCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoNovoCliente.setText("Novo Cliente");
        BotaoNovoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoNovoCliente.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoNovoClienteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Id:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nome Razao:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("CPF:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("RG:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Endereço:");

        BotaoSalvaCliente.setBackground(new java.awt.Color(255, 255, 255));
        BotaoSalvaCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoSalvaCliente.setText("Salvar");
        BotaoSalvaCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoSalvaCliente.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoSalvaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSalvaClienteActionPerformed(evt);
            }
        });

        BotaoBuscaCliente.setBackground(new java.awt.Color(255, 255, 255));
        BotaoBuscaCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoBuscaCliente.setText("Buscar Cliente");
        BotaoBuscaCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoBuscaCliente.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoBuscaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscaClienteActionPerformed(evt);
            }
        });

        CampoIdCliente.setEditable(false);
        CampoIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoIdClienteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Complemento:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Numero:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Cep:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Telefone:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Celular:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Email:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("SiglaEstado:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Cidade:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Vencimento da conta:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Debito:");

        BotaoAlteraCliente.setBackground(new java.awt.Color(255, 255, 255));
        BotaoAlteraCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoAlteraCliente.setText("Alterar");
        BotaoAlteraCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoAlteraCliente.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoAlteraCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAlteraClienteActionPerformed(evt);
            }
        });

        BotaoDesativaCliente.setBackground(new java.awt.Color(255, 255, 255));
        BotaoDesativaCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoDesativaCliente.setText("Desativar");
        BotaoDesativaCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoDesativaCliente.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoDesativaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoDesativaClienteActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("Bairro:");

        BotaoSalvaCliente1.setBackground(new java.awt.Color(255, 255, 255));
        BotaoSalvaCliente1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoSalvaCliente1.setText("Limpar");
        BotaoSalvaCliente1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoSalvaCliente1.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoSalvaCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSalvaCliente1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoCPFCliente)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CampoNomeCliente)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoRGCliente)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(168, 168, 168))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoEnderecoCliente)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(BotaoNovoCliente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BotaoBuscaCliente))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CampoNumeroCasaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CampoCepCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CampoEstadoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 37, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoComplementoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoCidadeCliente))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BotaoSalvaCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoSalvaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoAlteraCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoDesativaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoCelularCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoBairroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoContasCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoDebitoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoNovoCliente)
                    .addComponent(BotaoBuscaCliente))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(CampoIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(CampoCPFCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoRGCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(CampoTelefoneCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(CampoCelularCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(CampoEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CampoEnderecoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(CampoComplementoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(CampoNumeroCasaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(CampoCepCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(CampoEstadoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(CampoCidadeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel38)
                        .addComponent(CampoBairroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(CampoContasCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15)
                        .addComponent(CampoDebitoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoSalvaCliente)
                    .addComponent(BotaoAlteraCliente)
                    .addComponent(BotaoDesativaCliente)
                    .addComponent(BotaoSalvaCliente1))
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout ClienteViewLayout = new javax.swing.GroupLayout(ClienteView.getContentPane());
        ClienteView.getContentPane().setLayout(ClienteViewLayout);
        ClienteViewLayout.setHorizontalGroup(
            ClienteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ClienteViewLayout.setVerticalGroup(
            ClienteViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        FuncionarioView.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        FuncionarioView.setClosable(true);
        FuncionarioView.setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        FuncionarioView.setDebugGraphicsOptions(javax.swing.DebugGraphics.BUFFERED_OPTION);
        FuncionarioView.setVisible(true);

        BotaoNovoFunc.setBackground(new java.awt.Color(255, 255, 255));
        BotaoNovoFunc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoNovoFunc.setText("Novo Funcionario");
        BotaoNovoFunc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoNovoFunc.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoNovoFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoNovoFuncActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Id:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Nome:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("CPF:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("RG:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Endereço:");

        BotaoSalvaFunc.setBackground(new java.awt.Color(255, 255, 255));
        BotaoSalvaFunc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoSalvaFunc.setText("Salvar");
        BotaoSalvaFunc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoSalvaFunc.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoSalvaFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSalvaFuncActionPerformed(evt);
            }
        });

        BotaoBuscaFunc.setBackground(new java.awt.Color(255, 255, 255));
        BotaoBuscaFunc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoBuscaFunc.setText("Buscar Funcionario");
        BotaoBuscaFunc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoBuscaFunc.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoBuscaFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscaFuncActionPerformed(evt);
            }
        });

        CampoIdFunc.setEditable(false);
        CampoIdFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoIdFuncActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Numero:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Telefone:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Celular:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Email:");

        BotaoAlterarFuncionario.setBackground(new java.awt.Color(255, 255, 255));
        BotaoAlterarFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoAlterarFuncionario.setText("Alterar");
        BotaoAlterarFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoAlterarFuncionario.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoAlterarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAlterarFuncionarioActionPerformed(evt);
            }
        });

        BotaoNovoCliente9.setBackground(new java.awt.Color(255, 255, 255));
        BotaoNovoCliente9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoNovoCliente9.setText("Desativar");
        BotaoNovoCliente9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoNovoCliente9.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoNovoCliente9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoNovoCliente9ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Tipo:");

        CampoTipoFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoTipoFuncActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Nome de usuario:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Senha:");

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setText("Bairro:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoCPFFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoRGFunc)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoTelefoneFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(168, 168, 168))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(BotaoSalvaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotaoAlterarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotaoNovoCliente9, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoTipoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CampoNomeFunc))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoEnderecoFunc)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoNumeroCasaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(223, 223, 223))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoNomeUsuarioFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoSenhaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoBairroFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoCelularFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoEmailFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(BotaoNovoFunc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoBuscaFunc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(50, 50, 50))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoNovoFunc)
                    .addComponent(BotaoBuscaFunc)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(CampoIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(CampoTipoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(CampoNomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(CampoCPFFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoRGFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(CampoTelefoneFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(CampoCelularFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(CampoEmailFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(CampoEnderecoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(CampoNumeroCasaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel42)
                        .addComponent(CampoBairroFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(CampoNomeUsuarioFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel31)
                        .addComponent(CampoSenhaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoSalvaFunc)
                    .addComponent(BotaoAlterarFuncionario)
                    .addComponent(BotaoNovoCliente9))
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout FuncionarioViewLayout = new javax.swing.GroupLayout(FuncionarioView.getContentPane());
        FuncionarioView.getContentPane().setLayout(FuncionarioViewLayout);
        FuncionarioViewLayout.setHorizontalGroup(
            FuncionarioViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        FuncionarioViewLayout.setVerticalGroup(
            FuncionarioViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jDesktopPane1.setLayer(ProdutoView, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(ClienteView, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(FuncionarioView, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ClienteView)
                    .addComponent(FuncionarioView)
                    .addComponent(ProdutoView, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ClienteView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FuncionarioView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ProdutoView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        jMenu1.setText("Cadastros");

        BtnChamadaCliente.setText("Cliente");
        BtnChamadaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnChamadaClienteActionPerformed(evt);
            }
        });
        jMenu1.add(BtnChamadaCliente);

        BtnChamadaFuncionario.setText("Funcionario");
        BtnChamadaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnChamadaFuncionarioActionPerformed(evt);
            }
        });
        jMenu1.add(BtnChamadaFuncionario);

        jMenuItem1.setText("Produto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Consultas");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Sair");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnChamadaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnChamadaClienteActionPerformed
        ClienteView.setVisible(true);
    }//GEN-LAST:event_BtnChamadaClienteActionPerformed

    private void BtnChamadaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnChamadaFuncionarioActionPerformed
        FuncionarioView.setVisible(true);
    }//GEN-LAST:event_BtnChamadaFuncionarioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ProdutoView.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void BotaoNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoProdutoActionPerformed
        DestravaCamposProd();
        LimpaCamposProd();
        CampoIdProduto.setEnabled(false);
        CampoIdProduto.setEnabled(false);
        BotaoSalvaProduto.setEnabled(true);
        BotaoAlteraProduto.setEnabled(false);
        BotaoDesativaProduto.setEnabled(false);
    }//GEN-LAST:event_BotaoNovoProdutoActionPerformed

    private void BotaoSalvaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvaProdutoActionPerformed
        if (CampoTipoProduto.getText().isEmpty()
                || CampoDescProduto.getText().isEmpty()
                || CampoDetalhesProduto.getText().isEmpty()
                || CampoMarcaProduto.getText().isEmpty()
                || CampoOrigemProduto.getText().isEmpty()
                || CampoCodigoDeBarrasProduto.getText().isEmpty()
                || CampoFabricanteProduto.getText().isEmpty()
                || CampoSetorProduto.getText().isEmpty()
                || CampoUnidadeDeMedidaProduto.getText().isEmpty()
                || CampoPesoProduto.getText().isEmpty()
                || CampoMedidasProduto.getText().isEmpty()
                || CampoFotoProduto.getText().isEmpty()
                || CampoEstoqueProduto.getText().isEmpty() /*|| CampoAtivosProduto.getModel().getSelectedItem().equals(null)*/) {
            JOptionPane.showMessageDialog(null, "Há campos não preenchidos", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                ProdutoModel produtoModel = new ProdutoModel();
                produtoModel.getId();
                produtoModel.setTipo(CampoTipoProduto.getText());
                produtoModel.setDescricao(CampoDescProduto.getText());
                produtoModel.setDetalhes(CampoDetalhesProduto.getText());
                produtoModel.setMarca(CampoMarcaProduto.getText());
                produtoModel.setOrigem(CampoOrigemProduto.getText());
                produtoModel.setCodigoDeBarras(CampoCodigoDeBarrasProduto.getText());
                produtoModel.setFabricante(CampoFabricanteProduto.getText());
                produtoModel.setSetor(CampoSetorProduto.getText());
                produtoModel.setUnitMedida(CampoUnidadeDeMedidaProduto.getText());
                produtoModel.setPeso(Double.parseDouble(CampoPesoProduto.getText()));
                produtoModel.setMedidas(CampoMedidasProduto.getText());
                produtoModel.setFoto(CampoFotoProduto.getText());
                produtoModel.setEstoque(Integer.parseInt(CampoEstoqueProduto.getText()));
                produtoModel.isAtivo();

                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.InserirNovoProduto(produtoModel);
                LimpaCamposProd();
                TravaCamposProd();
                atualizarTabelaProduto();
                JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Sistema", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, e.getMessage(), "Sistema", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }//GEN-LAST:event_BotaoSalvaProdutoActionPerformed

    private void BotaoBuscaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaProdutoActionPerformed
        ChamadaTabelaProduto.setVisible(true);
    }//GEN-LAST:event_BotaoBuscaProdutoActionPerformed

    private void CampoIdProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoIdProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoIdProdutoActionPerformed

    private void BotaoAlteraProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAlteraProdutoActionPerformed
        if (CampoTipoProduto.getText().isEmpty()
                || CampoDescProduto.getText().isEmpty()
                || CampoDetalhesProduto.getText().isEmpty()
                || CampoMarcaProduto.getText().isEmpty()
                || CampoOrigemProduto.getText().isEmpty()
                || CampoCodigoDeBarrasProduto.getText().isEmpty()
                || CampoFabricanteProduto.getText().isEmpty()
                || CampoSetorProduto.getText().isEmpty()
                || CampoUnidadeDeMedidaProduto.getText().isEmpty()
                || CampoPesoProduto.getText().isEmpty()
                || CampoMedidasProduto.getText().isEmpty()
                || CampoFotoProduto.getText().isEmpty()
                || CampoEstoqueProduto.getText().isEmpty() /*|| CampoAtivosProduto.getModel().getSelectedItem().equals(null)*/) {
            JOptionPane.showMessageDialog(null, "Há campos não preenchidos", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                ProdutoModel prod = new ProdutoModel();
                ProdutoDAO produtoDAO = new ProdutoDAO();
                prod.setId(Integer.parseInt(CampoIdProduto.getText()));
                prod.setTipo(CampoTipoProduto.getText());
                prod.setDescricao(CampoDescProduto.getText());
                prod.setDetalhes(CampoDetalhesProduto.getText());
                prod.setMarca(CampoMarcaProduto.getText());
                prod.setOrigem(CampoOrigemProduto.getText());
                prod.setCodigoDeBarras(CampoCodigoDeBarrasProduto.getText());
                prod.setFabricante(CampoFabricanteProduto.getText());
                prod.setSetor(CampoSetorProduto.getText());
                prod.setUnitMedida(CampoUnidadeDeMedidaProduto.getText());
                prod.setPeso(Double.parseDouble(CampoPesoProduto.getText()));
                prod.setMedidas(CampoMedidasProduto.getText());
                prod.setFoto(CampoFotoProduto.getText());
                prod.setEstoque(Integer.parseInt(CampoEstoqueProduto.getText()));
                /*produtoModel.setAtivo(Boolean.parseBoolean((String) CampoAtivosProduto.getSelectedItem()));*/

                if (JOptionPane.showConfirmDialog(null, "Deseja mesmo alterar esse produto?", "pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                    produtoDAO.AlterarProduto(prod);
                    LimpaCamposProd();
                    TravaCamposProd();
                    atualizarTabelaProduto();
                    JOptionPane.showMessageDialog(null, "Alterado com sucesso", "Sistema", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, e.getMessage(), "Sistema", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }//GEN-LAST:event_BotaoAlteraProdutoActionPerformed

    private void BotaoDesativaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoDesativaProdutoActionPerformed
        if (CampoIdProduto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um produto", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                ProdutoModel produtoModel = new ProdutoModel();
                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoModel.setId(Integer.parseInt(CampoIdProduto.getText()));

                if (JOptionPane.showConfirmDialog(null, "Deseja mesmo desativar esse produto?", "pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    produtoDAO.DesativarProduto(produtoModel);
                    LimpaCamposProd();
                    TravaCamposProd();
                    atualizarTabelaProduto();
                    JOptionPane.showMessageDialog(null, "Produto desativado com sucesso", "Sistema", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, e.getMessage(), "Sistema", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }//GEN-LAST:event_BotaoDesativaProdutoActionPerformed

    private void BotaoNovoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoClienteActionPerformed
        DestravaCamposCliente();
        LimpaCamposCliente();
    }//GEN-LAST:event_BotaoNovoClienteActionPerformed

    private void BotaoSalvaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvaClienteActionPerformed
        if (CampoNomeCliente.getText().isEmpty()
                //|| CampoAtivosCliente.getSelectedItem().equals(null)
                || CampoCPFCliente.getText().isEmpty()
                || CampoCelularCliente.getText().isEmpty()
                || CampoCepCliente.getText().isEmpty()
                || CampoCidadeCliente.getText().isEmpty()
                || CampoComplementoCliente.getText().isEmpty()
                || CampoContasCliente.getText().isEmpty()
                || CampoDebitoCliente.getText().isEmpty()
                || CampoEmailCliente.getText().isEmpty()
                || CampoEnderecoCliente.getText().isEmpty()
                || CampoEstadoCliente.getText().isEmpty()
                || CampoNumeroCasaCliente.getText().isEmpty()
                || CampoRGCliente.getText().isEmpty()
                || CampoTelefoneCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Há campos não preenchidos", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        } else {
            ClienteModel cli = new ClienteModel();
            ClienteDAO cliD = new ClienteDAO();
            cli.setNomeRazao(CampoNomeCliente.getText());
            cli.setCPF_CNPJ(CampoCPFCliente.getText());
            cli.setRG(CampoRGCliente.getText());
            cli.setEndereco(CampoEnderecoCliente.getText());
            cli.setNumero(Integer.parseInt(CampoNumeroCasaCliente.getText()));
            cli.setComplemento(CampoComplementoCliente.getText());
            cli.setBairro(CampoBairroCliente.getText());
            cli.setCidade(CampoCidadeCliente.getText());
            cli.setEstado(CampoEstadoCliente.getText());
            cli.setCEP(CampoCepCliente.getText());
            cli.setTelefone(CampoTelefoneCliente.getText());
            cli.setTelefone2(CampoCelularCliente.getText());
            cli.setEmail(CampoEmailCliente.getText());
            cli.setVencimentoConta(CampoContasCliente.getText());
            cli.setDebito(Double.parseDouble(CampoDebitoCliente.getText()));

            try {
                cliD.NovoCliente(cli);
                JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Sistema", JOptionPane.INFORMATION_MESSAGE);
                LimpaCamposCliente();
                TravaCamposCliente();
                atualizarTabelaCliente();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BotaoSalvaClienteActionPerformed

    private void BotaoBuscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaClienteActionPerformed
        LimpaCamposCliente();
        ChamadaTabelaCliente.setVisible(true);
    }//GEN-LAST:event_BotaoBuscaClienteActionPerformed

    private void CampoIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoIdClienteActionPerformed

    private void BotaoAlteraClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAlteraClienteActionPerformed
        if (CampoNomeCliente.getText().isEmpty()
                //|| CampoAtivosCliente.getSelectedItem().equals(null)
                || CampoCPFCliente.getText().isEmpty()
                || CampoCelularCliente.getText().isEmpty()
                || CampoCepCliente.getText().isEmpty()
                || CampoCidadeCliente.getText().isEmpty()
                || CampoComplementoCliente.getText().isEmpty()
                || CampoContasCliente.getText().isEmpty()
                || CampoDebitoCliente.getText().isEmpty()
                || CampoEmailCliente.getText().isEmpty()
                || CampoEnderecoCliente.getText().isEmpty()
                || CampoEstadoCliente.getText().isEmpty()
                || CampoNumeroCasaCliente.getText().isEmpty()
                || CampoRGCliente.getText().isEmpty()
                || CampoTelefoneCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Há campos não preenchidos", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        } else {
            ClienteModel cli = new ClienteModel();
            ClienteDAO cliD = new ClienteDAO();
            cli.setId(Integer.parseInt(CampoIdCliente.getText()));
            cli.setNomeRazao(CampoNomeCliente.getText());
            cli.setCPF_CNPJ(CampoCPFCliente.getText());
            cli.setRG(CampoRGCliente.getText());
            cli.setEndereco(CampoEnderecoCliente.getText());
            cli.setNumero(Integer.parseInt(CampoNumeroCasaCliente.getText()));
            cli.setComplemento(CampoComplementoCliente.getText());
            cli.setBairro(CampoBairroCliente.getText());
            cli.setCidade(CampoCidadeCliente.getText());
            cli.setEstado(CampoEstadoCliente.getText());
            cli.setCEP(CampoCepCliente.getText());
            cli.setTelefone(CampoTelefoneCliente.getText());
            cli.setTelefone2(CampoCelularCliente.getText());
            cli.setEmail(CampoEmailCliente.getText());
            cli.setVencimentoConta(CampoContasCliente.getText());
            cli.setDebito(Double.parseDouble(CampoDebitoCliente.getText()));
            //clienteModel.isAtivo();
            try {
                cliD.AlterarCliente(cli);
                JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Sistema", JOptionPane.INFORMATION_MESSAGE);
                LimpaCamposCliente();
                TravaCamposCliente();
                atualizarTabelaCliente();
            } catch (Exception ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_BotaoAlteraClienteActionPerformed

    private void BotaoDesativaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoDesativaClienteActionPerformed
        if (CampoIdCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente para desativa-lo", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        } else {
            ClienteModel cli = new ClienteModel();
            ClienteDAO cliD = new ClienteDAO();
            cli.setId(Integer.parseInt(CampoIdCliente.getText()));

            try {
                cliD.DesativarCliente(cli);
                JOptionPane.showMessageDialog(null, "Desativado com sucesso", "Sistema", JOptionPane.INFORMATION_MESSAGE);
                LimpaCamposCliente();
                TravaCamposCliente();
                atualizarTabelaCliente();
            } catch (Exception ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BotaoDesativaClienteActionPerformed

    private void BotaoSalvaCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvaCliente1ActionPerformed
        LimpaCamposCliente();
    }//GEN-LAST:event_BotaoSalvaCliente1ActionPerformed

    private void BotaoNovoFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoFuncActionPerformed
        DestravaCamposFunc();
    }//GEN-LAST:event_BotaoNovoFuncActionPerformed

    private void BotaoSalvaFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvaFuncActionPerformed
        if (CampoSenhaFunc.getText().isEmpty()
                || CampoNomeFunc.getText().isEmpty()
                || CampoTipoFunc.getText().isEmpty()
                || CampoTelefoneFunc.getText().isEmpty()
                || CampoRGFunc.getText().isEmpty()
                || CampoNumeroCasaFunc.getText().isEmpty()
                || CampoEnderecoFunc.getText().isEmpty()
                || CampoEmailFunc.getText().isEmpty()
                || CampoCelularFunc.getText().isEmpty()
                || CampoCPFFunc.getText().isEmpty()
                || CampoNomeUsuarioFunc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Há campos não preenchidos", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                FuncionarioModel func = new FuncionarioModel();
                FuncionarioDAO funcionarioD = new FuncionarioDAO();

                func.setCelular(CampoCelularFunc.getText());
                func.setIdTipoUsuario(Integer.parseInt(CampoTipoFunc.getText()));
                func.setCpf(CampoCPFFunc.getText());
                func.setEmail(CampoEmailFunc.getText());
                func.setEndereco(CampoEnderecoFunc.getText());
                func.setNome(CampoNomeFunc.getText());
                func.setNumero(Integer.parseInt(CampoNumeroCasaFunc.getText()));
                func.setRg(CampoRGFunc.getText());
                func.setSenha(CampoSenhaFunc.getText());
                func.setTelefone(CampoTelefoneFunc.getText());
                func.setUsuario(CampoNomeUsuarioFunc.getText());
                func.setBairro(CampoBairroFunc.getText());

                funcionarioD.SalvarFuncionario(func);

                JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Sistema", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro! Não foi possível realizar o cadastro.");
                e.printStackTrace();
            }
            atualizarTabelaFuncionario();
            LimpaCamposFunc();
            TravaCamposFunc();
        }
    }//GEN-LAST:event_BotaoSalvaFuncActionPerformed

    private void BotaoBuscaFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaFuncActionPerformed
        ChamadaTabelaFuncionario.setVisible(true);
    }//GEN-LAST:event_BotaoBuscaFuncActionPerformed

    private void CampoIdFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoIdFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoIdFuncActionPerformed

    private void BotaoAlterarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAlterarFuncionarioActionPerformed
        if (CampoSenhaFunc.getText().isEmpty()
                || CampoNomeFunc.getText().isEmpty()
                || CampoTipoFunc.getText().isEmpty()
                || CampoTelefoneFunc.getText().isEmpty()
                || CampoRGFunc.getText().isEmpty()
                || CampoNumeroCasaFunc.getText().isEmpty()
                || CampoEnderecoFunc.getText().isEmpty()
                || CampoEmailFunc.getText().isEmpty()
                || CampoCelularFunc.getText().isEmpty()
                || CampoCPFFunc.getText().isEmpty()
                || CampoNomeUsuarioFunc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Há campos não preenchidos", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                FuncionarioModel func = new FuncionarioModel();
                FuncionarioDAO funcionarioD = new FuncionarioDAO();

                func.setId(Integer.parseInt(CampoIdFunc.getText()));
                func.setCelular(CampoCelularFunc.getText());
                func.setIdTipoUsuario(Integer.parseInt(CampoTipoFunc.getText()));
                func.setCpf(CampoCPFFunc.getText());
                func.setEmail(CampoEmailFunc.getText());
                func.setEndereco(CampoEnderecoFunc.getText());
                func.setNome(CampoNomeFunc.getText());
                func.setNumero(Integer.parseInt(CampoNumeroCasaFunc.getText()));
                func.setRg(CampoRGFunc.getText());
                func.setSenha(CampoSenhaFunc.getText());
                func.setTelefone(CampoTelefoneFunc.getText());
                func.setUsuario(CampoNomeUsuarioFunc.getText());
                func.setBairro(CampoBairroFunc.getText());

                funcionarioD.AlterarFuncionario(func);

                JOptionPane.showMessageDialog(null, "Salvo com sucesso", "Sistema", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro! Não foi possível realizar o cadastro.");
                e.printStackTrace();
            }
            atualizarTabelaFuncionario();
            LimpaCamposFunc();
            TravaCamposFunc();
        }
    }//GEN-LAST:event_BotaoAlterarFuncionarioActionPerformed

    private void BotaoNovoCliente9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoCliente9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoNovoCliente9ActionPerformed

    private void CampoTipoFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoTipoFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoTipoFuncActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void BotaoBuscaCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaCliente1ActionPerformed
        ListaBuscaCliente = null;
        ClienteModel cli = new ClienteModel();
        ClienteDAO clienteDAO = new ClienteDAO();

        try {

            if (!BuscaCliente.getText().isEmpty()) {
                cli.setNomeRazao(BuscaCliente.getText());
            }

            System.out.println(BuscaCliente.getText());
            ListaBuscaCliente = clienteDAO.ListaBuscaCliente(cli);

            BuscaClienteComFiltro();
            System.out.println("teste teste teste teste testes testes testes testes testes testes testes testes");

        } catch (Exception E) {
            System.out.println(E.getMessage());
            JOptionPane.showMessageDialog(null, "Problema no BotaoBuscaAlterarOuRemoverRevista do DashBoard, busca de revista falhou", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BotaoBuscaCliente1ActionPerformed

    private void TPesquisarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TPesquisarClienteMouseClicked
        TPesquisarCliente.getTableHeader().setReorderingAllowed(false);
        CampoIdCliente.setText(TPesquisarCliente.getValueAt(TPesquisarCliente.getSelectedRow(), 0).toString());
        CampoNomeCliente.setText(TPesquisarCliente.getValueAt(TPesquisarCliente.getSelectedRow(), 1).toString());
        CampoCPFCliente.setText(TPesquisarCliente.getValueAt(TPesquisarCliente.getSelectedRow(), 2).toString());
        CampoRGCliente.setText(TPesquisarCliente.getValueAt(TPesquisarCliente.getSelectedRow(), 3).toString());
        CampoEnderecoCliente.setText(TPesquisarCliente.getValueAt(TPesquisarCliente.getSelectedRow(), 4).toString());
        CampoNumeroCasaCliente.setText(TPesquisarCliente.getValueAt(TPesquisarCliente.getSelectedRow(), 5).toString());
        CampoComplementoCliente.setText(TPesquisarCliente.getValueAt(TPesquisarCliente.getSelectedRow(), 6).toString());
        CampoBairroCliente.setText(TPesquisarCliente.getValueAt(TPesquisarCliente.getSelectedRow(), 7).toString());
        CampoCidadeCliente.setText(TPesquisarCliente.getValueAt(TPesquisarCliente.getSelectedRow(), 8).toString());
        CampoEstadoCliente.setText(TPesquisarCliente.getValueAt(TPesquisarCliente.getSelectedRow(), 9).toString());
        CampoCepCliente.setText(TPesquisarCliente.getValueAt(TPesquisarCliente.getSelectedRow(), 10).toString());
        CampoTelefoneCliente.setText(TPesquisarCliente.getValueAt(TPesquisarCliente.getSelectedRow(), 11).toString());
        CampoCelularCliente.setText(TPesquisarCliente.getValueAt(TPesquisarCliente.getSelectedRow(), 12).toString());
        CampoEmailCliente.setText(TPesquisarCliente.getValueAt(TPesquisarCliente.getSelectedRow(), 13).toString());
        CampoContasCliente.setText(TPesquisarCliente.getValueAt(TPesquisarCliente.getSelectedRow(), 14).toString());
        CampoDebitoCliente.setText(TPesquisarCliente.getValueAt(TPesquisarCliente.getSelectedRow(), 15).toString());

        ChamadaTabelaCliente.dispose();
        DestravaCamposCliente();
    }//GEN-LAST:event_TPesquisarClienteMouseClicked

    private void TPesquisarFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TPesquisarFuncionarioMouseClicked
        TPesquisarFuncionario.getTableHeader().setReorderingAllowed(false);
        CampoIdFunc.setText(TPesquisarFuncionario.getValueAt(TPesquisarFuncionario.getSelectedRow(), 0).toString());
        CampoTipoFunc.setText(TPesquisarFuncionario.getValueAt(TPesquisarFuncionario.getSelectedRow(), 1).toString());
        CampoNomeFunc.setText(TPesquisarFuncionario.getValueAt(TPesquisarFuncionario.getSelectedRow(), 2).toString());
        CampoEnderecoFunc.setText(TPesquisarFuncionario.getValueAt(TPesquisarFuncionario.getSelectedRow(), 3).toString());
        CampoNumeroCasaFunc.setText(TPesquisarFuncionario.getValueAt(TPesquisarFuncionario.getSelectedRow(), 4).toString());
        CampoBairroFunc.setText(TPesquisarFuncionario.getValueAt(TPesquisarFuncionario.getSelectedRow(), 5).toString());
        CampoCPFFunc.setText(TPesquisarFuncionario.getValueAt(TPesquisarFuncionario.getSelectedRow(), 6).toString());
        CampoRGFunc.setText(TPesquisarFuncionario.getValueAt(TPesquisarFuncionario.getSelectedRow(), 7).toString());
        CampoTelefoneFunc.setText(TPesquisarFuncionario.getValueAt(TPesquisarFuncionario.getSelectedRow(), 8).toString());
        CampoCelularFunc.setText(TPesquisarFuncionario.getValueAt(TPesquisarFuncionario.getSelectedRow(), 9).toString());
        CampoEmailFunc.setText(TPesquisarFuncionario.getValueAt(TPesquisarFuncionario.getSelectedRow(), 10).toString());
        CampoNomeUsuarioFunc.setText(TPesquisarFuncionario.getValueAt(TPesquisarFuncionario.getSelectedRow(), 11).toString());
        CampoSenhaFunc.setText(TPesquisarFuncionario.getValueAt(TPesquisarFuncionario.getSelectedRow(), 12).toString());

        DestravaCamposFunc();
        ChamadaTabelaFuncionario.dispose();
    }//GEN-LAST:event_TPesquisarFuncionarioMouseClicked

    private void BotaoBuscaCliente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaCliente2ActionPerformed
        ListaBuscaFuncionario = null;
        FuncionarioModel func = new FuncionarioModel();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        try {

            if (!BuscaFuncionario.getText().isEmpty()) {
                func.setNome(BuscaFuncionario.getText());
            }

            /*if (BuscaEspecificacaoMenuRevistas.getSelectedItem() != null) {
                rev.setEspecificacao((String) BuscaEspecificacaoMenuRevistas.getSelectedItem());
            }

            if (BuscaAreaMenuRevistas.getSelectedItem() != null) {
                rev.setArea((String) BuscaAreaMenuRevistas.getSelectedItem());
            }

            //System.out.println(BuscaAreaMenuRevistas.getSelectedItem());*/
            ListaBuscaFuncionario = funcionarioDAO.ListaBuscaFuncionario(func);

            BuscaFuncionarioComFiltro();
            System.out.println("teste teste teste teste testes testes testes testes testes testes testes testes");

        } catch (Exception E) {
            System.out.println(E.getMessage());
            JOptionPane.showMessageDialog(null, "Problema no BotaoBuscaAlterarOuRemoverRevista do DashBoard, busca de revista falhou", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BotaoBuscaCliente2ActionPerformed

    private void TPesquisaProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TPesquisaProdutoMouseClicked
        TPesquisaProduto.getTableHeader().setReorderingAllowed(false);
        CampoIdProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 0).toString());
        CampoTipoProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 1).toString());
        CampoDescProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 2).toString());
        CampoDetalhesProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 3).toString());
        CampoMarcaProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 4).toString());
        CampoOrigemProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 5).toString());
        CampoCodigoDeBarrasProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 6).toString());
        CampoFabricanteProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 7).toString());
        CampoSetorProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 8).toString());
        CampoUnidadeDeMedidaProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 9).toString());
        CampoPesoProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 10).toString());
        CampoMedidasProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 11).toString());
        CampoFotoProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 12).toString());
        CampoEstoqueProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 13).toString());

        DestravaCamposProd();
        ChamadaTabelaProduto.dispose();
    }//GEN-LAST:event_TPesquisaProdutoMouseClicked

    private void BotaoBuscaCliente3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaCliente3ActionPerformed
        ListaBuscaProduto = null;
        ProdutoModel prod = new ProdutoModel();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        try {

            if (!BuscaProduto.getText().isEmpty()) {
                prod.setDescricao(BuscaProduto.getText());

                /*if (BuscaEspecificacaoMenuRevistas.getSelectedItem() != null) {
                    rev.setEspecificacao((String) BuscaEspecificacaoMenuRevistas.getSelectedItem());
                }

                if (BuscaAreaMenuRevistas.getSelectedItem() != null) {
                    rev.setArea((String) BuscaAreaMenuRevistas.getSelectedItem());
                }

                //System.out.println(BuscaAreaMenuRevistas.getSelectedItem());*/
                ListaBuscaProduto = produtoDAO.ListaBuscaProduto(prod);

                BuscaProdutoComFiltro();
            }
        } catch (Exception E) {
            System.out.println(E.getMessage());
            JOptionPane.showMessageDialog(null, "Problema no BotaoBuscaAlterarOuRemoverRevista do DashBoard, busca de revista falhou", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BotaoBuscaCliente3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAlteraCliente;
    private javax.swing.JButton BotaoAlteraProduto;
    private javax.swing.JButton BotaoAlterarFuncionario;
    private javax.swing.JButton BotaoBuscaCliente;
    private javax.swing.JButton BotaoBuscaCliente1;
    private javax.swing.JButton BotaoBuscaCliente2;
    private javax.swing.JButton BotaoBuscaCliente3;
    private javax.swing.JButton BotaoBuscaFunc;
    private javax.swing.JButton BotaoBuscaProduto;
    private javax.swing.JButton BotaoDesativaCliente;
    private javax.swing.JButton BotaoDesativaProduto;
    private javax.swing.JButton BotaoNovoCliente;
    private javax.swing.JButton BotaoNovoCliente9;
    private javax.swing.JButton BotaoNovoFunc;
    private javax.swing.JButton BotaoNovoProduto;
    private javax.swing.JButton BotaoSalvaCliente;
    private javax.swing.JButton BotaoSalvaCliente1;
    private javax.swing.JButton BotaoSalvaFunc;
    private javax.swing.JButton BotaoSalvaProduto;
    private javax.swing.JMenuItem BtnChamadaCliente;
    private javax.swing.JMenuItem BtnChamadaFuncionario;
    private javax.swing.JTextField BuscaCliente;
    private javax.swing.JTextField BuscaFuncionario;
    private javax.swing.JTextField BuscaProduto;
    private javax.swing.JTextField CampoBairroCliente;
    private javax.swing.JTextField CampoBairroFunc;
    private javax.swing.JTextField CampoCPFCliente;
    private javax.swing.JTextField CampoCPFFunc;
    private javax.swing.JTextField CampoCelularCliente;
    private javax.swing.JTextField CampoCelularFunc;
    private javax.swing.JTextField CampoCepCliente;
    private javax.swing.JTextField CampoCidadeCliente;
    private javax.swing.JTextField CampoCodigoDeBarrasProduto;
    private javax.swing.JTextField CampoComplementoCliente;
    private javax.swing.JTextField CampoContasCliente;
    private javax.swing.JTextField CampoDebitoCliente;
    private javax.swing.JTextField CampoDescProduto;
    private javax.swing.JTextField CampoDetalhesProduto;
    private javax.swing.JTextField CampoEmailCliente;
    private javax.swing.JTextField CampoEmailFunc;
    private javax.swing.JTextField CampoEnderecoCliente;
    private javax.swing.JTextField CampoEnderecoFunc;
    private javax.swing.JTextField CampoEstadoCliente;
    private javax.swing.JTextField CampoEstoqueProduto;
    private javax.swing.JTextField CampoFabricanteProduto;
    private javax.swing.JTextField CampoFotoProduto;
    private javax.swing.JTextField CampoIdCliente;
    private javax.swing.JTextField CampoIdFunc;
    private javax.swing.JTextField CampoIdProduto;
    private javax.swing.JTextField CampoMarcaProduto;
    private javax.swing.JTextField CampoMedidasProduto;
    private javax.swing.JTextField CampoNomeCliente;
    private javax.swing.JTextField CampoNomeFunc;
    private javax.swing.JTextField CampoNomeUsuarioFunc;
    private javax.swing.JTextField CampoNumeroCasaCliente;
    private javax.swing.JTextField CampoNumeroCasaFunc;
    private javax.swing.JTextField CampoOrigemProduto;
    private javax.swing.JTextField CampoPesoProduto;
    private javax.swing.JTextField CampoRGCliente;
    private javax.swing.JTextField CampoRGFunc;
    private javax.swing.JTextField CampoSenhaFunc;
    private javax.swing.JTextField CampoSetorProduto;
    private javax.swing.JTextField CampoTelefoneCliente;
    private javax.swing.JTextField CampoTelefoneFunc;
    private javax.swing.JTextField CampoTipoFunc;
    private javax.swing.JTextField CampoTipoProduto;
    private javax.swing.JTextField CampoUnidadeDeMedidaProduto;
    private javax.swing.JDialog ChamadaTabelaCliente;
    private javax.swing.JDialog ChamadaTabelaFuncionario;
    private javax.swing.JDialog ChamadaTabelaProduto;
    private javax.swing.JInternalFrame ClienteView;
    private javax.swing.JInternalFrame FuncionarioView;
    private javax.swing.JInternalFrame ProdutoView;
    private javax.swing.JTable TPesquisaProduto;
    private javax.swing.JTable TPesquisarCliente;
    private javax.swing.JTable TPesquisarFuncionario;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
