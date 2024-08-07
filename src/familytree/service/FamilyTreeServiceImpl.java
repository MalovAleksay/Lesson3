package familytree.service;

import familytree.model.FamilyMember;
import familytree.model.FamilyTree;
import familytree.model.Human;
import familytree.model.Gender;
import familytree.model.repository.FamilyTreeRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class FamilyTreeServiceImpl implements FamilyTreeService {
    private FamilyTree familyTree;
    private FamilyTreeRepository repository;

    public FamilyTreeServiceImpl(FamilyTreeRepository repository) {
        this.familyTree = new FamilyTree();
        this.repository = repository;
    }

    @Override
    public void addMember(Map<String, Object> memberInfo) {
        FamilyMember newMember = new Human(
                (int) memberInfo.get("id"),
                (String) memberInfo.get("name"),
                (Gender) memberInfo.get("gender"),
                (LocalDate) memberInfo.get("birthDate")
        );
        familyTree.addMember(newMember);
    }

    @Override
    public FamilyMember getMember(int id) {
        return familyTree.getMember(id);
    }

    @Override
    public List<FamilyMember> getAllMembers() {
        return familyTree.getAllMembers();
    }

    @Override
    public void setSpouse(int memberId, int spouseId) {
        FamilyMember member = familyTree.getMember(memberId);
        if (member != null) {
            member.setSpouseId(spouseId);
        }
    }

    @Override
    public void addChild(int parentId, int childId) {
        FamilyMember parent = familyTree.getMember(parentId);
        if (parent != null) {
            parent.addChildId(childId);
        }
    }

    @Override
    public void setFather(int childId, int fatherId) {
        FamilyMember child = familyTree.getMember(childId);
        if (child != null) {
            child.setFatherId(fatherId);
        }
    }

    @Override
    public void setMother(int childId, int motherId) {
        FamilyMember child = familyTree.getMember(childId);
        if (child != null) {
            child.setMotherId(motherId);
        }
    }

    @Override
    public void sortMembers(String criteria) {
        familyTree.sort(criteria);
    }

    @Override
    public void saveData() {
        repository.saveTree(familyTree);
    }

    @Override
    public void loadData() {
        familyTree = repository.loadTree();
    }
}