
import java.util.Scanner;

public class MenuPrincipal {

	public static void main(String[] args) {		
		
		Scanner menu = new Scanner (System.in);
	
		try {
	
	        while (true) {            
	
		        System.out.print("\nMenu Principal\n\n");
		        System.out.print("Opção 1 - Disciplina \n");
		        System.out.print("Opção 2 - Aluno \n");
		        System.out.print("Opção 3 - Professor \n");
		        System.out.print("Opção 4 - Fornecedor \n");
		        System.out.print("Opção 5 - Sair \n\n");
		        System.out.print("Digite uma opção: \n");
		
		        String opcao = menu.nextLine();		
		
		        switch (opcao) {
		        
		        case "1":
		            new MenuDisciplina().AbrirMenu(menu);
		            break;
		            
		        case "2":
		            new MenuAluno().AbrirMenu(menu);
		            break;
		
		        case "3":
		        	new MenuProfessor().AbrirMenu(menu);
		            break;
		            
		        case "4":
		        	//new MenuFornecedor().AbrirMenu();
		            break;
		
		        case "5":
		        	System.out.print("\nAté logo!");
		        	menu.close();
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
}
