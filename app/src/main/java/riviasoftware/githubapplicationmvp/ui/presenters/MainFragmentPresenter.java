package riviasoftware.githubapplicationmvp.ui.presenters;

import java.util.List;

import javax.inject.Inject;

import riviasoftware.githubapplicationmvp.manager.NetworkManager;
import riviasoftware.githubapplicationmvp.model.GithubUser;
import riviasoftware.githubapplicationmvp.model.GithubUserDetail;
import riviasoftware.githubapplicationmvp.ui.view.MainActivityFragment;

/**
 * Created by sergiolizanamontero on 26/7/17.
 */

public class MainFragmentPresenter implements Presenter {

    List<GithubUser> users;

    NetworkManager networkManager;
    MainActivityFragment mainActivityFragment;


    public MainFragmentPresenter(NetworkManager networkManager) {
        this.networkManager = networkManager;
    }

    public void retrieveUsers(){
        if(users != null){
            pintarUsuarios(users);
        }else{
           networkManager.getUsers(this);
        }
    }

    public void setMainFragmentActivity(MainActivityFragment mainActivityFragment) {
        this.mainActivityFragment = mainActivityFragment;
    }

    private void pintarUsuarios(List<GithubUser> users){

        if (mainActivityFragment != null){
            mainActivityFragment.printUsers(users);
        }

    }

    public void launchDetail(GithubUser user){
        if (mainActivityFragment != null){
            mainActivityFragment.launchDetail(user);
        }

    }

    @Override
    public void setUsers(List<GithubUser> users) {
        pintarUsuarios(users);
    }

    @Override
    public void setDetailUser(GithubUserDetail user) {}
}
