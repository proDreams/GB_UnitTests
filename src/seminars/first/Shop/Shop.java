package seminars.first.Shop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shop {
    public static void main(String[] args) {
        List<Product> products = List.of(new Product[]{
                new Product("apple", 25),
                new Product("banana", 22),
                new Product("orange", 15),
                new Product("mellon", 35)
        });
        List<Product> sortedProducts = List.of(new Product[]{
                new Product("orange", 15),
                new Product("banana", 22),
                new Product("apple", 25),
                new Product("mellon", 35)
        });
        Shop shop = new Shop();
        shop.setProducts(products);
        List<Product> res = shop.sortProductsByPrice();

        for (Product product : res) {
            System.out.println(product.getTitle());
        }
    }

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        List<Product> sortedProducts = new ArrayList<>(products);
        Comparator<Product> priceComparator = Comparator.comparing(Product::getCost);
        sortedProducts.sort(priceComparator);
        return sortedProducts;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        Product mostExpensiveProduct = null;
        int maxPrice = Integer.MIN_VALUE;

        for (Product product : products) {
            int price = product.getCost();
            if (price > maxPrice) {
                maxPrice = price;
                mostExpensiveProduct = product;
            }
        }
        return mostExpensiveProduct;
    }
}