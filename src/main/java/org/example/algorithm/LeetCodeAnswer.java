package org.example.algorithm;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeetCodeAnswer {
    /**
     * 876. Middle of The Linked List
     */
    class question876 {
        /**
         * time complexity O(n) <br>
         * space complexity O(n)
         */
        public ListNode middleNode1(ListNode head) {
            if (head == null || head.next == null) return head;
            ArrayList<ListNode> array = new ArrayList<>();
            int length = 0;
            while (head != null) {
                array.add(head);
                head = head.next;
                length++;
            }
            return array.get(length / 2);
        }

        /**
         * time complexity O(n) <br>
         * space complexity O(1)
         */
        public ListNode middleNode2(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode middle = head;
            ListNode end = head;

            while (end != null && end.next != null) {
                middle = middle.next;
                end = end.next.next;
            }

            return middle;
        }

        @NoArgsConstructor
        @AllArgsConstructor
        public class ListNode {
            int val;
            ListNode next;

            ListNode(int val) {
                this.val = val;
            }
        }
    }

    /**
     * 383. Ransom Note
     */
    class question383 {
        /**
         * time complexity O(m) <br>
         * space complexity O(k) <br>
         * m = ransomNote.length, k = 26
         */
        public boolean canConstruct1(String ransomNote, String magazine) {
            Map<String, Integer> map = new HashMap<>();

            for (String a : magazine.split("")) {
                if (map.containsKey(a)) {
                    Integer count = map.get(a);
                    map.put(a, ++count);
                } else {
                    map.put(a, 1);
                }
            }

            for (String a : ransomNote.split("")) {
                if (map.containsKey(a)) {
                    Integer count = map.get(a);
                    map.put(a, --count);
                    if (map.get(a) < 0) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        }

        /**
         * time complexity O(m+n) <br>
         * space complexity O(1) <br>
         */
        public boolean canConstruct2(String ransomNote, String magazine) {
            int[] alph = new int[26];

            for (char c : magazine.toCharArray()) {
                alph[c - 'a']++;
            }

           for(char c : ransomNote.toCharArray()){
               if (alph[c-'a']==0) return false;
               else alph[c-'a']--;
           }

           return true;
        }
    }
}
