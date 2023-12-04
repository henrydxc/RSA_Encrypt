import java.util.*;
import java.math.BigInteger;
public class RSA {
    final static BigInteger one=new BigInteger("1");
    final static BigInteger zero=new BigInteger("0");
    final static BigInteger two=new BigInteger("2");
    final static BigInteger four=new BigInteger("4");
    final static BigInteger five=new BigInteger("5");
    final static BigInteger six=new BigInteger("6");
    final static BigInteger fifteen=new BigInteger("15");
    final  static BigInteger sixteen=new BigInteger("16");
    final static BigInteger eighteen=new BigInteger("18");
    final static BigInteger nineteen=new BigInteger("19");
    final static BigInteger seven=new BigInteger("7");
    final static BigInteger eight=new BigInteger("8");
    final  static BigInteger nine=new BigInteger("9");
    final static BigInteger num211=new BigInteger("211");
    final static BigInteger num22487=new BigInteger("22487");

    public static void main(String[] args) {
        BigInteger p=new BigInteger("113");
        BigInteger q=new BigInteger("199");
        BigInteger n;
        n=p.multiply(q);
        BigInteger l;
        l=p.subtract(one).multiply(q.subtract(one));
        System.out.println("n="+n+" l="+l);
        BigInteger e=new BigInteger("211");
        System.out.println(gcd(e,l));
        System.out.println(prime(e)+" "+prime(p)+" "+prime(q));
        BigInteger d=new BigInteger("-1");
        for(BigInteger i=one;i.compareTo(l)<0;i=i.add(one)){
            if(e.multiply(i).mod(l).equals(one))  {
                d=i;
            }
        }
        System.out.println("d is "+d+" and "+prime(d));
        System.out.println("public key is "+"("+n+","+e+")"+" and private key is ("+n+","+d+")");
        // professor's public key (2713,6735257)
        // my public key  (22487,211)
        // my private key (22487,1051)
        BigInteger un=new BigInteger("2713");
        BigInteger ue=new BigInteger("6735257");

       // hi professor would be 8,9,16,18,15,6,5,19,19,15,18
        BigInteger h8,i9,p16,r18,o15,f6,e5,s19;
        h8=encrypt(n,d,eight);
        i9=encrypt(n,d,nine);
        p16=encrypt(n,d,sixteen);
        r18=encrypt(n,d,eighteen);
        o15=encrypt(n,d,fifteen);
        f6=encrypt(n,d,six);
        e5=encrypt(n,d,five);
        s19=encrypt(n,d,nineteen);
        System.out.println(" message encrypted by my secret key set : "+h8+","+i9+", "+p16+","+r18+","+o15+","+f6+","+e5+","+s19+","+s19+","+o15+","+r18);
        //19202,14599, 16966,11482,15466,3880,14102,16275,16275,15466,11482
        System.out.println("Now use your public key set to encrypt above codes");
        BigInteger num19202=new BigInteger("19202");
        BigInteger num14599=new BigInteger("14599");
        BigInteger num16966=new BigInteger(("16966"));
        BigInteger num11482=new BigInteger("11482");
        BigInteger num15466=new BigInteger(("15466"));
        BigInteger num3880=new BigInteger("3880");
        BigInteger num14102=new BigInteger("14102");
        BigInteger num16275=new BigInteger("16275");
        h8=encrypt(un,ue,num19202);
        i9=encrypt(un,ue,num14599);
        s19=encrypt(un,ue,num16275);
        p16=encrypt(un,ue,num16966);
        r18=encrypt(un,ue,num11482);
        o15=encrypt(un,ue,num15466);
        f6=encrypt(un,ue,num3880);
        e5=encrypt(un,ue,num14102);
        System.out.println("after that : "+h8+","+i9+", "+p16+","+r18+","+o15+","+f6+","+e5+","+s19+","+s19+","+o15+","+r18);
        System.out.println("Finally I sent this  : "+h8+","+i9+", "+p16+","+r18+","+o15+","+f6+","+e5+","+s19+","+s19+","+o15+","+r18);
        System.out.println("You can use your private key set to decrypt the message encrypted with my private key set, and then use my public key set to decrypt and verify the message ");
    }
    public static BigInteger modulus(BigInteger p, BigInteger q){
        return p.multiply(q);
    }
    public static BigInteger totient (BigInteger p, BigInteger q){
        return p.subtract(one).multiply(q.subtract(one));
    }


    public static BigInteger gcd(BigInteger a,BigInteger b){
        for(BigInteger i=a;i.compareTo(one)>=0;i=i.subtract(one)){
            if(a.mod(i).equals(zero)&&b.mod(i).equals(zero))
                return i;
        }
        return zero;
    }
    public static String prime(BigInteger x){
        for(BigInteger i=x.subtract(one);i.compareTo(one)>0;i=i.subtract(one)){
            if(x.mod(i).equals(zero))
                return x.toString()+" is not prime";
        }
        return x.toString()+" is prime";
    }
    public static BigInteger encrypt(BigInteger n, BigInteger e,BigInteger m){
        return m.modPow(e,n);
    }
}
/*
Output:

n=22487 l=22176
1
211 is prime 113 is prime 199 is prime
d is 1051 and 1051 is prime
public key is (22487,211) and private key is (22487,1051)
 message encrypted by my secret key set : 19202,14599, 16966,11482,15466,3880,14102,16275,16275,15466,11482
Now use your public key set to encrypt above codes
after that : 1013,2606, 1381,586,1519,334,788,2470,2470,1519,586
Finally I sent this  : 1013,2606, 1381,586,1519,334,788,2470,2470,1519,586
You can use your private key set to decrypt the message encrypted with my private key set, and then use my public key set to decrypt and verify the message

Process finished with exit code 0


 */