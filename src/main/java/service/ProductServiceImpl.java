package service;

import api.ProductDao;
import api.ProductService;
import dao.ProductDaoImpl;
import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;
import validator.ProductValidator;

import java.io.IOException;
import java.util.List;

public class ProductServiceImpl implements ProductService {


    private static ProductServiceImpl instance = null;
    private ProductDao productDao = ProductDaoImpl.getInstance();
    private ProductValidator productValidator = ProductValidator.getInstance();


    private ProductServiceImpl() {
    }

    public static ProductServiceImpl getInstance() {
        if (instance == null) {
            instance = new ProductServiceImpl();
        }
        return instance;
    }


    public List<Product> getAllProducts() throws IOException {
        return productDao.getAllProducts();
    }

    public Integer getCountProducts() throws IOException {
        return getAllProducts().size();
    }

    public Product getProductByProductName(String productName) throws IOException {
        List<Product> products = getAllProducts();

        for (Product product : products) {
            boolean isFoundProduct = product.getProductName().equals(productName);
            if (isFoundProduct) {
                return product;
            }
        }
        return null;
    }

    public Product getProductById(Long productId) throws IOException {
        List<Product> products = getAllProducts();

        for (Product product : products) {
            boolean isFoundProduct = product.getId().equals(productId);
            if (isFoundProduct) return product;
        }
        return null;
    }


    public void removeProduct(String productName) throws Exception {
        productDao.removeProductByName(productName);
    }


    public boolean isProductExistByName(String productName) throws IOException {

        Product product = null;
        product = getProductByProductName(productName);
        return product == null;
    }

    public boolean isProductExistById(Long productId) throws IOException {
        Product product = null;
        product = getProductById(productId);

        return product == null;
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

    public boolean saveProduct(Product product) throws IOException, ProductWeightNoPositiveException, ProductNameEmptyException,
            ProductCountNegativeException, ProductPriceNoPositiveException {
        if (productValidator.isValidate(product)) {
            productDao.saveProduct(product);
            return true;
        }

        return false;
    }
}
