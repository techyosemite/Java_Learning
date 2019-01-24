package serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Automobile implements Externalizable {

	/*
	 * Instead of making thse members private and adding setter and getter
	 * methods, I am just giving default access specifier. You can make them
	 * private members and add setters and getters.
	 */
	String regNo;
	String mileage;

	/*
	 * A public no-arg constructor
	 */
	public Automobile() {
	}

	Automobile(String rn, String m) {
		regNo = rn;
		mileage = m;
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(regNo);
		out.writeObject(mileage);
	}

	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		regNo = (String) in.readObject();
		mileage = (String) in.readObject();
	}

}

class Car extends Automobile implements Externalizable {

	String name;
	int year;

	/*
	 * mandatory public no-arg constructor
	 */
	public Car() {
		super();
	}

	Car(String n, int y) {
		super("RegNo", "Mleage");
		name = n;
		year = y;
		
	}

	/**
	 * Mandatory writeExernal method.
	 */
	public void writeExternal(ObjectOutput out) throws IOException {
		// first we call the writeExternal of the superclass as to write
		// all the superclass data fields
		System.out.println("Inside write external!!");

		// Now the subclass fields
		super.writeExternal(out);
		out.writeObject(name);
		out.writeInt(year);
	}

	/**
	 * Mandatory readExternal method.
	 */
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		// first call the superclass external method
		System.out.println("Inside read external!!");

		super.readExternal(in);

		// Now the subclass fields
		name = (String) in.readObject();
		year = in.readInt();
	}

	/**
	 * Prints out the fields. used for testing!
	 */
	public String toString() {
		return ("Reg No: " + regNo + "\n" + "Mileage: " + mileage + "\nName: "
				+ name + "\n" + "Year: " + year);
	}
}

public class ExternalizableClass {
	public static void main(String[] args) throws IOException,
			ClassNotFoundException {

		Car obj = new Car("Karan Ratra", 999);
		FileOutputStream fout = new FileOutputStream(
				"/Users/karanratra/Desktop/Extern.exr");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(obj);

		FileInputStream fin = new FileInputStream(
				"/Users/karanratra/Desktop/Extern.exr");
		ObjectInputStream oin = new ObjectInputStream(fin);

		Object deserObj = (Car) oin.readObject();
		System.out.println(deserObj);

	}
}
