public class Main {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("   Financial Forecasting Tool Demo        ");
        System.out.println("   Using Recursive Algorithms              ");
        System.out.println("==========================================\n");

        double initialInvestment = 100000.00; // starting value: $100,000
        double annualGrowthRate  = 0.08;       // 8% growth per year
        int    years             = 10;         // forecast 10 years ahead

        // ── TEST 1: Basic Recursive Approach ──────────
        System.out.println("--- Test 1: Basic Recursive Forecast ---");
        System.out.println("Initial Investment : $" + initialInvestment);
        System.out.println("Annual Growth Rate  : " + (annualGrowthRate * 100) + "%");
        System.out.println("Forecasting for     : " + years + " years\n");

        FinancialForecaster.callCount = 0; // reset counter
        long startBasic = System.nanoTime();
        double futureValue = FinancialForecaster.calculateFutureValue(
                initialInvestment, annualGrowthRate, years);
        long endBasic = System.nanoTime();

        System.out.println("Future Value after " + years + " years: $" +
                           String.format("%.2f", futureValue));
        System.out.println("Total recursive calls: " + FinancialForecaster.callCount);
        System.out.println("Time taken: " + (endBasic - startBasic) + " ns");

        // ── TEST 2: Year-by-year forecast printout ────
        System.out.println("\n--- Test 2: Year-by-Year Forecast ---");
        for (int y = 0; y <= years; y++) {
            double value = FinancialForecaster.calculateFutureValue(
                    initialInvestment, annualGrowthRate, y);
            System.out.println("  Year " + y + " : $" + String.format("%.2f", value));
        }

        // ── TEST 3: Optimized with Memoization ────────
        System.out.println("\n--- Test 3: Optimized (Memoized) Forecast ---");
        FinancialForecaster.callCount = 0; // reset counter
        Double[] memo = new Double[years + 1]; // cache array

        long startMemo = System.nanoTime();
        double futureValueMemo = FinancialForecaster.calculateFutureValueMemoized(
                initialInvestment, annualGrowthRate, years, memo);
        long endMemo = System.nanoTime();

        System.out.println("Future Value after " + years + " years: $" +
                           String.format("%.2f", futureValueMemo));
        System.out.println("Total recursive calls: " + FinancialForecaster.callCount);
        System.out.println("Time taken: " + (endMemo - startMemo) + " ns");

        // ── TEST 4: Compare repeated calls (shows memoization benefit) ──
        System.out.println("\n--- Test 4: Repeated Calls Comparison ---");

        System.out.println("\n[WITHOUT Memoization] Calling forecast 5 times for year 10:");
        FinancialForecaster.callCount = 0;
        for (int i = 0; i < 5; i++) {
            FinancialForecaster.calculateFutureValue(initialInvestment, annualGrowthRate, years);
        }
        System.out.println("Total calls across 5 runs: " + FinancialForecaster.callCount);

        System.out.println("\n[WITH Memoization] Calling forecast 5 times for year 10:");
        FinancialForecaster.callCount = 0;
        Double[] sharedMemo = new Double[years + 1]; // shared cache across calls
        for (int i = 0; i < 5; i++) {
            FinancialForecaster.calculateFutureValueMemoized(
                    initialInvestment, annualGrowthRate, years, sharedMemo);
        }
        System.out.println("Total calls across 5 runs: " + FinancialForecaster.callCount);

        // ── TEST 5: Variable Growth Rate Forecast ──────
        System.out.println("\n--- Test 5: Variable Growth Rate Forecast ---");
        double[] marketGrowthRates = {
            0.10, 0.08, -0.05, 0.12, 0.07,   // years 1-5 (note: year 3 is a downturn!)
            0.09, 0.11, 0.06, 0.08, 0.10     // years 6-10
        };

        System.out.println("Initial Investment : $" + initialInvestment);
        System.out.println("Growth rates vary each year (simulating market conditions)\n");

        for (int y = 0; y <= years; y++) {
            double value = FinancialForecaster.forecastWithVariableGrowth(
                    initialInvestment, marketGrowthRates, y);
            String rateUsed = (y == 0) ? "N/A (start)" :
                              (marketGrowthRates[y-1] * 100) + "%";
            System.out.println("  Year " + y + " : $" + String.format("%.2f", value) +
                               "  (rate applied: " + rateUsed + ")");
        }

        // ── ANALYSIS SUMMARY ───────────────────────────
        System.out.println("\n==========================================");
        System.out.println("           COMPLEXITY ANALYSIS            ");
        System.out.println("==========================================");
        System.out.println("Basic Recursion Time Complexity     : O(n)");
        System.out.println("Memoized Recursion Time Complexity  : O(n) first call,");
        System.out.println("                                       O(1) on repeated calls");
        System.out.println("Space Complexity (call stack)       : O(n)");
        System.out.println("\nFor n = " + years + " years:");
        System.out.println("  Basic recursion calls (single run): " + (years + 1));
        System.out.println("  Memoized calls (5 repeated runs)   : much lower due to cache");
        System.out.println("==========================================");

        System.out.println("\n==========================================");
        System.out.println("            Demo Complete                 ");
        System.out.println("==========================================");
    }
}