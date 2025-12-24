import java.io.*;
import java.util.*;
import java.time.LocalDate;


public class Categoria {

	private String nomeCat;
	private String descricao;
	private ArrayList<ItemCollecao> itens;
	
	
	
	public Categoria() {
		nomeCat = "";
		descricao = "";
		itens = new ArrayList<>();
		
	}
	
	public String getNomeCat() {
		return nomeCat;
	}
	
	public void setNomeCat(String nomeCat) {
		this.nomeCat = nomeCat;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao= descricao;
	}
	
	public List<ItemCollecao> getItens(){
		return itens;
	}
	
	public void adicionarItem(ItemCollecao item) {
		itens.add(item);
	}
	public void removerItem(ItemCollecao item) {
		itens.remove(item);
	}
	
	public boolean equals(Object obj) {
		boolean iguais = false;
		if(obj != null && this.getClass() == obj.getClass()) {
			Categoria cat =(Categoria) obj;
			iguais = this.nomeCat.equals(cat.nomeCat)&&
					this.descricao.equals(cat.descricao)&&
					this.itens.equals(cat.itens);
		}
		return iguais;
		
	}
	
	public Object clone() {
		Categoria clone = new Categoria() ;
		clone.nomeCat = this.nomeCat;
		clone.descricao = this.descricao;
		clone.itens = new ArrayList<>();
		return clone;
		
	}
	
	
	
	
	
	
}
