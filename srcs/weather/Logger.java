package srcs.weather;
import  java.io.IOException;
import  java.io.*;

public class Logger
{
    private static Logger logger = null;
    private static BufferedWriter bufferedWriter = null;
	private static File file = null;
    private static FileWriter fileWriter = null;
    
    Logger(){}

    public static void  InitFile()
    {
        try
        {
            logger = new Logger();
            file = new File("Simulation.txt");
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
        }
        catch(IOException e) {System.out.println("Could not create the Output File\n");}
    }

    public static Logger GetFileToWrite()
    {
        return logger;
    }
    
    public void	writetofile(String str)
    {
        try
        {
			bufferedWriter.write(str);
        }
        catch (IOException ioe) {ioe.printStackTrace();}
    }
    
    public void close()
    {
        try
        {
			if ( bufferedWriter != null)
				bufferedWriter.close();
        }
        catch (Exception ex) {System.out.println("Error in closing the BufferedWriter"+ex);}
	}
}