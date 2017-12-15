package br.com.interfacebean;

public interface ICartao {
	/**
	 * Valida o n�mero do cart�o inserido.
	 * 
	 * @param cardNumber - N�mero do cart�o que ser� analisado
	 * 
	 * @return <b>True</b> se foi v�lido ou <b>False</b> caso contr�rio.
	*/
	boolean validaNumeroCartao(String cardNumber);
	
	/**
	 * Obt�m a bandeira do cart�o
	 * 
	 * @param cardNumber - N�mero do cart�o que ser� analisado
	 * 
	 * @return <b>String</b> com a bandeira do cart�o se for v�lido, caso contr�rio retorna uma <b>String 'NONE'</b>
	*/
	String getBandeira(String cardNumber);
}
