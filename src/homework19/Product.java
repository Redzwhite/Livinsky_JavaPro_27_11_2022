package homework19;

import java.time.LocalDateTime;

public class Product {
    int indexNumber;
    String nameOfProduct;
    String type;
    double price;
    boolean discount;
    LocalDateTime addingDate;

    public Product(String name, String type, double price, boolean discount, LocalDateTime addingDate, int indexNumber) {
        this.nameOfProduct = name;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.addingDate = addingDate;
        this.indexNumber = indexNumber;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }
    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return discount;
    }

    public LocalDateTime getAddingDate() {
        return addingDate;
    }

    @Override
    public String toString() {
        return "{" +
                "indexNumber:" + indexNumber +
                ", nameOfProduct:'" + nameOfProduct + '\'' +
                ", type:'" + type + '\'' +
                ", price:" + price +
                ", discount:" + discount +
                ", addingDate:" + addingDate +
                '}';
    }
}
