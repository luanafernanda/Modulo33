package br.com.luana.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "TB_CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
    @SequenceGenerator(name = "carro_seq", sequenceName = "sq_carro", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "PLACA", length = 10, nullable = false, unique = true)
    private String placa;

    @Column(name = "MODELO", length = 50, nullable = false)
    private String modelo;

    @OneToOne(mappedBy = "carro")
    private Marca marca;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
        name = "TB_CARRO_ACESSORIO", 
        joinColumns = {@JoinColumn(name = "id_carro_fk")}, 
        inverseJoinColumns = {@JoinColumn(name = "id_acessorio_fk")}
    )
    private List<Acessorio> acessorios;

    public Carro() {
        this.acessorios = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public void addAcessorio(Acessorio acessorio) {
        this.acessorios.add(acessorio);
    }

	public Object getCodigo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCodigo(String codigo) {
		// TODO Auto-generated method stub
		
	}

	public void setDescricao(String string) {
		// TODO Auto-generated method stub
		
	}
}
