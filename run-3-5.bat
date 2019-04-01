javac -d out src/task3/domain/Machine.java src/task4/Plugin.java
cd out
jar cf ../plugin.jar task4/Plugin.class
cd ..

javac -cp plugin.jar -d out src/task3/domain/Machine.java src/task4/MachineRunnerPlugin.java src/task4/ColorStatisticsPlugin.java src/task5/ArchivePlugin.java src/task5/DeArchivePlugin.java
cd out
jar cf ../plugin-impl.jar task4/MachineRunnerPlugin.class task4/ColorStatisticsPlugin.class task5/ArchivePlugin.class task5/DeArchivePlugin.class ../META-INF
cd ..

javac -cp "plugin.jar;json-reader.jar" -d out src/task3/domain/Machine.java src/task6/JSONReaderPlugin.java
cd out
jar cf ../plugin-adapter.jar task6/JSONReaderPlugin.class META-INF
cd ..

javac -cp "commons-lang3-3.7.jar;plugin.jar" -d out src/task3/*.java src/task3/domain/*.java src/utils/*.java

java -cp "out;commons-lang3-3.7.jar;plugin.jar;plugin-impl.jar;org.json.jar;json-reader.jar;plugin-adapter.jar" task3.Runner


javac -d out src/task3/domain/Component.java src/task4/Joystick.java src/task4/ComponentBuyerPlugin.java src/task4/Plugin.java
cd out
jar cf ../plugin.jar task4/Plugin.class task4/ComponentBuyerPlugin.class task4/Joystick.class task3/domain/Component.class
cd ..