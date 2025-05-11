package ra.dao;

import ra.model.Task;
import ra.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImp implements TaskDAO{

    @Override
    public List<Task> findAllTask() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Task> tasks = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call findAllTasks()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getInt("id"));
                task.setDescription(rs.getString("description"));
                task.setCompleted(rs.getBoolean("status"));
                task.setDueDate(rs.getString("due_date"));
                tasks.add(task);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return tasks;
    }


    @Override
    public void saveTask(Task task) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call saveTask(?, ?)}");
            callSt.setString(1, task.getDescription());
            callSt.setBoolean(2, task.isCompleted());
            callSt.executeUpdate();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }
    @Override
    public Task findTaskById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Task task = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call findTaskById(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                task = new Task();
                task.setId(rs.getInt("id"));
                task.setDescription(rs.getString("description"));
                task.setCompleted(rs.getBoolean("status"));
                task.setDueDate(rs.getString("due_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return task;
    }

    @Override
    public void updateTask(Task task) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call updateTask(?, ?, ?)}");
            callSt.setInt(1, task.getId());
            callSt.setString(2, task.getDescription());
            callSt.setBoolean(3, task.isCompleted());
            callSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public void deleteTask(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call deleteTask(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }
}
