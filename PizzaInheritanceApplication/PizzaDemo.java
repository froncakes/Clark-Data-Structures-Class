/*
 * Frankie Nolan
 * 3/17/2024
 * CSCI 121 Sec 02
 *
 * Pizza Inheritance Application
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
public class PizzaDemo extends JFrame implements ActionListener,TextListener,ItemListener {
    String[] toppings = new String[10];
    // amount of actual toppings apposed to the array which has 10 which could contain null
    int toppingAmount = 0;
    // if delivery is selected
    boolean deliveryPizza = false;
    // for after delivery is selected so when user presses submit doesn't interact with the adding to toppings
    boolean pizzaDone = false;
    String deliveryAddress = new String();
    JLabel labelQuestion = new JLabel("What pizza topping would you like? do not leave empty, type 'QUIT' to confirm toppings");
    JTextField textQuestion = new JTextField(16);
    JButton submit = new JButton("Submit");
    JCheckBox delivery = new JCheckBox("Delivery?", false);
    public PizzaDemo(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        labelQuestion.setFont(new Font("Arial",Font.ITALIC, 18));
        submit.addActionListener(this);
        delivery.addItemListener(this);

        add(labelQuestion);
        add(textQuestion);
        add(delivery);
        add(submit);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        // user clicked submit
        if (s == "Submit"){
            // if the pizza is not done and the user has hit submit that means they are doing a delivery and need to write the address down
            if (!pizzaDone){
                // if user typed 'QUIT' will proceed with current toppings
                if (textQuestion.getText().equals("QUIT")){
                    System.out.println("QUIT");
                    textQuestion.setText("");
                    createPizza();
                }// check if the text is empty
                else if (!textQuestion.getText().isEmpty()) {
                    // finds next empty in array and adds the desired topping
                    for (int i = 0; i < toppings.length; i++) {
                        if (toppings[i] == null) {
                            toppings[i] = textQuestion.getText();
                            toppingAmount++;
                            textQuestion.setText("");
                            System.out.println(Arrays.toString(toppings));
                            // once i gets to the max of the array, will proceed with current toppings
                            if (i == toppings.length - 1) {
                                createPizza();
                            }
                            break;
                        }
                    }
                }
            }else{
                System.out.println("delivery");
                deliveryAddress = textQuestion.getText();
                textQuestion.setText("");
                // calls back to create the delivery pizza
                createPizza();
            }
        }
    }
    @Override
    public void textValueChanged(TextEvent e) {

    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        // delivery set on and off based if the checkbox is clicked
        int select = e.getStateChange();
        if (select == ItemEvent.SELECTED){
            deliveryPizza = true;
        }
        if (select == ItemEvent.DESELECTED){
            deliveryPizza = false;
        }
    }

    private void createPizza(){
        delivery.setVisible(false);
        if (pizzaDone){
            submit.setVisible(false);
            textQuestion.setVisible(false);
            DeliveryPizza a = new DeliveryPizza(toppings, toppingAmount, deliveryAddress);
            labelQuestion.setText(a.toString());
        }// if its delivery will ask user to put in the address with text field and submit again
        else if (deliveryPizza){
            labelQuestion.setText("Please put in your delivery address");
            pizzaDone = true;
        } else{
            submit.setVisible(false);
            textQuestion.setVisible(false);
            Pizza a = new Pizza(toppings, toppingAmount);
            labelQuestion.setText(a.toString());
        }
    }

    public static void main(String[] args) {
        final int FRAME_WIDTH = 720;
        final int FRAME_HEIGHT = 320;
        PizzaDemo i = new PizzaDemo();
        i.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        i.setVisible(true);
    }
}
