package ru.mail.park.android.zinovyev.task01;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TableAdapter extends ArrayAdapter<Integer> {

    private Context mContext;

    TableAdapter(@NonNull Context context, int resource) {
        super(context, resource, new ArrayList<Integer>());
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView label = (TextView) convertView;

        if (convertView == null) {
            convertView = new TextView(this.mContext);
            label = (TextView) convertView;
        }

        Integer x = this.getItem(position);
        if (x != null) {
            label.setText(String.format("%s", x));
            label.setTextColor(x % 2 == 0 ? Color.RED : Color.BLUE);
        }

        return (convertView);
    }
}
