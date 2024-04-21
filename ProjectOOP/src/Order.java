class Order {
    private int customerId;
    private int orderId;
    private Product[] products;
    private float totalPrice;

    public Order(int customerId, int orderId, Product[] products) {
        this.customerId = Math.abs(customerId);
        this.orderId = Math.abs(orderId);
        this.products = products;
        this.totalPrice = calculateTotalPrice();
    }
// Calculate total price of products in order
    private float calculateTotalPrice() {
        float totalPrice = 0;
        for (Product product : products) {
            if (product != null) {
                totalPrice += product.getPrice();
            }}       
        return totalPrice;
    }
// Print order information
    public void printOrderInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Products:");
        for (Product product : products) {
            if (product != null) {
                System.out.println("- " + product.getName() + ": $" + product.getPrice());
            }}
        System.out.println("Total Price: $" + totalPrice);
    }}
