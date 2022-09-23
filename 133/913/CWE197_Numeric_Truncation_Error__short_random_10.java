/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE197_Numeric_Truncation_Error__short_random_10.java
Label Definition File: CWE197_Numeric_Truncation_Error__short.label.xml
Template File: sources-sink-10.tmpl.java
*/
/*
* @description
* CWE: 197 Numeric Truncation Error
* BadSource: random Set data to a random value
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* BadSink: to_byte Convert data to a byte
* Flow Variant: 10 Control flow: if(IO.staticTrue) and if(IO.staticFalse)
*
* */




import java.security.SecureRandom;

public class CWE197_Numeric_Truncation_Error__short_random_10 extends AbstractTestCase
{
    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        short data;
        if (IO.staticTrue)
        {
            /* FLAW: Set data to a random value */
            data = (short)((new SecureRandom()).nextInt(Short.MAX_VALUE + 1));
        }                
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
        }                

        {
            /* POTENTIAL FLAW: Convert data to a byte, possibly causing a truncation error */
            IO.writeLine((byte)data);
        }                

    }                

    /* goodG2B1() - use goodsource and badsink by changing IO.staticTrue to IO.staticFalse */
    private void goodG2B1() throws Throwable
    {
        short data;
        if (IO.staticFalse)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
        }                
        else
        {

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

        }                

        {
            /* POTENTIAL FLAW: Convert data to a byte, possibly causing a truncation error */
            IO.writeLine((byte)data);
        }                

    }                

    /* goodG2B2() - use goodsource and badsink by reversing statements in if */
    private void goodG2B2() throws Throwable
    {
        short data;
        if (IO.staticTrue)
        {
            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;
        }                
        else
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run
             * but ensure data is inititialized before the Sink to avoid compiler errors */
            data = 0;
        }                

        {
            /* POTENTIAL FLAW: Convert data to a byte, possibly causing a truncation error */
            IO.writeLine((byte)data);
        }                

    }                

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
    }                

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested.
     */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }                
}                
