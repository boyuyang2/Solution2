package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        List<Integer> list = new ArrayList();
        for (int i=0; i<keyboards.length; i++){
            for (int j=0; j<drives.length; j++) {
                int sum = keyboards[i] + drives[j];
                if ( sum <= b) {
                    list.add(sum);
                }
            }
        }
        int total = -1;
        if (!list.isEmpty()) {
            list.sort(Comparator.reverseOrder());
            total = list.get(0);
        }
        return total;
    }
    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++){
            if (map.get(ar.get(i)) == null){
                map.put(ar.get(i), 1);
            } else {
                Integer v = map.get(ar.get(i)) + 1;
                map.put(ar.get(i), v);
            }
        }
        Set<Integer> set = map.keySet();
        for (Integer i:set){
            Integer v2 = map.get(i);
            total = total + v2/2;
        }
        return total;
    }
    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        Map<Integer, Integer> map = new HashMap();
        for (int i=0; i<a.size(); i++){
            for (int j=0; j<a.size(); j++){
                if (a.get(i) - a.get(j) <= 1 && a.get(i) - a.get(j) >= 0){
                    if (map.get(i) == null){
                        map.put(i, 1);
                    } else {
                        map.put(i, map.get(i)+1);
                    }
                }
            }
        }
        int max = 0;
        for (Integer l : map.values()){
            System.out.println(l);
            if (l > max){
                max = l;
            }
        }
        return max;
    }
    public static int hurdleRace(int k, List<Integer> height) {
        int max = k;
        for (Integer i:height){
            if (i>max){
                max = i;
            }
        }
        return max-k;

    }

    public static int designerPdfViewer(List<Integer> h, String word) {
        char[] ar = word.toCharArray();
        int maxh = 0;
        for (char c:ar){
            int index = (int)c - 97;
            int k = h.get(index);
            if (k>maxh){
                maxh = k;
            }
        }
        return maxh * ar.length;
    }
    public static List<String> cavityMap(List<String> grid) {
        int n = grid.size();
        char[][] matrix = new char[n][n];
        for (int i=0; i<n; i++){
            String row = grid.get(i);
            char[] ar = row.toCharArray();
            for (int j=0; j<n; j++){
                matrix[i][j] = ar[j];
            }
        }
        List<String> list = new ArrayList();
        char[][] matrix2 = new char[n][n];
        for (int i=1; i<n-1; i++){
            for (int j=1; j<n-1; j++){
                if (matrix[i][j]>matrix[i][j-1] && matrix[i][j]>matrix[i][j+1] && matrix[i][j]>matrix[i-1][j] && matrix[i][j]>matrix[i+1][j]){
                    matrix2[i][j] = 'X';
                } else {
                    matrix2[i][j] = 'Y';
                }
            }
        }
        for (int i=0; i<n; i++){
            char[] row = new char[n];
            for (int j=0; j<n; j++){
                if (matrix2[i][j] == 'X'){
                    matrix[i][j] = 'X';
                }
                row[j] = matrix[i][j];
            }
            list.add(new String(row));
        }
        return list;
    }
    public static int utopianTree(int n) {
        int m = 1;
        for (int i=0; i<=n; i++){
            if (i>0 && i%2 == 1){
                m = m*2;
            } else if (i>0) {
                m = m + 1;
            }
        }
        return m;
    }
    public static String angryProfessor(int k, List<Integer> a) {
        int count = 0;
        for (int i:a){
            if (i<=0){
                count++;
            }
        }
        if (count >= k){
            return "NO";
        } else {
            return "YES";
        }
    }
    public static int beautifulDays(int i, int j, int k) {
        int sum = 0;
        for (int m=i; m<=j; m++){
            Integer mm = Integer.valueOf(m);
            String nn = mm.toString();
            StringBuilder buf = new StringBuilder();
            buf.append(nn);
            buf.reverse();
            Integer rev = Integer.parseInt(buf.toString());
            if ((mm - rev) % k == 0){
                sum++;
            }
        }
        return sum;
    }
    public static int viralAdvertising(int n) {
        int si = 5;
        int like = 0;
        int sum = 0;
        for (int i=1; i<=n; i++){
            like = si / 2;
            sum = sum + like;
            si = like * 3;
        }
        return sum;
    }
    public static void staircase(int n) {
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                if ((n - (i+j)) > 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }
    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> lst = new ArrayList();
        for (Integer g:grades){
            int d = g/5;
            int m = d * 5 + 5;
            int r = m - g;
            int n = g;
            if (d >= 3 && r < 3){
                n = m;
                if (n < 40){
                    n = g;
                }
            }
            lst.add(n);
        }
        return lst;
    }
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        int ap_cnt = 0;
        for (Integer ap : apples){
            ap = ap + a;
            if (ap >= s && ap <=t){
                ap_cnt++;
            }
        }
        System.out.println(ap_cnt);
        int or_cnt = 0;
        for (Integer or : oranges){
            or = or + b;
            if (or >= s && or <= t){
                or_cnt++;
            }
        }
        System.out.println(or_cnt);
    }
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        if (v1 == v2){
            return "NO";
        }

        int n = (x2 - x1)/(v1 - v2);
        int r = (x2 - x1)%(v1 - v2);
        System.out.println(n);
        System.out.println(r);
        if (n >= 1 && r == 0){
            return "YES";
        } else {
            return "NO";
        }
    }
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        a.sort(Comparator.reverseOrder());
        b.sort(Comparator.naturalOrder());
        int maxa = a.get(0);
        int minb = b.get(0);
        List<Integer> l = new ArrayList();
        for (int i=maxa; i<=minb; i++){
            boolean all=true;
            for (int j:a){
                if (i % j > 0){
                    all = false;
                    break;
                }
            }
            if (all){
                l.add(i);
            }
        }

        int total = 0;
        for (Integer m:l) {
            boolean all=true;
            for (Integer k : b) {
                if (k % m >0){
                    all = false;
                    break;
                }
            }
            if (all){
                total++;
            }
        }
        return total;
    }
    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */
    public static List<Integer> breakingRecords(List<Integer> scores) {
        List<Integer> list = new ArrayList();
        int min = scores.get(0);
        int max = min;
        int min_c=0;
        int max_c=0;
        for (int i=1; i<scores.size(); i++){
            int score = scores.get(i);
            if (score < min){
                min = score;
                min_c++;
            }
            if (score > max){
                max = score;
                max_c++;
            }
        }
        list.add(max_c);
        list.add(min_c);
        return list;
    }
    /*
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */

    public static int birthday(List<Integer> s, int d, int m) {
        int count = 0;
        for (int i=0; i<s.size(); i++){
            int sum = 0;
            for (int j=i; j<(i+m); j++){
                if (j<s.size()) {
                    sum += s.get(j);
                }
            }
            System.out.println(sum);
            if (sum == d){
                count++;
            }
        }
        return count;
    }
    /*
     * Complete the 'bonAppetit' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY bill
     *  2. INTEGER k
     *  3. INTEGER b
     */

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int sum = 0;
        for (int i=0; i<bill.size(); i++){
            if (i != k){
                sum += bill.get(i);
            }
        }
        if ((sum / 2) == b){
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - (sum / 2));
        }

    }
    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
        if (p > n/2){
            p = n - p;
            if (n%2 == 0){
                p++;
            }
        }
        int min = p/2;
        return min;
    }
    /*
     * Complete the 'reverseArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Integer> reverseArray(List<Integer> a) {
        // Write your code here
        Collections.reverse(a);
        return a;
    }
    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        Integer[][] array = new Integer[arr.size()][];

        int i = 0;
        for (List<Integer> nestedList : arr) {
            array[i++] = nestedList.toArray(new Integer[nestedList.size()]);
        }
        int sum = -100000;
        for (int k=1; k<5; k++) {
            for (int m = 1; m<5; m++) {
                int s1 = array[k - 1][m - 1] + array[k - 1][m] + array[k - 1][m + 1] +
                        array[k][m] +
                        array[k + 1][m - 1] + array[k + 1][m] + array[k + 1][m + 1];
                if (s1 > sum) {
                    sum = s1;
                }
            }
        }
        return sum;
    }

    public static int hourglassSum2(List<List<Integer>> arr) {
        // Write your code here
        int sum = -100000;
        for (int k=1; k<5; k++) {
            for (int m = 1; m<5; m++) {
                int s1 = arr.get(k - 1).get(m - 1) + arr.get(k - 1).get(m) + arr.get(k - 1).get(m + 1) +
                        arr.get(k).get(m) +
                        arr.get(k + 1).get(m - 1) + arr.get(k + 1).get(m) + arr.get(k + 1).get(m + 1);
                if (s1 > sum) {
                    sum = s1;
                }
            }
        }
        return sum;
    }
    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> resultList = new ArrayList<>(queries.size());
        for (int i=0; i<queries.size(); i++){
            int count = 0;
            for (int j=0; j<strings.size(); j++){
                if (strings.get(j).equals(queries.get(i))){
                    count++;
                }
            }
            resultList.add(i, count);
        }
        return resultList;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        /*int n = 9; //Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = new ArrayList();
        ar.add(10);
        ar.add(20);
        ar.add(20);
        ar.add(10);
        ar.add(10);
        ar.add(30);
        ar.add(50);
        ar.add(10);
        ar.add(20);

        int result = Result.sockMerchant(n, ar);*/
        //Integer[] nums = {4, 2, 3, 4, 4, 9, 98, 98, 3, 3, 3, 4, 2, 98, 1, 98, 98, 1, 1, 4, 98, 2, 98, 3, 9, 9, 3, 1, 4, 1, 98, 9, 9, 2, 9, 4, 2, 2,9,98,4,98,1,3,4,9,1,98,98,4, 2,3,98,98,1,99,9,98,98,3,98,98,4,98,2,98,4,2,1,1,9,2,4};
        //List<Integer> ar = Arrays.asList(nums);

        //int[] kb = {3,1};
        //int[] dr = {5,2,8};
        //int result = Result.getMoneySpent(kb,dr,8);
        //Integer[] nums = {1, 6, 3, 5, 2};
        //List<Integer> ar = Arrays.asList(nums);
        //int result = Result.hurdleRace(4, ar);
        //System.out.println(result);

        //Result.staircase(6);
        //Integer[] nums = {73, 67, 38, 33};
        //List<Integer> ar = Arrays.asList(nums);
        //ar = Result.gradingStudents(ar);
        //for (Integer i:ar){
        //    System.out.println(i);
        //}
        //Integer[] apps = {-2, 2, 1};
        //List<Integer> ar = Arrays.asList(apps);
        //Integer[] orgs = {5, -6};
        //List<Integer> or = Arrays.asList(orgs);
        //Result.countApplesAndOranges(7,11,5,15, ar, or);
        //String ret = Result.kangaroo(23, 9867, 9814, 5861);
        //System.out.println(ret);
        //Integer[] nums2 = {3,10,2,9};
        //List<Integer> ar2 = Arrays.asList(nums2);
        //Result.bonAppetit(ar2, 1,7);
        //int c = Result.pageCount(100,31);
        //System.out.println(c);
        List<Integer> a1 = new ArrayList();
        a1.add(1);
        a1.add(1);
        a1.add(1);
        a1.add(0);
        a1.add(0);
        a1.add(0);
        List<Integer> a2 = new ArrayList();
        a2.add(0);
        a2.add(1);
        a2.add(0);
        a2.add(0);
        a2.add(0);
        a2.add(0);
        List<Integer> a3 = new ArrayList();
        a3.add(1);
        a3.add(1);
        a3.add(1);
        a3.add(0);
        a3.add(0);
        a3.add(0);
        List<Integer> a4 = new ArrayList();
        a4.add(0);
        a4.add(0);
        a4.add(2);
        a4.add(4);
        a4.add(4);
        a4.add(0);
        List<Integer> a5 = new ArrayList();
        a5.add(0);
        a5.add(0);
        a5.add(0);
        a5.add(2);
        a5.add(0);
        a5.add(0);
        List<Integer> a6 = new ArrayList();
        a6.add(0);
        a6.add(0);
        a6.add(1);
        a6.add(2);
        a6.add(4);
        a6.add(0);
        List<List<Integer>> arr = new ArrayList();
        arr.add(a1);
        arr.add(a2);
        arr.add(a3);
        arr.add(a4);
        arr.add(a5);
        arr.add(a6);
        int s = Result.hourglassSum(arr);
        System.out.println(s);
    }
}
