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

import model.Question;

public class QuestionAdapter extends ArrayAdapter<Question> {
    private Activity activity;
    private int resource;
    private List<Question> question;

    public QuestionAdapter(@NonNull Activity context, int resource, @NonNull List<Question> question) {
        super(context, resource, question);
        this.activity = context;
        this.resource = resource;
        this.question = question;
    }


    @Override
    public int getCount() {
        if (question == null) {
            return 0;
        }
        return question.size();
    }

    @Override
    public Question getItem(int position) {
        return question.get(position);
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
        TextView txtContent = (TextView) view.findViewById(R.id.chkDapAn);
        txtContent.setText(question.get(position).getContent());


        // Trả về view kết quả.
        return view;
    }
}
