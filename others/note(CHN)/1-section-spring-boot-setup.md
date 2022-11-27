1. 安装 spring boot

```diff
+ start.spring.io
+ Gradle project
+ Java
+ 2.2.2 (2.7.5)
+ group: com.weCode
+ Artifact: bookstore
+ Name: bookStore
+ Description: Demoproject for Spring Boot
+ Package name: com.weCode.bookStore
+ Jar
+ Java - 8 (8)

+ dependencies:
- spring web
- spring boot devtools
- spring data JPA
- Lombok
- H2 Database
```

2. download & run

```diff
$ brew install gradle
$ ./gradlew bootRun
```

3. download and install Java17, 解决错误：

```diff
- error: invalid source release: 17
```

4. add code

<!-- //////////////////////////// -->

- `bookStore/src/main/java/com/weCode/bookStore`

- new folder: controller
- new file: BookController.java

```java
package com.weCode.bookStore.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.http.ResponseEntity;

import com.weCode.bookStore.dto.BookDto;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
  @GetMapping
  public ResponseEntity<List<BookDto>> getBooks() {
    BookDto book = BookDto.builder()
                  .title("My First book title")
                  .build();

    List<BookDto> books = new ArrayList<>();
    books.add(book);
    return ResponseEntity.ok(books);
  }
}
```

<!-- //////////////////////////// -->

- `bookStore/src/main/java/com/weCode/bookStore`

- new folder: dto
- new file: BookDto.java

```java
package com.weCode.bookStore.dto;

import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
  private String title;
}
```

<!-- //////////////////////////// -->

- `bookStore/src/main/java/com/weCode/bookStore/BookStoreApplication.java`

```java
package com.weCode.bookStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

}
```

5. code 错误 debug

- BookController.java

```diff
- error: cannot find symbol @RequestMapping
+ import org.springframework.web.bind.annotation.RequestMapping;

- error: cannot find symbol @GetMapping
+ import org.springframework.web.bind.annotation.GetMapping;

- error: cannot find symbol ArrayList
+ import java.util.ArrayList;
```

6. 发生上述错误的原因是没有自动 import，其中原因应该是 vscode 没有自动 import 功能。

7. 访问 http://localhost:8080/api/v1/books，成功.

- 详细可以查看 `1-001.png`
