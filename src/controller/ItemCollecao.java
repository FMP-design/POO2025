package controller;
import java.io.Serializable;
import java.time.LocalDate;

public class ItemCollecao implements Serializable{
	
	private String nome;

	private LocalDate dataAquis;
	private Categoria categoria;
	private double valorPago;
	private double valorEst;
	
	public ItemCollecao() {
		this.nome= "";		
		this.dataAquis= LocalDate.now() ;
		this.categoria = null;
		this.valorPago= 0.0;
		this.valorEst = 0.0;
	}
	public ItemCollecao (String nome, LocalDate dataAquis, double valorPago, double valorEst) {
		this.nome= nome;	
		this.dataAquis = dataAquis;
		this.categoria = categoria;
		this.valorPago = valorPago;
		this.valorEst = valorEst;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	
	public LocalDate getDataAquis () {
		return dataAquis;
	}
	public void setDataAquis(LocalDate dataAquis) {
		this.dataAquis = dataAquis;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public double getValorPago() {
		return valorPago;
	}
	public void setValorPago(double valorPago) {
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
		s= "Nome: \n" + nome + 
				"Data de aquisição: \n" + dataAquis + 
				"Categoria: \n" + categoria +
				"Valor Pago: \n" + valorPago + 
				"Valor Estimado: \n" + valorEst;
		
		return s;
		
	}
	
	public boolean euqls(Object obj) {
		boolean iguais = false;
		if(obj != null && this.getClass() == obj.getClass()) {
			ItemCollecao itc = (ItemCollecao) obj;
			iguais = this.nome.equals(itc.nome)&&
					this.dataAquis.equals(itc.dataAquis)&&
					this.valorPago == itc.valorPago &&
					this.valorEst == itc.valorEst;
		}
		return iguais;
	}
	
	public Object clone() {
		ItemCollecao clone = new ItemCollecao(this.nome, this.dataAquis, this.valorPago, this.valorEst );
		return clone;
	}
}