package org.mousehole.homeworkappfragments.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import org.mousehole.homeworkappfragments.R;
import org.mousehole.homeworkappfragments.model.data.Assignment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddAssignmentFragment extends Fragment {

    @BindView(R.id.assignment_name_edittext)
    EditText assignmentNameEditText;

    @BindView(R.id.due_date_edittext)
    EditText dueDateEditText;



    private AddAssignmentInterface addAssignmentInterface;

    public interface AddAssignmentInterface {
        void addAssignment(Assignment assignment);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        addAssignmentInterface = (AddAssignmentInterface) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.add_assignment_fragment_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }


    @OnClick(R.id.add_assignment_button)
    public void checkInAssignment (){

        String asssignmentName = assignmentNameEditText.getText().toString().trim();
        String dueDate = dueDateEditText.getText().toString().trim();

        Assignment newAssignment = new Assignment (asssignmentName,dueDate);

        addAssignmentInterface.addAssignment(newAssignment);

    }


}