//imported packages
import java.util.*;
import java.lang.*;
import java.math.*;

// class karatsuba
public class karatsuba {
    public BigInteger karatsuba1(BigInteger X, BigInteger Y) {
        final BigInteger ZERO = new BigInteger("0");
        
        // Length of X, Y
        int x = X.toString().length();
        int y =  Y.toString().length();
        
        // Calculate n 
        int n = Math.max(x,y);
        
        // Increment n if its odd
        if(n % 2 != 0){
            n = n + 1;
        } 

        BigInteger n1 = BigInteger.valueOf(10);
        int n2 = n/2;
        BigInteger N1 = n1.pow(n); // 10^n
        BigInteger N2 = n1.pow(n2); // 10^(n/2)
        
        // Values A and B ------- X = 10^(n/2) * A + B
        BigInteger A = X.divide(N2);
        BigInteger B = X.remainder(N2);
        
        // Values C and D ------- Y = 10^(n/2) * C + D
        BigInteger C = Y.divide(N2);
        BigInteger D = Y.remainder(N2);
        
        //Karatsuba multiplication Algorithm with Guass concept
        BigInteger P1 = A.multiply(C); // A * C
        BigInteger P2 = B.multiply(D); // B * D
        BigInteger A1 = A.add(B); // A + B
        BigInteger A2 = C.add(D); // C + D
        BigInteger P3 = A1.multiply(A2); // (A + B) * (C + D)
        BigInteger A3 = P1.add(P2); // (A * C) + (B * D)
        BigInteger P4 = P3.subtract(A3); // (A + B) * (C + D) - ((A * C) + (B * D))
        BigInteger P5 = P1.multiply(N1); // A * C * 10^n
        BigInteger P6 = P4.multiply(N2); // ((A + B) * (C + D) - ((A * C) + (B * D))) * 10^(n/2)
        BigInteger P = P5.add(P6).add(P2); // (A * C * 10^n) + (((A + B) * (C + D) - ((A * C) + (B * D))) * 10^(n/2))) + (B*D)
        System.out.println("Product of X and Y: " + P);
        return ZERO;
    }


    public static void main(String args[]) {
        System.out.println("Enter the values of X and Y");
        // Input X ---- Multiplicand
        Scanner sc = new Scanner(System.in);
        BigInteger X = sc.nextBigInteger();
        // Input Y --- Multiplier
        BigInteger Y = sc.nextBigInteger();
        sc.close();
        karatsuba p = new karatsuba();
        p.karatsuba1(X,Y);
    }
}