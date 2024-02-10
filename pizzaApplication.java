/*
* Frankie Nolan
* 1/29/2024
* CSCI 121 Sec 02
*
* Pizza Application
*
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class pizzaApplication extends JFrame implements ActionListener,ItemListener {
    FlowLayout flow = new FlowLayout();
    JLabel question = new JLabel("What would you like to eat?");
    JCheckBox pizza = new JCheckBox("Pizza", false);
    JCheckBox sandwich = new JCheckBox("Sandwich", false);
    JCheckBox hotdog = new JCheckBox("Hot Dog", false);
    JButton confirm = new JButton("Confirm Order");
    JButton cancel = new JButton("Cancel Order");

    JLabel pizzaToppings = new JLabel("What Pizza Toppings? $.50 per topping, $1.25 for 3");
    JCheckBox pepperoni = new JCheckBox("Pepperoni", false);

    public pizzaApplication() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        question.setFont(new Font("Arial",Font.ITALIC, 22));
        pizza.addItemListener(this);
        sandwich.addItemListener(this);
        hotdog.addItemListener(this);
        confirm.addActionListener(this);
        cancel.addActionListener(this);
        add(question);
        add(pizza);
        add(sandwich);
        add(hotdog);
        add(confirm);
        add(cancel);

        pizzaToppings.setFont(new Font("Arial",Font.ITALIC, 14));
        pepperoni.addActionListener(this);
        add(pizzaToppings);
        add(pepperoni);
        hidePizzaToppings();
    }

    public void showPizzaToppings(){
        pizzaToppings.setVisible(true);
        pepperoni.setVisible(true);
    }

    public void hidePizzaToppings(){
        pizzaToppings.setVisible(false);
        pepperoni.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == confirm){
            System.out.println("confirm");
        } else if (source == cancel) {
            System.out.println("cancel");
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItem();
        int select = e.getStateChange();
        if(select == ItemEvent.SELECTED) {
            if (source == pizza){
                showPizzaToppings();
                System.out.println("pizza");
            } else if (source == sandwich) {
                System.out.println("sandwich");
            } else if (source == hotdog) {
                System.out.println("hotdog");
            }
        }
        else if(select == ItemEvent.DESELECTED) {
            if (source == pizza){
                hidePizzaToppings();
                System.out.println("pizza deselected");
            } else if (source == sandwich) {
                System.out.println("sandwich deselected");
            } else if (source == hotdog) {
                System.out.println("hotdog deselected");
            }
        }
    }

    public static void main(String[] args) {
        final int FRAME_WIDTH = 360;
        final int FRAME_HEIGHT = 160;
        pizzaApplication i = new pizzaApplication();
        i.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        i.setVisible(true);
    }
}