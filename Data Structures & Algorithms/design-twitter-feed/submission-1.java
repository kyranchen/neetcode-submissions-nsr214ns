class Tweet {
    int id;
    int userId;
    int time;

    public Tweet(int id, int userId, int time) {
        this.id = id;
        this.userId = userId;
        this.time = time;
    }
}

class Twitter {
    private int time;
    private HashMap<Integer, List<Tweet>> userTweet;
    private HashMap<Integer, Set<Integer>> userFollowee;

    public Twitter() {
        time = 0;
        userTweet = new HashMap<>();
        userFollowee = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userTweet.putIfAbsent(userId, new ArrayList<>());
        userTweet.get(userId).add(new Tweet(tweetId, userId, time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Tweet> feed = new ArrayList<>(userTweet.getOrDefault(userId, new ArrayList<>()));
        Set<Integer> followList = userFollowee.getOrDefault(userId, new HashSet<>());
        if (feed.size() == 0 && followList.size() == 0) return new ArrayList<>();

        for (int followeeId: followList) {
            feed.addAll(userTweet.getOrDefault(followeeId, new ArrayList<>()));
        }

        feed.sort((a, b) -> b.time - a.time);

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < Math.min(10, feed.size()); i++) {
            res.add(feed.get(i).id);
        }
        
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            userFollowee.putIfAbsent(followerId, new HashSet<>());
            userFollowee.get(followerId).add(followeeId);
        }

    }
    
    public void unfollow(int followerId, int followeeId) {
        userFollowee.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}
