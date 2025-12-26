import java.util.ArrayList;
import java.io.Serializable;
import java.util.*;

public class CollexFunc {

	private ArrayList<ItemCollecao> itens;
    private ArrayList<Categoria> categorias;
    private ArrayList<Movimento> movimentos;
    private ArrayList<Contacto> contactos;

    public CollexFunc() {
    	itens = new ArrayList<>();
        categorias = new ArrayList<>();
        movimentos = new ArrayList<>();
        contactos = new ArrayList<>();
    }
    
    /*adicionar item, remover item, listaritens
     * adicionar contacto listar contacto
     * registarMovimento , adiciona um movimento a lista e atualiza o item se fizer sentido
     * metodos de pesquisa por nome, categoria, etc*/
     
    
    /* quando saio   FileManager.guardar("collex.dat", collexFunc);*/ 
   
    /* quando entro     CollexFunc collexFunc;
    try {
        collexFunc = (CollexFunc) FileManager.carregar("collex.dat");
    } catch (...) {
        collexFunc = new CollexFunc(); // se ainda não existe ficheiro
    }*/
    
    
    /*ITEMS*/
    public void adicionarItem(ItemCollecao item) {
    	itens.add(item);
    }
    public boolean removerItemPorNome(String nome) {
    	for (int i = 0; i< itens.size(); i++) {
    		if(itens.get(i).getNome().equals(nome)) {
    			itens.remove(i);
    			return true;
    		}
    	} return false;
    }
    
    public List<ItemCollecao> getItens(){
    	return itens;
    }
    
    
    public ItemCollecao procurarItemPorNome(String nome) {
    	for(int i= 0; i < itens.size(); i++) {
    		if(itens.get(i).getNome().equals(nome)){
    			return itens.get(i);
    		}
    	}return null;
    }
    
    public List<ItemCollecao> getItensPorCategoria(Categoria cat){
    	List<ItemCollecao> resultado = new ArrayList<>();
    	for(int i = 0; i< itens.size(); i++) {
    		if(itens.get(i).getCategoria() != null &&itens.get(i).getCategoria().equals(cat)) {
    			resultado.add(itens.get(i));
    		}
    	} return resultado;
    }
    
    
    
    
    /*Contactos*/
    
    public void adicionarContactos(Contacto c) {
    	contactos.add(c);
    	
    }
    public ArrayList<Contacto> getContactos(){
    	return contactos;
    }
    
    public Contacto procurarContactoPorNome(String nome) {
    	for(int i = 0; i < contactos.size(); i++) {
    		if(contactos.get(i).getNome().equals(nome)) {
    			return contactos.get(i) ;
    		}
    		
    	} return null;
    	
    }
    
    public boolean removerContactoPorNome(String nome) {
    	for(int i = 0; i< contactos.size(); i++) {
    		if(contactos.get(i).getNome().equals(nome)) {
    			contactos.remove(i);
    			return true;
    		}
    	} return false;
    }
    
    
    
    /*Categorias*/

    public void adicionarCategoria(Categoria cat) {
        categorias.add(cat);
    }
    public ArrayList<Categoria> getCategorias(){
    	return categorias;
    }
    
    public Categoria procurarCategoriaPorNome(String nome) {
    	for (int i = 0; i< categorias.size(); i++) {
    		if(categorias.get(i).getNomeCat().equals(nome)) {
    			return categorias.get(i);
    		}
    	}return null;
    }
    
    public boolean removerCategoriaPorNome(String nome) {
    	for(int i = 0; i< categorias.size(); i++) {
    		if(categorias.get(i).getNomeCat().equals(nome)) {
    			categorias.remove(i);
    			return true;
    		}
    	}return false;
    }
    
    
    
    /*Movimentos*/
    
    public void registarMovimento(Movimento mov) {
    	movimentos.add(mov);
    }
    
    public ArrayList<Movimento> getMovimentos(){
    	return movimentos;
    }
 
    
    public List<Movimento> getMovimentosPorTipo(Movimento.Tipo tipo) {
    	List<Movimento> resultado = new ArrayList<>();
    	for (int i = 0; i < movimentos.size(); i++) {
    		if (movimentos.get(i).getTipo() == tipo) {
    			resultado.add(movimentos.get(i));
    		}
    	}
    	return resultado;
    }
    
    
}

/*Podes ir acrescentando métodos (editar item, remover contacto, etc.) à medida que fores precisando*/
