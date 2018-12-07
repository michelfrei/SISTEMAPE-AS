package View;

import DAO.ClienteDAO;
import DAO.FuncaoDAO;
import Model.ClienteModel;
import Model.Funcao;
import com.lowagie.text.DocumentException;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TelaFuncao extends javax.swing.JInternalFrame {

    List<Funcao> ListaFuncao;
    List<Funcao> ListaBuscaFuncao;

    public TelaFuncao() {
        initComponents();
        atualizarConsultaEspecificacao();

    }

    public void atualizarConsultaEspecificacao() {

        Funcao funcao = new Funcao();
        FuncaoDAO funcaoDAO = new FuncaoDAO();

        try {
            ListaFuncao = funcaoDAO.ListaFuncao();
            //ListaArea = areaDAO.ListaArea();
        } catch (SQLException ex) {
            ex.getMessage();
        }
        String dados[][] = new String[ListaFuncao.size()][2];
        int i = 0;
        for (Funcao fun : ListaFuncao) {
            dados[i][0] = String.valueOf(fun.getId());
            dados[i][1] = fun.getNome();
            i++;
        }
        String tituloColuna[] = {"id", "Nome"};
        DefaultTableModel tabelaCliente = new DefaultTableModel();
        tabelaCliente.setDataVector(dados, tituloColuna);
        TPesquisarFuncao.setModel(new DefaultTableModel(dados, tituloColuna) {
            boolean[] canEdit = new boolean[]{
                false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        TPesquisarFuncao.getColumnModel().getColumn(0).setPreferredWidth(20);
        TPesquisarFuncao.getColumnModel().getColumn(1).setPreferredWidth(500);

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        TPesquisarFuncao.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        TPesquisarFuncao.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        TPesquisarFuncao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        TPesquisarFuncao.setRowHeight(25);
        TPesquisarFuncao.updateUI();
    }

    public void ConsultaEspecificacaoAlterar() {
        Funcao funcao = new Funcao();
        String dados[][] = new String[ListaBuscaFuncao.size()][2];
        int i = 0;
        for (Funcao fun : ListaBuscaFuncao) {
            dados[i][0] = String.valueOf(fun.getId());
            dados[i][1] = fun.getNome();

            i++;
        }
        String tituloColuna[] = {"id", "Nome"};
        DefaultTableModel tabelaCliente = new DefaultTableModel();
        tabelaCliente.setDataVector(dados, tituloColuna);
        TPesquisarFuncao.setModel(new DefaultTableModel(dados, tituloColuna) {
            boolean[] canEdit = new boolean[]{
                false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        TPesquisarFuncao.getColumnModel().getColumn(0).setPreferredWidth(20);
        TPesquisarFuncao.getColumnModel().getColumn(1).setPreferredWidth(500);

        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        TPesquisarFuncao.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        TPesquisarFuncao.getColumnModel().getColumn(1).setCellRenderer(centralizado);
        TPesquisarFuncao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        TPesquisarFuncao.setRowHeight(25);
        TPesquisarFuncao.updateUI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChamadaTabelaFuncao = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        BotaoBuscaCliente1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TPesquisarFuncao = new javax.swing.JTable();
        BuscaCliente = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BotaoNovoCliente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BotaoSalvaCliente = new javax.swing.JButton();
        BotaoBuscaCliente = new javax.swing.JButton();
        CampoIdFuncao = new javax.swing.JTextField();
        CampoNomeFuncao = new javax.swing.JTextField();
        BotaoAlteraCliente = new javax.swing.JButton();
        BotaoDeletarFuncao = new javax.swing.JButton();
        BotaoLimpaCliente = new javax.swing.JButton();
        BotaoRelatorioCliente = new javax.swing.JButton();

        ChamadaTabelaFuncao.setMinimumSize(new java.awt.Dimension(850, 500));

        BotaoBuscaCliente1.setBackground(new java.awt.Color(255, 255, 255));
        BotaoBuscaCliente1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoBuscaCliente1.setText("Buscar funcao");
        BotaoBuscaCliente1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoBuscaCliente1.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        BotaoBuscaCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscaCliente1ActionPerformed(evt);
            }
        });

        TPesquisarFuncao.setModel(new javax.swing.table.DefaultTableModel(
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
        TPesquisarFuncao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TPesquisarFuncaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TPesquisarFuncao);

        BuscaCliente.setMinimumSize(new java.awt.Dimension(8, 20));
        BuscaCliente.setPreferredSize(new java.awt.Dimension(8, 20));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel48.setText("Tela de pesquisa de funcao:");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setText("Insira o nome de uma funcao");

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

        javax.swing.GroupLayout ChamadaTabelaFuncaoLayout = new javax.swing.GroupLayout(ChamadaTabelaFuncao.getContentPane());
        ChamadaTabelaFuncao.getContentPane().setLayout(ChamadaTabelaFuncaoLayout);
        ChamadaTabelaFuncaoLayout.setHorizontalGroup(
            ChamadaTabelaFuncaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ChamadaTabelaFuncaoLayout.setVerticalGroup(
            ChamadaTabelaFuncaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setClosable(true);
        setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jPanel1.setBackground(new java.awt.Color(255, 255, 246));
        jPanel1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        BotaoNovoCliente.setBackground(new java.awt.Color(255, 255, 255));
        BotaoNovoCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoNovoCliente.setText("Novo Cliente");
        BotaoNovoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoNovoCliente.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        BotaoNovoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoNovoClienteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Id:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nome Razao:");

        BotaoSalvaCliente.setBackground(new java.awt.Color(255, 255, 255));
        BotaoSalvaCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoSalvaCliente.setText("Salvar");
        BotaoSalvaCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoSalvaCliente.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        BotaoSalvaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSalvaClienteActionPerformed(evt);
            }
        });

        BotaoBuscaCliente.setBackground(new java.awt.Color(255, 255, 255));
        BotaoBuscaCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoBuscaCliente.setText("Buscar Cliente");
        BotaoBuscaCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoBuscaCliente.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        BotaoBuscaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscaClienteActionPerformed(evt);
            }
        });

        CampoIdFuncao.setEditable(false);
        CampoIdFuncao.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        CampoIdFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoIdFuncaoActionPerformed(evt);
            }
        });

        CampoNomeFuncao.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        BotaoAlteraCliente.setBackground(new java.awt.Color(255, 255, 255));
        BotaoAlteraCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoAlteraCliente.setText("Alterar");
        BotaoAlteraCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoAlteraCliente.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        BotaoAlteraCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAlteraClienteActionPerformed(evt);
            }
        });

        BotaoDeletarFuncao.setBackground(new java.awt.Color(255, 255, 255));
        BotaoDeletarFuncao.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoDeletarFuncao.setText("Deletar");
        BotaoDeletarFuncao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoDeletarFuncao.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        BotaoDeletarFuncao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoDeletarFuncaoActionPerformed(evt);
            }
        });

        BotaoLimpaCliente.setBackground(new java.awt.Color(255, 255, 255));
        BotaoLimpaCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoLimpaCliente.setText("Cancelar");
        BotaoLimpaCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoLimpaCliente.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        BotaoLimpaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoLimpaClienteActionPerformed(evt);
            }
        });

        BotaoRelatorioCliente.setBackground(new java.awt.Color(255, 255, 255));
        BotaoRelatorioCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotaoRelatorioCliente.setText("Relatorio");
        BotaoRelatorioCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoRelatorioCliente.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoIdFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CampoNomeFuncao))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BotaoNovoCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoBuscaCliente))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 109, Short.MAX_VALUE)
                        .addComponent(BotaoRelatorioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoLimpaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoDeletarFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoAlteraCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoSalvaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(CampoIdFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoNomeFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoAlteraCliente)
                    .addComponent(BotaoLimpaCliente)
                    .addComponent(BotaoRelatorioCliente)
                    .addComponent(BotaoSalvaCliente)
                    .addComponent(BotaoDeletarFuncao))
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

    }//GEN-LAST:event_BotaoNovoClienteActionPerformed

    private void BotaoSalvaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvaClienteActionPerformed
        Funcao funcao = new Funcao();
        funcao.setNome(CampoNomeFuncao.getText());
        FuncaoDAO funcaoDAO = new FuncaoDAO();
        try {
            funcaoDAO.InserirFuncao(funcao);
            System.out.println("Funcao salva com sucesso!");
            atualizarConsultaEspecificacao();
            TelaFuncionario telaFuncionario = new TelaFuncionario();
            telaFuncionario.ClearComboBox();
            try{
            telaFuncionario.ComboBox();
            } catch(Exception ex){
                ex.getMessage();
                System.out.println("Problema na TelaFuncao -> BotaoSalvaClienteActionPerformed referente a paradinha da combobox");
            }
        } catch (Exception e) {
            System.out.println("Não foi possivel salvar essa função" + e.getMessage());
        }
    }//GEN-LAST:event_BotaoSalvaClienteActionPerformed

    private void BotaoBuscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaClienteActionPerformed
        ChamadaTabelaFuncao.setVisible(true);
    }//GEN-LAST:event_BotaoBuscaClienteActionPerformed

    private void CampoIdFuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoIdFuncaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoIdFuncaoActionPerformed

    private void BotaoAlteraClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAlteraClienteActionPerformed
        if (CampoNomeFuncao.getText().isEmpty() || CampoIdFuncao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione uma editora!", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
        if (JOptionPane.showConfirmDialog(null, "Essa editora será alterada. Desaja continuar?", "pergunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

            try {
                Funcao funcao = new Funcao();
                funcao.setId(Integer.parseInt(CampoIdFuncao.getText()));
                funcao.setNome(CampoNomeFuncao.getText());

                try {
                    FuncaoDAO funcaoDAO = new FuncaoDAO();
                    funcaoDAO.AlterarFuncao(funcao);

                    JOptionPane.showMessageDialog(null, "Editora alterada com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    atualizarConsultaEspecificacao();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Algo de errado ocorreu! Erro: " + ex.getMessage(), "Sistema", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(ex.getMessage());
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Náo foi possível alterar essa especificação! Erro:" + e.getMessage(), "Sistema", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_BotaoAlteraClienteActionPerformed

    private void BotaoDeletarFuncaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoDeletarFuncaoActionPerformed
        if (CampoNomeFuncao.getText().isEmpty() || CampoIdFuncao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione uma funcao para deleta-lá!", "Sistema", JOptionPane.INFORMATION_MESSAGE);
        }

        if (JOptionPane.showConfirmDialog(null, "Essa especificação será Editora. Desaja continuar?", "Sistema", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            try {
                Funcao funcao = new Funcao();
                funcao.setId(Integer.parseInt(CampoIdFuncao.getText()));
                FuncaoDAO editoraDAO = new FuncaoDAO();

                try {
                    editoraDAO.RemoverFuncao(funcao);
                    JOptionPane.showMessageDialog(null, "Editora removida com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                    atualizarConsultaEspecificacao();
                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "Algo de errado ocorreu! Erro: " + ex.getMessage(), "Sistema", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(ex.getMessage());
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Náo foi possível remover essa editora! Erro:" + e.getMessage(), "Sistema", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_BotaoDeletarFuncaoActionPerformed

    private void BotaoLimpaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoLimpaClienteActionPerformed

    }//GEN-LAST:event_BotaoLimpaClienteActionPerformed

    private void BotaoRelatorioClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRelatorioClienteActionPerformed

    }//GEN-LAST:event_BotaoRelatorioClienteActionPerformed

    private void BotaoBuscaCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscaCliente1ActionPerformed

    }//GEN-LAST:event_BotaoBuscaCliente1ActionPerformed

    private void TPesquisarFuncaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TPesquisarFuncaoMouseClicked
        TPesquisarFuncao.getTableHeader().setReorderingAllowed(false);
        CampoIdFuncao.setText(TPesquisarFuncao.getValueAt(TPesquisarFuncao.getSelectedRow(), 0).toString());
        CampoNomeFuncao.setText(TPesquisarFuncao.getValueAt(TPesquisarFuncao.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_TPesquisarFuncaoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAlteraCliente;
    private javax.swing.JButton BotaoBuscaCliente;
    private javax.swing.JButton BotaoBuscaCliente1;
    private javax.swing.JButton BotaoDeletarFuncao;
    private javax.swing.JButton BotaoLimpaCliente;
    private javax.swing.JButton BotaoNovoCliente;
    private javax.swing.JButton BotaoRelatorioCliente;
    private javax.swing.JButton BotaoSalvaCliente;
    private javax.swing.JTextField BuscaCliente;
    private javax.swing.JTextField CampoIdFuncao;
    private javax.swing.JTextField CampoNomeFuncao;
    private javax.swing.JDialog ChamadaTabelaFuncao;
    private javax.swing.JTable TPesquisarFuncao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
