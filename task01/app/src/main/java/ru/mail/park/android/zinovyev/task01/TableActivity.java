package ru.mail.park.android.zinovyev.task01;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class TableActivity extends BaseActivity
        implements TableFragment.OnFragmentInteractionListener {

    Fragment tableFragment = new TableFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        FragmentManager fm = this.getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.fragment_layout,
                this.tableFragment).addToBackStack(null).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        System.out.println("onFragmentInteraction");
    }
}
