package u5d3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Merchandise implements MenuItem {
    private String name;
    private double price;

    public Merchandise(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getFormattedPrice() {
        return String.format("%.2f", price);
    }
}
