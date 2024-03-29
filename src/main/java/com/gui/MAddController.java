package com.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.app.GsonManager;
import com.app.LeaderBoard;
import com.app.Medewerker;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MAddController extends AController implements Initializable{

    private List<Medewerker> users = new ArrayList<>();
    
    @FXML
    private TextField naam;

    @FXML
    private TextField werktijd;

    @FXML
    private Label MedewerkerNaam;

    @FXML
    private TableView<Medewerker> Aleaderboard;

    @FXML
    private final TableColumn<Object, Object> ArankColumn = new TableColumn<>();

    @FXML
    private final TableColumn<Object, Object> AnamesKolom = new TableColumn<>();

    @FXML
    private final TableColumn<Object, Object> AwerktijdColumn = new TableColumn<>();

    @FXML
    private void MedewerkerAdd() throws IOException {
        if (!naam.getText().isBlank() && !werktijd.getText().isBlank()){
            Double wt = (double) Integer.parseInt(werktijd.getText());
            Medewerker medewerker = new Medewerker(naam.getText(), wt);
            GsonManager.saveFile();
            Main.show("MAdd", medewerker);
        }
    }
        /**
     * Deze methode zorgt ervoor dat het invoerveld van de kilometers louter cijfers kan bevatten.
     */
    public void addNumberLimiter(){
        werktijd.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                werktijd.setText(newValue.replaceAll("\\D", ""));
            }
        });
    }

    /**
     * Deze methode zorgt voor een maximaal aantal tekens die het invoerveld van de kilometers kan bevatten.
     * @param maxLength aantal maximale tekens
     */
    public void addTextLimiter(int maxLength) {
        werktijd.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (werktijd.getText().length() > maxLength) {
                    String s = werktijd.getText().substring(0, maxLength);
                    werktijd.setText(s);
                }
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addNumberLimiter();
        addTextLimiter(3);
        users = LeaderBoard.getUsers();
        ArankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));
        AnamesKolom.setCellValueFactory(new PropertyValueFactory<>("naam"));
        AwerktijdColumn.setCellValueFactory(new PropertyValueFactory<>("werktijd"));
        ObservableList<Medewerker> data = FXCollections.observableArrayList(users);
        Aleaderboard.setItems(data);
    }

    //Override just here because implementations
    @Override
    void setUser(Medewerker medewerker) {}   
}
