package familytree.model;

import java.time.LocalDate;
import java.util.List;

public interface FamilyMember {
    int getId();
    String getName();
    LocalDate getBirthDate();
    Gender getGender();
    int getSpouseId();
    void setSpouseId(int spouseId);
    int getMotherId();
    void setMotherId(int motherId);
    int getFatherId();
    void setFatherId(int fatherId);
    List<Integer> getChildrenIds();
    void addChildId(int childId);
}
