package com.aarya.lists;

public class MyLinkedList {

    static void printLinkedList(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
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
            if (current.next == null) {
                current.next = newNode;
                break;
            }
            current = current.next;
        }
        return head;
    }

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);

        if (head == null) {
            head = node;
            return head;
        }

        node.next = head;
        head = node;
        return head;
    }

    static void insertNodeAtPosition(int current, int target, SinglyLinkedListNode currentNode,
            SinglyLinkedListNode nodeToAdd) {
        if (current == target - 1) {
            SinglyLinkedListNode temp = currentNode.next;
            currentNode.next = nodeToAdd;
            nodeToAdd.next = temp;
            return;
        }
        int nextPosition = current + 1;
        SinglyLinkedListNode nextInPath = currentNode.next;
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
            SinglyLinkedListNode nodeToDelete = currentNode.next;
            SinglyLinkedListNode nodeAfterThat = nodeToDelete.next;
            currentNode.next = nodeAfterThat;
        } else {
            delete(currentPosition + 1, targetPosition, currentNode.next);
        }
    }

    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if (position == 0) {
            // SinglyLinkedListNode temp = head;
            head = head.next;
            return head;
        }
        delete(0, position, head);
        return head;
    }

    static void reversePrint(SinglyLinkedListNode head) {
        if (head.next != null) {
            reversePrint(head.next);
        }

        System.out.println(head.data);
    }

    static SinglyLinkedListNode reverse(SinglyLinkedListNode current) {
        SinglyLinkedListNode reverseHead = null;
        SinglyLinkedListNode iterator = current;
        while (current != null) {
            iterator = current.next;
            current.next = reverseHead;
            reverseHead = current;
            current = iterator;
        }
        return reverseHead;
    }

    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode iterator1 = head1;
        SinglyLinkedListNode iterator2 = head2;

        while (iterator1 != null && iterator2 != null) {
            if (iterator1.data != iterator2.data) {
                return false;
            }
            iterator1 = iterator1.next;
            iterator2 = iterator2.next;
        }

        return iterator1 == null && iterator2 == null;
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode itr1 = head1;
        SinglyLinkedListNode itr2 = head2;

        DoublyLinkedList mergedList = new DoublyLinkedList();

        while (itr1 != null && itr2 != null) {
            if (itr1.data < itr2.data) {
                mergedList.addLast(itr1);
                itr1 = itr1.next;
            } else {
                mergedList.addLast(itr2);
                itr2 = itr2.next;
            }
        }

        if (itr1 != null) {
            while (itr1 != null) {
                mergedList.addLast(itr1);
                itr1 = itr1.next;
            }
        }

        if (itr2 != null) {
            while (itr2 != null) {
                mergedList.addLast(itr2);
                itr2 = itr2.next;
            }
        }

        return mergedList.getHead();
    }

    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode runner = head;
        SinglyLinkedListNode current = head;
        for (int i = 0; i <= positionFromTail; i++) {
            runner = runner.next;
        }
        while (runner != null) {
            runner = runner.next;
            current = current.next;
        }
        return current != null ? current.data : 0;
    }

    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        SinglyLinkedListNode before = head;
        SinglyLinkedListNode after = before.next;
        while (after != null) {
            if (before.data == after.data) {
                before.next = after.next;
                after = before.next;
            } else {
                before = after;
                after = after.next;
            }
        }
        return head;
    }

    static boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;
        while (fast != null && fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode it1 = head1;
        while (it1 != null) {
            SinglyLinkedListNode temp = it1.next;
            it1.next = null;
            it1 = temp;
        }

        it1 = head2;
        while (it1 != null) {
            if (it1.next == null) {
                return it1.data;
            }
            it1 = it1.next;
        }

        return 0;
    }

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode current = head;
        if (head == null)
            return head;
        while (current != null) {
            head = current;
            System.out.println("current data = " + current.getData());
            DoublyLinkedListNode oldNext = current.getNext();
            DoublyLinkedListNode oldPrev = current.getPrev();
            current.setPrev(oldNext); // new prev
            current.setNext(oldPrev); // new next
            current = oldNext;
        }
        return head;
    }

}