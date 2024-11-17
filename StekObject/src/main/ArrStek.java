package main;

import java.util.Arrays;

import java.util.Iterator;

public class ArrStek <T>implements Iterable<T>{
	private T[] dataArray;
	private int size; // розмір
	private int capacity;//ємність
	private final int DEFAULT_CAPACITY=20;//масів з 20 елем.
	private final int MAX_STACK_SIZE=Integer.MAX_VALUE-1;//макс. вел.
	
	public ArrStek() {
		dataArray=(T[])new Object[DEFAULT_CAPACITY];
		capacity=dataArray.length;
		size=0;
	}
	public void push(T obj) {
		if(size>=capacity) {
			boolean resizeResult=upResize();
			if(!resizeResult) {
				throw new RuntimeException("Cant add element");
			}
		}
		dataArray[size]=obj;
		size+=1;
	}
			public boolean upResize() {
				if(capacity>=MAX_STACK_SIZE) {
					return false;
				}
				long newCapacityL=(capacity*3L)/2L+1L;
				int newCapacity=(newCapacityL<MAX_STACK_SIZE)?(int)newCapacityL:MAX_STACK_SIZE;
				dataArray=Arrays.copyOf(dataArray, newCapacity);
				capacity=newCapacity;
				return true;
			}
			 public T pop() {
				 if(size==0) {
					 return null;
				 }
				 size-=1;
				T element=dataArray[size];
				 dataArray[size]=null;
				 return element;
			 }
			 public T peek() {
				 if(size==0) {
					 return null;
				 }
				 return dataArray[size-1];
			 }
			 public int size() {
				 return size;
			 }
			 public void trimToSize() {
				 dataArray=Arrays.copyOf(dataArray,size);
				 capacity=dataArray.length;
			 }
			 public void clear() {
				 dataArray=(T[])new Object[DEFAULT_CAPACITY];
				 capacity=dataArray.length;
				 size=0;
			 }
			@Override
		    public String toString() {
		        StringBuilder result = new StringBuilder("[");
		        for (int i = 0; i < size; i++) {
		            if (i < size - 1) {
		                result.append(dataArray[i]).append(", ");
		            } else {
		                result.append(dataArray[i]);
		            }
		        }
		        return result.append("]").toString();
		    }
			 @Override
			    public Iterator<T> iterator() {
			        return new StackIterator();
			    }
			 private class StackIterator implements Iterator<T> {
			        private int currentIndex = size - 1;

			        @Override
			        public boolean hasNext() {
			            return currentIndex >= 0;
			        }
			        @Override
			        public T next() {
			            return dataArray[currentIndex--];
			        }
			 }
	}

