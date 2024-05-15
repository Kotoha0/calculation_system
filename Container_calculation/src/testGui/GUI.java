//Kotoha Takezaki(23069639)
package testGui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import containers.BigContainer;
import containers.Container;
import containers.SmallContainer;
import items.Item;
import methods.Calculation;

public class GUI extends JFrame {
	
    private JTextField laptopField;
    private JTextField mouseField;
    private JTextField desktopField;
    private JTextField lcdField;
    private JTextArea textArea;


    public GUI() {
   
        setTitle("Shipping Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 350);
        setLocationRelativeTo(null);
            
        
        //Create main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
       
        // Create the items panel
        JPanel itemsPanel = new JPanel(new GridLayout(5, 2));
        itemsPanel.setBorder(BorderFactory.createTitledBorder("Items"));
        itemsPanel.setBackground(Color.LIGHT_GRAY);
        
        JLabel laptopLabel = new JLabel("Laptop:");
        laptopField = new JTextField();
        JLabel mouseLabel = new JLabel("Mouse:");
        mouseField = new JTextField();
        JLabel desktopLabel = new JLabel("Desktop:");
        desktopField = new JTextField();
        JLabel lcdLabel = new JLabel("LCD Screen:");
        lcdField = new JTextField();

        itemsPanel.add(laptopLabel);
        itemsPanel.add(laptopField);
        itemsPanel.add(mouseLabel);
        itemsPanel.add(mouseField);
        itemsPanel.add(desktopLabel);
        itemsPanel.add(desktopField);
        itemsPanel.add(lcdLabel);
        itemsPanel.add(lcdField);

        mainPanel.add(itemsPanel, BorderLayout.NORTH);

        // Create the order button
        JButton orderButton = new JButton();
        orderButton.setText("Calculate shipping");
        orderButton.setBounds(0,125,350,30);
        
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
                OrderPlaceButton();
            }catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid quantities.");
            	}
            }
            
        });
        
        itemsPanel.add(orderButton);
        add(orderButton,BorderLayout.CENTER);
        
        // Create the output panel
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputPanel.setBorder(BorderFactory.createTitledBorder("Best shipping"));

        textArea = new JTextArea();
        textArea.setEditable(false);
        outputPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(outputPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }
   
	
	private void OrderPlaceButton() {
        // Get quantities from text fields
        int laptopQuantity = Integer.parseInt(laptopField.getText());
        int mouseQuantity = Integer.parseInt(mouseField.getText());
        int desktopQuantity = Integer.parseInt(desktopField.getText());
        int lcdQuantity = Integer.parseInt(lcdField.getText());

        // Create items
        Item laptop = new Item("Laptop", 60, 50, 50, 6.5, laptopQuantity);
        Item mouse = new Item("Mouse", 30, 30, 20, 0.2, mouseQuantity);
        Item desktop = new Item("Desktop", 100, 150, 50, 20, desktopQuantity);
        Item lcdScreen = new Item("LCD Screen", 120, 140, 80, 2.6, lcdQuantity);

        // Create containers
        Container smallContainer = new SmallContainer();
        Container bigContainer = new BigContainer();

        List<Item> itemsList = new ArrayList<>();
        itemsList.add(laptop);
        itemsList.add(mouse);
        itemsList.add(desktop);
        itemsList.add(lcdScreen);

        // Create containers list
        List<Container> containersList = new ArrayList<>();
        containersList.add(smallContainer);
        containersList.add(bigContainer);

        // Create order items list
        List<Item> orderItems = new ArrayList<>();
        orderItems.add(laptop);
        orderItems.add(mouse);
        orderItems.add(desktop);
        orderItems.add(lcdScreen);

        // Perform calculations
        Calculation calculation = new Calculation(orderItems, bigContainer, smallContainer);
        double totalVolume = calculation.totalVolume();
        double totalWeight = calculation.totalWeight();
        int containerCount = calculation.bestShipping();

        // Determine the best shipping container
         double shippingPrice = calculation.shippingPrice();

        // Display results
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Total Volume: ").append(totalVolume).append(" cm^3 \n");
        stringBuilder.append("Total Weight: ").append(totalWeight).append(" kg \n\n");
        stringBuilder.append("Shipment:\n");
        stringBuilder.append("Big Containers: ").append(containerCount).append("\n");
        
        if (calculation.isSmallCount() == true) {
        	stringBuilder.append("Small Containers: ").append("1").append("\n");
        }
        
        stringBuilder.append("Shipping Price: ").append(shippingPrice).append(" Euro");
        
        textArea.setText(stringBuilder.toString());
	}
	
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
}  