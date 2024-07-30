package familytree.view;

import familytree.model.Human;
import familytree.utils.FamilyMemberComparator;
import java.util.List;

public interface FamilyTreeView {
    void showMenu();
    int getUserChoice();
    Human getNewFamilyMemberInfo();
    void displayFamilyTree(List<Human> members);
    void displayMessage(String message);
    int getMemberIdForRelations();
    void displayRelations(Human member, Human spouse, Human mother, Human father, List<Human> children);
    FamilyMemberComparator.SortCriteria getSortCriteria();
}