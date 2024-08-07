package familytree.view;

import familytree.model.FamilyMember;
import familytree.model.Gender;
import familytree.utils.CompareStrategyFactory;

import java.time.LocalDate;
import java.util.*;

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
    public Map<String, Object> getNewFamilyMemberInfo() {
        Map<String, Object> info = new HashMap<>();
        System.out.print("Введите ID: ");
        info.put("id", Integer.parseInt(scanner.nextLine()));
        System.out.print("Введите имя: ");
        info.put("name", scanner.nextLine());
        System.out.print("Введите пол (M/F): ");
        info.put("gender", scanner.nextLine().equalsIgnoreCase("M") ? Gender.MALE : Gender.FEMALE);
        System.out.print("Введите дату рождения (yyyy-MM-dd): ");
        info.put("birthDate", LocalDate.parse(scanner.nextLine()));
        return info;
    }

    @Override
    public void displayFamilyTree(List<FamilyMember> members) {
        System.out.println("\nСемейное древо:");
        for (FamilyMember member : members) {
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
    public void displayRelations(FamilyMember member, FamilyMember spouse, FamilyMember mother, FamilyMember father, List<FamilyMember> children) {
        System.out.println("\nСвязи для " + member.getName() + ":");
        System.out.println("Супруг(а): " + (spouse != null ? spouse.getName() : "нет"));
        System.out.println("Мать: " + (mother != null ? mother.getName() : "неизвестна"));
        System.out.println("Отец: " + (father != null ? father.getName() : "неизвестен"));
        System.out.println("Дети: " + (children.isEmpty() ?
                "отсутствуют" :
                String.join(", ", children.stream().map(FamilyMember::getName).toArray(String[]::new))));
    }

    @Override
    public String getSortCriteria() {
        System.out.println("Выберите критерий сортировки:");
        Map<String, String> strategies = CompareStrategyFactory.getAvailableStrategies();
        List<String> keys = new ArrayList<>(strategies.keySet());
        for (int i = 0; i < keys.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, strategies.get(keys.get(i)));
        }
        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        if (choice >= 0 && choice < keys.size()) {
            return keys.get(choice);
        } else {
            throw new IllegalArgumentException("Неверный выбор критерия сортировки");
        }
    }
}