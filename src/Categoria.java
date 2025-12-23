import java.io.*;
import java.util.*;
import java.time.LocalDate;


public class Categoria {

	private String nomeCat;
	private String descricao;
	private ArrayList<ItemColecao> itens;
	
	
	
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
	
	public List<ItemColecao> getItens(){
		return itens;
	}
	
	public void adicionarItem(ItemColecao item) {
		itens.add(item);
	}
	public void removerItem(ItemColecao item) {
		itens.remove(item);
	}
	
	public String toString() {
		
	}
	
	
	
	
	
	
}
