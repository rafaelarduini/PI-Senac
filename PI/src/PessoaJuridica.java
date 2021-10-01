import com.google.gson.annotations.Expose;

public abstract class PessoaJuridica extends Pessoa {
	
	@Expose private String CNPJ;
	
	@Expose private String AtividadePrincipal;

	

	public PessoaJuridica(String nome, 
						  String email, 
						  String telefone, 
						  Endereco endereco, 
						  String cNPJ,
					  	  String atividadePrincipal) 
	{
		super(nome, email, telefone, endereco);
		CNPJ = cNPJ;
		AtividadePrincipal = atividadePrincipal;
	}

	public PessoaJuridica() {
		super();
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getAtividadePrincipal() {
		return AtividadePrincipal;
	}

	public void setAtividadePrincipal(String atividadePrincipal) {
		AtividadePrincipal = atividadePrincipal;
	}	
}
