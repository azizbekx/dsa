package codetrus_data_structures.linkedlist.challenge;

import codetrus_data_structures.linkedlist.DLLWithTail;

public class Challenge11_Palindrome {
    public static <T> boolean isPalindrome(DLLWithTail<T> list) {
        if(list.isEmpty()) return false;

        DLLWithTail<T>.Node left = list.getHeadNode();
        DLLWithTail<T>.Node right = list.getTailNode();
        int size = list.getSize();
        int middle = size % 2 == 0 ? size/2 : size/2 - 1;

        while(middle != 0 && left != null && right != null){
            if(!left.data.equals(right.data)){
                return false;
            }
            left = left.nextNode;
            right = right.prevNode;
            middle--;
        }
        return middle == 0;
    }
    public static void main(String[] args) {
        DLLWithTail<Integer> list1 = new DLLWithTail<Integer>();
        list1.insertAtEnd(1);
        list1.insertAtEnd(2);
        list1.insertAtEnd(2);
        list1.insertAtEnd(1);
        System.out.print("1st ");
        list1.printList();
        DLLWithTail<Integer> list2 = new DLLWithTail<Integer>();
        list2.insertAtEnd(6);
        list2.insertAtEnd(8);
        list2.insertAtEnd(6);
        list2.insertAtEnd(6);
        System.out.print("2nd ");
        list2.printList();
        System.out.println("Is 1st list a palindrome?  " + isPalindrome(list1));
        System.out.println("Is 2nd list a palindrome?  " + isPalindrome(list2));

    }
}
