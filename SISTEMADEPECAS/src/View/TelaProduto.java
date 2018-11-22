/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.FuncionarioDAO;
import DAO.ProdutoDAO;
import Model.FuncionarioModel;
import Model.ProdutoModel;
import com.lowagie.text.DocumentException;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Real
 */
public class TelaProduto extends javax.swing.JInternalFrame {

    List<ProdutoModel> ListaProduto;
    List<ProdutoModel> ListaBuscaProduto;

    /**
     * Creates new form TelaProduto
     */
    public TelaProduto() {
        initComponents();
        TravaCamposProd();
        atualizarTabelaProduto();
    }

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
    
    /*public void TravaTudoProd() {
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
    }*/
    
    
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChamadaTabelaProduto = new javax.swing.JDialog();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TPesquisaProduto = new javax.swing.JTable();
        BotaoBuscaCliente3 = new javax.swing.JButton();
        BuscaProduto = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
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
        BotaoLimpaProduto = new javax.swing.JButton();
        BotaoRelatorioProduto = new javax.swing.JButton();

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

        setClosable(true);

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

        BotaoLimpaProduto.setBackground(new java.awt.Color(255, 255, 255));
        BotaoLimpaProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoLimpaProduto.setText("Limpar");
        BotaoLimpaProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoLimpaProduto.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoLimpaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoLimpaProdutoActionPerformed(evt);
            }
        });

        BotaoRelatorioProduto.setBackground(new java.awt.Color(255, 255, 255));
        BotaoRelatorioProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoRelatorioProduto.setText("Relatorio");
        BotaoRelatorioProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoRelatorioProduto.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoRelatorioProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRelatorioProdutoActionPerformed(evt);
            }
        });

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
                                .addComponent(BotaoRelatorioProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotaoLimpaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotaoLimpaProduto)
                        .addComponent(BotaoRelatorioProduto))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotaoSalvaProduto)
                        .addComponent(BotaoAlteraProduto)
                        .addComponent(BotaoDesativaProduto)))
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void BotaoNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoProdutoActionPerformed
        DestravaCamposProd();
        LimpaCamposProd();
        CampoIdProduto.setEnabled(false);  
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
                
                 BotaoAlteraProduto.setEnabled(true);
                 BotaoDesativaProduto.setEnabled(true);
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

    private void BotaoLimpaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoLimpaProdutoActionPerformed
        LimpaCamposProd();
        BotaoAlteraProduto.setEnabled(true);
    }//GEN-LAST:event_BotaoLimpaProdutoActionPerformed

    private void BotaoRelatorioProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRelatorioProdutoActionPerformed
        String nomediretorio = null;
        ProdutoDAO produtoDAO = new ProdutoDAO();
        String nomepasta = "SRS";
        // Informe o nome da pasta que armazenará o relatório
        String separador = java.io.File.separator;
        try {
            nomediretorio = "C:" + separador + nomepasta;
            if (!new File(nomediretorio).exists()) {
                (new File(nomediretorio)).mkdir();
            }
            produtoDAO.RelatorioProduto();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BotaoRelatorioProdutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAlteraProduto;
    private javax.swing.JButton BotaoBuscaCliente3;
    private javax.swing.JButton BotaoBuscaProduto;
    private javax.swing.JButton BotaoDesativaProduto;
    private javax.swing.JButton BotaoLimpaProduto;
    private javax.swing.JButton BotaoNovoProduto;
    private javax.swing.JButton BotaoRelatorioProduto;
    private javax.swing.JButton BotaoSalvaProduto;
    private javax.swing.JTextField BuscaProduto;
    private javax.swing.JTextField CampoCodigoDeBarrasProduto;
    private javax.swing.JTextField CampoDescProduto;
    private javax.swing.JTextField CampoDetalhesProduto;
    private javax.swing.JTextField CampoEstoqueProduto;
    private javax.swing.JTextField CampoFabricanteProduto;
    private javax.swing.JTextField CampoFotoProduto;
    private javax.swing.JTextField CampoIdProduto;
    private javax.swing.JTextField CampoMarcaProduto;
    private javax.swing.JTextField CampoMedidasProduto;
    private javax.swing.JTextField CampoOrigemProduto;
    private javax.swing.JTextField CampoPesoProduto;
    private javax.swing.JTextField CampoSetorProduto;
    private javax.swing.JTextField CampoTipoProduto;
    private javax.swing.JTextField CampoUnidadeDeMedidaProduto;
    private javax.swing.JDialog ChamadaTabelaProduto;
    private javax.swing.JTable TPesquisaProduto;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
