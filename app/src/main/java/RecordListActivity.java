import android.support.v4.app.Fragment;

import com.example.macbook.professor_notes.RecordListFragment;
import com.example.macbook.professor_notes.SingleFragmentActivity;

public class RecordListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new RecordListFragment();
    }
}
