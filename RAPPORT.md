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

<br>

### Question 2 : implémentation des tests

Une fois tous les tests écrits, l'exécution nous a permis de nous assurer du bon fonctionnement de la classe Person.
![](/images/question2.png?raw=true)

<br>

### Question 3 : architecture abstraite

Pour faire passer les tests aux différentes classes du package people qui implémentent l’interface IPerson, sans avoir besoin de réécrire le code à chaque fois, il faut créer une classe abstraite [IPersonTest] (src/test/java/persons/IPersonTest.java).
Cette classe contient tous les tests écrits précédemment et si besoin, il est possible d'"overide" ces méthodes pour faire des tests plus spécifiques.
Pour tester toutes les classes, il faudra alors créer un fichier par classe et seulement changer la fonction setup() pour que les tests s'exécutent.

![](/images/IPersonTest.png?raw=true)

<br>

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

<br>

### Question 5 : patron de conception "Adapteur"

Pour faite passer les tests précédents à la classe Personne du package people (qui n’implémente pas l’interface IPerson), il faut utiliser le patron de conception "Adapteur".
On va alors créer une classe [PersonneAdapter](src/test/java/adapter/PersonneAdapter.java), qui étend de people.Personne et qui implémene IPerson.
On va ensuite écrire la méthode wasBorn pour respecter l'implémentation d'IPerson.

Enfin, on va créer une classe [PersonneTest](src/test/java/persons/PersonneAdapterTest.java) pour faire passer les tests sur la classe Personne.
Comme spécifié dans les consignes, une partie de nos tests échouent.


<br>

### Question 6 & 7 : classe OutilsPerson

Conformément aux consignes, nous avons créé la classe [UtilsPerson](src/main/java/utils/UtilsPerson.java) et nous avons implémenté les deux méthodes demandées : getPersonsInInterval et getAgeOfOldestPersonInList.
Les deux méthodes utilisent l'API stream présenté lors du premier TP.

```java
    public List<IPerson> getPersonsInInterval(ArrayList<IPerson> persons, int min, int max, final GregorianCalendar date) throws IllegalArgumentException{
        if(min > max) {
            throw new IllegalArgumentException("Minimal age superior at maximal age");
        }

        return persons.stream()
                .filter(person -> {
                    int age = person.getAge(date);
                    return age >= min && age <= max;
                })
                .collect(toList());
    }

    public int getAgeOfOldestPersonInList(ArrayList<IPerson> persons, final GregorianCalendar date)
    {
        if(persons == null || persons.size() == 0)
        {
            return -1;
        }

        int maxAge = Integer.MIN_VALUE;

        //TO OPTIM WITH STREAM

        for(IPerson person : persons)
        {
            if(person.getAge(date) > maxAge)
                maxAge = person.getAge(date);
        }

        return maxAge;
    }
```

<br>

### Question 8 : tests avec Mockito

Pour tester ces deux méthodes, nous avons utilisé des objets mock, pour éviter les erreurs liées aux autres méthodes (calcul de l'âge par exemple).
Nous avons écrit ces tests dans la classe [UtilsPersonTest](src/test/java/utils/UtilsPersonTest.java).
Par exemple, au lieu de créer des objets de type Person, on crée des objets de type Mock, suivant la classe Person.
Mockito permet ensuite de définir la valeur de retour des méthodes de la classe Person, pour avoir un comportement sûr dans notre environnement de test.

*Exemple d'objet de type Mock*
```java
    personAbove30 = Mockito.mock(Person.class); // création d'un objet de type Mock, suivant la classe Person
    Mockito.when(personAbove30.getAge(Mockito.any(GregorianCalendar.class))).thenReturn(35); // simulation du comportement de la méthode getAge()
``` 

<br>

### Question 9 : TODO

Nous utilisons IntelliJ, proposant une couverture de test intégrée a l'IDE. 
Après avoir fait passer le test coverage, on obtient le résultat suivant: 

![](/images/question9.png?raw=true)

Pour le code que nous avons crée dans la classe UtilsPerson, le test est codé à 100%.
Néanmoins, nous ne pouvons pas obtenir la couverture de code pour toutes les autres classes, car c'est du code pré-compilé dans des .jar. 

<br>

### Question 10 : Vérification d'appel de fonction

Pour vérifier que la méthode de la question 7 calcule le plus grand âge de façon " anonyme " et en utilisant au moins une fois la méthode getAge, on va utiliser la fonction Mockito verify().
On peut ainsi savoir si la méthode getAge est appelée au moins une fois en utilisant atLeast(1).
```java
    verify(person, atLeastOnce()).getAge(anyObject());
```

Pour vérifier que les méthodes getName() et getFirstName() ne sont jamais appelés, on va utiliser la fonction verify() avec comme paramètre : never().
```java
    verify(person, never()).getFirstName();
    verify(person, never()).getName();
```
