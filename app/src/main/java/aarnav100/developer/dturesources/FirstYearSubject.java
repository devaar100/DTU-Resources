package aarnav100.developer.dturesources;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import aarnav100.developer.dturesources.Adapters.WordExtenderAdapter;
import aarnav100.developer.dturesources.Models.ListSubject;

public class FirstYearSubject extends AppCompatActivity {

    private RecyclerView subjectrecyclerView;
    private String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_year_subject);
        type = getIntent().getStringExtra("type");

        ImageView backbutton=findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final ArrayList<ListSubject> subject = new ArrayList<>();
        subject.add(new ListSubject("Mathematics",  R.drawable.first));
        subject.add(new ListSubject("Physics",  R.drawable.first));
        subject.add(new ListSubject("Chemistry",  R.drawable.first));
        subject.add(new ListSubject("Electrical",  R.drawable.first));
        subject.add(new ListSubject("Computer",  R.drawable.first));
        subject.add(new ListSubject("Mechanical",  R.drawable.first));
        subject.add(new ListSubject("Engineering Drawing",R.drawable.first));

        ListView list = findViewById(R.id.lvf);
        WordExtenderAdapter item = new WordExtenderAdapter(this, subject);
        list.setAdapter(item);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListSubject word = subject.get(position);
                Intent intent=new Intent(FirstYearSubject.this,FirstYearItems.class);
                intent.putExtra("type",type);
                intent.putExtra("subject",word.getKann());
                startActivity(intent);
            }
        });
    }
}
