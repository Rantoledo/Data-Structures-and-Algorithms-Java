import java.util.ArrayList;

public class arrays {
	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

		if (intervals == null || newInterval == null){ return null;}
		if (newInterval.start > newInterval.end){
			int temp = newInterval.start;
			newInterval.start = newInterval.end; 
			newInterval.end = temp;
		}

		int[] index = new int[intervals.size()];

		for (int i=0 ; i < intervals.size() ; i++){
			boolean check = checkInter(newInterval, intervals.get(i));
			if(check){
				index[i] = 1;
			}
		}
		int firstindex = -1;
		for (int i=0 ; i < intervals.size() ; i++){
			if (index[i] == 1){
				firstindex = i;
				break;
			}
		}
		int lastindex = -1;
		for (int i=intervals.size()-1 ; i > -1 ; i--){
			if (index[i] == 1){
				lastindex = i;
				break;
			}
		}

		ArrayList<Interval> finall = new ArrayList<Interval>();
		Interval mergedInter = new Interval();

		if (lastindex != -1 || firstindex != -1){
			mergedInter = mergeIntervals(intervals.get(firstindex),intervals.get(lastindex),newInterval);
			for (int i=0 ; i < intervals.size() ; i++){
				if (index[i] == 0){
					finall.add(intervals.get(i));
				}
				if (index[i] == 1){
					finall.add(mergedInter);
					i = lastindex;
				}
			}
		}
		else{ // no merges at all
			boolean flag = true;
			for (int i=0 ; i < intervals.size() ; i++){
				Interval curr = intervals.get(i);
				if (newInterval.start < curr.start && flag){
					finall.add(newInterval);
					flag = false;
				}
				finall.add(curr);
			}
			if(flag){
				finall.add(newInterval);
			}
		}
		return finall;
	}
	
	public static Interval mergeIntervals(Interval first, Interval last, Interval newInterval){
		if (newInterval.start <= first.start && newInterval.end >= last.end){
			return newInterval;
		}
		if (newInterval.start >= first.start && newInterval.end >= last.end){
			return new Interval(first.start, newInterval.end);
		}
		if (newInterval.start >= first.start && newInterval.end <= last.end){
			return new Interval(first.start, last.end);
		}
		if (newInterval.start <= first.start && newInterval.end <= last.end){
			return new Interval(newInterval.start, last.end);
		}
		return null;
	}

	public static boolean checkInter(Interval newInterval, Interval current){
		if (newInterval.start >= current.start && newInterval.end <= current.end){ 
			return true;
		}
		if ((newInterval.start >= current.start && newInterval.start <= current.end) && current.end <= newInterval.end){
			return true;
		}
		if (newInterval.start <= current.start && (newInterval.end <= current.end && newInterval.end >= current.start)){
			return true;
		}
		if (newInterval.start <= current.start && newInterval.end >= current.end){
			return true;
		}
		return false;
	}
}
