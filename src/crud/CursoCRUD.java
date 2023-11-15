package crud;

import java.util.Scanner;
import dao.CursoDAO;
import modelos.Curso;

public class CursoCRUD {

	public static void main(String[] args) {
		
		CursoDAO cursoDAO = new CursoDAO ();	
		Scanner s = new Scanner (System.in);
	
		int opcao = 0, id_Curso = 0;
		
		String curso = ""; 
	    String data_Curso = "";
		
		do {
			
			System.out.println("\n=============================== Curso ===============================\n");
			System.out.println("1-CRIAR  2-CONSULTAR  3-ATUALIZAR  4-DELETAR  5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				
			   System.out.println("Digite o curso:");
			   curso = s.nextLine();
			   System.out.println("Digite a data do curso:");
			   data_Curso = s.nextLine();
			  
				
			  Curso curso1 = new Curso (curso, data_Curso);
			   
			   cursoDAO.create (curso1);
			   
			   break;
			   
			case 2:
				
				for (Curso c : cursoDAO.read()){
					System.out.println(c.toString());
				}
				
				break;
				
			 case 3:
				 
				
				System.out.println("Digite o id:");
				id_Curso = s.nextInt();
				s.nextLine();
				System.out.println("Digite o curso:");
				curso= s.nextLine();
				System.out.println("Digite a data do curso:");
				data_Curso = s.nextLine();
				
				Curso curso2 = new Curso(curso, id_Curso, data_Curso); 
				cursoDAO.update(curso2);	
				break;
					   
			 case 4:
				 System.out.println("Digite um id:");
				 id_Curso = s.nextInt();
				 s.nextLine();
				 	
				cursoDAO.delete(id_Curso);		
				break;
						   
			 case 5:
				 
				 System.out.println("Digite um id:");
				 id_Curso = s.nextInt();
				 s.nextLine();
				 	
				Curso curso3 = cursoDAO.readById(id_Curso);
				System.out.println(curso3.toString());
				break;
				
			default:	
				break;
			}
			
			
		} while (opcao !=0);
		
		System.out.println("Até mais!");
		 s.close();
    }

}
