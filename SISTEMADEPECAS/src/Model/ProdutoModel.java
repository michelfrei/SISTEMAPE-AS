
package Model;

/**
 *
 * @author Michel
 */
public class ProdutoModel {
    private int id;
    private String Tipo;
    private String Descricao;
    private String Detalhes;
    private String Marca;
    private String Origem;
    private String CodigoDeBarras;
    private String Fabricante;
    private String Setor;
    private String UnitMedida;
    private double Peso;
    private String Medidas;
    private String Foto;
    private int Estoque;
    private boolean Ativo;
    
    public ProdutoModel(){
    }

    public ProdutoModel(int id, String Tipo, String Descricao, String Detalhes, String Marca, String Origem, String CodigoDeBarras, String Fabricante, String Setor, String UnitMedida, double Peso, String Medidas, String Foto, int Estoque, boolean Ativo) {
        this.id = id;
        this.Tipo = Tipo;
        this.Descricao = Descricao;
        this.Detalhes = Detalhes;
        this.Marca = Marca;
        this.Origem = Origem;
        this.CodigoDeBarras = CodigoDeBarras;
        this.Fabricante = Fabricante;
        this.Setor = Setor;
        this.UnitMedida = UnitMedida;
        this.Peso = Peso;
        this.Medidas = Medidas;
        this.Foto = Foto;
        this.Estoque = Estoque;
        this.Ativo = Ativo;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getDetalhes() {
        return Detalhes;
    }

    public void setDetalhes(String Detalhes) {
        this.Detalhes = Detalhes;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getOrigem() {
        return Origem;
    }

    public void setOrigem(String Origem) {
        this.Origem = Origem;
    }

    public String getCodigoDeBarras() {
        return CodigoDeBarras;
    }

    public void setCodigoDeBarras(String CodigoDeBarras) {
        this.CodigoDeBarras = CodigoDeBarras;
    }

    public String getFabricante() {
        return Fabricante;
    }

    public void setFabricante(String Fabricante) {
        this.Fabricante = Fabricante;
    }

    public String getSetor() {
        return Setor;
    }

    public void setSetor(String Setor) {
        this.Setor = Setor;
    }

    public String getUnitMedida() {
        return UnitMedida;
    }

    public void setUnitMedida(String UnitMedida) {
        this.UnitMedida = UnitMedida;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    public String getMedidas() {
        return Medidas;
    }

    public void setMedidas(String Medidas) {
        this.Medidas = Medidas;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String Foto) {
        this.Foto = Foto;
    }

    public int getEstoque() {
        return Estoque;
    }

    public void setEstoque(int Estoque) {
        this.Estoque = Estoque;
    }

    public boolean isAtivo() {
        return Ativo;
    }

    public void setAtivo(boolean Ativo) {
        this.Ativo = Ativo;
    }

}
