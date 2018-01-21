// Student information for assignment
//
//  On <my> honor, Bryan Vuong,
//  this programming assignment is my own work.
//
//  Student Name: Bryan Vuong
//  Student UTEID: BKV85
//  Student CS307 class unique section id: 53280
//  Student email address: Vuong.bryan@gmail.com
//  Student TA name: Oliver Jensen

// Experiment results. CS307 students, place your experiment
// results here:

// Adding at end: ArrayList slightly but relatively equal
// Adding at front: LinkedList
// Removing from front: Linkedlist
// Get Random: ArrayList
// Get Iterator: Relatively equal
// Bet method: ArrayList

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class LinkedListTester {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<String>();
        Object[] actual;
        Object[] expected;

        
        // LinkedList Iterator Tests
        LinkedList<String> listTemp = new LinkedList<String>();
        listTemp.add("A");
        listTemp.add("B");
        listTemp.add("C");
        listTemp.add("D");
        listTemp.add("E");
        listTemp.add("F");
        listTemp.insert(2,"Z");

        Iterator<?> it = listTemp.iterator();
        String output = "";
        while(it.hasNext())
        	output += it.next() + ", ";
        System.out.println(output);
        
        it = listTemp.iterator();
        it.next();
        it.next();
        it.remove();
        System.out.println(listTemp);
        
        //test 0
        System.out.println("\nTest 0: initial list is empty");
        if( list.toString().equals("[]") )
            System.out.println("Passed test 0");
        else
            System.out.println("Failed test 0");

        //test 0.1
        System.out.println("\nTest 0.1: add to end");
        list.add("A");
        if( list.get(0).equals("A") )
            System.out.println("Passed test 0.1");
        else
            System.out.println("Failed test 0.1");  

        //test 0.2
        System.out.println("\nTest 0.2: size");
        if( list.size() == 1 )
            System.out.println("Passed test 0.2");
        else
            System.out.println("Failed test 0.2"); 

        //test 0.3
        System.out.println("\nTest 0.3: remove from position 0");
        String removed = list.remove(0);
        if(removed.equals("A"))
            System.out.println("Passed test 0.31");
        else
            System.out.println("Failed test 0.31");            

        System.out.println("\nTest 0.31: toStrin after remove");
        //test 0.31
        if( list.toString().equals("[]") )
            System.out.println("Passed test 0.3");
        else
            System.out.println("Failed test 0.3");  

        //test 0.4
        System.out.println("\nTest 0.4: size");
        if( list.size() == 0 )
            System.out.println("Passed test 0.4");
        else
            System.out.println("Failed test 0.4"); 

        //test 0.5
        System.out.println("\nTest 0.5: add and toString");
        list.add("A");
        list.add("B");
        if( list.toString().equals("[A, B]") )
            System.out.println("Passed test 0.5");
        else
            System.out.println("Failed test 0.5" + list.toString());  

        //test 0.6
        System.out.println("\nTest 0.6: size");
        if( list.size() == 2 )
            System.out.println("Passed test 0.6");
        else
            System.out.println("Failed test 0.6");


        //test 1
        System.out.println("\nTest 1: Adding at end");
        list = new LinkedList<String>();
        list.add("A");
        actual = toArray(list);
        expected = new Object[]{"A"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );		
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 1");
        else
            System.out.println("Failed test 1");


        //test 2
        System.out.println("\nTest 2: making empty");
        list.makeEmpty();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 2");
        else
            System.out.println("Failed test 2");


        //test 3
        System.out.println("\nTest 3: Adding at pos 0 in empty list");
        list.insert(0, "A");
        System.out.println(list);
        actual = toArray(list);
        expected = new Object[] {"A"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  		
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 3");
        else
            System.out.println("Failed test 3");



        //test 4
        System.out.println("\nTest 4: Adding at front");
        list = new LinkedList<String>();
        list.addFirst("A");
        actual = toArray(list);
        expected = new Object[] {"A"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 4");
        else
            System.out.println("Failed test 4");



        //test 5
        System.out.println("\nTest 5: Removing from front");
        list.removeFirst();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 5");
        else
            System.out.println("Failed test 5");


        //test 6
        list = new LinkedList<String>();
        System.out.println("\nTest 6: Adding at end");
        list.addLast("A");
        actual = toArray(list);
        expected = new Object[] {"A"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 6");
        else
            System.out.println("Failed test 6");


        //test 7
        System.out.println("\nTest 7: Removing from back");
        list.removeLast();
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 7");
        else
            System.out.println("Failed test 7");

        //test 8
        System.out.println("\nTest 8: Adding at middle");
        list = new LinkedList<String>();
        list.add("A");
        list.add("C");
        list.insert(1, "B");
        actual = toArray(list);
        expected = new Object[] {"A", "B", "C"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 8");
        else
            System.out.println("Failed test 8");


        //test 9
        System.out.println("\nTest 9: Setting");
        list = new LinkedList<String>();
        list.add("A");
        list.add("D");
        list.add("C");
        String oldValue = list.set(1, "B");
        actual = toArray(list);
        expected = new Object[] {"A", "B", "C"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 9.1");
        else
            System.out.println("Failed test 9.1");
        if( oldValue.equals("D") )
            System.out.println("Passed test 9.2");
        else
            System.out.println("Failed test 9.2");


        //test 10
        System.out.println("\nTest 10: Removing");
        list = new LinkedList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.remove(0);
        list.remove( list.size() - 1 );
        actual = toArray(list);
        expected = new Object[] {"B", "C"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if( arraysSame(actual, expected) )
            System.out.println("Passed test 10");
        else
            System.out.println("Failed test 10");
        
        
		System.out.println("\nTest 11: Remove Range");
		list = new LinkedList<String>();
		list.add("A");
		list.add("A");
		list.add("A");
		list.add("A");
		list.add("B");
		list.add("C");
		list.removeRange(1, 4);
		actual = toArray(list);
		expected = new Object[] {"A", "B", "C"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 11");
		else
			System.out.println("Failed test 11");

		System.out.println("\nTest 12: Remove Range");
		list = new LinkedList<String>();
		list.add("A");
		list.add("A");
		list.add("A");
		list.add("A");
		list.add("B");
		list.add("C");
		list.removeRange(1, 6);
		actual = toArray(list);
		expected = new Object[] {"A"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 12");
		else
			System.out.println("Failed test 12");

		System.out.println("\nTest 13: Remove Range");
		list = new LinkedList<String>();
		list.add("A");
		list.add("C");
		System.out.println(list.size());
		list.removeRange(0, 2);
		System.out.println(list);
		actual = toArray(list);
		expected = new Object[] {};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 13");
		else
			System.out.println("Failed test 13");


		System.out.println("\nTest 14: Remove Range");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.removeRange(1, 3);
		actual = toArray(list);
		expected = new Object[] {"A"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 14");
		else
			System.out.println("Failed test 14");

		System.out.println("\nTest 15: equals");
		LinkedList<String> listTwo = new LinkedList<String>();
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		listTwo.add("A");
		listTwo.add("B");
		listTwo.add("C");
		if( list.equals(listTwo))
			System.out.println("Passed test 15");
		else
			System.out.println("Failed test 15");
		if( list.size()==listTwo.size())
			System.out.println("Passed test 15.2 size()");
		else
			System.out.println("Failed test 15.2 size()");

		System.out.println("\nTest 16: equals");
		listTwo = new LinkedList<String>();
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.addFirst("Z");
		listTwo.add("Z");
		listTwo.add("A");
		listTwo.add("B");
		listTwo.addLast("C");
		if( list.equals(listTwo))
			System.out.println("Passed test 16");
		else
			System.out.println("Failed test 16");
		if( list.size()==listTwo.size())
			System.out.println("Passed test 16.2 size()");
		else
			System.out.println("Failed test 16.2 size()");

		System.out.println("\nTest 17: equals");
		listTwo = new LinkedList<String>();
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.remove("Z");
		listTwo.add("A");
		listTwo.add("B");
		listTwo.add("C");
		if( list.equals(listTwo))
			System.out.println("Passed test 17");
		else
			System.out.println("Failed test 17");
		if( list.size()==listTwo.size())
			System.out.println("Passed test 17.2 size()");
		else
			System.out.println("Failed test 17.2 size()");

		System.out.println("\nTest 18: add");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		actual = toArray(list);
		expected = new Object[] {"A","B","C","E","D","F"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 18");
		else
			System.out.println("Failed test 18");
		if( list.size()==expected.length)
			System.out.println("Passed test 18.2 size()");
		else
			System.out.println("Failed test 18.2 size()");

		System.out.println("\nTest 19: add");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		if( list.get(list.size()-1).equals("F")&&list.get(0).equals("A") )
			System.out.println("Passed test 19");
		else
			System.out.println("Failed test 19");
		if( list.size()==expected.length)
			System.out.println("Passed test 19.2 size()");
		else
			System.out.println("Failed test 19.2 size()");

		System.out.println("\nTest 20: add");
		list = new LinkedList<String>();
		list.add("A");
		list.add("F");
		expected = new Object[] {"A","F"};
		if( list.get(1).equals("F")&&list.get(0).equals("A") )
			System.out.println("Passed test 20");
		else
			System.out.println("Failed test 20");
		if( list.size()==expected.length)
			System.out.println("Passed test 20.2 size()");
		else
			System.out.println("Failed test 20.2 size()");


		System.out.println("\nTest 21: remove(int)");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		list.remove(1);
		list.remove(1);
		actual = toArray(list);
		expected = new Object[] {"A","E","D","F"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 21");
		else
			System.out.println("Failed test 21");
		if( list.size()==expected.length)
			System.out.println("Passed test 21.2 size()");
		else
			System.out.println("Failed test 21.2 size()");

		System.out.println("\nTest 22: remove(int)");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		list.remove(0);
		list.remove(0);
		actual = toArray(list);
		expected = new Object[] {"C","E","D","F"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 22");
		else
			System.out.println("Failed test 22");
		if( list.size()==expected.length)
			System.out.println("Passed test 22.2 size()");
		else
			System.out.println("Failed test 22.2 size()");

		System.out.println("\nTest 23: remove(int)");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		list.remove(list.size()-1);
		list.remove(list.size()-1);
		actual = toArray(list);
		expected = new Object[] {"A","B","C","E"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 23");
		else
			System.out.println("Failed test 23");
		if( list.size()==expected.length)
			System.out.println("Passed test 23.2 size()");
		else
			System.out.println("Failed test 23.2 size()");

		System.out.println("\nTest 24: remove(E)");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("A");
		list.add("D");
		list.add("F");
		list.remove("D");
		list.remove("A");
		actual = toArray(list);
		expected = new Object[] {"B","C","E","A","F"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 24");
		else
			System.out.println("Failed test 24");
		if( list.size()==expected.length)
			System.out.println("Passed test 24.2 size()");
		else
			System.out.println("Failed test 24.2 size()");

		System.out.println("\nTest 24: remove(E)");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("E");
		list.add("C");
		list.add("E");
		list.add("A");
		list.add("D");
		list.add("F");
		list.remove("E");
		list.remove("F");
		actual = toArray(list);
		expected = new Object[] {"A","B","C","E","A","D"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 24");
		else
			System.out.println("Failed test 24");
		if( list.size()==expected.length)
			System.out.println("Passed test 24.2 size()");
		else
			System.out.println("Failed test 24.2 size()");

		System.out.println("\nTest 24: remove(E)");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("A");
		list.add("D");
		list.add("F");
		list.remove("F");
		list.remove("A");
		actual = toArray(list);
		expected = new Object[] {"B","C","E","A","D"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 24");
		else
			System.out.println("Failed test 24");
		if( list.size()==expected.length)
			System.out.println("Passed test 24.2 size()");
		else
			System.out.println("Failed test 24.2 size()");

		System.out.println("\nTest 25: makeEmpty");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		list.makeEmpty();
		actual = toArray(list);
		expected = new Object[] {};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 25");
		else
			System.out.println("Failed test 25");
		if( list.size()==expected.length)
			System.out.println("Passed test 25.2 size()");
		else
			System.out.println("Failed test 25.2 size()");

		System.out.println("\nTest 26: makeEmpty");
		list = new LinkedList<String>();
		list.makeEmpty();
		actual = toArray(list);
		expected = new Object[] {};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 26");
		else
			System.out.println("Failed test 26");
		if( list.size()==expected.length)
			System.out.println("Passed test 26.2 size()");
		else
			System.out.println("Failed test 26.2 size()");

		System.out.println("\nTest 27: makeEmpty");
		list = new LinkedList<String>();
		list.addLast("A");
		list.makeEmpty();
		actual = toArray(list);
		expected = new Object[] {};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 27");
		else
			System.out.println("Failed test 27");
		if( list.size()==expected.length)
			System.out.println("Passed test 27.2 size()");
		else
			System.out.println("Failed test 27.2 size()");

		System.out.println("\nTest 28: indexOf(E)");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		int output2 = list.indexOf("C");
		int result = 2;
		System.out.println( "Expected result: " + result);
		System.out.println( "Actual result: " + output);  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 28");
		else
			System.out.println("Failed test 28");

		System.out.println("\nTest 29: indexOf(E)");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		output2 = list.indexOf("C");
		result = 2;
		System.out.println( "Expected result: " + result);
		System.out.println( "Actual result: " + output);  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 29");
		else
			System.out.println("Failed test 29");

		System.out.println("\nTest 30: indexOf(E)");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		output2 = list.indexOf("F");
		result = 5;
		System.out.println( "Expected result: " + result);
		System.out.println( "Actual result: " + output);  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 30");
		else
			System.out.println("Failed test 30");

		System.out.println("\nTest 31: indexOf(E,int)");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("C");
		list.add("F");
		output2 = list.indexOf("C",3);
		result = 4;
		System.out.println( "Expected result: " + result);
		System.out.println( "Actual result: " + output);  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 31");
		else
			System.out.println("Failed test 31");

		System.out.println("\nTest 32: indexOf(E,int)");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("G");
		list.add("F");
		output2 = list.indexOf("C",3);
		result = -1;
		System.out.println( "Expected result: " + result);
		System.out.println( "Actual result: " + output);  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 32");
		else
			System.out.println("Failed test 32");

		System.out.println("\nTest 33: indexOf(E,int)");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("C");
		list.add("F");
		output2 = list.indexOf("A",0);
		result = 0;
		System.out.println( "Expected result: " + result);
		System.out.println( "Actual result: " + output);  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 33");
		else
			System.out.println("Failed test 33");

		System.out.println("\nTest 34: addFirst");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		list.addFirst("Z");
		actual = toArray(list);
		expected = new Object[] {"Z","A","B","C","E","D","F"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 34");
		else
			System.out.println("Failed test 34");
		if( list.size()==expected.length)
			System.out.println("Passed test 34.2 size()");
		else
			System.out.println("Failed test 34.2 size()");

		System.out.println("\nTest 35: addFirst");
		list = new LinkedList<String>();
		list.addFirst("Z");
		list.addFirst("A");
		actual = toArray(list);
		expected = new Object[] {"A","Z"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 35");
		else
			System.out.println("Failed test 35");
		if( list.size()==expected.length)
			System.out.println("Passed test 35.2 size()");
		else
			System.out.println("Failed test 35.2 size()");

		System.out.println("\nTest 36: addFirst");
		list = new LinkedList<String>();
		list.addFirst("Z");
		list.add("D");
		list.addFirst("A");
		actual = toArray(list);
		expected = new Object[] {"A","Z","D"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 36");
		else
			System.out.println("Failed test 36");
		if( list.size()==expected.length)
			System.out.println("Passed test 36.2 size()");
		else
			System.out.println("Failed test 36.2 size()");

		System.out.println("\nTest 37: addLast");
		list = new LinkedList<String>();
		list.addLast("Z");
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		actual = toArray(list);
		expected = new Object[] {"Z","A","B","C","E","D","F"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 37");
		else
			System.out.println("Failed test 37");
		if( list.size()==expected.length)
			System.out.println("Passed test 37.2 size()");
		else
			System.out.println("Failed test 37.2 size()");

		System.out.println("\nTest 38: addLast");
		list = new LinkedList<String>();
		list.addLast("Z");
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		actual = toArray(list);
		expected = new Object[] {"Z","A","B","C","E","D","F"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 38");
		else
			System.out.println("Failed test 38");
		if( list.size()==expected.length)
			System.out.println("Passed test 38.2 size()");
		else
			System.out.println("Failed test 38.2 size()");

		System.out.println("\nTest 39: addLast");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.addLast("Z");
		list.add("E");
		list.add("D");
		list.add("F");
		actual = toArray(list);
		expected = new Object[] {"A","B","C","Z","E","D","F"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 39");
		else
			System.out.println("Failed test 39");
		if( list.size()==expected.length)
			System.out.println("Passed test 39.2 size()");
		else
			System.out.println("Failed test 39.2 size()");

		System.out.println("\nTest 40: addLast");
		list = new LinkedList<String>();
		list.addLast("Z");
		actual = toArray(list);
		expected = new Object[] {"Z"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 40");
		else
			System.out.println("Failed test 40");
		if( list.size()==expected.length)
			System.out.println("Passed test 40.2 size()");
		else
			System.out.println("Failed test 40.2 size()");

		System.out.println("\nTest 41: removeFirst");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		list.removeFirst();
		actual = toArray(list);
		expected = new Object[] {"B","C","E","D","F"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 41");
		else
			System.out.println("Failed test 41");
		if( list.size()==expected.length)
			System.out.println("Passed test 41.2 size()");
		else
			System.out.println("Failed test 41.2 size()");

		System.out.println("\nTest 42: removeFirst");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");;
		list.removeFirst();
		actual = toArray(list);
		expected = new Object[] {"B"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 42");
		else
			System.out.println("Failed test 42");
		if( list.size()==expected.length)
			System.out.println("Passed test 42.2 size()");
		else
			System.out.println("Failed test 42.2 size()");

		System.out.println("\nTest 43: removeFirst");
		list = new LinkedList<String>();
		list.add("Emil");
		list.removeFirst();
		actual = toArray(list);
		expected = new Object[] {};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 43");
		else
			System.out.println("Failed test 43");
		if( list.size()==expected.length)
			System.out.println("Passed test 43.2 size()");
		else
			System.out.println("Failed test 43.2 size()");

		System.out.println("\nTest 44: removeLast");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		list.removeLast();
		actual = toArray(list);
		expected = new Object[] {"A","B","C","E","D"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 44");
		else
			System.out.println("Failed test 44");
		if( list.size()==expected.length)
			System.out.println("Passed test 44.2 size()");
		else
			System.out.println("Failed test 44.2 size()");

		System.out.println("\nTest 45: removeLast");
		list = new LinkedList<String>();
		list.add("A");
		list.removeLast();
		actual = toArray(list);
		expected = new Object[] {};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 45");
		else
			System.out.println("Failed test 45");
		if( list.size()==expected.length)
			System.out.println("Passed test 45.2 size()");
		else
			System.out.println("Failed test 45.2 size()");

		System.out.println("\nTest 46: removeLast");
		list = new LinkedList<String>();
		list.add("Emil");
		list.removeLast();
		actual = toArray(list);
		expected = new Object[] {};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 46");
		else
			System.out.println("Failed test 46");
		if( list.size()==expected.length)
			System.out.println("Passed test 46.2 size()");
		else
			System.out.println("Failed test 46.2 size()");

		System.out.println("\nTest 47: insert");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		list.insert(3, "Z");
		actual = toArray(list);
		expected = new Object[] {"A","B","C","Z","E","D","F"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 47");
		else
			System.out.println("Failed test 47");
		if( list.size()==expected.length)
			System.out.println("Passed test 47.2 size()");
		else
			System.out.println("Failed test 47.2 size()");

		System.out.println("\nTest 48: insert");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		list.insert(1, "Z");
		actual = toArray(list);
		expected = new Object[] {"A","Z","B","C","E","D","F"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 48");
		else
			System.out.println("Failed test 48");
		if( list.size()==expected.length)
			System.out.println("Passed test 48.2 size()");
		else
			System.out.println("Failed test 48.2 size()");

		System.out.println("\nTest 49: insert");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.insert(1, "Z");
		actual = toArray(list);
		expected = new Object[] {"A","Z","B"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 49");
		else
			System.out.println("Failed test 49");
		if( list.size()==expected.length)
			System.out.println("Passed test 49.2 size()");
		else
			System.out.println("Failed test 49.2 size()");

		System.out.println("\nTest 50: insert");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.insert(0, "Z");
		actual = toArray(list);
		expected = new Object[] {"Z","A","B"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 50");
		else
			System.out.println("Failed test 50");
		if( list.size()==expected.length)
			System.out.println("Passed test 50.2 size()");
		else
			System.out.println("Failed test 50.2 size()");

		System.out.println("\nTest 51: insert");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		list.insert(list.size(), "Z");
		System.out.println(list.toString());
		actual = toArray(list);
		expected = new Object[] {"A","B","C","E","D","F","Z"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 51");
		else
			System.out.println("Failed test 51");
		if( list.size()==expected.length)
			System.out.println("Passed test 51.2 size()");
		else
			System.out.println("Failed test 51.2 size()");

		System.out.println("\nTest 52: getSubList");
		IList<String> resultingList = new LinkedList<String>();
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		resultingList = list.getSubList(0, 3);
		actual = toArray((LinkedList) resultingList);
		expected = new Object[] {"A","B","C"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 52");
		else
			System.out.println("Failed test 52");
		if( resultingList.size()==expected.length)
			System.out.println("Passed test 52.2 size()");
		else
			System.out.println("Failed test 52.2 size()");

		System.out.println("\nTest 53: getSubList");
		resultingList = new LinkedList<String>();
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		resultingList = list.getSubList(0, list.size());
		actual = toArray((LinkedList)resultingList);
		expected = new Object[] {"A","B","C","E","D","F"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 53");
		else
			System.out.println("Failed test 53");
		if( resultingList.size()==expected.length)
			System.out.println("Passed test 53.2 size()");
		else
			System.out.println("Failed test 53.2 size()");

		System.out.println("\nTest 54: getSubList");
		resultingList = new LinkedList<String>();
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("E");
		list.add("D");
		list.add("F");
		resultingList = list.getSubList(2, list.size());
		actual = toArray((LinkedList)resultingList);
		expected = new Object[] {"C","E","D","F"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 54");
		else
			System.out.println("Failed test 54");
		if( resultingList.size()==expected.length)
			System.out.println("Passed test 54.2 size()");
		else
			System.out.println("Failed test 54.2 size()");

		System.out.println("\nTest 55: toString");
		list = new LinkedList<String>();
		list.add("A");
		if( list.toString().equals("[A]") )
			System.out.println("Passed test 55");
		else
			System.out.println("Failed test 55");

		System.out.println("\nTest 56: toString");
		list = new LinkedList<String>();
		list.add("A");
		list.add("A");
		list.add("A");
		list.add("A");
		if( list.toString().equals("[A, A, A, A]") )
			System.out.println("Passed test 56");
		else
			System.out.println("Failed test 56");

		System.out.println("\nTest 57: toString");
		list = new LinkedList<String>();
		list.add("W");
		list.add("X");
		list.add("Y");
		list.add("Z");
		if( list.toString().equals("[W, X, Y, Z]") )
			System.out.println("Passed test 57");
		else
			System.out.println("Failed test 57");

		System.out.println("\nTest 58: set");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.set(1, "A");
		actual = toArray(list);
		expected = new Object[] {"A","A","C","D","E"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 58");
		else
			System.out.println("Failed test 58");
		if( list.size()==expected.length)
			System.out.println("Passed test 58.2 size()");
		else
			System.out.println("Failed test 58.2 size()");

		System.out.println("\nTest 59: set");
		list = new LinkedList<String>();
		list.add("A");
		list.set(0, "B");
		actual = toArray(list);
		expected = new Object[] {"B"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 59");
		else
			System.out.println("Failed test 59");
		if( list.size()==expected.length)
			System.out.println("Passed test 59.2 size()");
		else
			System.out.println("Failed test 59.2 size()");

		System.out.println("\nTest 60: set");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.set(1, "A");
		actual = toArray(list);
		expected = new Object[] {"A","A"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 60");
		else
			System.out.println("Failed test 60");
		if( list.size()==expected.length)
			System.out.println("Passed test 60.2 size()");
		else
			System.out.println("Failed test 60.2 size()");

		System.out.println("\nTest 61: get");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		if( list.get(0).equals("A") )
			System.out.println("Passed test 61");
		else
			System.out.println("Failed test 61");

		System.out.println("\nTest 62: get");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		if( list.get(3).equals("D") )
			System.out.println("Passed test 62");
		else
			System.out.println("Failed test 62");

		System.out.println("\nTest 63: get");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		if( list.get(list.size()-1).equals("E") )
			System.out.println("Passed test 63");
		else
			System.out.println("Failed test 63");

		System.out.println("\nTest 64: iterator");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		it = list.iterator();
		it.next();
		it.next();
		if( it.next().equals("C") )
			System.out.println("Passed test 64");
		else
			System.out.println("Failed test 64");

		System.out.println("\nTest 65: iterator");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		it = list.iterator();
		it.next();
		it.remove();
		if( it.next().equals("B") )
			System.out.println("Passed test 65");
		else
			System.out.println("Failed test 65");

		System.out.println("\nTest 66: iterator");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		it = list.iterator();
		it.next();
		it.next();
		it.next();
		it.next();
		it.next();
		if( !it.hasNext() )
			System.out.println("Passed test 66");
		else
			System.out.println("Failed test 66");

		System.out.println("\nTest 67: iterator");
		list = new LinkedList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		it = list.iterator();
		it.next();
		it.remove();
		it.next();
		it.next();
		it.remove();
		it.next();
		it.next();
		it.remove();
		actual = toArray(list);
		expected = new Object[] {"B","D"};
		System.out.println( "Expected result: " + Arrays.toString(expected) );
		System.out.println( "Actual result: " + Arrays.toString(actual) );  
		if( arraysSame(actual, expected) )
			System.out.println("Passed test 67");
		else
			System.out.println("Failed test 67");
		if( list.size()==expected.length)
			System.out.println("Passed test 67.2 size()");
		else
			System.out.println("Failed test 67.2 size()");
        
        

        // CS307 Students:
        // uncomment the following line to run tests comparing
        // your LinkedList class to the java ArrayList class.
        // comparison();
    }

    private static Object[] toArray(LinkedList<String> list) {
        Object[] result = new Object[list.size()];
        Iterator<String> it = list.iterator();
        int index = 0;
        while( it.hasNext() ){
            result[index] = it.next();
            index++;
        }
        return result;
    }

    //pre: none
    private static boolean arraysSame(Object[] one, Object[] two)  {
        boolean same;
        if( one == null || two == null ) {
            same = (one == two);
        }
        else {
            //neither one or two are null
            assert one != null && two != null;
            same = one.length == two.length;
            if( same ) {
                int index = 0;
                while( index < one.length && same ) {
                    same = ( one[index].equals(two[index]) );
                    index++;
                }
            }
        }
        return same;
    }

    // A method to be run to compare the LinkedList you are completing and the Java ArrayList class
    public static void comparison(){
        Stopwatch s = new Stopwatch();
        int initialN = 50000;
        int numTests = 5;


        addEndArrayList(s, initialN, numTests);
        addEndLinkedList(s, initialN, numTests);

        initialN = 10000;
        addFrontArrayList(s, initialN, numTests);
        addFrontLinkedList(s, initialN, numTests);

        removeFrontArrayList(s, initialN, numTests);
        removeFrontLinkedList(s, initialN, numTests);

        getRandomArrayList(s, initialN, numTests);
        getRandomLinkedList(s, initialN, numTests);

        getAllArrayListUsingIterator(s, initialN, numTests);
        getAllLinkedListUsingIterator(s, initialN, numTests);

        getAllArrayListUsingGetMethod(s, initialN, numTests);
        getAllLinkedListUsingGetMethod(s, initialN, numTests);

    }

    // These pairs of method illustarte a failure to use polymorphism
    // If the students had implemented the Java list interface there
    // could be a single method. Also we could use function objects to
    // reduce the awful repitition of code.
    public static void addEndArrayList(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Adding at end: ArrayList");
        int n = initialN;
        for(int i = 0; i < numTests; i++){
            System.out.print("Adding " + n + " elements to end of an ArrayList. ");
            s.start();
            for(int j = 0; j < n; j++)
                javaList.add(j);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
        }
    }

    public static void addEndLinkedList(Stopwatch s, int initialN, int numTests){
        System.out.println("Adding at end: LinkedList");
        int n = initialN;
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Adding " + n + " elements to end of a LinkedList. ");
            s.start();
            for(int j = 0; j < n; j++)
                studentList.add(j);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
        }
    }

    public static void addFrontArrayList(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Adding at front: ArrayList");
        int n = initialN;
        for(int i = 0; i < numTests; i++){
            System.out.print("Adding " + n + " elements to front of an ArrayList. ");
            s.start();
            for(int j = 0; j < n; j++)
                javaList.add(0, j);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
        }
    }

    public static void addFrontLinkedList(Stopwatch s, int initialN, int numTests){
        System.out.println("Adding at front: LinkedList");
        int n = initialN;
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Adding " + n + " elements to front of a LinkedList. ");
            s.start();
            for(int j = 0; j < n; j++)
                studentList.insert(0, j);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
        }
    }

    public static void removeFrontArrayList(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Removing from front: ArrayList");
        int n = initialN;
        for(int i = 0; i < numTests; i++){
            System.out.print("Removing " + n + " elements from front of an ArrayList. ");

            for(int j = 0; j < n; j++)
                javaList.add(j);
            s.start();
            while( !javaList.isEmpty())
                javaList.remove(0);
            s.stop();
            System.out.println("Time to add: " + s);
            n *= 2;
        }
    }

    public static void removeFrontLinkedList(Stopwatch s, int initialN, int numTests){
        System.out.println("removing from front: LinkedList");
        int n = initialN;
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Removing " + n + " elements from front of a LinkedList. ");
            for(int j = 0; j < n; j++)
                studentList.add(j);
            s.start();
            while( studentList.size() != 0 )
                studentList.removeFirst();
            s.stop();
            System.out.println("Time to remove: " + s);
            n *= 2;
        }
    }

    public static void getRandomArrayList(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Getting random: ArrayList");
        int n = initialN;
        int total = 0;
        Random r = new Random();
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting " + n + " elements from random locations in an ArrayList. ");

            for(int j = 0; j < n; j++)
                javaList.add(j);
            s.start();
            for(int j = 0; j < n; j++){
                total++;
                javaList.get( r.nextInt(n) );
            }
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
        }
    }

    public static void getRandomLinkedList(Stopwatch s, int initialN, int numTests){
        System.out.println("Getting random: LinkedList");
        int n = initialN;
        int total = 0;
        Random r = new Random();
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting " + n + " elements from random locations in a LinkedList. ");
            for(int j = 0; j < n; j++)
                studentList.add(j);
            s.start();
            for(int j = 0; j < n; j++){
                total++;
                studentList.get( r.nextInt(n) );
            }
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
        }
    }

    public static void getAllArrayListUsingIterator(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Getting all using iterator: ArrayList");
        int n = initialN;
        int total = 0;
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting all" + n + " elements from an ArrayList using the iterator. ");

            for(int j = 0; j < n; j++)
                javaList.add(j);

            Iterator<Integer> it = javaList.iterator();
            s.start();
            while( it.hasNext() ){
                total++;
                it.next();
            }        
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
        }
    }

    public static void getAllLinkedListUsingIterator(Stopwatch s, int initialN, int numTests){
        System.out.println("Getting all using iterator: LinkedList");
        int n = initialN;
        int total = 0;
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting all" + n + " elements from LinkedList using the iterator. ");
            for(int j = 0; j < n; j++)
                studentList.add(j);
            Iterator<Integer> it = studentList.iterator();

            s.start();
            while(it.hasNext()){
                total++;
                it.next();
            }
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
        }
    }

    public static void getAllArrayListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        ArrayList<Integer> javaList = new ArrayList<Integer>();
        System.out.println("Getting all using get method: ArrayList");
        int n = initialN;
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting all" + n + " elements from an ArrayList using the get method. ");

            for(int j = 0; j < n; j++)
                javaList.add(j);

            s.start();
            int x = 0;
            for(int j = 0; j < javaList.size(); j++){
                x += javaList.get(j);
            }
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
        }
    }

    public static void getAllLinkedListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        System.out.println("Getting all using get method: LinkedList");
        int n = initialN;
        LinkedList<Integer> studentList = new LinkedList<Integer>();
        for(int i = 0; i < numTests; i++){
            System.out.print("Getting all" + n + " elements from LinkedList using get method. ");
            for(int j = 0; j < n; j++)
                studentList.add(j);

            s.start();
            int x = 0;
            for(int j = 0; j < studentList.size(); j++){
                x += studentList.get(j);
            }
            s.stop();
            System.out.println("Time to get: " + s);
            n *= 2;
        }
    }
}