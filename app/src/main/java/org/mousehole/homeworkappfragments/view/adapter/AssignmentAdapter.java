package org.mousehole.homeworkappfragments.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.mousehole.homeworkappfragments.R;
import org.mousehole.homeworkappfragments.model.data.Assignment;
import org.mousehole.homeworkappfragments.presenter.AssignmentPresenterContract;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder> {

    private List<Assignment> assignmentList;

    public AssignmentAdapter(List<Assignment> assignmentList) {this.assignmentList=assignmentList;}

    public void updateAssignment(List<Assignment> assignments){
        assignmentList = assignments;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public AssignmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.assignment_item_layout,parent, false);
        return new AssignmentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AssignmentViewHolder holder, int position) {
        Assignment currentAssignment= assignmentList.get(position);
        holder.assignmentNameTextView.setText(currentAssignment.getAssignment_name());
        holder.assignmentDueTextView.setText(currentAssignment.getAssignment_due());
    }

    @Override
    public int getItemCount() {
        return assignmentList.size();
    }

    public class AssignmentViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.Assignmentitem_name_textview)
        TextView assignmentNameTextView;

        @BindView(R.id.Assignmentitem_dueDate_textview)
        TextView assignmentDueTextView;

        public AssignmentViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
