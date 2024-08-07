package familytree.service;

import familytree.model.FamilyMember;
import java.util.List;
import java.util.Map;

public interface FamilyTreeService {
    void addMember(Map<String, Object> memberInfo);
    FamilyMember getMember(int id);
    List<FamilyMember> getAllMembers();
    void setSpouse(int memberId, int spouseId);
    void addChild(int parentId, int childId);
    void setFather(int childId, int fatherId);
    void setMother(int childId, int motherId);
    void sortMembers(String criteria);
    void saveData();
    void loadData();
}