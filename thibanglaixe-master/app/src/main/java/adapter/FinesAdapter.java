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

import model.Fines;

public class FinesAdapter extends ArrayAdapter<Fines> {
    private Activity activity;
    private int resource;
    private List<Fines> fines;

    public FinesAdapter(@NonNull Activity context, int resource, @NonNull List<Fines> fines) {
        super(context, resource, fines);
        this.activity = context;
        this.resource = resource;
        this.fines = fines;
    }


    @Override
    public int getCount() {
        if (fines == null){
            return 0;
        }
        return fines.size();
    }

    @Override
    public Fines getItem(int position) {
        return fines.get(position);
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
        TextView txtContent = (TextView) view.findViewById(R.id.txtId);
        txtContent.setText(fines.get(position).getContent());
        TextView txtMulct = (TextView) view.findViewById(R.id.txtMulct);
        txtMulct.setText(fines.get(position).getMulct());


        // Trả về view kết quả.
        return view;
    }
}
