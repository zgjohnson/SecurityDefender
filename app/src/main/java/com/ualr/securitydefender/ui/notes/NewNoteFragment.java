package com.ualr.securitydefender.ui.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputEditText;
import com.ualr.securitydefender.R;
import com.ualr.securitydefender.data.NoteEntity;

public class NewNoteFragment extends DialogFragment {
    private Button createNoteButton;
    private NotesViewModel vm;
    private TextInputEditText noteTitleEditText;
    private EditText noteInfoEditText;

    public NewNoteFragment(NotesViewModel vm){
        this.vm = vm;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogStyle);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_add, container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.vm = new ViewModelProvider(requireActivity()).get(NotesViewModel.class);
        this.createNoteButton = view.findViewById(R.id.new_note_create_button);
        this.noteTitleEditText = view.findViewById(R.id.note_title);
        this.noteInfoEditText = view.findViewById(R.id.note_info);

        this.createNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoteEntity noteEntity = new NoteEntity();
                noteEntity.setTitle(noteTitleEditText.getEditableText().toString());
                noteEntity.setNote(noteInfoEditText.getEditableText().toString());
                vm.getNotes().getValue().add(noteEntity);
                goBack();
            }
        });
    }

    private void goBack() {
        this.getParentFragmentManager().beginTransaction().replace(this.getId(), new NotesFragment()).commitNow();
    }
}
