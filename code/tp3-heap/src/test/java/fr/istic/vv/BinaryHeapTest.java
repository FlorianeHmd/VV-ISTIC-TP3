package fr.istic.vv;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTest {
    private static BinaryHeap<Integer> binaryHeap ;
    private static BinaryHeap<Integer> binaryHeapEmpty ;

    @BeforeEach
    public void setUp(){
        binaryHeap = new BinaryHeap<>((o1, o2) -> {
            if(o1<o2) return -1 ;
            else if (o1>o2) return 1 ;
            else return 0;
        }, new ArrayList<>(Arrays.asList(12, 11, 13, 5, 6, 7)));
        binaryHeapEmpty = new BinaryHeap<>((o1, o2) -> {
            if(o1<o2) return -1 ;
            else if (o1>o2) return 1 ;
            else return 0;
        }, new ArrayList<>());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCount1(){
        assertEquals(binaryHeap.count(),6);
    }
    @Test
    public void testCount2(){
        assertEquals(binaryHeapEmpty.count(),0);
    }

    @Test
    public void testPeek1(){
        assertEquals(binaryHeap.peek(),5);
    }

    @Test
    public void testPeek2() throws NoSuchElementException {
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            binaryHeapEmpty.peek();
        });
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains("The heap is empty"));
    }

    @Test
    public void testPop1(){
        assertEquals(binaryHeap.pop(),5);
        assertEquals(binaryHeap.peek(), 6);
        assertEquals(binaryHeap.count(), 5);
    }
    @Test
    public void testPop2() throws NoSuchElementException {
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            binaryHeapEmpty.pop();
        });
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains("The heap is empty"));
    }
    @Test
    public void testPush1(){
        binaryHeap.push(6);
        assertEquals(binaryHeap.count(), 7);
        assertEquals(binaryHeap.peek(), 5);
    }
    @Test
    public void testPush2(){
        binaryHeapEmpty.push(1);
        assertEquals(binaryHeapEmpty.count(), 1);
        assertEquals(binaryHeapEmpty.peek(), 1);
    }
    @Test
    public void testPush3(){
        binaryHeap.push(1);
        assertEquals(binaryHeap.count(), 7);
        assertEquals(binaryHeap.peek(), 1);
    }
    @Test
    public void testSort1(){
        binaryHeapEmpty.push(2);
        binaryHeapEmpty.push(4);
        binaryHeapEmpty.sort();
        assertEquals(binaryHeapEmpty.count(), 2);
    }
    @Test
    public void testSort2(){
        binaryHeapEmpty.push(2);
        binaryHeapEmpty.sort();
        assertEquals(binaryHeapEmpty.count(), 1);
    }
    @Test
    public void testSort3(){
        binaryHeapEmpty.push(4);
        binaryHeapEmpty.push(2);
        binaryHeapEmpty.push(1);
        binaryHeapEmpty.sort();
        assertEquals(binaryHeapEmpty.count(), 3);
    }



}