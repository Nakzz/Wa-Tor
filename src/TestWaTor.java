//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:            TestWarTor
// Files:            TestWarTor.java
// Semester:         Spring 2018
//
// Author:           Ajmain Naqib
// Email:            naqib@wisc.edu
// CS Login:         ajmain
// Lecturer's Name:  Marc        
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// No help received from any person or other source.
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


/**
 * This file contains testing methods for the WaTor project.
 * These methods are intended to serve several objectives:
 * 1) provide an example of a way to incrementally test your code
 * 2) provide example method calls for the WaTor methods
 * 3) provide examples of creating, accessing and modifying arrays
 *    
 * Toward these objectives, the expectation is that part of the 
 * grade for the WaTor project is to write some tests and
 * write header comments summarizing the tests that have been written. 
 * Specific places are noted with TODO but add any other comments 
 * you feel would be useful.
 * 
 * Some of the provided comments within this file explain
 * Java code as they are intended to help you learn Java.  However,
 * your comments and comments in professional code, should
 * summarize the purpose of the code, not explain the meaning
 * of the specific Java constructs.
 *    
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * This class contains a few methods for testing methods in the WaTor
 * class as they are developed. These methods are all private as they are only
 * intended for use within this class.
 * 
 * @author Jim Williams
 * @author Ajmain Naqib
 *
 */
public class TestWaTor {
    
    /**
     * This is the main method that runs the various tests. Uncomment the tests
     * when you are ready for them to run.
     * 
     * @param args  (unused)
     */
    public static void main(String []args) {

        //milestone 1
        testClearMoves();
        testEmptyArray();
        //testCountCreatures();
        
        //The best way to test the following is probably to compare
        //output with the examples.
        //showFishAndSharks
        //placeFish        
        //placeSharks      
       
        //milestone 2
//        testUnoccupiedPositions();
//        testChooseMove();
//        testFishPositions();
        
        //test code for fishPositions would be similar to test code for unoccupiedPositions
        //test fishSwimAndBreed and sharksHuntAndBreed may be easiest
        //by comparing output to examples.
        
        //milestone 3
        //comparing results of either inputting from or outputting to files
        //may be the easiest way to test.
    }
    
    /**
     * Compares the lists to see if they are the same size and contain the same elements.
     * @param list1 One list of coordinates.
     * @param list2 Another list of coordinates
     * @return Whether the lists contain the same coordinates or not.
     */
    private static boolean matchingArrayLists(ArrayList<int[]>list1, ArrayList<int[]>list2) {
        boolean result = true;
        if ( list1.size() != list2.size()) {
            System.err.println("list1 size: " + list1.size() + " list2 size:" + list2.size() + " should be the same");
             result = false;
             return result;
        } 
        for ( int i = 0; i < list1.size(); i++) {
            int[]move1 = list1.get(i);
            int[]move2 = list2.get(i);
            if ( move1[0] == move2[0] && move1[1] == move2[1]) {
                //ok
            } else {
                result = false;
                System.err.println( "list1("+ i+"):" + Arrays.toString(move1) + " doesn't match in list2: " + Arrays.toString( move2));
               
                break;
            }
        }
        return result;
    }
    
