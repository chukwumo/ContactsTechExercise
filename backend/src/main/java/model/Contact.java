package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Contact {
    private Long id;
    private Name name;
    private Address address;
    private List<Phone> phoneNumbers;
    private String email;

    public Contact() {

    }

    public Contact(Long id, Name name, Address address, List<Phone> phoneNumbers, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumbers = phoneNumbers;
        this.email = email;
    }

    @JsonProperty
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @JsonProperty
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonProperty
    public List<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhone(List<Phone> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @JsonProperty
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
