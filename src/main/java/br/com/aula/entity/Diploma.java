package br.com.aula.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "diploma_aluno")
public class Diploma {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "codigo")
	private String codigo;

	@Column(name = "descricao")
	private String descricao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_hora_criacao")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
	private Date dataHoraCriacao;

	@Temporal(value = TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "data_criacao")
	private Date dataCriacao;

	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm:ss")
	@Column(name = "hora_criacao")
	private Date horaCriacao;

	@OneToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Aluno aluno;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(UUID codigo) {
		this.codigo = UUID.randomUUID().toString();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public void setDataHoraCriacao(Date dataHoraCriacao) {
		this.dataHoraCriacao = dataHoraCriacao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getHoraCriacao() {
		return horaCriacao;
	}

	public void setHoraCriacao(Date horaCriacao) {
		this.horaCriacao = horaCriacao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	@PrePersist
	private void prePersist() {
		this.codigo = UUID.randomUUID().toString();
		this.dataHoraCriacao = new Date();
		this.dataCriacao = new Date();
		this.horaCriacao = new Date();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diploma other = (Diploma) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
