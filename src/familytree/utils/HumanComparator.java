package familytree.utils;

import familytree.model.Human;
import java.util.Comparator;

public class HumanComparator implements Comparator<Human> {
    private SortCriteria criteria;

    public enum SortCriteria {
        BY_NAME,
        BY_BIRTH_DATE,
        BY_ID
    }

    public HumanComparator(SortCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public int compare(Human h1, Human h2) {
        switch (criteria) {
            case BY_NAME:
                return h1.getName().compareTo(h2.getName());
            case BY_BIRTH_DATE:
                return h1.getBirthDate().compareTo(h2.getBirthDate());
            case BY_ID:
                return Integer.compare(h1.getId(), h2.getId());
            default:
                throw new IllegalArgumentException("Unknown sorting criteria");
        }
    }
}