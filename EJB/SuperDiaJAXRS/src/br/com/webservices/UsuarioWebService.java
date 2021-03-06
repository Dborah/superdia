package br.com.webservices;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.interfacebean.IAutentica;
import br.com.interfacebean.ICliente;
import br.com.modelo.Resposta;
import br.com.modelo.Usuario;
 
/**
 * @author Deborah
 *
 *	ATEN��O: Ao realizarem altera��es aqui, o servidor glassfish precisa ter seus projetos
 *	limpos (dar um clean em (Project>Clean...) e reiniciado pelo restart. Sen�o o WebService
 *	encontrar� somente nullpointer nas classes EJB. Talves exista um fix, mas quando n�o tiver vamos
 *	trabalhar desta forma.
 */

@Stateless
@LocalBean
@Path("/usuario")
public class UsuarioWebService {	
    @EJB
    private IAutentica iautentica;
    
    @EJB
    private ICliente icliente;
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/logar")
    public Response Logar(@FormParam("usuario") String user, @FormParam("senha") String pass) {
    	Usuario usuario = new Usuario(user, pass);
    	usuario = iautentica.autentica(usuario);
    	if(usuario != null)
    		return Resposta.status(200, usuario.toString());
    	else
    		return Resposta.status(200, MessagensJSON.ERRO_USUARIO_INVALIDO.getMensagem());
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/cadastrar")
    public Response Cadastrar(@FormParam("usuario") String user, @FormParam("senha") String pass) {
    	Usuario usuario = new Usuario(user, pass);
    	if(icliente.autoAdiciona(usuario))
    		return Resposta.status(200,MessagensJSON.USUARIO_CADASTRADO_SUCESSO.getMensagem());
    	else
    		return Resposta.status(200,MessagensJSON.USUARIO_CADASTRADO_FALHA.getMensagem());
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/alterar")
    public Response Alterar(@FormParam("usuarioAntigo") String oldUser, @FormParam("senhaAntiga") String oldPass,
    		@FormParam("novoUsuario") String newUser, @FormParam("novaSenha") String newPass) {
    	Usuario usuario = new Usuario(oldUser, oldPass);
    	usuario = iautentica.autentica(usuario);
    	if(usuario != null)
    		if(icliente.autoAltera(new Usuario(newUser, newPass)))
    			return Resposta.status(200,MessagensJSON.INFORMACAO_ALTERADA_SUCESSO.getMensagem());
    		else
    			return Resposta.status(200,MessagensJSON.USUARIO_INALTERADO.getMensagem());
    	else
    		return Resposta.status(200,MessagensJSON.ALTERAR_USUARIO_FALHA.getMensagem());
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/remover")
    public Response Remover(@FormParam("usuario")String user, @FormParam("senha")String senha){
    	Usuario usuario = new Usuario(user,senha);
    	usuario = iautentica.autentica(usuario);
    	if(usuario != null)
    		if(icliente.autoRemove(usuario))
    			return Resposta.status(200,MessagensJSON.USUARIO_REMOVIDO_SUCESSO.getMensagem());
    		else
    			return Resposta.status(200,MessagensJSON.USUARIO_NAO_EXISTE.getMensagem());
    	else
    		return Resposta.status(200,MessagensJSON.ALTERAR_USUARIO_FALHA.getMensagem());
    }
}