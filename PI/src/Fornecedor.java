import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Fornecedor extends PessoaJuridica{	
	
	private String Descricao;	

	public Fornecedor(String nome, 
					  String email, 
					  String telefone, 
					  Endereco endereco, 
					  String cNPJ,
					  String atividadePrincipal, 
					  String descricao) 
	{
		super(nome, email, telefone, endereco, cNPJ, atividadePrincipal);
		Descricao = descricao;
	}

	public Fornecedor() {
		super();
	}
	
	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public List<Object> Buscar() {
		
		List<Object> listaBD = new ArrayList<Object>();
		
		try {
			
			String caminho = "BancoDados\\"+ this.getClass().getSimpleName() + ".json";
			
			File arquivo = new File(caminho);
			
			if(arquivo.exists()) {
				
				BufferedReader br;
				
				br = new BufferedReader(new FileReader(arquivo));				
				
				Type tipoClasse = new TypeToken<ArrayList<Fornecedor>>(){}.getType();
				
				listaBD = new Gson().fromJson(br,tipoClasse);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return listaBD;
	}  		
		
	public Object Adicionar(){
		
		try {
			
			List<Object> listaBD = Buscar();
			
			listaBD.add(this);
			
			Gson gson =  new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
	
			String json = gson.toJson(listaBD);
			
			File diretorio = new File("BancoDados");
			
			if (!diretorio.exists()) { 
				diretorio.mkdirs();
			};			
			
			FileWriter writer;
			
			writer = new FileWriter("BancoDados\\"+this.getClass().getSimpleName()+".json");
			
			writer.write(json);
			writer.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return this;
	}
	
	public void Remover(){
		
		var listaBD = Buscar();
		
		try {
			
		listaBD.remove(this);
		
		Gson gson =  new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

		String json = gson.toJson(listaBD);
		
		FileWriter writer;
		
		writer = new FileWriter("BancoDados\\"+this.getClass().getSimpleName()+".json");
		
		writer.write(json);
		writer.close();
		
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	public void Atualizar(){
		
	try {
		
		var listaBD = Buscar();
		
		if(listaBD.contains(this)) {				
			
			int index = listaBD.indexOf(this);
			
			listaBD.set(index,this);
			
			Gson gson =  new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

			String json = gson.toJson(listaBD);
			
			FileWriter writer;
			
			writer = new FileWriter("BancoDados\\"+this.getClass().getSimpleName()+".json");
			
			writer.write(json);
			writer.close();	
			}
		} catch (IOException e) {
				e.printStackTrace();
		}		
	}	
	
	@Override
	public boolean equals(Object obj) {
		
	    if (obj instanceof Fornecedor) {
	    	
	    	Fornecedor fornecedor = (Fornecedor)obj;	    	

	        if (fornecedor.getID().contains(this.getID()))
	           return true;
	   }
	    return false;
	}
}