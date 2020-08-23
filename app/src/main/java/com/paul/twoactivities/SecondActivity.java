package com.paul.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public final static String SENDBACKMESSAGE_KEY = "com.paul.twoactivities.extra.MESSAGEBACK"; //key für extra
    private EditText replyEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        replyEditText = findViewById(R.id.text_backmessage);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE); //der key aus main!
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
    }

  public void returnMessage(View view) {
        Intent replyIntent = new Intent();
        String replyBack = replyEditText.getText().toString();
        replyIntent.putExtra(SENDBACKMESSAGE_KEY, replyBack);
        setResult(RESULT_OK,replyIntent);
        finish();
    }

}
