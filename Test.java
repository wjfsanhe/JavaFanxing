class Test {
class Food{
public String name = new String("Food");
};
class Fruit extends Food{
public String name = new String("Fruit");
};
class Apple extends Fruit{
public String name = new String("Apple");
};

static class Plate<T> {
private T mItem;
public Plate(T item){mItem = item;}
public void set (T item) {mItem = item;}
public T get () {return mItem;};
}
public static void main(String args[]){
	Test owner = new Test();
	owner.run("list");
};
public void run(String args){
	Plate<? extends Food> plate = new Plate<Apple>(new Apple());  // ?  represent compiler didn't know it's type exactly.
	//plate.set(new Apple());                    Compile Wrong
	//Apple apple =plate.get();			         Compile Wrong
	Apple apple =(Apple) plate.get();			 //Right , force convert , so setter must be user. 
	System.out.println("Food name : " + apple.name); // output Apple
	
	Plate<? super Food> plate2 = new Plate<Food> (new Apple());
	plate2.set(new Apple());
	plate2.set(new Fruit());  //OK
	//Apple t = (Apple)plate2.get(); //runtime Wrong , Fruit can't convert to Apple
	Fruit t = (Fruit)plate2.get(); 
	
	System.out.println("Food name : " + t.name); //output :  Fruit
	
	plate2.set(new Apple());
	t = (Fruit)plate2.get(); // ok , Object (Apple) can convert to Fruit. 
	System.out.println("Food name : " + t.name); //output :  Fruit
	Apple a = (Apple)plate2.get(); // ok , Object (Apple) can convert to Apple. 
	System.out.println("Food name : " + a.name); //output :  Apple
}
}
