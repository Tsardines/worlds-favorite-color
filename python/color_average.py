myArray = []
word = 'FFFFFF'

def firstMethod(word, myArray):
    for i in range(0, 3):
        myArray.append(word[i:i+2])
    print(myArray)

firstMethod(word, myArray)