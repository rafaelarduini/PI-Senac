import java.util.Scanner;

public class MenuProfessor {
	
public void AbrirMenu(Scanner menu) {
	
	try {	
	
		while (true) {
			System.out.print("\nMenu Professor\n\n");
	        System.out.print("Opção 1 - Cadastrar \n");
	        System.out.print("Opção 2 - Atualizar \n");
	        System.out.print("Opção 3 - Excluir \n");
	        System.out.print("Opção 4 - Calcular Salário \n");
	        System.out.print("Opção 5 - Retornar \n\n");
	        System.out.print("Digite uma opção: ");
	
	        String opcao = menu.nextLine();
	
	        switch (opcao) {
	        case "1":	        	
	        	//TODO:Cadastrar();		        	
	            break;
	
	        case "2":
	        	//TODO:Atualizar();
	            break;
	
	        case "3":
	        	//TODO:Excluir();
	            break;		            
	            
	        case "4":
	        	//TODO:CalculaSalario();
	            
	        case "5":
	        	return;
	
	        default:
	            System.out.print("\nOpção Inválida!\n");
	            break;		            
	        }
		}
		} catch (Exception e) {
			System.out.print("Falha ao abrir menu Professor. Retorno: " + e.getMessage());
		}			
	}	
}