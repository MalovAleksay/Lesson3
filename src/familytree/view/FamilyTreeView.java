package familytree.view;

import familytree.model.FamilyMember;
import java.util.List;
import java.util.Map;

public interface FamilyTreeView {
    void showMenu();
    int getUserChoice();
    Map<String, Object> getNewFamilyMemberInfo();
    void displayFamilyTree(List<FamilyMember> members);
    void displayMessage(String message);
    int getMemberIdForRelations();
    void displayRelations(FamilyMember member, FamilyMember spouse, FamilyMember mother, FamilyMember father, List<FamilyMember> children);
    String getSortCriteria();
}