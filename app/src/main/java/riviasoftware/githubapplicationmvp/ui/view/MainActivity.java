package riviasoftware.githubapplicationmvp.ui.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import riviasoftware.githubapplicationmvp.R;

public class MainActivity extends AppCompatActivity {
    Unbinder unbinder;

    @BindView(R.id.toolbar_app)
    android.support.v7.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_app);
        toolbar.setTitle("Agenda");
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
