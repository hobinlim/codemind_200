/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__URLConnection_write_81_goodG2B.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: sources-sinks-81_goodG2B.tmpl.java
*/
/*
 * @description
 * CWE: 400 Resource Exhaustion
 * BadSource: URLConnection Read count from a web server with URLConnection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: write
 *    GoodSink: Write to a file count number of times, but first validate count
 *    BadSink : Write to a file count number of times
 * Flow Variant: 81 Data flow: data passed in a parameter to an abstract method
 *
 * */

package testcases.CWE400_Resource_Exhaustion.s03;
import testcasesupport.*;

import javax.servlet.http.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.logging.Level;

public class CWE400_Resource_Exhaustion__URLConnection_write_81_goodG2B extends CWE400_Resource_Exhaustion__URLConnection_write_81_base
{
    public void action(int count ) throws Throwable
    {

        File file = new File("badSink.txt");
        FileOutputStream streamFileOutput = new FileOutputStream(file);
        OutputStreamWriter writerOutputStream = new OutputStreamWriter(streamFileOutput, "UTF-8");
        BufferedWriter writerBuffered = new BufferedWriter(writerOutputStream);
        int i;

        /* POTENTIAL FLAW: Do not validate count before using it as the for loop variant to write to a file */
        for (i = 0; i < count; i++)
        {
            try
            {
                writerBuffered.write("Hello");
            } 
            catch (IOException exceptIO)
            {
                IO.logger.log(Level.WARNING, "Error with stream writing", exceptIO);
            } 
        } 

        /* Close stream reading objects */
        try
        {
            if (writerBuffered != null)
            {
                writerBuffered.close();
            } 
        } 
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error closing BufferedWriter", exceptIO);
        } 

        try
        {
            if (writerOutputStream != null)
            {
                writerOutputStream.close();
            } 
        } 
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error closing OutputStreamWriter", exceptIO);
        } 

        try
        {
            if (streamFileOutput != null)
            {
                streamFileOutput.close();
            } 
        } 
        catch (IOException exceptIO)
        {
            IO.logger.log(Level.WARNING, "Error closing FileOutputStream", exceptIO);
        } 

    } 
} 
