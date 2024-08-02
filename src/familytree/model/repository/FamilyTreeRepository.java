package familytree.model.repository;

import familytree.model.FamilyMember;
import java.util.List;

// Применение принципа Interface Segregation (ISP)
// Интерфейс определяет только необходимые методы для работы с хранилищем
public interface FamilyTreeRepository {
    void saveMembers(List<FamilyMember> members);
    List<FamilyMember> loadMembers();
}