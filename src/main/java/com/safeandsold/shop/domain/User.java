package com.safeandsold.shop.domain;

import java.time.LocalDate;
import java.util.Set;

public class User {

    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String patronymic;
    private LocalDate dateOfBirth;
    private String email;
//    private String password;

    private Set<Product> productSetForSale;
    private Set<Product> shoppingBasket;

    private Set<Role> roles;
    private UserStatus status;
    private boolean active;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Product> getProductSetForSale() {
        return productSetForSale;
    }

    public void setProductSetForSale(Set<Product> productSetForSale) {
        this.productSetForSale = productSetForSale;
    }

    public Set<Product> getShoppingBasket() {
        return shoppingBasket;
    }

    public void setShoppingBasket(Set<Product> shoppingBasket) {
        this.shoppingBasket = shoppingBasket;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
