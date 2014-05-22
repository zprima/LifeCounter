package com.prima.lifecounter.app;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

/**
 * Created by Primoz on 18.5.2014.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class PlayerColorPickerFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.getActivity());
        builder.setMessage("Izberi barvo izmed sledečih:");
        builder.setItems(Helpers.getColorNames(),new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int position) {

            }
        });
        return builder.create();
    }
}
