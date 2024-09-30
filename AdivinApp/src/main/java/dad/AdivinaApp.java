package dad;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import java.util.Random;


public class AdivinaApp extends Application {

    private TextField numeroTexto;
    private Button adivinarButton;
    private Label resultadoLabel;
    private int numeroAleatrio;
    private int contador;

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Adivina App");


        numeroTexto = new TextField();
        numeroTexto.setPromptText("Introduce un número");

        adivinarButton = new Button("Adivinar");
        adivinarButton.setDefaultButton(true);
        resultadoLabel = new Label();

        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        HBox numeroBox = new HBox(10, new Label("Introduce un número del 1 al 100"), numeroTexto);
        HBox adivinarBox = new HBox(10, adivinarButton);

        numeroBox.setAlignment(Pos.CENTER);
        adivinarBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(numeroBox, adivinarBox, resultadoLabel);
        vBox.setAlignment(Pos.CENTER);
        iniciar();
        adivinarButton.setOnAction(e -> adivinarNumero());

        stage.setScene(new Scene(vBox, 800, 650));
        stage.show();
    }


    private void iniciar(){
        numeroAleatrio = new Random().nextInt(100) + 1;
        contador=0;
        numeroTexto.clear();
    }
    private void adivinarNumero() {
        try {
            int numero2 = Integer.parseInt(numeroTexto.getText());
            contador++;
            if (numero2 != numeroAleatrio){
                if (numero2 < numeroAleatrio){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("AdivinApp");
                    alert.setHeaderText("Has fallado");
                    alert.setContentText("Has fallado a adivinar es mayor que " + numero2 + ". " +
                            "\nVuelve a intentarlo");
                    alert.showAndWait();
                }else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("AdivinApp");
                    alert.setHeaderText("Has fallado");
                    alert.setContentText("El número a adivinar es menor que " + numero2 + ". " +
                            "\nVuelve a intentarlo");
                    alert.showAndWait();
                }
            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("AdivinApp");
                alert.setHeaderText("Has ganado");
                alert.setContentText("Sólo has necesitado " + contador + " intentos."+
                        "\nVuelve a jugar y hazlo mejor");
                alert.showAndWait();
            }
        }catch (NumberFormatException ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("AdivinApp");
            alert.setHeaderText("Error");
            alert.setContentText("El número no es válido");
            alert.showAndWait();
        }
    }
}