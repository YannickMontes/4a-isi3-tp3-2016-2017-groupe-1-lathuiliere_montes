**Nom/Prénom Etudiant 1 : Yoann Lathuilière**

**Nom/Prénom Etudiant 2 : Yannick Montes**

# Rapport TP3

### Question 1 : réalisation d'une analyse partitionnelle

Ces deux méthodes partagent les mêmes classes d'équivalences. On peut donc définir les 4 classes suivantes :

|            Classe           | Validité |
|:---------------------------:|:--------:|
|          Date nulle         | Invalide |
| Date strictement inférieure | Invalide |
|          Date égale         |  Valide  |
| Date strictement supérieure |  Valide  |

On va alors créer 4 tests unitaires pour chaque méthode, afin de tester toutes nos classes d'équivalences.
Voici un tableau décrivant les différents tests ainsi que les résultats attendus.

**Méthode wasBorn:**

|      Classe     | Validité |                 Représentant                | Oracle |
|:---------------:|:--------:|:-------------------------------------------:|:------:|
|    Date null    | Invalide |  should_give_illegal_argument_exception_on_null_date  |  IllegalArgumentException |
| Date inférieure | Invalide |  should_give_false_on_date_before_birthday  |  false |
|    Date égale   |  Valide  | should_give_true_on_date_equals_to_birthday |  true  |
| Date supérieure |  Valide  |   should_give_false_on_date_after_birthday  |  true  |


**Méthode getAge:**

|      Classe     | Validité |                         Représentant                         |          Oracle          |
|:---------------:|:--------:|:------------------------------------------------------------:|:------------------------:|
|    Date null    | Invalide |       should_give_illegalArgumentException_on_null_date      | IllegalArgumentException |
| Date inférieure | Invalide | should_give_illegalArgumentException_on_date_before_birthday | IllegalArgumentException |
|    Date égale   |  Valide  |           should_give_zero_on_date_same_as_birthday          |             0            |
| Date supérieure |  Valide  |   should_give_twelve_on_date_twelve_years_after_birth_date   |            12            |


### Question 2 : implémentation des tests

Une fois tous les tests écrits, l'exécution nous a permis de nous assurer du bon fonctionnement de la classe Person.
![](/images/question2.png?raw=true)


### Question 3 : architecture abstraite

Pour faire passer les tests aux différentes classes du package people qui implémentent l’interface IPerson, sans avoir besoin de réécrire le code à chaque fois, il faut créer une classe abstraite [IPersonTest] (src/test/java/persons/IPersonTest.java).
Cette classe contient tous les tests écrits précédemment et si besoin, il est possible d'"overide" ces méthodes pour faire des tests plus spécifiques.
Pour tester toutes les classes, il faudra alors créer un fichier par classe et seulement changer la fonction setup() pour que les tests s'exécutent.

![](/images/IPersonTest.png?raw=true)


### Question 4 : tests pour toutes les classes implémentant IPerson

Pour tester le fonctionnement de notre nouvelle architecture, nous avons créé un fichier pour chaque classe implémentant IPerson, avec la fonction setup() qui change.
Après une première exécution, tous les tests passent, alors qu'au moins un par classe est censé échouer. Ce résultat indique que notre couverte n'est pas optimale.
Nous avons alors ajouté 6 tests supplémentaires pour la classe d'équivalence "Date strictement inférieure".

**Méthode wasBorn:**

|            Classe           | Validité | Représentant                               | Oracle |
|:---------------------------:|:--------:|--------------------------------------------|--------|
| Date strictement inférieure | Invalide | should_give_false_on_year_before_birthday  | False  |
| Date strictement inférieure | Invalide | should_give_false_on_month_before_birthday | False  |
| Date strictement inférieure | Invalide | should_give_false_on_day_before_birthday   | False  |

**Méthode getAge:**

|            Classe           | Validité | Représentant                                                  | Oracle                   |
|:---------------------------:|:--------:|---------------------------------------------------------------|--------------------------|
| Date strictement inférieure | Invalide | should_give_illegalArgumentException_on_day_before_birthday   | IllegalArgumentException |
| Date strictement inférieure | Invalide | should_give_illegalArgumentException_on_month_before_birthday | IllegalArgumentException |
| Date strictement inférieure | Invalide | should_give_illegalArgumentException_on_year_before_birthday  | IllegalArgumentException |

Après une nouvelle exécution, certains de nos tests échouent.
D'après les consignes, cela indique que nos tests couvrent le code de manière optimale et qu'il y a des bugs dans l'implémentation des classes.

![](/images/question4.png?raw=true)
