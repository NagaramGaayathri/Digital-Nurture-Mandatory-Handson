import java.util.List;

// SERVICE CLASS
// Contains business logic
// Depends on CustomerRepository — injected via constructor
public class CustomerService {

    // Depends on interface NOT implementation (loose coupling)
    private CustomerRepository customerRepository;

    // ── CONSTRUCTOR INJECTION ─────────────────────────
    // Repository is injected from outside — not created here
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        System.out.println("[SERVICE] CustomerService created.");
        System.out.println("[SERVICE] Repository injected: " +
                           customerRepository.getClass().getSimpleName());
    }

    // Find customer by ID with validation
    public Customer getCustomerById(String customerId) {
        System.out.println("\n[SERVICE] Getting customer by ID: " + customerId);
        if (customerId == null || customerId.isEmpty()) {
            System.out.println("[SERVICE] ✗ Invalid customer ID!");
            return null;
        }
        Customer customer = customerRepository.findCustomerById(customerId);
        if (customer == null) {
            System.out.println("[SERVICE] ✗ Customer not found: " + customerId);
        } else {
            System.out.println("[SERVICE] ✓ Customer found: " + customer.getName());
        }
        return customer;
    }

    // Find customer by email
    public Customer getCustomerByEmail(String email) {
        System.out.println("\n[SERVICE] Getting customer by email: " + email);
        Customer customer = customerRepository.findCustomerByEmail(email);
        if (customer == null) {
            System.out.println("[SERVICE] ✗ No customer with email: " + email);
        } else {
            System.out.println("[SERVICE] ✓ Customer found: " + customer.getName());
        }
        return customer;
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        System.out.println("\n[SERVICE] Getting all customers...");
        List<Customer> customers = customerRepository.findAllCustomers();
        System.out.println("[SERVICE] ✓ Total customers found: " + customers.size());
        return customers;
    }

    // Register new customer with business logic
    public void registerCustomer(Customer customer) {
        System.out.println("\n[SERVICE] Registering new customer: " + customer.getName());
        if (customerRepository.customerExists(customer.getCustomerId())) {
            System.out.println("[SERVICE] ✗ Customer ID already exists!");
            return;
        }
        customerRepository.saveCustomer(customer);
        System.out.println("[SERVICE] ✓ Customer registered successfully!");
    }

    // Update customer membership
    public void upgradeMembership(String customerId, String newMembership) {
        System.out.println("\n[SERVICE] Upgrading membership for: " + customerId);
        Customer customer = customerRepository.findCustomerById(customerId);
        if (customer == null) {
            System.out.println("[SERVICE] ✗ Customer not found!");
            return;
        }
        String oldMembership = customer.getMembershipType();
        customer.setMembershipType(newMembership);
        customerRepository.updateCustomer(customer);
        System.out.println("[SERVICE] ✓ Membership upgraded: " +
                           oldMembership + " → " + newMembership);
    }

    // Remove customer
    public void removeCustomer(String customerId) {
        System.out.println("\n[SERVICE] Removing customer: " + customerId);
        if (!customerRepository.customerExists(customerId)) {
            System.out.println("[SERVICE] ✗ Customer not found!");
            return;
        }
        customerRepository.deleteCustomer(customerId);
        System.out.println("[SERVICE] ✓ Customer removed successfully!");
    }
}