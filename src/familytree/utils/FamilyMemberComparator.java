package familytree.utils;

import familytree.model.FamilyMember;
import java.util.Comparator;

public class FamilyMemberComparator<T extends FamilyMember> implements Comparator<T> {
    private SortCriteria criteria;

    public enum SortCriteria {
        BY_NAME, BY_BIRTH_DATE, BY_ID
    }

    public FamilyMemberComparator(SortCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public int compare(T m1, T m2) {
        switch (criteria) {
            case BY_NAME:
                return m1.getName().compareTo(m2.getName());
            case BY_BIRTH_DATE:
                return m1.getBirthDate().compareTo(m2.getBirthDate());
            case BY_ID:
                return Integer.compare(m1.getId(), m2.getId());
            default:
                throw new IllegalArgumentException("Unknown sorting criteria");
        }
    }
}