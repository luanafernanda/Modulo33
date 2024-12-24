package br.com.luana;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.luana.dao.IMarcaDao;
import br.com.luana.dao.MarcaDao;
import br.com.luana.domain.Marca;

/**
 * @author rodrigo.pires
 *
 */
public class MarcaTest {

	private IMarcaDao marcaDao;
	
	public MarcaTest() {
		marcaDao = new MarcaDao();
	}

	@Test
	public void cadastrar() {
		Marca marca = new Marca();
		marca.setCodigo("M1");
		marca.setDescricao("MARCA TESTE");
		marca.setNome("Marca de Carros X");
		marca = marcaDao.cadastrar(marca);
		
		assertNotNull(marca);
		assertNotNull(marca.getId());
	}
}
