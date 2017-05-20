package sample.object;

/**
 * Created by karpik on 17.05.2017.
 */
public class Smeta {

    private int id;
    private String name;
    private double price;
    private String time;



    public Smeta(int id, String name, double price, String time) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
