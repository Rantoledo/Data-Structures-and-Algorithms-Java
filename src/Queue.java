
// this is a Queue from scratch 

class QueueItem {
	public int Element;
	public QueueItem next;
}

public class Queue {
	private int counter;
	private QueueItem first;
	private QueueItem last;
	private QueueItem temp;
	public Queue(){}
	public int Size(){return counter;}
	public void insert(int Elem){
		if (first == null){
			first = new QueueItem();
			first.Element = Elem;
			last = first;
			counter++;
		} else {
			temp = new QueueItem();
			temp.Element = Elem;
			last.next = temp;
			last = temp;
			counter++;
		}
	}
	public String delete(){
		if (first == null) {
			return "There are no items left in the queue.";
		} else if(Size()==1) {
			int Elem = first.Element;
			first = null;
			last = first;
			counter--;
			return "The Element " + Elem + " has been removed from the front of the Queue";
		} else {
			int Elem = first.Element;
			first = first.next;
			counter--;
			return "The Element " + Elem + " has been removed from the front of the Queue";
		}
	}
	public void View(){
		temp = first;
		System.out.println("The Queue contains the follwing elements, from front to back: ");
		if (Size()>0) {
			for(int k=0;k<Size();k++) {
				System.out.print(temp.Element + ", ");
				temp = temp.next;
			}
		}
		System.out.println("");
	}
}
