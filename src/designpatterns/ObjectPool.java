package designpatterns;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class Test {

	int i;

	String name;

	Test(int i, String name) {
		this.i = i;
		this.name = name;
	}
}

abstract class ReuseableObjectPool<T> {

	protected HashMap<T, Long> locked, unlocked;

	protected abstract T create();

	public abstract boolean validate(T o);

	public abstract void expire(T o);

	private long expirationTime;

	public ReuseableObjectPool() {
		locked = new HashMap<T, Long>();
		unlocked = new HashMap<T, Long>();
		expirationTime = 30000;

	}

	public synchronized T checkout() {
		long now = System.currentTimeMillis();

		T t;
		if (unlocked.size() > 0) {

			Iterator<Map.Entry<T, Long>> itr = (Iterator<Map.Entry<T, Long>>) unlocked
					.entrySet().iterator();
			
			while (itr.hasNext()) {

				Map.Entry<T, Long> entry = itr.next();

				t = entry.getKey();

				if (now - entry.getValue() > expirationTime) {

					itr.remove();

					expire(entry.getKey());

					t = null;

				} else {

					if (validate(entry.getKey())) {

						itr.remove();

						locked.put(t, now);

						return t;

					} else {
						// Object failed validation
						itr.remove();

						expire(t);

						t = null;
					}
				}

			}
		}
		// No objects available
		// Create a new one

		t = create();
		locked.put(t, now);
		return t;
	}

	public synchronized void checkIn(T t) {
		locked.remove(t);
		unlocked.put(t, System.currentTimeMillis());
	}
}

class TestPool extends ReuseableObjectPool<Test> {

	private int increment;

	private static TestPool testPool;

	private TestPool() {
		super();
		for (int i = 0; i < 5; i++) {
			unlocked.put(new Test(i, "Karan-" + i), System.currentTimeMillis());
			increment++;
		}
	}

	@Override
	protected Test create() {
		return new Test(increment++,"Karan --"  + increment);
	}

	@Override
	public boolean validate(Test o) {
		System.out.println("Iinside validate...");
		if(o.i  < 2 )
			return true;
		else 
			return false;
	}

	@Override
	public void expire(Test o) {
			System.out.println("Expire the object...");
	}
	
	public static TestPool getInstance(int inputParameter1,int parameter2){
		if(testPool == null){
			synchronized (TestPool.class) {
				if(testPool == null){
					testPool = new TestPool();
				}
			}
		}
		return testPool;
	}

}

public class ObjectPool {


public static void iterateMap(){
	Map<Test,Long> m = new HashMap<Test, Long>();
	
	m.put(new Test(10,"Karan"),  90000l);
	m.put(new Test(10,"Rahul"),  90000l);
	m.put(new Test(10,"Nitin"),  90000l);
	m.put(new Test(10,"JS"),  90000l);
	
	Iterator<Map.Entry<Test, Long>> itr  = m.entrySet().iterator();


}

	public static void main(String[] args) {

		System.out.println("Inside main..");
		TestPool pool = TestPool.getInstance(2, 2);
		Test obj = pool.checkout();
		System.out.println(obj.i + " -- " + obj.name);
		pool.checkIn(obj);
	}

}
