import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.*;

public class TextRetriever
{
	
	String text;
	Robot robot = new Robot();

    public TextRetriever() throws Exception
    {
    	text = "";
    }
    
    public void write(String word)
    {
    	for (int i = 0; i < word.length(); ++i)
    	{
    		int id = word.charAt(i);
    		try
    		{
    			robot.keyPress(id);
    			Thread.sleep(20);
    			robot.keyRelease(id);
    		}
    		catch (Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    }
    
    public String getText() throws Exception
    {
    	try 
        {
                robot.keyPress(157);
                robot.keyPress(KeyEvent.VK_C);
                Thread.sleep(20);

                robot.keyRelease(157);
                robot.keyRelease(KeyEvent.VK_C);
                Thread.sleep(500);
            
                text = getClipboardText();
                System.out.println("TEXT IS : " + text);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    	return text;
    }

    static String getClipboardText() throws Exception {
        return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    }

    public static void main(String[] args)
    {
        KeyListener listener = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("CODE IS: " + e.getKeyCode());
                try
                {
                    TextRetriever text = new TextRetriever();
                }
                catch (Exception f)
                {
                    f.printStackTrace();
                }
            }

            @Override
            public void keyReleased(KeyEvent event)
            {
            }

            @Override
            public void keyTyped(KeyEvent event)
            {
            }
        };

        /*try
        {
            TextRetriever text = new TextRetriever();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/
    }
}
