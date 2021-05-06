package com.ualr.securitydefender.ui.notes;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ualr.securitydefender.R;

public class NoteViewHolder extends RecyclerView.ViewHolder{

    private TextView noteTitle;
    private TextView noteBody;

    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        this.noteTitle = itemView.findViewById(R.id.note_title);
        this.noteBody = itemView.findViewById(R.id.note_info);
    }

    public void setNoteBody(String noteBody) {
        this.noteBody.setText(noteBody);
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle.setText(noteTitle);
    }

    public TextView getNoteBody() {
        return noteBody;
    }

    public TextView getNoteTitle() {
        return noteTitle;
    }

}
