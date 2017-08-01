package riviasoftware.githubapplicationmvp.ui.presenters;

import java.util.List;

import riviasoftware.githubapplicationmvp.model.GithubUser;
import riviasoftware.githubapplicationmvp.model.GithubUserDetail;

/**
 * Created by sergiolizanamontero on 26/7/17.
 */

public interface Presenter {
    void setUsers(List<GithubUser> users);
    void setDetailUser(GithubUserDetail user);
}
