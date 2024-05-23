package com.example.cartimart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cartimart.adapter.ListgridAdapter;
import com.example.cartimart.model.NotesList;

import java.util.List;


public class NotesListAct extends AppCompatActivity {
    Button createList;
    ListView idListItems;
    ListgridAdapter adapter;
    DatabaseNotesList dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notes_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        idListItems = findViewById(R.id.idListItems);
        createList = findViewById(R.id.buttonCreateList);
        createList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotesListAct.this, listAdding.class);
                startActivity(intent);
            }
        });
        dbHelper = new DatabaseNotesList(this);
        List<NotesList> notesLists = dbHelper.getAlladdress();
        adapter = new ListgridAdapter(this,notesLists);
        idListItems.setAdapter(adapter);

    }
}