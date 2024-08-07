package familytree.utils;

import familytree.model.FamilyMember;

public class IdCompareStrategy implements CompareStrategy {
    @Override
    public int compare(FamilyMember m1, FamilyMember m2) {
        return Integer.compare(m1.getId(), m2.getId());
    }

    @Override
    public String getDescription() {
        return "По ID";
    }
}