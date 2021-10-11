package ProductManager;

import java.io.Serializable;

public class Product implements Serializable {
    private String code;
    private String name;
    private String source;
    private int price;
    private String description;

    public Product() {
    }

    public Product(String code, String name, String source, int price, String description) {
        this.code = code;
        this.name = name;
        this.source = source;
        this.price = price;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
