from collections import defaultdict

def word_count(sentence):
    words = defaultdict(int)
    for word in sentence.lower().split():
        words[word] += 1

    return words
