**Nom/Prénom Etudiant 1 : Yoann Lathuilière**

**Nom/Prénom Etudiant 2 : Yannick Montes**

# Rapport TP3

### Question 1

**wasBorn method:**

|      Classe     | Validité |                 Représentant                | Oracle |
|:---------------:|:--------:|:-------------------------------------------:|:------:|
|    Date null    | Invalide |  should_give_illegal_argument_exception_on_null_date  |  IllegalArgumentException |
| Date inférieure | Invalide |  should_give_false_on_date_before_birthday  |  false |
|    Date égale   |  Valide  | should_give_true_on_date_equals_to_birthday |  true  |
| Date supérieure |  Valide  |   should_give_false_on_date_after_birthday  |  true  |


**getAge method:**

|      Classe     | Validité |                         Représentant                         |          Oracle          |
|:---------------:|:--------:|:------------------------------------------------------------:|:------------------------:|
|    Date null    | Invalide |       should_give_illegalArgumentException_on_null_date      | IllegalArgumentException |
| Date inférieure | Invalide | should_give_illegalArgumentException_on_date_before_birthday | IllegalArgumentException |
|    Date égale   |  Valide  |           should_give_zero_on_date_same_as_birthday          |             0            |
| Date supérieure |  Valide  |   should_give_twelve_on_date_twelve_years_after_birth_date   |            12            |


### Question 3

![](/images/IPersonTest.png?raw=true)

La solution est de mettre tout les tests que nous venons de créer dans une classe IPersonTest, qui est abstraite. 
Cette dernière possède tout les tests fait précédement, pouvant être overidés sur ils sont plus spécifique pour un certain cas.


