import java.util.*;

public class DataStructure {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        //implement queue as LinkedList, can easily remove head element
        LinkedList<Integer> queue = new LinkedList<>();

        //java PriorityQueue sorts elements in ascending order,
        //pass through comparator in constructor to sort in descending order
        PriorityQueue<Integer> priQueue = new PriorityQueue<Integer>(1,
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });

        try {
            while (sc.hasNextLine()) {
                //assume the underlying could be any of these until explicitly proven otherwise
                boolean canBeStack = true;
                boolean canBeQueue = true;
                boolean canBePriQueue = true;
                int counter = sc.nextInt();
                for (int i = 0; i < counter; i++) {
                    int type = sc.nextInt();
                    int value = sc.nextInt();
                    if (type == 1) {
                        //if type command is 1, we add the value to 3 structures
                        stack.push(value);
                        queue.add(value);
                        priQueue.add(value);
                    } else {
                        //otherwise, we remove the relevant value from our structures,
                        //and compare them to what the input set tells us was returned
                        //if they differ, this could not have been the underlying structure
                        if (stack.isEmpty() || stack.pop() != value) {
                            canBeStack = false;
                        }
                        if (queue.isEmpty() || queue.remove() != value) {
                            canBeQueue = false;
                        }
                        if (priQueue.isEmpty() || priQueue.poll() != value) {
                            canBePriQueue = false;
                        }
                    }
                }

                if (!canBeStack && !canBeQueue && !canBePriQueue) {
                    System.out.println("impossible");
                } else if (canBeStack && !canBeQueue && !canBePriQueue) {
                    System.out.println("stack");
                } else if (!canBeStack && canBeQueue && !canBePriQueue) {
                    System.out.println("queue");
                } else if (!canBeStack && !canBeQueue && canBePriQueue) {
                    System.out.println("priority queue");
                } else {
                    System.out.println("not sure");
                }

                stack = new Stack<>();
                queue.clear();
                priQueue.clear();

            }
            //EOF will now cause program to terminate rather than cause run-time error
        } catch (java.util.NoSuchElementException ignored) {
        }
    }
}