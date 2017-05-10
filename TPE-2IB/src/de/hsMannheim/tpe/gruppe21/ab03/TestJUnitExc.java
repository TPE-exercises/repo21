package de.hsMannheim.tpe.gruppe21.ab03;

import static org.junit.Assert.*;

import org.junit.Test;

import de.hsMannheim.tpe.gruppe21.ab03.myutil.ADT;
import de.hsMannheim.tpe.gruppe21.ab03.myutil.OverflowException;
import de.hsMannheim.tpe.gruppe21.ab03.myutil.UnderflowException;

public class TestJUnitExc {

	@Test(expected = OverflowException.class)
	public void overflowTestForStackArr() throws OverflowException {
		ADT stackArr = new StackArray(5);
		for (int i = 1; i <= 11; i++) {
			stackArr.enter(i);
		}
	}

	@Test(expected = OverflowException.class)
	public void overflowTestForQueueArr() throws OverflowException {
		ADT queueArr = new QueueArray(5);
		for (int i = 1; i <= 11; i++) {
			queueArr.enter(i);
		}
	}

	@Test(expected = OverflowException.class)
	public void overflowTestForStackLinkedList() throws OverflowException {
		ADT stackList = new StackLinkedList(5);
		for (int i = 1; i <= 11; i++) {
			stackList.enter(i);
		}
	}

	@Test(expected = OverflowException.class)
	public void overflowTestForQueueLinkedList() throws OverflowException {
		ADT queueList = new QueueLinkedList(5);
		for (int i = 1; i <= 11; i++) {
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
		
		for (int i = 1; i <= 10; i++) {
			stackArr.enter(i);
		}
		for (int i = 1; i <= 10; i++) {
			queueArr.enter(i);
		}
		for (int i = 1; i <= 10; i++) {
			stackList.enter(i);
		}
		for (int i = 1; i <= 10; i++) {
			queueList.enter(i);
		}
		
		assertEquals(10, stackArr.front());
		assertEquals(1, queueArr.front());
		assertEquals(10, stackList.front());
		assertEquals(1, queueList.front());
		
		
		
	}
	
	
	@Test
	public void sizeTest() throws OverflowException{
		ADT stackArr = new StackArray(5);
		ADT queueArr = new QueueArray(5);
		ADT stackList = new StackLinkedList(5);
		ADT queueList = new QueueLinkedList(5);
		
		for(int i = 1; i <= 10; i++){
			stackArr.enter(i);
		}
		
		for(int i = 1; i <= 10; i++){
			queueArr.enter(i);
		}
		
		for(int i = 1; i <= 10; i++){
			stackList.enter(i);
		}
		
		for(int i = 1; i <= 10; i++){
			queueList.enter(i);
		}
		
		
		assertEquals(10, stackArr.size());
		assertEquals(10, queueArr.size());
		assertEquals(10, stackList.size());
		assertEquals(10, queueList.size());
	}
	
	@Test(expected = UnderflowException.class)
	public void underflowTestForStackArr() throws UnderflowException{
		ADT stackArr = new StackArray(5);
		stackArr.leave();
	}
	
	@Test(expected = UnderflowException.class)
	public void underflowTestForQueueArr() throws UnderflowException{
		ADT queueArr = new QueueArray(5);
		queueArr.leave();
	}
	
	@Test(expected = UnderflowException.class)
	public void underflowTestForStackLinkedList() throws UnderflowException{
		ADT stackList = new StackLinkedList(5);
		stackList.leave();
	}
	
	@Test(expected = UnderflowException.class)
	public void underflowTestForQueueLinkedList() throws UnderflowException{
		ADT queueList = new QueueLinkedList(5);
		queueList.leave();
	}
	

}
