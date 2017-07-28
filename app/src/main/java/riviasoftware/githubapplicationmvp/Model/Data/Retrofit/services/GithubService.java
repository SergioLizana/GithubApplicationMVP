package riviasoftware.githubapplicationmvp.Model.Data.Retrofit.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import riviasoftware.githubapplicationmvp.Model.Data.GithubUser;
import riviasoftware.githubapplicationmvp.Model.Data.GithubUserDetail;


public interface GithubService {

    @GET("users")
    Call<List<GithubUser>> getUsers();

    @GET("users/{name}")
    Call<GithubUserDetail> getUserInfo(@Path("name") String userName);



}

