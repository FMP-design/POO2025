import myinputs.Ler;
import java.io.*;
import java.util.*;

public class Contacto implements Serializable{
	public String nome;
	public String email;
	public String telefone;
	public String tipoContacto;

	public Contacto() {
		nome = "";
		email = "";
		telefone = "";
		tipoContacto = "";
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTipoContacto(String tipoContacto) {
		this.tipoContacto = tipoContacto;
	}
	
	public String getTipoContacto() {
		return tipoContacto;
	}
	
	public String toString() {
		String s;
		s=  "Nome: " + nome + 
			"Email: \n" + email + 
			"Telefone: \n" + telefone + 
			"Tipo de Contacto: \n" + tipoContacto;
		return s;
	}
	
	public boolean equals(Object obj) {
		boolean iguais = false;
		if(obj != null && this.getClass() == obj.getClass()) {
			Contacto cont =(Contacto) obj;
			iguais = this.nome.equals(cont.nome)&&
					this.email.equals(cont.email)&&
					this.telefone.equals(cont.telefone)&&
					this.tipoContacto.equals(cont.tipoContacto);
		}
		return iguais;
		
	}
	
	public Object clone() {
		Contacto clone = new Contacto() ;
		clone.nome = this.nome;
		clone.email = this.email;
		clone.telefone = this.telefone;
		clone.tipoContacto = this.tipoContacto;
		return clone;
		
	}
	
}