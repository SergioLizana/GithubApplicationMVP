package riviasoftware.githubapplicationmvp.ui.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import riviasoftware.githubapplicationmvp.app.GithubApplication;
import riviasoftware.githubapplicationmvp.manager.NetworkManager;
import riviasoftware.githubapplicationmvp.manager.NetworkManagerImpl;
import riviasoftware.githubapplicationmvp.model.GithubUser;
import riviasoftware.githubapplicationmvp.model.GithubUserDetail;
import riviasoftware.githubapplicationmvp.ui.presenters.DetailFragmentPresenter;
import riviasoftware.githubapplicationmvp.R;

/**
 * Created by sergiolizanamontero on 27/7/17.
 */

public class DetailFragment extends Fragment {

    GithubUser user;
    @Inject
    DetailFragmentPresenter presenter;
    Unbinder unbinder;

    @BindView(R.id.company_name) TextView company;
    @BindView(R.id.location) TextView location;
    @BindView(R.id.email) TextView email;
    @BindView(R.id.blog) TextView blog;
    @BindView(R.id.user_type) TextView userType;
    @BindView(R.id.followers) TextView followers;
    @BindView(R.id.public_repos) TextView public_repos;
    @BindView(R.id.public_gist) TextView public_gist;
    @BindView(R.id.registration_date) TextView registration_date;
    @BindView(R.id.last_update) TextView last_update;
    @BindView(R.id.hireable) TextView hireable;
    @BindView(R.id.bio) TextView bio;



    public DetailFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            user = new GithubUser();
        } else {
            user = savedInstanceState.getParcelable("user");
        }
        ((GithubApplication)getActivity().getApplication()).getAppComponent().inject(this);
        presenter.setFragmentActivity(this);
        presenter.setActivity((DetailActivity) getActivity());
        presenter.setName(getActivity().getIntent().getStringExtra("username"));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        presenter.retrieveUser();

        return view;
    }

    public void printUser(GithubUserDetail user){

        company.setText(user.getCompany());
        location.setText(user.getLocation());
        email.setText((String) user.getEmail());
        blog.setText(user.getBlog());
        userType.setText(user.getType());
        followers.setText(String.valueOf(user.getFollowers()));
        public_repos.setText(String.valueOf(user.getPublicRepos()));
        public_gist.setText(String.valueOf(user.getPublicGists()));
        registration_date.setText(user.getCreatedAt());
        last_update.setText(user.getUpdatedAt());
        hireable.setText(String.valueOf(user.getHireable()));
        bio.setText((String) user.getBio());

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
