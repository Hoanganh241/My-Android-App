package ui.fragment;

import java.util.List;

public interface QuestionFragment {
    boolean isRightAnswer();

    void setRightAnswer(boolean rightAnswer);

    List<Integer> getCheckedAnswers();

    void setCheckedAnswers(List<Integer> checkedAnswers);

    void addEvents();

    void hienThiAnswer();

    void addControls();

    boolean traLoiDung();

    void xuLyAnHienAnswerDung(boolean isHide);

    void xuLyLuuAnswerDuocChon();

}
