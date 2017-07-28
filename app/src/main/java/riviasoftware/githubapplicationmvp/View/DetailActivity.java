package riviasoftware.githubapplicationmvp.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import riviasoftware.githubapplicationmvp.Model.Data.GithubUser;
import riviasoftware.githubapplicationmvp.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        String username = getIntent().getStringExtra("username");
        Toast.makeText(this,username,Toast.LENGTH_LONG).show();
    }
}
