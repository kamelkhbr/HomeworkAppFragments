package org.mousehole.homeworkappfragments.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import org.mousehole.homeworkappfragments.R;
import org.mousehole.homeworkappfragments.model.data.Assignment;
import org.mousehole.homeworkappfragments.presenter.AssignmentPresenter;
import org.mousehole.homeworkappfragments.presenter.AssignmentPresenterContract;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AssignmentPresenterContract.AssignmentView, AddAssignmentFragment.AddAssignmentInterface {

    private AddAssignmentFragment addAssignmentFragment = new AddAssignmentFragment();

    private AssignmentPresenterContract.AssignmentPresenter presenter;

    private AssignmentListFragment assignmentListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignmentListFragment = (AssignmentListFragment) getSupportFragmentManager().findFragmentById(R.id.main_fragment);
        presenter = new AssignmentPresenter(this);
        presenter.getAllAssignment();

        loadAddAssignmentFragment();

    }

    private void loadAddAssignmentFragment() {
        //Fragment fragment =getSupportFragmentManager().beginTransaction(); // Different implementation
        getSupportFragmentManager().beginTransaction().add(R.id.main_frame,addAssignmentFragment)
                .addToBackStack(addAssignmentFragment.getTag())
                .commit();


    }

    @Override
    public void displayAssignments(List<Assignment> assignmentList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                assignmentListFragment.displayList(assignmentList);
            }
        });


    }

    @Override
    public void displaySuccess(String message) {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void addAssignment(Assignment assignment) {
        presenter.insertAssignment(assignment);
        Log.d("TAG_x", "addGuest: ");
        //presenter.getAllGuests();
    }
}