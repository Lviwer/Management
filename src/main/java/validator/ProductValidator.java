package validator;

import api.ProductDao;
import dao.ProductDaoImpl;
import entity.Product;
import exception.ProductCountNegativeException;
import exception.ProductNameEmptyException;
import exception.ProductPriceNoPositiveException;
import exception.ProductWeightNoPositiveException;

public class ProductValidator {

    private final int ZERO = 0;
    private static ProductValidator instance = null;

    private ProductValidator() {

    }

    public ProductValidator getInstance() {
        if (instance == null) {
            return new ProductValidator();
        } else return instance;
    }

    public boolean isValidatePrice(float price) throws ProductPriceNoPositiveException {
        if (price > ZERO) return true;

        throw new ProductPriceNoPositiveException("Price can't be negative !");
    }

    public boolean isValidateProductCount(int numberOfProducts) throws ProductCountNegativeException {
        if (numberOfProducts > ZERO) return true;

        throw new ProductCountNegativeException("Number of products can't be negative !");
    }

    public boolean isValidateProductWeight(float weight) throws ProductWeightNoPositiveException {
        if (weight > ZERO) return true;

        throw new ProductWeightNoPositiveException("Product weight can't be negative !");
    }

    public boolean isValidateProductName(String name) throws ProductNameEmptyException {
        if (name.length() > 0) return true;
        throw new ProductNameEmptyException("Product name can't be empty !");
    }


}
