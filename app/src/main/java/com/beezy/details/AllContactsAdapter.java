package com.beezy.details;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        ContactsViewHolder viewHolder = new ContactsViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ContactsViewHolder holder, int position) {
        Contact mContact = contactList.get(position);
        holder.tvContactNumber.setText(mContact.getContactNumber());
        holder.tvContactName.setText(mContact.getContactName());
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

        public ContactsViewHolder(View itemView) {
            super(itemView);
            ivImage = (ImageView) itemView.findViewById(R.id.ivContactImage);
            tvContactName = (TextView) itemView.findViewById(R.id.tvContactName);
            tvContactNumber = (TextView) itemView.findViewById(R.id.tvPhoneNumber);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
