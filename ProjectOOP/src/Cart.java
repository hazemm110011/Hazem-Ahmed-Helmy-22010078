class Cart {
    private int customerId;
    private int nProducts;
    private Product[] products;

    public Cart(int customerId, int nProducts) {
        this.customerId = Math.abs(customerId);
        this.nProducts = Math.abs(nProducts);
        this.products = new Product[this.nProducts];
    }
    // Getters and setters
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public int getnProducts() {
        return nProducts;
    }
    public void setnProducts(int nProducts) {
        this.nProducts = nProducts;
    }
    public Product[] getProducts() {
        return products;
    }
    public void setProducts(Product[] products) {
        this.products = products;
    }
//Add products to cart
    public void addProduct(Product product, int index) {
        if (index >= 0 && index < nProducts) {
            products[index] = product;
        } else {
            System.out.println("Invalid index");
        }}
//Remove products from cart
    public void removeProduct(int index) {
        if (index >= 0 && index < nProducts) {
            products[index] = null;
        } else {
            System.out.println("Invalid index");
        }}
// Calculate total price of products
    public float calculatePrice() {
        float totalPrice = 0;
        for (Product product : products) {
            if (product != null) {
                totalPrice += product.getPrice();
            }}
        return totalPrice;
    }
// Place order
    public void placeOrder() {
         System.out.println("Order placed.");
    }}


