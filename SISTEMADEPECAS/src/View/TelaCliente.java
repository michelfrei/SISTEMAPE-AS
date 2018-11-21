package View;

import DAO.ClienteDAO;
import Model.ClienteModel;
import com.lowagie.text.DocumentException;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Real
 */
public class TelaCliente extends javax.swing.JInternalFrame {

    List<ClienteModel> ListaCliente;
    List<ClienteModel> ListaBuscaCliente;

    /**
     * Creates new form teste
     */
    public TelaCliente() {
        initComponents();
        TravaCamposCliente();
        atualizarTabelaCliente();
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
        BotaoRelatorioCliente = new javax.swing.JButton();

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

        setClosable(true);

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

        BotaoRelatorioCliente.setBackground(new java.awt.Color(255, 255, 255));
        BotaoRelatorioCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoRelatorioCliente.setText("Relatorio");
        BotaoRelatorioCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoRelatorioCliente.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoRelatorioCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRelatorioClienteActionPerformed(evt);
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
                                .addGap(0, 0, Short.MAX_VALUE)))
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
                        .addComponent(BotaoRelatorioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(BotaoSalvaCliente1)
                    .addComponent(BotaoRelatorioCliente))
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Sistema", JOptionPane.INFORMATION_MESSAGE);
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
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Sistema", JOptionPane.INFORMATION_MESSAGE);
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
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Sistema", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_BotaoDesativaClienteActionPerformed

    private void BotaoSalvaCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvaCliente1ActionPerformed
        LimpaCamposCliente();
    }//GEN-LAST:event_BotaoSalvaCliente1ActionPerformed

    private void BotaoRelatorioClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRelatorioClienteActionPerformed
        String nomediretorio = null;
        ClienteDAO cliDAO = new ClienteDAO();
        String nomepasta = "SRS";
        // Informe o nome da pasta que armazenará o relatório
        String separador = java.io.File.separator;
        try {
            nomediretorio = "C:" + separador + nomepasta;
            if (!new File(nomediretorio).exists()) {
                (new File(nomediretorio)).mkdir();
            }
            cliDAO.RelatorioCliente();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Sistema", JOptionPane.INFORMATION_MESSAGE);
            ex.printStackTrace();
        } catch (DocumentException ex) {
            Logger.getLogger(TelaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoRelatorioClienteActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAlteraCliente;
    private javax.swing.JButton BotaoBuscaCliente;
    private javax.swing.JButton BotaoBuscaCliente1;
    private javax.swing.JButton BotaoDesativaCliente;
    private javax.swing.JButton BotaoNovoCliente;
    private javax.swing.JButton BotaoRelatorioCliente;
    private javax.swing.JButton BotaoSalvaCliente;
    private javax.swing.JButton BotaoSalvaCliente1;
    private javax.swing.JTextField BuscaCliente;
    private javax.swing.JTextField CampoBairroCliente;
    private javax.swing.JTextField CampoCPFCliente;
    private javax.swing.JTextField CampoCelularCliente;
    private javax.swing.JTextField CampoCepCliente;
    private javax.swing.JTextField CampoCidadeCliente;
    private javax.swing.JTextField CampoComplementoCliente;
    private javax.swing.JTextField CampoContasCliente;
    private javax.swing.JTextField CampoDebitoCliente;
    private javax.swing.JTextField CampoEmailCliente;
    private javax.swing.JTextField CampoEnderecoCliente;
    private javax.swing.JTextField CampoEstadoCliente;
    private javax.swing.JTextField CampoIdCliente;
    private javax.swing.JTextField CampoNomeCliente;
    private javax.swing.JTextField CampoNumeroCasaCliente;
    private javax.swing.JTextField CampoRGCliente;
    private javax.swing.JTextField CampoTelefoneCliente;
    private javax.swing.JDialog ChamadaTabelaCliente;
    private javax.swing.JTable TPesquisarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
