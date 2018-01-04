class Test {
class Food{};
class Fruit extends Food{};
class Apple extends Fruit{};

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
	Plate<? extends Fruit> plate = new Plate<Apple>(new Apple());
}
}
