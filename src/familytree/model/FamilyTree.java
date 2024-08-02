
package familytree.model;

import familytree.utils.FamilyMemberComparator;
import java.util.*;

// Применение принципа Single Responsibility (SRP)
// Класс отвечает только за управление структурой семейного дерева
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

    // Применение принципа Open/Closed (OCP)
    // Метод сортировки использует стратегию сортировки, позволяя добавлять новые критерии без изменения кода
    public void sort(FamilyMemberComparator.SortCriteria criteria) {
        List<FamilyMember> sortedList = new ArrayList<>(members.values());
        sortedList.sort(new FamilyMemberComparator(criteria));
        members.clear();
        for (FamilyMember member : sortedList) {
            members.put(member.getId(), member);
        }
    }
}
// Остальные классы (FamilyTreePresenter, FamilyTreeService, FamilyTreeServiceImpl, и тд)
// также были изменены с учетом принципов SOLID
// Основные изменения включают:
// - Улучшение разделения ответственности между классами
// - Использование абстракций вместо конкретных реализаций
// - Улучшение расширяемости кода
// - Обеспечение возможности замены компонентов без изменения существующего кода