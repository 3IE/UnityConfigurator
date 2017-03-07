package fr.iiie.unityconfigurator;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button myButton = (Button)  findViewById(R.id.button);
        final EditText editTextLocation = (EditText) findViewById(R.id.Location);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JSONObject applicationInformation = new JSONObject();
                try {
                    applicationInformation.put("Location", editTextLocation.getText());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Intent myIntent = new Intent();
                myIntent.setAction("fr.iiie.unityConfiguration");
                myIntent.putExtra(Intent.EXTRA_TEXT, applicationInformation.toString() );

                sendOrderedBroadcast(myIntent, null, new BroadcastReceiver() {

                    @Override
                    public void onReceive(Context context, Intent intent) {
                        Bundle results = getResultExtras(true);
                        Log.i("SendOrderedBroadc", "Final Result Receiver = " + results.getString("Breadcrumb", "nil"));
                    }
                }, null, Activity.RESULT_OK, null, null);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
