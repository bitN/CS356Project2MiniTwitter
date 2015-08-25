import java.awt.event.ActionEvent;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.HashMap;

public class TreeView implements View {

    private DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root Group");
    private JTree usrTree = new JTree(rootNode);
    private int leafNum = 0;
    private HashMap<String, Integer> groupRecord = new HashMap<String, Integer>();

    public JScrollPane getTreePane() {
        usrTree.setRootVisible(true);
        
        JScrollPane treeViewPane = new JScrollPane(usrTree);
        return treeViewPane;
    }

    //Comeback to here
    public void addUserTree(String uID, String gID, ArrayList<String> groupIDs) {
        DefaultMutableTreeNode uLeaf = new DefaultMutableTreeNode(uID, false);
        if (groupIDs.contains(gID)) {
            //rootNode.getChildAt(groupRecord.get(gID)).add(uLeaf);
            //Vector<DefaultMutableTreeNode> vtor = rootNode.children;
            //gID.add(uLeaf);
        } else {
            rootNode.add(uLeaf);
        }
        leafNum++;
    }

    public void addGroupTree(String gID) {
        DefaultMutableTreeNode newG = new DefaultMutableTreeNode(gID);
        rootNode.add(newG);
        leafNum++;
        groupRecord.put(gID, leafNum);
    }

    public void actionPerformed(ActionEvent e) {
        //unfollow etc
    }
}
