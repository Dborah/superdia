package br.com.interfacebean;

import java.util.List;

import br.com.modelo.Usuario;

public interface IUsuario {
	/**
	 * adiciona um usu�rio no sistema
	 * 
	 * @param usuario - Objeto usuario com usuario, senha e papel que ser� cadastrado.
	 * 
	 * @return <b>True</b> se foi cadastrado com sucesso ou <b>False</b> caso contr�rio.
	*/
	boolean adiciona(Usuario usuario);
	
	/**
	 * altera um usu�rio no sistema
	 * 
	 * @param usuario - Objeto usuario com usuario, senha e papel que ser� alterado.
	 * 
	 * @return <b>True</b> se foi alterado com sucesso ou <b>False</b> caso contr�rio.
	*/
	boolean altera(Usuario usuario);
	
	/**
	 * remove um usu�rio no sistema
	 * 
	 * @param usuario - Objeto usuario com usuario que ser� removido.
	 * 
	 * @return <b>True</b> se foi removido com sucesso ou <b>False</b> caso contr�rio.
	*/
	boolean remove(Usuario usuario);
	
	/**
	 * lista todos os usu�rio do sistema.
	 * 
	 * @return uma List com todos os usu�rio cadastrados no banco.
	*/
	List<Usuario> listaTodos();
}
