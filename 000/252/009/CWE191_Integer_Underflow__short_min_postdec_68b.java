/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE191_Integer_Underflow__short_min_postdec_68b.java
Label Definition File: CWE191_Integer_Underflow.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 191 Integer Underflow 
 * BadSource: min Set data to the max value for short 
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: decrement
 *    GoodSink: Ensure there will not be an underflow before decrementing data
 *    BadSink : Decrement data, which can cause an Underflow
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */















package testcases.CWE191_Integer_Underflow.s04;
import testcasesupport.*;
      
public class CWE191_Integer_Underflow__short_min_postdec_68b 
{
    public void badSink() throws Throwable
    { 
        short data = CWE191_Integer_Underflow__short_min_postdec_68a.data;

        /* POTENTIAL FLAW: if data == Short.MIN_VALUE, this will overflow */
        data--;
        short result = (short)(data); 

        IO.writeLine("result: " + result);





    }




                    
    /* goodG2B() - use goodsource and badsink */
    public void goodG2BSink() throws Throwable
    {
        short data = CWE191_Integer_Underflow__short_min_postdec_68a.data; 

        /* POTENTIAL FLAW: if data == Short.MIN_VALUE, this will overflow */
        data--;
        short result = (short)(data);
 
        IO.writeLine("result: " + result);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2GSink() throws Throwable
    {
        short data = CWE191_Integer_Underflow__short_min_postdec_68a.data;

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
