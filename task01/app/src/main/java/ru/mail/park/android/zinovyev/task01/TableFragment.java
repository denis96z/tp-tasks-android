package ru.mail.park.android.zinovyev.task01;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class TableFragment extends Fragment {

    private static final String CURRENT_MAX_NUMBER_VAR = "max_number";

    private static final int DEFAULT_MIN_NUMBER = 1;
    private static final int DEFAULT_MAX_NUMBER = 100;

    private static final int PORTRAIT_NUM_COLUMNS = 3;
    private static final int LANDSCAPE_NUM_COLUMNS = 4;

    private Integer mMaxNumber = DEFAULT_MAX_NUMBER;

    private GridView mTableView;
    private TableAdapter mTableAdapter;

    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_table, container, false);

        if (savedInstanceState == null) {
            this.mTableAdapter = new TableAdapter(view.getContext(),
                    android.R.layout.simple_list_item_1);
        } else {
            int max = savedInstanceState.getInt(TableFragment.CURRENT_MAX_NUMBER_VAR);
            if (max != 0) {
                mMaxNumber = max;
            }
        }

        Button addNumberBtn = view.findViewById(R.id.add_number_button);
        addNumberBtn.setOnClickListener(v -> this.mTableAdapter.add(++this.mMaxNumber));

        this.mTableView = view.findViewById(R.id.table_view);
        this.mTableView.setAdapter(this.mTableAdapter);

        this.mTableView.setOnItemClickListener((parent, v, position, id) -> {
            if (mListener != null) {
                mListener.onNumberSelected(mTableAdapter.getItem(position));
            }
        });

        this.addInitNumbers();
        this.changeNumColumns(getResources().getConfiguration().orientation);

        return view;
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.changeNumColumns(newConfig.orientation);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(TableFragment.CURRENT_MAX_NUMBER_VAR, mMaxNumber);
        super.onSaveInstanceState(outState);
    }


    private void addInitNumbers() {
        for (int i = TableFragment.DEFAULT_MIN_NUMBER; i <= mMaxNumber; ++i) {
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

    public interface OnFragmentInteractionListener {
        void onNumberSelected(Integer number);
    }
}
