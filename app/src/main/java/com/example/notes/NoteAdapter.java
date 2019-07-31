package com.example.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    private Context context;
    private List<ModelNote> listNote;   //create list for recycleview

    public NoteAdapter(Context context) {
        this.context = context;
        listNote = new ArrayList<>();
    }

    public void setListNote(List<ModelNote> listNote) {
        this.listNote = listNote;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup, false);    //'layoutinflatter' is used to flip item to top of the layer
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {        //insert data into item list
        ModelNote noteModel = listNote.get(i);

        final int id = noteModel.getId();   //final for constant data
        String title = noteModel.getJudul();
        String desc = noteModel.getDesc();
        //String date = noteModel.getNoteDate();

        viewHolder.tv_Title.setText(title);
        viewHolder.tv_Desc.setText(desc);
    }

    @Override
    public int getItemCount() {
        return listNote.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView tv_Title, tv_Desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            tv_Title = itemView.findViewById(R.id.tvTitle);
            tv_Desc = itemView.findViewById(R.id.tvDesc);
        }
    }


}
