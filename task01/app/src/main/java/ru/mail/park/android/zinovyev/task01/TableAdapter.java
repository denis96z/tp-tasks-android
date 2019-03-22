package ru.mail.park.android.zinovyev.task01;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TableAdapter extends ArrayAdapter<Integer> {

    private static final ArrayList<Integer> numbers = new ArrayList<>();
    private Context context;

    TableAdapter(@NonNull Context context, int resource) {
        super(context, resource, TableAdapter.numbers);
        this.context = context;
    }

    public static void addNumber(Integer number) {
        TableAdapter.numbers.add(number);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView label = (TextView) convertView;

        if (convertView == null) {
            convertView = new TextView(this.context);
            label = (TextView) convertView;
        }

        label.setText(String.format("%s", TableAdapter.numbers.get(position)));
        return (convertView);
    }
}
