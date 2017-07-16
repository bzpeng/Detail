package com.beezy.details;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
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

import java.net.URI;
import java.util.List;

import static android.R.attr.fragment;

public class AllContactsAdapter extends RecyclerView.Adapter<AllContactsAdapter.ContactsViewHolder> {

    private List<Contact> contactList;
    private Context mContext;
    private LinearLayout currentlyVisible;
    FragmentManager fm;

    public AllContactsAdapter(List<Contact> contactList, Context mContext, FragmentManager fm) {
        this.fm = fm;
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
        holder.tvContactName.setText(mContact.getContactName());
        holder.btContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, mContact.getContactId());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                mContext.startActivity(intent);
            }
        });

        holder.btAddConvo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ActivityFragment.class);
                intent.putExtra("Name", mContact.getContactName());
                intent.putExtra("ID", mContact.getContactId());

                Activity activity = (Activity) mContext;
                NewConvoFragment fragment = new NewConvoFragment();
                fragment.setArguments(intent.getExtras());
                fragment.show(fm, "newContact");
            }
        });

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout mlinearLayout = (LinearLayout) v.findViewById(R.id.bottomLL);

                if(mlinearLayout.getVisibility() == View.VISIBLE) {
                    currentlyVisible.setVisibility(View.GONE);
                    currentlyVisible = null;
                }
                mlinearLayout.setVisibility(View.VISIBLE);
                if(currentlyVisible != null) {
                    currentlyVisible.setVisibility(View.GONE);
                }
                currentlyVisible = mlinearLayout;
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
        Button btContact;
        Button btAddConvo;

        View view;

        public ContactsViewHolder(View itemView, final Context context) {
            super(itemView);
            ivImage = (ImageView) itemView.findViewById(R.id.ivContactImage);
            tvContactName = (TextView) itemView.findViewById(R.id.tvContactName);
            btContact = (Button) itemView.findViewById(R.id.viewContactButton);
            btAddConvo = (Button) itemView.findViewById(R.id.addConvoButton);
            this.view = itemView;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
