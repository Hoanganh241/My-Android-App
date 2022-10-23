package adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import com.example.myapplication.R;

import java.util.List;

import model.Answer;


public class AnswerAdapter extends ArrayAdapter<Answer> {

    Activity context;
    int resource;
    List<Answer> answers;

    public AnswerAdapter(@NonNull Activity context, int resource, @NonNull List<Answer> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.answers = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = this.context.getLayoutInflater();
//        View row = inflater.inflate(this.resource, null);//Biên dịch file xml (item.xml)

        convertView = inflater.inflate(this.resource, null);
        CheckBox chkAnswer = convertView.findViewById(R.id.chkDapAn);
        Answer answer = this.answers.get(position);

        chkAnswer.setText(answer.getContent());
        // Hiển thị đáp án đúng ngay từ đầu. Nút Hiển thị đáp án đúng không có tác dụng gì
//        String answerDung=answer.getAnswerDung();
//        if(answerDung.equals("True"))
//            chkCheck.setChecked(true);
        return convertView;
    }
}
