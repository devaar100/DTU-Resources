package aarnav100.developer.dturesources;

import android.app.ActivityOptions;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import aarnav100.developer.dturesources.Adapters.DevsAdapter;
import aarnav100.developer.dturesources.Models.Devs;

public class Developers extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        final ArrayList<Devs> androidFlavors = new ArrayList<Devs>();
        androidFlavors.add(new Devs("Aarnav Jindal","COE", "aarnavjindal1000@gmail.com", new String[]{"https://www.facebook.com/aarnav.jindal.7","https://www.linkedin.com/in/aarnavjindal","https://www.github.com/devar100"},2020, R.drawable.bhaiya, R.drawable.bhaiyasquare ));
        androidFlavors.add(new Devs("Arnav Gohil", "COE", "arnav.gohil04@gmail.com",new String[]{"Developer Not On Facebok","https://www.linkedin.com/in/arnav-gohil-348026173","https://www.github.com/ArnavGohil"},2022, R.drawable.arnav, R.drawable.arnavsquare ));
        androidFlavors.add(new Devs("Tarun Kumar Gola","ECE", "dev.tarun.and@gmail.com",new String[]{"Developer Not On Facebook","https://www.linkedin.com","https://www.github.com/TarunKumarGola"},2022, R.drawable.tarun, R.drawable.tarunsquare ));
        androidFlavors.add(new Devs("Akshat Jindal", "SE","akshatjindal215@gmail.com", new String[]{"https://www.facebook.com/akshat.jindal.3","https://www.linkedin.com/in/akshat-jindal","https://www.github.com/Khali851999"},2022, R.drawable.akshat, R.drawable.akshatsquare));


        // Create an {@link AndroidFlavorAdapter}, whose data source is a list of
        // {@link AndroidFlavor}s. The adapter knows how to create list item views for each item
        // in the list.
        DevsAdapter oAdapter = new DevsAdapter(this, androidFlavors);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(oAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ActivityOptions options = null;
                Intent intent = new Intent(Developers.this, DeveloperDetails.class);
                intent.putExtra("Dev",androidFlavors.get(position));

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    options = ActivityOptions.makeSceneTransitionAnimation(Developers.this,view,"img_transition");
                    startActivity(intent, options.toBundle());
                }
                else
                    startActivity(intent);
            }
        });
    }
}
