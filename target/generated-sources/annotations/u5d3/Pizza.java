package u5d3;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Pizza implements MenuItem {
    private String name;
    private List<Topping> toppings;
    private boolean isLarge;
    private double basePrice;
    private String nutritionalInfo;

    public Pizza(String name, boolean isLarge, double basePrice, String nutritionalInfo) {
        this.name = name;
        this.toppings = new ArrayList<>();
        this.isLarge = isLarge;
        this.basePrice = basePrice;
        this.nutritionalInfo = nutritionalInfo;
        addBaseToppings();
    }

    private void addBaseToppings() {
    }

    @Override
    public double getPrice() {
        double totalPrice = basePrice;
        if (toppings != null) {
            for (Topping topping : toppings) {
                totalPrice += topping.getPrice();
            }
        }
        return totalPrice;
    }

    @Override
    public String getFormattedPrice() {
        return String.format("%.2f", getPrice());
    }

    public void addTopping(Topping topping) {
        if (toppings != null) {
            toppings.add(topping);
        }
    }
}
