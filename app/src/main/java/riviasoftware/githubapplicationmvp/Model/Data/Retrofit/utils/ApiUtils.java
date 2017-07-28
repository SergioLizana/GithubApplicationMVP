package riviasoftware.githubapplicationmvp.Model.Data.Retrofit.utils;

import riviasoftware.githubapplicationmvp.Model.Data.Retrofit.RetrofitClient;
import riviasoftware.githubapplicationmvp.Model.Data.Retrofit.services.GithubService;

public class ApiUtils {

    public static final String BASE_URL = "https://api.github.com/";


    public static GithubService getGithubService() {
        return RetrofitClient.getClient(BASE_URL).create(GithubService.class);
    }
}