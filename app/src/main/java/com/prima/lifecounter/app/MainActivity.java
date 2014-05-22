package com.prima.lifecounter.app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    public final static String EXTRA_DATA = "com.prima.lifecounter.EXTRA_DATA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et1 = (EditText)findViewById(R.id.editText);
        EditText et2 = (EditText)findViewById(R.id.editText2);

        et1.setText("2");
        et2.setText("20");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public AlertDialog CreateAlertDialogWithMessage(String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(msg);
        builder.setTitle("Opozorilo");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){

            }
        });
        AlertDialog dialog = builder.create();
        return dialog;
    }

    public void startCounting(View view){
        Intent intent = new Intent(this, LifeActivity.class);
        EditText et1 = (EditText)findViewById(R.id.editText);
        EditText et2 = (EditText)findViewById(R.id.editText2);

        String stringPlayers = et1.getText().toString();
        String stringLife = et2.getText().toString();

        if(stringPlayers.equals("")){
            AlertDialog dialog = CreateAlertDialogWithMessage("Število igralcev ne sme biti prazno!");
            dialog.show();
            return;
        }

        Integer numPlayers = Integer.parseInt(stringPlayers);
        if( numPlayers > 10 || numPlayers < 1){
            AlertDialog dialog = CreateAlertDialogWithMessage("Število igralcev ne sme presežti 10 in ne sme biti manjše od 1");
            dialog.show();
            return;
        }

        if(stringLife.equals("")){
            AlertDialog dialog = CreateAlertDialogWithMessage("Število življenja ne sme biti prazno!");
            dialog.show();
            return;
        }

        Integer numLife = Integer.parseInt(stringLife);
        if(numLife > 10000 || numLife < 0){
            AlertDialog dialog = CreateAlertDialogWithMessage("Število življenja more bit v obsegu od 0 do 100000.");
            dialog.show();
            return;
        }

        StartContainer sc = new StartContainer(numLife, numPlayers);
        intent.putExtra(EXTRA_DATA, sc);
        startActivity(intent);

    }
}
