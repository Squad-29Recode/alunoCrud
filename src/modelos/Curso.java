package modelos;

public class Curso {

	 //atributos
	private String curso;
	private int id_Curso;
	private String data_Curso;
	
	//construtor
	public Curso () {
	}
	
	public Curso (String curso, int id_Curso, String data_Curso) {
		this.curso = curso;
		this.id_Curso = id_Curso;
		this.data_Curso = data_Curso;
	}
	
	public Curso(String curso, String data_Curso) {
		this.curso = curso;
		this.data_Curso = data_Curso;
	}

	//getters e setters	
	public int getId() {
		return id_Curso;
	}

	public void setId(int id_Curso) {
		this.id_Curso = id_Curso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getData_Curso() {
		return data_Curso;
	}

	public void setData_Curso(String data_Curso) {
		this.data_Curso = data_Curso;
	}

	@Override
	public String toString() {
		return "Curso [id_Curso=" + id_Curso + ", curso=" + curso + ", data_curso=" + data_Curso + "]";
	}
		
}

