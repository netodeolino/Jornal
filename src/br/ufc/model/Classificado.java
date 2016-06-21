package br.ufc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="CLASSIFICADO")
public class Classificado {

	@Id
	@Column(name="CLASSIFICADO_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idClassificado;
	
	@Column(name="TITULO", nullable=false)
	private String titulo;
	
	@Column(name="TEXTO", nullable=false)
	private String texto;
	
	@Column(name="PRECO", nullable=false)
	private Double preco;
	
	@Column(name="TELEFONE", nullable=false)
	private String telefone;
	
	@Column(name="MELHOR_OFERTA")
	private Double melhorOferta;
	
	@Column(name="DATA_OFERTA")
	private Date dataOferta;
	
	@ManyToOne(fetch = FetchType.EAGER, optional=true)
	@JoinColumn(name="AUTOR_ID", referencedColumnName="USUARIO_ID",
				insertable=false, updatable=false, nullable=true)
	private Usuario autor;
	
	@Column(name="AUTOR_ID")
	private Long idAutor;

	public Long getIdClassificado() {
		return idClassificado;
	}

	public void setIdClassificado(Long idClassificado) {
		this.idClassificado = idClassificado;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Double getMelhorOferta() {
		return melhorOferta;
	}

	public void setMelhorOferta(Double melhorOferta) {
		this.melhorOferta = melhorOferta;
	}

	public Date getDataOferta() {
		return dataOferta;
	}

	public void setDataOferta(Date dataOferta) {
		this.dataOferta = dataOferta;
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
}
