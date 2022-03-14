# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer


Grace à PMD, nous remarquons que nous pouvons modifier ce test car le test contient plusieurs assets ce qui fait que si ça échoue, nous n’avons pas la raison exacte. Pour améliorer, il vaut mieux diviser le test en plusieurs tests distincts.

![Exemple_PMD](images/exo2.png)
````java
@Test
public void addIgnoreNull() {
    final Set<String> set = new HashSet<>();
    set.add("1");
    set.add("2");
    set.add("3");
    assertFalse(CollectionUtils.addIgnoreNull(set, null));
    assertEquals(3, set.size());
    assertFalse(CollectionUtils.addIgnoreNull(set, "1"));
    assertEquals(3, set.size());
    assertTrue(CollectionUtils.addIgnoreNull(set, "4"));
    assertEquals(4, set.size());
    assertTrue(set.contains("4"));
    }
````

Voici la solution que nous proposons :
````java
private static Set<String> set ;

@BeforeEach
public void setUp(){
    set = new HashSet<>();
    set.add("1");
    set.add("2");
    set.add("3");
}
@Test
public void addIgnoreNull1() {
    assertFalse(CollectionUtils.addIgnoreNull(set, null));
    assertEquals(3, set.size());
    }
@Test
public void addIgnoreNull2() {
    assertFalse(CollectionUtils.addIgnoreNull(set, "1"));
    assertEquals(3, set.size());
    }
@Test
public void addIgnoreNull3() {
    assertTrue(CollectionUtils.addIgnoreNull(set, "4"));
    assertEquals(4, set.size());
    assertTrue(set.contains("4"));
    }

````