public class Schemer{
  public int scheduleCourse(int[][] courses) {
        if(courses.length==0)
            return 0;
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);

        int start=0;
        for(int[] course:courses){
            start+=course[0];
            pq.offer(course[0]);
            if(start>course[1])
              start-=pq.poll();
        }
        return pq.size();
    }
  }
}
