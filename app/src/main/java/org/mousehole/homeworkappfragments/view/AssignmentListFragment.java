package org.mousehole.homeworkappfragments.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.mousehole.homeworkappfragments.R;
import org.mousehole.homeworkappfragments.model.data.Assignment;
import org.mousehole.homeworkappfragments.view.adapter.AssignmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AssignmentListFragment extends Fragment {

    @BindView(R.id.assignment_recyclerview)
    public RecyclerView assignmentRecyclerView;

    private AssignmentAdapter assignmentAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.assignment_list_fragment_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        assignmentAdapter = new AssignmentAdapter(new ArrayList<>());//Instantiate it with empty AList
        assignmentRecyclerView.setAdapter(assignmentAdapter);
    }
    public void displayList(List<Assignment> allAssignments) {
        assignmentAdapter.updateAssignment(allAssignments);
    }

}
