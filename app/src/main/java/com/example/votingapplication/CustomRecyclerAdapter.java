package com.example.votingapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {
    ArrayList<Vote> votes;
    public CustomRecyclerAdapter(ArrayList<Vote> votes){
        this.votes = votes;
    }

    @NonNull
    @Override
    public CustomRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = View.inflate(context, R.layout.vote_item, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerAdapter.ViewHolder holder, int position) {
        holder.txVoterName.setText(votes.get(position).getName());
        holder.txVotedFor.setText("Jumlah vote: " + String.valueOf(votes.get(position).getCandidate_ID()));
    }

    @Override
    public int getItemCount() {
        if (votes == null){
            return 0;
        }
        return votes.size();
    }

    //    add a viewholder for the recyclerview
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txVoterName;
        TextView txVotedFor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txVoterName = itemView.findViewById(R.id.tx_voter_name);
            txVotedFor = itemView.findViewById(R.id.tx_voted_for);
        }
    }
}
