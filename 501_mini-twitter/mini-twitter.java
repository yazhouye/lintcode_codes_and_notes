/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/mini-twitter
@Language: Java
@Datetime: 16-08-09 01:02
*/

/**
 * Definition of Tweet:
 * public class Tweet {
 *     public int id;
 *     public int user_id;
 *     public String text;
 *     public static Tweet create(int user_id, String tweet_text) {
 *         // This will create a new tweet object,
 *         // and auto fill id
 *     }
 * }
 */
public class MiniTwitter 
{
    class Node
    {
        Tweet tweet;
        int timestamp;
        public Node(Tweet tweet, int timestamp)
        {
            this.tweet=tweet;
            this.timestamp=timestamp;
        }
    }
    
    private HashMap<Integer, List<Node>> tweetMap;
    private HashMap<Integer, Set<Integer>> followingMap;
    private int timestamp;
    
    private Comparator<Node> nodeComparator = new Comparator<Node>()
    {
        @Override
        public int compare(Node n1, Node n2)
        {
            return n2.timestamp-n1.timestamp;
        }
    };

    public MiniTwitter() 
    {
        tweetMap = new HashMap<Integer, List<Node>>();
        followingMap = new HashMap<Integer, Set<Integer>>();
        timestamp = 0;
    }

    public Tweet postTweet(int user_id, String tweet_text) 
    {
        Tweet tweet = Tweet.create(user_id, tweet_text);
        
        if(!tweetMap.containsKey(user_id))
        {
            tweetMap.put(user_id, new ArrayList<Node>());
        }
        tweetMap.get(user_id).add(new Node(tweet, timestamp));
        timestamp++;
        
        return tweet;
    }

    public List<Tweet> getNewsFeed(int user_id)
    {
        List<Node> nodeList = getTimelineNode(user_id);
        
        if(followingMap.containsKey(user_id))
        {
            for(Integer followingID: followingMap.get(user_id))
            {
                nodeList.addAll(getTimelineNode(followingID));
            }
        }
        
        Collections.sort(nodeList, nodeComparator);
        
        List<Tweet> tweetList = new ArrayList<Tweet>();
        for(int i=0; i<10 && i<nodeList.size(); i++)
        {
            tweetList.add(nodeList.get(i).tweet);
        }
        return tweetList;
    }
        
    public List<Tweet> getTimeline(int user_id)
    {
        List<Node> nodeList = getTimelineNode(user_id);
        List<Tweet> tweetList = new ArrayList<Tweet>();
        for(Node node: nodeList)
        {
            tweetList.add(node.tweet);
        }
        return tweetList;
    }
    
    private List<Node> getTimelineNode(int user_id)
    {
        List<Node> nodeList = new ArrayList<Node>();
        if(!tweetMap.containsKey(user_id))
        {
            return nodeList;
        }
        List<Node> postList = tweetMap.get(user_id);
        for(int i=postList.size()-1; i>=0 && i>=postList.size()-10; i--)
        {
            nodeList.add(postList.get(i));
        }
        return nodeList;
    }

    public void follow(int from_user_id, int to_user_id) 
    {
        if(!followingMap.containsKey(from_user_id))
        {
            followingMap.put(from_user_id, new HashSet<Integer>());
        }
        followingMap.get(from_user_id).add(to_user_id);
    }

    public void unfollow(int from_user_id, int to_user_id) 
    {
        if(followingMap.containsKey(from_user_id))
        {
            followingMap.get(from_user_id).remove((Integer)to_user_id);
        }
        if(followingMap.get(from_user_id).size()==0)
        {
            followingMap.remove(from_user_id);
        }
    }
}