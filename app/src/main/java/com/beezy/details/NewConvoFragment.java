package com.beezy.details;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


public class NewConvoFragment extends DialogFragment {

    long id;
    String name;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Bundle bundle = getArguments();

        if (bundle != null) {
            id = bundle.getLong("ID", -1);
            name = bundle.getString("Name");
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add Conversation");
        builder.setMessage(name);
        builder.setView(R.layout.add_conversation);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText edit = (EditText)((AlertDialog) dialog).findViewById(R.id.conversation);
                String conversation = edit.getText().toString();
                //Toast.makeText(getContext(),edit.getText().toString(), Toast.LENGTH_SHORT).show();
                ConvoDatabase.ConvoDbHelper dbHelper = new ConvoDatabase.ConvoDbHelper(getContext());
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(ConvoDatabase.ConvoEntry.COLUMN_NAME_CONTACT_ID, id);
                values.put(ConvoDatabase.ConvoEntry.COLUMN_NAME_CONVO, conversation);

                if(conversation != "") {
                    long newRowId = db.insert(ConvoDatabase.ConvoEntry.TABLE_NAME, null, values);

                }
                dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });

        return builder.create();
    }

}
