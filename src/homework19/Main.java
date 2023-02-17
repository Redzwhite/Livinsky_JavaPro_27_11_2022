package homework19;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) {

        Product product0 = new Product("Book1", "Book", 249, false, LocalDateTime.now(), 1);
        Product product1 = new Product("Book", "Book", 250, true, LocalDateTime.now(), 2);
        Product product2 = new Product("Book2", "Book", 251, false, LocalDateTime.now(), 3);
        Product product3 = new Product("Book3", "Book", 252, true, LocalDateTime.now(), 4);
        Product product4 = new Product("Book4", "Book", 253, false, LocalDateTime.now(), 5);
        Product product5 = new Product("Book5", "Book", 254, true, LocalDateTime.now(), 6);
        Product product6 = new Product("Cat1", "Cat", 150, true, LocalDateTime.now(), 7);

        List<Product> listOfProducts = new ArrayList<>();
        listOfProducts.add(product0);
        listOfProducts.add(product1);
        listOfProducts.add(product2);
        listOfProducts.add(product3);
        listOfProducts.add(product4);
        listOfProducts.add(product5);
        listOfProducts.add(product6);


        getAllProductsAsCriteriaBookTypeAndPrice(listOfProducts);
        getAllProductsAsCriteriaBookTypeAndPriceWithDiscount(listOfProducts, 50);
        findMinProductsPriceAsCriteriaBookType(listOfProducts, "Cat");
        findLastThreeProducts(listOfProducts);
        groupingObjectsByProductType(listOfProducts);
        totalVarthOfProducts(listOfProducts, "Cat");
        groupingObjectsByProductType(listOfProducts);
        findMinProductsPriceAsCriteriaBookType(listOfProducts, "acasca");


    }

    public static void getAllProductsAsCriteriaBookTypeAndPrice(List<Product> myList) {
        Stream<Product> sequentialStream = myList.stream();
        Stream<Product> comparableProduct = sequentialStream.filter(p -> p.type.equals("Book") && p.price >= 250);
        System.out.print("Products of the book type the price is more than 250: \n");
        System.out.println(comparableProduct.toList());
    }

    public static void getAllProductsAsCriteriaBookTypeAndPriceWithDiscount(List<Product> myList, double discount) {
        Stream<Product> sequentialStream = myList.stream();
        Stream<Product> comparableProduct = sequentialStream.filter(p -> p.type.equals(p.getType()) && p.price >= 250 && p.discount);
        comparableProduct.forEach(p -> System.out.print(p.getNameOfProduct() + " has price with discount "
                + discount + "%" + " : " + (p.price - ((discount * p.getPrice())) / 100) + "\n"));
    }

    public static void findMinProductsPriceAsCriteriaBookType(List<Product> list, String category) {
        Comparator<Product> comparePrice = Comparator.comparingDouble(Product::getPrice);
        List<Product> sortedProducts = list.stream().filter(product -> product.type.equals(category)).min(comparePrice).stream().toList();
        if (sortedProducts.size() == 0) {
            throw new RuntimeException("Продукт [категорія: " + category + " ] не знайдено");
        } else {
            System.out.println(sortedProducts.get(0));
        }
    }

    public static List<Product> findLastThreeProducts(List<Product> list) {
        List<Product> sortByDate = list.stream().sorted(Comparator.comparing(Product::getAddingDate).reversed()).limit(3).toList();
        System.out.println(sortByDate);
        return sortByDate;
    }

    public static void totalVarthOfProducts(List<Product> myList, String productType) {
        Stream<Product> sequentialStream = myList.stream();
        Double comparableProductSum = sequentialStream.filter(
                p -> p.type.equals(productType) &&
                        p.price >= 75 &&
                        p.getAddingDate().getYear() == LocalDateTime.now().getYear()
        ).mapToDouble(Product::getPrice).sum();
        System.out.println(comparableProductSum);
    }

    public static void groupingObjectsByProductType(List<Product> list) {
        final Map<String, List<String>> optionsByName = list.stream().collect(
                Collectors.groupingBy(Product::getType, Collectors.mapping(Product::toString, Collectors.toList())));
        System.out.println(optionsByName);
    }
}


