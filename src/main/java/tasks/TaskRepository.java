package tasks;

import dao.Task;

/**
 * Interface for task storage operations.
 * Used for dependency injection to decouple from Blackboard.
 *
 * @author Collin Howard
 * @version 1.0
 */
public interface TaskRepository {
	void addTask(Task task);
	int getTaskCount();
}
