package riviasoftware.githubapplicationmvp.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import riviasoftware.githubapplicationmvp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_app);
        toolbar.setTitle("Agenda");
        setSupportActionBar(toolbar);
    }
}
