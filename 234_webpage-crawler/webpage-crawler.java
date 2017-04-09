/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/webpage-crawler
@Language: Java
@Datetime: 16-08-22 08:08
*/

/**
 * public class HtmlHelper {
 *     public static List<String> parseUrls(String url);
 *         // Get all urls from a webpage of given url. 
 * }
*/

//single threading
/*
import java.net.*;

public class Solution 
{
    public List<String> crawler(String url) 
    {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(url);
        
        HashSet<String> visitedSet = new HashSet<String>();
        visitedSet.add(url);
        
        List<String> list = new ArrayList<String>();
        while(queue.size()!=0)
        {
            String head = queue.poll();
            String domain = "";
            try 
            {
                URL netUrl = new URL(head);
                domain = netUrl.getHost();
            } 
            catch (MalformedURLException e) 
            {
                e.printStackTrace(); 
            }
            if(domain.endsWith("wikipedia.org"))
            {
                list.add(head);   
            }
            
            for(String next: HtmlHelper.parseUrls(head))
            {
                if(!visitedSet.contains(next))
                {
                    visitedSet.add(next);
                    queue.offer(next);
                }
            }
        }
        
        return list;
    }
}
*/

//multithreading
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.lang.Thread;
import java.net.*;
import java.io.*;

class CrawlerThread extends Thread 
{
    private static BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
    private static HashSet<String> visitedUrl = new HashSet<String>();
    private static List<String> results = new ArrayList<String>();
    
    public static void setFirstUrl(String s)
    {
        try
        {
            queue.put(s);
            visitedUrl.add(s);
        } 
        catch (Exception e) 
        {
            
        }
    }
    
    public static List<String> getResult()
    {
        return results;
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            String url="";
            try
            {
                url=queue.take();
            }
            catch (Exception e)
            {
                break;
            }
            
            String domain="";
            try
            {
                URL netUrl = new URL(url);
                domain = netUrl.getHost();
            }
            catch (Exception e)
            {
                
            }
            
            if(domain.endsWith("wikipedia.org"))
            {
                results.add(url);
            }
            
            for (String u : HtmlHelper.parseUrls(url))
            {
                try
                {
                    if(!visitedUrl.contains(u))
                    {
                        queue.put(u);
                        visitedUrl.add(u);  
                    }
                }
                catch (Exception e)
                {
                    
                }
            }
        }
    }
}

public class Solution 
{
    public List<String> crawler(String url) 
    {
        CrawlerThread.setFirstUrl(url);
        CrawlerThread[] thread_pools = new CrawlerThread[10];
        for (int i = 0; i < 10; ++i) 
        {
            thread_pools[i] = new CrawlerThread();
            thread_pools[i].start();
        }
        
        try 
        {
            Thread.sleep(1000);
        } catch (Exception e)
        {

        }
        
        for (int i = 0; i < 10; ++i) 
        {
            thread_pools[i].stop();
        }
        
        List<String> results = CrawlerThread.getResult();
        return results;
    }
}

