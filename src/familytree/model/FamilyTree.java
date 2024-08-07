package familytree.model;

import familytree.utils.FamilyMemberComparator;
import familytree.utils.CompareStrategyFactory;
import java.util.*;

public class FamilyTree {
    private Map<Integer, FamilyMember> members;

    public FamilyTree() {
        this.members = new HashMap<>();
    }

    public void addMember(FamilyMember member) {
        members.put(member.getId(), member);
    }

    public FamilyMember getMember(int id) {
        return members.get(id);
    }

    public List<FamilyMember> getAllMembers() {
        return new ArrayList<>(members.values());
    }

    public void clear() {
        members.clear();
    }

    public void sort(String criteria) {
        List<FamilyMember> sortedList = new ArrayList<>(members.values());
        sortedList.sort(new FamilyMemberComparator(CompareStrategyFactory.getStrategy(criteria)));
        members.clear();
        for (FamilyMember member : sortedList) {
            members.put(member.getId(), member);
        }
    }
}