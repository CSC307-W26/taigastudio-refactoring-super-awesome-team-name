package dao;

/**
 * Simple task object right now. Nothing much aside from just being a way to treat things in OOP way for how tasks should be
 * at the moment this is just my own implementation, this code will be obsolete and be placed inside the blackboard
 * 
 * @author Kevin Mokarapiromya
 */
public class KMTasks {
    
    private String taskInfo;

    public KMTasks(String taskInfo) {
        this.taskInfo = taskInfo;
    }

    public String getTaskInfo() {
        return this.taskInfo;
    }

    @Override
    public String toString() {
        return this.taskInfo;
    }

}
