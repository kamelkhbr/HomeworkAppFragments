package org.mousehole.homeworkappfragments.presenter;

import android.content.Context;

import org.mousehole.homeworkappfragments.model.data.Assignment;

import java.util.List;

public interface AssignmentPresenterContract {

    interface AssignmentPresenter{
        void insertAssignment(Assignment assignment);
        void deleteAssignment (Assignment assignment);
        void getAllAssignment();
    }

    interface AssignmentView{
        void displayAssignments(List<Assignment> assignmentList);
        void displaySuccess ( String message);
        Context getContext();
    }

}
