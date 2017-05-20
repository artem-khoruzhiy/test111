package sample.interfaces.impls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import sample.Main;
import sample.object.Smeta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CollectionDataBd implements TableData {

    private ObservableList<Smeta> personList = FXCollections.observableArrayList();

    @Override
    public void add(Smeta smeta) {
        personList.add(smeta);
    }

    @Override
    // для коллекции не используется, но пригодится для случая, когда данные хранятся в БД и пр.
    public void update(Smeta smeta) {
        // т.к. коллекция и является хранилищем - то ничего обновлять не нужно
        // если бы данные хранились в БД или файле - в этом методе нужно было бы обновить соотв. запись
    }

    @Override
    public void delete(Smeta smeta) {
        personList.remove(smeta);
    }

    public ObservableList<Smeta> getPersonList() {
        return personList;
    }

    public void print(){
        for(Smeta smeta : personList){
            System.out.println(smeta.getId() + ") Service name: " + smeta.getName() + "; price: " + smeta.getPrice()
                    + "; time: " + smeta.getTime());
        }
    }

    public void fillTestData(){
//        personList.add(new Smeta(1, "Заливка стяжки", 1000, 5, "8h"));
    }

    public ResultSet getInfoFromBD(){

        Connection connection = Main.connectionDb();
        ResultSet set = null;
        try {
            Statement statement = connection.createStatement();
            set = statement.executeQuery("SELECT * FROM smeta;");
            while (set.next()){
                int id = set.getInt(1);
                String name = set.getString(2);
                double price = set.getDouble(3);
                String time = set.getString(4);
                personList.add(new Smeta(id, name, price, time));
            }

        }catch (SQLException e){
            System.out.println("Ошибка подключеия (Метод getInfoFromDB).");
        }
        return set;
    }


}