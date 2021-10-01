import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;

public class Aluno extends PessoaFisica {
	
	@Expose private Boletim Boletim;
	
	@Expose private boolean Aprovado;	
	
	public Aluno(String nome, 
				 String email, 
				 String telefone, 
				 Endereco endereco, 
				 String cPF, 
				 Date dataNascimento,
				 Boletim boletim, 
				 boolean aprovado) 
	{
		super(nome, email, telefone, endereco, cPF, dataNascimento);
		Boletim = boletim;
		Aprovado = aprovado;
	}

	public Aluno() {
		super();
	}	

	public Boletim getBoletim() {
		return Boletim;
	}

	public void setBoletim(Boletim boletim) {
		Boletim = boletim;
	}

	public boolean isAprovado() {
		return Aprovado;
	}

	public void AvaliarAluno() {
		
		double percentualMinimoFrequencia = 70.0;
		double notaMinima = 7.0;
		
		int frequenciaAcumulada = 0;		
		double notaAcumulada = 0;
		
		var disciplinaCursada = Boletim.getDisciplinas();
		
		for (DisciplinaCursada disciplina : disciplinaCursada) {
			
			frequenciaAcumulada += disciplina.getFrequencia();
			notaAcumulada += disciplina.getMedia();
			
		}
		
		double percentualFrequencia = frequenciaAcumulada / disciplinaCursada.size();
		double notaFinal = notaAcumulada / disciplinaCursada.size();
		
		Aprovado = percentualFrequencia > percentualMinimoFrequencia && notaFinal > notaMinima;
	}	
	
	public List<Object> Buscar() {
		
		List<Object> listaBD = new ArrayList<Object>();
		
		try {
			
			String caminho = "BancoDados\\"+ this.getClass().getSimpleName() + ".json";
			
			File arquivo = new File(caminho);
			
			if(arquivo.exists()) {
				
				BufferedReader br;
				
				br = new BufferedReader(new FileReader(arquivo));				
				
				Type tipoClasse = new TypeToken<ArrayList<Aluno>>(){}.getType();
				
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
		
	    if (obj instanceof Aluno) {
	    	
	    	Aluno aluno = (Aluno)obj;	    	

	        if (aluno.getID().contains(this.getID()))
	           return true;
	   }
	    return false;
	}
	
	@Override
	public String toString() {		
		return String.format("%s\nBoletim\n%s",
        		super.toString(), this.Boletim);
	}
}
