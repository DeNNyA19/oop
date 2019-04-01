//for plugin 4
javac -d out src/task3/domain/Component.java src/task4/*.java
cd out
jar cf ../plugin4.jar task3/domain/Component.class task4/*.class
cd ..

//for plugin 5
javac -d out src/task3/domain/Component.java src/task4/Plugin.java src/task5/*.java
cd out
jar cf ../plugin5.jar task3/domain/Component.class task4/Plugin.class task5/*.class ../META-INF
cd ..


//for project
javac -cp "jar_files/reflections.jar;jar_files/javassist.jar;jar_files/commons-lang.jar" -d out src/task3/domain/*.java src/task3/Runner.java src/task4/Plugin.java
cd out
jar cf ../task4.jar task3/domain/*.class task3/Runner.class task4/Plugin.class
//with plugin 4
java -cp "task4.jar;plugin4.jar;jar_files/reflections.jar;jar_files/javassist.jar;jar_files/guava.jar;jar_files/commons-lang.jar" task3.Runner
//with plugin 5
java -cp "task4.jar;plugin4.jar;plugin5.jar;jar_files/reflections.jar;jar_files/javassist.jar;jar_files/guava.jar;jar_files/commons-lan
g.jar" task3.Runner
//without plugin
java -cp "task4.jar;jar_files/reflections.jar;jar_files/javassist.jar;jar_files/guava.jar;jar_files/commons-lang.jar" task3.Runner
