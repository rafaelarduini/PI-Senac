import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class MenuAluno {
	
	public void AbrirMenu() {
		
		Scanner menu = new Scanner (System.in);
		
		try {	
		
			while (true) {
				System.out.print("\nMenu Aluno\n\n");
		        System.out.print("Opção 1 - Cadastrar \n");
		        System.out.print("Opção 2 - Atualizar \n");
		        System.out.print("Opção 3 - Excluir \n");
		        System.out.print("Opção 4 - Avaliar \n");
		        System.out.print("Opção 5 - Retornar \n\n");
		        System.out.print("Digite uma opção: ");
		
		        String opcao = menu.nextLine();
		
		        switch (opcao) {
		        case "1":	        	
		        	Cadastrar();		        	
		            break;
		
		        case "2":
		        	Atualizar();
		            break;
		
		        case "3":
		        	Excluir();
		            break;		            
		            
		        case "4":
		        	Avaliar();
		            
		        case "5":
		        	return;
		
		        default:
		            System.out.print("\nOpção Inválida!\n");
		            break;		            
		        }
			}
		} catch (Exception e) {
			e.printStackTrace();
			menu.close();
		}			
	}	
	
	private void Cadastrar() {
		
		Scanner menu = new Scanner (System.in);
		
		try {
			
			Aluno novoAluno = new Aluno();
			
			novoAluno = ObtemDadosAluno(novoAluno);
			
			System.out.print("Cadastrar endereço? (S/N)\n");			
			if(menu.nextLine().contains("S")) {
				novoAluno.setEndereco(ObtemDadosEndereco());
			}
			
			System.out.print("Cadastrar boletim? (S/N)\n");			
			if(menu.nextLine().contains("S")) {
				novoAluno.setBoletim(ObtemDadosBoletim());
			}
		
			System.out.print("\nDodos do novo cadastro\n\n");
					
			System.out.print(novoAluno);
			
			System.out.print("\n\nConfirmar cadastro? (S/N)\n");
			
			if(menu.nextLine().contains("S")) {
				novoAluno.Adicionar();
				
				System.out.print("Realizar novo cadastro? (S/N)\n");
				
				if(menu.nextLine().contains("S")) {
					Cadastrar();
				}
				else {
					AbrirMenu();
				}
				
			}else {	
				System.out.print("Novo cadastro apagado.\n");
				AbrirMenu();
			}	
		} catch (Exception e) {
			e.printStackTrace();
			menu.close();
		}		
	}
	
	private Aluno ObtemDadosAluno(Aluno aluno) {
		
		Scanner menu = new Scanner (System.in);
		String valorDigitado = null;
		
		try {			
			
			System.out.print("Informe o nome:\n");		
			aluno.setNome( menu.nextLine());
			
			System.out.print("Informe o e-mail:\n");		
			aluno.setEmail( menu.nextLine());
			
			System.out.print("Informe o telefone:\n");		
			aluno.setTelefone( menu.nextLine());
			
			System.out.print("Informe o CPF:\n");		
			aluno.setCPF( menu.nextLine());
			
			while (!isDate(valorDigitado)) {				
				System.out.print("Informe data de nascimento (dd/MM/yyyy):\n");	
				valorDigitado = menu.nextLine();
				
				if(!isDate(valorDigitado))
					System.out.print("Valor inválido.\n");
			}
			
			aluno.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(valorDigitado));
			
		}catch(ParseException e) {
			e.printStackTrace();
			menu.close();
		}	
		return aluno;
	}
	
	private Endereco ObtemDadosEndereco() {
		
		Scanner menu = new Scanner (System.in);
		var novoEndereco = new Endereco();
		String valorDigitado = null;
		
		try {	
			
			System.out.print("\nEndereco\n");
			
			System.out.print("Informe o Logradouro:\n");		
			novoEndereco.setLogradouro(menu.nextLine());
			
			while (!isNumber(valorDigitado)) {				
				System.out.print("Informe o Numero:\n");			
				valorDigitado = menu.nextLine();
				
				if(!isNumber(valorDigitado))
					System.out.print("Valor inválido.\n");
			}

			novoEndereco.setNumero(Integer.parseInt(valorDigitado));
			valorDigitado = null;

			System.out.print("Informe o Complemento:\n");		
			novoEndereco.setComplemento(menu.nextLine());
			
			System.out.print("Informe o Bairro:\n");		
			novoEndereco.setBairro(menu.nextLine());
			
			System.out.print("Informe o CEP:\n");		
			novoEndereco.setCEP(menu.nextLine());
			
			System.out.print("Informe o Cidade:\n");		
			novoEndereco.setCidade(menu.nextLine());
			
			System.out.print("Informe o Estado:\n");		
			novoEndereco.setEstado(menu.nextLine());
			
		} catch (Exception e) {
			e.printStackTrace();
			menu.close();
		}	
		return novoEndereco;
	}
	
	private void Atualizar() {
		
		Scanner menu = new Scanner (System.in);
		
		try {
			
			Aluno alunoSelecionado = ObtemAlunoSelecionado();
			
			System.out.print("Aluno selecionado: " + alunoSelecionado.getNome());
			
			System.out.print("\n\nAtualizar:\n");
	        System.out.print("Opção 1 - Dados do Aluno \n");
	        System.out.print("Opção 2 - Endereço do aluno\n");
	        System.out.print("Opção 3 - Boletim do aluno\n");
	        System.out.print("Opção 4 - Retornar \n\n");
	        System.out.print("Digite uma opção: ");
	
	        String opcao = menu.nextLine();
	
	        switch (opcao) {
	        case "1":	        	
	        	alunoSelecionado = ObtemDadosAluno(alunoSelecionado);     	
	            break;
	
	        case "2":
	        	alunoSelecionado.setEndereco(ObtemDadosEndereco());
	            break;
	
	        case "3":	        	
	        	alunoSelecionado.setBoletim(ObtemDadosBoletim());
	            break;
	            
	        case "4":
	        	AbrirMenu();
	
	        default:
	            System.out.print("\nOpção Inválida!\n");
	            break;	            
	        }
	        
	        System.out.print(alunoSelecionado);
	        
	        System.out.print("\n\nConfirmar atualização? (S/N)\n");
			
			if(menu.nextLine().contains("S")) {
				alunoSelecionado.Atualizar();
				
				System.out.print("Realizar nova atualização? (S/N)\n");
				
				if(menu.nextLine().contains("S")) {
					Atualizar();
				}
				else {
					AbrirMenu();
				}
				
			}else {	
				System.out.print("Atualização cancelada.\n");
				AbrirMenu();
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
			menu.close();
		}	
	}
	
	private Boletim ObtemDadosBoletim() {
		
		Scanner menu = new Scanner (System.in);
		var novoBoletim = new Boletim();
				
		try {		
			
			System.out.print("\nSelecionar disciplinas do novo boletim\n\n");
			
			while (true) {
				
				var disciplinaSelecionada = ObtemDisciplinaSelecionada();
				
				if(disciplinaSelecionada == null) {
					return null;
				}
				
				var novaDisciplinaCursada = new DisciplinaCursada(disciplinaSelecionada);
				
				System.out.print(disciplinaSelecionada);
				
				System.out.print("\n\nAdicionar? (S/N)\n");
				
				if(menu.nextLine().contains("S")) {
					novoBoletim.addDisciplinaCursada(novaDisciplinaCursada);
					
					System.out.print("Adicionar nova disciplina? (S/N)\n");
					
					if(!menu.nextLine().contains("S")) {
						break;
					}
					
				}else {	
					System.out.print("Nova disciplina apagada.\n");					
				}		
							
			}			
			
			} catch (Exception e) {
				e.printStackTrace();
				menu.close();
			}		
		
		return novoBoletim;
	}	
	
	private Disciplina ObtemDisciplinaSelecionada() {
		
		Scanner menu = new Scanner (System.in);			
		String valorDigitado = null;		
		var listaDisciplinas = new Disciplina().Buscar();
		
		try {
			
			if(listaDisciplinas.size() == 0) {
				System.out.print("Nenhuma disciplina disponívies.\n"
							   + "Realizar o cadastro através do menu Disciplinas.\n"
							   + "Digite 'OK' para continuar.\n");
				menu.nextLine();
				return null;
			}
			
			System.out.print("Lista de disciplinas disponívies:\n");
			
			for (Object disciplinaBD : listaDisciplinas) {
				
				int indiceLista = listaDisciplinas.indexOf(disciplinaBD);
				
				System.out.print("Opção: " + indiceLista + " - Nome: " + ((Disciplina)disciplinaBD).getNome() + "\n");
			}
			
			while(!isValidIndex(valorDigitado, listaDisciplinas)) {
				System.out.print("\nEscolha uma opção :\n");
				
				valorDigitado = menu.nextLine();
				
				if(!isValidIndex(valorDigitado, listaDisciplinas))
					System.out.print("Opção inválida.\n");
			}	
			
			} catch (Exception e) {
				e.printStackTrace();
				menu.close();
			}
		
		return (Disciplina)(listaDisciplinas.get(Integer.parseInt(valorDigitado)));
	}
	
	private void Excluir() {
		
		Scanner menu = new Scanner (System.in);
		
		try {
			
			Aluno alunoSelecionado = ObtemAlunoSelecionado();
			
			System.out.print(alunoSelecionado);
	        
	        System.out.print("\n\nConfirmar exclusão? (S/N)\n");
			
			if(menu.nextLine().contains("S")) {
				alunoSelecionado.Remover();
				
				System.out.print("Realizar nova exclusão? (S/N)\n");
				
				if(menu.nextLine().contains("S")) {
					Atualizar();
				}
				else {
					AbrirMenu();
				}
				
			}else {	
				System.out.print("Atualização cancelada.\n");
				AbrirMenu();
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
			menu.close();
		}	
	}
	
	private void Avaliar() {
		
		Scanner menu = new Scanner (System.in);
		
		try {
			
			Aluno alunoSelecionado = ObtemAlunoSelecionado();
			
			if (alunoSelecionado.getBoletim() == null) {
				System.out.print("Aluno ainda não possui um boletim cadastrado.\n"
								+"Você pode adicionar um boletim através do menu Atualizar Aluno.\n"
								+ "Digite 'OK' para continuar.\n");
				menu.nextLine();
				return;
			}
		
			System.out.print("Boletim do aluno: " + alunoSelecionado.getNome() + "\n\n");
			
			System.out.print(alunoSelecionado.getBoletim());

			System.out.print("Inserir notas? (S/N)\n");			
			if(menu.nextLine().contains("S")) {
				alunoSelecionado = AdicionaNotasBoletim(alunoSelecionado);  
			}
			
			System.out.print("Inserir frequência? (S/N)\n");			
			if(menu.nextLine().contains("S")) {
				alunoSelecionado = AdicionaNotasFrequencia(alunoSelecionado);
			}			
	        
			alunoSelecionado.AvaliarAluno();
			
	        System.out.print("\nBoletim do aluno\n\n" + alunoSelecionado.getBoletim());
	        
	        if (alunoSelecionado.isAprovado()) {
				System.out.print("Aluno aprovado!");
			}else {
				System.out.print("Aluno reprovado!");
			}	
	        
	        System.out.print("\n\nConfirmar alterações? (S/N)\n");
			
			if(menu.nextLine().contains("S")) {
				alunoSelecionado.Atualizar();
				
				System.out.print("Realizar nova avaliação? (S/N)\n");
				
				if(menu.nextLine().contains("S")) {
					Avaliar();
				}
				else {
					AbrirMenu();
				}
				
			}else {	
				System.out.print("Avaliação cancelada.\n");
				AbrirMenu();
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
			menu.close();
		}	
	}

	private Aluno AdicionaNotasBoletim(Aluno aluno) {
		
		Scanner menu = new Scanner (System.in);
		String valorDigitado = null;
		
		try {
			
			var boletim = aluno.getBoletim();
					
			var disciplinas = boletim.getDisciplinas();
			
			for (DisciplinaCursada disciplina : disciplinas) {
				
				System.out.print("\nDisciplina: " + disciplina.getNome());
				
				while (!isNumber(valorDigitado)) {				
					System.out.print("\nNota 1: ");			
					valorDigitado = menu.nextLine();
					
					if(!isNumber(valorDigitado))
						System.out.print("Valor inválido.\n");
				}
				
				disciplina.setNota1(Integer.parseInt(valorDigitado));				
				valorDigitado = null;
				
				while (!isNumber(valorDigitado)) {				
					System.out.print("\nNota 2: ");			
					valorDigitado = menu.nextLine();
					
					if(!isNumber(valorDigitado))
						System.out.print("Valor inválido.\n");
				}
				
				disciplina.setNota2(Integer.parseInt(valorDigitado));				
				valorDigitado= null;				
				
			}
			
			boletim.setDisciplinas(disciplinas);			
			aluno.setBoletim(boletim);
			
		} catch (Exception e) {
			e.printStackTrace();
			menu.close();
		}
		
		return aluno;
	}
	
	private Aluno AdicionaNotasFrequencia(Aluno aluno) {
		
		Scanner menu = new Scanner (System.in);
		String valorDigitado = null;
		
		try {
			
			System.out.print("\nInserir frequência\n");
			
			var boletim = aluno.getBoletim();
					
			var disciplinas = boletim.getDisciplinas();
			
			for (DisciplinaCursada disciplina : disciplinas) {
				
				System.out.print("\nDisciplina: " + disciplina.getNome());
				
				while (!isNumber(valorDigitado)) {				
					System.out.print("\nFrequência: ");			
					valorDigitado = menu.nextLine();
					
					if(!isNumber(valorDigitado))
						System.out.print("Valor inválido.\n");
				}
				
				disciplina.setFrequencia(Integer.parseInt(valorDigitado));
				valorDigitado = null;				
			}
			
			boletim.setDisciplinas(disciplinas);			
			aluno.setBoletim(boletim);			
			
		} catch (Exception e) {
			e.printStackTrace();
			menu.close();
		}
		
		return aluno;
	}	

	private Aluno ObtemAlunoSelecionado() {
		
		Scanner menu = new Scanner (System.in);			
		String valorDigitado = null;		
		var listaAlunos = new Aluno().Buscar();
		
		try {
			
			System.out.print("\nLista de alunos:\n\n");
			
			for (Object alunoBD : listaAlunos) {
				
				int indiceLista = listaAlunos.indexOf(alunoBD);
				
				System.out.print("Opção: " + indiceLista + " - Nome: " + ((Aluno)alunoBD).getNome() + "\n");
			}
			
			while(!isValidIndex(valorDigitado, listaAlunos)) {
				System.out.print("\nEscolha uma opção :\n");
				
				valorDigitado = menu.nextLine();
				
				if(!isValidIndex(valorDigitado, listaAlunos))
					System.out.print("Opção inválida.\n");
			}	
			
			} catch (Exception e) {
				e.printStackTrace();
				menu.close();
			}
		
		return (Aluno)(listaAlunos.get(Integer.parseInt(valorDigitado)));
	}	
	
	public static boolean isNumber(String text) {
	    try {
	        Double.parseDouble(text);
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public static boolean isDate(String text) {
	    try {
	    	SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
	    	parser.parse(text);
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public static boolean isValidIndex(String text, List<Object> lista) {
	    try {
	    	int inteiro = Integer.parseInt(text);
	    	lista.get(inteiro);
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
}
