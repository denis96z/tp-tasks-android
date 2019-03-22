package ru.mail.park.android.zinovyev.task01;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;

public class TableActivity extends Activity {

    private GridView tableView;
    private TableAdapter tableAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        this.tableAdapter = new TableAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1);

        this.tableView = findViewById(R.id.tableView);
        this.tableView.setAdapter(this.tableAdapter);
    }
}
