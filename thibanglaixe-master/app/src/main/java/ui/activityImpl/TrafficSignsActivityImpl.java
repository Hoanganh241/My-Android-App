package ui.activityImpl;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.myapplication.R;

import java.util.List;

import adapter.TrafficSignsAdapter;
import model.TrafficSigns;
import presenter.TrafficSignsPresenter;
import presenterImpl.TrafficSignsPresenterImpl;
import ui.activity.TrafficSignsActivity;

public class TrafficSignsActivityImpl extends AppCompatActivity implements TrafficSignsActivity {


    private TrafficSignsAdapter trafficSignsAdapter;
    private ListView listTrafficSigns;

    private TrafficSignsPresenter trafficSignsPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traffic_signs_activity);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Các biển báo giao thông");
        actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getApplicationContext(),R.color.toolbar2)));

        trafficSignsPresenter = new TrafficSignsPresenterImpl(TrafficSignsActivityImpl.this);
        trafficSignsPresenter.getListTrafficSigns();

    }

    @Override
    public void setListTrafficSigns(List<TrafficSigns> trafficSigns) {
        trafficSignsAdapter = new TrafficSignsAdapter(this, R.layout.traffic_signs_item, trafficSigns);
        listTrafficSigns = findViewById(R.id.listTrafficSigns);
        listTrafficSigns.setAdapter(trafficSignsAdapter);
        trafficSignsAdapter.notifyDataSetChanged();
    }
    
}
