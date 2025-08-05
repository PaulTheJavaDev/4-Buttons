package de.hup.home.plan;

import de.hup.home.login.LoginFrame;
import de.hup.home.ui.LessionBlock;
import de.hup.home.ui.LessionBlock;
import de.hup.home.users.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The PlannerDashBoard shows the weekly overview for students.
 * TODO: Das ist eine Aufgabe
 * FIXME: Das ist ein Bug
 *
 */
public class PlannerDashBoard {

    private static final int FRAME_WIDTH = 1500;
    private static final int FRAME_HEIGHT = 800;

    private JPanel weekPlanContainer;

    public PlannerDashBoard() {
        initializeMainDashboard();
        PlannerBlock plannerBlock = new PlannerBlock(5,5);
    }

    /**
     * Initialises The Main-Dashboard for Students
     */
    private void initializeMainDashboard() {
        //closing login window
        LoginFrame.disposeLoginFrame();

        //only visible for students
        Role currentUserRole = UserManager.getCurrentUser().role;
        if (!currentUserRole.equals(Role.STUDENT)) {
            return;
        }

        JFrame mainDashboard = new JFrame("Main Dashboard");
        mainDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainDashboard.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        mainDashboard.setResizable(false);
        mainDashboard.setLayout(null);

        weekPlanContainer = new JPanel(null);
        weekPlanContainer.setBounds(150, 125, 1200, 500);
        weekPlanContainer.setBackground(Color.BLACK);

        mainDashboard.add(weekPlanContainer);

        //Weekdays creation
        createWeekDayPlanner();

        mainDashboard.setVisible(true);
    }

    /**
     * Creates the panels for the 5 week-days
     */
    int weekDays = 5;
    private void createWeekDayPlanner() {
        int xPositionStartValue = 10;

        for (int i = 0; i < weekDays; i++) {
            createDayColumn(xPositionStartValue, 0, 220, 500);
            xPositionStartValue += 240;
        }
    }

    /**
     * Creates a daily column with class and break blocks.
     */
    private JPanel createDayColumn(int x, int y, int width, int height) {
        JPanel dayPanel = new JPanel(null);
        dayPanel.setBounds(x, y, width, height);
        dayPanel.setBackground(new Color(0, 0, 255));
        weekPlanContainer.add(dayPanel);

        JPanel panel = (createTimeBlock(0, 0, width, 150));

        dayPanel.add(panel);
        //createEditableSubjectFrame(panel);

        LessionBlock classBlock =       new LessionBlock(dayPanel, 0, 150, width, 35);
        LessionBlock breakBlock =       new LessionBlock(dayPanel, 0, 185, width, 150);
        LessionBlock secondClassBlock = new LessionBlock(dayPanel, 0, 335, width, 35);
        LessionBlock secondBreakBlock = new LessionBlock(dayPanel, 0, 370, width, 150);
        //LessionBlock thirdClassBlock =  new LessionBlock(dayPanel, 0, );

        return dayPanel;
    }

    /**
     * Creates a time block for each different classes
     */
    private JPanel createTimeBlock(int x, int y, int width, int height) {
        JPanel timeBlock = new JPanel(null);
        timeBlock.setBounds(x, y, width, height);
        timeBlock.setBackground(Color.YELLOW);
        return timeBlock;
    }


    //private void createEditableSubjectFrame(final JPanel subjectPanel) {
    //        JPanel subjectFrame = new JPanel(null);
    //        subjectFrame.setBounds(subjectPanel.getX() + subjectPanel.getWidth() + 10, subjectPanel.getY(), 220, 150);
    //        subjectFrame.setBackground(Color.LIGHT_GRAY);
    //        subjectFrame.setVisible(false);
    //
    //        weekPlanContainer.add(subjectFrame); // Add the frame to the container so it can be shown
    //
    //        subjectFrame.addMouseListener(new MouseAdapter() {
    //            @Override
    //            public void mouseExited(MouseEvent e) {
    //                subjectFrame.setVisible(false);
    //            }
    //
    //            @Override
    //            public void mouseEntered(MouseEvent e) {
    //                subjectFrame.setVisible(true);
    //            }
    //        });
    //    }
}
