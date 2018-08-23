package application;

import java.util.Arrays;
import java.util.Optional;

import javax.swing.text.html.Option;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExemploAlerta extends Application{

	private Button botao01 = new Button("Exemplo 01");
	private Button botao02 = new Button("Exemplo 02");
	private Button botao03 = new Button("Exemplo 03");
	private Button botao04 = new Button("Exemplo 04");
	private Button botao05 = new Button("Exemplo 05");
	private Button botao06 = new Button("Exemplo 06");
	private Button botao07 = new Button("Exemplo 07");
	
	@Override
	public void init() throws Exception {
		super.init();
		
		//Botão para mostrar Informação
		botao01.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Informação");
				alert.setHeaderText(null);
				alert.setContentText("Você clicou no Exemplo 01");
				alert.show();
			}
		});		
		
		//Botão para mostrar mensagem de Aviso
		botao02.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("Perigo");
				alert.setHeaderText("Cuidado!");
				alert.setContentText("Você clicou no Exemplo 02");
				alert.show();
			}
		});	
		
		//Botão para mostrar mensagem para Confirmação
		botao03.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Confirmação");
				alert.setHeaderText("Esta operação é um pouco crítica");
				alert.setContentText("Deseja realmente excluir?");
				Optional <ButtonType> resposta = alert.showAndWait();
				if(resposta.get().equals(ButtonType.OK))
					System.out.println("Botão Ok selecionado!");
				else if(resposta.get().equals(ButtonType.CANCEL))
					System.out.println("Botão cancelar selecionado!");
			}
		});	
		
		//Botão para mostrar mensagem de Informação com opção de Mais Detalhes
		botao04.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Informação");
				alert.setHeaderText("Detalhes");
				alert.setContentText("Você clicou no Exemplo 04 ... Veja mais Detalhes");
				Label label = new Label("Outros Detalhes");
				alert.getDialogPane().setExpandableContent(label);
				alert.show();
			}
		});	
		
		//Botão para mostrar mensagem vazia (Botões foram adicionados para aparecerem nela)
		botao05.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert = new Alert(Alert.AlertType.NONE);
				alert.setTitle("Informação");
				alert.setHeaderText("Outros Botões");
				alert.setContentText("Selecione uma das opções:");
				
				ButtonType buttonSim = new ButtonType("Sim", ButtonData.OK_DONE);
				ButtonType buttonNao = new ButtonType("Não");
				ButtonType buttonTalvez = new ButtonType("Talvez");
				ButtonType buttonCerteza = new ButtonType("Certeza", ButtonData.CANCEL_CLOSE);
				
				alert.getButtonTypes().addAll(buttonSim, buttonNao, buttonTalvez, buttonCerteza);
				
				Optional <ButtonType> resposta = alert.showAndWait();
				System.out.println("Resposta: " + resposta.get().getText());
			}
		});	
		
		//Botão para mostrar um TextField com uma mensagem escrita previamente
		botao06.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				TextInputDialog dialog = new TextInputDialog("Palmas");
				dialog.setTitle("Município");
				dialog.setHeaderText("Cabeçalho Qualquer");
				dialog.setContentText("Informe o nome da sua cidade");
				
				Optional <String> resultado = dialog.showAndWait();
				if(resultado.isPresent())
					System.out.println("A cidade digitada foi: " + resultado.get());
			}
		});	
		
		botao07.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ChoiceDialog<String> dialog = new ChoiceDialog<String>("Palmas", Arrays.asList("Araguaína", "Paraíso", "Palmas"));
				
				Optional<String> resultado = dialog.showAndWait();
				
				System.out.println("Cidade Escolhida: " + resultado.get());
				
			}
		});	
	}
	
	@Override
	public void start(Stage arg) throws Exception {
		// TODO Auto-generated method stub
		VBox vbox = new VBox();
		vbox.getChildren().addAll(botao01, botao02, botao03, botao04, botao05, botao06, botao07);
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(10);
		
		Scene scene = new Scene(vbox, 300, 300);
		
		arg.setTitle("Exemplo Alerta");
		arg.setScene(scene);
		arg.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
