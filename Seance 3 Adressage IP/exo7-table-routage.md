# Table de routage de R0

|Destination|Prochain Saut|Interface|Nb de sauts|
|---|---|---|---|
|136.1.0.0|Connexion directe (136.1.1.1)|P1|0|
|138.9.0.0|Connexion directe (138.9.1.1)|P2|0|
|135.12.0.0|136.1.2.3|P1|1|
|137.5.0.0|136.1.2.5|P1|1|
|140.33.0.0|138.9.1.2|P2|1|


NB : 
- Compter le nb de saut est un protocole RIP (algo de Bellman-Ford)
- Compter la distance est un protocole OSPF (algo de Dijkstra)