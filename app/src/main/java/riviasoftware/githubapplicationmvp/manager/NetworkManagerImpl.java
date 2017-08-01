package riviasoftware.githubapplicationmvp.manager;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import riviasoftware.githubapplicationmvp.model.GithubUser;
import riviasoftware.githubapplicationmvp.model.GithubUserDetail;
import riviasoftware.githubapplicationmvp.Network.retrofit.services.GithubService;
import riviasoftware.githubapplicationmvp.Network.retrofit.utils.ApiUtils;
import riviasoftware.githubapplicationmvp.ui.presenters.Presenter;

/**
 * Created by sergiolizanamontero on 26/7/17.
 */

public class NetworkManagerImpl implements NetworkManager {
    GithubService githubService;

    public NetworkManagerImpl() {
        githubService = ApiUtils.getGithubService();
    }

    @Override
    public void getUsers(final Presenter presenter) {
        Call<List<GithubUser>> response = githubService.getUsers();
        response.enqueue(new Callback<List<GithubUser>>() {
            @Override
            public void onResponse(Call<List<GithubUser>> call, Response<List<GithubUser>> response) {
                if (response.isSuccessful()) {
                    presenter.setUsers(response.body());
                } else {
                    int statusCode = response.code();
                    Log.d("MainActivity", "error loading from API status code: " + statusCode);
                }
            }
            @Override
            public void onFailure(Call<List<GithubUser>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void getUserDetail(final Presenter presenter, String name) {
        Call<GithubUserDetail> response = githubService.getUserInfo(name);
        response.enqueue(new Callback<GithubUserDetail>() {
            @Override
            public void onResponse(Call<GithubUserDetail> call, Response<GithubUserDetail> response) {
                if (response.isSuccessful()) {
                    presenter.setDetailUser(response.body());

                } else {
                    int statusCode = response.code();
                    Log.d("Detail", "error loading from API status code: " + statusCode);
                }
            }

            @Override
            public void onFailure(Call<GithubUserDetail> call, Throwable t) {

            }
        });
    }
}
