1. CICD

- After that we deploy to staging and production. For every change we need to perform all these steps manually. There are chances that people can mistake or skip certain steps just to deliver their changes. For overcomming these issues we need to automate all these manual steps.

- The process to automate all these is `CICD`.

- `What steps?`

  - Build the project with new functionality
  - run Unit test cases, integration test cases
  - run Sonarqube for code quality
  - run smoke test (functional test cases)

2. Travis CI

- Travis CI is a hosted continuous integreation service where we are using for CICD. It is very easily integrated with github.

3. add new file

- location: `/bookStore/.travis.yml`

```bash
$ javac -version
```

```yml
language: java
jdk:
  - openjdk8
```

- url: travis-ci.org => sign up with github => right top icon => sync account => select a plan => input payment info => turn the repo on

```bash
$ git add .
$ git commit -m'add travis'
$ git push
```

- Travis will be triggered when you make a push.

4. what is JDK?

- The Java development kit (JDK) contains tools for `Java development`, and the `Java Runtime Environment (JRE)` contains a JVM to convert byte code .class to machine code, and execute it, in short, the JRE runs Java program.

5. Heroku (`CD`)

- login your heroku account
- click on new
- name your app
- book-store-demo-2022
- download heroku cli
- heroku commands

```bash
$ heroku login
$ heroku auth:token
```

- go to travis CI => dsahboard => more options => Environment Variables => HEROKU_TOKEN & token => Add

- `travis.yml` 

```yml
language: java
jdk:
  - openjdk8

deploy:
  provider: heroku
  api_key: $HEROKU_TOKEN
  app: "book-store-demo-2022"
```

```bash
$ git add .
$ git commit -m'added heroku configuration into .travis.yml'
$ git push
```

- after travis finishes their job, go to 

- `book-store-demo-2022.herokuapp.com/api/v1/books`

6. make a change in code part

- src/main/java/com/weCode/bookStore/controller/BookController.java

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
                  .title("My First book title!")
                  .build();

    BookDto bookSecond = BookDto.builder()
                  .title("My Second book title!")
                  .build();
    List<BookDto> books = new ArrayList<>();
    books.add(book);
    return ResponseEntity.ok(books);
  }
}
```

```bash
$ git add .
$ git commit -m'added second book to test CI/CD.'
$ git push
```


7. travis heroku error:

- Skipping a deployment with the heroku provider because this branch is not permitted: main

- ERROR:  Error installing dpl-heroku:
	The last version of faraday-net_http (>= 2.0, < 3.1) to support your Ruby & RubyGems was 2.1.0. Try installing it with `gem install faraday-net_http -v 2.1.0` and then running the current command again

- Error: Missing required flag: -a, --app APP

- keep track of the heroku error

```BASH
$ 
```