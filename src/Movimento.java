import java.io.*;
import java.util.*;
import java.time.LocalDate;


public class Movimento {
	public LocalDate data;
	public ItemColecao itemColecao;
	public Contacto contacto;
	
	enum Tipo{
		COMPRA{
			public double getMovimento() {
				return valor;
			}
			
			public void setMovimento(double valor) {
				this.valor = valor;
			}
		},
		VENDA{
			public void setMovimento(double valor) {
				this.valor = valor;
			}
			
			public double getMovimento() {
				return valor;
			}
		},
		TROCA;
		
		double valor = 0;
		void setMovimento(double d) {
			this.valor = d;
		} 
	}
	
	public Movimento() {
		data = LocalDate.now();
		itemColecao = new ItemColecao();
		contacto = new Contacto();
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public void setData(int dia, int mes, int ano) {
		this.data = LocalDate.of(ano, mes, dia);
	}
	
	public LocalDate getData() {
		return this.data;
	}
	
	public void setColecao(ItemColecao itemColecao) {
		this.itemColecao = itemColecao;
	}
	
	public ItemColecao getColecao() {
		return this.itemColecao;
	}
	
	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}
	
	public Contacto getContacto() {
		return this.contacto;
	}
}