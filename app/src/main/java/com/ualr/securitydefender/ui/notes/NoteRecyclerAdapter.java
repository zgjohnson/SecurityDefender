package com.ualr.securitydefender.ui.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.ualr.securitydefender.R;
import com.ualr.securitydefender.data.NoteEntity;

import java.util.List;

public class NoteRecyclerAdapter  extends RecyclerView.Adapter {
    private List<NoteEntity> noteEntityList;
    private Context context;
    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    // TODO. implement this

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_list_item,parent,false);
        return new NoteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NoteEntity noteEntity = noteEntityList.get(position);
        NoteViewHolder noteViewHolder = (NoteViewHolder) holder;
        noteViewHolder.setNoteTitle(noteEntity.getTitle());
        noteViewHolder.setNoteBody(noteEntity.getNote());

        if (noteEntity.isSelected()) {
            noteViewHolder.lyt_parent.setBackgroundColor(ContextCompat.getColor(context, R.color.teal_200));
        }
        else {
            noteViewHolder.lyt_parent.setBackgroundColor(ContextCompat.getColor(context, R.color.white));
        }
    }

    @Override
    public int getItemCount() {
        if (this.noteEntityList == null) {
            return 0;
        } else {
            return noteEntityList.size();
        }
    }
    public void updateNoteList(List<NoteEntity> notes) {
        this.noteEntityList = notes;
        this.notifyDataSetChanged();
    }

    public NoteRecyclerAdapter(Context context, List<NoteEntity> notes){
        this.context = context;
        this.noteEntityList = notes;
    }

    public void removeNote(int position){
        if (position >= noteEntityList.size()){
            return;
        }
        noteEntityList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount());
    }

    public void clearAllSelections(){
        for (NoteEntity mItem: noteEntityList){
            mItem.setSelected(false);
        }
        notifyDataSetChanged();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {
        private TextView noteTitle;
        private TextView noteBody;
        public View lyt_parent;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            this.noteTitle = itemView.findViewById(R.id.note_title);
            this.noteBody = itemView.findViewById(R.id.note_info);
            lyt_parent = itemView.findViewById(R.id.note_lyt_parent);
            lyt_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(v, getLayoutPosition());
                }
            });
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


}
