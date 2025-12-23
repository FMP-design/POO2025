import myinputs.Ler;
import java.io.*;
import java.util.*;

public class Contacto {
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
}