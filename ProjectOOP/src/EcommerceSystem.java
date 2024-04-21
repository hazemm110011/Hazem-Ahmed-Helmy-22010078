import java.util.Scanner;
// EcommerceSystem class
public class EcommerceSystem {
    public static void main(String[] args) {
        // Create electronic product
        ElectronicProduct electronicProduct = new ElectronicProduct(1, "smartphone", 599.9f, "Samsung", 1);
        // Create clothing product
        ClothingProduct clothingProduct = new ClothingProduct(2, "T-shirt", 19.99f, "Medium", "Cotton");
        // Create book product
        BookProduct bookProduct = new BookProduct(3, "OOP", 39.99f, "O’Reilly", "X Publications");
        // Create scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // Prompt user for customer details
        System.out.println("Welcome to the E-Commerce system !");
        System.out.println("Please Enter your ID:");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Please Enter your name:");
        String customerName = scanner.nextLine();
        System.out.println("Please enter your address:");
        String customerAddress = scanner.nextLine();
        // Create customer
        Customer customer = new Customer(customerId, customerName, customerAddress);
        // Prompt user for number of products
        System.out.println("How many products do you want to add to your cart?");
        int numProducts = scanner.nextInt();
        // Create cart for customer
        Cart cart = new Cart(customer.getCustomerId(), numProducts);
        // Prompt user for product details and add them to cart
        for (int i = 0; i < numProducts; i++) {
            System.out.println("Which product would you like to add? " + (i + 1) + ":");
            System.out.println("1- Smartphone\n2- T-shirt\n3- OOP");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    cart.addProduct(electronicProduct, i);
                    break;
                case 2:
                    cart.addProduct(clothingProduct, i);
                    break;
                case 3:
                    cart.addProduct(bookProduct, i);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }   
        }
        float totalPrice = cart.calculatePrice();
            System.out.println("Total price for your order: $" + totalPrice);
        // Ask user if they want to place an order
        System.out.println("Would you like to place the order? 1-yes  2-No");
        String placeOrderChoice = scanner.next();
        if (placeOrderChoice.equalsIgnoreCase("1")) {
            // Place order
            cart.placeOrder();
            Order order = new Order(customer.getCustomerId(), 1, cart.getProducts());
            // Print order information
            System.out.println("Here is your order's summary :");
            order.printOrderInfo();
        } else {
            System.out.println("Order not placed.");
        }
        // Close scanner
        scanner.close();
    }}
