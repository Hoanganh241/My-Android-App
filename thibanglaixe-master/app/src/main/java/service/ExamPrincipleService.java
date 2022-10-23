package service;

import model.ExamPrinciple;
import serviceCallback.ListDataCallback;

public interface ExamPrincipleService {
    public void getListExamPrinciples(ListDataCallback<ExamPrinciple> callback);
}
