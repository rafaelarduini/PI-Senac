import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;

public class DisciplinaCursada extends Disciplina{
	
	@Expose private double Nota1;
	
	@Expose private double Nota2;
	
	@Expose private double Media;
	
	@Expose private int Frequencia;		

	public DisciplinaCursada(String nome, 
							 int cargaHoraria, 
							 double nota1, 
							 double nota2, 
							 double media, 
							 int frequencia) 
	{
		super(nome, cargaHoraria);
		Nota1 = nota1;
		Nota2 = nota2;
		Media = media;
		Frequencia = frequencia;
	}
	
	public DisciplinaCursada() {
		super();
	}

	public DisciplinaCursada(Disciplina disciplinaSelecionada) {
		this.setNome(disciplinaSelecionada.getNome());
		this.setCargaHoraria(disciplinaSelecionada.getCargaHoraria());
	}

	public double getNota1() {
		return Nota1;
	}

	public void setNota1(double nota1) {
		Nota1 = nota1;
	}

	public double getNota2() {
		return Nota2;
	}

	public void setNota2(double nota2) {
		Nota2 = nota2;
	}

	public int getFrequencia() {
		return Frequencia;
	}

	public void setFrequencia(int frequencia) {
		Frequencia = frequencia;
	}

	public double getMedia() {
		return Media;
	}

	public void CalculaMedia() {
		Media = (Nota1 + Nota2) / 2;
	}
	
	@Override
	public String toString() {
		return String.format("%s\nNota 1: %s\nNota 2: %s\nMédia: %s\nFrequência: %s\n\n",
				super.toString(), this.Nota1, this.Nota2, this.Media, this.Frequencia);
	}
	
}

