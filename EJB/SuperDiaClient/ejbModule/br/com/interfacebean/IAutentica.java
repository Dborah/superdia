package br.com.interfacebean;

import br.com.modelo.Usuario;

public interface IAutentica {
	/**
	 * Autentica um usu�rio no sistema.
	 * 
	 * @param usuario - Objeto usuario com usuario e senha que ser� autenticado.
	 * 
	 * @return null se o usuario n�o existe ou n�o est� cadastrado ou um objeto do usu�rio somente com seu usuario e papel.
	*/
	Usuario autentica(Usuario usuario);
}
