

package familytree.model;

import java.time.LocalDate;
import java.util.List;

// Применение принципа Interface Segregation (ISP)
// Интерфейс определяет только необходимые методы для работы с членом семьи
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
