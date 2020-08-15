package aarnav100.developer.dturesources;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import aarnav100.developer.dturesources.Models.Devs;

public class DeveloperDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_details);
        Intent intent = getIntent();
        final Devs dev = (Devs)intent.getSerializableExtra("Dev");

        ((ImageView)findViewById(R.id.dev_img)).setImageDrawable(getResources().getDrawable(dev.getSqPhoto()));
        ((TextView)findViewById(R.id.dev_name)).setText(dev.getName());
        ((TextView)findViewById(R.id.dev_batch)).setText("COE Batch "+String.valueOf(dev.getYear()));
        ((TextView)findViewById(R.id.dev_batch)).setText(dev.getBranch()+" Batch "+String.valueOf(dev.getYear()));
        final ImageView dev_fb1=findViewById(R.id.dev_fb);
        final ImageView dev_gmail1=findViewById(R.id.dev_gmail);
        final ImageView dev_linkedin=findViewById(R.id.dev_linkedin);
        final ImageView dev_github=findViewById(R.id.dev_git);


        dev_gmail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SENDTO);
                email.setData(Uri.parse("mailto:"));
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{dev.getMail()});
                email.putExtra(Intent.EXTRA_SUBJECT, "DTU Resources");
                email.putExtra(Intent.EXTRA_TEXT, "Query/Feedback");
                startActivity(email);
            }
        });
        final String[] links = dev.getLinks();
        dev_fb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(links[0].equals("Developer Not On Facebok"))
                    Toast.makeText(DeveloperDetails.this,"Developer Not On Facebok",Toast.LENGTH_SHORT).show();
                else {
                    Uri webpage = Uri.parse(links[0]);
                    Intent browse = new Intent(Intent.ACTION_VIEW, webpage);
                    startActivity(browse);
                }
            }
        });
        dev_linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse(links[1]);
                Intent browse = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(browse);
            }
        });
        dev_github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse(links[2]);
                Intent browse = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(browse);
            }
        });
    }
}
