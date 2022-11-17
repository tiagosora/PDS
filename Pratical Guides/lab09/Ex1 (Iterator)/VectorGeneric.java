// package Ex1;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class VectorGeneric<T> {
	private T[] vec;		
	private int nElem;	      
	private final static int ALLOC = 50;   
	private int dimVec = ALLOC;     

	@SuppressWarnings("unchecked")
	public VectorGeneric() {
		vec = (T[]) new Object[dimVec];
		nElem = 0;
	}
	
	public boolean addElem(T elem) {
		if (elem == null)
			return false;
		ensureSpace();
		vec[nElem++] = elem;
		return true;
	}

	private void ensureSpace() {
		if (nElem>=dimVec) {
			dimVec += ALLOC;
			@SuppressWarnings("unchecked")
			T[] newArray = (T[]) new Object[dimVec];
			System.arraycopy(vec, 0, newArray, 0, nElem );
			vec = newArray;
		}
	}

	public boolean removeElem(T elem) {
		for (int i = 0; i < nElem; i++) {
			if (vec[i].equals(elem)) {
				if (nElem-i-1 > 0) // not last element
					System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
				vec[--nElem] = null; // libertar último objecto para o GC
				return true;
			}
		}
		return false;
	}

	public int totalElem() {
		return nElem;
	}
	
	public T getElem(int i) {
		return (T) vec[i];
	}

	public Iterator<T> Iterator() {
		return (this).new VectotIterator<T>();
	}

	private class VectotIterator<K> implements Iterator<K> {
		private int index;

		public void VectorIterator() {
			index = 0;
		}
		@Override
		public boolean hasNext() {
			return (index < nElem);
		}
		@Override
		public K next() {
			if (hasNext())
				return (K)VectorGeneric.this.vec[index++];	
			throw new NoSuchElementException("Invalid index! There are only " + nElem + " elements.");
		}
		public void remove() {
			throw new UnsupportedOperationException("ERROR! Unsupported operation.");
		}
	}

	public ListIterator<T> listIterator() {
		return new VectorListIterator();
	}	

	public ListIterator<T> listIterator(int index) {
		return new VectorListIterator(index);
	}

	private class VectorListIterator<K> implements ListIterator<K> {
		private int index;

		VectorListIterator() {
			index = 0;
		}
		VectorListIterator(int i) {
			index = i;
		}
		public void add(K k) {
			throw new UnsupportedOperationException("ERROR! Unsupported operation.");
		}
		@Override
		public boolean hasNext() {
			return (index < nElem);
		}
		@Override
		public boolean hasPrevious() {
			return (index > 0);
		}
		@Override
		public K next() {
			if (hasNext())
				return (K)VectorGeneric.this.vec[index++];	
			throw new NoSuchElementException("Invalid index! There are only " + nElem + " elements.");
		}
		@Override
		public int nextIndex() {
			if (hasNext())
				return index + 1;
			return -1;
		}
		@Override
		public K previous() {
			if (hasPrevious())
				return (K)VectorGeneric.this.vec[index--];	
			throw new NoSuchElementException("Invalid index! There are only " + nElem + " elements.");
		}
		@Override
		public int previousIndex() {
			if (hasPrevious())
				return index - 1;
			return -1;
		}
		public void remove() {
			throw new UnsupportedOperationException("ERROR! Unsupported operation.");
		}
		public void set(K k) {
			throw new UnsupportedOperationException("ERROR! Unsupported operation.");
		}
	}
}
