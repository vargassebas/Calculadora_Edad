package edu.calculadora_edad;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class Calculadora_EdadController implements Initializable {

    @FXML
    private ComboBox<Integer> dia, mes, ano;

    @FXML
    private Button calcular, nuevo, creador;

    @FXML
    private Label titulo, error, result;

    @FXML
    private ImageView imagen;

    @FXML
    void calcularEdad(ActionEvent event) {

        if (ano.getValue() == null || mes.getValue() == null || dia.getValue() == null) {
            error.setVisible(true);
            imagen.setVisible(false);
        } else {
            LocalDate actual = LocalDate.now();
            LocalDate edad = LocalDate.of(ano.getValue(), mes.getValue(), dia.getValue());
            int anos = Period.between(edad, actual).getYears(), meses = Period.between(edad, actual).getMonths(),
                    dias = Period.between(edad, actual).getDays();
            result.setText(anos + " años \n" + meses + " meses \n" + dias + " dias.");
            result.setVisible(true);
            error.setVisible(false);
            if (mes.getValue() <= LocalDate.now().getMonthValue()) {
                if (dia.getValue() <= LocalDate.now().getDayOfMonth()){
                    imagen.setVisible(true);
                };
            }
        }
    }

    @FXML
    void nuevoRegistro(ActionEvent event) {
        dia.setValue(null);
        mes.setValue(null);
        ano.setValue(null);
        result.setText("");
        result.setVisible(false);
        imagen.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //ciclos que llenan las listas despegables de los combo box
        ArrayList<Integer> dias = new ArrayList<>();
        for (int i = 1; i < 32; i++) {
            dias.add(i);
        }

        ArrayList<Integer> meses = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            meses.add(i);
        }

        ArrayList<Integer> anos = new ArrayList<>();
        int anoactual = Year.now().getValue();
        for (int i = anoactual; i >= 1930; i--) {
            anos.add(i);
        }

        //lista que se muestra en el combobox de los dias
        ObservableList<Integer> listadia = FXCollections.observableArrayList(dias);
        dia.setItems(listadia);

        //lista que se muestra en el combobox de los meses
        ObservableList<Integer> listames = FXCollections.observableArrayList(meses);
        mes.setItems(listames);

        //lista que se muestra en el combobox de los años
        ObservableList<Integer> listaano = FXCollections.observableArrayList(anos);
        ano.setItems(listaano);

    }
}