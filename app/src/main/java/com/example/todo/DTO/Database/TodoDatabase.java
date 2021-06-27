/**
 * @Author Mathew McPherson
 * @Date 04/06/2021
 */

package com.example.todo.DTO.Database;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.todo.DAL.DAO.TodoDao;
import com.example.todo.DTO.Models.Todo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Defines the RoomDatabase for the Todo Application
 * @see RoomDatabase
 */
@Database(entities = { Todo.class }, version = 1)
public abstract class TodoDatabase extends RoomDatabase {
    public abstract TodoDao todoDao();
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private static volatile TodoDatabase INSTANCE;

    public static TodoDatabase getDatabase(Context context) {
        if (INSTANCE == null){
            synchronized ( (TodoDatabase.class)) {
                if ( INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TodoDatabase.class, "todo_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }

        }
        return INSTANCE;
    }

    /**
     * Override the onOpen method to populate the database with initial test data.
     * For this sample, we clear the database every time it is created or opened.
     *
     * If you want to populate the database only when the database is created for the 1st time,
     * override RoomDatabase.Callback()#onCreate
     */
    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
//                  super.onCreate(db);

                    // If you want to keep the data through app restarts,
                    // comment out the following line.
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    /**
     * Populate the database in the background with initial test data
     */
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final TodoDao mDao;

        PopulateDbAsync(TodoDatabase db) {
            mDao = db.todoDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
// Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            mDao.deleteAll();
            Todo todo = new Todo("Wake up!");
            todo.setDetail("either set 2 alarm clocks or none");
            mDao.Insert(todo);

            Todo todo1 = new Todo("Drink coffee!");
            todo.setDetail("Use the liter mugs");
            mDao.Insert(todo1);

            Todo todo2 = new Todo("Ponder the duality of existence!");
            todo.setDetail("and plant trees");
            mDao.Insert(todo2);

            Todo todo3 = new Todo("make someone laugh");
            todo.setDetail("read a comic");
            mDao.Insert(todo3);

            return null;
        }
    }

}
