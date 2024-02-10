import java.util.*;

abstract class Product {
    // public Map<Integer, Product> m;
    int ProductID;
    String name;
    int price;

    public Product(int id, String name, int price) {
        this.ProductID = id;
        this.name = name;
        this.price = price;

    }

    int getProductId() {
        return ProductID;
    }

    String getProductName() {
        return name;
    }

    int getPrice() {
        return price;
    }

}

class Electronics extends Product {
    int warranty;
    public List<Product> cart;

    public Electronics(int id, String name, int price, int warranty) {
        super(id, name, price);
        this.warranty = warranty;
    }

    public void display() {
        System.out.println("Product ID: " + getProductId());
        System.out.println("Product Name: " + getProductName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Warranty Period: " + this.warranty + " months");
    }
}

class Clothing extends Product {
    String colour;
    int size;

    public Clothing(int id, String name, int price, String colour, int size) {
        super(id, name, price);
        this.colour = colour;
        this.size = size;
    }

    public void display() {
        System.out.println("Product ID: " + getProductId());
        System.out.println("Product Name: " + getProductName());
        System.out.println("Price: " + getPrice());
        System.out.println("Colour is  " + this.colour);
        System.out.println("Size is  " + this.size);
    }
}

interface user1 {

    void browseProducts(int id);

    void addProduct11(int id);

    void placeOrder();

}

class User {
    String name = "";
    String email = "";
    String phone = "";

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;

    }

    String getn() {
        return name;
    }

}

class Shopping {
    public static Map<Integer, Electronics> m1 = new HashMap<>();
    public static Map<Integer, Clothing> c1 = new HashMap<>();
    public Map<String, User> u = new HashMap<>();
    public static boolean f = false;

    public void addProduct(Electronics e) {
        m1.put(e.getProductId(), e);
        System.out.println("Product Added successfully");
    }

    public void addc(Clothing c) {
        c1.put(c.getProductId(), c);
        System.out.println("Product Added successfully");
    }

    public void addUser(User user) {
        u.put(user.getn(), user);
        f = true;
    }

    public void display() {
        if (m1.isEmpty() && c1.isEmpty()) {
            System.out.println("Nothing to be displayed! Please first add products");
        } else {
            if (!m1.isEmpty()) {
                System.out.println("Electronics Item are ");
                for (Map.Entry<Integer, Electronics> entry : m1.entrySet()) {
                    System.out.println("Id = " + entry.getKey() + ",  Name =  "
                            + entry.getValue().getProductName() + ", Price = " + entry.getValue().getPrice());
                }
            }
            if (!c1.isEmpty()) {
                System.out.println("Clothing Item are ");
                for (Map.Entry<Integer, Clothing> entry : c1.entrySet()) {
                    System.out.println("Id = " + entry.getKey() + ",  Name =  "
                            + entry.getValue().getProductName() + ", Price = " + entry.getValue().getPrice()
                            + ", Color = "
                            + entry.getValue().colour + ", Size = " +
                            entry.getValue().size);

                }
            }
        }
    }
}

class Guests extends Shopping implements user1 {
    public static ArrayList<Product> cart = new ArrayList<>();
    public static ArrayList<Product> order = new ArrayList<>();
    public static ArrayList<Product> temp;

    public void browseProducts(int id) {
        boolean f = false;
        for (Map.Entry<Integer, Electronics> entry : m1.entrySet()) {

            if (entry.getKey() == id) {
                System.out.println("Product Available");
                System.out.println("Product is =>" + "Id = " + entry.getKey() + ",  Name =  "
                        + entry.getValue().getProductName() + ", Price = " + entry.getValue().getPrice());
                f = true;
                break;
            }
        }
        for (Map.Entry<Integer, Clothing> entry : c1.entrySet()) {

            if (entry.getKey() == id) {
                System.out.println("Product Available");
                System.out.println("Product is =>" + "Id = " + entry.getKey() + ",  Name =  "
                        + entry.getValue().getProductName() + ", Price = " + entry.getValue().getPrice());
                f = true;
                break;
            }
        }
        if (!f) {
            System.out.println("Product not found");
        }
    }

    public void addProduct11(int id) {
        if (m1.containsKey(id)) {
            cart.add(m1.get(id));
        } else if (c1.containsKey(id)) {
            cart.add(c1.get(id));
        } else {
            System.out.println("Invalid id");
        }
    }

    public void showCart() {

        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i).getProductName());
        }
    }

    public void placeOrder() {
        order.addAll(cart);
        cart.clear();
        System.out.println("Order Placed Successfully......");
    }
}

class Registered extends Shopping implements user1 {
    public ArrayList<Product> cart = new ArrayList<>();
    public static ArrayList<Product> order = new ArrayList<>();
    private HashMap<String, Integer> accounts = new HashMap<>();

    public void createaccount(String name, int id) {
        accounts.put(name, id);
    }

