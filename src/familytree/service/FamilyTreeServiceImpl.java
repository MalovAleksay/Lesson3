package familytree.service;

import familytree.model.FamilyMember;
import familytree.model.FamilyTree;
import familytree.model.repository.FamilyTreeRepository;
import familytree.utils.FamilyMemberComparator;
import java.util.List;

public class FamilyTreeServiceImpl implements FamilyTreeService {
    private FamilyTree familyTree;
    private FamilyTreeRepository repository;

    public FamilyTreeServiceImpl(FamilyTreeRepository repository) {
        this.familyTree = new FamilyTree();
        this.repository = repository;
    }

    @Override
    public void addMember(FamilyMember member) {
        familyTree.addMember(member);
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
    public void sortMembers(FamilyMemberComparator.SortCriteria criteria) {
        familyTree.sort(criteria);
    }

    @Override
    public void saveData() {
        repository.saveMembers(getAllMembers());
    }

    @Override
    public void loadData() {
        List<FamilyMember> members = repository.loadMembers();
        familyTree.clear();
        for (FamilyMember member : members) {
            addMember(member);
        }
    }
}