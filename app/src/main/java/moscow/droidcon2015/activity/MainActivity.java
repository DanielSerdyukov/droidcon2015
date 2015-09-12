package moscow.droidcon2015.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import moscow.droidcon2015.R;
import moscow.droidcon2015.processor.BindView;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fab)
    private FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mFab == null) {
            throw new RuntimeException("BindView not working!!!");
        }
    }

}
