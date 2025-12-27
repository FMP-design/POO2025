package controller;
import java.io.*;
import java.util.*;
import java.time.LocalDate;


public class Movimento implements Serializable {
	public LocalDate data;
	public ItemCollecao itemCollecao;
	public Contacto contacto;
	private double valor;
	private Tipo tipo;
	
	public enum Tipo{
		COMPRA, VENDA, TROCA;
	}
	
	public Movimento() {
		data = LocalDate.now();
		itemCollecao = new ItemCollecao();
		contacto = new Contacto();
		tipo = Tipo.COMPRA;
		valor = 0.0;
}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public void setData(int dia, int mes, int ano) {
		this.data = LocalDate.of(ano, mes, dia);
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public void setColecao(ItemCollecao itemColecao) {
		this.itemCollecao = itemColecao;
	}
	
	public ItemCollecao getColecao() {
		return itemCollecao;
	}
	
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	
	public Contacto getContacto() {
		return contacto;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public boolean equals (Object obj) {
		boolean iguais = false;
		if (obj != null || this.getClass() == obj.getClass()) {
			Movimento mov = (Movimento) obj;
			iguais = this.data.equals(mov.data)&&
					this.itemCollecao.equals(mov.itemCollecao)&&
					this.contacto.equals(mov.contacto)&&
					this.tipo ==mov.tipo &&
					this.valor == mov.valor;			
		}
		return iguais;
	}
	
	public Object clone() {
		Movimento clone = new Movimento();
		clone.data = this.data;
		clone.itemCollecao = this.itemCollecao;
		clone.contacto = this.contacto;
		clone.valor=this.valor;
		clone.tipo = this.tipo;
		return clone;
	}
	
}