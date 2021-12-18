class Product {
    String productName;
    String productID;
    String productType;
    int cost;
    public Product(String productName, String productID, String productType, int cost) {
        this.productName = productName;
        this.productID = productID;
        this.productType = productType;
        this.cost = cost;
    }
}

class ProductDetails {
    public Product getProductDetailProduct(String str) {
        String pName;
        String pId;
        String pType;
        int cost;


        String parts[] = str.split("\\.");      // "HP" "LaptopIDIE11IT012DTITCTC8L" 
        String parts2[] = parts[1].split("ID"); // "Laptop" "IE11IT012DTITCTC8L" 
        pName = parts[0] + " " + parts2[0];     // HP Laptop

        String[] ids = parts2[1].split("DT");   // "IE11IT012"    "ITCTC8L"
        pId = ids[0]; // IE11IT012

        String costs[] = ids[1].split("CTC");   // "IT"    "8L"
        pType = costs[0];

        cost = Integer.parseInt(costs[1].substring(0, 1));

        if (costs[1].charAt(1) == 'L') cost = cost * 100000;

        return new Product(pName, pId, pType, cost);
    }

    public String getTaxSlabOnProduct(Product p) {
        if (p.cost > 1000000) return "High";
        else if (p.cost >= 800000 && p.cost <= 1000000) return "Medium";
        else if (p.cost >= 500000 && p.cost <= 800000) return "Low";
        else return "None";
    }
}

public class ManipulatingStrings {
    public static void main(String[] args) throws Exception {
        String inputString = "HP.LaptopIDIE11IT012DTITCTC8L";
        
        ProductDetails productDetails = new ProductDetails();
        Product product = productDetails.getProductDetailProduct(inputString);

        String output = productDetails.getTaxSlabOnProduct(product);
        System.out.println(output);

        // String str = "aaaabbaaaaa";
        // String[] strs = {"aaaa", "abaa", "aabb", "bbbb"};
		// for (String string : strs) {
        //     System.out.println(str.contains(string) ? 1 : 0);
        // }
    }
}
