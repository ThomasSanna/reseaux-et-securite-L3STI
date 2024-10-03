# Exercice 3: Jeu  en ligne

## Question 2 Expliquer pourquoi il est inutile d’identifier le destinataire dans le paquet de données, et indiquer l’endroit où l’identification est réalisée lors de la réalisation du paquet

Il est inutile d'identifier le destinataire dans le paquet de données car **le paquet de données est envoyé à tous les joueurs**. L'identification du destinataire est réalisée lors de la réalisation du paquet dans la couche **transport**.

## Question 3 Situation : le paquet 10 atteint le client avant le paquet 8. Que faire du paquet 8 dans cette situation?

Dans cette situation, le paquet 8 doit être **ignoré** car il est arrivé trop tard.

## Question 4 Avec une telle implémentation, faut-il préférer TCP ou UDP ? Réponse en une phrase courte

L'implémentation TCP est préférable pour éviter la situation précédente de la question 1.

## Question 5  On suppose qu’il y a une latence de 80 ms entre le client et le serveur. Le client modifie l’état de son application uniquement lorsqu’il reçoit une information du serveur. Au temps t = 100ms, le client se situe en (2, 4) et envoie ”D” au serveur. Indiquer l’état du client et du serveur à 200ms et `a 300ms, en sachant que le serveur a commencé à émettre à t = 0ms

- À 200ms, le client est en (2, 4) et le serveur est en (3, 4).
- À 300ms, le client est en (3, 4) et le serveur est en (3, 4).

## Question 6 La latence augmente alors à 150 ms. Le client envoie ”Q” au serveur à t = 300ms en étant à (3, 4), puis à t = 400ms, il envoie ”S”. Compléter le schéma de la figure 3 en annexe A, et expliquer en quoi une telle architecture n’est pas envisageable pour une simulation en temps réel. Pour la suite, on ajoute la capacité au client de prédire son état au lieu d’attendre le serveur (voir fig. 2). Lorsque le client reçoit un paquet du serveur, il applique la logique autoritaire et déplace alors les entités aux positions désignées. Seulement, cela peut poser problème si la latence devient trop haute

Une telle architecture n'est pas envisageable pour une simulation en temps réel car la latence est trop élevée et le client doit attendre le serveur pour mettre à jour son état.