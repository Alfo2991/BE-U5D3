package u5d3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class Menu {
    private List<Pizza> pizzas;
    private List<Drink> drinks;
    private List<Merchandise> merchandiseItems;

    @Autowired
    public Menu(List<Pizza> pizzas, List<Drink> drinks, List<Merchandise> merchandiseItems) {
        this.pizzas = pizzas;
        this.drinks = drinks;
        this.merchandiseItems = merchandiseItems;
        initializeMenuItems();
    }

    private void initializeMenuItems() {
        pizzas = new ArrayList<>();
        drinks = new ArrayList<>();
        merchandiseItems = new ArrayList<>();

        Pizza pizza1 = new Pizza("Margherita", false, 8.99, "Sempli, sana e nutriente");
        pizza1.addTopping(new Topping("Mozzarella", 1.0));
        pizza1.addTopping(new Topping("Salsa pomodoro", 0.5));
        pizzas.add(pizza1);

        Pizza pizza2 = new Pizza("Salame", false, 10.99, "Piccantella e piena di carbo");
        pizza2.addTopping(new Topping("Salame", 1.5));
        pizza2.addTopping(new Topping("Mozzarella", 1.0));
        pizza2.addTopping(new Topping("Salsa pomodoro", 0.5));
        pizzas.add(pizza2);

        drinks.add(new Drink("Coke", 2.5, "bella sana"));
        drinks.add(new Drink("Sprite", 2.5, "senza zucchero ma con aspartame"));

        merchandiseItems.add(new Merchandise("Cappellino", 15.99));
        merchandiseItems.add(new Merchandise("Tazza", 7.99));
    }


    public void printMenu() {
        System.out.println("Pizze:");
        for (Pizza pizza : pizzas) {
            String pizzaLine = pizza.getName() + " - " + pizza.getPrice() + "€";
            System.out.println(pizzaLine);
            for (Topping topping : pizza.getToppings()) {
                String toppingLine = "+ " + topping.getName() + " - " + topping.getPrice() + "€";
                System.out.println(toppingLine);
            }
            System.out.println();
        }

        System.out.println("Bevande:");
        for (Drink drink : drinks) {
            String drinkLine = drink.getName() + " - " + drink.getPrice() + "€";
            System.out.println(drinkLine);
        }

        System.out.println("Articoli di oggettistica:");
        for (Merchandise item : merchandiseItems) {
            String itemLine = item.getName() + " - " + item.getPrice() + "€";
            System.out.println(itemLine);
        }
    }

    public Order createOrder(Table table, List<OrderItem> items) {
        Order order = new Order();
        order.setOrderNumber(generateOrderNumber());
        order.setStatus("In corso");
        order.setNumSeats(table.getMaxSeats());
        order.setOrderTime(LocalDateTime.now());
        order.setOrderItems(items);

        double totalAmount = 0;
        for (OrderItem item : items) {
            totalAmount += item.getMenuItem().getPrice();
        }
        totalAmount += calculateCoverCharge();
        order.setTotalAmount(totalAmount);

        return order;
    }

    private String generateOrderNumber() {
        return "ORD-12345";
    }

    private double calculateCoverCharge() {
        return 2.5;
    }
}
