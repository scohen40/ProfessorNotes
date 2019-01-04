package com.example.macbook.professor_notes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import java.util.UUID;

public class RecordActivity extends SingleFragmentActivity {

    private static final String EXTRA_RECORD_ID =
            "com.example.macbook.professor_notes.record_id";

    public static Intent newIntent(Context packageContext, UUID recordId) {
        Intent intent = new Intent(packageContext, RecordActivity.class);
        intent.putExtra(EXTRA_RECORD_ID, recordId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_record);
    }

    @Override
    protected Fragment createFragment() {
        UUID recordId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_RECORD_ID);
        return RecordFragment.newInstance(recordId);
    }
}

/*public class RecordActivity extends AppCompatActivity {
    *//**
     * Called when the activity is first created.
     *//*
    public static final String EXTRA_RECORD_ID = "com.example.professornotes.record_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new RecordFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

}*/
//

//
//    public static Intent newIntent(Context packageContext, UUID crimeID) {
//        Intent intent = new Intent(packageContext, RecordActivity.class);
//        intent.putExtra(EXTRA_RECORD_ID, crimeID);
//        return intent;
//    }
//
//    @Override
//    protected Fragment createFragment() {
//        return new RecordFragment();
//    }
//}

