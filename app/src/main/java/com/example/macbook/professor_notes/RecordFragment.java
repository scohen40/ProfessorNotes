package com.example.macbook.professor_notes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

public class RecordFragment extends Fragment {
    private Record mRecord;
    private EditText mFirstNameField;
    private EditText mLastNameField;
    private EditText mCourseField;
    private Button mDateButton;
    private CheckBox mDealtWithCheckBox;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID crimeID = (UUID) getActivity().getIntent().getSerializableExtra(RecordActivity.EXTRA_RECORD_ID);
        mRecord = RecordLab.get(getActivity()).getCrime(crimeID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_record, container, false);

        mFirstNameField = (EditText) v.findViewById(R.id.first_name_field);
        mFirstNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.setFirstName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mLastNameField = (EditText) v.findViewById(R.id.last_name_field);
        mLastNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.setLastName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mCourseField = (EditText) v.findViewById(R.id.course_field);
        mCourseField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRecord.setCourse(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDateButton = (Button) v.findViewById(R.id.date_field);
        mDateButton.setText(mRecord.getDate().toString()); //change later to react to onClick listener
        mDateButton.setEnabled(false);

        mDealtWithCheckBox = (CheckBox) v.findViewById(R.id.dealt_with_checkbox);
        mDealtWithCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mRecord.setDealtWith(isChecked);
            }
        });

        return v;
    }
}
