package entity;


import entity.enums.ProductSeparators;

public class User {

    private Long id;
    private String login;
    private String password;


    public User(Long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return id + ProductSeparators.PRODUCT_SEPARATOR.toString() + login + ProductSeparators.PRODUCT_SEPARATOR.toString()
                + password;
    }

}