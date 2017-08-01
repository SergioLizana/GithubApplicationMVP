package riviasoftware.githubapplicationmvp.ui.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import riviasoftware.githubapplicationmvp.model.GithubUserDetail;
import riviasoftware.githubapplicationmvp.R;

public class DetailActivity extends AppCompatActivity {
    Unbinder unbind;

    @BindView(R.id.app_bar_image)
    ImageView userPhoto;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        unbind = ButterKnife.bind(this);
        toolbar.setTitle(getIntent().getStringExtra("username"));
        toolbar.setTitleTextColor(0xFFFFFFFF);

    }

    public void printToolbarImage(GithubUserDetail user){
        Glide.with(this).load(user.getAvatarUrl()).into(userPhoto);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbind.unbind();
    }
}
