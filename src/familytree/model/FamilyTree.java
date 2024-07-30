package familytree.model;

import familytree.utils.FamilyMemberComparator;
import java.util.*;

public class FamilyTree {
    private Map<Integer, Human> members;

    public FamilyTree() {
        this.members = new HashMap<>();
    }

    public void addMember(Human member) {
        members.put(member.getId(), member);
    }

    public Human getMember(int id) {
        return members.get(id);
    }

    public List<Human> getAllMembers() {
        return new ArrayList<>(members.values());
    }

    public void clear() {
        members.clear();
    }

    public void sort(FamilyMemberComparator.SortCriteria criteria) {
        List<Human> sortedList = new ArrayList<>(members.values());
        sortedList.sort(new FamilyMemberComparator<>(criteria));
        members.clear();
        for (Human human : sortedList) {
            members.put(human.getId(), human);
        }
    }
}