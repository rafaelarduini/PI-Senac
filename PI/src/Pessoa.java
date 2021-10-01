import java.util.UUID;

import com.google.gson.annotations.Expose;

public abstract class Pessoa implements Base {
	
	@Expose	private String ID;
	
	@Expose private String Nome;
		
	@Expose private String Email;
	
	@Expose private String Telefone;
	
	@Expose private Endereco Endereco;	
	
	public Pessoa(String nome, String email, String telefone, Endereco endereco) {
		ID = UUID.randomUUID().toString();
		Nome = nome;
		Email = email;
		Telefone = telefone;
		Endereco = endereco;
	}
	
	public Pessoa() {
		ID = UUID.randomUUID().toString();
	}
	
	public String getID() {
		return ID;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public Endereco getEndereco() {
		return Endereco;
	}

	public void setEndereco(Endereco endereco) {
		Endereco = endereco;
	}	
	
	@Override
	public String toString() {
		return String.format("Nome: %s\nEmail: %s\nTelefone: %s\n\nEndereço\n%s",
        		this.Nome, this.Email,this.Telefone, this.Endereco);
	}
}
