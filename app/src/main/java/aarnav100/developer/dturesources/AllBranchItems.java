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

public class AllBranchItems extends AppCompatActivity {

    private ProgressDialog mDialog;
    private String itemtype;
    private RecyclerView bookrecyclerViewitems;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_branch_items);
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


        String itemsubject=getIntent().getStringExtra("subject");
        ((TextView)findViewById(R.id.toolbarfirstyearitemstitle)).setText(itemsubject);
        itemtype=getIntent().getStringExtra("type");
        if(itemtype.equals("Practicals"))
            itemtype = "Practicals";
        if(itemtype.equals("Question Paper"))
            itemtype = "Papers";
        databaseReference = FirebaseDatabase.getInstance().getReference().child("AllbranchSubjects").child(itemtype).child(itemsubject);

        bookrecyclerViewitems=findViewById(R.id.recyclerViewbooksitems);
        bookrecyclerViewitems.setLayoutManager(new LinearLayoutManager(this));
        mDialog.setMessage("LOADING");
        mDialog.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getChildrenCount()==0) {
                    Toast.makeText(AllBranchItems.this, "Material not available for this category", Toast.LENGTH_SHORT).show();
                    mDialog.dismiss();
                }
                else{
                    FirebaseRecyclerAdapter<Books, FirstYearItems.BookViewholder> booksBookViewholderFirebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Books, FirstYearItems.BookViewholder>(
                            Books.class,
                            R.layout.booklayout,
                            FirstYearItems.BookViewholder.class,
                            databaseReference
                    ) {
                        @Override
                        protected void populateViewHolder(FirstYearItems.BookViewholder viewHolder, final Books model, int position) {
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
                Toast.makeText(AllBranchItems.this, "There was an error. Please try again", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void downloadbook(Context context, String Filename, String FileExtension, String DesignationDirectory, String url) {
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
