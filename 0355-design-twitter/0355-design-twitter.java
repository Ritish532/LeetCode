class Twitter {
    class Tweets{
        int tweetId;
        int time;
        Tweets(int tweetId , int time){
            this.tweetId = tweetId;
            this.time = time;
        }
    }
    HashMap< Integer , HashSet<Integer> > following;
    HashMap< Integer , List<Tweets> > tweets;
    int time = 0;
    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId , new ArrayList<>());
        tweets.get(userId).add(new Tweets(tweetId , time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Tweets> pq = new PriorityQueue<>((a , b) -> b.time - a.time);
        if(tweets.containsKey(userId)){
            for(Tweets t : tweets.get(userId)) pq.offer((t));
        }
        if(following.containsKey(userId)){
            for(int a : following.get(userId)){
                if(tweets.containsKey(a)){
                    for(Tweets t : tweets.get(a)) pq.offer((t));
                }
            }
        }
        while(pq.size() > 0 && result.size() < 10) result.add(pq.poll().tweetId);
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followeeId == followerId) return ;
        following.putIfAbsent(followerId , new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(following.containsKey(followerId)) following.get(followerId).remove(followeeId);
    }
}