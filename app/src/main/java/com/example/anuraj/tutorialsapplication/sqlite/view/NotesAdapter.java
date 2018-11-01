package com.example.anuraj.tutorialsapplication.sqlite.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anuraj.tutorialsapplication.R;
import com.example.anuraj.tutorialsapplication.sqlite.NoteSelectedListener;
import com.example.anuraj.tutorialsapplication.sqlite.database.model.Note;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by AnuRaj on 11/1/2018.
 */

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    private List<Note> notesList;
    private NoteSelectedListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView note;
        public TextView dot;
        public TextView timestamp;

        public MyViewHolder(View view) {
            super(view);
            note = view.findViewById(R.id.note);
            dot = view.findViewById(R.id.dot);
            timestamp = view.findViewById(R.id.timestamp);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onNoteSelected(getAdapterPosition());
                }
            });
        }
    }


    public NotesAdapter(List<Note> notesList, NoteSelectedListener listener) {
        this.notesList = notesList;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Note note = notesList.get(position);

        holder.note.setText(note.getNote());

        // Displaying dot from HTML character code
        holder.dot.setText(Html.fromHtml("&#8226;"));

        // Formatting and displaying timestamp
        holder.timestamp.setText(formatDate(note.getTimestamp()));

    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    /**
     * Formatting timestamp to `MMM d` format
     * Input: 2018-02-21 00:15:42
     * Output: Feb 21
     */
    private String formatDate(String dateStr) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("MMM d");
            return fmtOut.format(date);
        } catch (ParseException e) {

        }

        return "";
    }
}
