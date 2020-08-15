package aarnav100.developer.dturesources.Fragments;

import aarnav100.developer.dturesources.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import aarnav100.developer.dturesources.Developers;


/**
 * A simple {@link Fragment} subclass.
 */
public class HelpDesk extends Fragment implements View.OnClickListener {

    private CardView material,news,developer;

    public HelpDesk() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_help__desk, container, false);
        material=v.findViewById(R.id.material);
        news=v.findViewById(R.id.news);
        developer=v.findViewById(R.id.developers);
        material.setOnClickListener(this);
        news.setOnClickListener(this);
        developer.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.material)
        {
            Toast.makeText(getContext(), "Please attach the material in the mail.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { "droidheads123@gmail.com" });
            intent.putExtra(Intent.EXTRA_SUBJECT, "Material for DTU Resources");
            intent.putExtra(Intent.EXTRA_TEXT, "Hi,\n I would like to contribute the following materials");
            {
                startActivity(intent);
            }

        }
        else if (view.getId() == R.id.news)
        {

            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { "droidheads123@gmail.com" });
            intent.putExtra(Intent.EXTRA_SUBJECT, "News for DTU Resources");
            intent.putExtra(Intent.EXTRA_TEXT, "Hi,\n I would like to publish the following news on the app");
            {
                startActivity(intent);
            }

        }
        else if (view.getId() == R.id.developers)
        {
            Intent i=new Intent(this.getContext(),Developers.class);
            startActivity(i);

        }

    }

}
