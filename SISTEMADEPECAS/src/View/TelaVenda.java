/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.ClienteDAO;
import DAO.ProdutoDAO;
import DAO.VendaDAO;
import Model.ClienteModel;
import Model.EntradaModel;
import Model.FornecedorDAO;
import Model.FornecedorModel;
import Model.ItensVendaModel;
import Model.ProdutoModel;
import Model.VendaModel;
import TableModel.TableModelVenda;
import com.lowagie.text.pdf.PdfName;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Natan Oliveira
 */
public class TelaVenda extends javax.swing.JInternalFrame {

    public static int quantidadeTotal;
    public static double valorTotal;
    public static int qtdProduto;
    ProdutoModel mProduto;
    VendaModel modelVenda;
    ItensVendaModel itensVenda;
    EntradaModel entradaModel;
    ClienteModel clienteModel;
    FornecedorModel fornecedorModel;
    TableModelVenda modeloVendas;
    ProdutoDAO produtoDAO;
    FornecedorDAO fornecedorDAO;
    VendaDAO vendaDAO;
    public static DecimalFormat dFormat;
    List<ClienteModel> ListaCliente;
    List<ClienteModel> ListaBuscaCliente;
    List<ProdutoModel> ListaProduto;
    List<ProdutoModel> ListaBuscaProduto;
    private int codigoCliente;
    
    /**
     * Creates new form TelaVenda
     */
    public TelaVenda() {
        initComponents();
        mProduto = new ProdutoModel();
        modeloVendas = new TableModelVenda();
        itensVenda = new ItensVendaModel();
        entradaModel = new EntradaModel();
        clienteModel = new ClienteModel();
        fornecedorModel = new FornecedorModel();
        produtoDAO = new ProdutoDAO();
        vendaDAO = new VendaDAO();
        fornecedorDAO = new FornecedorDAO();
        TxtUsuario.setEditable(false);
        TxtCliente.setBackground(Color.white);
        TxtUsuario.setBackground(Color.white);
        TxtDescricaoProduto.setEditable(false);
        TxtValorProduto.setEditable(false);
        TxtFornecedorProduto.setEditable(false);
        TxtUnidadeMedida.setEditable(false);
        TxtTipo.setEditable(false);
        TxtNomeProduto.setEditable(false);
        TxtQtdEstoqueProduto.setEditable(false);
        BttAlterar.setEnabled(false);
        BttCadastrar.setEnabled(false);
        BttCancelar.setEnabled(false);
        BttRemoverCliente.setEnabled(false);
        BttEditarCliente.setEnabled(false);
        TblProduto.setVisible(false);
        TxtQtdTotal.setEditable(false);
        TxtValorTotal.setEditable(false);
        TblProduto.setModel(modeloVendas);
        setVisiblePainel(false);
        TblProduto.getColumnModel().getColumn(0).setPreferredWidth(30);
        TblProduto.getColumnModel().getColumn(1).setPreferredWidth(200);
        TblProduto.getColumnModel().getColumn(2).setPreferredWidth(150);
        TblProduto.getColumnModel().getColumn(3).setPreferredWidth(150);
        TblProduto.getColumnModel().getColumn(4).setPreferredWidth(80);
        TblProduto.getColumnModel().getColumn(5).setPreferredWidth(40);
        TblProduto.getColumnModel().getColumn(6).setPreferredWidth(40);
        TblProduto.getColumnModel().getColumn(7).setPreferredWidth(40);
        TxtValorTotal.setHorizontalAlignment(JTextField.CENTER);
        TxtQtdTotal.setHorizontalAlignment(JTextField.CENTER);
        TxtCliente.setHorizontalAlignment(JTextField.CENTER);
        TxtUsuario.setHorizontalAlignment(JTextField.CENTER);
        dFormat = new DecimalFormat ( "#,###.00" );
    }
    
