package familytree.view;

import familytree.model.FamilyMember;
import familytree.utils.FamilyMemberComparator;
import java.util.List;

public interface FamilyTreeView {
    void showMenu();
    int getUserChoice();
    FamilyMember getNewFamilyMemberInfo();
    void displayFamilyTree(List<FamilyMember> members);
    void displayMessage(String message);
    int getMemberIdForRelations();
    void displayRelations(FamilyMember member, FamilyMember spouse, FamilyMember mother, FamilyMember father, List<FamilyMember> children);
    FamilyMemberComparator.SortCriteria getSortCriteria();
}