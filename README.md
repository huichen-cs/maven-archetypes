# Maven Archetypes

## Archetype

`java9-junit4-basic`: a very basic Maven archetype. The only difference between
this one and the Quickstart archetype is that the project compiles using
Java 9 and JUnit 4. 

`java9-junit4-slf4j-basic`: a very basic Maven archetype. The only difference
between this one and the Quickstart archetype is that the project compiles
using Java 9 and JUnit 4, and has necessary dependencies for logging with
`slf4j` and Apache Log4j as the actual logging framework. 

## Repository 

`java9-junit4-basic`: model Maven Java project for the
`java9-junit4-basic-archetype`

`java9-junit4-slf4j`: model Maven Java project for the
`java9-junit4-slf4j-basic` archetype.

`java9-junit4-slf4j-basic-archetype`: Maven project for the archetype, 
generated and revised from `java9-junit4-slf4j`.

## Creating Archetypes

There are several methods to create a Maven archetype. We create this archetype
by modeling an existing Maven project. Below is a work flow to create Maven
archetypes.

1. Create a Maven project, such as a Maven Java project in the Eclipse IDE,
   e.g., the `java9-junit4-basic` project and the project is at the
   `java9-junit4-basic` directory. Declare necessary dependencies in its
   `pom.xml`.
2. Generate the Maven archetype source from the parsing project in the project
   directory, e.g.,
    ```
    cd java9-junit4-basic
    mvn archetype:create-from-project    
    ```
    From the output, we should observe something similar to,
    ```
    [INFO] Archetype created in target/generated-sources/archetype
    ```
    where the directory `target/generated-sources/archetype` holds the generated
    Maven archetype source.  The reference for this step is,

    [Archetype creation](https://maven.apache.org/archetype/maven-archetype-plugin/advanced-usage.html)

3. Create the Maven archetype from the generated source at the directory
where the source is, e.g.,
    ```
    cd target/generated-sources/archetype
    mvn install
    ``` 
    We should observe that Maven has created the archetype jar file and pom file,
    as shown in the output, similar to,
    ```
    [INFO] Installing 
           java9-junit4-basic/target/generated-sources/archetype/target/java9-junit4-basic-archetype-1.0.jar 
           to 
           ${HOME}/.m2/repository/java9-junit4-basic-archetype/1.0/java9-junit4-basic-archetype-1.0.jar
    [INFO] Installing 
           java9-junit4-basic/target/generated-sources/archetype/pom.xml 
           to 
           ${HOME}/.m2/repository/java9-junit4-basic-archetype/1.0/java9-junit4-basic-archetype-1.0.pom
    ```

4. We can run an integration test and see whether everything appears to be fine.
    ```
    mvn integration-test
    ```

5. We are now ready to create a catalogue file for the archetypes. 
    ```
    mvn archetype:crawl
    ```
    which search the Maven repository directory at `${HOME}/.m2/repository`, and create the
    catagloue file at `${HOME}/.m2/repository/archetype-catalog.xml`. We may need
    to edit the catalogue file to remove the archetypes that we do not wish to 
    appear in the catalogue. 

6. We may publish the archetypes at the Maven central repository or some
   other offical repositories. To publish at the Maven central repository, we
   must meet its requirements, such as, signing the archetype with our PGP key,
   declaring license term, and some other measures. The guideline is at,

    [Guide to uploading artifacts to the Central Repository](https://maven.apache.org/guides/mini/guide-central-repository-upload.html)

    and

    [Requirements](http://central.sonatype.org/pages/requirements.html)

    However, if we elect to publish the archetype at a self-maintained
    repository, we may skip these steps by simplying copying the catalogue file
    and the archetype files to the repository. Assuming that we publish the
    achetype to `example.com`, the Web root is
    `ssh://webadmin@example.com:/var/html`, and the repositry is at
    `http://example.com/maven/archetypes/`, we may do the following,

    ```
    cd ${HOME}/.m2/repository
    scp -r archetype-catalog.xml java9-junit4-basic \
           webadmin@example.com:/var/html/maven/archetypes/
    ```

    For this particular example, we may set up a remote archetype using the
    archetype catalogue at,

    [Java9-JUnit4-Basic Archetype](https://huichen-cs.github.io/maven/archetypes/archetype-catalog.xml)





