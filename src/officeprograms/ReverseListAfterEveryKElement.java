package officeprograms;

public class ReverseListAfterEveryKElement {


    LinkedList list;


    public void reverseList(LinkedList list) {


        Node current = list.getHEAD();

        Node first = null;

        Node save = null;


        list.setTAIL(list.getHEAD());


        while (current != null) {

            save = current;

            current = current.getNext();

            save.setNext(first);

            first = save;

        }


        list.setHEAD(save);


    }


    public void reverseListAfterEveryKElements(LinkedList list, int k) {


        Node newHead = list.getHEAD();

        for (int i = 0; i < k - 1; i++) {

            newHead = newHead.getNext();

        }

        

        Node temp, tempNext, current,currentTemp;

        current = list.getHEAD();

        currentTemp = null;        list.setHEAD(newHead);

        int count = 1;

        temp = null;

        LinkedList tempList = new LinkedList(current, null);

        

        while (current != null) {

            

            if (count == k) {

                temp = current;

                tempNext = current.getNext();

                tempList.setTAIL(current);

                tempList.getTAIL().setNext(null);

                reverseList(tempList);

                Node tempTail = tempList.getTAIL();

                tempTail.setNext(tempNext);

                if(currentTemp != null){

                currentTemp.setNext(tempList.getHEAD());

                }

                currentTemp = tempTail;

                current = tempNext;

                tempList = new LinkedList(current, null);

                count = 1;

            } else {

                count++;

                temp = current;

                temp.setNext(current.getNext());

                current = current.getNext();

            }

        }

        list.setTAIL(temp);

    }


    public static void main(String[] args) {

        

        Node n1 = new Node();

        Node n2 = new Node();

        Node n3 = new Node();

        Node n4 = new Node();

        Node n5 = new Node();

        Node n6 = new Node();

        Node n7 = new Node();


        n1.setKey("JAVA");

        n2.setKey("RUBY");

        n3.setKey("HTML");

        n4.setKey("ORACLE");

        n5.setKey("C++");

        n6.setKey("C");

        n7.setKey("Obj C");


        n1.setNext(n2);

        n2.setNext(n3);

        n3.setNext(n4);

        n4.setNext(n5);

        n5.setNext(n6);

        n6.setNext(n7);

        n7.setNext(null);

        

        LinkedList list = new LinkedList(n1, n6);
        list.traverseList();

        ReverseListAfterEveryKElement listObj = new ReverseListAfterEveryKElement();

        listObj.reverseListAfterEveryKElements(list, 6);

        System.out.println("List after traversal..");

        list.traverseList();
    }
}