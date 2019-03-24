package ru.mail.park.android.zinovyev.task01;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class TableActivity extends BaseActivity
        implements TableFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        this.addFragment(R.id.fragment_layout, new TableFragment(), "tableFragment");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        System.out.println("onFragmentInteraction");
    }
}
