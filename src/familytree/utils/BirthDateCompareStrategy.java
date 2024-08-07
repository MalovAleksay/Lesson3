package familytree.utils;

import familytree.model.FamilyMember;

public class BirthDateCompareStrategy implements CompareStrategy {
    @Override
    public int compare(FamilyMember m1, FamilyMember m2) {
        return m1.getBirthDate().compareTo(m2.getBirthDate());
    }

    @Override
    public String getDescription() {
        return "По дате рождения";
    }
}