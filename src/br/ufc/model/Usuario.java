package br.ufc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

@Entity(name="USUARIO")
public class Usuario {

	@Id
	@Column(name="USUARIO_ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idUsuario;
	
	@Column(name="LOGIN", nullable=false)
	private String login;
	
	@Column(name="SENHA", nullable=false)
	private String senha;
	
	@Column(name="NOME", nullable=false)
	private String nome;
	
	@Column(name="EMAIL", nullable=false)
	private String email;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="USUARIO_PAPEL", joinColumns=@JoinColumn(name="ID_USU", referencedColumnName="USUARIO_ID"),
		inverseJoinColumns=@JoinColumn(name="ID_PAP", referencedColumnName="PAPEL_ID"))
	private List<Papel> papelList;
	
	@OneToMany(mappedBy="autor",
				targetEntity=Classificado.class,
				fetch=FetchType.EAGER)
	private List<Classificado> classificados;
	
	@OneToMany(mappedBy="autor",
				cascade=CascadeType.ALL,
				targetEntity=Noticia.class,
				fetch=FetchType.EAGER)
	private List<Noticia> noticias;
	
	@OneToMany(mappedBy="autor",
				cascade=CascadeType.ALL,
				targetEntity=Comentario.class,
				fetch=FetchType.EAGER)
	private List<Comentario> comentarios;
	
	@Column(name="ATIVO")
	private boolean ativo;
	
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Papel> getPapelList() {
		return papelList;
	}

	public void setPapelList(List<Papel> papelList) {
		this.papelList = papelList;
	}

	public List<Classificado> getClassificados() {
		return classificados;
	}

	public void setClassificados(List<Classificado> classificados) {
		this.classificados = classificados;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
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

	@PreRemove
    public void preRemove(){
        for(Classificado classificado : classificados){
            classificado.setAutor(null);
            classificado.setIdAutor(null);
        }
    }
}
