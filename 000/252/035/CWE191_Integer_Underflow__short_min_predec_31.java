/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__short_min_predec_31.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-31.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: min Set data to the max value for short
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: decrement
 *    GoodSink: Ensure there will not be an underflow before decrementing data
 *    BadSink : Decrement data, which can cause an Underflow
 * Flow Variant: 31 Data flow: make a copy of data within the same method
 *
 * */

	/*
    	 *	There is no such method for servlets testcases
    	 *	This is just a temp-small modification to make servlets compile and run
    	 */

package testcases.CWE191_Integer_Underflow.s05;
import testcasesupport.*;

public class CWE191_Integer_Underflow__short_min_predec_31 extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        short dataCopy;
        {
            short data;

            /* POTENTIAL FLAW: Use the maximum size of the data type */
            data = Short.MIN_VALUE;

            dataCopy = data;
        }
        {
            short data = dataCopy;

            /* POTENTIAL FLAW: if data == Short.MIN_VALUE, this will overflow */
            short result = (short)(--data);

            IO.writeLine("result: " + result);

        }
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        short dataCopy;
        {
            short data;

            /* FIX: Use a hardcoded number that won't cause underflow, overflow, divide by zero, or loss-of-precision issues */
            data = 2;

            dataCopy = data;                          





        }
        {
            short data = dataCopy;

            /* POTENTIAL FLAW: if data == Short.MIN_VALUE, this will overflow */
            short result = (short)(--data);

            IO.writeLine("result: " + result);

        }
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        short dataCopy;
        {
            short data;

            /* POTENTIAL FLAW: Use the maximum size of the data type */
            data = Short.MIN_VALUE;

            dataCopy = data;
        }
        {
            short data = dataCopy;

            /* FIX: Add a check to prevent an underflow from occurring */
            if (data > Short.MIN_VALUE)
            {
                short result = (short)(--data);
                IO.writeLine("result: " + result);
            }
            else
            {
                IO.writeLine("data value is too small to decrement.");
            }

        }
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
