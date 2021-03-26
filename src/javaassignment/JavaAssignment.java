/**
* Class Section: TT5V
* Trimester 2 2020/21
* Members:
* Yew Ee Jet Emmanuel       1181203540 +60 19-283 8311
* Paul John C. Escobia      1171103354 +60 11-5630 9196
* Yoong Yu Hong             1181203116 +60 14-337 8434
* Ting Siong Hock           1181203305 +60 11-2502 2950
* Lum Kar Yu                1191202435 +60 10-208 4816
*/
package javaassignment;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class JavaAssignment extends JFrame implements ActionListener, ItemListener {
    
    private String[] colors = {"---","Red", "Green", "Blue", "Yellow", "Gray"}; //Selection for color
    private JLabel gameTitle, textWelcome, textSelection ;
    private JButton btnProceed;
    private JPanel panelTitle, panelCenter, panelContentCenter, panelWelcomeCenter, panelSelectionCenter, panelBtnCenter;
    private JComboBox cboxColor;
    
    public static void main(String[] args) {
        JavaAssignment frame = new JavaAssignment();
        
        //making a frame
        frame.setSize(800,450);
        frame.setResizable(false);
        frame.setTitle("Rock-Paper-Scissors-Lizard-Spock");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public JavaAssignment(){   
        // label for a title
        gameTitle = new JLabel("Rock-Paper-Scissors-Lizard-Spock");
        gameTitle.setFont(new Font("Arial", Font.PLAIN, 22));
        
        //greetings and ask for background color selection
        textWelcome = new JLabel("Welcome!");
        textSelection = new JLabel("Please select the background color before you proceed:");
        
        btnProceed = new JButton("PROCEED"); //button to proceed after selecting color
        
        cboxColor = new JComboBox(colors); // combo box for the color selection
            
        panelTitle = new JPanel();
        panelTitle.setBackground(Color.orange);
        panelTitle.add(gameTitle);
       
        
        panelCenter = new JPanel();
            panelContentCenter = new JPanel();
            panelContentCenter.setLayout(new GridLayout(3,1));

            panelWelcomeCenter = new JPanel();
            panelWelcomeCenter.add(textWelcome);
            panelContentCenter.add(panelWelcomeCenter);

            panelContentCenter.add(textSelection);

            panelSelectionCenter = new JPanel();
            panelSelectionCenter.add(cboxColor);
            panelContentCenter.add(panelSelectionCenter);

        panelCenter.add(panelContentCenter);
        
        panelBtnCenter = new JPanel();
        panelBtnCenter.add(btnProceed);
            
        add(panelTitle,BorderLayout.NORTH);
        add(panelCenter,BorderLayout.CENTER);
        add(panelBtnCenter,BorderLayout.SOUTH);
        
        cboxColor.addActionListener(this);
        btnProceed.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String background = (String)cboxColor.getSelectedItem();
        
        if(e.getSource() == cboxColor) { // if a color is selected from a combo box
            switch(background){
                case "Red": // set the background color red
                    panelCenter.setBackground(Color.red);
                    panelContentCenter.setBackground(Color.red);
                    panelWelcomeCenter.setBackground(Color.red);
                    panelSelectionCenter.setBackground(Color.red);
                    panelBtnCenter.setBackground(Color.red);
                    break;
                case "Green": // set the background color green
                    panelCenter.setBackground(Color.green);
                    panelContentCenter.setBackground(Color.green);
                    panelWelcomeCenter.setBackground(Color.green);
                    panelSelectionCenter.setBackground(Color.green);
                    panelBtnCenter.setBackground(Color.green);
                    break;
                case "Blue":  // set the background color blue
                    panelCenter.setBackground(Color.blue);
                    panelContentCenter.setBackground(Color.blue);
                    panelWelcomeCenter.setBackground(Color.blue);
                    panelSelectionCenter.setBackground(Color.blue);
                    panelBtnCenter.setBackground(Color.blue);
                    break;
                case "Yellow":  //set the background color yellow
                    panelCenter.setBackground(Color.yellow);
                    panelContentCenter.setBackground(Color.yellow);
                    panelWelcomeCenter.setBackground(Color.yellow);
                    panelSelectionCenter.setBackground(Color.yellow);
                    panelBtnCenter.setBackground(Color.yellow);
                    break;
                case "Gray":  // set the background color gray
                    panelCenter.setBackground(Color.gray);
                    panelContentCenter.setBackground(Color.gray);
                    panelWelcomeCenter.setBackground(Color.gray);
                    panelSelectionCenter.setBackground(Color.gray);
                    panelBtnCenter.setBackground(Color.gray);
                    break;
                default:  // set default background white is nothing is chosen
                    panelCenter.setBackground(Color.white);
                    panelContentCenter.setBackground(Color.white);
                    panelWelcomeCenter.setBackground(Color.white);
                    panelSelectionCenter.setBackground(Color.white);
                    panelBtnCenter.setBackground(Color.white);
                    break;
            }
        }
        if(e.getSource() == btnProceed) { // if proceed button is clicked
            if(background!="---"){  // if the background set is not default
                new Screen2(background);  // call for screen 2
                this.dispose();  // dispose the current frame
            }
            else // if background is default
                JOptionPane.showMessageDialog(new JFrame(),"You MUST select a background color!","Warning",JOptionPane.WARNING_MESSAGE);// if background is default
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       // if(comBox.setSelectedItem(1)) {
            
       // }
    }
}