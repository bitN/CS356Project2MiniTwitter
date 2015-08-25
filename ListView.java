import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionEvent;


public class ListView implements View {
        DefaultListModel listModel = new DefaultListModel();
        
        //overload with elements?
        ListView(){
            listModel.addElement("List View");
        }
        ListView(String viewOf){
            listModel.addElement("List View  (" + viewOf + ")");
        }
        
        public void addEntry(String entry){
            listModel.addElement("--  " + entry);
        }
        
        public JScrollPane getListPane(){
            //Create the list and put it in a scroll pane.
            JList list = new JList(listModel);
            list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            //list.setSelectedIndex(0);
            //list.addListSelectionListener(this);
            list.setVisibleRowCount(5);//grows?
            JScrollPane listViewPane = new JScrollPane(list);
            return listViewPane;
        }
        
        public void actionPerformed(ActionEvent e) {
            //unfollow etc
        }
}
