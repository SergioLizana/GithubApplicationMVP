package riviasoftware.githubapplicationmvp.manager;

import riviasoftware.githubapplicationmvp.ui.presenters.Presenter;

/**
 * Created by sergiolizanamontero on 26/7/17.
 */

public interface NetworkManager {
    void getUsers(Presenter presenter);
    void getUserDetail(Presenter presenter, String userName);
}
