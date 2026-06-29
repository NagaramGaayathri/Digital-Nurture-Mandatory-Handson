import java.util.List;

// REPOSITORY INTERFACE
// Defines what operations are available
// CustomerService depends on THIS, not the implementation
public interface CustomerRepository {

    // Find a single customer by ID
    Customer findCustomerById(String customerId);

    // Find a customer by email
    Customer findCustomerByEmail(String email);

    // Get all customers
    List<Customer> findAllCustomers();

    // Save a new customer
    void saveCustomer(Customer customer);

    // Update existing customer
    void updateCustomer(Customer customer);

    // Delete a customer
    void deleteCustomer(String customerId);

    // Check if customer exists
    boolean customerExists(String customerId);
}