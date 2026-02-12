package project;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;

import dao.*;

import java.awt.*;
import java.util.Date;

/**
 * Screen to enter information about a new Sprint being added to the project
 *
 * Finley Room
 * version 1.0
 */
public class NewSprintPanel extends JFrame {
    private JTextField name;
    private JTextField startDate;
    private JTextField endDate;
    private JButton makeSprint;
    DateFormat formatter=new SimpleDateFormat("MM/dd/yy");

    public NewSprintPanel(){
        super("Create New Sprint");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JPanel row1=new JPanel(new FlowLayout());
        name=new JTextField(30);
        row1.add(new JLabel("Name:"));
        row1.add(name);

        JPanel row2=new JPanel(new FlowLayout());
        startDate=new JTextField(10);
        endDate=new JTextField(10);
        row2.add(new JLabel("Start Date: "));
        row2.add(startDate);
        row2.add(new JLabel("End Date: "));
        row2.add(endDate);

        JPanel row3=new JPanel(new FlowLayout());
        makeSprint=new JButton("Create Sprint");
        makeSprint.addActionListener(e->submit());

        add(row1);
        add(row2);
        add(row3);

        setVisible(true);
    }


    public void submit(){
        String sprintName=name.getText();
        String start=startDate.getText();
        String end=endDate.getText();
        try{
            Date startDate=formatter.parse(start);
            Date endDate=formatter.parse(end);
            Blackboard.getInstance().getActiveProject().setActiveSprint(new Sprint(startDate, endDate));
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Likely entered incorrect date format try MM/dd/yy");
        }
    }
}
