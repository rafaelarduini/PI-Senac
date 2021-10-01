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

public class Professor extends PessoaFisica{
	
	@Expose private String Departamento;
	
	@Expose private List<Disciplina> DisciplinasMinistradas = new ArrayList<Disciplina>();
	
	@Expose private double ValorHoraAula;
	
	@Expose private double Salario;

	public Professor(String nome, 
					 String email, 
					 String telefone, 
					 Endereco endereco, 
					 String cPF, 
					 Date dataNascimento,
					 String departamento, 
					 List<Disciplina> disciplinasMinistradas, 
					 double valorHoraAula, 
					 double salario) 
	{
		super(nome, email, telefone, endereco, cPF, dataNascimento);
		Departamento = departamento;
		DisciplinasMinistradas = disciplinasMinistradas;
		ValorHoraAula = valorHoraAula;
		Salario = salario;
	}
	
	public Professor() {
		super();
	}

	public String getDepartamento() {
		return Departamento;
	}

	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}

	public double getValorHoraAula() {
		return ValorHoraAula;
	}

	public void setValorHoraAula(double valorHoraAula) {
		ValorHoraAula = valorHoraAula;
	}

	public List<Disciplina> getDisciplinasMinistradas() {
		return DisciplinasMinistradas;
	}

	public double getSalario() {
		return Salario;
	}

	public void setDisciplinaMinistrada(Disciplina disciplinaMinistrada) {
		DisciplinasMinistradas.add(disciplinaMinistrada);
		CalculaSalario();
	}

	public void CalculaSalario() {		
		for (Disciplina disciplina : DisciplinasMinistradas) {
			Salario += disciplina.getCargaHoraria() * ValorHoraAula;
		}
	}
	
	public List<Object> Buscar() {
		
		List<Object> listaBD = new ArrayList<Object>();
		
		try {
			
			String caminho = "BancoDados\\"+ this.getClass().getSimpleName() + ".json";
			
			File arquivo = new File(caminho);
			
			if(arquivo.exists()) {
				
				BufferedReader br;
				
				br = new BufferedReader(new FileReader(arquivo));				
				
				Type tipoClasse = new TypeToken<ArrayList<Professor>>(){}.getType();
				
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
		
	    if (obj instanceof Professor) {
	    	
	    	Professor professor = (Professor)obj;	    	

	        if (professor.getID().contains(this.getID()))
	           return true;
	   }
	    return false;
	}
}