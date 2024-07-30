package familytree;

import familytree.model.FamilyTree;
import familytree.model.Human;
import familytree.model.Gender;
import familytree.view.ConsoleView;
import familytree.view.FamilyTreeView;
import familytree.presenter.FamilyTreePresenter;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree model = new FamilyTree();
        initializeWithPredefinedData(model);

        FamilyTreeView view = new ConsoleView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(model, view);

        presenter.run();
    }

    private static void initializeWithPredefinedData(FamilyTree familyTree) {
        // Создаем членов семьи
        Human grandfather = new Human(1, "Иван", Gender.MALE, LocalDate.of(1940, 5, 15));
        Human grandmother = new Human(2, "Мария", Gender.FEMALE, LocalDate.of(1942, 8, 20));
        Human father = new Human(3, "Петр", Gender.MALE, LocalDate.of(1965, 3, 10));
        Human mother = new Human(4, "Анна", Gender.FEMALE, LocalDate.of(1967, 11, 25));
        Human uncle = new Human(5, "Алексей", Gender.MALE, LocalDate.of(1970, 7, 5));
        Human aunt = new Human(6, "Елена", Gender.FEMALE, LocalDate.of(1972, 9, 30));
        Human son = new Human(7, "Михаил", Gender.MALE, LocalDate.of(1990, 2, 14));
        Human daughter = new Human(8, "Ольга", Gender.FEMALE, LocalDate.of(1992, 6, 18));
        Human cousin1 = new Human(9, "Дмитрий", Gender.MALE, LocalDate.of(1995, 4, 22));
        Human cousin2 = new Human(10, "Екатерина", Gender.FEMALE, LocalDate.of(1997, 12, 7));

        // Устанавливаем связи
        grandfather.setSpouseId(grandmother.getId());
        grandmother.setSpouseId(grandfather.getId());

        father.setFatherId(grandfather.getId());
        father.setMotherId(grandmother.getId());
        father.setSpouseId(mother.getId());
        grandfather.addChildId(father.getId());
        grandmother.addChildId(father.getId());

        mother.setSpouseId(father.getId());

        uncle.setFatherId(grandfather.getId());
        uncle.setMotherId(grandmother.getId());
        uncle.setSpouseId(aunt.getId());
        grandfather.addChildId(uncle.getId());
        grandmother.addChildId(uncle.getId());

        aunt.setSpouseId(uncle.getId());

        son.setFatherId(father.getId());
        son.setMotherId(mother.getId());
        father.addChildId(son.getId());
        mother.addChildId(son.getId());

        daughter.setFatherId(father.getId());
        daughter.setMotherId(mother.getId());
        father.addChildId(daughter.getId());
        mother.addChildId(daughter.getId());

        cousin1.setFatherId(uncle.getId());
        cousin1.setMotherId(aunt.getId());
        uncle.addChildId(cousin1.getId());
        aunt.addChildId(cousin1.getId());

        cousin2.setFatherId(uncle.getId());
        cousin2.setMotherId(aunt.getId());
        uncle.addChildId(cousin2.getId());
        aunt.addChildId(cousin2.getId());

        // Добавляем всех членов семьи в дерево
        familyTree.addMember(grandfather);
        familyTree.addMember(grandmother);
        familyTree.addMember(father);
        familyTree.addMember(mother);
        familyTree.addMember(uncle);
        familyTree.addMember(aunt);
        familyTree.addMember(son);
        familyTree.addMember(daughter);
        familyTree.addMember(cousin1);
        familyTree.addMember(cousin2);
    }
}