package ru.mail.park.android.zinovyev.task01;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    protected void log(String message) {
        StackTraceElement st = Thread.currentThread().getStackTrace()[3];
        message = st.getClassName() + "::" + st.getMethodName() + " -> " + message;

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
