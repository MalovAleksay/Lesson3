package familytree.command;

import familytree.presenter.FamilyTreePresenter;

public class SaveDataCommand implements Command {
    private FamilyTreePresenter presenter;

    public SaveDataCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.saveData();
    }
}