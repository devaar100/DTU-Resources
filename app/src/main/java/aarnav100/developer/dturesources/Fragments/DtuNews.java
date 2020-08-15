package aarnav100.developer.dturesources.Fragments;

import aarnav100.developer.dturesources.R;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import aarnav100.developer.dturesources.Models.PostBlog;


/**
 * A simple {@link Fragment} subclass.
 */
public class DtuNews extends Fragment {
    RecyclerView recyclerView;
    boolean firstVisible = true;
    DatabaseReference mref;

    public DtuNews() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_dtu__news, container, false);
        recyclerView=rootView.findViewById(R.id.dtunnewRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mref=FirebaseDatabase.getInstance().getReference().child("DTUNEWS");
        return rootView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            if(firstVisible){
                new DownloadNewsTask().doInBackground();
            }
        }
    }

    private class DownloadNewsTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            FirebaseRecyclerAdapter<PostBlog,PostViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<PostBlog, PostViewHolder>(
                    PostBlog.class,
                    R.layout.dtunewslayout,
                    PostViewHolder.class,
                    mref
            ) {
                @Override
                protected void populateViewHolder(PostViewHolder viewHolder, PostBlog model, int position) {
                    viewHolder.setPost(model.getTitle(),model.getDescript(),model.getImageUrl());
                }
            };
            recyclerView.setAdapter(firebaseRecyclerAdapter);
            firstVisible = false;
            return null;
        }
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder{
        View view;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
        }
        private void setPost(String title, String postDescription, String imageURL){
            TextView posttitle=view.findViewById(R.id.posttitlerecyclerview);
            TextView postdescp=view.findViewById(R.id.postdec);
            ImageView imageView=view.findViewById(R.id.dtunewimage);
            postdescp.setText(postDescription);
            posttitle.setText(title);
            Picasso.get().load(imageURL).into(imageView);
        }
    }
}
