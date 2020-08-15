package aarnav100.developer.dturesources.Fragments;

import aarnav100.developer.dturesources.R;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.algo.Algorithm;
import com.google.maps.android.clustering.algo.NonHierarchicalDistanceBasedAlgorithm;

import java.util.ArrayList;
import java.util.Collection;

import aarnav100.developer.dturesources.Models.MyItem;


/**
 * A simple {@link Fragment} subclass.
 */
public class DtuMaps extends Fragment implements OnMapReadyCallback {

    ArrayList<String> places;
    AutoCompleteTextView autoComplete;
    ArrayList<MyItem> userList;
    Marker m;
    View rootView;
    ArrayAdapter<String> myAdap;
    private GoogleMap mMap;
    private ClusterManager<MyItem> mClusterManager;
    public DtuMaps() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_dtu_maps, container, false);

        userList = new ArrayList<>();
        places = new ArrayList<>();
        autoComplete = (AutoCompleteTextView) rootView.findViewById(R.id.autoComplete);
        myAdap = new ArrayAdapter<String>(getContext(), R.layout.placelayout, R.id.tvplace, places);
        autoComplete.setAdapter(myAdap);
        autoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView temp = (TextView) view.findViewById(R.id.tvplace);
                String x = temp.getText().toString();
                for (int i = 0; i < userList.size(); i++) {
                    LatLng ll;
                    if (userList.get(i).getTitle().equals(x)) {
                        ll = new LatLng(userList.get(i).getLat(), userList.get(i).getLng());
                        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.
                                Builder().target(ll).tilt(45).zoom(20).build()));
                        if (m != null)
                            m.hideInfoWindow();
                        m = mMap.addMarker(new MarkerOptions().title(x).position(ll).visible(true));
                        m.showInfoWindow();
                        break;
                    }
                }
            }
        });
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            takePermission();
        }
        work();

    }
    void work() {
        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            getActivity().finish();
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.setInfoWindowAdapter(null);
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);

        final CameraPosition[] mPreviousCameraPosition = {null};
        mMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {
                CameraPosition position = mMap.getCameraPosition();
                if(mPreviousCameraPosition[0] == null || mPreviousCameraPosition[0].zoom != position.zoom) {
                    mPreviousCameraPosition[0] = mMap.getCameraPosition();
                    mClusterManager.cluster();
                }
            }
        });
        mMap.setOnMarkerClickListener(mClusterManager);
        mClusterManager = new ClusterManager<MyItem>(getContext(), mMap);
        mClusterManager.addItem(new MyItem(28.753567, 77.115853, "Ground"));
        mClusterManager.addItem(new MyItem(28.750623, 77.116647, "Library"));
        mClusterManager.addItem(new MyItem(28.752029, 77.116738, "Sports Complex"));
        mClusterManager.addItem(new MyItem(28.751089, 77.115643, "Mic Mac"));
        mClusterManager.addItem(new MyItem(28.745266, 77.117649, "Maggi Baba"));
        mClusterManager.addItem(new MyItem(28.746555, 77.119205, "Post Office"));
        mClusterManager.addItem(new MyItem(28.747750, 77.119817, "Gym"));
        mClusterManager.addItem(new MyItem(28.747421, 77.119624, "SBI"));
        mClusterManager.addItem(new MyItem(28.749350, 77.118808, "Mechanical Canteen"));
        mClusterManager.addItem(new MyItem(28.749455, 77.118445, "Amul"));
        mClusterManager.addItem(new MyItem(28.749488, 77.118153, "Juice Corner"));
        mClusterManager.addItem(new MyItem(28.749655, 77.116702, "Nescafe"));
        mClusterManager.addItem(new MyItem(28.749417, 77.118848, "Stationary"));
        mClusterManager.addItem(new MyItem(28.751964, 77.119599, "Kissing Point"));
        mClusterManager.addItem(new MyItem(28.753544, 77.114471, "Race Track"));
        mClusterManager.addItem(new MyItem(28.751037, 77.117561, "Wind Point"));
        mClusterManager.addItem(new MyItem(28.750764, 77.117990, "Science Block"));
        mClusterManager.addItem(new MyItem(28.750530, 77.116589, "Library Registration"));
        mClusterManager.addItem(new MyItem(28.750506, 77.116312 ,"Technology Incubator"));
        mClusterManager.addItem(new MyItem(28.749820, 77.116203,"Joint Registrar"));
        mClusterManager.addItem(new MyItem(28.749926, 77.116341,"Senate Hall "));
        mClusterManager.addItem(new MyItem(28.749668, 77.113001,"DTU Lake"));
        mClusterManager.addItem(new MyItem(28.750236, 77.116440,"BR Ambedkar Audi"));
        mClusterManager.addItem(new MyItem(28.750256, 77.116451,"Smart Classroom"));
        mClusterManager.addItem(new MyItem(28.750119, 77.117128 ,"Computer Centre"));
        mClusterManager.addItem(new MyItem(28.750979, 77.117627,"Physics Lab"));
        mClusterManager.addItem(new MyItem(28.751238, 77.117879,"Chemistry Labs "));
        mClusterManager.addItem(new MyItem(28.751288, 77.119004,"SPS 1-8"));
        mClusterManager.addItem(new MyItem(28.749355, 77.119888,"SPS 9-12"));
        mClusterManager.addItem(new MyItem(28.749562, 77.119942,"Washroom"));
        mClusterManager.addItem(new MyItem(28.751058, 77.118697,"Washroom"));
        mClusterManager.addItem(new MyItem(28.750973, 77.118628,"Mechanical Workshop"));
        mClusterManager.addItem(new MyItem(28.749681, 77.116269,"Admin Block"));
        mClusterManager.addItem(new MyItem(28.747722, 77.118213,"Girl's Hostel"));
        Algorithm<MyItem> clusterManagerItem;
        clusterManagerItem=new NonHierarchicalDistanceBasedAlgorithm<>();
        mClusterManager.setAlgorithm(clusterManagerItem);
        Collection<MyItem> mrkrs=clusterManagerItem.getItems();
        Object[] markers=  mrkrs.toArray();
        for(int i=0;i<markers.length;i++)
        {
            userList.add((MyItem)markers[i]);
            places.add(userList.get(i).getTitle());
        }
        LatLng dtu = new LatLng(28.7505, 77.1177);
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(dtu).tilt(65).zoom(15).build()),2500,null);
        myAdap.notifyDataSetChanged();
        mMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {
                CameraPosition position = mMap.getCameraPosition();
                if(mPreviousCameraPosition[0] == null || mPreviousCameraPosition[0].zoom != position.zoom) {
                    mPreviousCameraPosition[0] = mMap.getCameraPosition();
                    mClusterManager.cluster();
                }
            }
        });
        mClusterManager.getMarkerCollection().setOnInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                LayoutInflater inflater=(LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View view=inflater.inflate(R.layout.info_window,null);
                TextView venue_name=view.findViewById(R.id.venue_name);
                venue_name.setText(marker.getTitle());
                return view;
            }

            @Override
            public View getInfoContents(Marker marker) {
                return null;
            }
        });

        mMap.setOnMarkerClickListener(mClusterManager);
        mClusterManager.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener<MyItem>() {
            @Override
            public boolean onClusterItemClick(MyItem myItem) {

                return false;
            }
        });
    }

    void takePermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                || ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)) {
            Toast.makeText(getContext(), "Please give the permission", Toast.LENGTH_SHORT).show();
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{
                android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION
        }, 100);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 100){
            for(int i=0;i<grantResults.length;i++)
                if(grantResults[i] != PackageManager.PERMISSION_GRANTED)
                    getActivity().finish();
            work();
        }
    }
}

