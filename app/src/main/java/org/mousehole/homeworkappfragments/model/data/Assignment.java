package org.mousehole.homeworkappfragments.model.data;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "homework")

public class Assignment {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo (name="assignment_id")
    private int assignmentID;

    @ColumnInfo(name="assignment_name")
    private String assignment_name;

    @ColumnInfo(name = "assignment_due")
    private String assignment_due;

    public Assignment(int assignmentID, String assignment_name, String assignment_due) {
        this.assignmentID = assignmentID;
        this.assignment_name = assignment_name;
        this.assignment_due = assignment_due;
    }

    @Ignore
    public Assignment(String assignment_name, String assignment_due) {
        this.assignment_name = assignment_name;
        this.assignment_due = assignment_due;
    }

    public int getAssignmentID() {
        return assignmentID;
    }

//    public void setAssignmentID(int assignmentID) {
//        this.assignmentID = assignmentID;
//    }

    public String getAssignment_name() {
        return assignment_name;
    }

    public void setAssignment_name(String assignment_name) {
        this.assignment_name = assignment_name;
    }

    public String getAssignment_due() {
        return assignment_due;
    }

    public void setAssignment_due(String assignment_due) {
        this.assignment_due = assignment_due;
    }
}
