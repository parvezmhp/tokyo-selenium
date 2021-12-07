package practice;

import java.util.HashMap;
import java.util.Locale;

public class Homework {
    public int loneSum(int a, int b, int c) {
        if( (a==b) && (b==c) && (c==a) ) return 0;
    else
    {
            if (a==b) return c;
            if (b==c) return a;
            if (a==c) return b;
            else return a+b+c;

    }
    }
}
