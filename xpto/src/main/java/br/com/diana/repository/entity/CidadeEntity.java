package br.com.diana.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cidade")
public class CidadeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer codigo;
	
	@Column(name = "ibge_id")
    private String idIbge;

    @Column(name = "uf")
    private String estado;

    @Column(name = "name")
    private String nomeCidade;

    private String capital;

    @Column(name = "lon")
    private String longitude;

    @Column(name = "lat")
    private String latitude;

    @Column(name = "no_accents")
    private String nao_acentos;

    @Column(name = "alternative_names")
    private String nome_alternativo;

    @Column(name = "microregion")
    private String microregiao;

    @Column(name = "mesoregion")
    private String mesoregiao;


	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getIdIbge() {
		return idIbge;
	}

	public void setIdIbge(String idIbge) {
		this.idIbge = idIbge;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getNao_acentos() {
		return nao_acentos;
	}

	public void setNao_acentos(String nao_acentos) {
		this.nao_acentos = nao_acentos;
	}

	public String getNome_alternativo() {
		return nome_alternativo;
	}

	public void setNome_alternativo(String nome_alternativo) {
		this.nome_alternativo = nome_alternativo;
	}

	public String getMicroregiao() {
		return microregiao;
	}

	public void setMicroregiao(String microregiao) {
		this.microregiao = microregiao;
	}

	public String getMesoregiao() {
		return mesoregiao;
	}

	public void setMesoregiao(String mesoregiao) {
		this.mesoregiao = mesoregiao;
	}

	
}
