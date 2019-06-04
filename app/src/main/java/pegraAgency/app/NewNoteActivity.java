package pegraAgency.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ServerTimestamp;

public class NewNoteActivity extends AppCompatActivity {
    private EditText editTextTitle, editTextDescription,editTextPhoneNo;
    private Button bSave, bCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextDescription = findViewById(R.id.editTextDescription);
        editTextPhoneNo = findViewById(R.id.editTextPhoneNo);
        bSave = findViewById(R.id.buttonSave);
        bCancel = findViewById(R.id.buttonCancel);


        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noteCancel();
            }
        });

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });

    }
    private void saveNote(){
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        int phoneNo  = Integer.parseInt(editTextPhoneNo.getText().toString());




        if(title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Please fill all the field before you save", Toast.LENGTH_LONG).show();

        }else {
        CollectionReference notebookRef = FirebaseFirestore.getInstance()
                .collection("Notebook");
        notebookRef.add(new Note(title,description, phoneNo ));

        startActivity ( new Intent(NewNoteActivity.this, MainActivity.class));
        Toast.makeText(this, "Your complain has been send to Pegra Agency", Toast.LENGTH_LONG).show();

    }


}
    private void noteCancel (){
        startActivity(new Intent(NewNoteActivity.this, MainActivity.class));
        Toast.makeText(this, "Nothing was sent to the management", Toast.LENGTH_LONG).show();

    }

}

