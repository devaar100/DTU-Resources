package aarnav100.developer.dturesources.Models;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by Tarun kumar gola  on 16/03/19.
 */

public class MyItem implements ClusterItem {
    private final LatLng mPosition;
    private final String mTitle;
    public MyItem(double lat, double lng) {
        mPosition = new LatLng(lat, lng);
        mTitle="Marker";
    }

    public MyItem(double lat, double lng, String title) {
        mPosition = new LatLng(lat, lng);
        mTitle = title;
    }
    public double getLat() {
        return mPosition.latitude;
    }

    public double getLng (){
        return mPosition.longitude;
    }
    @Override
    public LatLng getPosition() {
        return mPosition;
    }


    public String getTitle() {
        return mTitle;
    }


    public String getSnippet() {
        return null;
    }
}
