package riviasoftware.githubapplicationmvp.Presenter;

import java.util.List;

import riviasoftware.githubapplicationmvp.Model.Data.GithubUser;

/**
 * Created by sergiolizanamontero on 26/7/17.
 */

public interface Presenter {
    void setUsers(List<GithubUser> users);
}
