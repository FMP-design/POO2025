package controller;

import java.io.Serializable;
import java.time.LocalDate;

public class ItemColecao implements Serializable {
	
    private String nome;
    private String ano;
    private String pago;
    private String valorEstimado;
    private LocalDate dataCompra;
    private String tipo;
    private String imagem;

    public ItemColecao(String nome, String ano, String pago, String valorEstimado, LocalDate dataCompra, String tipo, String imagem) {

        this.nome = nome;
        this.ano = ano;
        this.pago = pago;
        this.valorEstimado = valorEstimado;
        this.dataCompra = dataCompra;
        this.tipo = tipo;
        this.imagem = imagem;
    }

    public String getNome(){
    	return nome; 
    }
    public void setNome(String nome) {
    	this.nome = nome;
    }
    public String getAno(){
    	return ano; 
    }
    public void setPago(String pago) {
    	this.pago = pago;
    }
    public String getPago(){
    	return pago; 
    }
    public String getValorEstimado(){
    	return valorEstimado;
    }
    public void setValorEstimado(String valorEstimado) {
    	this.valorEstimado=valorEstimado;
    }
    public LocalDate getDataCompra(){
    	return dataCompra;
    }
    public String getTipo(){
    	return tipo; 
    }
    public void setTipo(String tipo) {
    	this.tipo = tipo;
    }
    public String getImagem(){
    	return imagem; 
    }
    public void setImagem(String imagem) {
    	this.imagem=imagem;
    	
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean iguais = false;
        if (obj != null && this.getClass() == obj.getClass()) {
            ItemColecao ic = (ItemColecao) obj;
            iguais = this.nome.equals(ic.nome)&&
            		this.ano.equals(ic.ano)&&
            		this.pago.equals(ic.pago)&&
            		this.valorEstimado.equals(ic.valorEstimado)&&
            		this.dataCompra.equals(ic.dataCompra)&&
            		this.tipo.equals(ic.tipo)&&
            		this.imagem.equals(ic.imagem);
            		
        }

        return iguais;
    }

    @Override
    public Object clone() {
        ItemColecao clone = new ItemColecao (this.nome, this.ano, this.pago, this.valorEstimado, this.dataCompra, this.tipo, this.imagem);;
        return clone;
    }

}
