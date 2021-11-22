import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class MenuFornecedor {
	
	public void AbrirMenu(Scanner menu) {
		
		try {	
		
			while (true) {
				System.out.print("\nMenu Fornecedor\n\n");
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
				System.out.print("Falha ao abrir menu Fornecedor. Retorno: " + e.getMessage());
			}			
		}
	
		private void Cadastrar(Scanner menu) {
			
			try {
				while (true) {
					
					Fornecedor newFornecedor = new Fornecedor();
					
					newFornecedor = ObtemDadosFornecedor(newFornecedor, menu);
					
					System.out.print("\nCadastrar endereï¿½o? (S/N) ");			
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
				
				System.out.print("DescriÃ§Ã£o dos serviÃ§os do fornecedor:\n");
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
		// TODO Auto-generated method stub
			try {
				
				while(true) {
					
					Fornecedor fornecedorSelecionado = ObtemFornecedorSelecionado(menu);	
					
					if(fornecedorSelecionado == null) {
						System.out.print("Atualização cancelada.\n");
						break;
					}
					  	
					fornecedorSelecionado = ObtemDadosFornecedor(fornecedorSelecionado, menu);     	
			         
			        System.out.print(fornecedorSelecionado);
			        
			        System.out.print("\n\nConfirmar atualização? (S/N) ");
					
					if(menu.nextLine().toUpperCase().contains("S")) {
						fornecedorSelecionado.Atualizar();
						
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
				System.out.print("Falha ao atualizar Fornecedor. Retorno: " + e.getMessage());
			}

		}
		
		
		
		private void Excluir(Scanner menu) {
			
			try {
				
				while(true) {
					
					Fornecedor fornecedorSelecionado = ObtemFornecedorSelecionado(menu);
					
					if(fornecedorSelecionado == null) {
						System.out.print("Exclusï¿½o cancelada.\n");
						break;
					}
					
					System.out.print(fornecedorSelecionado);
			        
			        System.out.print("Confirmar exclusï¿½o? (S/N) ");
					
					if(menu.nextLine().toUpperCase().contains("S")) {
						fornecedorSelecionado.Remover();
						
						System.out.print("Realizar nova exclusï¿½o? (S/N) ");
						
						if(menu.nextLine().toUpperCase().toUpperCase().contains("S"))
							continue;					
						else
							break;
						
					}else {	
						System.out.print("Atualizaï¿½ï¿½o cancelada.\n");
						break;
					}	
				}
			} catch (Exception exception) {
				System.out.print("Falha ao excluir fornecedor. Retorno: " + exception.getMessage());
			}	
		
		}

		
		private Fornecedor ObtemFornecedorSelecionado(Scanner menu) {
			
			String valorDigitado = null;	
			
			var listaFornecedores = new Fornecedor().Buscar();
			int numeroElementos = listaFornecedores.size();
			
			try {
				
				if(numeroElementos == 0) {
					System.out.print("Nenhum fornecedor disponÃ­vel.\n"
								   + "Realizar o cadastro atravÃ©s do menu Cadastrar.\n"
								   + "Digite 'OK' para continuar.\n");
					menu.nextLine();
					return null;
				}
				
				System.out.print("\nLista de fornecedores cadastrados:\n\n");
				
				for (Object fornecedorBD : listaFornecedores) {
					
					int indiceLista = listaFornecedores.indexOf(fornecedorBD);
					
					System.out.print("OpÃ§Ã£o: " + indiceLista + " - Nome: " + ((Fornecedor)fornecedorBD).getNome() + "\n");
				}
				
				System.out.print("OpÃ§Ã£o: " + numeroElementos + " - Retornar\n");
				
				while(!isValidIndex(valorDigitado, listaFornecedores)) {
					System.out.print("\nEscolha uma opï¿½ï¿½o: ");
					
					valorDigitado = menu.nextLine();
					
					if(valorDigitado.contains(String.valueOf(numeroElementos)))
						return null;
					
					if(!isValidIndex(valorDigitado, listaFornecedores))
						System.out.print("OpÃ§Ã£o invÃ¡lida.\n");
				}	
				} catch (Exception e) {
					System.out.print("Falha ao obter aluno da lista. Retorno: " + e.getMessage());
				}
			
			return (Fornecedor)(listaFornecedores.get(Integer.parseInt(valorDigitado)));
				
		}
		
		

		private boolean isValidIndex(String text, List<Object> lista) {
			
			    try {
			    	int inteiro = Integer.parseInt(text);
			    	lista.get(inteiro);
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
		




}