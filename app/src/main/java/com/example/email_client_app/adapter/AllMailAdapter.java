package com.example.email_client_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.email_client_app.R;
import com.example.email_client_app.item.ItemEmail;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AllMailAdapter extends RecyclerView.Adapter<AllMailAdapter.MyHolder> {
    private Context context;
    private ArrayList<ItemEmail>emails;

    public AllMailAdapter(Context context, ArrayList<ItemEmail> emails) {
        this.context = context;
        this.emails = emails;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_mail_item,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.tvNameSent.setText(emails.get(position).getName());
        holder.tvSubject.setText(emails.get(position).getSubject());
        holder.tvDescription.setText(emails.get(position).getDescription());
        holder.tvTags.setText("Tags");
        holder.tvDateSent.setText(emails.get(position).getDate());
        Picasso.with(context).load(emails.get(position).getImgProfile()).into(holder.imgProfile);
    }

    @Override
    public int getItemCount() {
        return emails.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private ImageView imgProfile;
        private TextView tvNameSent;
        private TextView tvDateSent;
        private TextView tvSubject;
        private TextView tvDescription;
        private ImageView imgStar;
        private TextView tvTags;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.img_person_sent_allmail);
            tvNameSent = itemView.findViewById(R.id.tv_person_sent_allmail);
            tvDateSent = itemView.findViewById(R.id.tv_time_received_allmail);
            tvSubject = itemView.findViewById(R.id.tv_subject_sent_allmail);
            tvDescription = itemView.findViewById(R.id.tv_description_allmail);
            imgStar = itemView.findViewById(R.id.img_star_allmail);
            tvTags = itemView.findViewById(R.id.tv_tags_allmail);
        }
    }
}
