package familytree;

import familytree.utils.FamilyMemberComparator;
import java.util.*;

public class FamilyTree<T extends FamilyMember> implements Iterable<T> {
    private List<T> family;

    public FamilyTree() {
        this.family = new ArrayList<>();
    }

    public void addMember(T member) {
        family.add(member);
    }

    public void sort(FamilyMemberComparator.SortCriteria criteria) {
        family.sort(new FamilyMemberComparator<>(criteria));
    }

    @Override
    public Iterator<T> iterator() {
        return family.iterator();
    }

    public int size() {
        return family.size();
    }
}