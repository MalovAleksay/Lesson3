package familytree;

import java.time.LocalDate;
import java.util.List;

public interface FamilyMember<T extends FamilyMember<T>> {
    int getId();
    String getName();
    LocalDate getBirthDate();
    T getSpouse();
    void setSpouse(T spouse);
    T getMother();
    void setMother(T mother);
    T getFather();
    void setFather(T father);
    List<T> getChildren();
    void addChild(T child);
}