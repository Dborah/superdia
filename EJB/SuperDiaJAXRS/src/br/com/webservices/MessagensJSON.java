package br.com.webservices;

public enum MessagensJSON {
	//JSON Usu�rio
	ERRO_USUARIO_INVALIDO("{'cod' : 401, 'msg':'Usu�rio n�o tem permiss�o para realizar esta opera��o.'}");
	
	private MessagensJSON(String mensagem) {
		this.mensagem = mensagem;
	}

	private String mensagem;

	public String getMensagem() {
		return mensagem;
}
	
	
}
