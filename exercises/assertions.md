# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1- L'erreur est dûe à la représentation d'un double dans la mémoire. La solution que nous avons trouvé est la suivante :
````java
@Test
void test(){
    BigDecimal a = BigDecimal.valueOf(0.4);
    BigDecimal b = BigDecimal.valueOf(3);
    BigDecimal c = a.multiply(b) ;
    BigDecimal d = BigDecimal.valueOf(1.2);
    assertEquals(c,d);
}
````

2- La différence est que assertEquals utilise .equals tandis que assertSame utilise == pour comparer les 2 objets. Equals compare la valeur des objets alors que == compare les références.

Exemple où assertEquals et assertSame donne le même résultat :
````java
String s1 = « abcd » ;
String s2 = « abcd » ;
assertSame(s1,s2) ; // true
assertEquals(s1,s2) ; // true
````

Exemple où assertEquals et assertSame donne un résultat différent:
````java
String s1 = new String("abcd") ;
String s2 = new String("abcd") ;
assertSame(s1,s2) ; // false
assertEquals(s1,s2) ; //true
````

3- Nous pouvons appeler fail() quand un résultat ne répond pas à une condition désirée :
````java
@Test
public void testingCondition() {
    int result = randomInteger();
    if(result > Integer.MAX_VALUE) {
        fail("Result cannot exceed integer max value");
    }
}
````

4- Avec cette nouvelle méthode, il est possible de tester plusieurs exceptions dans le même test.