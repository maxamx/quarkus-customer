package maxamx.model;

import java.math.BigInteger;

public class Customer {

    public Long id;
    public String name;
    public String lastName;
    public String document;

    public Customer(){}

    public Customer(Long id, String name, String lastName, String document) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", document='" + document + '\'' +
                '}';
    }
}
