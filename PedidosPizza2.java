package AppPizza;

//--- VIDEO 268 ---

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import paqueteFX.VentanaEmergente;

public class PedidosPizza2 extends Application {
	
	// Creamos las variables
	
	Stage miStage;
	TextField cuadroNombre, cuadroTlf, cuadroDir;
	RadioButton radioPeq, radioMed, radioGran;
	RadioButton radioFina, radioNormal;
	CheckBox chkPepperoni, chkQueso, chkPimiento, chkAceitunas, chkChampi, chkTomate, chkAnchoas;

	// Creamos 2 variables nuevas para crear la listview
	
	ObservableList<String> ingredientes;
	ListView listaIngredientes;
	
	@Override
	public void start(Stage primaryStage) {
		
		// Creamos el pane (panel) superior, y situamos la cabecera
		
		miStage = primaryStage;
		Text txtCabecera = new Text("Pide tu pizza ahora");
		txtCabecera.setFont(new Font(20));
		HBox paneSuperior = new HBox(txtCabecera);
		paneSuperior.setPadding(new Insets(20,10,20,10));
		
		// Creamos el pane de los datos del cliente. Creamos el label, ancho del espacio del nombre (setPrefWidth),
		// ancho del cuadro donde escribimos el nombre(setPrefColumnCount), y por ultimo, texto informativo del cuadro.
		
		Label lblNombre = new Label("Nombre: ");
		lblNombre.setPrefWidth(100);
		cuadroNombre = new TextField();
		cuadroNombre.setPrefColumnCount(20);
		cuadroNombre.setPromptText("Introduce tu nombre aquí");
		
		HBox paneNombre = new HBox(lblNombre, cuadroNombre);
		
		// Label y TextField del tlf
		
		Label lblTelefono = new Label("Nº de teléfono: ");
		lblTelefono.setPrefWidth(100);
		cuadroTlf = new TextField();
		cuadroTlf.setPrefColumnCount(20);
		cuadroTlf.setPromptText("Introduce tu teléfono aquí");
		
		HBox paneTelefono = new HBox(lblTelefono, cuadroTlf);
		
		// Label y TextField de la dirección
		
		Label lblDireccion = new Label("Dirección: ");
		lblDireccion.setPrefWidth(100);
		cuadroDir = new TextField();
		cuadroDir.setPrefColumnCount(20);
		cuadroDir.setPromptText("Introduce tu teléfono aquí");
		
		HBox paneDireccion = new HBox(lblDireccion, cuadroDir);
		
		// Creamos el panel de datos
		
		VBox paneCliente = new VBox(10, paneNombre, paneTelefono, paneDireccion);
		
		// Creamos el pane de datos del tamaño de la pizza
		
		Label lblTamano = new Label("Tamaño");
		
		radioPeq = new RadioButton("Pequeña");
		radioMed = new RadioButton("Mediana");
		radioGran = new RadioButton("Grande");
		
		radioMed.setSelected(true);
		
		// Agrupamos los botones en un "grupo" y lo situamos
		
		ToggleGroup grupoTamano = new ToggleGroup();
		radioPeq.setToggleGroup(grupoTamano);
		radioMed.setToggleGroup(grupoTamano);
		radioGran.setToggleGroup(grupoTamano);
		
		VBox paneTamano = new VBox(lblTamano, radioPeq, radioMed, radioGran);
		paneTamano.setSpacing(10);
		
		// Creamos el pane del tipo de masa
		
		Label lblMasa = new Label("Masa");
		
		radioFina = new RadioButton("Fina");
		radioNormal = new RadioButton("Normal");
		
		radioFina.setSelected(true);
		
		// Agrupamos los botones en un "grupo" y lo situamos
		
		ToggleGroup grupoMasa = new ToggleGroup();
		radioFina.setToggleGroup(grupoMasa);
		radioNormal.setToggleGroup(grupoMasa);
		
		VBox paneMasa = new VBox(lblMasa, radioFina, radioNormal);
		
		paneMasa.setSpacing(10);
		
		// Creación del pane ingredientes
		
		Label lblIngredientes = new Label("Ingredientes");
		
		listaIngredientes = new ListView();
		
		ingredientes = FXCollections.observableArrayList("- Pepperoni", "- Queso", "- Pimiento", "- Aceitunas", "- Champiñón", "- Tomate", "- Anchoas");
		
		listaIngredientes.setPrefHeight(125);
		listaIngredientes.getItems().addAll(ingredientes);
		listaIngredientes.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		// Situamos los ingredientes, y los separamos unos de otros con un Insets.
		// Separamos por arriba 10 pixeles, por la derecha 0, por abajo 10, por la izquierda 0.
		// Situamos dentro del contenedor paneIngredientes, los ingredientes los separamos
		// con hgap y vgap.
		
		FlowPane paneIngredientes = new FlowPane(Orientation.VERTICAL, listaIngredientes);
		
		paneIngredientes.setPadding(new Insets(10,0,10,20));
		paneIngredientes.setHgap(20);
		paneIngredientes.setVgap(10);
		paneIngredientes.setPrefWrapLength(100);
		
		VBox paneIngredientesVertical = new VBox(lblIngredientes, paneIngredientes);
		
		// Crear el pane del tamaño, masa e ingredientes
		
		HBox paneOrden = new HBox (35, paneTamano, paneMasa, paneIngredientesVertical);
		
		// Crear el panel principal
		
		VBox paneCentral = new VBox(20, paneCliente, paneOrden);
		paneCentral.setPadding(new Insets(0, 10, 0, 10));
		
		// Creamos los botones, damos un tamaño y le asignamos una acción a través de
		// un método
		
		Button botonOk = new Button("Ok");
		botonOk.setPrefWidth(80);
		botonOk.setOnAction(e->botonOkClick());
		
		Button botonCancelar = new Button("Cancelar");
		botonCancelar.setPrefWidth(80);
		botonCancelar.setOnAction(e->botonCancelarClick());
		
		// Para construir una región donde colocar los botones anteriores
		
		Region espacio = new Region ();
		
		HBox paneInferior = new HBox(50, espacio, botonOk, botonCancelar);
		
		paneInferior.setHgrow(espacio, Priority.ALWAYS);
		paneInferior.setPadding(new Insets(20, 10, 20, 10));
		
		// Finalizamos con la escena
		
		BorderPane panePrincipal = new BorderPane();
		
		panePrincipal.setTop(paneSuperior);
		panePrincipal.setCenter(paneCentral);
		panePrincipal.setBottom(paneInferior);
		
		Scene miScene = new Scene(panePrincipal);
		
		primaryStage.setScene(miScene);
		primaryStage.setTitle("Pizzeria");
		primaryStage.show();
		
	}

