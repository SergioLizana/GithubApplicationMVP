package riviasoftware.githubapplicationmvp.Network.retrofit.utils;

import riviasoftware.githubapplicationmvp.Network.retrofit.RetrofitClient;
import riviasoftware.githubapplicationmvp.Network.retrofit.services.GithubService;

public class ApiUtils {

    public static final String BASE_URL = "https://api.github.com/";


    public static GithubService getGithubService() {
        return RetrofitClient.getClient(BASE_URL).create(GithubService.class);
    }
}