package familytree.utils;

import java.util.HashMap;
import java.util.Map;

public class CompareStrategyFactory {
    private static final Map<String, CompareStrategy> strategies = new HashMap<>();

    static {
        strategies.put("name", new NameCompareStrategy());
        strategies.put("birthDate", new BirthDateCompareStrategy());
        strategies.put("id", new IdCompareStrategy());
    }

    public static CompareStrategy getStrategy(String criteria) {
        CompareStrategy strategy = strategies.get(criteria);
        if (strategy == null) {
            throw new IllegalArgumentException("Unknown sorting criteria: " + criteria);
        }
        return strategy;
    }

    public static Map<String, String> getAvailableStrategies() {
        Map<String, String> availableStrategies = new HashMap<>();
        for (Map.Entry<String, CompareStrategy> entry : strategies.entrySet()) {
            availableStrategies.put(entry.getKey(), entry.getValue().getDescription());
        }
        return availableStrategies;
    }
}