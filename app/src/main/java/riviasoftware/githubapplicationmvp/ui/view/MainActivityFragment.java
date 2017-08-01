package riviasoftware.githubapplicationmvp.ui.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import riviasoftware.githubapplicationmvp.app.GithubApplication;
import riviasoftware.githubapplicationmvp.databinding.UserListBinding;
import riviasoftware.githubapplicationmvp.manager.NetworkManager;
import riviasoftware.githubapplicationmvp.manager.NetworkManagerImpl;
import riviasoftware.githubapplicationmvp.model.GithubUser;
import riviasoftware.githubapplicationmvp.ui.presenters.MainFragmentPresenter;
import riviasoftware.githubapplicationmvp.R;
import riviasoftware.githubapplicationmvp.ui.view.adapters.ListUserAdapter;


public class MainActivityFragment extends Fragment {

    @Inject
    MainFragmentPresenter presenter;

    ListUserAdapter adapter;
    ArrayList<GithubUser> users;
    Unbinder unbinder;
    @BindView(R.id.recyclerciew_list)
    RecyclerView mRecyclerView;


    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            users = new ArrayList<GithubUser>();
        } else {
            users = savedInstanceState.getParcelableArrayList("users");
        }
        ((GithubApplication)getActivity().getApplication()).getAppComponent().inject(this);
        presenter.setMainFragmentActivity(this);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        unbinder = ButterKnife.bind(this, view);
        adapter = new ListUserAdapter(getActivity(),users,presenter);
        mRecyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        presenter.retrieveUsers();

        return view;

    }

    public void launchDetail(GithubUser user){
        Intent intent = new Intent(getActivity().getApplicationContext(), DetailActivity.class);
        intent.putExtra("username",user.getLogin());
        startActivity(intent);
    }

    public void printUsers(List<GithubUser> users){
        adapter.updateMovies(users);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
