package android.example.simplenotesapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder extends RecyclerView.ViewHolder {
     private View view;
   private TextView texttitle, texttime;
    CardView noteCard;
    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);

        view= itemView;
        texttitle = view.findViewById(R.id.note_title);
        noteCard =  view.findViewById(R.id.note_card);
        texttime = view.findViewById(R.id.note_time);

    }
    void setNoteTitle(String title){
        texttitle.setText(title);
    }

    void setNoteTime(String NoteTime){
        texttime.setText(NoteTime);
    }

}
