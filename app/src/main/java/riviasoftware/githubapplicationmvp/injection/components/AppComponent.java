package riviasoftware.githubapplicationmvp.injection.components;

import javax.inject.Singleton;

import dagger.Component;
import riviasoftware.githubapplicationmvp.injection.modules.AppModule;
import riviasoftware.githubapplicationmvp.injection.modules.NetworkManagerModule;
import riviasoftware.githubapplicationmvp.injection.modules.PresenterModule;
import riviasoftware.githubapplicationmvp.manager.NetworkManagerImpl;
import riviasoftware.githubapplicationmvp.ui.presenters.DetailFragmentPresenter;
import riviasoftware.githubapplicationmvp.ui.presenters.MainFragmentPresenter;
import riviasoftware.githubapplicationmvp.ui.presenters.Presenter;
import riviasoftware.githubapplicationmvp.ui.view.DetailFragment;
import riviasoftware.githubapplicationmvp.ui.view.MainActivityFragment;

/**
 * Created by sergiolizanamontero on 1/8/17.
 */

@Singleton
@Component(modules = {AppModule.class, PresenterModule.class,NetworkManagerModule.class})
public interface AppComponent {
        void inject(MainActivityFragment target);
        void inject(DetailFragment target);
        void inject(DetailFragmentPresenter target);
        void inject(MainFragmentPresenter target);
        void inject(NetworkManagerImpl target);
    }

