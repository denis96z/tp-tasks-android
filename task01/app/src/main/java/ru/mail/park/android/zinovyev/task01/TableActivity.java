package ru.mail.park.android.zinovyev.task01;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TableActivity extends BaseActivity implements
        TableFragment.OnFragmentInteractionListener,
        NumberFragment.OnFragmentInteractionListener {

    TableFragment mTableFragment = new TableFragment();
    NumberFragment mNumberFragment = new NumberFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        showTableFragment();
    }

    @Override
    public void onNumberSelected(Integer number) {
        showNumberFragment(number);
    }

    @Override
    public void onReturnButtonClicked() {
        showTableFragment();
    }

    private void showTableFragment() {
        showFragment(mTableFragment);
    }

    private void showNumberFragment(Integer number) {
        mNumberFragment = NumberFragment.newInstance(number);
        showFragment(mNumberFragment);
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_layout, fragment)
                .addToBackStack(null)
                .commit();
    }
}
