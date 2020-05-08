package masterclass.udemy;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Main {

    public static void main(String[] args) {


    }

    int max ( int a, int b, int c)
    { if (a>b && a>c)
        return a;
        if ( b>a && b>c)
            return b;
        else return c;}
    int middle (int a, int b, int c)
    { if  ((a>b && b>c) || (b>a && c>b))
        return b;
        if  ((a<b && a>c) || (a>b && c>a))
            return a;
        else return c;
    }
    int min( int a, int b, int c)
    { if (a<b && a<c)
        return a;
        if (b<c && b<a)
            return b;
        else return c;}
    void main()
    { int num1, num2, num3;
        while (4) {
            scanf("%d\n %d\n %d\n", &num1, &num2, &num3);
            for (int i=0; i)
            {
                if((num1==0 && num2==0) && num3==0)
                break;
            }

            printf("%d ", max(num1, num2, num3));
            printf("%d ", middle(num1, num2, num3));
            printf("%d ", min(num1, num2, num3));
        }
    }
}
