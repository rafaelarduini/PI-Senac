import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MenuFornecedor {
	
	public void AbrirMenu(Scanner menu) {
		
		try {	
		
			while (true) {
				System.out.print("\nMenu Fornecedor\n\n");
		        System.out.print("Op��o 1 - Cadastrar \n");
		        System.out.print("Op��o 2 - Atualizar \n");
		        System.out.print("Op��o 3 - Excluir \n");
		        System.out.print("Op��o 4 - Retornar \n\n");
		        System.out.print("Digite uma op��o: ");
		
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
		            System.out.print("\nOp��o Inv�lida!\n");
		            break;		            
		        }
			}
			} catch (Exception e) {
				System.out.print("Falha ao abrir menu Fornecedor. Retorno: " + e.getMessage());
			}			
		}
	
		private void Cadastrar(Scanner menu) {
			
			try {
				while (true) {
					
					Fornecedor newFornecedor = new Fornecedor();
					
					newFornecedor = ObtemDadosFornecedor(newFornecedor, menu);
					
					System.out.print("\nCadastrar endere�o? (S/N) ");			
					if(menu.nextLine().toUpperCase().contains("S")) {
						newFornecedor.setEndereco(ObtemDadosEndereco(menu));
					}
					
					System.out.print("\nDodos do novo cadastro\n\n");
					
					System.out.print(newFornecedor);
					
					System.out.print("Confirmar cadastro? (S/N) ");
					
					if(menu.nextLine().toUpperCase().contains("S")) {
						newFornecedor.Adicionar();
						
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
			} catch(Exception exception) {
				System.out.print("Falha ao cadastrar Fornecedor. Retorno: " + exception.getMessage());
			}
		}
		
		private Fornecedor ObtemDadosFornecedor(Fornecedor fornecedor, Scanner menu) {

			String valorDigitado = null;
			
			try {			
				System.out.print("\nDados do Fornecedor\n\n");
				
				System.out.print("Informe o nome:\n");		
				fornecedor.setNome(menu.nextLine());
				
				System.out.print("Informe o e-mail:\n");
				fornecedor.setEmail(menu.nextLine());
				
				System.out.print("Informe o telefone:\n");
				fornecedor.setTelefone(menu.nextLine());
				
				System.out.print("Informe o CNPJ:\n");
				fornecedor.setCNPJ(menu.nextLine());
				
				System.out.print("Informe a atividade principal do fornecedor:\n");
				fornecedor.setAtividadePrincipal(menu.nextLine());
				
				System.out.print("Descrição dos serviços do fornecedor:\n");
				fornecedor.setCNPJ(menu.nextLine());					
				
			}catch(Exception e) {
				System.out.print("Falha ao obter dados do Fornecedor. Retorno: " + e.getMessage());
			}	
			return fornecedor;
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
						System.out.print("Valor inv�lido.\n");
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
				System.out.print("Falha ao obter dados de Endere�o. Retorno: " + e.getMessage());
			}	
			return novoEndereco;
		}
		
		
		
		private void Atualizar(Scanner menu) {
		// TODO Auto-generated method stub
		
		}
		
		
		
		private void Excluir(Scanner menu) {
		// TODO Auto-generated method stub
		
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



}