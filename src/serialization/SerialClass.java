package serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

class SuperNonSerializable {

	int k;

	SuperNonSerializable() {
		k = 39;
	}
}

class SerializeableClass implements Serializable {

	/**
	 * 
	 */
	// private static final long serialVersionUID = 1L;

	int i;

	float f;

	String str;

	// String newName;

	public SerializeableClass() {
		super();
		this.i = 20;
		this.f = 30;
		this.str = "KARAN";
		// this.newName = "new Name";
	}

	// public void setNewValues() {
	// this.newName = "new value!!";
	// }
}

public class SerialClass {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		//
		// SerializeableClass obj = new SerializeableClass();
		//
		// FileOutputStream fStream = new FileOutputStream(
		// "/Users/karanratra/Desktop/Object.ser");// Connection Stream
		// ObjectOutputStream oStream = new ObjectOutputStream(fStream);//
		// // Channel Stream
		//
		// oStream.writeObject(obj);
		// oStream.flush();
		// oStream.close();
		//
		FileInputStream fis = new FileInputStream(
				"/Users/karanratra/Desktop/Object.ser");
		ObjectInputStream oin = new ObjectInputStream(fis);
		SerializeableClass deserializedObject = (SerializeableClass) oin
				.readObject();

		// It proves that the constructor is not called while deserializing the
		// object .
		System.out.println(deserializedObject.i + " -- " + deserializedObject.f
				+ " -- " + deserializedObject.str);// + " -- "
		// + deserializedObject.k);
		// deserializedObject.setNewValues();

		// System.out.println("Again!!");
		// System.out.println(deserializedObject.i + " -- " +
		// deserializedObject.f
		// + " -- " + deserializedObject.str + " -- "
		// + deserializedObject.newName);
	}
}
