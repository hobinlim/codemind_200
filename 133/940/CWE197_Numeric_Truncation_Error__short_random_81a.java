/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE197_Numeric_Truncation_Error__short_random_81a.java
Label Definition File: CWE197_Numeric_Truncation_Error__short.label.xml
Template File: sources-sink-81a.tmpl.java
*/
/*
 * @description
 * CWE: 197 Numeric Truncation Error
 * BadSource: random Set data to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: to_byte
 *    BadSink : Convert data to a byte
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */




import java.security.SecureRandom;

public class CWE197_Numeric_Truncation_Error__short_random_81a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        short data;

        /* FLAW: Set data to a random value */
        data = (short)((new SecureRandom()).nextInt(Short.MAX_VALUE + 1));

        CWE197_Numeric_Truncation_Error__short_random_81_base baseObject = new CWE197_Numeric_Truncation_Error__short_random_81_bad();
        baseObject.action(data );
    }          

    public void good() throws Throwable
    {
        goodG2B();
    }          

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        short data;

        /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
        data = 2;

        CWE197_Numeric_Truncation_Error__short_random_81_base baseObject = new CWE197_Numeric_Truncation_Error__short_random_81_goodG2B();
        baseObject.action(data );
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
