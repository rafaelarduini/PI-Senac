import java.util.List;
import java.util.Scanner;

public class MenuDisciplina {
	
	public void AbrirMenu() {
		
		Scanner menu = new Scanner (System.in);
		
		try {	
		
			while (true) {
				System.out.print("\nMenu Disciplina\n\n");
		        System.out.print("Opção 1 - Cadastrar \n");
		        System.out.print("Opção 2 - Atualizar \n");
		        System.out.print("Opção 3 - Excluir \n");
		        System.out.print("Opção 4 - Retornar \n\n");
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
			
			Disciplina novaDisciplina = new Disciplina();
			
			novaDisciplina = ObtemDadosDisciplina(novaDisciplina);
			
			System.out.print("\nDodos do novo cadastro\n\n");
					
			System.out.print(novaDisciplina);
			
			System.out.print("\n\nConfirmar cadastro? (S/N)\n");
			
			if(menu.nextLine().contains("S")) {
				novaDisciplina.Adicionar();
				
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
	
	private Disciplina ObtemDadosDisciplina(Disciplina disciplina) {
		
		Scanner menu = new Scanner (System.in);
		String valorDigitado = null;
		
		try {			
			
			System.out.print("Informe o nome:\n");		
			disciplina.setNome( menu.nextLine());
			
			while (!isNumber(valorDigitado)) {				
				System.out.print("\nCarga horária: ");			
				valorDigitado = menu.nextLine();
				
				if(!isNumber(valorDigitado))
					System.out.print("Valor inválido.\n");
			}
			
			disciplina.setCargaHoraria(Integer.parseInt(valorDigitado));
			valorDigitado = null;				
			
		}catch(Exception e) {
			e.printStackTrace();
			menu.close();
		}	
		return disciplina;
	}
	
	private void Atualizar() {
		
		Scanner menu = new Scanner (System.in);
		
		try {
			
			Disciplina disciplinaSelecionada = ObtemDisciplinaSelecionada();			
			  	
        	disciplinaSelecionada = ObtemDadosDisciplina(disciplinaSelecionada);     	
	         
	        System.out.print(disciplinaSelecionada);
	        
	        System.out.print("\n\nConfirmar atualização? (S/N)\n");
			
			if(menu.nextLine().contains("S")) {
				disciplinaSelecionada.Atualizar();
				
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
	
	private Disciplina ObtemDisciplinaSelecionada() {
		
		Scanner menu = new Scanner (System.in);			
		String valorDigitado = null;		
		var listaDisciplinas = new Disciplina().Buscar();
		
		try {
			
			if(listaDisciplinas.size() == 0) {
				System.out.print("Nenhuma disciplina disponívies.\n"
							   + "Realizar o cadastro através do menu Cadastrar.\n"
							   + "Digite 'OK' para continuar.\n");
				menu.nextLine();
				return null;
			}
			
			System.out.print("Lista de disciplinas disponívies:\n");
			
			for (Object disciplinaBD : listaDisciplinas) {
				
				int indiceLista = listaDisciplinas.indexOf(disciplinaBD) == -1 ? 0 : listaDisciplinas.indexOf(disciplinaBD);
				
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
			
			Disciplina disciplinaSelecionada = ObtemDisciplinaSelecionada();
			
			System.out.print(disciplinaSelecionada);
	        
	        System.out.print("\n\nConfirmar exclusão? (S/N)\n");
			
			if(menu.nextLine().contains("S")) {
				disciplinaSelecionada.Remover();
				
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
	
	public static boolean isNumber(String text) {
	    try {
	        Double.parseDouble(text);
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
