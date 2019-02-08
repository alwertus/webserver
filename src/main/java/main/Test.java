package main;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1,"odin");
        hm.put(2,"dva");
        hm.put(3,"tre");
        //hm.put(2,"chetire");
        //hm.put(2,"dva");
        hm.put(5,"pyat");
        System.out.println(hm);
    }
}
/*
СБОРКА.
В POM файл добавить проперти
 <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
  </properties>

  и инструкции для сборки
  <build>
        <plugins>
            <plugin>
                <artifactId>maven-assembly-plugin</artifactId>
                <configuration>
                    <descriptorRefs>
                        <descriptorRef>jar-with-dependencies</descriptorRef>
                    </descriptorRefs>
                </configuration>
            </plugin>
        </plugins>
    </build>
* */
