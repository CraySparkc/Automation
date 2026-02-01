package data;
import java.util.*;

public class StateAndCity {

    private final Map<String, List<String>> data;

    public StateAndCity() {
        data = new HashMap<>();
        initializeData();
    }

    public List<String> getCities(String state) {
        return data.getOrDefault(state, Collections.emptyList());
    }

    public Set<String> getStates() {
        return data.keySet();
    }

    private void initializeData() {
        data.put("NCR", new ArrayList<>(Arrays.asList("Delhi", "Gurgaon", "Noida")));
        data.put("Uttar Pradesh", new ArrayList<>(Arrays.asList("Agra", "Lucknow", "Merrut")));
        data.put("Haryana", new ArrayList<>(Arrays.asList("Karnal", "Panipat")));
        data.put("Rajasthan", new ArrayList<>(Arrays.asList("Jaipur", "Jaiselmer")));
    }
}
/*
["NCR": ["Delhi","Gurgaon","Noida"],
"Uttar Pradesh": ["Agra", "Lucknow", "Merrut"],
"Haryana": ["Karnal", "Panipat"],
"Rajasthan": ["Jaipur", "Jaiselmer"]
]
*/