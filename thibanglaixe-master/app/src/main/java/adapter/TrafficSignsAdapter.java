package adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.squareup.picasso.Callback;

import java.util.List;

import model.TrafficSigns;
import utils.CustomPicasso;

public class TrafficSignsAdapter extends ArrayAdapter<TrafficSigns> {
    private Activity activity;
    private int resource;
    private List<TrafficSigns> trafficSigns;

    public TrafficSignsAdapter(@NonNull Activity context, int resource, @NonNull List<TrafficSigns> trafficSigns) {
        super(context, resource, trafficSigns);
        this.activity = context;
        this.resource = resource;
        this.trafficSigns = trafficSigns;
    }


    @Override
    public int getCount() {
        if (trafficSigns == null){
            return 0;
        }
        return trafficSigns.size();
    }

    @Override
    public TrafficSigns getItem(int position) {
        return trafficSigns.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // Gọi layoutInflater ra để bắt đầu ánh xạ view và data.
        LayoutInflater inflater = activity.getLayoutInflater();

        // Đổ dữ liệu vào biến View, view này chính là những gì nằm trong item_name.xml
        view = inflater.inflate(this.resource, null);

        // Đặt chữ cho từng view trong danh sách.
        ImageView imgTraffic = (ImageView) view.findViewById(R.id.imgTraffic);
        CustomPicasso.with(view.getContext())
                .load("https://songchung.vn/API_giaothong/image/" + trafficSigns.get(position).getImage())
                .placeholder(R.mipmap.loader)
                .error(R.mipmap.error)
                .into(imgTraffic, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("Success: ", "Success");
                    }

                    @Override
                    public void onError() {
                        Log.d("error: ", "error");
                    }
                });
        TextView txtContent = (TextView) view.findViewById(R.id.txtIdTraffic);
        txtContent.setText(trafficSigns.get(position).getId());
        TextView txtMulct = (TextView) view.findViewById(R.id.txtContentTraffic);
        txtMulct.setText(trafficSigns.get(position).getContent());


        // Trả về view kết quả.
        return view;
    }
}