    public void browseProducts(int id) {
        boolean f = false;
        for (Map.Entry<Integer, Electronics> entry : m1.entrySet()) {

            if (entry.getKey() == id) {
                System.out.println("Product Available");
                System.out.println("Product is =>" + "Id = " + entry.getKey() + ",  Name =  "
                        + entry.getValue().getProductName() + ", Price = " + entry.getValue().getPrice());
                f = true;
                break;
            }
        }
        for (Map.Entry<Integer, Clothing> entry : c1.entrySet()) {

            if (entry.getKey() == id) {
                System.out.println("Product Available");
                System.out.println("Product is =>" + "Id = " + entry.getKey() + ",  Name =  "
                        + entry.getValue().getProductName() + ", Price = " + entry.getValue().getPrice());
                f = true;
                break;
            }
        }
        if (!f) {
            System.out.println("Product not found");
        }
    }

    public void addProduct11(int id) {
        if (m1.containsKey(id)) {
            cart.add(m1.get(id));
            System.out.println("Product Added Sucessfully....");
        } else if (c1.containsKey(id)) {
            cart.add(c1.get(id));
            System.out.println("Product Added Sucessfully....");
        } else {
            System.out.println("Invalid id");
        }

    }

    public void placeOrder() {
        System.out.println(cart.size());
        order.addAll(cart);
        cart.clear();
        System.out.println("Order Placed Successfully......");

    }

}

class Order {
    public ArrayList<Product> orders;
    Guests g = new Guests();

    public Order() {
        // System.out.println(orders.size());
        this.orders = Guests.order;
    }

    // total amount
    public int calculateTotalAmount() {
        int totalAmount = 0;
        if (orders.isEmpty()) {
            System.out.println("Price of your order is ");
            for (Product p : orders) {
                totalAmount += p.getPrice();
            }
        } else {
            System.out.println("Total amount of products in your cart are ");
            for (Product p : Guests.cart) {
                totalAmount += p.getPrice();
            }
        }

        return totalAmount;
    }

    // order history
    public void orderHistory() {
        if (Shopping.f == true) {
            System.out.println(orders.size());
            if (orders.size() == 0) {
                System.out.println("No order yet");
            }
            for (int i = 0; i < orders.size(); i++) {
                System.out.println(orders.get(i).getProductName());
            }
        }

        else {
            System.out.println("You are not applocable to see order history ");
        }

    }
}

public class OnlineShoppingSystem {
    public static void main(String args[]) {

        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Shopping s = new Shopping();

        boolean flag = true;

        Guests g = new Guests();

        Registered user = new Registered();
        Order o = new Order();

        do {
            System.out.println(
                    ".............................Welcome to the Online Shopping System..................................");
            System.out.println("1. Add Products in App\n" +
                    "2. Create Account\n" +
                    "3. Browse Product\n" +
                    "4. Add to Cart\n" +
                    "5. Total Amount\n" +
                    "6. Place order\n" +
                    "7. Order History\n" +
                    "8. Exit");

            System.out.print("Enter your choice ");
            int n = sc1.nextInt();

            switch (n) {
                case 1:
                    System.out.print("If you want to add Clothes enter 'c' if you wnat to add elctronics enter 'e': ");
                    char ch = sc1.next().charAt(0);
                    System.out.print("Eneter the Product ID: ");
                    int id = sc1.nextInt();
                    System.out.print("Enter the Product name:");
                    String name = sc2.next();
                    System.out.print("Enter the price: ");
                    int price = sc2.nextInt();
                    if (ch == 'c') {
                        System.out.print("Enter the size: ");
                        int size = sc1.nextInt();
                        System.out.print("Enter the color: ");
                        String colour = sc1.nextLine();
                        Clothing c1 = new Clothing(id, name, price, colour, size);
                        s.addc(c1);
                    } else if (ch == 'e') {
                        System.out.print("Warranty period in months: ");
                        int Warranty = sc1.nextInt();
                        Electronics e1 = new Electronics(id, name, price, Warranty);
                        s.addProduct(e1);
                    } else {
                        System.out.println("Invalid Input!");
                    }
                    break;
                case 2:
                    System.out.println("Enter the name of the user: ");
                    String cname = sc2.next();
                    System.out.println("Enter the mail id");
                    String mail = sc1.next();
                    System.out.println("Enter phone no . ");
                    String phn = sc1.next();
                    User u = new User(cname, mail, phn);
                    s.addUser(u);
                    System.out.println("Member Added Successfully!!");
                    break;

                case 3:
                    System.out.println("Enter id to search product");
                    int id1 = sc1.nextInt();
                    g.browseProducts(id1);
                    break;

                case 4:
                    System.out.println("Available products are");
                    s.display();
                    System.out.println("Enter id of product which u want to add to cart");
                    int i = sc1.nextInt();
                    if (Shopping.f == true)
                        user.addProduct11(i);
                    else
                        g.addProduct11(i);
                    break;
                case 5:
                    System.out.println(o.calculateTotalAmount());
                    break;
                case 6:
                    if (Shopping.f == true)
                        user.placeOrder();
                    else
                        g.placeOrder();
                    break;
                case 7:
                    o.orderHistory();
                    break;

                case 8:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        } while (flag);
        sc1.close();
        sc2.close();

    }
}