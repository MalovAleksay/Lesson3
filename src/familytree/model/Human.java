
package familytree.model;

import java.time.LocalDate;

// Применение принципа Liskov Substitution (LSP)
// Класс Human расширяет AbstractFamilyMember и может быть использован везде, где ожидается FamilyMember
public class Human extends AbstractFamilyMember {
    public Human(int id, String name, Gender gender, LocalDate birthDate) {
        super(id, name, gender, birthDate);
    }

    @Override
    public String toString() {
        return String.format("id: %d, имя: %s, пол: %s, дата рождения: %s", getId(), getName(), getGender(), getBirthDate());
    }
}