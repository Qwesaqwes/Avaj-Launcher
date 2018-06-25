package srcs;
import  java.io.IOException;
import  java.io.*;

public class Logger
{
    private static Logger logger = null;
    private static BufferedWriter bw = null;
	private static File file = null;
    private static FileWriter fw = null;
    
    Logger()
    {
        // try
        // {
        //     logger = new Logger();
        //     file = new File("Simulation.txt");
        //     fw = new FileWriter(file);
        //     bw = new BufferedWriter(fw);
        // }
        // catch(IOException e) {System.out.println("Could not create the Output File\n");}
    }

    public static Logger GetFileToWrite()
    {
        if (logger == null)
        {
            try
            {
                logger = new Logger();
                file = new File("Simulation.txt");
                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);
            }
            catch(IOException e) {System.out.println("Could not create the Output File\n");}
        }
        return logger;
    }
    
    public void	writetofile(String str)
    {
        try
        {
            System.out.println(str);
			bw.write(str);
            System.out.println("exit");
			bw.newLine();
        }
        catch (IOException ioe) {ioe.printStackTrace();}
	}
}