package familytree.service;

import familytree.model.FamilyMember;
import familytree.utils.FamilyMemberComparator;
import java.util.List;

public interface FamilyTreeService {
    void addMember(FamilyMember member);
    FamilyMember getMember(int id);
    List<FamilyMember> getAllMembers();
    void sortMembers(FamilyMemberComparator.SortCriteria criteria);
    void saveData();
    void loadData();
}