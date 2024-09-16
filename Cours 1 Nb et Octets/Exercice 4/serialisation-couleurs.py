def empaquetage(r:int, v:int, b:int)->int:
  """
  Empaquetage de couleurs dans un entier 

  Args:
      r (int): la couleur rouge, comprise entre 0 et 255.
      v (int): la couleur verte, comprise entre 0 et 255.
      b (int): la couleur bleue, comprise entre 0 et 255.

  Returns:
      int: Empaquetage sous forme d'entier
  """
  assert 0 <= r <= 255 and 0 <= v <= 255 and 0 <= b <= 255, "Les couleurs doivent être comprises entre 0 et 255"
  
  return b | (v << 8) | (r << 16)

def depaquetage(paquet:int)->tuple[int, int, int]:
  """
  Dépaquetage 

  Args:
      paquet (int): La couleur sous forme de paquet à convertir

  Returns:
      tuple[int, int, int]: Retourne les entiers des couleurs rouge, bleue et verte
  """
  r = (paquet >> 16) & 0b11111111
  v = (paquet >> 8) & 0b11111111
  b = (paquet) & 0b11111111
  
  return r, v, b

def main():
  """
  point d'entrée du programme
  """
  r, v, b = (122, 22, 244)
  print(empaquetage(r, v, b))
  print(depaquetage(empaquetage(r, v, b)))
  
  
if __name__ == '__main__':
  main()