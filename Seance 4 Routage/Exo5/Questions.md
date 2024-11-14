# Exo 5

## 3.1 Trame RIP

Voir [trame-RIP.png](trame-RIP.png)

## 3.2 Quelle est sa distance avec le routeur D ?

Il y a plusieurs chemins possibles pour atteindre D depuis H. Il y a une distance de 1, 2 ou 3 sauts.

### Identifier les deux (3??) interfaces du routeur D et donner celle où le paquet arrivera le plus vite

- 192.168.7.2
- 192.168.15.1
- 192.168.11.2

Le paquet situé à H arrivera le plus vite à D par l'interface 192.168.11.2 (voir [trame-RIP.png](trame-RIP.png)), ie en passant par le routeur C.

## 4

### Avec la commande traceroute sur le PC M4, obtenir le chemin parcouru entre le PC M4 et la machine M14

Voir [traceroute4.png](traceroute4.png)

## 5 Supprimer le lien entre A et H, et attendre que des nouveaux paquets RIP transitent pour que les tables de routages soient mises à jour. Recommencer l’opération de la question précédente et donner le nouveau chemin.

Voir [traceroute5.png](traceroute5.png)

On remarque que le chemin est différent que celui de la question 4. A-H était le chemin qui permettait d'être le plus court, mais, comme il a été supprimé, un autre chemin a été trouvé (s'il existe. Ici, oui).