package com.paul.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = MainActivity.class.getSimpleName();
    public final static String EXTRA_MESSAGE = "com.paul.twoactivities.extra.MESSAGE"; //key für extra
    private EditText mMessageEditText;
    public final static int TEXT_REQUEST = 1;
    private TextView replyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
        replyText = findViewById(R.id.textView_backmessage);
    }


    public void openSecondActv(View view) {
        Log.i(LOG_TAG, "Button clicked!");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString(); //value (string) für extra
        Log.i(LOG_TAG, message);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.SENDBACKMESSAGE_KEY);
                replyText.setText(reply);
            }
        }

    }

}
