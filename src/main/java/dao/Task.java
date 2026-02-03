package dao;

import java.util.Date;

/**
 * This class represents a task
 *
 * @author ALEXANDER BLOOMER
 * @version 1.0
 */
public class Task{
    
    private String id;
    private String subject;
    private String body;

    private Date completionDate;
    
    public Task(String id, String subject, String body){
        this.subject = subject;
        this.body = body;
        this.id = id;
    }

    @Override
    public String toString(){
        return id + ":" + subject + ":" + body;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }
}