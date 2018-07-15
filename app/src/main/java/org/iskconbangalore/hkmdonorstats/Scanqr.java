package org.iskconbangalore.hkmdonorstats;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.google.firebase.database.FirebaseDatabase.getInstance;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Scanqr extends AppCompatActivity {
    EditText fid1;
    Button btn4, btn3;
    String idno,event,place,location,entryline,personname, login;
    Bundle bundle;
    private   FirebaseDatabase database1;
    private DatabaseReference myRef;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanqr);
        bundle = getIntent().getExtras();
        login = bundle.getString("login");
        event = bundle.getString("event");
                place = bundle.getString("place");
                location = bundle.getString("location");
                entryline = bundle.getString("entryline");
                personname = bundle.getString("personname");

        btn4 = (Button)findViewById(R.id.btnqrs);

        btn3 = (Button)findViewById(R.id.btn3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Hare Krishna!", Toast.LENGTH_SHORT).show();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");

                myRef.setValue("Hello, World from test 3!");


//                database1 = FirebaseDatabase.getInstance();
//            myRef = database1.getReference();
//                myRef.setValue("Hello, World!");
        }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                    intent.putExtra("SCAN_MODE", "QR_CODE_MODE"); // "PRODUCT_MODE for bar codes

                    startActivityForResult(intent, 0);

                } catch (Exception e) {

                    Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
                    Intent marketIntent = new Intent(Intent.ACTION_VIEW,marketUri);
                    startActivity(marketIntent);

                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {

            if (resultCode == RESULT_OK) {
                idno = data.getStringExtra("SCAN_RESULT");
                Toast.makeText(getApplicationContext(), idno, Toast.LENGTH_SHORT).show();
                getDataForID(idno);
            }
            if(resultCode == RESULT_CANCELED){
                //handle cancel
            }
        }
    }

    private void getDataForID(String idnos){
        fid1 = (EditText)findViewById(R.id.fid1);

        fid1.setText(idno);
//        myRef = FirebaseDatabase.getInstance().getReference().child("A");
//        myRef.child(idno).child("Name").setValue("name");

    }


}
