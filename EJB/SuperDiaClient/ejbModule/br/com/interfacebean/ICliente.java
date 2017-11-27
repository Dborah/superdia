package br.com.interfacebean;

import br.com.modelo.Usuario;

public interface ICliente {
	/**
	 * cliente se auto adiciona no sistema, o papel � definido como cliente antes de ir para o banco, n�o necess�rio cadastrar.
	 * 
	 * @param usuario - Objeto usuario com usuario e senha que ser� cadastrado.
	 * 
	 * @return <b>True</b> se foi cadastrado com sucesso ou <b>False</b> caso contr�rio.
	*/
	boolean autoAdiciona(Usuario usuario);
	
	/**
	 * cliente se auto altera no sistema, o papel � definido como cliente antes de ir para o banco, n�o necess�rio alterar.
	 * 
	 * @param usuario - Objeto usuario com usuario e senha que ser� alterado.
	 * 
	 * @return <b>True</b> se foi alterado com sucesso ou <b>False</b> caso contr�rio.
	*/
	boolean autoAltera(Usuario usuario);
	
	/**
	 * cliente se auto remove no sistema.
	 * 
	 * @param usuario - Objeto usuario com usuario e senha que ser� removido.
	 * 
	 * @return <b>True</b> se foi removido com sucesso ou <b>False</b> caso contr�rio.
	*/
	boolean autoRemove(Usuario usuario);
}
