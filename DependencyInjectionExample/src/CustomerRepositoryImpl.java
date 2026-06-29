import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// CONCRETE REPOSITORY
// Actual implementation — uses HashMap as in-memory database
public class CustomerRepositoryImpl implements CustomerRepository {

    // Simulated database (HashMap as in-memory store)
    private Map<String, Customer> database = new HashMap<>();

    // Pre-load some sample customers
    public CustomerRepositoryImpl() {
        database.put("C001", new Customer(
            "C001", "Gaayathri Nagaram",
            "gaayathri@gmail.com", "9876543210",
            "Chennai, Tamil Nadu", "Gold"
        ));
        database.put("C002", new Customer(
            "C002", "Ravi Kumar",
            "ravi@gmail.com", "9123456789",
            "Bangalore, Karnataka", "Silver"
        ));
        database.put("C003", new Customer(
            "C003", "Priya Sharma",
            "priya@gmail.com", "9988776655",
            "Mumbai, Maharashtra", "Bronze"
        ));
        database.put("C004", new Customer(
            "C004", "Arjun Reddy",
            "arjun@gmail.com", "9012345678",
            "Hyderabad, Telangana", "Gold"
        ));
        System.out.println("[REPO] Database initialized with " +
                           database.size() + " customers.");
    }

    @Override
    public Customer findCustomerById(String customerId) {
        System.out.println("[REPO] Searching for customer ID: " + customerId);
        return database.get(customerId);
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        System.out.println("[REPO] Searching for customer email: " + email);
        for (Customer c : database.values()) {
            if (c.getEmail().equalsIgnoreCase(email)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Customer> findAllCustomers() {
        System.out.println("[REPO] Fetching all customers...");
        return new ArrayList<>(database.values());
    }

    @Override
    public void saveCustomer(Customer customer) {
        database.put(customer.getCustomerId(), customer);
        System.out.println("[REPO] Customer saved: " + customer.getName());
    }

    @Override
    public void updateCustomer(Customer customer) {
        if (database.containsKey(customer.getCustomerId())) {
            database.put(customer.getCustomerId(), customer);
            System.out.println("[REPO] Customer updated: " + customer.getName());
        } else {
            System.out.println("[REPO] Customer not found for update!");
        }
    }

    @Override
    public void deleteCustomer(String customerId) {
        if (database.containsKey(customerId)) {
            String name = database.get(customerId).getName();
            database.remove(customerId);
            System.out.println("[REPO] Customer deleted: " + name);
        } else {
            System.out.println("[REPO] Customer ID not found: " + customerId);
        }
    }

    @Override
    public boolean customerExists(String customerId) {
        return database.containsKey(customerId);
    }
}