package controller;

public class Vendas{

    private String nome;
    private String tipo;
    private String colecao; 
    private String imagem;

    public Vendas(String nome, String tipo, String colecao, String imagem) {
        this.nome = nome;
        this.tipo = tipo;
        this.colecao = colecao;
        this.imagem = imagem;
    }

   
    public String getNome() {
    	return nome;
    }
   public void setNome(String nome) {
	   this.nome=nome;
   }
   
   public String getTipo() {
	   return tipo;
   }
   public void setTipo(String tipo) {
	   this.tipo = tipo;
   }
   
   public String getColecao() {
	   return colecao;
   }
   public void setColecao(String colecao) {
	   this.colecao = colecao;
   }
   
   public String getImagem() {
	   return imagem;
   }
   public void setImagem(String imagem) {
	   this.imagem = imagem;
   }
   
   public boolean equals(Object obj) {
		boolean iguais = false;
		if(obj != null && this.getClass() == obj.getClass()) {
			Vendas vend =(Vendas) obj;
			iguais = this.nome.equals(vend.nome)&&
					this.tipo.equals(vend.tipo)&&
					this.colecao.equals(vend.colecao)&&
					this.imagem.equals(vend.imagem);
		}
		return iguais;
		
	}
   
   public Object clone () {
	   Vendas clone = new Vendas (this.nome, this.tipo, this.colecao, this.imagem);
	   return clone;
	   
   }
   
   
}
