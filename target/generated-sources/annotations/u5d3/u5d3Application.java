package u5d3;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.stereotype.Component;

@ComponentScan("u5d3")
public class u5d3Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(u5d3Application.class, args);
        Menu menu = context.getBean(Menu.class);

        Pizza pizza1 = context.getBean(Pizza.class);
        Pizza pizza2 = context.getBean(Pizza.class);

        Topping topping1 = context.getBean(Topping.class);
        Topping topping2 = context.getBean(Topping.class);

        pizza1.addTopping(topping1);
        pizza2.addTopping(topping2);

        System.out.println("Pizza 1: " + pizza1.getName() + ", Prezzo: " + pizza1.getFormattedPrice());
        System.out.println("Topping: ");
        if (pizza1.getToppings() != null) {
            for (Topping topping : pizza1.getToppings()) {
                System.out.println("- " + topping.getName() + ", Prezzo: " + topping.getPrice());
            }
        }
        System.out.println();

        System.out.println("Pizza 2: " + pizza2.getName() + ", Prezzo: " + pizza2.getFormattedPrice());
        System.out.println("Topping: ");
        if (pizza2.getToppings() != null) {
            for (Topping topping : pizza2.getToppings()) {
                System.out.println("- " + topping.getName() + ", Prezzo: " + topping.getPrice());
            }
        }

        menu.printMenu();
        context.close();

        System.out.println("Ciao Mondo");
    }
}
