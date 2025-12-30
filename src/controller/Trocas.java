package controller;

public class Trocas{

    private String nome;
    private String tipo;
    private String colecao; 
    private String imagem;

    public Trocas(String nome, String tipo, String colecao, String imagem) {
        this.nome = nome;
        this.tipo = tipo;
        this.colecao = colecao;
        this.imagem = imagem;
    }

    public String getNome(){
    	return nome; 
    }
    public void setNome(String nome){
    	this.nome = nome;
    }
    public String getTipo(){
    	return tipo; 
    }
    public void setTipo(String tipo){
    	this.tipo = tipo;
    }
    public String getColecao(){
    	return colecao; 
    }
    public void setColecao(String colecao) {
    	this.colecao = colecao;
    }
    public String getImagem(){
    	return imagem; 
    }
    public void setImagem(String imagem) {
    	this.imagem = imagem;
    }
    
    
    public boolean equals(Object obj) {
    	boolean iguais = false;
    	if(obj!=null && this.getClass()==obj.getClass()) {
    		Trocas tro = (Trocas) obj;
    		iguais = this.nome.equals(tro.nome)&&
    				this.tipo.equals(tro.tipo)&&
    				this.colecao.equals(tro.colecao)&&
    				this.imagem.equals(tro.imagem);
    	}
    	return iguais;
    }
    
    public Object clone() {
    	Trocas clone = new Trocas (this.nome, this.tipo, this.colecao, this.imagem);
    	return clone();
    }
}