package com.example.macbook.professor_notes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecordListFragment extends Fragment {
    private RecyclerView mRecordRecyclerView;
    private RecordAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_record_list, container, false);

        mRecordRecyclerView = (RecyclerView) view;
        mRecordRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        RecordLab crimeLab = RecordLab.get(getActivity());
        List<Record> records = crimeLab.getRecords();
        
        if(mAdapter == null) {
            mAdapter = new RecordAdapter(records);
            mRecordRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setRecords(records);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class RecordHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private Record mRecord;
        private TextView mFirstNameTextView;
        private TextView mLastNameTextView;
        private TextView mDateTextView;

        private ImageView mDealtImageView;


        public RecordHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_record, parent, false));
            itemView.setOnClickListener(this);

            mFirstNameTextView = (TextView) itemView.findViewById(R.id.record_list_first);
            mLastNameTextView = (TextView) itemView.findViewById(R.id.record_list_last);
            mDateTextView = (TextView) itemView.findViewById(R.id.record_list_date);
            mDealtImageView = (ImageView) itemView.findViewById(R.id.record_list_dealt_with);
        }

        public void bind(Record record) {
            mRecord = record;
            mFirstNameTextView.setText(mRecord.getFirstName());
            mLastNameTextView.setText(mRecord.getLastName());
            mDateTextView.setText(mRecord.getDate().toString());
        }

        @Override
        public void onClick(View v) {
            Intent intent = RecordActivity.newIntent(getActivity(), mRecord.getId());
            startActivity(intent);
        }
    }

    private class RecordAdapter extends RecyclerView.Adapter<RecordHolder> {

        private List<Record> mRecords;

        public RecordAdapter(List<Record> records) {
            mRecords = records;
        }

        @NonNull
        @Override
        public RecordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new RecordHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull RecordHolder holder, int position) {
            Record record = mRecords.get(position);
            holder.bind(record);
        }

        @Override
        public int getItemCount() {
            return mRecords.size();
        }

        public void setRecords(List<Record> records) {
            mRecords = records;
        }
    }
}