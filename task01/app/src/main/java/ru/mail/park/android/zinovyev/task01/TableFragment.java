package ru.mail.park.android.zinovyev.task01;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class TableFragment extends Fragment {

    private GridView tableView;
    private TableAdapter tableAdapter;

    private static final int INIT_N = 10;

    private static final int PORTRAIT_NUM_COLUMNS = 2;
    private static final int LANDSCAPE_NUM_COLUMNS = 3;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_table,
                container, false);

        if (savedInstanceState == null) {
            Toast.makeText(this.getContext(), "onCreateView()", Toast.LENGTH_SHORT).show();

            this.tableAdapter = new TableAdapter(view.getContext(),
                    android.R.layout.simple_list_item_1);

            this.tableView = view.findViewById(R.id.tableView);
            this.tableView.setAdapter(this.tableAdapter);

            this.addInitNumbers();
            this.changeNumColumns(getResources().getConfiguration().orientation);
        }

        return view;
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.changeNumColumns(newConfig.orientation);
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    private void addInitNumbers() {
        for (int i = 0; i < TableFragment.INIT_N; ++i) {
            this.tableAdapter.add(i);
        }
    }

    private void changeNumColumns(int orientation) {
        switch (orientation) {
            case Configuration.ORIENTATION_PORTRAIT:
                this.tableView.setNumColumns(TableFragment.PORTRAIT_NUM_COLUMNS);
                break;

            case Configuration.ORIENTATION_LANDSCAPE:
                this.tableView.setNumColumns(TableFragment.LANDSCAPE_NUM_COLUMNS);
                break;
        }
    }
}
