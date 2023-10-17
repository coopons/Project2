import java.util.Arrays;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * Program that prints the result of executing a series of
 * logical operations on subsets A and B and multisets A and B.
 * The operation "¬A" is exclusive to the subsets.
 *
 * @author Cooper Pons
 */
public class Main {
    public static void main(String[] args) {
        /* Initialize subsets A and B */
        boolean[] subset_A = {true, true, false};
        boolean[] subset_B = {false, false, true};

        /* Initialize and populate multisets A and B */
        Multiset<Integer> multi_A = HashMultiset.create();
        Multiset<Integer> multi_B = HashMultiset.create();

        multi_A.add(3,3);
        multi_A.add(7,1);
        multi_A.add(9,2);
        multi_A.add(6,5);

        multi_B.add(5,1);
        multi_B.add(1,8);
        multi_B.add(0,2);
        multi_B.add(2,3);

        /* Print operations for subsets A and B */
        printSubsetResults(subset_A, subset_B);

        /* Print operations for multiset A and multiset B */
        printMultisetResults(multi_A,multi_B);

    }
    /**
     * Print results of each logical operation for given subsets.
     *
     * @param A subset A
     * @param B subset A
     */
    public static void printSubsetResults(boolean[] A, boolean[] B) {
        System.out.println(" ¬A  : " + Arrays.toString(not(A)));
        System.out.println("A ∪ B: " + Arrays.toString(union(A, B)));
        System.out.println("A ∩ B: " + Arrays.toString(intersection(A, B)));
        System.out.println("A - B: " + Arrays.toString(difference(A, B)));
        System.out.println("A ⊕ B: " + Arrays.toString(symmetricDifference(A, B)));
    }

    public static <E> void printMultisetResults(Multiset<E> A, Multiset<E> B) {
        System.out.println("A ∪ B: " + multiUnion(A, B));
        System.out.println("A ∩ B: " + multiIntersection(A,B));
        System.out.println("A - B: " + multiDifference(A,B));
        System.out.println("A + B: " + multiSum(A,B));
    }

    /**
     * Not of subset A.
     *
     * @param A subset A
     * @return boolean array with logical inverse of A
     */
    public static boolean[] not(boolean[] A) {
        int n = A.length;
        boolean[] out = new boolean[n];
        for (int i = 0; i < n; i++) {
            out[i] = !A[i];
        }
        return out;
    }

    /**
     * Union of subsets A and B.
     *
     * @param A subset A
     * @param B subset B
     * @return boolean array of the logical operation, union
     */
    public static boolean[] union(boolean[] A, boolean[] B) {
        int n = A.length;
        boolean[] out = new boolean[n];
        for (int i = 0; i < n; i++) {
            out[i] = A[i] || B[i];
        }
        return out;
    }

    /**
     * Intersection of subsets A and B.
     *
     * @param A subset A
     * @param B subset B
     * @return boolean array of the logical operation, intersection
     */
    public static boolean[] intersection(boolean[] A, boolean[] B) {
        int n = A.length;
        boolean[] out = new boolean[n];
        for (int i = 0; i < n; i++) {
            out[i] = A[i] && B[i];
        }
        return out;
    }

    /**
     * Difference of subsets A and B.
     *
     * @param A subset A
     * @param B subset B
     * @return boolean array of the logical operation, difference
     */
    public static boolean[] difference(boolean[] A, boolean[] B) {
        int n = A.length;
        boolean[] out = new boolean[n];
        for (int i = 0; i < n; i++) {
            out[i] = A[i] && !B[i];
        }
        return out;
    }

    /**
     * Symmetric difference of subsets A and B.
     * (A - B) U (B - A)
     *
     * @param A subset A
     * @param B subset B
     * @return boolean array of the logical operation, symmetric difference
     */
    public static boolean[] symmetricDifference(boolean[] A, boolean[] B) {
        boolean[] C = difference(A, B);
        boolean[] D = difference(B, A);
        return union(C, D);
    }

    public static <E> Multiset<E> multiUnion(Multiset<E> A, Multiset<E> B){
        Multiset<E> out = HashMultiset.create(A);
        out.addAll(B);
        return out;
    }

    public static <E> Multiset<E> multiIntersection(Multiset<E> A, Multiset<E> B){
        Multiset<E> out = HashMultiset.create(A);
        out.retainAll(B);
        return out;
    }

    public static <E> Multiset<E> multiDifference(Multiset<E> A, Multiset<E> B){
        Multiset<E> out = HashMultiset.create(A);
        out.removeAll(B);
        return out;
    }

    public static <E> Multiset<E> multiSum(Multiset<E> A, Multiset<E> B){
        Multiset<E> out = HashMultiset.create(A);
        out.addAll(B);
        return out;
    }
}