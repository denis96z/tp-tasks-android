package ru.mail.park.android.zinovyev.task01;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class TableFragment extends Fragment {

    private GridView tableView;
    private TableAdapter tableAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_table, container, false);

        this.tableAdapter = new TableAdapter(view.getContext(),
                android.R.layout.simple_list_item_1);

        this.tableView = view.findViewById(R.id.tableView);
        this.tableView.setAdapter(this.tableAdapter);

        for (int i = 0; i < 100; i++) {
            TableAdapter.addNumber(i);
        }

        return view;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
