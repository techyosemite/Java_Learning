package objectCreation;

final class  CloneableClassExtension extends CloneableClass{
	
	int k = 99;
	
	int getK(){
		return k;
	}
	void setK(int k){
		this.k = k;
	}
	protected Object clone(){
		CloneableClassExtension obj = new CloneableClassExtension();
		obj.setF(99f);
		obj.setStr("NEW CLONE");
		obj.setI(99);
		obj.setK(k);
		return obj;
//			return super.clone();
	}
	
}
public  class CloneableClass implements Cloneable{

	public CloneableClass() {
		System.out.println("Inside constructor..");
	}
	int i = 10;
	float f = 20f;
	String str = "KARAN";
	
	int getI(){
		return i;
	}
	float getF(){
		return f;
	}
	String getStr(){
		return str;
	}
	void setI(int i){
		this.i = i;
	}
	void setF(float f){
		this.f = f;
	}
	void setStr(String str){
		this.str = str;
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		CloneableClass obj = new CloneableClass();
		CloneableClass obj1 = (CloneableClass) obj.clone();
		if(obj instanceof Cloneable)
			System.out.println("true...");
		else
			System.out.println("false...");
		if (obj1 instanceof Cloneable)
			System.out.println("true111");
		else
			System.out.println("false..");
		CloneableClass obj2 = (CloneableClass)obj1.clone();
		System.out.println(obj2.getI() + " --- " + obj2.getF() + " --- " + obj1.getStr());
		System.out.println("Object 1 Hash Code -- " + obj.hashCode());
		System.out.println("Object 2 hash code -- " + obj1.hashCode());
		System.out.println("Object 3 hash code -- " + obj2.hashCode());
		CloneableClassExtension extendedClassObject = new CloneableClassExtension();
		CloneableClassExtension extenstionObject1 = (CloneableClassExtension)extendedClassObject.clone();
		System.out.println(extenstionObject1.getClass());
		System.out.println(extenstionObject1.getStr());
		System.out.println(extenstionObject1.getK());
		
	}
}
