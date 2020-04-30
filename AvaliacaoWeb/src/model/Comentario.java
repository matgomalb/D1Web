package model;

public class Comentario {

	private int id;
	private String nome;
	private String texto;
	private int noticiaId;
	

	public Comentario () {}
	
	public Comentario (int id, String nome, String texto) {
		setId(id);
		setNome(nome);
		setTexto(texto);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public int getNoticiaId() {
		return noticiaId;
	}

	public void setNoticiaId(int noticiaId) {
		this.noticiaId = noticiaId;
	}
	
	@Override
	public String toString() {
		return "{Id: " + getId() + ", Nome: " + getNome() + ", Texto: " + getTexto() + "}";
	}
}