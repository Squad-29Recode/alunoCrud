package crud;

	import java.util.Scanner;

	import dao.AlunoDAO;
	import dao.CursoDAO;
	import dao.EscolhaDAO;
	import modelos.Escolha;
    import modelos.Aluno;
	import modelos.Curso;

	public class EscolhaCRUD {

		public static void main(String[] args) {
			
			Scanner s = new Scanner(System.in);
			EscolhaDAO escolhaDAO = new EscolhaDAO();
			AlunoDAO alunoDAO = new AlunoDAO();
			CursoDAO cursoDAO = new CursoDAO();	
			
			int opcao = 0, id = 0, id_Aluno = 0, id_Curso = 0; 
			
			String data_Escolha = "";
			String nome = "";
			
			do {
				
				System.out.println("\n============================== Escolha =================================\n");
				System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
				opcao = s.nextInt();
				s.nextLine();
				
				switch (opcao) {
				case 1:
					System.out.println("Digite a data da escolha:");
					data_Escolha = s.nextLine();
					System.out.println("Digite o nome do curso:");
					nome = s.nextLine();
					System.out.println("Digite o id do aluno:");
					id_Aluno = s.nextInt();
					s.nextLine();
					System.out.println("Digite o id do curso:");
					id_Curso = s.nextInt();
					s.nextLine();
					
					Aluno aluno1 = alunoDAO.readById(id_Aluno);
					Curso curso1 = cursoDAO.readById(id_Curso);
					
					
					Escolha escolha1 = new Escolha(data_Escolha, nome, id_Aluno, id_Curso);
					
					
					escolhaDAO.create(escolha1);
					
					break;
				case 2:
					
					for (Escolha e : escolhaDAO.read()) {
						
						System.out.println (e.toString());
					}
					
					break;
				case 3:
					System.out.println("Digite o id da escolha:");
					id = s.nextInt();
					s.nextLine();
					System.out.println("Digite a data da escolha:");
					data_Escolha = s.nextLine();
					System.out.println("Digite o nome curso:");
					nome = s.nextLine();
					System.out.println("Digite o id do aluno:");
					id_Aluno = s.nextInt();
					s.nextLine();
					System.out.println("Digite o id do curso:");
					id_Curso= s.nextInt();
					s.nextLine();
					
					Aluno aluno2 = alunoDAO.readById(id_Aluno);
					Curso curso2 = cursoDAO.readById(id_Curso);
					
					
					Escolha escolha2 = new Escolha(id, data_Escolha, nome, id_Aluno, id_Curso);
					
					escolhaDAO.update(escolha2);
					break;
				case 4:
					System.out.println("Digite um id:");
					id = s.nextInt();
					s.nextLine();
					
					escolhaDAO.delete(id);
					break;
				case 5:
					System.out.println("Digite um id:");
					id = s.nextInt();
					s.nextLine();
					
					Escolha escolha3 = escolhaDAO.readById(id);
					
					System.out.println(escolha3.toString());
					break;
				default:
					System.out.println(opcao != 0 ? "Opção invalida, digite novamente" : "");
					break;
				}
				
			} while (opcao != 0);
			
			System.out.println("Até mais!");
			s.close();

		}

	}

