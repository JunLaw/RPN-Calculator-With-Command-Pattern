# Exemple de projet Maven/Java

## Étape 1 : initialiser le projet
### Créer le projet à partir d'un archétype
L'archétype `org.apache.maven.archetypes:maven-archetype-quickstart` permet de créer un squelette de projet Maven/Java.

```bash
mvn archetype:generate \
    -DinteractiveMode=false \
    -DarchetypeGroupId=org.apache.maven.archetypes \
    -DarchetypeArtifactId=maven-archetype-quickstart \
    -DarchetypeVersion=1.4 \
    -DgroupId=fr.uvsq.poo \
    -DartifactId=maven-exemple \
    -Dpackage=fr.uvsq.poo.compte
```

### Initialiser le dépôt git
```bash
git init
git add .
git commit -m"Initialise le projet Maven"
```
Après ces commandes, le dépôt comporte un _commit_ sur la branche _master_.

### Faire le lien avec le dépôt distant sur la forge (_github_, _bitbucket_, ...)
Tout d'abord, il est nécessaire de créer le dépôt distant sur la forge.
Ensuite, il suffit de le lier avec le dépôt local.

```bash
git remote add origin git@github.com:hal91190/maven-exemple.git
git push -u origin master
```

### Vérifier la construction du projet avec Maven
On génère un `jar` du projet.

```bash
mvn package
```



Cette commande crée un répertoire `target` contenant les résultats de la construction du projet.
Ce répertoire ne doit pas être ajouté au dépôt git.
On ajoute donc un fichier `.gitignore` à partir du modèle se trouvant sur [github](https://raw.githubusercontent.com/github/gitignore/master/Maven.gitignore).

### Importer le projet dans l'IDE
La plupart des IDEs permettent d'importer un projet Maven.
Il est préférable de ne pas ajouter les fichiers spécifiques à l'IDE dans le dépôt git.
On modifie donc le `.gitignore` en conséquence.

## Étape 2 : configurer le projet
### Fixer la version 11 de Java pour les sources et la cible
Il suffit pour cela d'ajouter deux propriétés dans le `pom.xml`.

```xml
<properties>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
</properties>
```

### Changer la version de JUnit pour la version 4.13.1
On modifie la dépendance dans le `pom.xml`.

```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.1</version>
    <scope>test</scope>
</dependency>
```

### Rendre le `jar` exécutable
Pour cela, il indiquer à Maven d'ajouter un fichier `Manifest` dans le `jar` en précisant l'attribut `Main-class`.

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <version>3.0.2</version>
            <configuration>
                <archive>
                    <manifest>
                        <mainClass>fr.uvsq.poo.compte.App</mainClass>
                    </manifest>
                </archive>
            </configuration>
        </plugin>
    </plugins>
</build>
```

À partir de là, il est possible d'exécuter l'application avec `java -jar target/maven-exemple-1.0-SNAPSHOT.jar`.

## Étape 3 : améliorer le projet (optionnel)
### Créer un `jar` intégrant les dépendances
Le plugin [`assembly`](https://maven.apache.org/plugins/maven-assembly-plugin/) permet de générer une archive contenant l'ensemble des dépendances d'un projet.

```xml
<build>
    <plugins>
        <plugin>
            <artifactId>maven-assembly-plugin</artifactId>
            <version>3.1.0</version>
            <configuration>
                <descriptorRefs>
                    <descriptorRef>jar-with-dependencies</descriptorRef>
                </descriptorRefs>
                <archive>
                    <manifest>
                        <mainClass>${main-class}</mainClass>
                    </manifest>
                </archive>
            </configuration>
            <executions>
                <execution>
                    <id>make-assembly</id>
                    <phase>package</phase>
                    <goals>
                        <goal>single</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

### Créer un `jar` des sources du projet
Le plugin [`source`](https://maven.apache.org/plugins/maven-source-plugin/) permet de générer une archive des sources du projet.

```xml
<build>
    <plugins>
        <plugin>
            <artifactId>maven-source-plugin</artifactId>
            <version>3.0.1</version>
            <executions>
                <execution>
                    <id>attach-sources</id>
                    <phase>package</phase>
                    <goals>
                        <goal>jar-no-fork</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

### Créer un `jar` avec la javadoc
Le plugin [`javadoc`](https://maven.apache.org/plugins/maven-javadoc-plugin/) permet de générer une archive de la javadoc.

```xml
<build>
    <plugins>
        <plugin>
            <artifactId>maven-javadoc-plugin</artifactId>
            <version>3.0.0-M1</version>
            <executions>
                <execution>
                    <id>attach-javadocs</id>
                    <phase>package</phase>
                    <goals>
                        <goal>jar</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```

### Intégrer l'extension Hamcrest pour JUnit
Cette [extension]() apporte un syntaxe plus lisible pour les tests JUnit.

```xml
<!-- https://mvnrepository.com/artifact/org.hamcrest/hamcrest-all -->
<dependency>
    <groupId>org.hamcrest</groupId>
    <artifactId>hamcrest-all</artifactId>
    <version>1.3</version>
    <scope>test</scope>
</dependency>
```

### Étape 4 : implémenter la classe `Account` et les tests unitaires

Exercices 3.1

1.Cette classe respecte-t-elle SRP?

La classe ne respecte pas le Single Responsibility Programm. La classe calcule et affiche les coordonées d'un employé, or la classe peut avoir deux raison de changer, soit le salaire change soit les coordonées change ou le format des coordonnées peuvent changer egalement.

2.Si la méthode de calcul change il faut modifier les attributs de la classe mais pas l'affichage des coordonées

3. Si l'affichage est dans un CSV il faudra faire appel à une fonction de lecture I/O ce qui viole le principe de SRP

4. pour que SRP Soit respecté il faut séparé les coordonées des Employé ainsi que leur calcul de salaire.

Exercice 3.2

fichier employe.java

Exercice 3.3


Exercice 3.4

1.L'interface Printer contient trop de methode qui sont independante entre elle mais fait que la classe simplePrinter depends de toute les methodes dans cette interface de manière inutile

2.si on modifie la méthode fax on devra recompiler toutes l'interface Printer et toutes les methodes associées, il suffit donc de séparer toutes les methode dans une interfce chacune.

3.Dossier Printer

