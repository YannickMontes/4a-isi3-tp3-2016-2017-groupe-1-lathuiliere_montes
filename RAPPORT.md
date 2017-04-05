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
|    Date égale   |  Valide  |          should_give_zero_on_date_equal_to_birthday          |             0            |
| Date supérieure |  Valide  |       should_give_at_least_zero_on_date_after_birthday       |            >=0           |