/*
* Frankie Nolan
* 2/10/2024
* CSCI 121 Sec 02
*
* Pizza Application
* adds sandwiches aswell as hotdogs, while making the gui still readable as it will hide everything not worth looking at in the moment.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class pizzaApplication extends JFrame implements ActionListener,ItemListener {
    boolean orderInProgress = false;
    boolean orderDone = false;
    boolean pizzaDone = true;
    boolean sandwichDone = true;
    boolean hotdogDone = true;
    int pizzaTops = 0;
    int sandwichTops = 0;
    double price = 0.0;
    boolean end = false;
    // general order
    JLabel question = new JLabel("What would you like to eat?");
    JCheckBox pizza = new JCheckBox(" $5-$20 Pizza", false);
    JCheckBox sandwich = new JCheckBox("$6 Sandwich", false);
    JCheckBox hotdog = new JCheckBox("$4 Hot Dog", false);
    JButton confirm = new JButton("Confirm");
    JButton cancel = new JButton("Cancel");
    boolean pizzaSelected = false;
    boolean sandwichSelected = false;
    boolean hotdogSelected = false;

    // pizza toppings and size
    JLabel pizzaSize = new JLabel("What pizza size? small $5, medium $10, large $15, super $20");
    // pizza size will be a mandatory argument, so we will check to see if they
    boolean pizzaSizeSelected = false;
    JCheckBox superSize = new JCheckBox("Super", false);
    JCheckBox largeSize = new JCheckBox("Large", false);
    JCheckBox mediumSize = new JCheckBox("Medium", false);
    JCheckBox smallSize = new JCheckBox("Small", false);
    JLabel pizzaToppings = new JLabel("What pizza toppings? $.50 per topping, $1.25 for 3");
    JCheckBox extraCheese = new JCheckBox("Extra Cheese (Free)", false);
    JCheckBox pepperoni = new JCheckBox("Pepperoni", false);
    JCheckBox mushroom = new JCheckBox("Mushroom", false);
    JCheckBox sausage = new JCheckBox("Sausage", false);
    JCheckBox bacon = new JCheckBox("Bacon", false);
    JCheckBox basil = new JCheckBox("Basil", false);

    // sandwich settings and toppings
    JLabel sandwichMeat = new JLabel("What sandwich meat?");
    boolean sandwichMeatSelected = false;
    JCheckBox ham = new JCheckBox("Ham", false);
    JCheckBox turkey = new JCheckBox("Turkey", false);
    JCheckBox pastrami = new JCheckBox("Pastrami", false);
    JCheckBox salami = new JCheckBox("Salami", false);

    JLabel sandwichToppings = new JLabel("What sandwich toppings? First two are free, costs $.50 each after");
    JCheckBox tomato = new JCheckBox("Tomato", false);
    JCheckBox pickles = new JCheckBox("Pickles", false);
    JCheckBox cheese = new JCheckBox("Cheese", false);
    JCheckBox peppers = new JCheckBox("Peppers", false);
    JCheckBox sandwichBacon = new JCheckBox("Bacon", false);
    JCheckBox lettuce = new JCheckBox("Lettuce", false);
    JCheckBox cucumbers = new JCheckBox("Cucumbers", false);

    // hot dog settings
    JLabel hotdogToppings = new JLabel("What hot dog sauces?");
    JCheckBox ketchup = new JCheckBox("Ketchup", false);
    JCheckBox mustard = new JCheckBox("Mustard", false);
    JCheckBox mayonnaise = new JCheckBox("Mayonnaise", false);

    JLabel total = new JLabel();
    public pizzaApplication() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // General order, user will select to order a pizza, a sandwich, and/or a hotdog.
        question.setFont(new Font("Arial",Font.ITALIC, 22));
        pizza.addItemListener(this);
        sandwich.addItemListener(this);
        hotdog.addItemListener(this);
        add(question);
        add(pizza);
        add(sandwich);
        add(hotdog);

        /* Pizza settings, user will choose between four sizes small-super,
        * then choose the toppings of extra cheese, pepperoni, mushroom, sausage, bacon, and basil
         */
        pizzaSize.setFont(new Font("Arial",Font.ITALIC,18));
        smallSize.addItemListener(this);
        mediumSize.addItemListener(this);
        largeSize.addItemListener(this);
        superSize.addItemListener(this);
        add(pizzaSize);
        add(smallSize);
        add(mediumSize);
        add(largeSize);
        add(superSize);

        pizzaToppings.setFont(new Font("Arial",Font.ITALIC, 18));
        extraCheese.addItemListener(this);
        pepperoni.addItemListener(this);
        mushroom.addItemListener(this);
        sausage.addItemListener(this);
        bacon.addItemListener(this);
        basil.addItemListener(this);
        add(pizzaToppings);
        add(extraCheese);
        add(pepperoni);
        add(mushroom);
        add(sausage);
        add(bacon);
        add(basil);

        /* Sandwich Settings, user will choose between four meats, Ham, Turkey, Pastrami, and Salami
        * then the user will choose between the toppings listed
         */
        sandwichMeat.setFont(new Font("Arial",Font.ITALIC, 18));
        ham.addItemListener(this);
        turkey.addItemListener(this);
        pastrami.addItemListener(this);
        salami.addItemListener(this);
        add(sandwichMeat);
        add(ham);
        add(turkey);
        add(pastrami);
        add(salami);

        sandwichToppings.setFont(new Font("Arial",Font.ITALIC, 18));
        tomato.addItemListener(this);
        pickles.addItemListener(this);
        cheese.addItemListener(this);
        peppers.addItemListener(this);
        sandwichBacon.addItemListener(this);
        lettuce.addItemListener(this);
        cucumbers.addItemListener(this);
        add(sandwichToppings);
        add(tomato);
        add(pickles);
        add(cheese);
        add(peppers);
        add(sandwichBacon);
        add(lettuce);
        add(cucumbers);

        // Hot Dog settings, the user has a choice of 3 sauces.
        hotdogToppings.setFont(new Font("Arial",Font.ITALIC, 18));
        mustard.addItemListener(this);
        ketchup.addItemListener(this);
        mayonnaise.addItemListener(this);
        add(hotdogToppings);
        add(ketchup);
        add(mustard);
        add(mayonnaise);

        add(total);
        total.setFont(new Font("Arial",Font.ITALIC, 18));
        total.setVisible(false);

        showGeneralOrder();
        hideSandwichSettings();
        hideHotDogSettings();
        hidePizzaSettings();
        confirm.addActionListener(this);
        cancel.addActionListener(this);
        add(confirm);
        add(cancel);
    }

    // show/hide functions for each segment of ordering
    public void showGeneralOrder(){
        question.setVisible(true);
        pizza.setVisible(true);
        sandwich.setVisible(true);
        hotdog.setVisible(true);
    }

    public void hideGeneralOrder(){
        question.setVisible(false);
        pizza.setVisible(false);
        sandwich.setVisible(false);
        hotdog.setVisible(false);
    }

    public void showPizzaSettings(){
        pizzaSize.setVisible(true);
        superSize.setVisible(true);
        largeSize.setVisible(true);
        mediumSize.setVisible(true);
        smallSize.setVisible(true);

        pizzaToppings.setVisible(true);
        extraCheese.setVisible(true);
        pepperoni.setVisible(true);
        mushroom.setVisible(true);
        sausage.setVisible(true);
        bacon.setVisible(true);
        basil.setVisible(true);
    }

    public void hidePizzaSettings(){
        pizzaSize.setVisible(false);
        superSize.setVisible(false);
        largeSize.setVisible(false);
        mediumSize.setVisible(false);
        smallSize.setVisible(false);

        pizzaToppings.setVisible(false);
        extraCheese.setVisible(false);
        pepperoni.setVisible(false);
        mushroom.setVisible(false);
        sausage.setVisible(false);
        bacon.setVisible(false);
        basil.setVisible(false);
    }

    public void showSandwichSettings(){
        sandwichMeat.setVisible(true);
        ham.setVisible(true);
        turkey.setVisible(true);
        pastrami.setVisible(true);
        salami.setVisible(true);

        sandwichToppings.setVisible(true);
        tomato.setVisible(true);
        pickles.setVisible(true);
        cheese.setVisible(true);
        peppers.setVisible(true);
        sandwichBacon.setVisible(true);
        lettuce.setVisible(true);
        cucumbers.setVisible(true);
    }

    public void hideSandwichSettings(){
        sandwichMeat.setVisible(false);
        ham.setVisible(false);
        turkey.setVisible(false);
        pastrami.setVisible(false);
        salami.setVisible(false);

        sandwichToppings.setVisible(false);
        tomato.setVisible(false);
        pickles.setVisible(false);
        cheese.setVisible(false);
        peppers.setVisible(false);
        sandwichBacon.setVisible(false);
        lettuce.setVisible(false);
        cucumbers.setVisible(false);
    }

    public void showHotDogSettings(){
        hotdogToppings.setVisible(true);
        ketchup.setVisible(true);
        mustard.setVisible(true);
        mayonnaise.setVisible(true);
    }

    public void hideHotDogSettings(){
        hotdogToppings.setVisible(false);
        ketchup.setVisible(false);
        mustard.setVisible(false);
        mayonnaise.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == confirm){
            if (orderDone == false){
                // when clicking confirm and the order is not done, will repeat the order() function until orderDone == true
                orderInProgress = true;
                order();
            }else if (end == true){
                // ends program on confirm to pay
                System.exit(0);
            }else if (orderDone == true){
                // Order is done, calculate total cost.
                hideSandwichSettings();
                hidePizzaSettings();
                hideHotDogSettings();
                total.setText("Your total for this order is equal to $"+price+" would you like to pay?");
                total.setVisible(true);
                end = true;
            }
            System.out.println("confirm");
        } else if (source == cancel) {
            if (orderInProgress){
                /*
                // if the user clicks cancel while the order is in progress, the app will take them back to the start
                ******* planned but wasnt able to finish before it was due (alot of repetitive coding)
                orderInProgress = false;
                hidePizzaSettings();
                hideSandwichSettings();
                hideHotDogSettings();
                pizzaDone = false;
                sandwichDone = false;
                hotdogDone = false;
                showGeneralOrder();
                 */
                System.exit(0);
            } else{
                // close the program if the order is not in progress
                System.exit(0);
            }
            System.out.println("cancel");
        }
    }

    private void order() {
        /* the order hasnt begun yet, so it will begin at this confirm click, after clicking confirm, check all the selected orders
         * and grant the user the ability to choose the settings for each of the orders one by one
         */
        if (pizzaSelected && !pizzaDone){
            showPizzaSettings();
            hideSandwichSettings();
            hideHotDogSettings();
            hideGeneralOrder();
            pizzaDone = true;
        }else if (sandwichSelected && !sandwichDone){
            showSandwichSettings();
            hidePizzaSettings();
            hideHotDogSettings();
            hideGeneralOrder();
            sandwichDone = true;
        }else if (hotdogSelected && !hotdogDone){
            showHotDogSettings();
            hideSandwichSettings();
            hidePizzaSettings();
            hideGeneralOrder();
            hotdogDone = true;
        }else if (!pizzaSelected && !sandwichSelected && !hotdogSelected){
            // user didn't select anything
            System.out.println("nothing selected");
        }
        if (pizzaDone && sandwichDone && hotdogDone){
            /* once all of these are done will make orderDone true, these are set to done by default if their selected alternatives arent selected.
            * as in, if pizzaSelected is set to true, pizzaDone will equal false, and vice versa
             */
            orderDone= true;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println(price);
        Object source = e.getItem();
        int select = e.getStateChange();
        if(select == ItemEvent.SELECTED) {
            // original buttons to select the basic orders
            if (source == pizza){
                pizzaSelected = true;
                pizzaDone = false;
                System.out.println("pizza");
            } else if (source == sandwich) {
                sandwichSelected = true;
                sandwichDone = false;
                System.out.println("sandwich");
            } else if (source == hotdog) {
                hotdogSelected = true;
                hotdogDone = false;
                System.out.println("hotdog");
            }
            // pizza size adds costs and disables the other ones.
            if (source == superSize) {
                price += 20.0;
                superSize.setEnabled(false);
                largeSize.setEnabled(false);
                mediumSize.setEnabled(false);
                smallSize.setEnabled(false);
            } else if (source == largeSize) {
                price += 15.0;
                superSize.setEnabled(false);
                largeSize.setEnabled(false);
                mediumSize.setEnabled(false);
                smallSize.setEnabled(false);
            } else if (source == mediumSize) {
                price += 10.0;
                superSize.setEnabled(false);
                largeSize.setEnabled(false);
                mediumSize.setEnabled(false);
                smallSize.setEnabled(false);
            } else if (source == smallSize) {
                price += 5.0;
                superSize.setEnabled(false);
                largeSize.setEnabled(false);
                mediumSize.setEnabled(false);
                smallSize.setEnabled(false);
            }
            // pizza toppings calls the addPizzaTopping() method
            if (source == pepperoni) {
                addPizzaTopping();
            } else if (source == mushroom) {
                addPizzaTopping();
            } else if (source == sausage) {
                addPizzaTopping();
            } else if (source == bacon) {
                addPizzaTopping();
            } else if (source == basil) {
                addPizzaTopping();
            }
            // sandwich meats, disables other meats
            if (source == ham){
                price += 6.0;
                salami.setEnabled(false);
                pastrami.setEnabled(false);
                turkey.setEnabled(false);
                ham.setEnabled(false);
            }else if (source == turkey){
                price += 6.0;
                salami.setEnabled(false);
                pastrami.setEnabled(false);
                turkey.setEnabled(false);
                ham.setEnabled(false);
            }else if (source == pastrami){
                price += 6.0;
                salami.setEnabled(false);
                pastrami.setEnabled(false);
                turkey.setEnabled(false);
                ham.setEnabled(false);
            }else if (source == salami){
                price += 6.0;
                salami.setEnabled(false);
                pastrami.setEnabled(false);
                turkey.setEnabled(false);
                ham.setEnabled(false);
            }
            // sandwich selections calls addSandwichTopping()
            if (source == tomato){
                addSandwichTopping();
            }else if (source == pickles){
                addSandwichTopping();
            }else if (source == cheese){
                addSandwichTopping();
            }else if (source == peppers){
                addSandwichTopping();
            }else if (source == sandwichBacon){
                addSandwichTopping();
            }else if (source == lettuce){
                addSandwichTopping();
            }else if (source == cucumbers){
                addSandwichTopping();
            }
        }
        else if(select == ItemEvent.DESELECTED) {
            if (source == pizza){
                pizzaSelected = false;
                pizzaDone = true;
                System.out.println("pizza deselected");
            } else if (source == sandwich) {
                sandwichSelected = false;
                sandwichDone = true;
                System.out.println("sandwich deselected");
            } else if (source == hotdog) {
                hotdogSelected = false;
                hotdogDone = true;
                System.out.println("hotdog deselected");
            }
            // deselecting toppings on pizza or sandwich leads to a change in cost
            if (source == pepperoni) {
                subtractPizzaTopping();
            } else if (source == mushroom) {
                subtractPizzaTopping();
            } else if (source == sausage) {
                subtractPizzaTopping();
            } else if (source == bacon) {
                subtractPizzaTopping();
            } else if (source == basil) {
                subtractPizzaTopping();
            }
            if (source == tomato){
                subtractSandwichTopping();
            }else if (source == pickles){
                subtractSandwichTopping();
            }else if (source == cheese){
                subtractSandwichTopping();
            }else if (source == peppers){
                subtractSandwichTopping();
            }else if (source == sandwichBacon){
                subtractSandwichTopping();
            }else if (source == lettuce){
                subtractSandwichTopping();
            }else if (source == cucumbers){
                subtractSandwichTopping();
            }
        }
    }

    private void addPizzaTopping() {
        if (pizzaTops == 2){
            price += .25;
        }else{
            price += .50;
        }
        pizzaTops++;
        // disables the checkboxes if the pizza toppings are at 3
        if (pizzaTops == 3){
            pepperoni.setEnabled(false);
            mushroom.setEnabled(false);
            sausage.setEnabled(false);
            bacon.setEnabled(false);
            basil.setEnabled(false);
        }
    }

    private void subtractPizzaTopping() {
        price -= .5;
        pizzaTops--;
    }

    private void addSandwichTopping(){
        if (sandwichTops> 1){
            price += .50;
        }
        sandwichTops++;
    }

    private void subtractSandwichTopping(){
        sandwichTops--;
        if (sandwichTops> 1){
            price -= .50;
        }
    }

    public static void main(String[] args) {
        final int FRAME_WIDTH = 540;
        final int FRAME_HEIGHT = 320;
        pizzaApplication i = new pizzaApplication();
        i.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        i.setVisible(true);
    }
}