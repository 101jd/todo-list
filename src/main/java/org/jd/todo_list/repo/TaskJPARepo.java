package org.jd.todo_list.repo;

import org.jd.todo_list.model.Priority;
import org.jd.todo_list.model.Status;
import org.jd.todo_list.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskJPARepo extends JpaRepository<Task, Integer> {
    @Query("SELECT t FROM Task t WHERE t.id = :id")
    Optional<Task> getTaskById(@Param("id") int id);
    @Query("SELECT t FROM Task t " +
            "ORDER BY t.priority")
    List<Task> sortByPriority();

    @Query("SELECT t FROM Task t ORDER BY t.status")
    List<Task> sortByStatus();

    @Query("UPDATE Task t " +
            "SET t.description=:description, " +
            "t.id=:id, " +
            "t.date=:date, " +
            "t.priority=:priority, " +
            "t.status=:status, " +
            "t.deadline=:deadline " +
            "WHERE t.id=:id")
    Task updateTaskById(@Param("description") String description, @Param("priority") int priority,
                        @Param("status") int status, @Param("deadline") Date deadline,
                        @Param("date") LocalDate date,
                        @Param("id") int id);

//    @Query("DELETE FROM Task t WHERE t.id=:id")
//    void delete(@Param("id") int id);
}
