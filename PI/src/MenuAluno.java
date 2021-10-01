import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class MenuAluno {
	
	public void AbrirMenu(Scanner menu) {
		
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
			System.out.print("Falha ao abrir menu Aluno. Retorno: " + e.getMessage());
		}			
	}	
	
	private void Cadastrar() {
		
		Scanner menu = new Scanner (System.in);
		
		try {
			
			while (true) {
				
				Aluno novoAluno = new Aluno();
				
				novoAluno = ObtemDadosAluno(novoAluno, menu);
				
				System.out.print("\nCadastrar endereço? (S/N) ");			
				if(menu.nextLine().toUpperCase().contains("S")) {
					novoAluno.setEndereco(ObtemDadosEndereco(menu));
				}
				
				System.out.print("\nCadastrar boletim? (S/N) ");			
				if(menu.nextLine().toUpperCase().contains("S")) {
					novoAluno.setBoletim(ObtemDadosBoletim(menu));
				}
			
				System.out.print("\nDodos do novo cadastro\n\n");
						
				System.out.print(novoAluno);
				
				System.out.print("Confirmar cadastro? (S/N) ");
				
				if(menu.nextLine().toUpperCase().contains("S")) {
					novoAluno.Adicionar();
					
					System.out.print("Realizar novo cadastro? (S/N) ");
					
					if(menu.nextLine().toUpperCase().contains("S"))
						continue;
					else
						break;
					
				}else {	
					System.out.print("Novo cadastro apagado.\n");
					break;
				}	
			}
		} catch (Exception e) {
			System.out.print("Falha ao cadastrar Aluno. Retorno: " + e.getMessage());
		}		
	}
	
	private Aluno ObtemDadosAluno(Aluno aluno, Scanner menu) {

		String valorDigitado = null;
		
		try {			
			System.out.print("\nDados do Aluno\n");
			
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
			System.out.print("Falha ao obter dados do Aluno. Retorno: " + e.getMessage());
		}	
		return aluno;
	}
	
	private Endereco ObtemDadosEndereco(Scanner menu) {

		var novoEndereco = new Endereco();
		String valorDigitado = null;
		
		try {	
			
			System.out.print("\nEndereco\n");
			
			System.out.print("Informe o Logradouro:\n");		
			novoEndereco.setLogradouro(menu.nextLine());
			
			while (!isInt(valorDigitado)) {				
				System.out.print("Informe o Numero:\n");			
				valorDigitado = menu.nextLine();
				
				if(!isInt(valorDigitado))
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
			System.out.print("Falha ao obter dados de Endereço. Retorno: " + e.getMessage());
		}	
		return novoEndereco;
	}
	
	private void Atualizar() {
		
		Scanner menu = new Scanner (System.in);
		
		try {
			
			while (true) {
				
				Aluno alunoSelecionado = ObtemAlunoSelecionado(menu);
				
				if(alunoSelecionado == null) {
					System.out.print("Atualização cancelada.\n");
					break;
				}
				
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
		        	alunoSelecionado = ObtemDadosAluno(alunoSelecionado, menu);     	
		            break;
		
		        case "2":
		        	alunoSelecionado.setEndereco(ObtemDadosEndereco(menu));
		            break;
		
		        case "3":	        	
		        	alunoSelecionado.setBoletim(ObtemDadosBoletim(menu));
		            break;
		            
		        case "4":
		        	return;
		
		        default:
		            System.out.print("\nOpção Inválida!\n");
		            break;	            
		        }
		        
		        System.out.print(alunoSelecionado);
		        
		        System.out.print("\n\nConfirmar atualização? (S/N) ");
				
				if(menu.nextLine().toUpperCase().contains("S")) {
					alunoSelecionado.Atualizar();
					
					System.out.print("Realizar nova atualização? (S/N) ");
					
					if(menu.nextLine().toUpperCase().contains("S"))
						continue;
					else
						break;
					
				}else {	
					System.out.print("Atualização cancelada.\n");
					break;
				}	
			}
		} catch (Exception e) {
			System.out.print("Falha ao atualizar Aluno. Retorno: " + e.getMessage());
		}	
	}
	
	private Boletim ObtemDadosBoletim(Scanner menu) {
		
		var novoBoletim = new Boletim();
				
		try {		
			
			System.out.print("\nSelecionar disciplinas do novo boletim\n");
			
			while (true) {
				
				var disciplinaSelecionada = ObtemDisciplinaSelecionada(menu);
				
				if(disciplinaSelecionada == null) {
					return null;
				}
				
				var novaDisciplinaCursada = new DisciplinaCursada(disciplinaSelecionada);
				
				System.out.print("\n\n" + disciplinaSelecionada);
				
				System.out.print("\n\nAdicionar? (S/N) ");
				
				if(menu.nextLine().toUpperCase().contains("S")) {
					novoBoletim.addDisciplinaCursada(novaDisciplinaCursada);
					
					System.out.print("Adicionar nova disciplina? (S/N) ");
					
					if(!menu.nextLine().toUpperCase().contains("S"))
						break;
					
				}else {	
					System.out.print("Nova disciplina apagada.\n");					
				}		
				}	
			} catch (Exception e) {
				System.out.print("Falha ao obter dados do Boletim. Retorno: " + e.getMessage());
			}		
		
		return novoBoletim;
	}	
	
	private Disciplina ObtemDisciplinaSelecionada(Scanner menu) {

		String valorDigitado = null;		
		var listaDisciplinas = new Disciplina().Buscar();
		int numeroElementos = listaDisciplinas.size();
		
		try {
			
			if(listaDisciplinas.size() == 0) {
				System.out.print("Nenhuma disciplina disponívies.\n"
							   + "Realizar o cadastro através do menu Disciplinas.\n"
							   + "Digite 'OK' para continuar.\n");
				menu.nextLine();
				return null;
			}
			
			System.out.print("\nLista de disciplinas disponívies:\n\n");
			
			for (Object disciplinaBD : listaDisciplinas) {
				
				int indiceLista = listaDisciplinas.indexOf(disciplinaBD);
				
				System.out.print("Opção: " + indiceLista + " - Nome: " + ((Disciplina)disciplinaBD).getNome() + "\n");
			}
			
			System.out.print("Opção: " + numeroElementos + " - Retornar\n");
			
			while(!isValidIndex(valorDigitado, listaDisciplinas)) {
				System.out.print("\nEscolha uma opção: ");
				
				valorDigitado = menu.nextLine();
				
				if(valorDigitado.contains(String.valueOf(numeroElementos))) {
					return null;
				}
				
				if(!isValidIndex(valorDigitado, listaDisciplinas))
					System.out.print("Opção inválida.\n");
			}	
			
			} catch (Exception e) {
				System.out.print("Falha ao obter disciplina da lista. Retorno: " + e.getMessage());
			}
		
		return (Disciplina)(listaDisciplinas.get(Integer.parseInt(valorDigitado)));
	}
	
	private void Excluir() {
		
		Scanner menu = new Scanner (System.in);
		
		try {
			
			while(true) {
				
				Aluno alunoSelecionado = ObtemAlunoSelecionado(menu);
				
				if(alunoSelecionado == null) {
					System.out.print("Exclusão cancelada.\n");
					break;
				}
				
				System.out.print(alunoSelecionado);
		        
		        System.out.print("Confirmar exclusão? (S/N) ");
				
				if(menu.nextLine().toUpperCase().contains("S")) {
					alunoSelecionado.Remover();
					
					System.out.print("Realizar nova exclusão? (S/N) ");
					
					if(menu.nextLine().toUpperCase().toUpperCase().contains("S"))
						continue;					
					else
						break;
					
				}else {	
					System.out.print("Atualização cancelada.\n");
					break;
				}	
			}
		} catch (Exception e) {
			System.out.print("Falha ao excluir aluno. Retorno: " + e.getMessage());
		}	
	}
	
	private void Avaliar() {
		
		Scanner menu = new Scanner (System.in);
		
		try {
			
			while(true) {
				
				Aluno alunoSelecionado = ObtemAlunoSelecionado(menu);
				
				if(alunoSelecionado == null) {
					System.out.print("Avaliação cancelada.\n");
					break;
				}
				
				if (alunoSelecionado.getBoletim() == null) {
					System.out.print("Aluno ainda não possui um boletim cadastrado.\n"
									+"Você pode adicionar um boletim através do menu Atualizar Aluno.\n"
									+ "Digite 'OK' para continuar.\n");
					menu.nextLine();
					break;
				}
			
				System.out.print("Boletim do aluno: " + alunoSelecionado.getNome() + "\n\n");
				
				System.out.print(alunoSelecionado.getBoletim());

				System.out.print("Inserir notas? (S/N) ");			
				if(menu.nextLine().toUpperCase().contains("S")) {
					alunoSelecionado = AdicionaNotasBoletim(alunoSelecionado, menu);  
				}
				
				System.out.print("Inserir frequência? (S/N) ");			
				if(menu.nextLine().toUpperCase().contains("S")) {
					alunoSelecionado = AdicionaFrequencia(alunoSelecionado, menu);
				}			
		        
				alunoSelecionado.AvaliarAluno();
				
		        System.out.print("\nBoletim do aluno\n\n" + alunoSelecionado.getBoletim());
		        
		        if (alunoSelecionado.isAprovado()) {
					System.out.print("Aluno aprovado!");
				}else {
					System.out.print("Aluno reprovado!");
				}	
		        
		        System.out.print("\n\nConfirmar alterações? (S/N) ");
				
				if(menu.nextLine().toUpperCase().contains("S")) {
					alunoSelecionado.Atualizar();
					
					System.out.print("Realizar nova avaliação? (S/N) ");
					
					if(menu.nextLine().toUpperCase().contains("S"))
						continue;
					else
						break;
					
				}else {	
					System.out.print("Avaliação cancelada.\n");
					break;
				}
			}
		} catch (Exception e) {
			System.out.print("Falha ao realizar avaliação. Retorno: " + e.getMessage());
		}	
	}

	private Aluno AdicionaNotasBoletim(Aluno aluno, Scanner menu) {

		String valorDigitado = null;
		
		try {
			
			var boletim = aluno.getBoletim();
					
			var disciplinas = boletim.getDisciplinas();
			
			for (DisciplinaCursada disciplina : disciplinas) {
				
				System.out.print("\nDisciplina: " + disciplina.getNome());
				
				while (!isDouble(valorDigitado)) {				
					System.out.print("\nNota 1: ");			
					valorDigitado = menu.nextLine();
					
					if(!isDouble(valorDigitado))
						System.out.print("Valor inválido.\n");
				}
				
				disciplina.setNota1(Double.parseDouble(valorDigitado));				
				valorDigitado = null;
				
				while (!isDouble(valorDigitado)) {				
					System.out.print("\nNota 2: ");			
					valorDigitado = menu.nextLine();
					
					if(!isDouble(valorDigitado))
						System.out.print("Valor inválido.\n");
				}
				
				disciplina.setNota2(Double.parseDouble(valorDigitado));				
				valorDigitado= null;	
				
				disciplina.CalculaMedia();
				
			}
			
			boletim.setDisciplinas(disciplinas);			
			aluno.setBoletim(boletim);
			
		} catch (Exception e) {
			System.out.print("Falha ao adicionar notas ao Boletim. Retorno: " + e.getMessage());
		}
		
		return aluno;
	}
	
	private Aluno AdicionaFrequencia(Aluno aluno, Scanner menu) {

		String valorDigitado = null;
		
		try {
			
			System.out.print("\nInserir frequência\n");
			
			var boletim = aluno.getBoletim();
					
			var disciplinas = boletim.getDisciplinas();
			
			for (DisciplinaCursada disciplina : disciplinas) {
				
				System.out.print("\nDisciplina: " + disciplina.getNome()
								+"\nCarga horária: " + disciplina.getCargaHoraria() + " h");
				
				while (!isInt(valorDigitado)) {				
					System.out.print("\nFrequência(h): ");			
					valorDigitado = menu.nextLine();
					
					if(!isInt(valorDigitado))
						System.out.print("Valor inválido.\n");
				}
				
				disciplina.setFrequencia(Integer.parseInt(valorDigitado));
				valorDigitado = null;				
			}
			
			boletim.setDisciplinas(disciplinas);			
			aluno.setBoletim(boletim);			
			
		} catch (Exception e) {
			System.out.print("Falha ao adicionar frequência no Boletim. Retorno: " + e.getMessage());
		}
		
		return aluno;
	}	

	private Aluno ObtemAlunoSelecionado(Scanner menu) {

		String valorDigitado = null;		
		var listaAlunos = new Aluno().Buscar();
		int numeroElementos = listaAlunos.size();
		
		try {
			
			if(numeroElementos == 0) {
				System.out.print("Nenhuma aluno disponívies.\n"
							   + "Realizar o cadastro através do menu Cadastrar.\n"
							   + "Digite 'OK' para continuar.\n");
				menu.nextLine();
				return null;
			}
			
			System.out.print("\nLista de alunos:\n\n");
			
			for (Object alunoBD : listaAlunos) {
				
				int indiceLista = listaAlunos.indexOf(alunoBD);
				
				System.out.print("Opção: " + indiceLista + " - Nome: " + ((Aluno)alunoBD).getNome() + "\n");
			}
			
			System.out.print("Opção: " + numeroElementos + " - Retornar\n");
			
			while(!isValidIndex(valorDigitado, listaAlunos)) {
				System.out.print("\nEscolha uma opção: ");
				
				valorDigitado = menu.nextLine();
				
				if(valorDigitado.contains(String.valueOf(numeroElementos)))
					return null;
				
				if(!isValidIndex(valorDigitado, listaAlunos))
					System.out.print("Opção inválida.\n");
			}	
			} catch (Exception e) {
				System.out.print("Falha ao obter aluno da lista. Retorno: " + e.getMessage());
			}
		
		return (Aluno)(listaAlunos.get(Integer.parseInt(valorDigitado)));
	}	
	
	public static boolean isDouble(String text) {
	    try {
	        Double.parseDouble(text);
	        return true;
	    } catch (Exception e) {
	        return false;
	    }
	}
	
	public static boolean isInt(String text) {
	    try {
	        Integer.parseInt(text);
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
