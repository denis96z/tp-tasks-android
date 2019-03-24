package ru.mail.park.android.zinovyev.task01;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class NumberFragment extends Fragment {

    private Integer mNumber = 0;

    private Button mBackButton;
    private TextView mNumberView;

    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_number,
                container, false);

        this.mNumberView = view.findViewById(R.id.number_text_view);
        this.mNumberView.setText(String.format("%s", this.mNumber.toString()));
        this.mNumberView.setTextColor(this.mNumber % 2 == 0 ? Color.RED : Color.BLUE);

        this.mBackButton = view.findViewById(R.id.back_button);
        this.mBackButton.setOnClickListener(v -> {
            if (this.mListener != null) {
                mListener.onReturnButtonClicked();
            }
        });

        return view;
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

    void setNumber(Integer number) {
        this.mNumber = number;
    }

    public interface OnFragmentInteractionListener {
        void onReturnButtonClicked();
    }
}
