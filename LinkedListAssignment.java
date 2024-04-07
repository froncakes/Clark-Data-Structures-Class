/*
 * Frankie Nolan
 * 4/6/2024
 * Linked List Assignment
 */

import java.util.LinkedList;
public class LinkedListAssignment {
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(3);
        list.add(6);

        System.out.println(list);
        removeAfter(list, 0);
        System.out.println(list);

        System.out.println(copy(list));

        list.add(6);
        System.out.println(list);
        removeDuplicate(list,6);
        System.out.println(list);

        list.add(8);
        list.add(22);
        list.add(15);
        list.add(27);
        System.out.println(max(list));
    }
    // removes the node after the number given
    public static void removeAfter(LinkedList<Integer> a, int i){
        if (i >= 0 && i < a.size()-1){
            a.remove(i +1);
        }
    }
    // copies a linked list into a new linked list
    public static LinkedList<Integer> copy(LinkedList<Integer> a){
        LinkedList<Integer> b = new LinkedList<>();
        for (int i = 0; i < a.size(); i++){
            b.add(a.get(i));
        }
        return b;
    }
    // removes duplicate specified.
    public static void removeDuplicate(LinkedList<Integer> a, int dup){
        for (int i = 0; i < a.size(); i++){
            if ((int)a.get(i)==dup){
                a.remove(i);
                i--;
            }
        }
    }
    // returns
    public static int max(LinkedList<Integer> a){
        if (a.isEmpty()){
            return 0;
        }
        int max = 0;
        for (int i = 0; i < a.size(); i++){
            if ((int)a.get(i) > max){
                max = (int) a.get(i);
            }
        }
        return max;
    }
}
