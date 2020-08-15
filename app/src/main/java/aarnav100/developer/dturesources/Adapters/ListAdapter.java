package aarnav100.developer.dturesources.Adapters;

import aarnav100.developer.dturesources.R;
import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import aarnav100.developer.dturesources.AllBranchItems;
import aarnav100.developer.dturesources.Models.ListSubject;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private Context context;
    private List<ListSubject> personUtils;
    private String type;


    public ListAdapter(Context context, List<ListSubject> personUtils, String type) {
        this.context = context;
        this.personUtils = personUtils;
        this.type = type;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(personUtils.get(position));

        final ListSubject pu = personUtils.get(position);

        holder.pName.setImageResource(pu.getImgRes());
        holder.pJobProfile.setText(pu.getKann());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pu.getKann().length()>=4&&pu.getKann().substring(0,4).equals("SEM "));
                else{
                    Intent intent=new Intent(context, AllBranchItems.class);
                    intent.putExtra("type",type);
                    intent.putExtra("subject",pu.getKann());
                    context.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return personUtils.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView pName;
        public TextView pJobProfile;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            pName =  itemView.findViewById(R.id.iv);
            pJobProfile = itemView.findViewById(R.id.t1);
            linearLayout=itemView.findViewById(R.id.listLinearLayout);


        }
    }

}