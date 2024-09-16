import struct

def serialiser(joystickGauche, joystickDroit, boutons):

    gaucheX, gaucheY = joystickGauche
    droitX, droitY = joystickDroit

    # convertir les états des boutons en un seul entier
    # boutons = [True, False, True, False, True, False, False, False, False]
    # on a 2^0 + 2^2 + 2^4 = 1 + 4 + 16 = 21 (000010101 en binaire = 21 en décimal)
    boutonsInt = 0
    for i, appuye in enumerate(boutons):
        if appuye:
            boutonsInt += 2**i

    # empaqueter les données en octets
    donnees = struct.pack("!4fH", gaucheX, gaucheY, droitX, droitY, boutonsInt)
    return donnees


def deserialiser(donnees):
  
    gaucheX, gaucheY, droitX, droitY, boutonsInt = struct.unpack("!4fH", donnees) # !4fH signifie: "4 f (floats) et 1 H (entier non signé (unsigned short)) en ! (big-endian)". Voir https://docs.python.org/3/library/struct.html#format-characters pour plus d'informations.

    # convertir l'entier en une liste de booléens
    boutons = []
    for i in range(9):
        masqueBit = boutonsInt & 2**i # & est l'opérateur "et" bit à bit. Exemple: "21 & 2**4" = "21 & 16" = 16. Si le résultat est 0, le bit n'est pas activé, sinon il l'est.
        boutons.append(bool(masqueBit != 0))
        # print(boutonsInt, i, masqueBit)

    joystickGauche = (gaucheX, gaucheY)
    joystickDroit = (droitX, droitY)
    return joystickGauche, joystickDroit, boutons


def main():
    joystickGauche = (0.2, -0.5)
    joystickDroit = (-1.0, 1.0)
    boutons = [True, False, True, False, True, False, False, False, False]

    donneesSerialisees = serialiser(joystickGauche, joystickDroit, boutons)
    print(f"Données sérialisées: {donneesSerialisees}")

    joystickGaucheDeserialise, joystickDroitDeserialise, boutonsDeserialises = deserialiser(donneesSerialisees)
    print(f"Joystick gauche désérialisé: {joystickGaucheDeserialise}")
    print(f"Joystick droit désérialisé: {joystickDroitDeserialise}")
    print(f"Boutons désérialisés: {boutonsDeserialises}")

if __name__ == "__main__":
    main()