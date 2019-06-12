[![Maven Central](https://img.shields.io/maven-central/v/com.github.giorgosart/java-string-utils.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.giorgosart%22%20AND%20a:%22java-string-utils%22)
[![Javadocs](https://www.javadoc.io/badge/com.github.giorgosart/java-string-utils.svg)](https://www.javadoc.io/doc/com.github.giorgosart/java-string-utils)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

# java-string-utils
A simple Java string utility library

## Usage
```
<dependency>
  <groupId>com.github.giorgosart</groupId>
  <artifactId>java-string-utils</artifactId>
  <version>1.0.0</version>
</dependency>
```

```
import static com.github.giorgosart.StringUtils.defaultString;
import static com.github.giorgosart.StringUtils.truncate;
import static com.github.giorgosart.StringUtils.isBlank;
import static com.github.giorgosart.StringUtils.isEmpty;
import com.github.giorgosart.TruncateAt;

public class Main {
    public static void main(String[] args) {
        System.out.println(isEmpty("")); //true
        System.out.println(isBlank("")); //true
        System.out.println(defaultString("", "default string")); //"default string"
        System.out.println(truncate("string", 2, TruncateAt.START.name())); //"st"
        System.out.println(truncate("string", 2, TruncateAt.START.name(),true)); //"st..."
    }
}
```
