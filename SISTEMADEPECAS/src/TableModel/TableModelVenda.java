/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

import Model.EntradaModel;
import Model.ProdutoModel;
import View.TelaVenda;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Natan Oliveira
 */
public class TableModelVenda extends AbstractTableModel {
    EntradaModel entrada = new EntradaModel();
    boolean d = false;
    private List <ProdutoModel> dados = new ArrayList<>();
    private double valorUnitario = entrada.getValor();
    private String[] colunas = {"Código", "Nome", "Marca", "Fabricante", "Unidade Medida", "Valor R$", "Valor Total", "Quantidade"};
    
     @Override
    public String getColumnName (int column) {
        return colunas [column];
    }
    
     @Override
    public int getRowCount() {
        return dados.size();
    }

     @Override
    public int getColumnCount() {
        return colunas.length;
    }

     @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0 :
                return dados.get(linha).getId();
            case 1 :
                return dados.get(linha).getDescricao();
            case 2 :
                return dados.get(linha).getMarca();
            case 3 :
                return dados.get(linha).getFabricante();
            case 4 :
                return dados.get(linha).getUnitMedida();
            case 5 : 
                return valorUnitario;
            case 6 :
                return valorUnitario * TelaVenda.quantidadeTotal;
            case 7 :
                return TelaVenda.quantidadeTotal;
        }
        return null;
    }

    public List<ProdutoModel> getDados() {
        return dados;
    }

    public void setDados(List<ProdutoModel> dados) {
        this.dados = dados;
    }
    
    public void addRow (ProdutoModel c) {
        this.dados.add(c);
        this.fireTableDataChanged();
    }
    
    public void removeAllRows () {
        if (getRowCount() > 0) {
            for (int i = getRowCount() - 1; i > -1; i--) {
                this.dados.clear();
                this.fireTableRowsDeleted(0, i);
            }
        }
    }
    
    public void removeSlctRow (int row) {
        this.dados.remove(row);
        this.fireTableRowsDeleted(row, row);
    }
    
    public void updateSlctRow (Object value, int row, int column) {
        this.setValueAt(value, row, column);
        this.fireTableDataChanged();
    }
}
