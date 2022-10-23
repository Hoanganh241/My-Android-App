package ui.activityImpl;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TabHost;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import adapter.ExamPrincipleAdapter;
import adapter.SectionsPageAdapter;
import model.ExamPrinciple;
import presenter.ExamPrinciplePresenter;
import presenterImpl.ExamPrinciplePresenterImpl;
import ui.activity.ExamPrincipleActivity;
import ui.fragmentImpl.PrincipleTab1FragmentImpl;
import ui.fragmentImpl.PrincipleTab2FragmentImpl;

public class ExamPrincipleActivityImpl extends AppCompatActivity implements ExamPrincipleActivity {

    private ExamPrincipleAdapter examPrincipleAdapter;
    private ListView listPrinciple;
    private TabHost principleTab;
    private ViewPager mViewPager;

    private List<Fragment> fragments = new ArrayList<Fragment>();
    private List<ExamPrinciple> examPrinciples;

    private SectionsPageAdapter mSectionsPageAdapter;
    private ExamPrinciplePresenter examPrinciplePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_principle_activity);

        examPrinciplePresenter = new ExamPrinciplePresenterImpl(ExamPrincipleActivityImpl.this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Giới thiệu thi thực hành");
        actionBar.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getApplicationContext(),R.color.toolbar2)));

        // Set up the ViewPager with the sections adapter.
//        mViewPager = findViewById(R.id.container);
//        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

//        setupViewPager(mViewPager);

//        TabLayout tabLayout = findViewById(R.id.principleTab);
//        tabLayout.setupWithViewPager(mViewPager);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
//        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.principleTab);
        tabLayout.setupWithViewPager(mViewPager);

        examPrinciplePresenter.getListExamPrinciples();

    }

    @Override
    public void setListExamPrinciples(List<ExamPrinciple> examPrinciples) {
        this.examPrinciples = examPrinciples;
//        for (int i = 0; i < examPrinciples.size(); i++) {
//            mSectionsPageAdapter.addFragment(QuestionFragmentImpl.getInstance(i+1, questions.get(i), "False", task), title);
//        }
        mSectionsPageAdapter.addFragment(PrincipleTab1FragmentImpl.getInstance(examPrinciples.get(1)), "Luật thi");
        mSectionsPageAdapter.addFragment(PrincipleTab2FragmentImpl.getInstance(examPrinciples.get(0)), "Kinh nghiệm thi");

        mViewPager.setAdapter(mSectionsPageAdapter);
        mSectionsPageAdapter.notifyDataSetChanged();
    }

//    private void setupViewPager(ViewPager viewPager) {
//        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
//        adapter.addFragment(new PrincipleTab1FragmentImpl(), "TAB1");
//        adapter.addFragment(new PrincipleTab2FragmentImpl(), "TAB2");
//        viewPager.setAdapter(adapter);
//    }
}
