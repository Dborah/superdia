package br.com.webservices;

/**
 * @author Deborah
 */
public enum MessagensJSON {
	//JSON Usu�rio
	ERRO_USUARIO_INVALIDO("{'cod' : 401, 'msg':'Usu�rio n�o tem permiss�o para realizar esta opera��o.'}"),
	USUARIO_CADASTRADO_SUCESSO("{'cod': 200, 'msg': 'Cadastro realizado com sucesso!'}"),
	USUARIO_CADASTRADO_FALHA("{'cod': 401, 'msg': 'N�o foi poss�vel cadastrar usu�rio.'}");
	
	
	private MessagensJSON(String mensagem) {
		this.mensagem = mensagem;
	}

	private String mensagem;

	public String getMensagem() {
		return mensagem;
}
	
	
}
