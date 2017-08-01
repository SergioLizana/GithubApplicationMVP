package riviasoftware.githubapplicationmvp.injection.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import riviasoftware.githubapplicationmvp.manager.NetworkManager;
import riviasoftware.githubapplicationmvp.manager.NetworkManagerImpl;

/**
 * Created by sergiolizanamontero on 1/8/17.
 */

@Module
public class NetworkManagerModule {

    @Provides
    @Singleton
    NetworkManager provideNetworkManager(){
        return new NetworkManagerImpl();
    }

}
