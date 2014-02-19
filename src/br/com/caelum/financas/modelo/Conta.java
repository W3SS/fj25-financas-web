package br.com.caelum.financas.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;



@Entity
@Cacheable
@Table(uniqueConstraints={
		@UniqueConstraint(columnNames={"agencia", "numero"})
})
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titular;
	private String agencia;
	//@Column(name="num", unique=true, nullable=false, updatable=false) APENAS ALGUNS EXEMPLOS DE ATRIBUTOS 
	private String numero;
	@Column(length=20, nullable=false)
	private String banco;
	
	//TEMOS TRANSACTION E READ-ONLY. A DIFERENCA E QUE TRANSACTION ELE INVALIDA 
	//O CACHE QUANDO A ENTITY FOR ALTERADA, READY ONLY NAO
	@Cache(usage=CacheConcurrencyStrategy.TRANSACTIONAL)
	@OneToMany(mappedBy="conta")//LADO FRACO DO RELACIONAMENTO
	private List<Movimentacao> movimentacoes;
	
	//CRIANDO UM ATRIVUTO DE VERSIONAMENTO. SERÁ USADO PELO JPA PARA CONTROLE DE CONCORRENCIA
	// POR DEFAULT ELE USA O LOCK OTIMISTA, OU SEJA, DEIXA UM OU MAIS USAREM A INSTACIA, PORME SO UM PODE COMMITAR, OS OUTROS TERAM EXCEPTION
	//JA O LOCK PESSIMISTA NEM DEIXA OUTROS USUARIOS ACESSAREM O OBJETO
	@Version
	private Integer versao;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}
	
	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
	}
	
	

}
