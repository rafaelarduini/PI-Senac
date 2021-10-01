import com.google.gson.annotations.Expose;

public class Endereco {
	
	@Expose private String Logradouro;
	
	@Expose private int Numero;
	
	@Expose private String Complemento;
	
	@Expose private String Bairro;
	
	@Expose private String CEP;
	
	@Expose private String Cidade;
	
	@Expose private String Estado;
	
	public Endereco(String logradouro, 
					int numero, 
					String complemento, 
					String bairro, 
					String cEP, 
					String cidade, 
					String estado) 
	{
		Logradouro = logradouro;
		Numero = numero;
		Complemento = complemento;
		Bairro = bairro;
		CEP = cEP;
		Cidade = cidade;
		Estado = estado;
	}
	
	public Endereco() {
		super();
	}

	public String getLogradouro() {
		return Logradouro;
	}

	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}

	public int getNumero() {
		return Numero;
	}

	public void setNumero(int numero) {
		Numero = numero;
	}

	public String getComplemento() {
		return Complemento;
	}

	public void setComplemento(String complemento) {
		Complemento = complemento;
	}

	public String getBairro() {
		return Bairro;
	}

	public void setBairro(String bairro) {
		Bairro = bairro;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getCidade() {
		return Cidade;
	}

	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}	
	
	@Override
	public String toString() {
		return String.format("Logradouro:%s\nNúmero:%s\nComplemento:%s\nBairro:%s\nCEP:%s\nCidade:%s\nEstado:%s",
        		this.Logradouro, this.Numero,this.Complemento, this.Bairro, this.CEP, this.Cidade, this.Estado);
	}
}
