import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class MenuProfessor {
	
public void AbrirMenu(Scanner menu) {
	
	try {	
	
		while (true) {
			System.out.print("\nMenu Professor\n\n");
	        System.out.print("Opï¿½ï¿½o 1 - Cadastrar \n");
	        System.out.print("Opï¿½ï¿½o 2 - Atualizar \n");
	        System.out.print("Opï¿½ï¿½o 3 - Excluir \n");
	        System.out.print("Opï¿½ï¿½o 4 - Retornar \n\n");
	        System.out.print("Digite uma opï¿½ï¿½o: ");
	
	        String opcao = menu.nextLine();
	
	        switch (opcao) {
	        case "1":	        	
	        	Cadastrar(menu);		        	
	            break;
	
	        case "2":
	        	Atualizar(menu);
	            break;
	
	        case "3":
	        	Excluir(menu);
	            break;		            
	            
	        case "4":
	        	return;
	            
	        default:
	            System.out.print("\nOpï¿½ï¿½o Invï¿½lida!\n");
	            break;		            
	        }
		}
		} catch (Exception e) {
			System.out.print("Falha ao abrir menu Professor. Retorno: " + e.getMessage());
		}			
	}

private void Cadastrar(Scanner menu) {
	
	try {
		
		while (true) {
			
			Professor novoProfessor = new Professor();
			
			novoProfessor = ObtemDadosProfessor(novoProfessor, menu);
			
			System.out.print("\nCadastrar endereÃ§o? (S/N) ");			
			if(menu.nextLine().toUpperCase().contains("S")) {
				novoProfessor.setEndereco(ObtemDadosEndereco(menu));
			}
			
			System.out.print("\nCadastrar disciplinas ministradas? (S/N) ");			
			if(menu.nextLine().toUpperCase().contains("S")) {
				novoProfessor = ObtemDadosDisciplina(novoProfessor, menu);
			}		
		
			System.out.print("\nDados do novo cadastro\n\n");
					
			System.out.print(novoProfessor);
			
			System.out.print("Confirmar cadastro? (S/N) ");
			
			if(menu.nextLine().toUpperCase().contains("S")) {
				novoProfessor.Adicionar();
				
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
		System.out.print("Falha ao cadastrar Professor. Retorno: " + e.getMessage());
	}		
}

private Professor ObtemDadosProfessor(Professor professor, Scanner menu) {

	String valorDigitado = null;
	
	try {			
		System.out.print("\nDados do Professor\n\n");
		
		System.out.print("Informe o nome:\n");		
		professor.setNome( menu.nextLine());
		
		System.out.print("Informe o e-mail:\n");		
		professor.setEmail( menu.nextLine());
		
		System.out.print("Informe o telefone:\n");		
		professor.setTelefone( menu.nextLine());
		
		System.out.print("Informe o CPF:\n");		
		professor.setCPF( menu.nextLine());
		
		while (!isDate(valorDigitado)) {				
			System.out.print("Informe data de nascimento (dd/MM/yyyy):\n");	
			valorDigitado = menu.nextLine();
			
			if(!isDate(valorDigitado))
				System.out.print("Valor invï¿½lido.\n");
		}
		
		professor.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(valorDigitado));
		
		System.out.print("Informe o departamento:\n");		
		professor.setDepartamento( menu.nextLine());
		
		System.out.print("Informe o valor hora aula:\n");		
		professor.setValorHoraAula(Integer.parseInt(menu.nextLine()));
		
		professor.CalculaSalario();
		
	}catch(ParseException e) {
		System.out.print("Falha ao obter dados do Professor. Retorno: " + e.getMessage());
	}	
	return professor;
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
				System.out.print("Valor invï¿½lido.\n");
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
		System.out.print("Falha ao obter dados de Endereï¿½o. Retorno: " + e.getMessage());
	}	
	return novoEndereco;
}

private void Atualizar(Scanner menu) {
	
	try {
		
		while (true) {
			
			Professor professorSelecionado = ObtemProfessorSelecionado(menu);
			
			if(professorSelecionado == null) {
				System.out.print("Atualizaï¿½ï¿½o cancelada.\n");
				break;
			}
			
			System.out.print("Professor selecionado: " + professorSelecionado.getNome());
			
			System.out.print("\n\nAtualizar:\n");
	        System.out.print("Opï¿½ï¿½o 1 - Dados do Professor \n");
	        System.out.print("Opï¿½ï¿½o 2 - Endereï¿½o do professor\n");
	        System.out.print("Opï¿½ï¿½o 3 - Disciplinas do professor\n");
	        System.out.print("Opï¿½ï¿½o 4 - Retornar \n\n");
	        System.out.print("Digite uma opï¿½ï¿½o: ");
	
	        String opcao = menu.nextLine();
	
	        switch (opcao) {
	        case "1":	        	
	        	professorSelecionado = ObtemDadosProfessor(professorSelecionado , menu);     	
	            break;
	
	        case "2":
	        	professorSelecionado .setEndereco(ObtemDadosEndereco(menu));
	            break;
	
	        case "3":	        	
	        	professorSelecionado = AtualizaDisciplinaMinistradas(professorSelecionado,menu);
	            break;
	            
	        case "4":
	        	return;
	
	        default:
	            System.out.print("\nOpï¿½ï¿½o Invï¿½lida!\n");
	            break;	            
	        }
	        
	        System.out.print(professorSelecionado );
	        
	        System.out.print("\n\nConfirmar atualizaï¿½ï¿½o? (S/N) ");
			
			if(menu.nextLine().toUpperCase().contains("S")) {
				professorSelecionado .Atualizar();
				
				System.out.print("Realizar nova atualizaï¿½ï¿½o? (S/N) ");
				
				if(menu.nextLine().toUpperCase().contains("S"))
					continue;
				else
					break;
				
			}else {	
				System.out.print("Atualizaï¿½ï¿½o cancelada.\n");
				break;
			}	
		}
	} catch (Exception e) {
		System.out.print("Falha ao atualizar Aluno. Retorno: " + e.getMessage());
	}	
}

private Professor ObtemProfessorSelecionado(Scanner menu) {

	String valorDigitado = null;		
	var listaProfessores = new Professor().Buscar();
	int numeroElementos = listaProfessores.size();
	
	try {
		
		if(numeroElementos == 0) {
			System.out.print("Nenhuma professor disponï¿½vies.\n"
						   + "Realizar o cadastro atravï¿½s do menu Cadastrar.\n"
						   + "Digite 'OK' para continuar.\n");
			menu.nextLine();
			return null;
		}
		
		System.out.print("\nLista de professores:\n\n");
		
		for (Object professorDB : listaProfessores) {
			
			int indiceLista = listaProfessores.indexOf(professorDB);
			
			System.out.print("Opï¿½ï¿½o: " + indiceLista + " - Nome: " + ((Professor)professorDB).getNome() + "\n");
		}
		
		System.out.print("Opï¿½ï¿½o: " + numeroElementos + " - Retornar\n");
		
		while(!isValidIndex(valorDigitado, listaProfessores)) {
			System.out.print("\nEscolha uma opï¿½ï¿½o: ");
			
			valorDigitado = menu.nextLine();
			
			if(valorDigitado.contains(String.valueOf(numeroElementos)))
				return null;
			
			if(!isValidIndex(valorDigitado, listaProfessores))
				System.out.print("Opï¿½ï¿½o invï¿½lida.\n");
		}	
		} catch (Exception e) {
			System.out.print("Falha ao obter aluno da lista. Retorno: " + e.getMessage());
		}
	
	return (Professor)(listaProfessores.get(Integer.parseInt(valorDigitado)));
}

private Professor ObtemDadosDisciplina(Professor novoProfessor ,Scanner menu) {	
			
	try {		
		System.out.print("\nSelecionar disciplinas do professor\n");
		
		while (true) {
			
			var disciplinaSelecionada = ObtemDisciplinaSelecionada(menu);
			
			if(disciplinaSelecionada == null) {
				return null;
			}
			
			System.out.print("\n\nAdicionar? (S/N) ");
			
			if(menu.nextLine().toUpperCase().contains("S")) {
				novoProfessor.setDisciplinaMinistrada(disciplinaSelecionada);
				
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
	
	return novoProfessor;
}

private Professor AtualizaDisciplinaMinistradas(Professor novoProfessor ,Scanner menu) {			
	try {
		novoProfessor.apagarDisciplinas();
		System.out.print("\nSelecionar disciplinas do professor\n");
		
		while (true) {
			
			var disciplinaSelecionada = ObtemDisciplinaSelecionada(menu);
			
			if(disciplinaSelecionada == null) {
				return null;
			}
			
			System.out.print("\n\nAdicionar? (S/N) ");
			
			if(menu.nextLine().toUpperCase().contains("S")) {
				novoProfessor.setDisciplinaMinistrada(disciplinaSelecionada);
				
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
	
	return novoProfessor;
}

private Disciplina ObtemDisciplinaSelecionada(Scanner menu) {

	String valorDigitado = null;		
	var listaDisciplinas = new Disciplina().Buscar();
	int numeroElementos = listaDisciplinas.size();
	
	try {
		
		if(listaDisciplinas.size() == 0) {
			System.out.print("Nenhuma disciplina disponï¿½vies.\n"
						   + "Realizar o cadastro atravï¿½s do menu Disciplinas.\n"
						   + "Digite 'OK' para continuar.\n");
			menu.nextLine();
			return null;
		}
		
		System.out.print("\nLista de disciplinas disponï¿½vies:\n\n");
		
		
		for (Object disciplinaBD : listaDisciplinas) {
			
			int indiceLista = listaDisciplinas.indexOf(disciplinaBD);
			
			System.out.print("Opï¿½ï¿½o: " + indiceLista + " - Nome: " + ((Disciplina)disciplinaBD).getNome() + "\n");
		}
		
		System.out.print("Opï¿½ï¿½o: " + numeroElementos + " - Retornar\n");
		
		while(!isValidIndex(valorDigitado, listaDisciplinas)) {
			System.out.print("\nEscolha uma opï¿½ï¿½o: ");
			
			valorDigitado = menu.nextLine();
			
			if(valorDigitado.contains(String.valueOf(numeroElementos))) {
				
				return null;
			}
			
			var disc = listaDisciplinas.get(Integer.parseInt(valorDigitado));
			System.out.print("\n"+disc);
			
			if(!isValidIndex(valorDigitado, listaDisciplinas))
				System.out.print("Opï¿½ï¿½o invï¿½lida.\n");
		}	
		
		} catch (Exception e) {
			System.out.print("Falha ao obter disciplina da lista. Retorno: " + e.getMessage());
		}
	
	return (Disciplina)(listaDisciplinas.get(Integer.parseInt(valorDigitado)));
}

private void Excluir(Scanner menu) {
	
	try {
		
		while(true) {
			
			Professor professorSelecionado = ObtemProfessorSelecionado(menu);
			
			if(professorSelecionado == null) {
				System.out.print("Exclusão cancelada.\n");
				break;
			}
			
			System.out.print(professorSelecionado);
	        
	        System.out.print("Confirmar exclusão? (S/N) ");
			
			if(menu.nextLine().toUpperCase().contains("S")) {
				professorSelecionado.Remover();
				
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
		System.out.print("Falha ao excluir Professor. Retorno: " + e.getMessage());
	}	
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