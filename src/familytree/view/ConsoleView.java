package familytree.view;

import familytree.model.Gender;
import familytree.model.Human;
import familytree.utils.FamilyMemberComparator;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleView implements FamilyTreeView {
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        System.out.println("\n1. Добавить члена семьи");
        System.out.println("2. Показать семейное древо");
        System.out.println("3. Показать связи члена семьи");
        System.out.println("4. Отсортировать семейное древо");
        System.out.println("5. Сохранить данные");
        System.out.println("6. Загрузить данные");
        System.out.println("7. Выход");
    }

    @Override
    public int getUserChoice() {
        System.out.print("Выберите действие: ");
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public Human getNewFamilyMemberInfo() {
        System.out.print("Введите ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите пол (M/F): ");
        Gender gender = scanner.nextLine().equalsIgnoreCase("M") ? Gender.MALE : Gender.FEMALE;
        System.out.print("Введите дату рождения (yyyy-MM-dd): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        return new Human(id, name, gender, birthDate);
    }

    @Override
    public void displayFamilyTree(List<Human> members) {
        System.out.println("\nСемейное древо:");
        for (Human member : members) {
            System.out.println(member);
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public int getMemberIdForRelations() {
        System.out.print("Введите ID члена семьи для отображения связей: ");
        return Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void displayRelations(Human member, Human spouse, Human mother, Human father, List<Human> children) {
        System.out.println("\nСвязи для " + member.getName() + ":");
        System.out.println("Супруг(а): " + (spouse != null ? spouse.getName() : "нет"));
        System.out.println("Мать: " + (mother != null ? mother.getName() : "неизвестна"));
        System.out.println("Отец: " + (father != null ? father.getName() : "неизвестен"));
        System.out.println("Дети: " + (children.isEmpty() ?
                "отсутствуют" :
                String.join(", ", children.stream().map(Human::getName).toArray(String[]::new))));
    }

    @Override
    public FamilyMemberComparator.SortCriteria getSortCriteria() {
        System.out.println("Выберите критерий сортировки:");
        System.out.println("1. По имени");
        System.out.println("2. По дате рождения");
        System.out.println("3. По ID");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1: return FamilyMemberComparator.SortCriteria.BY_NAME;
            case 2: return FamilyMemberComparator.SortCriteria.BY_BIRTH_DATE;
            case 3: return FamilyMemberComparator.SortCriteria.BY_ID;
            default: throw new IllegalArgumentException("Неверный выбор критерия сортировки");
        }
    }
}