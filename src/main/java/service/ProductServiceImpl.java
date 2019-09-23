package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;
import org.omg.IOP.IOR;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {


    private static ProductServiceImpl instance = null;
    private ProductDao productDao = new ProductDaoImpl("products.data", "PRODUCT");

    private ProductServiceImpl() {
    }

    public ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }


    public List<Product> getAllProducts() throws IOException {
        return productDao.getAllProducts();
    }

    public Integer getCountProducts() throws IOException {
        return productDao.getAllProducts().size();
    }


    public Product getProductByName(String productName) throws IOException {
        return productDao.getProductByProductName(productName);
    }

    public boolean isProductExistByName(String productName) {
        Product product = null;
        try {
            product = productDao.getProductByProductName(productName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (product == null) return false;

        return true;
    }

    public boolean isProductExistById(Long productId) {
        Product product = null;

        try {
            product = productDao.getProductById(productId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (product == null) return false;
        return true;
    }

    public boolean isProductOnWareHouse(String productName) {

        try {
            for (Product product : getAllProducts()) {
                if (isProductExistByName(productName) &&
                        product.getProductCount() > 0)
                    return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
