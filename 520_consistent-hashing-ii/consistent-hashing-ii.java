/*
@Copyright:LintCode
@Author:   yazhou
@Problem:  http://www.lintcode.com/problem/consistent-hashing-ii
@Language: Java
@Datetime: 16-08-14 04:16
*/

public class Solution 
{
    public int n;
    public int k;
    public HashSet<Integer> IDs;
    public HashMap<Integer, List<Integer>> machineIdMap;
    
    public static Solution create(int n, int k) 
    {
        Solution solution = new Solution();
        solution.n=n;
        solution.k=k;
        solution.IDs = new HashSet<Integer>();
        solution.machineIdMap = new HashMap<Integer, List<Integer>>();
        return solution;
    }

    public List<Integer> addMachine(int machine_id) 
    {
        if(machineIdMap.containsKey(machine_id))
        {
            return machineIdMap.get(machine_id);
        }
        
        Random r = new Random();
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<k; i++)
        {
            int position = r.nextInt(n);
            while(IDs.contains(position))
            {
                position = r.nextInt(n);
            }
            IDs.add(position);
            list.add(position);
        }
        machineIdMap.put(machine_id, list);
        return list;
    }

    public int getMachineIdByHashCode(int hashcode) 
    {
        int minDiff = n;
        int machineID = 0;
        for(Map.Entry<Integer, List<Integer>> entry: machineIdMap.entrySet())
        {
            for(Integer position: entry.getValue())
            {
                int diff = position - hashcode;
                if(diff<0)
                {
                    diff+=n;
                }
                
                if(diff<minDiff)
                {
                    minDiff=diff;
                    machineID=entry.getKey();
                }
            }
        }
        return machineID;
    }
}