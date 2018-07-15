package org.iskconbangalore.hkmdonorstats;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EntryCount extends AppCompatActivity {
    Button btn4, btn3;
    EditText event,place,location,entryline,personname;
    private String mUsername, event1,place1,location1,entryline1,personname1,login;
    public static final String ANONYMOUS = "anonymous";
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_count);

        btn3 = (Button)findViewById(R.id.btnqr);
        event = (EditText)findViewById(R.id.event);
                place = (EditText)findViewById(R.id.place);
                location = (EditText)findViewById(R.id.location);
                entryline = (EditText)findViewById(R.id.entryline);
                personname = (EditText)findViewById(R.id.personname);
        bundle = getIntent().getExtras();
        login = bundle.getString("login");

        mUsername = ANONYMOUS;

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Scanqr.class);
                intent.putExtra("event", event.getText().toString());
                intent.putExtra("place", place.getText().toString());
                intent.putExtra("location", location.getText().toString());
                intent.putExtra("entryline", entryline.getText().toString());
                intent.putExtra("personname", personname.getText().toString());
                intent.putExtra("login", login);
                startActivity(intent);            }
        });


    }
}
