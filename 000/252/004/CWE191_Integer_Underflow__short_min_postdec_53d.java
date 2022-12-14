/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__short_min_postdec_53d.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-53d.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow
 * BadSource: min Set data to the max value for short
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: decrement
 *    GoodSink: Ensure there will not be an underflow before decrementing data
 *    BadSink : Decrement data, which can cause an Underflow
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */






	/*
    	 *	There is no such method for servlets testcases
    	 *	This is just a temp-small modification to make servlets compile and run
    	 */





	/*
    	 *	There is no such method for servlets testcases
    	 *	This is just a temp-small modification to make servlets compile and run
    	 */




package testcases.CWE191_Integer_Underflow.s04;
import testcasesupport.*;

public class CWE191_Integer_Underflow__short_min_postdec_53d
{
    public void badSink(short data ) throws Throwable
    {

        /* POTENTIAL FLAW: if data == Short.MIN_VALUE, this will overflow */
        data--;
        short result = (short)(data);

        IO.writeLine("result: " + result);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink(short data ) throws Throwable
    {

        /* POTENTIAL FLAW: if data == Short.MIN_VALUE, this will overflow */
        data--;
        short result = (short)(data);

        IO.writeLine("result: " + result);

    }                                              

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink(short data ) throws Throwable
    {

        /* FIX: Add a check to prevent an underflow from occurring */
        if (data > Short.MIN_VALUE)
        {
            data--;
            short result = (short)(data);
            IO.writeLine("result: " + result);
        }
        else
        {
            IO.writeLine("data value is too small to decrement.");
        }

    }
}
