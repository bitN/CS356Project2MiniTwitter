
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.tree.*;
import java.lang.*;
import java.util.*;

public class UserView implements View {
    
    //declaration of global variables
    //JLabel display = new JLabel("0", JLabel.RIGHT);
    private JFrame uView = new JFrame("User View");
    //list View Current Following
    //List View News Feed
    private JTextArea usrID = new JTextArea("User ID");
    private JTextArea tweetText = new JTextArea("Tweet Message");
    private JButton followUser = new JButton("Follow User");
    private JButton postTweet = new JButton("Post Tweet");
    private ArrayList<User> followings = new ArrayList<User>();
    private ListView curFollowings = new ListView("Currently Following");
    private ListView newsFeed = new ListView("News Feed");

    //argh
    //String uID
    //private MiniTwitterFeed uFeed

    public UserView() {

        //Add action listeners.
        followUser.addActionListener(this);
        postTweet.addActionListener(this);

        //Specify FlowLayout for the layout manager.
        uView.getContentPane().setLayout(new FlowLayout());

        //Give the frame an initial size.
        uView.setSize(500, 500);

        //Terminate the program when the user closes the application.
        uView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add the Label and buttons
        uView.add(BorderLayout.NORTH, usrID);
        uView.add(BorderLayout.NORTH, followUser);
        //CurrentFollowingList (CENTER_
        uView.add(BorderLayout.CENTER, curFollowings.getListPane());
        uView.add(BorderLayout.SOUTH, tweetText);
        uView.add(BorderLayout.SOUTH, postTweet);
        //NewsFeedList View
        uView.add(BorderLayout.SOUTH, newsFeed.getListPane());
        //uView.add(BorderLayout.SOUTH, showMsgTotal);

        //set the default button
        //uView.getRootPane().setDefaultButton(usrView);
        //center the frame
        uView.setLocationRelativeTo(null);
        
        //don't exit the whole program when a single userView is closed
        uView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Display the frame
        uView.setVisible(true);
    }

    public void followUser(String uID){
        curFollowings.addEntry(uID);
    }
    
    public void postTweet(String tweet){
       //post Name: Tweet
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Follow User")) {
            followUser(usrID.getText());
        } else {
            if (ae.getActionCommand().equals("Post Tweet")) {
                postTweet(tweetText.getText());
            }
        }
        uView.revalidate();
        uView.repaint();
    }

}
