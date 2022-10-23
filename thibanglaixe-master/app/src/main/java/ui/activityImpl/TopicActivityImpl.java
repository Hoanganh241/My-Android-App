package ui.activityImpl;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.myapplication.R;

import java.util.List;

import adapter.TopicAdapter;
import model.Topic;
import presenter.TopicPresenter;
import presenterImpl.TopicPresenterImpl;
import ui.activity.TopicActivity;

public class TopicActivityImpl extends AppCompatActivity implements TopicActivity {

    private TopicAdapter topicAdapter;
//    private ListView lvTopic;
    private GridView lvTopic;
    private TopicPresenter topicPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_activity);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Chọn mã đề");
        actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getApplicationContext(), R.color.toolbar2)));

        topicPresenter = new TopicPresenterImpl(TopicActivityImpl.this);
        topicPresenter.getListTopics();


    }

    @Override
    public void setListTopics(List<Topic> topics) {
        topicAdapter = new TopicAdapter(this, R.layout.topic_item, topics);
        lvTopic = findViewById(R.id.lvTopic);
        lvTopic.setAdapter(topicAdapter);
        topicAdapter.notifyDataSetChanged();

        lvTopic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Topic topic = topicAdapter.getItem(position);
                Intent intent = new Intent(TopicActivityImpl.this,TestExamActivityImpl.class);
                intent.putExtra("topicId",topic.getId().toString());
                startActivity(intent);
            }
        });
    }
}
