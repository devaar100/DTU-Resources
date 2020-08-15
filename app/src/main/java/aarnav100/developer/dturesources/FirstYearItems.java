package aarnav100.developer.dturesources;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import aarnav100.developer.dturesources.Models.Books;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class FirstYearItems extends AppCompatActivity {

    private ProgressDialog mDialog;
    private String itemtype;
    private TextView toolbaritem;
    private RecyclerView bookrecyclerViewitems;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_year_items);
        Toolbar toolbar = findViewById(R.id.toolbarfirstyearitems);
        setSupportActionBar(toolbar);

        mDialog=new ProgressDialog(this);


        ImageView backbutton=findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        toolbaritem=findViewById(R.id.toolbarfirstyearitemstitle);
        itemtype = getIntent().getStringExtra("type");
        String itemsubject=getIntent().getStringExtra("subject");
        if(itemtype.equals("Practicals"))
            itemtype = "Practicals";
        if(itemtype.equals("Question Paper"))
            itemtype = "Papers";

        databaseReference=FirebaseDatabase.getInstance().getReference().child("FirstYear").child(itemtype).child(itemsubject);
        toolbaritem.setText(itemsubject);

        bookrecyclerViewitems=findViewById(R.id.recyclerViewbooksitems);
        bookrecyclerViewitems.setLayoutManager(new LinearLayoutManager(this));
        mDialog.setMessage("LOADING");
        mDialog.show();
    }

    public static class BookViewholder extends RecyclerView.ViewHolder{
        View bookView;
        LinearLayout booklist;
        public BookViewholder(@NonNull View itemView) {
            super(itemView);
            bookView=itemView;
            booklist=itemView.findViewById(R.id.booklistLinearLayout);
        }
        public void setBook(String booktitle){
            TextView textView=bookView.findViewById(R.id.booktitle);
            textView.setText(booktitle);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getChildrenCount()==0){
                    Toast.makeText(FirstYearItems.this, "Material not available for this category", Toast.LENGTH_SHORT).show();
                    mDialog.dismiss();
                }else{
                    FirebaseRecyclerAdapter<Books, BookViewholder> booksBookViewholderFirebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Books, BookViewholder>(
                            Books.class,
                            R.layout.booklayout,
                            BookViewholder.class,
                            databaseReference
                    )
                    {
                        @Override
                        protected void populateViewHolder(BookViewholder viewHolder, final Books model, int position) {
                            viewHolder.setBook(model.getName());
                            viewHolder.booklist.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    downloadbook(getApplicationContext(), model.getName(), model.getBooktype(), DIRECTORY_DOWNLOADS, model.getUrl().trim());
                                }
                            });
                        }
                    };
                    bookrecyclerViewitems.setAdapter(booksBookViewholderFirebaseRecyclerAdapter);
                    mDialog.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                mDialog.dismiss();
                Toast.makeText(FirstYearItems.this, "There was an error. Please try again", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void downloadbook(Context context, String Filename, String FileExtension, String DesignationDirectory, String url)
    {
        DownloadManager downloadManager=(DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri=Uri.parse(url);
        DownloadManager.Request request=new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context,DesignationDirectory,Filename+FileExtension);
        downloadManager.enqueue(request);
        Snackbar snackbar = (Snackbar) Snackbar
                .make(findViewById(android.R.id.content), "Downloading...", Snackbar.LENGTH_LONG);
        snackbar.show();
    }

}
