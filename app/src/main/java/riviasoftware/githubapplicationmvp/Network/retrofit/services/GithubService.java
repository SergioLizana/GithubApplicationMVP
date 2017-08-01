package riviasoftware.githubapplicationmvp.Network.retrofit.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import riviasoftware.githubapplicationmvp.model.GithubUser;
import riviasoftware.githubapplicationmvp.model.GithubUserDetail;


public interface GithubService {

    @GET("users")
    Call<List<GithubUser>> getUsers();

    @GET("users/{name}")
    Call<GithubUserDetail> getUserInfo(@Path("name") String userName);



}

