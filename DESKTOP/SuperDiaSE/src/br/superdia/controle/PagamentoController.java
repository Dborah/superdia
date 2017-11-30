package br.superdia.controle;

import br.superdia.app.App;
import br.superdia.enumeracoes.Tela;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class PagamentoController {
	 @FXML
	    private TextField valorCompraTextField;

	    @FXML
	    private TextField numeroCartaoTextField;

	    @FXML
	    private Button concluirButton;

	    @FXML
	    private Button cancelarButton;

	    @FXML
	    private TextField trocoTextField;

	    @FXML
	    private TextField valorRecebidoTextField;

	    private Stage primaryStage;
		private Alert alert;
	    
		
		
	    public PagamentoController() {
			primaryStage = App.getPrimaryStage();
	    	System.err.println("PagamentoController --> construtor default: " + App.usuarioLogado);
	    }

		@FXML
	    private void initialize() {

	    	System.err.println("PagamentoController --> initialize: " + App.usuarioLogado);
			alert = new Alert(null);
	    	App.addOnChangeScreenListener(new App.OnChangeScreen() {				
				@Override
				public void onScreenChanged(String newScreen, Object userData) {
					System.out.println("Pagamento Nova tela:" + newScreen + ", " + userData);
					
				}
			});
	    	
		}
	    
	    @FXML
	    void concluirButtonOnAction() {
	    	System.out.println("Clicou em concluir");
	    	
	    	Double valorRecebido;
	    	Integer numeroCartao;
	    	System.out.println(valorRecebidoTextField.getText());
	    	try {	    		
	    		valorRecebido = Double.parseDouble(valorRecebidoTextField.getText());
			} catch (Exception e) {
				e.getMessage();
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Erro");				
				alert.setContentText("O valor recebido informado N�O e um n�mero.");
				alert.show();
			}
	    	
	    	try {
		    	numeroCartao = Integer.parseInt(numeroCartaoTextField.getText());
		    } catch (Exception e) {
				e.getMessage();/*
				alert.setAlertType(AlertType.ERROR);
				alert.setTitle("Erro");				
				alert.setContentText("O dado referente ao n�mero do cart�o informado N�O e um n�mero.");
				alert.show();*/
			}
	    	
	    	/*
	    	alert.setAlertType(AlertType.INFORMATION);
			alert.setTitle("Sucesso");
			alert.setHeaderText("Finalizar Compra.");
			alert.setContentText("Compra finalizada com SUCESSO!");
			alert.show();*/
			
			/*limpar os campos da janela caixa
			
			
			App.changeScreen(Tela.CAIXA.getTela());
			primaryStage.setTitle("Caixa");
			primaryStage.centerOnScreen();*/
			
			numeroCartaoTextField.clear();
	    	valorRecebidoTextField.clear();
	    	valorCompraTextField.clear();
	    	trocoTextField.clear();	
	    }
	    
	    @FXML
	    void cancelarButtonOnAction() {
	    	System.out.println("Clicou em CANCELAR");
	    	App.changeScreen(Tela.CAIXA.getTela());
			primaryStage = App.getPrimaryStage();
			primaryStage.setTitle("Caixa");
			primaryStage.centerOnScreen();
	    }
	    	    
	    @FXML
	    void concluirOnKeyPressed(KeyEvent event) {
	    	
	    	System.out.println("Concluir --> keyEvent.getCode(): " + event.getCode());
	    }

	   	public TextField getValorCompraTextField() {
			return valorCompraTextField;
		}

		public void setValorCompraTextField(TextField valorCompraTextField) {
			this.valorCompraTextField = valorCompraTextField;
		}

		public TextField getNumeroCartaoTextField() {
			return numeroCartaoTextField;
		}

		public void setNumeroCartaoTextField(TextField numeroCartaoTextField) {
			this.numeroCartaoTextField = numeroCartaoTextField;
		}

		public Button getConcluirButton() {
			return concluirButton;
		}

		public void setConcluirButton(Button concluirButton) {
			this.concluirButton = concluirButton;
		}

		public Button getCancelarButton() {
			return cancelarButton;
		}

		public void setCancelarButton(Button cancelarButton) {
			this.cancelarButton = cancelarButton;
		}

		public TextField getTrocoTextField() {
			return trocoTextField;
		}

		public void setTrocoTextField(TextField trocoTextField) {
			this.trocoTextField = trocoTextField;
		}

		public TextField getValorRecebidoTextField() {
			return valorRecebidoTextField;
		}

		public void setValorRecebidoTextField(TextField valorRecebidoTextField) {
			this.valorRecebidoTextField = valorRecebidoTextField;
		}

		public Stage getPrimaryStage() {
			return primaryStage;
		}

		public void setPrimaryStage(Stage primaryStage) {
			this.primaryStage = primaryStage;
		}
	    
	    
}

