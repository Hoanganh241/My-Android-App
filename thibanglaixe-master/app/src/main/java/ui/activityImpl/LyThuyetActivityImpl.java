package ui.activityImpl;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import adapter.CustomPagerAdapter;
import model.Question;
import presenter.QuestionPresenter;
import presenterImpl.QuestionPresenterImpl;
import ui.activity.BaseQuestionActivity;
import ui.fragmentImpl.QuestionFragmentImpl;

public class LyThuyetActivityImpl extends AppCompatActivity implements BaseQuestionActivity {


    private ViewPager viewPager;

    private List<Fragment> fragments = new ArrayList<Fragment>();
    private List<Question> questions;

    private QuestionPresenter questionPresenter;
    private CustomPagerAdapter pagerAdapter;

    private static final String task = "ly_thuyet";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ly_thuyet_activity);

        questionPresenter = new QuestionPresenterImpl(LyThuyetActivityImpl.this);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Ôn câu lý thuyết");
        actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getApplicationContext(), R.color.toolbar2)));
        viewPager = findViewById(R.id.vpLyThuyet);
        FragmentManager manager = getSupportFragmentManager();
        pagerAdapter = new CustomPagerAdapter(manager);
        //CustomPagerAdapter pagerAdapter=new CustomPagerAdapter(manager,fragments);
        viewPager.setAdapter(pagerAdapter);
        fragments.add(new QuestionFragmentImpl());

        questionPresenter.getListQuestion(task, "");
        fragments.clear();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setListQuestion(List<Question> questions) {
        this.questions = questions;
        Collections.shuffle(questions);
        for (int i = 0; i < questions.size(); i++) {
            int maCauHoi = questions.get(i).getId();
            String title = "Câu " + maCauHoi;
            pagerAdapter.addFragment(QuestionFragmentImpl.getInstance(i+1, questions.get(i), "False", task), title);
        }
        pagerAdapter.notifyDataSetChanged();
    }

}