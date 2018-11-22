/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.FuncionarioDAO;
import DAO.ProdutoDAO;
import Model.FuncionarioModel;
import com.lowagie.text.DocumentException;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Real
 */
public class TelaFuncionario extends javax.swing.JInternalFrame {

    List<FuncionarioModel> ListaFuncionario;
    List<FuncionarioModel> ListaBuscaFuncionario;

    /**
     * Creates new form TelaFuncionario
     */
    public TelaFuncionario() {
        initComponents();

        TravaCamposFunc();
        atualizarTabelaFuncionario();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChamadaTabelaFuncionario = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TPesquisarFuncionario = new javax.swing.JTable();
        BotaoBuscaCliente2 = new javax.swing.JButton();
        BuscaFuncionario = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
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
        CampoEnderecoFunc = new javax.swing.JTextField();
        CampoNumeroCasaFunc = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        CampoEmailFunc = new javax.swing.JTextField();
        BotaoAlteraFunc = new javax.swing.JButton();
        BotaoDesativaFunc = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        CampoTipoFunc = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        CampoNomeUsuarioFunc = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        CampoSenhaFunc = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        CampoBairroFunc = new javax.swing.JTextField();
        BotaoLimpaProduto = new javax.swing.JButton();
        BotaoRelatorioProduto = new javax.swing.JButton();
        CampoCPFFunc = new javax.swing.JFormattedTextField();
        CampoRGFunc = new javax.swing.JFormattedTextField();
        CampoTelefoneFunc = new javax.swing.JFormattedTextField();
        CampoCelularFunc = new javax.swing.JFormattedTextField();

        ChamadaTabelaFuncionario.setMinimumSize(new java.awt.Dimension(850, 500));

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

        setClosable(true);

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

        BotaoAlteraFunc.setBackground(new java.awt.Color(255, 255, 255));
        BotaoAlteraFunc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoAlteraFunc.setText("Alterar");
        BotaoAlteraFunc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoAlteraFunc.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoAlteraFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAlteraFuncActionPerformed(evt);
            }
        });

        BotaoDesativaFunc.setBackground(new java.awt.Color(255, 255, 255));
        BotaoDesativaFunc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoDesativaFunc.setText("Desativar");
        BotaoDesativaFunc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoDesativaFunc.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoDesativaFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoDesativaFuncActionPerformed(evt);
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

        CampoNomeUsuarioFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoNomeUsuarioFuncActionPerformed(evt);
            }
        });

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

        try {
            CampoCPFFunc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            CampoRGFunc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            CampoTelefoneFunc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            CampoCelularFunc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(BotaoRelatorioProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotaoLimpaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotaoSalvaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotaoAlteraFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotaoDesativaFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addGap(18, 18, 18)
                                        .addComponent(CampoCelularFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel27)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CampoEmailFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CampoCPFFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel20))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CampoIdFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel33)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CampoTipoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(CampoNomeFunc))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(CampoRGFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CampoTelefoneFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(183, 183, 183)))))
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
                    .addComponent(jLabel25)
                    .addComponent(CampoCPFFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoRGFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoTelefoneFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(CampoEmailFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoCelularFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotaoLimpaProduto)
                        .addComponent(BotaoRelatorioProduto))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotaoSalvaFunc)
                        .addComponent(BotaoAlteraFunc)
                        .addComponent(BotaoDesativaFunc)))
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void BotaoNovoFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoFuncActionPerformed
        DestravaCamposFunc();
        BotaoAlteraFunc.setEnabled(false);
        BotaoDesativaFunc.setEnabled(false);
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

                
                BotaoAlteraFunc.setEnabled(true);
                BotaoDesativaFunc.setEnabled(true);


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

    private void BotaoAlteraFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAlteraFuncActionPerformed
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
    }//GEN-LAST:event_BotaoAlteraFuncActionPerformed

    private void BotaoDesativaFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoDesativaFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoDesativaFuncActionPerformed

    private void CampoTipoFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoTipoFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoTipoFuncActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void BotaoLimpaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoLimpaProdutoActionPerformed
        LimpaCamposFunc();
        BotaoAlteraFunc.setEnabled(false);
    }//GEN-LAST:event_BotaoLimpaProdutoActionPerformed

    private void BotaoRelatorioProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRelatorioProdutoActionPerformed
        String nomediretorio = null;
        FuncionarioDAO funcDAO = new FuncionarioDAO();
        String nomepasta = "SRS";
        // Informe o nome da pasta que armazenará o relatório
        String separador = java.io.File.separator;
        try {
            nomediretorio = "C:" + separador + nomepasta;
            if (!new File(nomediretorio).exists()) {
                (new File(nomediretorio)).mkdir();
            }
            funcDAO.RelatorioFuncionario();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BotaoRelatorioProdutoActionPerformed

    private void CampoNomeUsuarioFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoNomeUsuarioFuncActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoNomeUsuarioFuncActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAlteraFunc;
    private javax.swing.JButton BotaoBuscaCliente2;
    private javax.swing.JButton BotaoBuscaFunc;
    private javax.swing.JButton BotaoDesativaFunc;
    private javax.swing.JButton BotaoLimpaProduto;
    private javax.swing.JButton BotaoNovoFunc;
    private javax.swing.JButton BotaoRelatorioProduto;
    private javax.swing.JButton BotaoSalvaFunc;
    private javax.swing.JTextField BuscaFuncionario;
    private javax.swing.JTextField CampoBairroFunc;
    private javax.swing.JFormattedTextField CampoCPFFunc;
    private javax.swing.JFormattedTextField CampoCelularFunc;
    private javax.swing.JTextField CampoEmailFunc;
    private javax.swing.JTextField CampoEnderecoFunc;
    private javax.swing.JTextField CampoIdFunc;
    private javax.swing.JTextField CampoNomeFunc;
    private javax.swing.JTextField CampoNomeUsuarioFunc;
    private javax.swing.JTextField CampoNumeroCasaFunc;
    private javax.swing.JFormattedTextField CampoRGFunc;
    private javax.swing.JTextField CampoSenhaFunc;
    private javax.swing.JFormattedTextField CampoTelefoneFunc;
    private javax.swing.JTextField CampoTipoFunc;
    private javax.swing.JDialog ChamadaTabelaFuncionario;
    private javax.swing.JTable TPesquisarFuncionario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
