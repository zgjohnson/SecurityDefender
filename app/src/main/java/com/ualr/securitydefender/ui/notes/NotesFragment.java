package com.ualr.securitydefender.ui.notes;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ualr.securitydefender.R;
import com.ualr.securitydefender.data.NoteEntity;

import java.util.List;

public class NotesFragment extends Fragment {

    private NotesViewModel notesViewModel;
    private NoteRecyclerAdapter noteRecyclerAdapter;
    private FloatingActionButton addButton;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notesViewModel =
                new ViewModelProvider(this).get(NotesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notes, container, false);
        notesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);
        setHasOptionsMenu(true);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.addButton = view.findViewById(R.id.note_add_button);

        RecyclerView recyclerView = view.findViewById(R.id.notes_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        notesViewModel.getNotes().observeForever(new Observer<List<NoteEntity>>() {
            @Override
            public void onChanged(List<NoteEntity> noteEntities) {
                noteRecyclerAdapter = new NoteRecyclerAdapter(getContext(), notesViewModel.getNotes().getValue());
                recyclerView.setAdapter(noteRecyclerAdapter);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNewNoteDialog();
            }
        });
    }

    private void showNewNoteDialog() {
        FragmentManager fm = getChildFragmentManager();
        NewNoteFragment newNoteFragment = new NewNoteFragment(notesViewModel);
        newNoteFragment.show(fm, "noteFrag");
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}