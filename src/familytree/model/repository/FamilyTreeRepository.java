package familytree.model.repository;

import familytree.model.FamilyTree;

import java.util.List;

// Применение принципа Interface Segregation (ISP)
// Интерфейс определяет только необходимые методы для работы с хранилищем
public interface FamilyTreeRepository {
    void saveTree(FamilyTree tree);
    FamilyTree loadTree();
}