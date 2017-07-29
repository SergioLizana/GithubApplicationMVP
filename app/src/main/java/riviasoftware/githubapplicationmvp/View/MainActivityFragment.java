package riviasoftware.githubapplicationmvp.View;

import android.content.Intent;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import riviasoftware.githubapplicationmvp.Manager.NetworkManager;
import riviasoftware.githubapplicationmvp.Manager.NetworkManagerImpl;
import riviasoftware.githubapplicationmvp.Model.Data.GithubUser;
import riviasoftware.githubapplicationmvp.Presenter.MainFragmentPresenter;
import riviasoftware.githubapplicationmvp.R;
import riviasoftware.githubapplicationmvp.View.adapters.ListUserAdapter;


public class MainActivityFragment extends Fragment {

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
        NetworkManager networkManager = new NetworkManagerImpl();
        presenter = new MainFragmentPresenter(networkManager);
        presenter.setMainFragmentActivity(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        adapter = new ListUserAdapter(getActivity(),users);
        mRecyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GithubUser user = (GithubUser) v.getTag();
                Intent intent = new Intent(getActivity().getApplicationContext(), DetailActivity.class);
                intent.putExtra("username",user.getLogin());
                startActivity(intent);

            }
        });
        presenter.retrieveUsers();

        return view;

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
