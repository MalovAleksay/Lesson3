package familytree.utils;

import familytree.model.FamilyMember;

public interface CompareStrategy {
    int compare(FamilyMember m1, FamilyMember m2);
    String getDescription();
}