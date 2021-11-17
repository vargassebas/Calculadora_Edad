module com.act2.actividad2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.calculadora_edad to javafx.fxml;
    exports edu.calculadora_edad;
}