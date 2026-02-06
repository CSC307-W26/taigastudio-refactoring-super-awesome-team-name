import dao.*;
import dao.Sprint.Designation;
import project.*;


public class SprintTests{
    public static void main(String[] args){
        NewSprintPanel panel=new NewSprintPanel();
        Sprint toTest=Blackboard.getInstance().getActiveSprint();
        UserStory story1=new UserStory("0", "test story", "this is a random story for testing");
        UserStory story2=new UserStory("1", "test story 2", "another random story for testing");
        toTest.addStory(story1);
        toTest.addStory(story2);
        toTest.addDesignation(story1, "Finley Room");
        toTest.addDesignation(story2, "Johnathan");
        assert(toTest.nextStory()==story1);
        assert(toTest.startNextStory().equals(new Designation("Finley Room", story1)));
        assert(toTest.startNextStory().equals(new Designation("Johnathan", story2)));
    }
}