package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.*;
public class SearchInventoryMap {
    public static HashMap<String, Product> inventory = new HashMap<String, Product>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loadInventory();
            System.out.println("Welcome to the Store! Here is our inventory! ");
        for (Product p : inventory.values()) {
            System.out.printf("id: %d %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
            }

        while (true) {
            System.out.print("What item are you interested in? ");
        String productName = scanner.nextLine().trim().toLowerCase().replaceAll("[^a-zA-Z0-9]", "");


        Product matchedProduct = inventory.get(productName);
        if (matchedProduct == null) {
            System.out.print("We don't carry that product");
                break;
            }
            System.out.printf("We carry %s and the price is $%.2f", matchedProduct.getName(), matchedProduct.getPrice());
        //if user wants to find another item

            System.out.println("\nDo you want to find another item? Yes or No: ");
        String userSearch = scanner.nextLine().toLowerCase().trim();
            if (userSearch.equals("yes")) {}

            else {
                break;
            }
        }
            scanner.close();
            System.exit(0);
    }

    public static void loadInventory() {
        String input;
        try {
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            while ((input = bufReader.readLine()) != null) {
                String[] inventoryReader = input.split("\\|");
                int id = Integer.parseInt(inventoryReader[0]);
                String name = inventoryReader[1];
                double productPrice = Double.parseDouble(inventoryReader[2]);
                inventory.put(name.trim().toLowerCase().replaceAll("[^a-zA-Z0-9]", ""), new Product(id, name, productPrice));
            }
            fileReader.close();
            bufReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





