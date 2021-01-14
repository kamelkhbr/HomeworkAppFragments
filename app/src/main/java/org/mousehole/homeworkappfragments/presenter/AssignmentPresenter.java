package org.mousehole.homeworkappfragments.presenter;

import androidx.room.Room;

import org.mousehole.homeworkappfragments.model.data.Assignment;
import org.mousehole.homeworkappfragments.model.db.AssignmentDatabase;

import static org.mousehole.homeworkappfragments.model.db.AssignmentDatabase.DATABASE_NAME;

public class AssignmentPresenter implements AssignmentPresenterContract.AssignmentPresenter {

    private AssignmentPresenterContract.AssignmentView view;
    private AssignmentDatabase assignmentDatabase;


    public AssignmentPresenter(AssignmentPresenterContract.AssignmentView view){
        this.view = view;
        assignmentDatabase = Room.databaseBuilder(
                view.getContext(),
                AssignmentDatabase.class,
                DATABASE_NAME
        ).build();
    }

    @Override
    public void insertAssignment(Assignment assignment) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                assignmentDatabase.getAssignmentDAO().insertAssignment(assignment);
                view.displaySuccess("Assignment Added successfully");
                view.displayAssignments(assignmentDatabase.getAssignmentDAO().getAllAssignments());

            }
        }.start();


    }

    @Override
    public void deleteAssignment(Assignment assignment) {

        new Thread(){
            @Override
            public void run() {
                super.run();
                assignmentDatabase.getAssignmentDAO().deleteAssignment(assignment);
                view.displaySuccess("Assignment Deleted! YOU'RE FREE");
            }
        }.start();

    }

    @Override
    public void getAllAssignment() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                view.displayAssignments(assignmentDatabase.getAssignmentDAO().getAllAssignments());
            }
        }.start();

    }
}
