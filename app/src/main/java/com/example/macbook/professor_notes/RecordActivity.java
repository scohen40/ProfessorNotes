package com.example.macbook.professor_notes;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class RecordActivity extends SingleFragmentActivity {

    public static final String EXTRA_RECORD_ID = "com.example.ciminalintent.crime_id";

    public static Intent newIntent(Context packageContext, UUID crimeID) {
        Intent intent = new Intent(packageContext, RecordActivity.class);
        intent.putExtra(EXTRA_RECORD_ID, crimeID);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new RecordFragment();
    }
}
