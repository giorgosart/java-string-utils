![Maven Central](https://img.shields.io/maven-central/v/com.github.giorgosart/java-string-utils.svg)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

# java-string-utils
A `null` safe Java string manipulation library.

For javadoc, visit [this link](https://www.javadoc.io/doc/com.github.giorgosart/java-string-utils/)

## Usage
```
<dependency>
  <groupId>com.github.giorgosart</groupId>
  <artifactId>java-string-utils</artifactId>
  <version>1.2.0</version>
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
