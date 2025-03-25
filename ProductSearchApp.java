import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductSearchApp {
    public static void main(String[] args) {
        BinarySearchTree<Product> bst = new BinarySearchTree<>();
        String csvFile = "home_appliance_skus_lowes.csv";  // Asegúrate de que el archivo CSV está en la misma carpeta
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // Saltar encabezado
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 5) {
                    String SKU = values[0];
                    double priceRetail = Double.parseDouble(values[1]);
                    double priceCurrent = Double.parseDouble(values[2]);
                    String productName = values[3];
                    String category = values[4];

                    Product product = new Product(SKU, priceRetail, priceCurrent, productName, category);
                    bst.insert(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Buscar un producto por SKU
        String skuToSearch = "123456";  // Reemplazar con un SKU válido
        Product foundProduct = bst.search(new Product(skuToSearch, 0, 0, "", ""));
        if (foundProduct != null) {
            System.out.println("Producto encontrado: " + foundProduct);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
}