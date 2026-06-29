// MODEL — represents a Customer object
public class Customer {

    private String customerId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String membershipType; // Gold, Silver, Bronze

    public Customer(String customerId, String name, String email,
                    String phone, String address, String membershipType) {
        this.customerId     = customerId;
        this.name           = name;
        this.email          = email;
        this.phone          = phone;
        this.address        = address;
        this.membershipType = membershipType;
    }

    // Getters
    public String getCustomerId()     { return customerId; }
    public String getName()           { return name; }
    public String getEmail()          { return email; }
    public String getPhone()          { return phone; }
    public String getAddress()        { return address; }
    public String getMembershipType() { return membershipType; }

    // Setters
    public void setName(String name)                     { this.name = name; }
    public void setEmail(String email)                   { this.email = email; }
    public void setPhone(String phone)                   { this.phone = phone; }
    public void setAddress(String address)               { this.address = address; }
    public void setMembershipType(String membershipType) { this.membershipType = membershipType; }

    @Override
    public String toString() {
        return "\n===========================================" +
               "\n  Customer ID  : " + customerId +
               "\n  Name         : " + name +
               "\n  Email        : " + email +
               "\n  Phone        : " + phone +
               "\n  Address      : " + address +
               "\n  Membership   : " + membershipType +
               "\n===========================================";
    }
}