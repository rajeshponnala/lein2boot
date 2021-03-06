# lein2boot

This is a sample project that demonstrates how to achieve the same development and build process in leiningen and boot.
There is a blog post about it [here](http://blog.michielborkent.nl/blog/2015/06/06/from-leiningen-to-boot/).

Both project configurations support:

- code reloading on the server (Clojure) and on the client (ClojureScript)
- building production ClojureScript
- packaging the application as a standalone jar

## Leiningen

### Developing

In a terminal, start the web server:

    lein repl
    (start-server)

In another terminal, start figwheel:

    lein clean && lein figwheel dev

Browse to
[http://localhost:8080/index.html](http://localhost:8080/index.html).

### Building production ClojureScript

    lein clean && lein cljsbuild once prod

### Package as uberjar

    lein clean
    lein cljsbuild once prod
    lein uberjar

or just

    lein build

Run with `java -jar target/animals-1.0.0-standalone.jar [<port>]`

## Boot

### Developing

In a terminal:

    boot dev

Browse to
[http://localhost:3000/index.html](http://localhost:3000/index.html).

### Building production ClojureScript

    boot build-cljs

### Package as uberjar

    boot build

Run with `java -jar target/animals-1.0.0.jar [<port>]`

## Credits

Thanks to

- [Alan Dipert](https://github.com/alandipert) for general help and fixing [issue 210](https://github.com/boot-clj/boot/issues/210) of [boot-clj](http://boot-clj.com/). 
- [Martin Klepsch](https://github.com/martinklepsch) for general help

## License

Copyright Michiel Borkent

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
