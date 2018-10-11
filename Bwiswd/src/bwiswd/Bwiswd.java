package bwiswd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.BorderFactory;

/**
 @author Patryk
 */
public class Bwiswd  {
    JFrame frame;
    JButton sendButton = new JButton("Send your data to the knowledge base");
    JButton resetButton = new JButton("Reset Button");
    JPanel panel;
    JPanel small1, small2, small3, small4, small5, small6, small7, small8, small9;
    JLabel bigLabel;
    JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9;
    JList list1, list2, list3, list4,list5, list7, list8, list9;
    double p, c, f, kcal;
    Font bigFont;
    JCheckBox check1, check2, check3, check4;
    JTextArea area;
    JTextField field;
    String[] gender = {"Male", "Female"};
    String[] activity = {"0","1","2","3","4"};
    String[] goals = {"Cut", "Recomp", "Strength", "Bulk"};
    String[] times = {"3","4","5","6"};
    String[] body = {"ekto", "mezo", "endo"};
    String[] eight = {"yes", "no"};
    String[] nine = {"young", "midage", "old"};
    
    public static void main(String[] args) {
        Bwiswd main = new Bwiswd();
        main.guiBuild();
        main.GuiMenuBar();
    }
    public void guiBuild() {
        frame = new JFrame("BWISWD");
        frame.setSize(820,650);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        bigLabel = new JLabel("Ultimate equipment for exercising people");
        Font bigFont = new Font("sanserif", Font.BOLD, 24);
        bigLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        bigLabel.setFont(bigFont);
        bigLabel.setHorizontalAlignment(JLabel.CENTER);
        frame.getContentPane().add(BorderLayout.NORTH, bigLabel);
        
        sendButton.addActionListener( new BottomButtonListener());
        frame.getContentPane().add(BorderLayout.SOUTH, sendButton);
        
        panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        small1 = new JPanel();
        label1 = new JLabel("Choose your sex");
        small1.add(label1);
        list1 = new JList(gender);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.addListSelectionListener( new GenderListener());
        small1.add(list1);
        small1.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(small1);
        
        
        small2 = new JPanel();
        label2 = new JLabel("Choose your activity level");
        small2.add(label2);
        list2 = new JList(activity);
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list2.addListSelectionListener( new ActivityListener());
        small2.add(list2);
        small2.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(small2);
        
        small5 = new JPanel();
        label5 = new JLabel("How many times per week you working out");
        small5.add(label5);
        list5 = new JList(times);
        list5.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list5.addListSelectionListener( new TimesListener() );
        small5.add(list5);
        small5.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(small5);
        
        
        
        small3 = new JPanel();
        label3 = new JLabel("Choose your goals");
        small3.add(label3);
        list3 = new JList(goals);
        list3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list3.addListSelectionListener( new GoalsListener());
        small3.add(list3);
        small3.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(small3);
        
        small7 = new JPanel();
        label7 = new JLabel("Type of your body");
        small7.add(label7);
        list7 = new JList(body);
        list7.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list7.addListSelectionListener( new BodyListener());
        small7.add(list7);
        small7.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(small7);
        
        small8 = new JPanel();
        label8 = new JLabel("Are you like protein");
        small8.add(label8);
        list8 = new JList(eight);
        list8.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list8.addListSelectionListener( new EightListener() );
        small8.add(list8);
        small8.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(small8);
        
        small9 = new JPanel();
        label9 = new JLabel("How is your age");
        small9.add(label9);
        list9 = new JList(nine);
        list9.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list9.addListSelectionListener( new NineListener() );
        small9.add(list9);
        small9.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(small9);
        
        small4 = new JPanel();
        label4 = new JLabel("Few Aditional questions");
        small4.add(label4);
        check1 = new JCheckBox("Are you ease geting weight");
        check1.addItemListener( new WeightListener());
        small4.add(check1);
        check2 = new JCheckBox("Are you using suplements");
        check2.addItemListener( new SupListener());
        small4.add(check2);
        check3 = new JCheckBox("Are you healthy");
        check3.addItemListener( new HealthListener());
        small4.add(check3);
        check4 = new JCheckBox("Are you using heavy weights");
        check4.addItemListener ( new PlatesListener() );
        small4.add(check4);
        //small4.setBackground(Color.BLUE);
        small4.setLayout(new BoxLayout(small4, BoxLayout.Y_AXIS));
        small4.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.add(small4);
        
        
        
                     
        
        frame.getContentPane().add(BorderLayout.WEST, panel);
        
        area = new JTextArea(10,20);
        area.setLineWrap(true);
        area.setText("Your Name and results : ");
        area.setBorder(BorderFactory.createLineBorder(Color.black));
        frame.getContentPane().add(BorderLayout.EAST, area);
        
        small6 = new JPanel();
        label6 = new JLabel("Please type your Name");
        small6.add(label6);
        field = new JTextField(20);
        small6.add(field);
        small6.add((new JLabel(new ImageIcon("./pudzianek.PNG"))));
        resetButton.addActionListener( new ResetButtonListener());
        small6.add(resetButton);
        frame.getContentPane().add(BorderLayout.CENTER,small6);
        
    }
    public void GuiMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu1 = new JMenu("File");
        JMenu fileMenu2 = new JMenu("Settings");
        JMenu fileMenu3 = new JMenu("View");
        JMenu fileMenu4 = new JMenu("About");
        
        JMenuItem menuItem1 = new JMenuItem("New");
        JMenuItem menuItem2 = new JMenuItem("Save");
        JMenuItem menuItem3 = new JMenuItem("Load");
        JMenuItem menuItem4 = new JMenuItem("Exit");
        JMenuItem menuItem5 = new JMenuItem("About");
        
