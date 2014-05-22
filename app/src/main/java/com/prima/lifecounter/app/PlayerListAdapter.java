package com.prima.lifecounter.app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Primoz on 18.5.2014.
 */

class ViewHolder {
    Button btnAddLife, btnRemLife;
    TextView txtPlayerName;
    TextView txtPlayerLife;
    Integer playerPosition;
}


public class PlayerListAdapter extends ArrayAdapter {
    Context c;
    ArrayList<Player> players;

    public PlayerListAdapter(Context context, ArrayList<Player> objects) {
        super(context, R.layout.player_row, objects);
        this.c = context;
        this.players = objects;
    }

    @Override
    public View getView(final int position, View cView, ViewGroup parent){
        final ViewHolder rowView;
        LayoutInflater inflater = (LayoutInflater)this.c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //if(cView == null || ((ViewHolder)cView.getTag()).playerPosition != position) {
            cView = inflater.inflate(R.layout.player_row, parent, false);
            rowView = new ViewHolder();
            //rowView = inflater.inflate(R.layout.player_row, parent, false);

            rowView.playerPosition = position;

            rowView.txtPlayerName = (TextView) cView.findViewById(R.id.txtPlayerName);
            rowView.txtPlayerLife = (TextView) cView.findViewById(R.id.txtPlayerLife);
            rowView.btnAddLife = (Button) cView.findViewById(R.id.btnAddLife);
            rowView.btnRemLife = (Button) cView.findViewById(R.id.btnRemLife);

            Player p = players.get(position);

            rowView.txtPlayerName.setText(p.getPlayerName());
            rowView.txtPlayerName.setTextColor(p.getPlayerColor());
            rowView.txtPlayerName.setOnLongClickListener(new View.OnLongClickListener() {
                 @Override
                 public boolean onLongClick(View view) {
                     //show picker dialog
                     AlertDialog.Builder builder = new AlertDialog.Builder(c);
                     builder.setTitle("Izberi barvo izmed sledečih:");
                     builder.setItems(Helpers.getColorNames(), new DialogInterface.OnClickListener() {
                         public void onClick(DialogInterface dialog, int wich) {
                             Player p = players.get(position);
                             p.changePlayerColorTo(wich);

                             rowView.txtPlayerName.setTextColor(p.getPlayerColor());

                             dialog.dismiss();

                         }
                     });
                     AlertDialog dialog = builder.create();
                     dialog.show();

                     return true;
                 }
            });


            rowView.txtPlayerLife.setText(p.getPlayerLife().toString());

            rowView.btnAddLife.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Player p = players.get(position);
                    p.addLife();
                    rowView.txtPlayerLife.setText(p.getPlayerLife().toString());
                }
            });


            rowView.btnRemLife.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Player p = players.get(position);
                    p.reduceLife();
                    rowView.txtPlayerLife.setText(p.getPlayerLife().toString());
                }
            });

            cView.setTag(rowView);
        //}
        //else{
        //    rowView = (ViewHolder)cView.getTag();
        //}

        return cView;
    }


}
