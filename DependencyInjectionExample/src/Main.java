import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("  Customer Management System Demo         ");
        System.out.println("  Using Dependency Injection              ");
        System.out.println("==========================================\n");

        // ── Step 1: Create the concrete repository ────
        CustomerRepository repository = new CustomerRepositoryImpl();

        System.out.println();

        // ── Step 2: INJECT repository into service ────
        // This is Constructor Injection!
        CustomerService service = new CustomerService(repository);

        // ── Test 1: Find customer by ID ───────────────
        System.out.println("\n========== TEST 1: Find by ID ==========");
        Customer c1 = service.getCustomerById("C001");
        if (c1 != null) System.out.println(c1);

        // ── Test 2: Find customer by ID (not found) ───
        System.out.println("\n========== TEST 2: ID Not Found =========");
        Customer c2 = service.getCustomerById("C999");

        // ── Test 3: Find customer by Email ────────────
        System.out.println("\n========== TEST 3: Find by Email ========");
        Customer c3 = service.getCustomerByEmail("priya@gmail.com");
        if (c3 != null) System.out.println(c3);

        // ── Test 4: Register new customer ─────────────
        System.out.println("\n========== TEST 4: Register Customer ====");
        Customer newCustomer = new Customer(
            "C005", "Sneha Patel",
            "sneha@gmail.com", "9876012345",
            "Ahmedabad, Gujarat", "Silver"
        );
        service.registerCustomer(newCustomer);

        // ── Test 5: Register duplicate (should fail) ──
        System.out.println("\n========== TEST 5: Duplicate Register ===");
        service.registerCustomer(newCustomer);

        // ── Test 6: Upgrade membership ────────────────
        System.out.println("\n========== TEST 6: Upgrade Membership ===");
        service.upgradeMembership("C002", "Gold");

        // ── Test 7: Remove customer ───────────────────
        System.out.println("\n========== TEST 7: Remove Customer ======");
        service.removeCustomer("C003");

        // ── Test 8: Get all customers ─────────────────
        System.out.println("\n========== TEST 8: All Customers ========");
        List<Customer> all = service.getAllCustomers();
        for (Customer c : all) {
            System.out.println(c);
        }

        System.out.println("\n==========================================");
        System.out.println("            Demo Complete                 ");
        System.out.println("==========================================");
    }
}