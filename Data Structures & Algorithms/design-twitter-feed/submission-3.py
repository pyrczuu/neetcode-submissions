from collections import defaultdict
import heapq

class Twitter:

    def __init__(self):
        self.time = 0
        self.tweets = defaultdict(list)
        self.followers = defaultdict(set)

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.followers[userId].add(userId)
        self.tweets[userId].append((self.time, tweetId))
        self.time -= 1

    def getNewsFeed(self, userId: int) -> List[int]:
        newsFeed = []
        minHeap = []

        for followeeId in self.followers[userId]:
            if followeeId in self.tweets:
                idx = len(self.tweets[followeeId]) - 1
                time, tweetId = self.tweets[followeeId][idx]
                heapq.heappush(minHeap, [time, tweetId, followeeId, idx-1])
        
        while minHeap and len(newsFeed) < 10:
            time, tweetId, followeeId, idx = heapq.heappop(minHeap)
            newsFeed.append(tweetId)

            if idx >= 0:
                nextTime, nextTweetId = self.tweets[followeeId][idx]
                heapq.heappush(minHeap, [nextTime, nextTweetId, followeeId, idx-1])
        
        return newsFeed

    def follow(self, followerId: int, followeeId: int) -> None:
        self.followers[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        if followeeId != followerId:
            self.followers[followerId].discard(followeeId)
