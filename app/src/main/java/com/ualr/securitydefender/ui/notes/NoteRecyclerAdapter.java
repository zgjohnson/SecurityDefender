package com.ualr.securitydefender.ui.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ualr.securitydefender.R;
import com.ualr.securitydefender.data.NoteEntity;

import java.util.List;

public class NoteRecyclerAdapter  extends RecyclerView.Adapter {
    private List<NoteEntity> noteEntityList;
    private Context context;

    // TODO. implement this

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NoteEntity noteEntity = noteEntityList.get(position);
        NoteViewHolder noteViewHolder = (NoteViewHolder) holder;
        noteViewHolder.setNoteTitle(noteEntity.getTitle());
        noteViewHolder.setNoteBody(noteEntity.getNote());
    }

    @Override
    public int getItemCount() {
        if (this.noteEntityList == null) {
            return 0;
        } else {
            return noteEntityList.size();
        }
    }

    public NoteRecyclerAdapter(Context context, List<NoteEntity> notes){
        this.context = context;
        this.noteEntityList = notes;
    }
}
