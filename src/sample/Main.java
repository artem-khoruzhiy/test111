package sample;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.interfaces.impls.CollectionDataBd;
import java.sql.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Сметный калькулятор");
        primaryStage.setMaximized(true);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
//        testData();
    }

    private void testData() {
        CollectionDataBd addressBook = new CollectionDataBd();
        addressBook.fillTestData();
        addressBook.print();
    }

    public static Connection connectionDb() {
        Connection dbConnection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/smeta", "root", "root");
        } catch (Exception e) {
            System.out.println("Ошибка подключения к базе данных.");;
        }
        return dbConnection;
    }

    private static void getDataTable() {
        Connection dbConnection;
        Statement statement;
        String selectTableSQL = "SELECT * from smeta";

        try {
            dbConnection = connectionDb();
            statement = dbConnection.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                System.out.println("userid : " + rs.getString("name"));
                System.out.println("username : " + rs.getString("cena"));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка выборки данных.");
        }
    }

    public static void main(String[] args)  {
//        getDataTable();
        CollectionDataBd collectionDataBd = new CollectionDataBd();
        collectionDataBd.getInfoFromBD();
        launch(args);
    }
}