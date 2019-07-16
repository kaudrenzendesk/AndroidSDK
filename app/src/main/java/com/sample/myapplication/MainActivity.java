package com.sample.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import zendesk.core.AnonymousIdentity;
import zendesk.core.Identity;
import zendesk.core.Zendesk;
import zendesk.support.Support;
import zendesk.support.guide.HelpCenterActivity;

public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        Button helpCenterButton = (Button) findViewById(R.id.help_button);
        helpCenterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                HelpCenterActivity.builder()
                        .show(MainActivity.this);
            }
        });

        Zendesk.INSTANCE.init(this, "https://z3nklara123.zendesk.com",
                "f06543533e8f7eb349c75c6bcbfbd9e4ba1decd747d70439",
                "mobile_sdk_client_f3ee20ea28125e220bc6");

        Identity identity = new AnonymousIdentity();
        Zendesk.INSTANCE.setIdentity(identity);


        Support.INSTANCE.init(Zendesk.INSTANCE);

    }

    ;
}
