package de.hsMannheim.tpe.gruppe21.ab03;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hsMannheim.tpe.gruppe21.ab03.myutil.ADT;
import de.hsMannheim.tpe.gruppe21.ab03.myutil.OverflowException;

public class TestJUnitExc {

	@Test(expected = OverflowException.class)
	public void overflowTestForStackArr() throws OverflowException {
		ADT stackArr = new StackArray(5);
		for (int i = 0; i <= 11; i++) {
			stackArr.enter(i);
		}
	}

	@Test(expected = OverflowException.class)
	public void overflowTestForQueueArr() throws OverflowException {
		ADT queueArr = new QueueArray(5);
		for (int i = 0; i <= 11; i++) {
			queueArr.enter(i);
		}
	}

	@Test(expected = OverflowException.class)
	public void overflowTestForStackLinkedList() throws OverflowException {
		ADT stackList = new StackLinkedList(5);
		for (int i = 0; i <= 11; i++) {
			stackList.enter(i);
		}
	}

	@Test(expected = OverflowException.class)
	public void overflowTestForQueueLinkedList() throws OverflowException {
		ADT queueList = new QueueLinkedList(5);
		for (int i = 0; i <= 11; i++) {
			queueList.enter(i);
		}
	}
	
	
	@Test
	public void isEmptyTest() throws OverflowException{
		ADT stackArr = new StackArray(5);
		ADT queueArr = new QueueArray(5);
		ADT stackList = new StackLinkedList(5);
		ADT queueList = new QueueLinkedList(5);
		
		assertEquals(true, stackArr.isEmpty());
		assertEquals(true, queueArr.isEmpty());
		assertEquals(true, stackList.isEmpty());
		assertEquals(true, queueList.isEmpty());
		
		
		
		stackArr.enter(1);
		queueArr.enter(1);
		stackList.enter(1);
		queueList.enter(1);
		
		assertEquals(false, stackArr.isEmpty());
		assertEquals(false, queueArr.isEmpty());
		assertEquals(false, stackList.isEmpty());
		assertEquals(false, queueList.isEmpty());
	}

	
	
	@Test
	public void frontTest() throws OverflowException{
		ADT stackArr = new StackArray(5);
		ADT queueArr = new QueueArray(5);
		ADT stackList = new StackLinkedList(5);
		ADT queueList = new QueueLinkedList(5);
		
		for (int i = 0; i <= 10; i++) {
			stackArr.enter(i);
		}
		for (int i = 0; i <= 10; i++) {
			queueArr.enter(i);
		}
		for (int i = 0; i <= 10; i++) {
			stackList.enter(i);
		}
		for (int i = 0; i <= 10; i++) {
			queueList.enter(i);
		}
		
		assertEquals(10, stackArr.front());
		assertEquals(0, queueArr.front());
		assertEquals(10, stackList.front());
		assertEquals(0, queueList.front());
		
		
		
	}
	
	
	@Test
	public void sizeTest() throws OverflowException{
		ADT stackArr = new StackArray(5);
		ADT queueArr = new QueueArray(5);
		ADT stackList = new StackLinkedList(5);
		ADT queueList = new QueueLinkedList(5);
		
		for(int i = 0; i <= 10; i++){
			stackArr.enter(i);
		}
		
		queueArr.enter(1);
		queueArr.enter(1);
		
		stackList.enter(1);
		stackList.enter(1);
		
		queueList.enter(1);
		queueList.enter(1);
		
		
		assertEquals(10, stackArr.size());
		assertEquals(2, queueArr.size());
		assertEquals(2, stackList.size());
		assertEquals(2, queueList.size());
	}
	
	
	

}
