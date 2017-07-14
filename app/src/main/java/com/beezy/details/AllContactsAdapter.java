package com.beezy.details;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.util.List;

public class AllContactsAdapter extends RecyclerView.Adapter<AllContactsAdapter.ContactsViewHolder> {

    private List<Contact> contactList;
    private Context mContext;

    public AllContactsAdapter(List<Contact> contactList, Context mContext) {
        this.contactList = contactList;
        this.mContext = mContext;
    }
    @Override
    public ContactsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.contacts_list_item, parent, false);
        return new ContactsViewHolder(v, mContext);
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, int position) {
        final Contact mContact = contactList.get(position);
        holder.tvContactNumber.setText(mContact.getContactNumber());
        holder.tvContactName.setText(mContact.getContactName());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Uri uri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, mContact.getContactId());
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                mContext.startActivity(intent);
                LinearLayout mlinearLayout = (LinearLayout) v.findViewById(R.id.bottomLL);
                mlinearLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(contactList == null) {
            return 0;
        }
        return contactList.size();
    }

    public static class ContactsViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvContactName;
        TextView tvContactNumber;
        View view;

        public ContactsViewHolder(View itemView, final Context context) {
            super(itemView);
            ivImage = (ImageView) itemView.findViewById(R.id.ivContactImage);
            tvContactName = (TextView) itemView.findViewById(R.id.tvContactName);
            tvContactNumber = (TextView) itemView.findViewById(R.id.tvPhoneNumber);
            this.view = itemView;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