       public static boolean valData(String data) {
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6); 
        return !(Integer.parseInt(dia) > 31 || Integer.parseInt(mes) > 12 || Integer.parseInt(ano) < 1900 || Integer.parseInt(ano) > 2017);
    }
    
    public static String formataData (String data) {
        String dia = data.substring(0, 2);
        String mes = data.substring(3, 5);
        String ano = data.substring(6);
        String formatDate = ano + "-" + mes + "-" + dia;
        return formatDate;
    }
    
    public static String retornaData (String data) {
        String dia = data.substring(8);
        String mes = data.substring(5, 7);
        String ano = data.substring(0, 4);
        String formatDate = dia + "/" + mes + "/" + ano;
        return formatDate;
    }
    
    public static String getDateForDB () {
        Date data = new Date(System.currentTimeMillis());  
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd"); 
        return String.valueOf(formatarDate.format(data));
    }
    
    public String getDateForSystem () {
        Date data = new Date(System.currentTimeMillis());  
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
        return String.valueOf(formatarDate.format(data));
    }
    
    public Color setColorButton (JButton buttonColor, boolean setMouseIf) {
        Color cor;
        if (buttonColor.isEnabled() && setMouseIf)
            buttonColor.setBackground(cor = Color.lightGray);
        else
            buttonColor.setBackground(cor = Color.WHITE);
        return cor;
    }
    
    private void setVisiblePainel (boolean visibleOf) {
        PainelCliente.setVisible(visibleOf);
        PainelDireita.setVisible(visibleOf);
        PainelProduto.setVisible(visibleOf);
        PainelGrid.setVisible(visibleOf);
    }

    public void LimpaCamposProduto () {
        TxtCodigoProduto.setText("");
        TxtNomeProduto.setText("");
        TxtDescricaoProduto.setText("");
        TxtQtdEstoqueProduto.setText("");
        TxtFornecedorProduto.setText("");
        TxtTipo.setText("");
        TxtUnidadeMedida.setText("");
        TxtValorProduto.setText("");
        SpnQuantidadeProduto.setValue(0);
    }
    
    public void selecionaProduto () {
        if (TxtNomeProduto.getText().trim().isEmpty())
            JOptionPane.showMessageDialog(null, "Localize um produto para selecionar!");
        else
            if (verificaProdutoExistente())
                JOptionPane.showMessageDialog(null, "Este produto já foi adicionado!");
        else 
            if (Integer.parseInt(SpnQuantidadeProduto.getValue().toString()) < 1 
                    || Integer.parseInt(SpnQuantidadeProduto.getValue().toString()) > Integer.parseInt(TxtQtdEstoqueProduto.getText()))
                JOptionPane.showMessageDialog(null, "Quantidade Inválida!");
        else {
                mProduto.setQuantidade(Integer.parseInt(SpnQuantidadeProduto.getValue().toString()));
                quantidadeTotal += mProduto.getQuantidade();
                valorTotal += mProduto.getValor() * mProduto.getQuantidade();
                modeloVendas.addRow(mProduto);
                LimpaCamposProduto();
                TxtQtdTotal.setText(String.valueOf(quantidadeTotal));
                TxtValorTotal.setText(dFormat.format(valorTotal));
                TxtCodigoProduto.requestFocus();
        }
    }
    
    public boolean verificaProdutoExistente () {
        boolean existente = false;
        for (int i = 0; i < TblProduto.getRowCount(); i++) {
            if(Integer.parseInt(TblProduto.getValueAt(i, 0).toString()) == mProduto.getId()) {
                existente = true;
                break;
            }
        }
        return existente;
    }
    
    public void limpaCliente() {
        TxtCliente.setText("");
        BttRemoverCliente.setEnabled(false);
        BttEditarCliente.setEnabled(false);
        BttPesquisarClientes.setEnabled(true);
    }
    public void preencherProdutoId (int id) {
        //try {
            //mProduto = ;
            if (mProduto == null)
                JOptionPane.showMessageDialog(null, "Produto não localizado!");
            else {
                TxtNomeProduto.setText(mProduto.getDescricao());
                TxtDescricaoProduto.setText(mProduto.getDetalhes());
                TxtQtdEstoqueProduto.setText(String.valueOf(mProduto.getEstoque()));
                TxtTipo.setText(mProduto.getTipo());
                TxtUnidadeMedida.setText(mProduto.getUnitMedida());
                SpnQuantidadeProduto.requestFocus();
            }                
        /*} catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro! Não foi possível realizar esta tarefa.");
        }*/
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
            "Email", "Vencimento", "Debito", "Ativo",};

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
            "fabricante", "setor", "unidade_medida", "peso", "medidas", "foto", "estoque", "ativo", "Quantidade", "Valor"};
        DefaultTableModel tabelaCliente = new DefaultTableModel();
        tabelaCliente.setDataVector(dados, tituloColuna);
        TPesquisaProduto.setModel(new DefaultTableModel(dados, tituloColuna) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        String dados[][] = new String[ListaBuscaProduto.size()][16];
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
            dados[i][15] = String.valueOf(prodM.getValor());

            i++;
        }
        String tituloColuna[] = {"id", "tipo", "descricao", "detalhes", "marca", "origem", "codigo_de_barras",
            "fabricante", "setor", "unidade_medida", "peso", "medidas", "foto", "estoque", "ativo", "valor"};
        DefaultTableModel tabelaCliente = new DefaultTableModel();
        tabelaCliente.setDataVector(dados, tituloColuna);
        TPesquisaProduto.setModel(new DefaultTableModel(dados, tituloColuna) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};

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
        mProduto = prod;
    }
    
    public void verificaSalvar () {
        int linhaSelecionada = TblProduto.getRowCount();
        if (linhaSelecionada == 0)
            JOptionPane.showMessageDialog(null, "Adicione produtos para finalizar a venda!");
        else {
            if (JOptionPane.showConfirmDialog(null, "Deseja realmente finalizar a venda?") == 0)
                salvar();
        }
    }
    
    public void salvar () {
        //if ((limiteCliente - debitoCliente) < valorTotal && ! TxtCliente.getText().trim().isEmpty() && vConfirmarVenda.formaPagamento == 2)
        //JOptionPane.showMessageDialog(null, "O cliente não possui limite suficiente para finalizar a compra no crediário!");
        //else {
        cadastrarVenda();
        cadastrarItens();
        prepareNovaVenda();
        // }
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
    
    public ProdutoModel cadastrarVenda () {
        int estoquenovo;
        try {
            modelVenda = new VendaModel();
            modelVenda.setData(getDateForDB());
            modelVenda.setValorTotal(valorTotal);
            modelVenda.setIdFuncionario(1);
            if (! TxtCliente.getText().trim().equals("")) 
                modelVenda.setIdCliente(codigoCliente);
            else 
                modelVenda.setIdCliente(1);
            for (int i = 0; i < TblProduto.getRowCount(); i++) {
                mProduto = modeloVendas.getDados().get(i);
                estoquenovo = (mProduto.getEstoque() - mProduto.getQuantidade());
                System.out.println(mProduto.getId() + "  " + estoquenovo);
                produtoDAO.baixaEstoque(mProduto.getId(), estoquenovo);
                System.out.println(mProduto.getId());
            }
            vendaDAO.Salvar(modelVenda);
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERRO! Não foi possível realizar a venda!");
            e.printStackTrace();
        }
        return mProduto;
    }
    
    public void cadastrarItens () {
        mProduto = null;
        try {
            for (int i = 0; i < TblProduto.getRowCount(); i++) {
                mProduto = modeloVendas.getDados().get(i);
                itensVenda.setValorProduto(entradaModel.getValor());
                itensVenda.setQuantidadeProduto(mProduto.getQuantidade());
                itensVenda.setIdProduto(mProduto.getId());
                vendaDAO.SalvarItens(itensVenda);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro! Não foi possível cadastrar os itens.");
        }
    }
    
    public void prepareNovaVenda () {
        LimpaCamposProduto();
        modeloVendas.removeAllRows();
        setVisiblePainel(false);
        BttCadastrar.setEnabled(false);
        BttNovo.setEnabled(true);
        BttPesquisarClientes.setEnabled(true);
        BttEditarCliente.setEnabled(false);
        BttRemoverCliente.setEnabled(false);
        valorTotal = 0;
        quantidadeTotal = 0;
        clienteModel = null;
        mProduto = null;
        TxtCliente.setText("");
        TxtValorTotal.setText("");
        TxtQtdTotal.setText("");
    }
    
    public void insereProduto (ProdutoModel p) {
            TxtCodigoProduto.setText(String.valueOf(p.getId()));
            TxtNomeProduto.setText(p.getDescricao());
            TxtDescricaoProduto.setText(p.getDetalhes());
            TxtQtdEstoqueProduto.setText(String.valueOf(p.getEstoque()));
            TxtFornecedorProduto.setText(p.getFabricante());
            TxtUnidadeMedida.setText(p.getUnitMedida());
            TxtTipo.setText(p.getTipo());
            TxtValorProduto.setText(dFormat.format(entradaModel.getValor()));
            mProduto = p;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChamadaTabelaCliente = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        BotaoBuscaCliente1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TPesquisarCliente = new javax.swing.JTable();
        BuscaCliente = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        ChamadaTabelaProduto = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TPesquisaProduto = new javax.swing.JTable();
        BotaoBuscaCliente3 = new javax.swing.JButton();
        BuscaProduto = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        PainelProduto = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        TxtCodigoProduto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TxtNomeProduto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        TxtValorProduto = new javax.swing.JTextField();
        BttLocalizar = new javax.swing.JButton();
        BttSelecionar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        TxtQtdEstoqueProduto = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        SpnQuantidadeProduto = new javax.swing.JSpinner();
        BttLimparProdutos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtDescricaoProduto = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        lImage = new javax.swing.JLabel();
        TxtFornecedorProduto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        TxtUnidadeMedida = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        TxtTipo = new javax.swing.JTextField();
        PainelGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblProduto = new javax.swing.JTable();
        BttRemoveLinha = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        BttNovo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BttAlterar = new javax.swing.JButton();
        BttCadastrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BttCancelar = new javax.swing.JButton();
        BttRelatorio = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        PainelDireita = new javax.swing.JPanel();
        BttPesquisarProduto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        TxtQtdTotal = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        TxtValorTotal = new javax.swing.JTextField();
        BttCadastrar2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        PainelCliente = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        TxtCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtUsuario = new javax.swing.JTextField();
        BttPesquisarClientes = new javax.swing.JLabel();
        BttRemoverCliente = new javax.swing.JLabel();
        BttEditarCliente = new javax.swing.JLabel();

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
        jScrollPane3.setViewportView(TPesquisarCliente);

        BuscaCliente.setMinimumSize(new java.awt.Dimension(8, 20));
        BuscaCliente.setPreferredSize(new java.awt.Dimension(8, 20));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel48.setText("Tela de pesquisa de Cliente:");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setText("Insira um nome");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel48)
                    .addComponent(jLabel49)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(BuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BotaoBuscaCliente1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoBuscaCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout ChamadaTabelaClienteLayout = new javax.swing.GroupLayout(ChamadaTabelaCliente.getContentPane());
        ChamadaTabelaCliente.getContentPane().setLayout(ChamadaTabelaClienteLayout);
        ChamadaTabelaClienteLayout.setHorizontalGroup(
            ChamadaTabelaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ChamadaTabelaClienteLayout.setVerticalGroup(
            ChamadaTabelaClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ChamadaTabelaProduto.setMinimumSize(new java.awt.Dimension(850, 500));

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
        jScrollPane4.setViewportView(TPesquisaProduto);

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

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Insira um produto!");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel29.setText("Tela de pesquisa de produto:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel19)
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
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BuscaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoBuscaCliente3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        PainelProduto.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        PainelProduto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));

        jLabel9.setText("Código do Produto");

        TxtCodigoProduto.setEditable(false);
        TxtCodigoProduto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TxtCodigoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtCodigoProdutoKeyPressed(evt);
            }
        });

        jLabel10.setText("Nome do Produto");

        TxtNomeProduto.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        TxtNomeProduto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TxtNomeProduto.setForeground(new java.awt.Color(95, 106, 138));

        jLabel11.setText("Descrição do Produto");

        jLabel13.setText("Valor UN. R$");

        TxtValorProduto.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        TxtValorProduto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TxtValorProduto.setForeground(new java.awt.Color(95, 106, 138));

        BttLocalizar.setBackground(new java.awt.Color(255, 255, 255));
        BttLocalizar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BttLocalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complements/magnifier (1).png"))); // NOI18N
        BttLocalizar.setText("Localizar");
        BttLocalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BttLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttLocalizarActionPerformed(evt);
            }
        });
        BttLocalizar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BttLocalizarKeyPressed(evt);
            }
        });

        BttSelecionar.setBackground(new java.awt.Color(255, 255, 255));
        BttSelecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complements/thumb-up-black-hand-symbol.png"))); // NOI18N
        BttSelecionar.setText("Selecionar");
        BttSelecionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BttSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttSelecionarActionPerformed(evt);
            }
        });

        jLabel17.setText("Qtd. Estoque");

        TxtQtdEstoqueProduto.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        TxtQtdEstoqueProduto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TxtQtdEstoqueProduto.setForeground(new java.awt.Color(255, 153, 102));
        TxtQtdEstoqueProduto.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel18.setText("Selecionar Qtde.:");

        SpnQuantidadeProduto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SpnQuantidadeProduto.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        SpnQuantidadeProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SpnQuantidadeProdutoKeyPressed(evt);
            }
        });

        BttLimparProdutos.setBackground(new java.awt.Color(255, 255, 255));
        BttLimparProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complements/office-material.png"))); // NOI18N
        BttLimparProdutos.setText("Limpar");
        BttLimparProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BttLimparProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttLimparProdutosActionPerformed(evt);
            }
        });

        TxtDescricaoProduto.setEditable(false);
        TxtDescricaoProduto.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        TxtDescricaoProduto.setColumns(20);
        TxtDescricaoProduto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TxtDescricaoProduto.setForeground(new java.awt.Color(95, 106, 138));
        TxtDescricaoProduto.setRows(5);
        TxtDescricaoProduto.setBorder(null);
        TxtDescricaoProduto.setCaretColor(new java.awt.Color(215, 217, 228));
        jScrollPane2.setViewportView(TxtDescricaoProduto);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        lImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\Natan Oliveira\\Desktop\\image.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lImage)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lImage, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TxtFornecedorProduto.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        TxtFornecedorProduto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TxtFornecedorProduto.setForeground(new java.awt.Color(95, 106, 138));

        jLabel12.setText("Fabricante");

        jLabel15.setText("Unidade de Medida");

        TxtUnidadeMedida.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        TxtUnidadeMedida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TxtUnidadeMedida.setForeground(new java.awt.Color(95, 106, 138));

        jLabel14.setText("Tipo");

        TxtTipo.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        TxtTipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TxtTipo.setForeground(new java.awt.Color(95, 106, 138));

        javax.swing.GroupLayout PainelProdutoLayout = new javax.swing.GroupLayout(PainelProduto);
        PainelProduto.setLayout(PainelProdutoLayout);
        PainelProdutoLayout.setHorizontalGroup(
            PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PainelProdutoLayout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addGap(372, 372, 372)))
                    .addGroup(PainelProdutoLayout.createSequentialGroup()
                        .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(TxtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelProdutoLayout.createSequentialGroup()
                                .addComponent(TxtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelProdutoLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(167, 167, 167)))
                        .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(TxtValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PainelProdutoLayout.createSequentialGroup()
                        .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtFornecedorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(TxtUnidadeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(TxtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PainelProdutoLayout.createSequentialGroup()
                        .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtQtdEstoqueProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SpnQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelProdutoLayout.createSequentialGroup()
                        .addComponent(BttLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BttSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BttLimparProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PainelProdutoLayout.setVerticalGroup(
            PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelProdutoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PainelProdutoLayout.createSequentialGroup()
                        .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13))
                        .addGap(2, 2, 2)
                        .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(jLabel15))
                            .addComponent(jLabel12))
                        .addGap(5, 5, 5)
                        .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtFornecedorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtUnidadeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelProdutoLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BttLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BttSelecionar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BttLimparProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PainelProdutoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelProdutoLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(PainelProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SpnQuantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PainelProdutoLayout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtQtdEstoqueProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PainelGrid.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        PainelGrid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        PainelGrid.setForeground(new java.awt.Color(204, 204, 204));

        TblProduto.setBackground(new java.awt.Color(153, 153, 153));
        TblProduto.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TblProduto.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        TblProduto.setForeground(new java.awt.Color(255, 255, 255));
        TblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TblProduto);

        BttRemoveLinha.setBackground(new java.awt.Color(255, 255, 255));
        BttRemoveLinha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BttRemoveLinha.setForeground(new java.awt.Color(102, 102, 102));
        BttRemoveLinha.setText("Remover Produto");
        BttRemoveLinha.setToolTipText("Clique para remover um produto na tabela!");
        BttRemoveLinha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        BttRemoveLinha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BttRemoveLinha.setOpaque(false);
        BttRemoveLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttRemoveLinhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelGridLayout = new javax.swing.GroupLayout(PainelGrid);
        PainelGrid.setLayout(PainelGridLayout);
        PainelGridLayout.setHorizontalGroup(
            PainelGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelGridLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(PainelGridLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BttRemoveLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PainelGridLayout.setVerticalGroup(
            PainelGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BttRemoveLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(235, 238, 243));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));

        BttNovo.setBackground(new java.awt.Color(255, 255, 255));
        BttNovo.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        BttNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complements/new-commercial-label.png"))); // NOI18N
        BttNovo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        BttNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BttNovo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BttNovoMouseMoved(evt);
            }
        });
        BttNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BttNovoMouseExited(evt);
            }
        });
        BttNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttNovoActionPerformed(evt);
            }
        });
        BttNovo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BttNovoKeyPressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel2.setText("Novo");

        BttAlterar.setBackground(new java.awt.Color(255, 255, 255));
        BttAlterar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        BttAlterar.setForeground(new java.awt.Color(153, 153, 153));
        BttAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complements/pencil-striped-symbol-for-interface-edit-buttons (3).png"))); // NOI18N
        BttAlterar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        BttAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BttAlterar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BttAlterarMouseMoved(evt);
            }
        });
        BttAlterar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BttAlterarBttNovoFocusGained(evt);
            }
        });
        BttAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BttAlterarMouseExited(evt);
            }
        });

        BttCadastrar.setBackground(new java.awt.Color(255, 255, 255));
        BttCadastrar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        BttCadastrar.setForeground(new java.awt.Color(153, 153, 153));
        BttCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complements/checklist-checked-box (1).png"))); // NOI18N
        BttCadastrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        BttCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BttCadastrar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BttCadastrarMouseMoved(evt);
            }
        });
        BttCadastrar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BttCadastrarBttNovoFocusGained(evt);
            }
        });
        BttCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BttCadastrarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BttCadastrarMousePressed(evt);
            }
        });
        BttCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttCadastrarActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel4.setText("Cancelar");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel5.setText("Finalizar");

        BttCancelar.setBackground(new java.awt.Color(255, 255, 255));
        BttCancelar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        BttCancelar.setForeground(new java.awt.Color(153, 153, 153));
        BttCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complements/recycle-bin.png"))); // NOI18N
        BttCancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        BttCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BttCancelar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BttCancelarMouseMoved(evt);
            }
        });
        BttCancelar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BttCancelarBttNovoFocusGained(evt);
            }
        });
        BttCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BttCancelarMouseExited(evt);
            }
        });
        BttCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttCancelarActionPerformed(evt);
            }
        });

        BttRelatorio.setBackground(new java.awt.Color(255, 255, 255));
        BttRelatorio.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        BttRelatorio.setForeground(new java.awt.Color(153, 153, 153));
        BttRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complements/edit-document.png"))); // NOI18N
        BttRelatorio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        BttRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BttRelatorio.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BttRelatorioMouseMoved(evt);
            }
        });
        BttRelatorio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BttRelatorioBttNovoFocusGained(evt);
            }
        });
        BttRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BttRelatorioMouseExited(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel6.setText("Relatórios");

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("Vendas");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel3.setText("Alterar");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complements/power.png"))); // NOI18N
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setOpaque(false);
        jButton2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jButton2MouseMoved(evt);
            }
        });
        jButton2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton2FocusGained(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton5.setToolTipText("\"Pesquisar Vendas\"");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BttNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BttAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(69, 69, 69))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(BttCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BttCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BttRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BttRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BttCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BttCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BttNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BttAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        PainelDireita.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        PainelDireita.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));

        BttPesquisarProduto.setBackground(new java.awt.Color(255, 255, 255));
        BttPesquisarProduto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BttPesquisarProduto.setText("Pesquisar Produto");
        BttPesquisarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttPesquisarProdutoActionPerformed(evt);
            }
        });

        jPanel2.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true), "Qtde. de Itens Selecionados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        TxtQtdTotal.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        TxtQtdTotal.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        TxtQtdTotal.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxtQtdTotal)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxtQtdTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true), "Valor Total (R$). ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        TxtValorTotal.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        TxtValorTotal.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        TxtValorTotal.setForeground(new java.awt.Color(51, 102, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxtValorTotal)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxtValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );

        BttCadastrar2.setBackground(new java.awt.Color(255, 255, 255));
        BttCadastrar2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        BttCadastrar2.setForeground(new java.awt.Color(116, 191, 90));
        BttCadastrar2.setText("Finalizar");
        BttCadastrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BttCadastrar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelDireitaLayout = new javax.swing.GroupLayout(PainelDireita);
        PainelDireita.setLayout(PainelDireitaLayout);
        PainelDireitaLayout.setHorizontalGroup(
            PainelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelDireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BttCadastrar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BttPesquisarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PainelDireitaLayout.setVerticalGroup(
            PainelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelDireitaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BttPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(BttCadastrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        PainelCliente.setBackground(new java.awt.Color(255, 255, 255));
        PainelCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        jLabel7.setFont(new java.awt.Font("Pristina", 1, 28)); // NOI18N
        jLabel7.setText("Usuário:");

        TxtCliente.setEditable(false);
        TxtCliente.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        TxtCliente.setForeground(new java.awt.Color(0, 153, 255));
        TxtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtClienteActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Pristina", 1, 28)); // NOI18N
        jLabel8.setText("Cliente:");

        TxtUsuario.setEditable(false);
        TxtUsuario.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        TxtUsuario.setForeground(new java.awt.Color(0, 153, 255));

        BttPesquisarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complements/magnifier (1).png"))); // NOI18N
        BttPesquisarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BttPesquisarClientes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BttPesquisarClientesMouseMoved(evt);
            }
        });
        BttPesquisarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BttPesquisarClientesMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BttPesquisarClientesMouseExited(evt);
            }
        });
        BttPesquisarClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BttPesquisarClientesKeyPressed(evt);
            }
        });

        BttRemoverCliente.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        BttRemoverCliente.setForeground(new java.awt.Color(255, 0, 51));
        BttRemoverCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complements/office-material.png"))); // NOI18N
        BttRemoverCliente.setToolTipText("Remover Cliente");
        BttRemoverCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BttRemoverCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BttRemoverClienteMouseClicked(evt);
            }
        });

        BttEditarCliente.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        BttEditarCliente.setForeground(new java.awt.Color(255, 0, 51));
        BttEditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Complements/pencil-striped-symbol-for-interface-edit-buttons (2).png"))); // NOI18N
        BttEditarCliente.setToolTipText("Editar Dados do Cliente\n");
        BttEditarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BttEditarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BttEditarClienteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PainelClienteLayout = new javax.swing.GroupLayout(PainelCliente);
        PainelCliente.setLayout(PainelClienteLayout);
        PainelClienteLayout.setHorizontalGroup(
            PainelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelClienteLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 363, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BttPesquisarClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BttRemoverCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BttEditarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        PainelClienteLayout.setVerticalGroup(
            PainelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PainelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PainelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TxtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PainelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BttRemoverCliente)
                            .addComponent(BttEditarCliente)))
                    .addComponent(BttPesquisarClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PainelGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PainelProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PainelDireita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PainelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PainelGrid, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PainelProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(PainelDireita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtCodigoProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCodigoProdutoKeyPressed
 
    }//GEN-LAST:event_TxtCodigoProdutoKeyPressed

    private void BttLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttLocalizarActionPerformed
        /*if (TxtCodigoProduto.getText().trim().equals(""))
        JOptionPane.showMessageDialog(null, "Insira o código para pesquisar");
        else
        preencherProdutoId(Integer.parseInt(TxtCodigoProduto.getText()));*/
    }//GEN-LAST:event_BttLocalizarActionPerformed

    private void BttLocalizarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BttLocalizarKeyPressed

    }//GEN-LAST:event_BttLocalizarKeyPressed

    private void BttSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttSelecionarActionPerformed
        selecionaProduto();
    }//GEN-LAST:event_BttSelecionarActionPerformed

    private void SpnQuantidadeProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SpnQuantidadeProdutoKeyPressed
        
    }//GEN-LAST:event_SpnQuantidadeProdutoKeyPressed

    private void BttLimparProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttLimparProdutosActionPerformed
        //LimpaCamposProduto();
    }//GEN-LAST:event_BttLimparProdutosActionPerformed

    private void BttRemoveLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttRemoveLinhaActionPerformed
        int linhaSelecionada = TblProduto.getSelectedRow();
        if (linhaSelecionada == -1)
        JOptionPane.showMessageDialog(null, "Selecione um produto na tabela para remover!");
        else {
            valorTotal -= Double.parseDouble(modeloVendas.getValueAt(linhaSelecionada, 3).toString())
            * Double.parseDouble(modeloVendas.getValueAt(linhaSelecionada, 4).toString()) ;
            quantidadeTotal -=   Double.parseDouble(modeloVendas.getValueAt(linhaSelecionada, 4).toString());
            TxtQtdTotal.setText(String.valueOf(quantidadeTotal));
            //TxtValorTotal.setText(dFormat.format(valorTotal));
            modeloVendas.removeSlctRow(linhaSelecionada);
        }
    }//GEN-LAST:event_BttRemoveLinhaActionPerformed

    private void BttNovoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BttNovoMouseMoved
        setColorButton(BttNovo, true);
    }//GEN-LAST:event_BttNovoMouseMoved

    private void BttNovoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BttNovoMouseExited
        setColorButton(BttNovo, false);
    }//GEN-LAST:event_BttNovoMouseExited

    private void BttNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttNovoActionPerformed
        valorTotal = 0;
        quantidadeTotal = 0;
        setVisiblePainel(true);
        TblProduto.setVisible(true);
        BttNovo.setEnabled(false);
        BttCancelar.setEnabled(true);
        BttCadastrar.setEnabled(true);
        BttPesquisarClientes.requestFocus();
    }//GEN-LAST:event_BttNovoActionPerformed

    private void BttNovoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BttNovoKeyPressed
       
    }//GEN-LAST:event_BttNovoKeyPressed

    private void BttAlterarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BttAlterarMouseMoved
        setColorButton(BttAlterar, true);
    }//GEN-LAST:event_BttAlterarMouseMoved

    private void BttAlterarBttNovoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BttAlterarBttNovoFocusGained

    }//GEN-LAST:event_BttAlterarBttNovoFocusGained

    private void BttAlterarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BttAlterarMouseExited
        setColorButton(BttAlterar, false);
    }//GEN-LAST:event_BttAlterarMouseExited

    private void BttCadastrarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BttCadastrarMouseMoved
        setColorButton(BttCadastrar, true);
    }//GEN-LAST:event_BttCadastrarMouseMoved

    private void BttCadastrarBttNovoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BttCadastrarBttNovoFocusGained

    }//GEN-LAST:event_BttCadastrarBttNovoFocusGained

    private void BttCadastrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BttCadastrarMouseExited
        setColorButton(BttCadastrar, false);
    }//GEN-LAST:event_BttCadastrarMouseExited

    private void BttCadastrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BttCadastrarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BttCadastrarMousePressed

    private void BttCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttCadastrarActionPerformed
        //verificaSalvar();
    }//GEN-LAST:event_BttCadastrarActionPerformed

    private void BttCancelarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BttCancelarMouseMoved
        setColorButton(BttCancelar, true);
    }//GEN-LAST:event_BttCancelarMouseMoved

    private void BttCancelarBttNovoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BttCancelarBttNovoFocusGained

    }//GEN-LAST:event_BttCancelarBttNovoFocusGained

    private void BttCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BttCancelarMouseExited
        setColorButton(BttCancelar, false);
    }//GEN-LAST:event_BttCancelarMouseExited

    private void BttCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttCancelarActionPerformed
        LimpaCamposProduto();
        modeloVendas.removeAllRows();
        TxtValorTotal.setText("");
        TxtQtdTotal.setText("");
        setVisiblePainel(false);
        BttNovo.setEnabled(true);
        BttCadastrar.setEnabled(false);
        BttCancelar.setEnabled(false);
        valorTotal = 0;
        quantidadeTotal = 0;
        TxtCliente.setText("");
        BttNovo.requestFocus();
        BttPesquisarClientes.setEnabled(true);
        BttRemoverCliente.setEnabled(false);
        BttEditarCliente.setEnabled(false);
    }//GEN-LAST:event_BttCancelarActionPerformed

    private void BttRelatorioMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BttRelatorioMouseMoved
        setColorButton(BttRelatorio, true);
    }//GEN-LAST:event_BttRelatorioMouseMoved

    private void BttRelatorioBttNovoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BttRelatorioBttNovoFocusGained

    }//GEN-LAST:event_BttRelatorioBttNovoFocusGained

    private void BttRelatorioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BttRelatorioMouseExited
        setColorButton(BttRelatorio, false);
    }//GEN-LAST:event_BttRelatorioMouseExited

    private void jButton2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseMoved
        jButton2.setToolTipText("Sair");
    }//GEN-LAST:event_jButton2MouseMoved

    private void jButton2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton2FocusGained
        BttNovo.requestFocus();
    }//GEN-LAST:event_jButton2FocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        valorTotal = 0;
        quantidadeTotal = 0;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void BttPesquisarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttPesquisarProdutoActionPerformed
        ChamadaTabelaProduto.setVisible(true);
    }//GEN-LAST:event_BttPesquisarProdutoActionPerformed

    private void BttCadastrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BttCadastrar2ActionPerformed
        verificaSalvar();
    }//GEN-LAST:event_BttCadastrar2ActionPerformed

    private void TxtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtClienteActionPerformed

    private void BttPesquisarClientesMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BttPesquisarClientesMouseMoved
        BttPesquisarClientes.setToolTipText("Localizar Cliente");
        BttPesquisarClientes.setBackground(Color.lightGray);
    }//GEN-LAST:event_BttPesquisarClientesMouseMoved

    private void BttPesquisarClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BttPesquisarClientesMouseClicked
        ChamadaTabelaCliente.setVisible(true);
    }//GEN-LAST:event_BttPesquisarClientesMouseClicked

    private void BttPesquisarClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BttPesquisarClientesMouseExited
        BttPesquisarClientes.setBackground(Color.white);
    }//GEN-LAST:event_BttPesquisarClientesMouseExited

    private void BttPesquisarClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BttPesquisarClientesKeyPressed
        
    }//GEN-LAST:event_BttPesquisarClientesKeyPressed

    private void BttRemoverClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BttRemoverClienteMouseClicked
        if (BttRemoverCliente.isEnabled())
        limpaCliente();
    }//GEN-LAST:event_BttRemoverClienteMouseClicked

    private void BttEditarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BttEditarClienteMouseClicked
        
    }//GEN-LAST:event_BttEditarClienteMouseClicked

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

        } catch (SQLException ex) {

        }
    }//GEN-LAST:event_BotaoBuscaCliente1ActionPerformed

    private void TPesquisarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TPesquisarClienteMouseClicked
        TPesquisarCliente.getTableHeader().setReorderingAllowed(false);
        TxtCliente.setText(TPesquisarCliente.getValueAt(TPesquisarCliente.getSelectedRow(), 1).toString());

        ChamadaTabelaCliente.dispose();
    }//GEN-LAST:event_TPesquisarClienteMouseClicked

    private void TPesquisaProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TPesquisaProdutoMouseClicked
        TPesquisaProduto.getTableHeader().setReorderingAllowed(false);
        TxtCodigoProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 0).toString());
        TxtTipo.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 1).toString());
        TxtNomeProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 2).toString());
        TxtDescricaoProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 3).toString());
        TxtUnidadeMedida.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 9).toString());
        TxtFornecedorProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 7).toString());
        TxtQtdEstoqueProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 13).toString());
        TxtValorProduto.setText(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 15).toString());
        mProduto.setId(Integer.parseInt(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 0).toString()));
        mProduto.setDescricao(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 2).toString());
        mProduto.setDetalhes(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 3).toString());
        mProduto.setMarca(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 4).toString());
        mProduto.setFabricante(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 7).toString());
        mProduto.setUnitMedida(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 9).toString());
        mProduto.setValor(Double.parseDouble(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 15).toString()));
        mProduto.setEstoque(Integer.parseInt(TPesquisaProduto.getValueAt(TPesquisaProduto.getSelectedRow(), 13).toString()));
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

                System.out.println(BuscaAreaMenuRevistas.getSelectedItem());*/
                ListaBuscaProduto = produtoDAO.ListaBuscaProduto(prod);
                
                BuscaProdutoComFiltro();
            }
        } catch (Exception E) {
            System.out.println(E.getMessage());
            JOptionPane.showMessageDialog(null, "Problema no BotaoBuscaAlterarOuRemoverRevista do DashBoard, busca de revista falhou", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BotaoBuscaCliente3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoBuscaCliente1;
    private javax.swing.JButton BotaoBuscaCliente3;
    private javax.swing.JButton BttAlterar;
    private javax.swing.JButton BttCadastrar;
    private javax.swing.JButton BttCadastrar2;
    private javax.swing.JButton BttCancelar;
    private javax.swing.JLabel BttEditarCliente;
    private javax.swing.JButton BttLimparProdutos;
    private javax.swing.JButton BttLocalizar;
    private javax.swing.JButton BttNovo;
    private javax.swing.JLabel BttPesquisarClientes;
    private javax.swing.JButton BttPesquisarProduto;
    private javax.swing.JButton BttRelatorio;
    private javax.swing.JButton BttRemoveLinha;
    private javax.swing.JLabel BttRemoverCliente;
    private javax.swing.JButton BttSelecionar;
    private javax.swing.JTextField BuscaCliente;
    private javax.swing.JTextField BuscaProduto;
    private javax.swing.JDialog ChamadaTabelaCliente;
    private javax.swing.JDialog ChamadaTabelaProduto;
    private javax.swing.JPanel PainelCliente;
    private javax.swing.JPanel PainelDireita;
    private javax.swing.JPanel PainelGrid;
    private javax.swing.JPanel PainelProduto;
    private javax.swing.JSpinner SpnQuantidadeProduto;
    private javax.swing.JTable TPesquisaProduto;
    private javax.swing.JTable TPesquisarCliente;
    private javax.swing.JTable TblProduto;
    private javax.swing.JTextField TxtCliente;
    private javax.swing.JTextField TxtCodigoProduto;
    private javax.swing.JTextArea TxtDescricaoProduto;
    private javax.swing.JTextField TxtFornecedorProduto;
    private javax.swing.JTextField TxtNomeProduto;
    private javax.swing.JTextField TxtQtdEstoqueProduto;
    private javax.swing.JTextField TxtQtdTotal;
    private javax.swing.JTextField TxtTipo;
    private javax.swing.JTextField TxtUnidadeMedida;
    private javax.swing.JTextField TxtUsuario;
    private javax.swing.JTextField TxtValorProduto;
    private javax.swing.JTextField TxtValorTotal;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lImage;
    // End of variables declaration//GEN-END:variables
}
