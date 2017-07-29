package riviasoftware.githubapplicationmvp.Presenter;

import java.util.List;

import riviasoftware.githubapplicationmvp.Manager.NetworkManager;
import riviasoftware.githubapplicationmvp.Model.Data.GithubUser;
import riviasoftware.githubapplicationmvp.Model.Data.GithubUserDetail;
import riviasoftware.githubapplicationmvp.View.MainActivity;
import riviasoftware.githubapplicationmvp.View.MainActivityFragment;

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


    @Override
    public void setUsers(List<GithubUser> users) {
        pintarUsuarios(users);
    }

    @Override
    public void setDetailUser(GithubUserDetail user) {}
}
