package com.ualr.securitydefender.ui.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.ualr.securitydefender.R;
import com.ualr.securitydefender.data.NoteEntity;

import java.util.List;

public class EditNoteFragment extends DialogFragment {

    private static final String SELECTED = "selectedNote";
    private NotesViewModel mNoteViewModel;

    public static EditNoteFragment newInstance(int selectedNote){
        EditNoteFragment mFragment = new EditNoteFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(SELECTED, selectedNote);
        mFragment.setArguments(arguments);
        return mFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNoteViewModel = new ViewModelProvider(getActivity()).get(NotesViewModel.class);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogStyle);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_edit,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final int selectedNoteIndex = getArguments().getInt(SELECTED);
        final NoteEntity selectedNoteItem = mNoteViewModel.getNotes().getValue().get(selectedNoteIndex);
        final EditText newTitle = view.findViewById(R.id.edit_note_title);
        final EditText newNoteInfo = view.findViewById(R.id.edit_note_info);

        newTitle.setText(selectedNoteItem.getTitle());
        newNoteInfo.setText(selectedNoteItem.getNote());

        Button saveBtn = view.findViewById(R.id.edit_note_button);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedNoteItem.setTitle(newTitle.getText().toString());
                selectedNoteItem.setNote(newNoteInfo.getText().toString());
                selectedNoteItem.setSelected(false);

                List<NoteEntity> currentNoteItems = mNoteViewModel.getNotes().getValue();
                mNoteViewModel.setNotes(currentNoteItems);
                dismissFragment();

            }
        });
    }

    private void dismissFragment() {
        this.dismiss();
    }
}
