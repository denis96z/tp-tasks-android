package ru.mail.park.android.zinovyev.task01;

import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class TableFragment extends Fragment {

    private GridView mTableView;
    private TableAdapter mTableAdapter;

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    private static final int PORTRAIT_NUM_COLUMNS = 3;
    private static final int LANDSCAPE_NUM_COLUMNS = 4;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_table,
                container, false);

        this.mTableAdapter = new TableAdapter(view.getContext(),
                android.R.layout.simple_list_item_1);

        this.mTableView = view.findViewById(R.id.tableView);
        this.mTableView.setAdapter(this.mTableAdapter);

        this.addInitNumbers();
        this.changeNumColumns(getResources().getConfiguration().orientation);

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
        for (int i = TableFragment.MIN_NUMBER; i <= TableFragment.MAX_NUMBER; ++i) {
            this.mTableAdapter.add(i);
        }
    }

    private void changeNumColumns(int orientation) {
        switch (orientation) {
            case Configuration.ORIENTATION_PORTRAIT:
                this.mTableView.setNumColumns(TableFragment.PORTRAIT_NUM_COLUMNS);
                break;

            case Configuration.ORIENTATION_LANDSCAPE:
                this.mTableView.setNumColumns(TableFragment.LANDSCAPE_NUM_COLUMNS);
                break;
        }
    }
}
