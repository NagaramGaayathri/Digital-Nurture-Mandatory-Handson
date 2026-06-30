public class FinancialForecaster {

    // Counter to track how many recursive calls happen (for analysis)
    public static int callCount = 0;

    // ── BASIC RECURSIVE APPROACH ─────────────────────────
    // Calculates future value using simple recursion
    // Time Complexity: O(n) — but with repeated work if called multiple times
    public static double calculateFutureValue(double initialValue,
                                                double growthRate,
                                                int year) {
        callCount++; // track number of calls

        // BASE CASE — year 0 means we're at the starting value
        if (year == 0) {
            return initialValue;
        }

        // RECURSIVE CASE — this year's value depends on previous year's
        return calculateFutureValue(initialValue, growthRate, year - 1)
                * (1 + growthRate);
    }

    // ── OPTIMIZED RECURSIVE APPROACH (Memoization) ───────
    // Stores already-computed results to avoid recalculating
    public static double calculateFutureValueMemoized(double initialValue,
                                                        double growthRate,
                                                        int year,
                                                        Double[] memo) {
        callCount++;

        // BASE CASE
        if (year == 0) {
            return initialValue;
        }

        // Check cache first — if already computed, return immediately
        if (memo[year] != null) {
            return memo[year];
        }

        // Compute, store in cache, then return
        double result = calculateFutureValueMemoized(initialValue, growthRate,
                                                       year - 1, memo)
                         * (1 + growthRate);
        memo[year] = result;
        return result;
    }

    // ── FORECAST MULTIPLE YEARS (with varying growth rates) ──
    // Useful when growth rate changes year to year (e.g. market conditions)
    public static double forecastWithVariableGrowth(double initialValue,
                                                      double[] growthRates,
                                                      int year) {
        // BASE CASE
        if (year == 0) {
            return initialValue;
        }

        // RECURSIVE CASE — apply THIS year's specific growth rate
        double previousValue = forecastWithVariableGrowth(initialValue,
                                                            growthRates, year - 1);
        return previousValue * (1 + growthRates[year - 1]);
    }
}