        menuItem4.addActionListener( new ExitMenuItemListener());
        
        fileMenu1.add(menuItem1);
        fileMenu1.add(menuItem2);
        fileMenu1.add(menuItem3);
        fileMenu1.add(menuItem4);
        
        menuBar.add(fileMenu1);
        menuBar.add(fileMenu2);
        menuBar.add(fileMenu3);
        menuBar.add(fileMenu4);
        
        frame.setJMenuBar(menuBar);
    }
    
    class  BottomButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev1) {
            kcal = 4*p + 4*c + 9*f;
            area.setText("");
            area.append(field.getText());
            
            area.append("\nYou should eat proteins :\n" + (p+30));
            area.append("\nYou should eat carbs :\n" + c);
            area.append("\nYou should eat fats :\n" + f);
            area.append("\nIt makes total kcal :\n" + kcal);
        }
    }
    class GenderListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent lse1) {
           if( !lse1.getValueIsAdjusting()) {
               String selection1 = (String) list1.getSelectedValue();
               if (selection1.equals("Female")) {
                   kcal = 2000;
                   p = 100;
                   f = 75;
                   c = (kcal - 4*p - 9*f)/4; 
               }
               else if (selection1.equals("Male")) {
                   kcal = 2500;
                   p = 140;
                   f = 100;
                   c = (kcal - 4*p - 9*f)/4;
               }
           } 
        }
    }
    class EightListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent lse1) {
           if( !lse1.getValueIsAdjusting()) {
               
           }
        }
    }
    class NineListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent lse1) {
           if( !lse1.getValueIsAdjusting()) {
               
           }
        }
    }
    class ActivityListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent lse2) {
           if( !lse2.getValueIsAdjusting()) {
               String selection2 = (String) list2.getSelectedValue();
               int choose1 = Integer.parseInt(selection2);
               switch(choose1) {
                   case 0: p-=0.2*p;
                           c-=0.2*c;
                           f-=0.2*f;
                         break;
                   case 1: p-=0.1*p;
                           c-=0.1*c;
                           f-=0.1*f;
                         break;
                   case 2: 
                         break;
                   case 3: p+=0.1*p;
                           c+=0.1*c;
                           f+=0.1*f;
                         break;
                   case 4: p+=0.2*p;
                           c+=0.2*c;
                           f+=0.2*f;
                         break;
                   
               }
           }
        }
    }
    class GoalsListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent lse3) {
           if( !lse3.getValueIsAdjusting()) {
               String selection3 = (String) list3.getSelectedValue();
               if (selection3.equals("Cut")) {
                   p-=0.05*p;
                   c-=0.3*c;
                   f-=0.2*f;
               }
               else if (selection3.equals("Recomp")) {
                   p+=0.05*p;
                   c-=0.15*c;
                   f-=0.05*f;
               }
               else if (selection3.equals("Strength")) {
                   p+=0.1*p;
                   c+=0.1*c;
                   f+=0.1*f;
               }
               else if (selection3.equals("Bulk")) {
                   p+=0.05*p;
                   c+=0.6*c;
                   f+=0.1*f;
               }
           }
        }
    }
    class WeightListener implements ItemListener {
        public void itemStateChanged(ItemEvent ev2) {
            if (check1.isSelected()) {
                p-=0.075*p;
                c-=0.075*c;
                f-=0.075*f;  
            }
            
        }
    }
    class SupListener implements ItemListener {
        public void itemStateChanged(ItemEvent ev3) {
            if (check2.isSelected()) {
                p+=0.075*p;
                c+=0.075*c;
                f+=0.075*f;  
            }
            
        }
    }
    class HealthListener implements ItemListener {
        public void itemStateChanged(ItemEvent ev2) {
            if (check1.isSelected()) {
                p-=0.05*p;
                c-=0.05*c;
                f-=0.05*f;  
            }
            
        }
    }
    class TimesListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent lse4) {
            if( !lse4.getValueIsAdjusting()) {
               String selection5 = (String) list5.getSelectedValue();
               switch(selection5) {
                   case "3" :
                       p-=0.025*p;
                       c-=0.05*c;
                       f-=0.025*f;
                       break;
                    case "4" :
                       break;
                    case "5" :
                        p+=0.025*p;
                        c+=0.05*c;
                        f+=0.025*f;
                       break;
                    case "6" :
                        p+=0.05*p;
                        c+=0.05*c;
                        f+=0.05*f;
                       break;
               }
            }
        }
    }
    class PlatesListener implements ItemListener {
        public void itemStateChanged(ItemEvent ev4) {
            if (check4.isSelected()) {
                p+=0.075*p;
                c+=0.075*c;
                f+=0.075*f;   
            }
        }
    }
    class  ResetButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ev7) {
            check1.setSelected(false);
            check2.setSelected(false);
            check3.setSelected(false);
            check4.setSelected(false);
            
            p=0;
            f=0;
            c=0;
            kcal=0;
            
            area.setText("");
            field.setText("");
           
        }
    }
    class BodyListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent lse7) {
            if( !lse7.getValueIsAdjusting()) {
                String selection7 = (String) list7.getSelectedValue();
                switch(selection7) {
                    case "ekto" :
                        c+=0.1;
                        f+=0.05;
                        break;
                    case "endo" :
                        c-=0.1;
                        f-=0.05;
                        p+=0.025;
                }
            }
        }
    }
    class ExitMenuItemListener implements ActionListener {
        public void actionPerformed(ActionEvent ev7) {
            frame.setVisible(false);
        }
    }
}
