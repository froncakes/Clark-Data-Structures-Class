import java.util.Scanner;

public class GuessGame {
    private TreeNode first;

    public GuessGame(TreeNode first){
        this.first = first;
    }

    public void beginGame(){
        // i is the node that the loop is currently on
        TreeNode i = first;
        Scanner s = new Scanner(System.in);
        while (i.left != null && i.right != null){
            // prints out yes/no question and asks the user to put in yes or no
            System.out.println(i.question);
            System.out.println("please put yes or no");
            String ans = s.nextLine();

            if (ans.equals("yes")){
                i = i.left;
            } else if (ans.equals("no")) {
                i = i.right;
            } else{
                System.out.println("do not answer with anything besides yes or no");
            }
        }
        // once the while loop is finished it will be at the end of the binary tree
        System.out.println(i.question);
        System.out.println("please put yes or no");
        String a = s.nextLine();

        if (a.equals("yes")){
            System.out.println("I have guessed your object!");
        }else{
            System.out.println("I have failed to guess your object...");
        }

        // asks the user if theyd like to play again
        System.out.println("would you like to play again?");
        a = s.nextLine();

        if (a.equals("yes")){
            beginGame();
        }
    }

    public static void main(String[] args){
        // first question
        TreeNode first = new TreeNode("is it living?");
        // living: yes
        first.left = new TreeNode("is it a plant?");
        // plant: yes
        first.left.left = new TreeNode("is it a tree?");
        // tree: yes
        first.left.left.left = new TreeNode("is your object an oak tree?");
        // tree: no
        first.left.left.right = new TreeNode("is your object a blade of grass?");
        // plant: no
        first.left.right = new TreeNode("is it an animal?");
        // animal: no
        first.left.right.right = new TreeNode("is it a bug?");
        // bug: no
        first.left.right.right.right = new TreeNode("is your object a spider?");
        // bug: yes
        first.left.right.right.left = new TreeNode("is your object an ant?");
        // animal: yes
        first.left.right.left = new TreeNode("does it potentially have a gun?");
        // gun: yes
        first.left.right.left.left = new TreeNode("is your object a human?");
        // gun: no
        first.left.right.left.right = new TreeNode("is it amphibian?");
        // amphibian: yes
        first.left.right.left.right.left = new TreeNode("is your object a frog?");
        // amphibian: no
        first.left.right.left.right.right = new TreeNode("is it a pet?");
        // pet: no
        first.left.right.left.right.right.right = new TreeNode("is it a predator?");
        // predator: yes
        first.left.right.left.right.right.right.left = new TreeNode("is your object a bear?");
        // predator: no
        first.left.right.left.right.right.right.right = new TreeNode("is your object a rabbit?");
        // pet: yes
        first.left.right.left.right.right.left = new TreeNode("does it 'meow'?");
        // meow: yes
        first.left.right.left.right.right.left.left = new TreeNode("is your object a cat?");
        // meow: no
        first.left.right.left.right.right.left.right = new TreeNode("is your object a dog?");

        // living: no
        first.right = new TreeNode("is it man-made?");
        // manmade: yes
        first.right.left = new TreeNode("is your object a gun?");
        // manmade: no
        first.right.right = new TreeNode("is it a rock?");
        // rock: yes
        first.right.right.left = new TreeNode("is it a fancy rock?");
        // fancy rock: yes
        first.right.right.left.left = new TreeNode("is your object a diamond?");
        // fancy rock: no
        first.right.right.left.right= new TreeNode("is your object just a rock?");
        // rock: no
        first.right.right.right = new TreeNode("is your object a corpse?");

        GuessGame a = new GuessGame(first);
        a.beginGame();
    }
}
