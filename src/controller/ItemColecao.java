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

    public ItemColecao(String nome, String ano, String pago,
                       String valorEstimado, LocalDate dataCompra,
                       String tipo, String imagem) {

        this.nome = nome;
        this.ano = ano;
        this.pago = pago;
        this.valorEstimado = valorEstimado;
        this.dataCompra = dataCompra;
        this.tipo = tipo;
        this.imagem = imagem;
    }

    public String getNome() { return nome; }
    public String getAno() { return ano; }
    public String getPago() { return pago; }
    public String getValorEstimado() { return valorEstimado; }
    public LocalDate getDataCompra() { return dataCompra; }
    public String getTipo() { return tipo; }
    public String getImagem() { return imagem; }
}
