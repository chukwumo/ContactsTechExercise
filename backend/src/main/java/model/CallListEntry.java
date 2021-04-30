package model;

public class CallListEntry {
    private Name name;
    private String phone;

    public CallListEntry(Name name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
