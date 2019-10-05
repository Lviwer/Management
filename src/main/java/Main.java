
import api.ProductService;
import api.UserRegisterLoginFacade;
import entity.Boots;
import entity.Cloth;
import entity.Product;
import entity.enums.Color;
import entity.enums.Material;
import entity.enums.SkinType;
import entity.parser.ColorParser;
import entity.parser.MaterialParser;
import entity.parser.SkinParser;
import facade.UserRegisterLoginFacadeImpl;
import service.ProductServiceImpl;


import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void startMenu() {
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Zaloguj się");
        System.out.println("2 - Zarejestruj się");
        System.out.println("3 - Wyjdź");
    }

    public static void loggedMenu() {
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Dodaj nowy produkt");
        System.out.println("0 - Wyloguj się");
    }

    public static void productTypeMenu() {
        System.out.println("1 - Dodaj buty");
        System.out.println("2 - Dodaj ubrania");
    }

    public static Product createOtherProduct() {
        String productName, color;
        Float price, weight;
        Integer count;
        Color colorPars;
        System.out.println("ProductName: ");
        productName = scanner.next();
        System.out.println("Price: ");
        price = scanner.nextFloat();
        System.out.println("Weight: ");
        weight = scanner.nextFloat();
        System.out.println("Choose one of colors: RED, BLUE, GREEN, WHITE, BLACK, YELLOW");
        color = scanner.next();
        colorPars = ColorParser.parseStrToColor(color);
        System.out.println("Count: ");
        count = scanner.nextInt();
        return new Product(1L, productName, price, weight, colorPars, count);
    }

    public static Product createBootsProduct() {
        String productName, color;
        Float price, weight;
        Integer count, size;
        String isNaturalSkin;
        Color colorPars;
        SkinType skinType;
        System.out.println("ProductName: ");
        productName = scanner.next();
        System.out.println("Price: ");
        price = scanner.nextFloat();
        System.out.println("Weight: ");
        weight = scanner.nextFloat();
        System.out.println("Choose one of colors: RED, BLUE, GREEN, WHITE, BLACK, YELLOW");
        color = scanner.next();
        colorPars = ColorParser.parseStrToColor(color);
        System.out.println("Count: ");
        count = scanner.nextInt();
        System.out.println("Size: ");
        size = scanner.nextInt();
        System.out.println("Choose one of skin type: NATURAL, ARTIFICAL");
        isNaturalSkin = scanner.next();
        skinType = SkinParser.parsStrToSkinType(isNaturalSkin);

        return new Boots(1L, productName, price, weight, colorPars, count, size, skinType);
    }

    public static Product createClothProduct() {
        String productName, color, size, material;
        Float price, weight;
        Integer count;
        Color colorPars;
        Material materialPars;
        System.out.println("ProductName: ");
        productName = scanner.next();
        System.out.println("Price: ");
        price = scanner.nextFloat();
        System.out.println("Weight: ");
        weight = scanner.nextFloat();
        System.out.println("Choose one of colors: RED, BLUE, GREEN, WHITE, BLACK, YELLOW");
        color = scanner.next();
        colorPars = ColorParser.parseStrToColor(color);
        System.out.println("Count: ");
        count = scanner.nextInt();
        System.out.println("Size: ");
        size = scanner.next();
        System.out.println("Choose one of material:  LEATHER, FUR, COTTON, WOOL, POLYESTERS");
        material = scanner.next();
        materialPars = MaterialParser.parseStrToColor(material);

        return new Cloth(1L, productName, price, weight, colorPars, count, size, materialPars);
    }


    public static void main(String[] args) {
        UserRegisterLoginFacade userFacade = UserRegisterLoginFacadeImpl.getInstance();
        ProductService productService = ProductServiceImpl.getInstance();

        boolean appOn = true;
        boolean loggedOn = false;
        int read;

        while (appOn) {
            startMenu();
            read = scanner.nextInt();

            switch (read) {
                case 1:
                    System.out.println("Podaj login: ");
                    String loginLog = scanner.next();
                    System.out.println("Podaj hasło: ");
                    String passwordLog = scanner.next();

                    if (userFacade.loginUser(loginLog, passwordLog)) {
                        loggedOn = true;
                        System.out.println("Zalogowałeś się !");
                    } else {
                        System.out.println("Niepoprawne dane !");
                    }
                    break;
                case 0:
                    appOn = false;
                    break;
            }

            while (loggedOn) {
                loggedMenu();
                read = scanner.nextInt();

                switch (read) {

                    case 1:

                        productTypeMenu();
                        read = scanner.nextInt();
                        Product product = null;
                        switch (read) {
                            case 1:
                                product = createBootsProduct();
                                break;
                            case 2:
                                product = createClothProduct();
                                break;

                            case 3:
                                product = createOtherProduct();
                                break;
                        }
                        if (productService.saveProduct(product)) {
                            System.out.println("Product został utworzony");
                        } else {
                            System.out.println("Product nie został utworzony");
                        }
                        break;

                    case 0:
                        loggedOn = false;
                        break;
                }

            }


        }


    }


}
