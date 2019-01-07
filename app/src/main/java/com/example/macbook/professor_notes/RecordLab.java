package com.example.macbook.professor_notes;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RecordLab {
    private static RecordLab sRecordLab;

    private List<Record> mRecords;

    public static RecordLab get(Context context) {
        if(sRecordLab == null) {
            sRecordLab = new RecordLab(context);
        }
        return sRecordLab;
    }

    public RecordLab(Context context) { //THIS WILL NEED TO CHANGE TO TAKE INFO ONLY FROM USER INPUT
        mRecords = new ArrayList<>();
    }

    public void addRecord(Record record) {
        mRecords.add(record);
    }

    public List<Record> getRecords() {
        return mRecords;
    }

    public Record getCrime(UUID id) {
        for(Record record : mRecords) {
            if(record.getId().equals(id)) {
                return record;
            }
        }

        return null;
    }
}

