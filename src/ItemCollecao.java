import java.io.Serializable;
import java.time.LocalDate;

public class ItemColecao implements Serializable{
	
	private String nome;
	private String descricao;
	private LocalDate dataAquis;
	private double valorPago;
	private double valorEst;
	
	public ItemColecao (String nome, String descricao, LocalDate dataAquis, double valorPago, double valorEst) {
		this.nome= nome;
		this.descricao = descricao;
		this.dataAquis = dataAquis;
		this.valorPago = valorPago;
		this.valorEst = valorEst;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataAquis () {
		return dataAquis;
	}
	public void setDataAquis(LocalDate dataAquis) {
		this.dataAquis = dataAquis;
	}
	public double getValorPago() {
		return valorPago;
	}
	public void setVlaorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	public double getValorEst() {
		return valorEst;
	}
	public void setValorEst(double valorEst) {
		this.valorEst = valorEst;
	}
	
	public String toString() {
		String s;
		s= "Nome: \n" + nome + "Descrição: \n" + descricao +"Data de aquisição: \n" + dataAquis + "Valor Pago: \n" + valorPago + "Valor Estimado: \n" + valorEst;
		
		return s;
		
	}
}