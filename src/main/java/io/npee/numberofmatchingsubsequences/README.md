# 792. Number of Matching Subsequences
## Code
```java
public class Solution {
    public static int numMatchingSubseq(String S, String[] words) {
        List<StringCharacterIterator>[] waiting = new List[128];
        for (int c = 0; c <= 'z'; c++)
            waiting[c] = new ArrayList<>();
        for (String w : words)
            waiting[w.charAt(0)].add(new StringCharacterIterator(w));
        for (char c : S.toCharArray()) {
            List<StringCharacterIterator> advance = waiting[c];
            waiting[c] = new ArrayList<>();
            for (StringCharacterIterator it : advance)
                waiting[it.next() % it.DONE].add(it);
        }
        return waiting[0].size();
    }
}
```
## Results
## Complexity
### Time complexity
words.length = N
S.length = M
for x 3 => O(1 + N + M + words[0].length + words[1].length + ...)
=> O(n)
### Space complexity