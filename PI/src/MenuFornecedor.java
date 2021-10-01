import java.util.Scanner;

public class MenuFornecedor {
	
public void AbrirMenu(Scanner menu) {
	
	try {	
	
		while (true) {
			System.out.print("\nMenu Fornecedor\n\n");
	        System.out.print("Opção 1 - Cadastrar \n");
	        System.out.print("Opção 2 - Atualizar \n");
	        System.out.print("Opção 3 - Excluir \n");
	        System.out.print("Opção 4 - Retornar \n\n");
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
	        	return;
	
	        default:
	            System.out.print("\nOpção Inválida!\n");
	            break;		            
	        }
		}
		} catch (Exception e) {
			System.out.print("Falha ao abrir menu Fornecedor. Retorno: " + e.getMessage());
		}			
	}	
}