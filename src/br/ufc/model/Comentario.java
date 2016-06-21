package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="COMENTARIO")
public class Comentario {

	@Id
	@Column(name="COMENTARIO_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idComentario;
	
	@Column(name="TEXTO", nullable=false)
	private String texto;
	
	@ManyToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(name="AUTOR_ID",
				referencedColumnName="USUARIO_ID", insertable=false, updatable=false)
	private Usuario autor;
	
	@Column(name="AUTOR_ID")
	private Long idAutor;
	
	@ManyToOne(fetch = FetchType.EAGER, optional=true)
	@JoinColumn(name="NOTICIA_ID",
				referencedColumnName="NOTICIA_ID", insertable=false, updatable=false, nullable=true)
	private Noticia noticia;
	
	@Column(name="NOTICIA_ID", nullable=false)
	private Long idNoticia;
	
	@Column(name="ATIVO")
	private boolean ativo;

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

	public Long getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
	}

	public Long getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(Long idNoticia) {
		this.idNoticia = idNoticia;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
