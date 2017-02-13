# ISI 3 TP N°3 : Tests Unitaires et Mocks
Antoine Caron, Victor Lequay, Laëtitia Matignon

>Le rapport est à saisir dans le ficher [RAPPORT.md](RAPPORT.md) en utilisant le [formalisme MarkDown](https://guides.github.com/features/mastering-markdown/)

## Tests boite noire

L’objectif de cette première partie est de tester les classes de deux packages persons et people, permettant de représenter des personnes.
Vous trouverez dans ce projet :
* Junit
* Mockito
* un fichier persons.jar pour le package **persons**
* un fichier people.jar pour le package **people**

Le dossier **javadoc** contient la documentation des packages **persons** et **people**.


Au fil des questions suivantes, vous devez définir des cas de tests pour tester les méthodes de l’interface **IPerson**. 
Ces cas de tests doivent couvrir efficacement le domaine d’entrée de ces méthodes. 
Les cas de tests seront exécutées pour tester les différentes classes implémentant l’interface **IPerson**. 
**La classe persons.Person est normale- ment sans erreurs, les classes du package people ont toutes au moins une erreur.**


####Question 1 

Lisez la documentation de l’interface **IPerson**. 
On souhaite tester les méthodes *wasBorn* et *getAge*. 
Pour chaque méthode, réalisez une analyse partitionnelle en proposant un partitionnement en classes d’équivalence pour chaque donnée d’entrée. 
Choisissez les données de tests et oracles correspondant pour obtenir les cas de test.

####Question 2 

Créez une classe de test **JUnit**, nommée **TestPerson**, pour tester la classe **Person** du package *persons*. 
Implémentez les cas de tests définis à la question précédente pour les méthodes *wasBorn* et *getAge*. Exécutez ces cas de tests. 
Tous les tests devraient être réussis (la classe **Person** est normalement sans erreurs).

####Question 3 

On souhaite maintenant faire passer ces tests aux classes du package people qui implémentent l’interface **IPerson** (donc **la classe people.Personne n’est pas à tester pour l’instant**). 
Pour cela, proposez une architecture pour faire passer les cas de tests existants à toutes ces classes sans réécrire de nouveaux tests.

####Question 4 

Pour chacune des classes du package **people** qui implémentent l’interface **IPerson** (donc **la classe people.Personne n’est pas à tester ici**), vous devez avoir au moins un test qui échoue sur chacune des classes. 
Si ce n’est pas le cas, votre analyse réalisée à la question 1 ne garantie pas une bonne couverture du domaine des don- nées d’entrée. 
**Vous devez donc compléter vos cas de tests et refaire passer tous les tests à toutes les classes qui implémentent l’interface IPerson (y compris à persons.Person).**

####Question 5 
Utiliser un patron de conception pour faire passer les tests précédents à la classe **Personne** du package *people*, qui n’implémente pas l’interface **IPerson**.

## Tests en isolation et Mock


On souhaite maintenant implémenter et tester des requêtes sur des listes de personnes. On veillera à utiliser une interface générique pour représenter les personnes, afin de faciliter l’écriture des tests. On utilisera donc l’interface IPerson du package persons.

####Question 6 

Créez une classe **OutilsPerson** dans laquelle vous devez implémenter une méthode qui prend en paramètre une liste de **IPerson**, une date au format GregorianCalendar, un âge (nombre d’années) minimal et un âge maximal (ce sont des entiers). 
Cette méthode doit retourner l’ensemble des personnes parmi la liste passée en paramètre dont l’âge à la date donnée est dans l’intervalle [ageminimal,agemaximal].

A titre d’exemple, la méthode pourra être utilisée pour retourner la liste des personnes qui auront entre 60 et 65 ans le 10 mai 2050.

La méthode renverra une exception *IllegalArgumentException* si l’age minimal est supérieur à l’age maximal.


####Question 7 

Ecrivez une méthode de recherche qui prend en paramètre une liste de IPerson et une date au format GregorianCalendar. Cette méthode retourne l’âge de la personne la plus âgée parmi la liste à la date donnée en paramètre. Si la liste en entrée est vide, la méthode retournera -1.

Pour tester ces méthodes dans les questions suivantes, on utilisera des objets mock pour représenter les personnes, en utilisant le framework Mockito 3 dont un fichier jar est disponible dans le dossier lib de l’archive TPPerson.zip.

En utilisant un objet mock, les tests des requêtes seront indépendants de la méthode de calcul de l’âge des personnes (méthode utilisée dans les méthodes de recherche).

####Question 8
 
Ecrivez des tests unitaires (comportement nominal et aux limites) pour les deux requêtes implémentées aux questions 6 et 7. Pour cela, vous utiliserez un objet mock qui permettra d’éviter des erreurs dans vos tests qui seraient dues au calcul de l’âge des personnes.

####Question 9 

Trouvez un outil d’analyse de couverture de code utilisable avec votre IDE (par ex. [http://www.eclemma.org/](http://www.eclemma.org/) pour eclipse). 
Vérifiez avec cet outil que vos tests couvrent l’ensemble des lignes des requêtes.

####Question 10 
On souhaite vérifier par des tests que la méthode de la question 7 calcule le plus grand âge de façon " anonyme ", c’est-à-dire sans lire les noms et prénoms des personnes ; et en utilisant au moins une fois la méthode getAge. 
Vérifiez ces propriétés à l’aide des objets mock.