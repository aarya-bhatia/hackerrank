package com.aarya.lists;

public class MyLinkedList {

    static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (head == null) {
            head = newNode;
            return head;
        }
        SinglyLinkedListNode current = head;
        while (current != null) {
            if (current.hasNext()) {
                current.setNext(newNode);
                break;
            }
            current = current.getNext();
        }
        return head;
    }

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);

        if (head == null) {
            head = node;
            return head;
        }

        node.setNext(head);
        head = node;
        return head;
    }

    static void insertNodeAtPosition(int current, int target, SinglyLinkedListNode currentNode,
            SinglyLinkedListNode nodeToAdd) {
        if (current == target - 1) {
            SinglyLinkedListNode temp = currentNode.getNext();
            currentNode.setNext(nodeToAdd);
            nodeToAdd.setNext(temp);
            return;
        }
        int nextPosition = current + 1;
        SinglyLinkedListNode nextInPath = currentNode.getNext();
        insertNodeAtPosition(nextPosition, target, nextInPath, nodeToAdd);
    }

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode nodeToAdd = new SinglyLinkedListNode(data);
        if (position == 0 || head == null) {
            head = nodeToAdd;
            return head;
        }
        insertNodeAtPosition(0, position, head, nodeToAdd);
        return head;
    }

    static void delete(int currentPosition, int targetPosition, SinglyLinkedListNode currentNode) {
        if (currentPosition == targetPosition - 1) {
            SinglyLinkedListNode nodeToDelete = currentNode.getNext();
            SinglyLinkedListNode nodeAfterThat = nodeToDelete.getNext();
            currentNode.setNext(nodeAfterThat);
        } else {
            delete(currentPosition + 1, targetPosition, currentNode.getNext());
        }
    }

    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if (position == 0) {
            // SinglyLinkedListNode temp = head;
            head = head.getNext();
            return head;
        }
        delete(0, position, head);
        return head;
    }

    static void reversePrint(SinglyLinkedListNode head) {
        if (head.hasNext()) {
            reversePrint(head.getNext());
        }

        System.out.println(head.getData());
    }

    static SinglyLinkedListNode reverse(SinglyLinkedListNode current) {
        SinglyLinkedListNode reverseHead = null;
        SinglyLinkedListNode iterator;
        while (current != null) {
            iterator = current.getNext();
            current.setNext(reverseHead);
            reverseHead = current;
            current = iterator;
        }
        return reverseHead;
    }

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode iterator1 = head1;
        SinglyLinkedListNode iterator2 = head2;

        while (iterator1 != null && iterator2 != null) {
            if (iterator1.getData() != iterator2.getData()) {
                return false;
            }
            iterator1 = iterator1.getNext();
            iterator2 = iterator2.getNext();
        }

        return iterator1 == null && iterator2 == null;
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode itr1 = head1;
        SinglyLinkedListNode itr2 = head2;

        SinglyLinkedList mergedList = new SinglyLinkedList();

        while (itr1 != null && itr2 != null) {
            if (itr1.getData() < itr2.getData()) {
                mergedList.addLast(itr1);
                itr1 = itr1.getNext();
            } else {
                mergedList.addLast(itr2);
                itr2 = itr2.getNext();
            }
        }

        if (itr1 != null) {
            while (itr1 != null) {
                mergedList.addLast(itr1);
                itr1 = itr1.getNext();
            }
        }

        if (itr2 != null) {
            while (itr2 != null) {
                mergedList.addLast(itr2);
                itr2 = itr2.getNext();
            }
        }

        return mergedList.getHead();
    }

    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode runner = head;
        SinglyLinkedListNode current = head;
        for (int i = 0; i <= positionFromTail; i++) {
            runner = runner.getNext();
        }
        while (runner != null) {
            runner = runner.getNext();
            current = current.getNext();
        }
        return current != null ? current.getData() : 0;
    }

    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        SinglyLinkedListNode before = head;
        SinglyLinkedListNode after = before.getNext();
        while (after != null) {
            if (before.getData() == after.getData()) {
                before.setNext(after.getNext());
                after = before.getNext();
            } else {
                before = after;
                after = after.getNext();
            }
        }
        return head;
    }

    static boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;
        while (fast != null && fast.getNext() != null && slow != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode it1 = head1;
        while (it1 != null) {
            SinglyLinkedListNode temp = it1.getNext();
            it1.setNext(null);
            it1 = temp;
        }

        it1 = head2;
        while (it1 != null) {
            if (it1.hasNext()) {
                return it1.getData();
            }
            it1 = it1.getNext();
        }

        return 0;
    }



}