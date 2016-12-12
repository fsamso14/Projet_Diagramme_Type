# Projet Diagramme de Types
Un langage embarqué JAVA pour dessiner des diagrammes de types


# Auteurs
Matyas Amrouche / Matthieu Posmyk / Fabian Samson

# Représentation des éléments du diagramme
1) Classes et interfaces

Les classes et interfaces sont représentées par des rectangles de couleurs : classe en jaune, classe abstraite en vert, interface en bleu.

2) Liaisons

Les liaisons qui existent entre les différentes classes ou interfaces sont représentées par des flèches de couleurs qui pointent vers l'élément dont elles héritent, implémentent ou délèguent les propriétés, ainsi l'héritage est représenté par une flèche noire, l'implémentation en bleu et la déléguation en vert.

# Utilisation
1)Projet Maven a importé sous Eclipse

2)La classe utile à la création d'un document SVG est la classe Main. La classe est commentée, ainsi l'utilisateur n'a plus quà suivre les consignes. De plus, des instances déjà en places servent d'exemple à l'utilisateur quant à la nomenclature à utiliser afin de générer le diagramme type voulu. 

# Interprétation
Le diagramme s'affiche au format texte dans la console, sous la forme d'un script XML. L'utilisateur devra le copier puis le coller dans un fichier .svg qui s'ouvrira dans le navigateur pas défaut de l'utilisateur.

# Bugs de représentation

Il se peut que dans certains rares cas les liaisons entre les différents types ne soient pas dessinées avec une précision optimale

