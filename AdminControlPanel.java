import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.tree.*;
import java.lang.*;
import java.util.*;

public class AdminControlPanel implements ControlPanel {

    //declaration of global variables
    //JLabel display = new JLabel("0", JLabel.RIGHT);
    private JFrame adminUI = new JFrame("Administrator Control Panel");
    private JTextArea usrID = new JTextArea("User ID");
    private JTextArea grpID = new JTextArea("Group ID");
    private JButton addUSR = new JButton("Add User");
    private JButton addGRP = new JButton("Add Group");
    private JButton usrView = new JButton("Open User View");
    private JButton showUsrTotal = new JButton("Show User Total");
    private JButton showGrpTotal = new JButton("Show Group Total");
    private JButton showMsgTotal = new JButton("Show Messages Total");
    private JButton showPosPerc = new JButton("Show postivite percentage");
    private static final AdminControlPanel INSTANCE = new AdminControlPanel();
    private TreeView adminTree = new TreeView();
    private ArrayList<User> userRecord = new ArrayList<User>();
    private ArrayList<String> groupIDs = new ArrayList<String>();

    public static AdminControlPanel getInstance() {
        return INSTANCE;
    }

    private AdminControlPanel() {
        //declaration of frame

        //Add action listeners.
        addUSR.addActionListener(this);
        addGRP.addActionListener(this);
        usrView.addActionListener(this);
        showUsrTotal.addActionListener(this);
        showGrpTotal.addActionListener(this);
        showMsgTotal.addActionListener(this);
        showPosPerc.addActionListener(this);

        //Specify FlowLayout for the layout manager.
        adminUI.getContentPane().setLayout(new FlowLayout());

        //Give the frame an initial size.
        adminUI.setSize(500, 500);

        //Terminate the program when the user closes the application.
        adminUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add the Label and buttons
        //adminUI.add(display);
        adminUI.add(BorderLayout.WEST, adminTree.getTreePane());
        //adminUI.getContentPane().add(treeView, BorderLayout.WEST);
        adminUI.add(BorderLayout.NORTH, usrID);
        adminUI.add(BorderLayout.NORTH, addUSR);
        adminUI.add(BorderLayout.CENTER, grpID);
        adminUI.add(BorderLayout.CENTER, addGRP);
        adminUI.add(BorderLayout.NORTH, usrView);
        adminUI.add(BorderLayout.SOUTH, showUsrTotal);
        adminUI.add(BorderLayout.SOUTH, showGrpTotal);
        adminUI.add(BorderLayout.SOUTH, showMsgTotal);
        adminUI.add(BorderLayout.SOUTH, showPosPerc);

        //set the default button
        //adminUI.getRootPane().setDefaultButton(usrView);
        //center the frame
        adminUI.setLocationRelativeTo(null);

        //Display the frame
        adminUI.setVisible(true);
    }

    //add user to Users, add to display tree
    private void addUser(String uID, String gID) {
        MiniTwitterUser newU = new MiniTwitterUser(uID);
        userRecord.add(newU);
        adminTree.addUserTree(uID, gID, groupIDs);
    }

    private void addGroup(String gID) {
        groupIDs.add(gID);
        adminTree.addGroupTree(gID);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Add User")) {
            addUser(usrID.getText(), grpID.getText());
        } else {
            if (ae.getActionCommand().equals("Add Group")) {
                addGroup(grpID.getText());
            } else {
                if (ae.getActionCommand().equals("Open User View")) {
                    //Create the frame on the event dispatching thread
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            UserView uV = new UserView();
                        }
                    });
                } else {
                    if (ae.getActionCommand().equals("Show User Total")) {
                        JOptionPane.showMessageDialog(null, "The number of users is: " + userRecord.size());
                    } else {
                        if (ae.getActionCommand().equals("Show Group Total")) {
                        JOptionPane.showMessageDialog(null, "The number of groups is: " + groupIDs.size());
                        } else {
                            if (ae.getActionCommand().equals("Show Messages Total")) {
                                //for each user get post count?
                            } else {
                                if (ae.getActionCommand().equals("Show postivite percentage")) {
                                }
                            }
                        }
                    }
                }

            }
        }
        adminUI.revalidate();
        adminUI.repaint();
    }
}
