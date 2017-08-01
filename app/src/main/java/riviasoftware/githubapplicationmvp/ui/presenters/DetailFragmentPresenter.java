package riviasoftware.githubapplicationmvp.ui.presenters;

import java.util.List;

import javax.inject.Inject;

import riviasoftware.githubapplicationmvp.manager.NetworkManager;
import riviasoftware.githubapplicationmvp.model.GithubUser;
import riviasoftware.githubapplicationmvp.model.GithubUserDetail;
import riviasoftware.githubapplicationmvp.ui.view.DetailActivity;
import riviasoftware.githubapplicationmvp.ui.view.DetailFragment;


/**
 * Created by sergiolizanamontero on 28/7/17.
 */

public class DetailFragmentPresenter implements Presenter {


    GithubUserDetail user;
    private String name;


    NetworkManager networkManager;
    DetailFragment detailFragment;
    DetailActivity detailActivity;


    public DetailFragmentPresenter(NetworkManager networkManager) {
        this.networkManager = networkManager;
    }

    public void retrieveUser(){
        if(user != null){
            pintarDetalleUsuario(user);
        }else{
            networkManager.getUserDetail(this,name);
        }
    }

    public void setFragmentActivity(DetailFragment detailFragment) {
        this.detailFragment = detailFragment;
    }

    public void setActivity(DetailActivity detailActivity){
        this.detailActivity = detailActivity;
    }


    private void pintarDetalleUsuario(GithubUserDetail user){
        if (detailFragment != null){
            detailFragment.printUser(user);
        }
        if (detailActivity != null){
            detailActivity.printToolbarImage(user);
        }

    }

    @Override
    public void setUsers(List<GithubUser> users) {}

    @Override
    public void setDetailUser(GithubUserDetail user) {
        pintarDetalleUsuario(user);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


}
