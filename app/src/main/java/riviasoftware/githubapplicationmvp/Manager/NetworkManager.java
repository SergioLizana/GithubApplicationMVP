package riviasoftware.githubapplicationmvp.Manager;

import java.util.List;

import riviasoftware.githubapplicationmvp.Model.Data.GithubUser;
import riviasoftware.githubapplicationmvp.Model.Data.GithubUserDetail;
import riviasoftware.githubapplicationmvp.Presenter.Presenter;

/**
 * Created by sergiolizanamontero on 26/7/17.
 */

public interface NetworkManager {
    void getUsers(Presenter presenter);
    void getUserDetail(Presenter presenter, String userName);
}
