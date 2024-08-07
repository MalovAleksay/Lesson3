package familytree;

import familytree.model.repository.FileDataRepository;
import familytree.model.repository.FamilyTreeRepository;
import familytree.service.FamilyTreeService;
import familytree.service.FamilyTreeServiceImpl;
import familytree.utils.FamilyTreeInitializer;
import familytree.view.ConsoleView;
import familytree.view.FamilyTreeView;
import familytree.presenter.FamilyTreePresenter;

public class Main {
    public static void main(String[] args) {
        FamilyTreeRepository repository = new FileDataRepository();
        FamilyTreeService service = new FamilyTreeServiceImpl(repository);

        // Инициализация дерева с заранее созданными членами семьи
        FamilyTreeInitializer.initializeDefaultFamilyTree(service);

        FamilyTreeView view = new ConsoleView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(service, view);

        presenter.run();
    }
}