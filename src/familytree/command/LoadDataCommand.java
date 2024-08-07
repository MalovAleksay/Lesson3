package familytree.command;

import familytree.presenter.FamilyTreePresenter;

public class LoadDataCommand implements Command {
    private FamilyTreePresenter presenter;

    public LoadDataCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.loadData();
    }
}