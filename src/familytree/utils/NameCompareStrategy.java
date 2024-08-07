package familytree.utils;

import familytree.model.FamilyMember;

public class NameCompareStrategy implements CompareStrategy {
    @Override
    public int compare(FamilyMember m1, FamilyMember m2) {
        return m1.getName().compareTo(m2.getName());
    }


    @Override
    public String getDescription() {
        return "По имени";
    }
}