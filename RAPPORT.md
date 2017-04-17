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


### Question 3

![](/images/IPersonTest.png?raw=true)

La solution est de mettre tout les tests que nous venons de créer dans une classe IPersonTest, qui est abstraite. 
Cette dernière possède tout les tests fait précédement, pouvant être overidés sur ils sont plus spécifique pour un certain cas.


