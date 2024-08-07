package familytree.utils;

import familytree.model.FamilyMember;
import java.util.Comparator;

public class FamilyMemberComparator implements Comparator<FamilyMember> {
    private CompareStrategy strategy;

    public FamilyMemberComparator(CompareStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public int compare(FamilyMember m1, FamilyMember m2) {
        return strategy.compare(m1, m2);
    }
}