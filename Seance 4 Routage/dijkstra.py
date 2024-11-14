import math

matrice = [
  [0, 5, 0, 10, 6, 0, 0],
  [5, 0, 5, 0, 0, 0, 0],
  [0, 5, 0, 7, 0, 0, 3],
  [10, 0, 7, 0, 3, 1, 4],
  [6, 0, 0, 3, 0, 5, 0],
  [0, 0, 0, 1, 5, 0, 2],
  [0, 0, 3, 4, 0, 2, 0],
]

def getVoisin(matrice, sommet, ls):
    res = []
    for i in range(len(matrice)):
        if matrice[sommet][i] != 0 and i not in ls:
            res.append(i)
    return res

def dijkstraToutPoint(matrice):
    dists = [math.inf for i in range(len(matrice))]
    dists[0] = 0  
    ls = []
    
    while len(ls) < len(matrice):
        minDist = math.inf
        minIndex = -1
        
        for i in range(len(matrice)):
            if i not in ls and dists[i] < minDist:
                minDist = dists[i]
                minIndex = i
        
        if minIndex == -1:
            break
        
        ls.append(minIndex)
        
        for elt in getVoisin(matrice, minIndex, ls):
            if dists[elt] > dists[minIndex] + matrice[minIndex][elt]:
                dists[elt] = dists[minIndex] + matrice[minIndex][elt]
    
    return dists

print(dijkstraToutPoint(matrice))