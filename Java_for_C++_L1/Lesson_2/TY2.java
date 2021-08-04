class Test {
    static void Swap(Integer j, Integer k) {
        int tmp = k.intValue();
        k = new Integer(j.intValue());
        j = new Integer(tmp);
    }
    
    public static void main(String[] args) {
        Integer n = new Integer(5), m = new Integer(6);
        Swap(n, m);
        System.out.println("n = " + n + "; m = " + m);
    }
}

// Q1: The person who wrote this program expected the output 
// to be: n = 6; m = 5. However, the actual output is: n = 5; m = 6. Explain why. 

// A1: In java, paramters are passed by value. Swapping the paramters in the function has no affect
// on the parameters sitting in the main method


/* Q2: bad function

    static String Reverse(String S) {
        String newS = "";
        char c = S[0]; // cannot index a string in java
        while (c) { // not a boolean loop condition
            newS = c + newS; // does not help get next char in S, incerment ascii val of c
            c++;
        }
        return newS;
    }

    Correct version:

    static String Reverse(String S) {
       String newS = "";
       for (int i=0; i<S.length(); i++) {
          newS = S.charAt(i) + newS;
       }
       return newS;
    }
*/