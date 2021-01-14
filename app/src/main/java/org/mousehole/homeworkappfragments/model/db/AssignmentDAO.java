package org.mousehole.homeworkappfragments.model.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import org.mousehole.homeworkappfragments.model.data.Assignment;

import java.util.List;

@Dao
public interface AssignmentDAO {

    @Insert
    public void insertAssignment(Assignment... newAssignment);

    @Delete
    public void deleteAssignment(Assignment... oldAssignment);


    @Query("SELECT * FROM homework WHERE assignment_id = :assignmentID")

    public Assignment getAssignment (int assignmentID);

    @Query("SELECT * FROM homework")
    public List<Assignment> getAllAssignments();

    @Update
    public void updateAssignment(Assignment assignment);

}
