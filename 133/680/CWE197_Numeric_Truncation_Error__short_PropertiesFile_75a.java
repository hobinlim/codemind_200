/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE197_Numeric_Truncation_Error__short_PropertiesFile_75a.java
Label Definition File: CWE197_Numeric_Truncation_Error__short.label.xml
Template File: sources-sink-75a.tmpl.java
*/
/*
 * @description
 * CWE: 197 Numeric Truncation Error
 * BadSource: PropertiesFile Read data from a .properties file (in property named data)
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: to_byte
 *    BadSink : Convert data to a byte
 * Flow Variant: 75 Data flow: data passed in a serialized object from one method to another in different source files in the same package
 *
 * */



import java.io.ByteArrayOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.logging.Level;

import java.util.Properties;

import java.io.FileInputStream;


public class CWE197_Numeric_Truncation_Error__short_PropertiesFile_75a extends AbstractTestCase
{
    public void bad() throws Throwable
    {
        short data;

        data = Short.MIN_VALUE; /* Initialize data */

        /* retrieve the property */
        {
            Properties properties = new Properties();
            FileInputStream streamFileInput = null;

            try
            {
                streamFileInput = new FileInputStream("../common/config.properties");
                properties.load(streamFileInput);

                /* FLAW: Read data from a .properties file */
                String stringNumber = properties.getProperty("data");
                if (stringNumber != null) // avoid NPD incidental warnings
                {
                    try
                    {
                        data = Short.parseShort(stringNumber.trim());
                    }                 
                    catch(NumberFormatException exceptNumberFormat)
                    {
                        IO.logger.log(Level.WARNING, "Number format exception parsing data from string", exceptNumberFormat);
                    }                 
                }                 
            }                 
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream reading", exceptIO);
            }                 
            finally
            {
                /* Close stream reading object */
                try
                {
                    if (streamFileInput != null)
                    {
                        streamFileInput.close();
                    }                 
                }                 
                catch (IOException exceptIO)
                {
                    IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
                }                 
            }                 
        }                 

        /* serialize data to a byte array */
        ByteArrayOutputStream streamByteArrayOutput = null;
        ObjectOutput outputObject = null;

        try
        {
            streamByteArrayOutput = new ByteArrayOutputStream() ;
            outputObject = new ObjectOutputStream(streamByteArrayOutput) ;
            outputObject.writeObject(data);
            byte[] dataSerialized = streamByteArrayOutput.toByteArray();
            (new CWE197_Numeric_Truncation_Error__short_PropertiesFile_75b()).badSink(dataSerialized  );
        }                 
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "IOException in serialization", exceptIO);
        }                 
        finally
        {
            /* clean up stream writing objects */
            try
            {
                if (outputObject != null)
                {
                    outputObject.close();
                }                 
            }                 
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectOutputStream", exceptIO);
            }                 

            try
            {
                if (streamByteArrayOutput != null)
                {
                    streamByteArrayOutput.close();
                }                 
            }                 
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayOutputStream", exceptIO);
            }                 
        }                 
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

        /* serialize data to a byte array */
        ByteArrayOutputStream streamByteArrayOutput = null;
        ObjectOutput outputObject = null;

        try
        {
            streamByteArrayOutput = new ByteArrayOutputStream() ;
            outputObject = new ObjectOutputStream(streamByteArrayOutput) ;
            outputObject.writeObject(data);
            byte[] dataSerialized = streamByteArrayOutput.toByteArray();
            (new CWE197_Numeric_Truncation_Error__short_PropertiesFile_75b()).goodG2BSink(dataSerialized  );
        }                 
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "IOException in serialization", exceptIO);
        }                 
        finally
        {
            /* clean up stream writing objects */
            try
            {
                if (outputObject != null)
                {
                    outputObject.close();
                }                 
            }                 
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ObjectOutputStream", exceptIO);
            }                 

            try
            {
                if (streamByteArrayOutput != null)
                {
                    streamByteArrayOutput.close();
                }                 
            }                 
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error closing ByteArrayOutputStream", exceptIO);
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