	private void botonOkClick() {
		// TODO Auto-generated method stub
		
		// Creación del String con la información del cliente
		
		String mensaje = "Cliente :\n\n";
		mensaje += "\t"+ cuadroNombre.getText()+"\n";
		mensaje += "\t"+ cuadroTlf.getText()+"\n";
		mensaje += "\t"+ cuadroDir.getText()+"\n";
		mensaje += "\n -- Resumen pedido --";
		mensaje += "\nPizza";
		
		// Añadimos el tamaño a la ventana emergente
	
		if(radioPeq.isSelected()) mensaje += " pequeña";
		if(radioMed.isSelected()) mensaje += " mediana";
		if(radioGran.isSelected()) mensaje += " grande";
		
		// Añadimos la masa a la ventana emergente
		
		if(radioFina.isSelected()) mensaje += " y masa fina con";
		if(radioNormal.isSelected()) mensaje += " y masa normal con";
		
		// Añadimos los ingredientes
		
		String losIngredientes = "";
		
		ingredientes = listaIngredientes.getSelectionModel().getSelectedItems();
		
		for (String toppings:ingredientes) {
			
			losIngredientes += toppings +"\n";
			
		}
		
		if(losIngredientes.equals("")) mensaje += " sin ingredientes";
		else mensaje += " los siguientes ingredientes:\n"+losIngredientes;
		
		// Mostramos el mensaje emergente final
		VentanaEmergente.mostrar(mensaje, "Detalles del pedido", 500, 250);
		
	}

	private String construyeIngredientes(CheckBox chk, String msg) {
		// TODO Auto-generated method stub
		
		if (chk.isSelected()) {
			
			if (!msg .equals("")) msg+=", ";
			msg+=chk.getText();
			
		}
		return msg;
	}

	private void botonCancelarClick() {
		// TODO Auto-generated method stub
		miStage.close();
	}


	public static void main(String[] args) {
		launch(args);
	}
}
