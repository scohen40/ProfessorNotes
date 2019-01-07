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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_record_list, container, false);

        mRecordRecyclerView = (RecyclerView)view;
        mRecordRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return new View();
    }

    private void updateUI() {
        RecordLab recordLab = RecordLab.get(getActivity());
        List<Record> records = recordLab.getRecords();

        mAdapter = new RecordAdapter(records);
        mRecordRecyclerView.setAdapter(mAdapter);
    }

    private class RecordAdapter extends RecyclerView.Adapter<RecordHolder> {

        private List<Record> mRecords;

        public RecordAdapter(List<Record> records) {
            mRecords = records;
        }

        @NonNull
        @Override
        public RecordHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new RecordHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(RecordHolder holder, int position) {
            Record record = mRecords.get(position);
            holder.bind(record);
        }

        @Override
        public int getItemCount() {
            return mRecords.size();
        }
    }

    private class RecordHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        private TextView mTitleTextView;
        private TextView mDateTextView;

        private ImageView mSolvedImageView;

        private Record mRecord;

        public RecordHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_record, parent, false));
            itemView.setOnClickListener(this);

            mTitleTextView = (TextView) itemView.findViewById(R.id.record_list_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.record_list_date);
            mSolvedImageView = (ImageView) itemView.findViewById(R.id.record_list_dealt_with);
        }

        public void bind(Record Record) {
            mRecord = Record;
            mTitleTextView.setText(mRecord.getFirstName() + mRecord.getLastName());
            mDateTextView.setText(mRecord.getDate().toString());
            mSolvedImageView.setVisibility(Record.isDealtWith() ? View.VISIBLE : View.GONE);
        }

        @Override
        public void onClick(View view) {
            Intent intent = RecordActivity.newIntent(getActivity(), mRecord.getId());
            startActivity(intent);
        }
    }
}

