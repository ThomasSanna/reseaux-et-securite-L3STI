# Seance 3 Adressage IP

## Exercice 1

1. 192.168.196.10/24 ; a
2. 192.168.197.10/24 ; b
3. 192.168.196.246/24 ; a
4. 172.162.162.2/19 ; c
5. 172.162.162.3/19 ; c
6. 172.162.191.2/19 ; c
7. 192.168.10.12/25 ; d
8. 192.168.10.50/25 ; d
9. 192.168.10.100/25 ; d
10. 192.168.10.150/25 ; e

## Exercice 2

### Quelle est l'adresse IP du réseau?

192.168.12.0/24

### Determiner le nombre de machines qu'on peut brancher dans le réseau

254 machines (2^8 - 2 (l'adresse de broadcast et l'adresse de réseau))

### Donner l'adresse de diffusion du réseau et la plage d'adresse IP adressable

#### Broadcast

192.168.12.255/24

#### Plage d'adresse IP adressable

192.168.12.1/24 à 192.168.12.254/24

## Exercice 3 : Soit le réseau 42.0.0.0/8, qu’on souhaite découper en 25 sous-réseaux. Identifier les 4 premiers réseaux (i.e. donner leur adresse) ainsi que les deux derniers avec, pour chaque sous-réseau, l’adresse de broadcast et la plage d’adresses attribuables

### Nombre de bits pour les sous-réseaux

25 sous-réseaux => 5 bits (2^5 = 32)

### Adresse des 4 premiers réseaux

1. 42.0.0.0/13
2. 42.8.0.0/13
3. 42.16.0.0/13
4. 42.24.0.0/13
5. 42.32.0.0/13

### Adresse des 2 derniers réseaux

24. 42.192.0.0
25. 42.200.0.0
26. ...


31 : 42.240.0.0

32 : 42.248.0.0

### Adresse de broadcast

1. 42.7.255.255
2. 42.15.255.255
3. 42.23.255.255.... etc etc

32:  42.255.255.255

### Plage d'adresses attribuables

1. 42.0.0.1 à 42.7.255.255
2. 42.8.0.1 à 42.15.255.254
3. 42.16.0.1 à 42.23.255.254
4. 42.24.0.1 à 42.31.255.254
5. ...
6. ...

31: 42.240.0.1 à 42.247.255.254

32: 42.248.0.1 à 42.255.255.254

## Exercice 4

### 145.245.45.225

#### La classe adresse

Classe B

#### Masque par défaut

255.255.0.0

#### Adresse réseau

145.245.0.0

#### Masques de sous-réseaux

##### 15 sous-réseaux

4 bits (2^4 = 16)

255.255.240.0

##### 60 sous-réseaux

6 bits (2^6 = 64)

255.255.252.0

##### 200 sous-réseaux

8 bits (2^8 = 256)

255.255.255.0

#### L'adresse du sous-réseau 145.245.45.225 et son numéro

##### 15 sr

- 145.245.32.0/20
- numéro 3

##### 60 sr

- 145.245.44.0/22
- numéro 12

##### 200 sr

- 145.245.45.0/24
- numéro 45

#### Le numéro de la machine sur le sous-réseau

##### 15 soureso

- 145.245.32.0 - 145.245.45.225 = 0.0.13.225
- numéro 0.0.13.225

##### 60 soureso

- 145.245.44.0 - 145.245.45.225 = 0.0.1.225
- numéro 0.0.1.225

##### 200 soureso

- 145.245.45.0 - 145.245.45.225 = 0.0.0.225
- numéro 0.0.0.225

#### Intervalles d'adresses utilisables

##### 15 sous réseaux

###### premiers

1. 145.245.0.1/20 à 145.245.15.254/20
2. 145.245.16.1/20 à 145.245.31.254/20

###### derniers

14. 145.245.208.1/20 à 145.245.223.254/20
15. 145.245.224.1/20 à 145.245.239.254/20
16. 145.245.240.1/20 à 145.245.255.254/20

##### 60 sous réseaux

###### premiers

1. 145.245.0.1/22 à 145.245.3.254/22
2. 145.245.4.1/22 à 145.245.7.254/22

###### derniers

63. 145.245.248.1/22 à 145.245.251.254/22
64. 145.245.252.1/22 à 145.245.255.254/22

##### 200 sous réseaux

###### premiers

1. 145.245.0.1/24 à 145.245.0.254/24
2. 145.245.1.1/24 à 145.245.1.254/24

###### derniers

255. 145.245.254.1/24 à 145.245.254.254/24
256. 145.245.255.1/24 à 145.245.255.254/24

## Exercice 5

