package crokky.com.fragmentstestuno;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    private static String TAG = "fdlActivity";
    private Button next, previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        setContentView(R.layout.activity_main);

        next = (Button) findViewById(R.id.bnext);
        previous = (Button) findViewById(R.id.bprev);
        next.setOnClickListener(this);
        previous.setOnClickListener(this);

        // by default, use the FirstFragment fragment
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment mainFragment = new FirstFragment();
        fragmentTransaction.add(R.id.fragment_container, mainFragment);
        fragmentTransaction.addToBackStack(null);

        // Commit the transaction
        fragmentTransaction.commit();


    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick");
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (v == next) {
            Log.d(TAG, "onClick: next");
            Fragment newFragment = new SecondFragment();
            //remove whatever fragment in the container and use the SecondFragment
            fragmentTransaction.replace(R.id.fragment_container, newFragment);
            fragmentTransaction.addToBackStack(null);

            // Commit the transaction
            fragmentTransaction.commit();

        } else if (v == previous) {
            Log.d(TAG, "onClick: previous");
            Fragment newFragment = new FirstFragment();
            //remove whatever fragment in the container and use the SecondFragment
            fragmentTransaction.replace(R.id.fragment_container, newFragment);
            fragmentTransaction.addToBackStack(null);

            // Commit the transaction
            fragmentTransaction.commit();
        }
    }
}
