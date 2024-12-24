package br.com.luana.dao;

import br.com.luana.domain.Carro;


public interface ICarroDao {

	public Carro cadastrar(Carro carro);

	public Carro buscarPorCodigo(Object codigo);
}
