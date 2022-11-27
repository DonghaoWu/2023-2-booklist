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
