package aarnav100.developer.dturesources.Fragments;

import aarnav100.developer.dturesources.R;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.cardview.widget.CardView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import aarnav100.developer.dturesources.FirstYearSubject;
import aarnav100.developer.dturesources.StreamActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class DtuHome extends Fragment implements View.OnClickListener {


    private String type;
    private CardView firstYear;
    private CardView ComputerScience;
    private CardView InformationTechnology;
    private CardView Sowftware;
    private CardView ECE;
    private CardView Placements;
    private CardView ME;
    private CardView EE;
    private CardView MAM;
    private CardView MC;
    private CardView PIE;
    private CardView EP;
    private CardView ENE;
    private CardView PCT;
    private CardView CE;
    private CardView BT;

    BottomNavigationView bottomNavigationView;
    public DtuHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_dtu_home, container, false);
        type = "Books";
        bottomNavigationView=v.findViewById(R.id.homeBottomNavigationBar);
        firstYear=v.findViewById(R.id.firstYear);
        ComputerScience=v.findViewById(R.id.Computer_Science);
        InformationTechnology=v.findViewById(R.id.it);
        Sowftware=v.findViewById(R.id.se);
        ECE=v.findViewById(R.id.ECE);
        EE=v.findViewById(R.id.ee);
        Placements=v.findViewById(R.id.placement);
        MAM=v.findViewById(R.id.mam);
        MC=v.findViewById(R.id.MC);
        PCT=v.findViewById(R.id.PCT);
        BT=v.findViewById(R.id.BT);
        ENE=v.findViewById(R.id.ENE);
        EP=v.findViewById(R.id.EP);
        PIE=v.findViewById(R.id.PIE);
        CE=v.findViewById(R.id.CE)  ;
        ME=v.findViewById(R.id.me);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                 switch (menuItem.getItemId()){
                     case R.id.book:
                         type = "Books";
                         break;
                     case R.id.notes:
                         type = "Notes";
                         break;
                     case R.id.paper:
                         type = "Question Paper";
                         break;
                     case R.id.Practical:
                         type = "Practicals";
                         break;
                 }
                 if (menuItem.getItemId()!=R.id.notes)
                    Toast.makeText(getContext(),"You are in "+type,Toast.LENGTH_SHORT).show();
                 else
                     Toast.makeText(getContext(),"You are in Notes and Assignments",Toast.LENGTH_SHORT).show();
                     return true;
            }
        });

        firstYear.setOnClickListener(this);
        ComputerScience.setOnClickListener(this);
        InformationTechnology.setOnClickListener(this);
        Sowftware.setOnClickListener(this);
        ECE.setOnClickListener(this);
        EE.setOnClickListener(this);
        Placements.setOnClickListener(this);
        MAM.setOnClickListener(this);
        MC.setOnClickListener(this);
        PIE.setOnClickListener(this);
        EP.setOnClickListener(this);
        ENE.setOnClickListener(this);
        PCT.setOnClickListener(this);
        CE.setOnClickListener(this);
        BT.setOnClickListener(this);
        ME.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("type",type);
        if (view.getId()==R.id.firstYear)
           intent.setClass(getActivity(),FirstYearSubject.class);
        else {
            intent.setClass(getActivity(), StreamActivity.class);

            switch (view.getId()){
                case R.id.Computer_Science:
                    intent.putExtra("stream","COE");
                    break;
                case R.id.it:
                    intent.putExtra("stream","IT");
                    break;
                case R.id.se:
                    intent.putExtra("stream","SE");
                    break;
                case R.id.ECE:
                    intent.putExtra("stream","ECE");
                    break;
                case R.id.ee:
                    intent.putExtra("stream","EE");
                    break;
                case R.id.me:
                    intent.putExtra("stream","ME");
                    break;
                case R.id.PIE:
                    intent.putExtra("stream","PIE");
                case R.id.MC:
                    intent.putExtra("stream","MC");
                    break;
                case R.id.PCT:
                    intent.putExtra("stream","PCT");
                    break;
                case R.id.mam:
                    intent.putExtra("stream","MAM");
                    break;
                case R.id.CE:
                    intent.putExtra("stream","CE");
                    break;
                case R.id.BT:
                    intent.putExtra("stream","BT");
                    break;
                case R.id.EP:
                    intent.putExtra("stream","EP");
                    break;
                case R.id.ENE:
                    intent.putExtra("stream","ENE");
                    break;

                case R.id.placement:
                    intent.putExtra("stream","PC");
                    break;
            }
        }
        startActivity(intent);
    }
}

