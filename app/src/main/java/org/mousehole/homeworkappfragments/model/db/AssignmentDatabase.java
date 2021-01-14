package org.mousehole.homeworkappfragments.model.db;

import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.RoomDatabase;

import org.mousehole.homeworkappfragments.model.data.Assignment;

@Database(version = 1, entities = {Assignment.class})

public abstract class AssignmentDatabase extends RoomDatabase{

    public static final String DATABASE_NAME = "homework.db";
    public abstract AssignmentDAO getAssignmentDAO();

}
