package facade;

import api.ProductFacade;
import api.ProductService;
import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;
import service.ProductServiceImpl;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ProductFacadeImpl implements ProductFacade {

    private final static ProductFacade instance = new ProductFacadeImpl();
    private final ProductService productService = ProductServiceImpl.getInstance();

    private ProductFacadeImpl() {

    }

    public static ProductFacade getInstance() {
        return ProductFacadeImpl.instance;
    }


    public String createProduct(Product product) {

        try {
            productService.saveProduct(product);
            return "Create product " + product;
        } catch (IOException e) {
            e.printStackTrace();
            return "[IOException] Error while add product to database";
        } catch (ProductWeightNoPositiveException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (ProductNameEmptyException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (ProductCountNegativeException e) {
            e.printStackTrace();
            return e.getMessage();
        } catch (ProductPriceNoPositiveException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String removeProduct(String productName) {

        try {
            productService.removeProduct(productName);
            return "Removed product";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }


    }

    public List<Product> getAllProducts() {

        try {
            return productService.getAllProducts();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
