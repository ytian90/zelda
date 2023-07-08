package core.pq;

import java.util.*;

/**
 * https://www.1point3acres.com/bbs/thread-1002615-1-1.html
 给一个服务器的聊天消息日志文件，格式如下：
 [YYYY-MM-DD HH-mm-ss] <user_name> message_text
 给定了一个读取日志文件的函数（自己不用写文件IO），读出一个list of tuples，每个tuple是用户名和他这条消息里的单词数。
 写一个函数来求出整个log文件中所有user里，谁说的单词数最多，给出top-k最多的user的username
 思路：
 最简单的办法，用map对每个用户累加，然后再转成list，再用lambda函数sort，然后return前k个元素的username --> O(nlogn)
 n是user数，处理log的复杂度不care，只考虑取前k个元素这一步的复杂度，下同）
 后续优化1：建立大根堆，每次去top-1，取k次 --> O(klogn)
 后续优化2：建立小根堆，在建堆时每次push一个元素进去就判断堆大小是否已大于k，如果大于就push后把堆顶pop出来 --> O(klogk)
 Follow-up quetion：
 写出处理log给出list of tuples的函数，假设文件已经读取成一个list of log strings形式。

 https://leetcode.com/discuss/interview-question/1400286/Google-Phone-Screen-rejected
 */
public class TopKUserInLog {
    class Message {
        String userName;
        int textCount;

        public Message(String userName, int textCount) {
            this.userName = userName;
            this.textCount = textCount;
        }
    }

    public List<String> findTopKUserNames(List<String> logs, int k) {
        List<Message> messages = parseLog(logs);
        return findTopKUser(messages, k);
    }

    private List<String> findTopKUser(List<Message> messages, int k) {
        Map<String, Integer> map = new HashMap<>(); // <user_name, total_message_count>
        TreeMap<Integer, LinkedHashSet<String>> treeMap = new TreeMap<>(); // <total_message_count, all user_name with same count>
        for (Message msg : messages) {
            if (!map.containsKey(msg.userName)) {
                map.put(msg.userName, msg.textCount);
                treeMap.putIfAbsent(msg.textCount, new LinkedHashSet<>());
                treeMap.get(msg.textCount).add(msg.userName);
            } else {
                int count = map.get(msg.userName);
                int newCount = count + msg.textCount;
                map.put(msg.userName, newCount);
                treeMap.get(count).remove(msg.userName);
                treeMap.putIfAbsent(newCount, new LinkedHashSet<>());
                treeMap.get(newCount).add(msg.userName);
            }
        }
        List<String> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, LinkedHashSet<String>> lastEntry = treeMap.pollLastEntry();
            if (res.size() + lastEntry.getValue().size() <= k) {
                res.addAll(lastEntry.getValue());
            } else {
                Iterator<String> iterator = lastEntry.getValue().iterator();
                while (iterator.hasNext() && res.size() < k) {
                    res.add(iterator.next());
                }
            }
        }
        return res;
    }

    private List<Message> parseLog(List<String> logs) {
        List<Message> res = new ArrayList<>();
        for (String log : logs) {
            int startIdx = log.indexOf("<");
            int endIdx = log.indexOf(">");
            String userName = log.substring(startIdx + 1, endIdx);
            String msg = log.substring(endIdx + 1);
            String[] words = msg.split("\\s+");
            res.add(new Message(userName, words.length));
        }
        return res;
    }

    public static void main(String[] args) {
        TopKUserInLog obj = new TopKUserInLog();
        System.out.println(obj.findTopKUserNames(Arrays.asList("Preamble <bob> code check in", "Commit 2 <alice> change variables",
                "Commit 2 <david> change variables", "Preamble <bob> code check in again"), 2));
        System.out.println(obj.findTopKUserNames(Arrays.asList("Preamble <bob> code check in", "Commit 2 <elsa> change variables",
                "Commit 2 <david> change variables", "Preamble <bob> code check in again"), 2));
    }
}
