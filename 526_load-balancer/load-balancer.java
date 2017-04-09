/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/load-balancer
@Language: Java
@Datetime: 16-08-21 05:57
*/

public class LoadBalancer 
{
    private ArrayList<Integer> servers;
    private Random r;

    public LoadBalancer() 
    {
        servers = new ArrayList<Integer>();
        r = new Random();
    }

    public void add(int server_id) 
    {
        servers.add(server_id);
    }

    public void remove(int server_id) 
    {
        servers.remove((Integer)server_id);
    }

    public int pick() 
    {
        return servers.get(r.nextInt(servers.size()));
    } 
}