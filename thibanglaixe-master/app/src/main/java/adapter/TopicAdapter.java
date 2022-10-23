package adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

import model.Topic;

public class TopicAdapter extends ArrayAdapter<Topic> {
    private Activity activity;
    private int resource;
    private List<Topic> topic;

    public TopicAdapter(@NonNull Activity context, int resource, @NonNull List<Topic> topic) {
        super(context, resource, topic);
        this.activity = context;
        this.resource = resource;
        this.topic = topic;
    }


    @Override
    public int getCount() {
        if (topic == null){
            return 0;
        }
        return topic.size();
    }

    @Override
    public Topic getItem(int position) {
        return topic.get(position);
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
        TextView txtContent = (TextView) view.findViewById(R.id.txtTopicId);
        txtContent.setText("Đề " + topic.get(position).getId());

        // Trả về view kết quả.
        return view;
    }
}
