package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import sample.interfaces.impls.CollectionDataBd;
import sample.object.Smeta;


import javax.swing.*;
import java.io.File;

public class Controller {

    private CollectionDataBd addressBookImpl = new CollectionDataBd();

    @FXML
    private TableView tableSmeta;

    @FXML
    private TableColumn<Smeta, String> id;

    @FXML
    private TableColumn<Smeta, String> service;

    @FXML
    private TableColumn<Smeta, String> price;

    @FXML
    private TableColumn<Smeta, String> count;

    @FXML
    private TableColumn<Smeta, String> time;


    @FXML
    private void initialize() {
        id.setCellValueFactory(new PropertyValueFactory<Smeta, String>("id"));
        service.setCellValueFactory(new PropertyValueFactory<Smeta, String>("name"));
        time.setCellValueFactory(new PropertyValueFactory<Smeta, String>("time"));
        price.setCellValueFactory(new PropertyValueFactory<Smeta, String>("price"));

        addressBookImpl.getInfoFromBD();

        tableSmeta.setItems(addressBookImpl.getPersonList());
    }

    public void openFile() {
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
        }
    }
}