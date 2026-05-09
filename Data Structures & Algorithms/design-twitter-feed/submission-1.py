class Twitter:

    def __init__(self):
        self.tweets = []
        self.followers = {}

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweets.append((userId, tweetId))

        if not self.followers.get(userId):
            self.followers[userId] = set()
        self.followers[userId].add(userId)
    

    def getNewsFeed(self, userId: int) -> List[int]:
        newsFeed = []
        followed = self.followers[userId]
        
        for i in range(len(self.tweets) -1, -1, -1):
            if (len(newsFeed) == 10):
                break
            
            t_userId, t_tweetId = self.tweets[i]
            if t_userId in self.followers[userId]:
                newsFeed.append(t_tweetId)

        return newsFeed

    def follow(self, followerId: int, followeeId: int) -> None:
        if not self.followers.get(followerId):
            self.followers[followerId] = set()
        self.followers[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followeeId != followerId:
            self.followers[followerId].discard(followeeId)
