package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Escolha;
import modelos.Aluno;
import modelos.Curso;

public class EscolhaDAO {

	//CREATE
		public void create (Escolha escolha) {
			
			String sql = "INSERT INTO escolha (data_Escolha, nome, id_Aluno, id_Curso) VALUES (?, ?, ?, ?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, escolha.getData_Escolha());
				pstm.setString(2, escolha.getNome());
				pstm.setInt(3, escolha.getId_Aluno());
				pstm.setInt(4, escolha.getId_Curso());

								pstm.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}finally {
				 try {
					
					 if (pstm !=null) {
						 pstm.close();
					
					 }
					 if (conn !=null) {
						 conn.close();
					 }
					 
					 }catch (Exception e) {
						 e.printStackTrace();
					 }
		}
			
		}

		//READ
		public List<Escolha> read(){
			List<Escolha> escolhaList = new ArrayList<Escolha>();
			String sql = "select * from escolha";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			try {
				conn = ConnectionMySQL.createConnectionMySQL();
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					
					Escolha escolha = new Escolha();
					Aluno aluno = new Aluno();
					Curso curso = new Curso();
					
					escolha.setId(rset.getInt("id_Escolha"));
					escolha.setData_Escolha(rset.getString("data_Escolha"));
					escolha.setNome(rset.getString("nome"));
					escolha.setId_Aluno(rset.getInt("id_Aluno"));
			        escolha.setId_Curso(rset.getInt("id_Curso"));

			        aluno.setId(rset.getInt("id_Aluno"));
					
					curso.setId(rset.getInt("id_Curso"));
				
		
					escolha.setAluno(aluno);
		            escolha.setCurso(curso);

					escolhaList.add(escolha);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			 try {
				
				 if (pstm !=null) {
					 pstm.close();
				
				 }
				 if (conn !=null) {
					 conn.close();
				 }
				 
				 }catch (Exception e) {
					 e.printStackTrace();
				 }
	}
			
			return escolhaList;
		}
		
		//UPDATE
		public void update (Escolha escolha) {
			String sql = "UPDATE escolha SET data_Escolha = ?, nome = ?, id_Aluno = ?, id_Curso = ? WHERE id_Escolha = ?";

			Connection conn = null;
			PreparedStatement pstm = null;

			try {

				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setString(1, escolha.getData_Escolha());
				pstm.setString(2, escolha.getNome());
				pstm.setInt(3, escolha.getId_Aluno());
				pstm.setInt(4, escolha.getId_Curso());
				pstm.setInt(5, escolha.getId());

				pstm.execute();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		
		//DELETE
		public void delete (int id_Escolha) {
			String sql = "DELETE FROM escolha WHERE id_escolha = ?";

			Connection conn = null;
			PreparedStatement pstm = null;

			try {

				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setInt(1, id_Escolha);

				pstm.execute();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		//readById
		public Escolha readById (int id_Escolha) {
			Escolha escolha = new Escolha();
			String sql = "select * from escolha WHERE id_Escolha = ?";

			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;

			try {
				conn = ConnectionMySQL.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setInt(1, id_Escolha);

				rset = pstm.executeQuery();

				rset.next();

				Aluno aluno = new Aluno ();
				Curso curso = new Curso();

				escolha.setId(rset.getInt("id_Escolha"));
				escolha.setData_Escolha(rset.getString("data_Escolha"));
				escolha.setNome(rset.getString("nome"));
				escolha.setId_Aluno(rset.getInt("id_Aluno"));
				escolha.setId_Curso(rset.getInt("id_Curso"));

				aluno.setId(rset.getInt("id_Aluno"));
			
				curso.setId(rset.getInt("id_Curso"));

				escolha.setAluno(aluno);
				escolha.setCurso(curso);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return escolha;
		}
	}

