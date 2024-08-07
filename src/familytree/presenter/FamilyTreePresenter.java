package familytree.presenter;

import familytree.command.*;
import familytree.service.FamilyTreeService;
import familytree.view.FamilyTreeView;
import familytree.model.FamilyMember;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTreePresenter {
    private FamilyTreeService service;
    private FamilyTreeView view;
    private Map<Integer, Command> commands;
    private boolean running;

    public FamilyTreePresenter(FamilyTreeService service, FamilyTreeView view) {
        this.service = service;
        this.view = view;
        this.commands = new HashMap<>();
        initializeCommands();
    }

    private void initializeCommands() {
        commands.put(1, new AddFamilyMemberCommand(this));
        commands.put(2, new DisplayFamilyTreeCommand(this));
        commands.put(3, new ShowMemberRelationsCommand(this));
        commands.put(4, new SortFamilyTreeCommand(this));
        commands.put(5, new SaveDataCommand(this));
        commands.put(6, new LoadDataCommand(this));
        commands.put(7, () -> running = false);
    }

    public void run() {
        running = true;
        while (running) {
            view.showMenu();
            int choice = view.getUserChoice();
            Command command = commands.get(choice);
            if (command != null) {
                command.execute();
            } else {
                view.displayMessage("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    public void addFamilyMember() {
        Map<String, Object> memberInfo = view.getNewFamilyMemberInfo();
        service.addMember(memberInfo);
        view.displayMessage("Член семьи успешно добавлен в семейное древо.");
    }

    public void displayFamilyTree() {
        List<FamilyMember> members = service.getAllMembers();
        view.displayFamilyTree(members);
    }

    public void showMemberRelations() {
        int memberId = view.getMemberIdForRelations();
        FamilyMember member = service.getMember(memberId);
        if (member != null) {
            FamilyMember spouse = service.getMember(member.getSpouseId());
            FamilyMember mother = service.getMember(member.getMotherId());
            FamilyMember father = service.getMember(member.getFatherId());
            List<FamilyMember> children = member.getChildrenIds().stream()
                    .map(service::getMember)
                    .toList();
            view.displayRelations(member, spouse, mother, father, children);
        } else {
            view.displayMessage("Член семьи с указанным ID не найден.");
        }
    }

    public void sortFamilyTree() {
        String criteria = view.getSortCriteria();
        service.sortMembers(criteria);
        view.displayMessage("Семейное древо отсортировано.");
        displayFamilyTree();
    }

    public void saveData() {
        service.saveData();
        view.displayMessage("Данные успешно сохранены.");
    }

    public void loadData() {
        service.loadData();
        view.displayMessage("Данные успешно загружены.");
    }
}