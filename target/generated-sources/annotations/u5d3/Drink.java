package u5d3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Drink implements MenuItem {
    private String name;
    private double price;
    private String description;

    public Drink(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public String getFormattedPrice() {
        return String.format("%.2f", price);
    }
}