    /**
     * This runs some tests on the unoccupiedPositions method. 
     * 1. TODO describe each test in your own words. 
     * 2.
     */
    private static void testUnoccupiedPositions() {
        boolean error = false;
        
        int [][]fish = new int[][]{{-1,-1,-1},{-1,0,-1},{-1,-1,-1}};
        int [][]sharks = new int[][]{{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        
        ArrayList<int[]> positions = WaTor.unoccupiedPositions( fish, sharks, 1, 1);
        ArrayList<int[]>expected = new ArrayList<>();
        expected.add( new int[]{0,1});
        expected.add( new int[]{2,1});
        expected.add( new int[]{1,0});
        expected.add( new int[]{1,2});
        if ( !matchingArrayLists( expected, positions)) {
            error = true;
            System.err.println("testUnoccupiedPositions 1 :" );
        }
        
        positions = WaTor.unoccupiedPositions( fish, sharks, 0, 1);
        expected = new ArrayList<>();
        expected.add( new int[]{2,1});
        expected.add( new int[]{0,0});
        expected.add( new int[]{0,2});
        if ( !matchingArrayLists( expected, positions)) {
            error = true;
            System.err.println("testUnoccupiedPositions 2 :" );
        }
        
        positions = WaTor.unoccupiedPositions( fish, sharks, 0, 0);
        expected = new ArrayList<>();
        expected.add( new int[]{2,0});
        expected.add( new int[]{1,0});
        expected.add( new int[]{0,2});
        expected.add( new int[]{0,1});
        if ( !matchingArrayLists( expected, positions)) {
            error = true;
            System.err.println("testUnoccupiedPositions 3 :" );
        }        
        
        fish = new int[][]{{0,0,0},{0,0,0},{0,0,0}};
        sharks = new int[][]{{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        
        positions = WaTor.unoccupiedPositions( fish, sharks, 1, 1);
        expected = new ArrayList<>();

        if ( !matchingArrayLists( expected, positions)) {
            error = true;
            System.err.println("testUnoccupiedPositions 4 :" );
        }
        
        positions = WaTor.unoccupiedPositions( fish, sharks, 0, 1);
        expected = new ArrayList<>();

        if ( !matchingArrayLists( expected, positions)) {
            error = true;
            System.err.println("testUnoccupiedPositions 5 :" );
        }
        
        positions = WaTor.unoccupiedPositions( fish, sharks, 0, 0);
        expected = new ArrayList<>();

        if ( !matchingArrayLists( expected, positions)) {
            error = true;
            System.err.println("testUnoccupiedPositions 6 :" );
        }        
        fish = new int[][]{{0,0,0},{-1,0,0},{0,0,0}};
        sharks = new int[][]{{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
        
        positions = WaTor.unoccupiedPositions( fish, sharks, 1, 1);
        expected = new ArrayList<>();
        expected.add( new int[]{1,0});

        if ( !matchingArrayLists( expected, positions)) {
            error = true;
            System.err.println("testUnoccupiedPositions 7 :" );
        }
        
        positions = WaTor.unoccupiedPositions( fish, sharks, 0, 1);
        expected = new ArrayList<>();
        if ( !matchingArrayLists( expected, positions)) {
            error = true;
            System.err.println("testUnoccupiedPositions 8 :" );
        }
        
        positions = WaTor.unoccupiedPositions( fish, sharks, 0, 0);
        expected = new ArrayList<>();
        expected.add( new int[]{1,0});
        if ( !matchingArrayLists( expected, positions)) {
            error = true;
            System.err.println("testUnoccupiedPositions 9 :" );
        }
        
        if ( error) {
            System.err.println("testUnoccupiedPositions failed");
        } else {
            System.out.println("testUnoccupiedPositions passed");            
        }
    }
    
    /**
     * This runs some tests on the fishPositions method. 
     * 1. TODO describe each test in your own words. 
     * 2.
     */
    private static void testFishPositions() {
        
        //TODO Implement in Milestone 2
    }
    
    /**
     * This runs some tests on the chooseMove method. 
     * 1. TODO describe each test in your own words. 
     * 2.
     */    
    private static void testChooseMove() {
        boolean error = false;
        Random randGen = new Random();
        randGen.setSeed( 456);
        
        ArrayList<int[]> input = new ArrayList<>();
        int [] expected = null;
        int [] result = WaTor.chooseMove( input, randGen);
        if ( result != expected) {
            error = true;
            System.err.println("testChooseMove 0: result not null");
        }
        
        input.clear();
        int [] oneMove = new int[] {0,1};
        input.add(oneMove);
        expected = oneMove;
        result = WaTor.chooseMove( input, randGen);
        if ( result != expected) {
            error = true;
            System.err.println("testChooseMove 1: result not " + Arrays.toString( oneMove));
        }
        
        input.clear();
        int [] move1 = new int[] {0,1};
        int [] move2 = new int[] {1,0};
        input.add( move1);
        input.add( move2);
        int move1Count = 0;
        int move2Count = 0;
        int numTrials = 1000;
        for ( int i = 0; i < numTrials; i++) {
            result = WaTor.chooseMove( input, randGen);
            if ( result == move1) move1Count++; 
            else if ( result == move2) move2Count++;
        }
        if ( move1Count != 513 || move2Count != 487 ) {
            error = true;
            System.err.println("testChooseMove 2: expected 513,487 move1Count=" + move1Count + " move2Count=" + move2Count);
        }
        
        input.clear();
        move1 = new int[] {0,1};
        move2 = new int[] {1,0};
        int[] move3 = new int[] {2,1};
        input.add( move1);
        input.add( move2);
        input.add( move3);
        move1Count = 0;
        move2Count = 0;
        int move3Count = 0;
        numTrials = 1000;
        for ( int i = 0; i < numTrials; i++) {
            result = WaTor.chooseMove( input, randGen);
            if ( result == move1) move1Count++; 
            else if ( result == move2) move2Count++;
            else if ( result == move3) move3Count++;
        }
        if ( move1Count != 325 || move2Count != 341 || move3Count != 334 ) {
            error = true;
            System.err.println("testChooseMove 3: expected 325,341,334 move1Count=" + move1Count + " move2Count=" + move2Count + " move3Count=" + move3Count);
        }
        
        input.clear();
        move1 = new int[] {0,1};
        move2 = new int[] {1,0};
        move3 = new int[] {2,1};
        int []move4 = new int[] {1,2};
        input.add( move1);
        input.add( move2);
        input.add( move3);
        input.add( move4);
        move1Count = 0;
        move2Count = 0;
        move3Count = 0;
        int move4Count = 0;
        numTrials = 1000;
        for ( int i = 0; i < numTrials; i++) {
            result = WaTor.chooseMove( input, randGen);
            if ( result == move1) move1Count++; 
            else if ( result == move2) move2Count++;
            else if ( result == move3) move3Count++;
            else if ( result == move4) move4Count++;
        }
        if ( move1Count != 273 || move2Count != 231 || move3Count != 234 || move4Count != 262 ) {
            error = true;
            System.err.println("testChooseMove 4: expected 325,341,334,262 move1Count=" + move1Count + " move2Count=" + move2Count + " move3Count=" + move3Count + " move4Count=" + move4Count);
        }

        if ( error) {
            System.err.println("testChooseMove failed");
        } else {
            System.out.println("testChooseMove passed");            
        }
    }
    
    /**
     * This runs some tests on the clearMoves method. 
     * 
     * This test assigns true to each cell of the array, then calls the clearMoves method from 
     * WarTor.java. Given that the method works perfectly fine, each of the cell should be false.
     * Next this test method checks if any of the cell is assigned as true, if so, the test fails.
     * Otherwise the test passes.
     *  
     */        
    private static void testClearMoves() {
        boolean error = false;
        boolean [][] moves = new boolean[4][9];
        for (int row = 0; row < moves.length; row++) {
            for (int col = 0; col < moves[row].length; col++) {
                moves[row][col] = true;
            }
        }        
        WaTor.clearMoves(moves);
        for (int row = 0; row < moves.length; row++) {
            for (int col = 0; col < moves[row].length; col++) {
                if ( moves[row][col]) {
                    System.err.println("testClearMoves 0: move " + row + "," + col + " not false");
                    error = true;
                    break;
                }
            }
        }    
        if ( error) {
            System.err.println("testClearMoves failed");
        } else {
            System.out.println("testClearMoves passed");            
        }        
    }
    
    /**
     * This runs some tests on the emptyArray method. 
     * 
     * This test assigns a value to each cell of the array, then calls the emptyArray method from 
     * WarTor.java. Given that the method works perfectly fine, each of the cell should be empty.
     * Next this test method checks if any of the cell is assigned a value other than Config.EMPTY, 
     * if so, prints out the coordinate of the occupied cell and the test fails. Otherwise the test passes.
     * 
     */        
    private static void testEmptyArray() {
        boolean error = false;
        int [][] moves = new int[100][99];
        for (int row = 0; row < moves.length; row++) {
            for (int col = 0; col < moves[row].length; col++) {
                moves[row][col] = Config.EMPTY + 2; //make sure not EMPTY
            }
        }        
        WaTor.emptyArray(moves);
        for (int row = 0; row < moves.length; row++) {
            for (int col = 0; col < moves[row].length; col++) {
                if ( moves[row][col] != Config.EMPTY) {
                    System.err.println("testEmptyArray 0: move " + row + "," + col + " not EMPTY");
                    error = true;
                    break;
                }
            }
        }    
        if ( error) {
            System.err.println("testEmptyArray failed");
        } else {
            System.out.println("testEmptyArray passed");            
        }            
    }
    
    /**
     * This runs some tests on the countFish method. 
     * 1. TODO describe each test in your own words. 
     * 2.
     */        
    private static void testCountCreatures() {
        boolean error = false;

        int[][] fish = new int[7][3];
        WaTor.emptyArray(fish);
        fish[0][0] = 1;
        fish[6][2] = 2;
        fish[0][2] = 3;
        fish[6][0] = 4;
        fish[3][1] = 5;
        int result = WaTor.countCreatures( fish);
        if ( result != 5) {
            System.err.println("testCountCreatures 0: expected 5 found " + result );
            error = true;
        }

        if ( error) {
            System.err.println("testCountCreatures failed");
        } else {
            System.out.println("testCountCreatures passed");            
        }              
    }

}