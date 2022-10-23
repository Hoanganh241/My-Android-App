package ui.fragmentImpl;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;

import model.ExamPrinciple;
import ui.fragment.PrincipleTabFragment;

public class PrincipleTab2FragmentImpl extends Fragment implements PrincipleTabFragment {

    private ExamPrinciple examPrinciple;

    private View view;
    private TextView txtExamExperience;

    public static PrincipleTab2FragmentImpl getInstance(ExamPrinciple examPrinciple) {
        PrincipleTab2FragmentImpl myFragment = new PrincipleTab2FragmentImpl();
        myFragment.examPrinciple = examPrinciple;
        return myFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.exam_principle_tab2_fragment, container, false);
        txtExamExperience = view.findViewById(R.id.txtExamExperience);
        display();
        return view;
    }

    @Override
    public void display() {
        String fullText = examPrinciple.getContent();

        Spannable spannable = new SpannableString(fullText);
        ForegroundColorSpan fcsBlue = new ForegroundColorSpan(getResources().getColor(R.color.colorPrimaryDark));
        ForegroundColorSpan fcsBlack = new ForegroundColorSpan(getResources().getColor(R.color.black));
        RelativeSizeSpan rss15 = new RelativeSizeSpan(0.75f);
        RelativeSizeSpan rss20 = new RelativeSizeSpan(1f);
        StyleSpan boldSpan = new StyleSpan(Typeface.BOLD);

        spannable.setSpan(boldSpan, 0, 10, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannable.setSpan(rss20, 0, 10, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannable.setSpan(fcsBlack, 10, fullText.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        spannable.setSpan(rss15, 10, fullText.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        txtExamExperience.setText(spannable);
    }
}
