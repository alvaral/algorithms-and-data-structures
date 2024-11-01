package algorithms.object_oriented_programming;
/*
Design a class to calculate the price of a pizza. The price of a pizza depends on:

- Size: Small, Medium, or Large
- Crust Type: Thin, Thick, or Stuffed
- Toppings: Each topping adds an additional cost.

The class should:

- Allow the user to set the size, crust type, and toppings.
- Have a method to calculate and return the total price of the pizza:
    -> Small (8$), Medium(10$), Large (12$)
    -> Thin (2$), Thick (2$), Stuffed (3$)
    -> Each topping (1.5$)
- Use appropriate OOP concepts such as encapsulation.
 */
import java.util.ArrayList;
import java.util.List;

class Pizza {
    // Enum for Pizza Size and Crust Type
    public enum Size { SMALL, MEDIUM, LARGE }
    public enum CrustType { THIN, THICK, STUFFED }

    private Size size;
    private CrustType crustType;
    private List<String> toppings;

    // Constructor
    public Pizza(Size size, CrustType crustType) {
        this.size = size;
        this.crustType = crustType;
        this.toppings = new ArrayList<>();
    }

    // Method to add toppings
    public void addTopping(String topping) {
        toppings.add(topping);
    }

    // Method to calculate the price
    public double calculatePrice() {
        double price = 0.0;

        // Set base price according to the size
        switch (size) {
            case SMALL:
                price += 8.0;  // Small base price
                break;
            case MEDIUM:
                price += 10.0; // Medium base price
                break;
            case LARGE:
                price += 12.0; // Large base price
                break;
        }

        // Add extra cost for crust type
        switch (crustType) {
            case THIN:
                price += 2.0;  // Thin crust cost
                break;
            case THICK:
                price += 3.0;  // Thick crust cost
                break;
            case STUFFED:
                price += 4.0;  // Stuffed crust cost
                break;
        }

        // Add cost for each topping
        price += toppings.size() * 1.5;  // Each topping costs $1.50

        return price;
    }

    // Get a list of all selected toppings
    public List<String> getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        return "Pizza [Size=" + size + ", Crust Type=" + crustType + ", Toppings=" + toppings + "]";
    }
}

// Testing the Pizza class
public class PizzaOrder {
    public static void main(String[] args) {
        // Create a pizza with medium size and thick crust
        Pizza pizza = new Pizza(Pizza.Size.MEDIUM, Pizza.CrustType.THICK);
        
        // Add toppings
        pizza.addTopping("Pepperoni");
        pizza.addTopping("Mushrooms");
        pizza.addTopping("Onions");

        // Calculate and print the total price
        double price = pizza.calculatePrice();
        System.out.println("Total Price: $" + price);
        System.out.println(pizza);  // Print pizza details
    }
}

