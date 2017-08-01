package riviasoftware.githubapplicationmvp.injection.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import riviasoftware.githubapplicationmvp.manager.NetworkManager;
import riviasoftware.githubapplicationmvp.ui.presenters.DetailFragmentPresenter;
import riviasoftware.githubapplicationmvp.ui.presenters.MainFragmentPresenter;
import riviasoftware.githubapplicationmvp.ui.presenters.Presenter;

/**
 * Created by sergiolizanamontero on 1/8/17.
 */

@Module
public class PresenterModule {

    @Provides
    @Singleton
    DetailFragmentPresenter provideDetailFragmentPresenter(NetworkManager networkManager) {
        return new DetailFragmentPresenter(networkManager);
    }

    @Provides
    @Singleton
    MainFragmentPresenter provideMainFragmentPresenter(NetworkManager networkManager) {
        return new MainFragmentPresenter(networkManager);
    }
}
