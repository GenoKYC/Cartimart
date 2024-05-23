package com.example.cartimart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cartimart.model.NotesList;

public class listAdding extends AppCompatActivity {
    private DatabaseNotesList dbHelper;

    EditText TitleInput, ContentInput,fullnameInput;
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_adding);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        dbHelper = new DatabaseNotesList(this);
        TitleInput = findViewById(R.id.TitleInput);
        ContentInput = findViewById(R.id.ContentInput);
        submitButton = findViewById(R.id.submitButton);
        fullnameInput = findViewById(R.id.fullnameInput);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String listTitle = TitleInput.getText().toString().trim();
                String content = ContentInput.getText().toString().trim();
                String fullname = fullnameInput.getText().toString().trim();
                NotesList noteadd = new NotesList(listTitle,content,fullname);

                long result = dbHelper.addUsersInfo(noteadd);
                if(result != -1){
                    Toast.makeText(listAdding.this, "Notes Added!", Toast.LENGTH_SHORT).show();
                    TitleInput.setText(" ");
                    ContentInput.setText(" ");
                    fullnameInput.setText(" ");

                }
                else{
                    Toast.makeText(listAdding.this, "Error adding notes", Toast.LENGTH_SHORT).show();
                }
            }


        });

    }

}