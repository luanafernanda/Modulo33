package br.com.luana;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.luana.dao.ICarroDao;
import br.com.luana.dao.IAcessorioDao;
import br.com.luana.dao.IMarcaDao;
import br.com.luana.dao.MarcaDao;
import br.com.luana.dao.CarroDao;
import br.com.luana.dao.AcessorioDao;
import br.com.luana.domain.Carro;
import br.com.luana.domain.Acessorio;
import br.com.luana.domain.Marca;

public class CarroTest {
	
	private ICarroDao carroDao;
	private IMarcaDao marcaDao;
	private IAcessorioDao acessorioDao;
	
	public CarroTest() {
		carroDao = new CarroDao();
		marcaDao = new MarcaDao();
		acessorioDao = new AcessorioDao();
	}

	@Test
	public void cadastrar() {
		Marca marca = criarMarca("M1");
		Carro carro = criarCarro("C1", marca);
		Acessorio acessorio1 = criarAcessorio("A1");
		Acessorio acessorio2 = criarAcessorio("A2");

		carro.addAcessorio(acessorio1);
		carro.addAcessorio(acessorio2);
		
		carro = carroDao.cadastrar(carro);
		
		assertNotNull(carro);
		assertNotNull(carro.getId());
		
		Carro carroBD = carroDao.buscarPorCodigo(carro.getCodigo());
		assertNotNull(carroBD);
		assertEquals(carro.getId(), carroBD.getId());
	}
	
	private Acessorio criarAcessorio(String codigo) {
		Acessorio acessorio = new Acessorio();
		acessorio.setCodigo(codigo);
		acessorio.setDescricao("Acessório " + codigo);
		return acessorioDao.cadastrar(acessorio);
	}

	private Carro criarCarro(String codigo, Marca marca) {
		Carro carro = new Carro();
		carro.setCodigo(codigo);
		carro.setDescricao("Carro de Teste");
		carro.setMarca(marca);
		return carroDao.cadastrar(carro);
	}

	private Marca criarMarca(String codigo) {
		Marca marca = new Marca();
		marca.setCodigo(codigo);
		marca.setDescricao("Marca de Carros");
		marca.setNome("Marca Teste");
		return marcaDao.cadastrar(marca);
	}
}
