package com.example.Sagutdinov721;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        final TextView textFind=findViewById(R.id.textFind);
        Button btnFind=findViewById(R.id.buttonFind);

        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                StringBuilder uriBuilder=new StringBuilder();
                uriBuilder.append("geo:");
                char[] tempString=textFind.getText().toString().toCharArray();
                for(int i=0;i<tempString.length;i++){
                    if(Character.isLetter(tempString[i])){
                        uriBuilder.append("?q=");
                        break;
                    }
                }
                uriBuilder.append(textFind.getText().toString());
                intent.setData(Uri.parse(uriBuilder.toString()));
                startActivity(intent);
            }
        });
    }
}
