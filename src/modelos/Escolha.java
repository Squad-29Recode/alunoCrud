package modelos;

public class Escolha {
	
	private int id_Escolha;
	private String data_Escolha;
	private String nome;
	private int id_Aluno;
	private int id_Curso;
	private Aluno aluno;
	private Curso curso;

	public Escolha() {
	}

	public Escolha(int id_Escolha, String data_Escolha, String nome, int id_Aluno, int id_Curso) {
		this.id_Escolha = id_Escolha;
		this.data_Escolha = data_Escolha;
		this.nome = nome;
		this.id_Aluno = id_Aluno;
		this.id_Curso = id_Curso;
	}


	public Escolha(String data_Escolha, String nome, int id_Aluno , int id_Curso) {
		this.data_Escolha = data_Escolha;
		this.nome = nome;
		this.id_Aluno = id_Aluno;
		this.id_Curso = id_Curso;
	}

	public int getId() {
		return id_Escolha;
	}

	public void setId(int id_Escolha) {
		this.id_Escolha = id_Escolha;
	}

	public String getData_Escolha() {
		return data_Escolha;
	}

	public void setData_Escolha(String data_Escolha) {
		this.data_Escolha = data_Escolha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getId_Aluno() {
		return id_Aluno;
	}

	public void setId_Aluno (int id_Aluno) {
		this.id_Aluno = id_Aluno;
	}

	public int getId_Curso() {
		return id_Curso;
	}

	public void setId_Curso(int id_Curso) {
		this.id_Curso = id_Curso;
	}
	   public void setAluno(Aluno aluno) {
	        this.aluno = aluno;
	    }

	    public void setCurso(Curso curso) {
	        this.curso = curso;
	    }
	

	@Override
	public String toString() {
		return "Escolha [id_Escolha=" + id_Escolha + ", data_Escolha=" + data_Escolha+ ", nome=" + nome + ", id_Aluno=" + id_Aluno+ ", id_Curso=" + id_Curso + "]";
	}

	

	}