import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class EcommerceSystemGUI extends JFrame {
    private JTextField customerIdField;
    private JTextField customerNameField;
    private JTextField customerAddressField;
    private JButton addOrderButton;
    private JTextArea outputTextArea;
    private float totalOrdersPrice;
    
    public EcommerceSystemGUI() {
        setTitle("E-Commerce System");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(240, 240, 240)); // Set background color
        // Panel to hold input components
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Font inputFont = new Font("Arial", Font.PLAIN, 16);
        inputPanel.setFont(inputFont);
        inputPanel.setBackground(new Color(220, 220, 220)); // Set background color
        // Add customer ID field
        inputPanel.add(createLabel("Customer ID:"));
        customerIdField = createTextField();
        inputPanel.add(customerIdField);
        // Add customer name field
        inputPanel.add(createLabel("Customer Name:"));
        customerNameField = createTextField();
        inputPanel.add(customerNameField);
        // Add customer address field
        inputPanel.add(createLabel("Customer Address:"));
        customerAddressField = createTextField();
        inputPanel.add(customerAddressField);
        // Add input panel to frame
        add(inputPanel, BorderLayout.NORTH);
        // Add order button with icon
        addOrderButton = new JButton("Add Order");
        addOrderButton.setFont(inputFont);
        addOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numOrders = getNumberOfOrders();
                if (numOrders > 0) {
                    addOrders(numOrders);
                }}}); 
        add(addOrderButton, BorderLayout.CENTER);
        // Add output text area
        outputTextArea = new JTextArea();
        outputTextArea.setFont(inputFont);
        outputTextArea.setBackground(new Color(255, 255, 255)); // Set background color
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.SOUTH);
        setVisible(true);
    }
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        return label;
    }
    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setBackground(new Color(255, 255, 255)); // Set background color
        return textField;
    }
    private int getNumberOfOrders() {
        String numOrdersStr = JOptionPane.showInputDialog(this, "Enter the number of orders:", "Number of Orders", JOptionPane.QUESTION_MESSAGE);
        try {
            return Integer.parseInt(numOrdersStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;}}   
    private void addOrders(int numOrders) {
        String customerId = customerIdField.getText();
        String customerName = customerNameField.getText();
        String customerAddress = customerAddressField.getText();
        if (customerId.isEmpty() || customerName.isEmpty() || customerAddress.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter all customer details.", "Error", JOptionPane.ERROR_MESSAGE);
            return;}
        Customer customer = new Customer(Integer.parseInt(customerId), customerName, customerAddress);
        for (int i = 0; i < numOrders; i++) {
            String[] products = {"Smartphone", "T-shirt", "OOP Book"};
            String selectedProduct = (String) JOptionPane.showInputDialog(this, "Choose a product:", "Product Selection", JOptionPane.QUESTION_MESSAGE, null, products, products[0]);
            if (selectedProduct != null) {
                Product product;
                switch (selectedProduct) {
                    case "Smartphone":
                        product = new ElectronicProduct(1, "Smartphone", 599.9f, "Samsung", 1);
                        break;
                    case "T-shirt":
                        product = new ClothingProduct(2, "T-shirt", 19.99f, "Medium", "Cotton");
                        break;
                    case "OOP Book":
                        product = new BookProduct(3, "OOP", 39.99f, "O’Reilly", "X Publications");
                        break;
                    default:
                        product = null;}               
                if (product != null) {
                    float orderPrice = product.getPrice();
                    totalOrdersPrice += orderPrice;
                    outputTextArea.append("Order " + (i + 1) + " Summary:\n");
                    outputTextArea.append("Customer ID: " + customer.getCustomerId() + "\n");
                    outputTextArea.append("Customer Name: " + customer.getName() + "\n");
                    outputTextArea.append("Customer Address: " + customer.getAddress() + "\n");
                    outputTextArea.append("Product: " + selectedProduct + "\n");
                    outputTextArea.append("Total price: $" + orderPrice + "\n\n");
                }}}          
          outputTextArea.append("Total Price of All Orders: $" + totalOrdersPrice + "\n");}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EcommerceSystemGUI();
            } });
    }}
