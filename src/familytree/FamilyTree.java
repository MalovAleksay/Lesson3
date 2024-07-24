package familytree;

import familytree.model.Human;
import familytree.utils.HumanComparator;
import java.util.*;

public class FamilyTree implements Iterable<Human> {
    private List<Human> family;

    public FamilyTree() {
        this.family = new ArrayList<>();
    }

    public void addHuman(Human human) {
        family.add(human);
    }

    public void sort(HumanComparator.SortCriteria criteria) {
        family.sort(new HumanComparator(criteria));
    }

    @Override
    public Iterator<Human> iterator() {
        return family.iterator();
    }

    public int size() {
        return family.size();
    }
}