package org.example.homework29;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoffeeOrderBoard {

    public static final Logger logger = LoggerFactory.getLogger(Main.class);

    public ArrayList<Order> ordersList;

    public CoffeeOrderBoard() {
        this.ordersList = new ArrayList<>();
    }

    public List<Integer> ordersNumbersList() {
        List<Integer> existOrders = new ArrayList<>();
        for (Order o : this.ordersList) {
            existOrders.add(o.orderNumber);
        }
        return existOrders;
    }

    public void add(int numberOrder, String clientName) {
        int size = this.ordersList.size();
        if (size != 0) {
            List<Integer> existOrders = ordersNumbersList();
            if (existOrders.contains(numberOrder)) {
                System.err.println("This element already exist in order list");
            } else {
                this.ordersList.add(new Order(numberOrder, clientName));
                logger.info("Order added: {}", new Order(numberOrder, clientName));
                List<Integer> updatedOrders = ordersNumbersList();
                List<Integer> copyExistOrders = new ArrayList<>(updatedOrders);
                Collections.sort(copyExistOrders);
                ArrayList<Order> sortedOrdersList = new ArrayList<>();
                System.out.println(existOrders);
                System.out.println(copyExistOrders);

                for (int i = 0; i < copyExistOrders.size(); i++) {
                    int sortedItem = copyExistOrders.get(i);
                    int indexOfItemNotSortedList = updatedOrders.indexOf(sortedItem);
                    sortedOrdersList.add(this.ordersList.get(indexOfItemNotSortedList));
                }
                this.ordersList = sortedOrdersList;
                System.out.println("Add to list new order number: " + numberOrder + ", List size orders: " + this.ordersList.size());

            }

        } else {
            this.ordersList.add(new Order(numberOrder, clientName));
            System.out.println("Add to list new order number: " + numberOrder + ", List size orders: " + this.ordersList.size());
        }
    }

    public void deliver(int orderNumber) {
        try {
            for (Order o : this.ordersList) {
                if (o.orderNumber == orderNumber) {
                    Order deliveredOrder = this.ordersList.remove(this.ordersList.indexOf(o));
                    logger.info("The order has been deleted: {}", deliveredOrder);
                    System.out.println("Order for " + deliveredOrder.clientName + "delivered order number is " + deliveredOrder.orderNumber);
                    return;
                }
            }
            logger.warn("Order number {} not found", orderNumber);
            System.err.println("Such order " + orderNumber + " not exist");
        } catch (Exception e) {
            logger.error("Error deleting order with number {}", orderNumber, e);
        }
    }

    public void draw(){
        System.out.println("====================\n" + "Num | Name");
        for (Order o : this.ordersList) {
            System.out.println(o.orderNumber + " | " + o.clientName);
        }
    }
}
