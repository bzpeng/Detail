package com.beezy.details;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.attr.fragment;

public class AllConvoAdapter extends RecyclerView.Adapter<AllConvoAdapter.ContactsViewHolder> {

    private List<Contact> contactList;
    private Context mContext;
    FragmentManager fm;

    Map<Long, List<String>> map = new HashMap<>();


    private void pullAllConvos() {
        ConvoDatabase.ConvoDbHelper helper = new ConvoDatabase.ConvoDbHelper(mContext);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.query(ConvoDatabase.ConvoEntry.TABLE_NAME, null, null, null, null, null, null);
        while(cursor.moveToNext()) {
            long mId = cursor.getLong(cursor.getColumnIndex(ConvoDatabase.ConvoEntry.COLUMN_NAME_CONTACT_ID));
            String convo = cursor.getString(cursor.getColumnIndex(ConvoDatabase.ConvoEntry.COLUMN_NAME_CONVO));

            if(map.get(mId)==null) {
                map.put(mId, new ArrayList<String>());
            }
            map.get(mId).add(convo);
        }
    }

    public AllConvoAdapter(List<Contact> contactList, Context mContext, FragmentManager fm) {
        this.fm = fm;
        this.contactList = contactList;
        this.mContext = mContext;
        pullAllConvos();
    }
    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.conversation, parent, false);
        return new ContactsViewHolder(v, mContext);
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, int position) {
        final Contact mContact = contactList.get(position);
        holder.convoName.setText(mContact.getContactName());

        if(map.get(mContact.getContactId()) != null) {
            holder.convoContent.setText(map.get(mContact.getContactId()).get(0));
        }
    }

    @Override
    public int getItemCount() {
        if(contactList == null) {
            return 0;
        }
        return contactList.size();
    }

    public static class ContactsViewHolder extends RecyclerView.ViewHolder {
        TextView convoName;
        TextView convoContent;

        View view;

        public ContactsViewHolder(View itemView, final Context context) {
            super(itemView);
            convoName = (TextView) itemView.findViewById(R.id.convoName);
            convoContent = (TextView) itemView.findViewById(R.id.convoContent);
            this.view = itemView;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
