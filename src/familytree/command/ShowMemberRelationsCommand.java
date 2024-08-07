package familytree.command;

import familytree.presenter.FamilyTreePresenter;

public class ShowMemberRelationsCommand implements Command {
    private FamilyTreePresenter presenter;

    public ShowMemberRelationsCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.showMemberRelations();
    }
}