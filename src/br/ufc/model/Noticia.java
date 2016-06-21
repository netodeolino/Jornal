package br.ufc.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="NOTICIA")
public class Noticia {

	@Id
	@Column(name="NOTICIA_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idNoticia;
	
	@Column(name="TITULO", nullable=false)
	private String titulo;
	
	@Column(name="SUBTITULO", nullable=false)
	private String subtitulo;
	
	@Lob
	@Column(name="TEXTO", nullable=false)
	private String texto;
	
	@Column(name="DATA_NOTICIA", nullable=false)
	private Date dataNoticia;
	
	@ManyToOne(fetch = FetchType.EAGER, optional=true)
	@JoinColumn(name="AUTOR_ID",
				referencedColumnName="USUARIO_ID", insertable=false, updatable=false, nullable=true)
	private Usuario autor;
	
	@Column(name="AUTOR_ID")
	private Long idAutor;
	
	@ManyToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(name="SECAO_ID",
				referencedColumnName="SECAO_ID", insertable=false, updatable=false, nullable=true)
	private Secao secao;
	
	@Column(name="SECAO_ID")
	private Long idSecao;
	
	@Column(name="ATIVO")
	private boolean ativo;
	
	@OneToMany(mappedBy="noticia",
			cascade=CascadeType.ALL,
			targetEntity=Comentario.class,
			fetch=FetchType.EAGER)
	private List<Comentario> comentarios;
	
	public Long getIdNoticia() {
		return idNoticia;
	}

	public void setIdNoticia(Long idNoticia) {
		this.idNoticia = idNoticia;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDataNoticia() {
		return dataNoticia;
	}

	public void setDataNoticia(Date dataNoticia) {
		this.dataNoticia = dataNoticia;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}

	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}

	public Long getIdSecao() {
		return idSecao;
	}

	public void setIdSecao(Long idSecao) {
		this.idSecao = idSecao;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
